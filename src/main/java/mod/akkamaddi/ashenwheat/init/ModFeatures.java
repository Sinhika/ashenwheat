package mod.akkamaddi.ashenwheat.init;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.akkamaddi.ashenwheat.world.NetherTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** CONFIGURED_FEATURES REGISTRY */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Ashenwheat.MODID);
    
    // TreeConfiguration - equivalent of a TreeFeatures entry.
    public static RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> BLAZE_TREE = 
            CONFIGURED_FEATURES.register("blaze_tree", () -> new ConfiguredFeature<>(Feature.TREE, createBlazeTree().build()));
    
    // RandomPatchConfiguration - equivalent of a VegetationFeatures entry.
    public static RegistryObject<ConfiguredFeature<RandomPatchConfiguration,?>> PATCH_FLAX =
            CONFIGURED_FEATURES.register("patch_flax", 
                    ()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, 
                            FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, 
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(
                                            ModBlocks.flax_crop.get().defaultBlockState().setValue(CropBlock.AGE, 
                                                                                            Integer.valueOf(CropBlock.MAX_AGE)))),
                                    List.of(Blocks.GRASS_BLOCK, Blocks.DIRT))));
    
    public static RegistryObject<ConfiguredFeature<RandomPatchConfiguration,?>> PATCH_ROTTEN_PLANT = 
            CONFIGURED_FEATURES.register("patch_rotten_plant",
                    ()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, 
                            FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, 
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(
                                            ModBlocks.rotten_crop.get().defaultBlockState().setValue(RottenPlantBlock.ROTTEN_AGE, 
                                                    Integer.valueOf(RottenPlantBlock.ROTTEN_MAX_AGE)))),
                                        ForgeRegistries.BLOCKS.tags().getTag(BlockTags.BASE_STONE_OVERWORLD).stream().toList())));
    

    /** PLACED_FEATURES REGISTRY */
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Ashenwheat.MODID);
    
    // PlacedTreeFeature.
     public static RegistryObject<PlacedFeature> BLAZE_TREE_CHECKED = 
            PLACED_FEATURES.register("blaze_tree_checked", 
                    ()->createPlacedTreeFeature(BLAZE_TREE.getHolder().get(), 
                                                List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.blaze_sapling.get()))));

     // equivalent of a VegetationFeatures or NetherFeatures entry.
     public static RegistryObject<ConfiguredFeature<RandomFeatureConfiguration, ?>> BLAZE_TREES = 
             CONFIGURED_FEATURES.register("blaze_trees", 
                    () -> new ConfiguredFeature<>( Feature.RANDOM_SELECTOR, 
                            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(BLAZE_TREE_CHECKED.getHolder().get(), 1.0F)), BLAZE_TREE_CHECKED.getHolder().get())));
     
     // equivalent of a VegetationPlacements or NetherPlacements entry.
     public static RegistryObject<PlacedFeature> TREES_BLAZEWOOD = 
             PLACED_FEATURES.register("trees_blazewood", 
                     ()->createPlacedVegetationFeature(BLAZE_TREES.getHolder().get(),
                             List.of(CountPlacement.of(30), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE)));
//                             List.of( CountOnEveryLayerPlacement.of(1))));

     public static RegistryObject<PlacedFeature> PATCH_FLAX_COMMON = 
             PLACED_FEATURES.register("patch_flax_common", 
                     ()->createPlacedPatchFeature(PATCH_FLAX.getHolder().get(), 
                             List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), 
                                         PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
                     
     public static RegistryObject<PlacedFeature> PATCH_ROTTEN_PLANT_NORMAL = 
             PLACED_FEATURES.register("patch_rotten_plant_normal",
                     ()->createPlacedPatchFeature(PATCH_ROTTEN_PLANT.getHolder().get(),
                             getCaveGrowthPlacement(256, (PlacementModifier) null)));
             
     
     /** STATIC HELPER METHODS **/
    /**
     * Factory function that supplies a PlacedFeature for a RegistryObject.
     * @param cf
     * @param placements
     * @return
     */
    public static PlacedFeature createPlacedPatchFeature( Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> cf, 
            List<PlacementModifier> pMod)
    {
        return new PlacedFeature(Holder.hackyErase(cf), List.copyOf(pMod));
    }

    public static PlacedFeature createPlacedTreeFeature( Holder<ConfiguredFeature<TreeConfiguration, ?>> cf, 
            List<PlacementModifier> pMod)
    {
        return new PlacedFeature(Holder.hackyErase(cf), List.copyOf(pMod));
    }

     public static PlacedFeature createPlacedVegetationFeature( Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> cf, 
             List<PlacementModifier> pMod)
     {
         return new PlacedFeature(Holder.hackyErase(cf), List.copyOf(pMod));
     }
    
     private static List<PlacementModifier> getCaveGrowthPlacement(int rarityFactor, @Nullable PlacementModifier placeMod)
     {
         Builder<PlacementModifier> builder = ImmutableList.builder();
         if (placeMod != null)
         {
             builder.add(placeMod);
         }

         if (rarityFactor != 0)
         {
             builder.add(RarityFilter.onAverageOnceEvery(rarityFactor));
         }

         builder.add(InSquarePlacement.spread());
         builder.add(PlacementUtils.HEIGHTMAP);
         return builder.build();
     } // end getCaveGrowthPlacement()
     
    private static TreeConfiguration.TreeConfigurationBuilder createBlazeTree()
    {
        return ModFeatures.createStraightBlobTree(ModBlocks.blaze_log.get(), ModBlocks.blaze_leaves.get(), 4, 2, 0, 2).ignoreVines();
    } // end createBlazeTree()
    
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block pLogBlock, Block pLeafBlock,
            int pBaseHeight, int pHeightRandA, int pHeightRandB, int pRadius)
    {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(pLogBlock),
                new NetherTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB), BlockStateProvider.simple(pLeafBlock),
                new BlobFoliagePlacer(ConstantInt.of(pRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }

} // end class
