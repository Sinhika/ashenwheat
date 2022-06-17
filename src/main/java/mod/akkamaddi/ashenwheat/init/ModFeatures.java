package mod.akkamaddi.ashenwheat.init;

import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.world.CavePlantFeature;
import mod.akkamaddi.ashenwheat.world.NetherTrunkPlacer;
import mod.alexndr.simplecorelib.api.helpers.OreGenUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GlowLichenConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceRelativeThresholdFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    
    /** FEATURES REGISTRY */
    public static final DeferredRegister<Feature<?>> MOD_FEATURES =
            DeferredRegister.create(Registry.FEATURE_REGISTRY, Ashenwheat.MODID);
            
    public static RegistryObject<Feature<GlowLichenConfiguration>> ROTTEN_PLANT_FEATURE =
            MOD_FEATURES.register("rotten_plant", ()->new CavePlantFeature(GlowLichenConfiguration.CODEC, ModBlocks.rotten_crop.get()));
                    
 
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
    
    
    public static RegistryObject<ConfiguredFeature<OreConfiguration, ?>> ORE_BURIED_REMAINS =
            CONFIGURED_FEATURES.register("ore_buried_remains", 
                    () -> OreGenUtils.createConfiguredOreFeature(
                            List.of(OreConfiguration.target(new TagMatchTest(BlockTags.DIRT), 
                                    ModBlocks.buried_remains.get().defaultBlockState())),
                            AshenwheatConfig.buried_remains_cfg));

    @SuppressWarnings("deprecation")
    public static RegistryObject<ConfiguredFeature<GlowLichenConfiguration,?>> PATCH_ROTTEN_PLANT = 
    CONFIGURED_FEATURES.register("patch_rotten_plant",
            ()->new ConfiguredFeature<>(ROTTEN_PLANT_FEATURE.get(),
                    new GlowLichenConfiguration(20, true, false, false, 1.0F, 
                                  HolderSet.direct(Block::builtInRegistryHolder, 
                                          List.of(Blocks.STONE, Blocks.DEEPSLATE, Blocks.DIORITE, Blocks.GRANITE, Blocks.ANDESITE,
                                                  Blocks.TUFF, Blocks.SMOOTH_BASALT)))));
                              //            ForgeRegistries.BLOCKS.tags().getTag(BlockTags.BASE_STONE_OVERWORLD).stream().toList()))));
    
//                    ()-> new ConfiguredFeature<>(Feature.RANDOM_PATCH, 
//                            FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, 
//                                    new SimpleBlockConfiguration(BlockStateProvider.simple(
//                                            ModBlocks.rotten_crop.get().defaultBlockState().setValue(RottenPlantBlock.ROTTEN_AGE, 
//                                                    Integer.valueOf(RottenPlantBlock.ROTTEN_MAX_AGE)))),
//                                        ForgeRegistries.BLOCKS.tags().getTag(BlockTags.BASE_STONE_OVERWORLD).stream().toList())));
    

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
                     ()->createPlacedCaveFeature(PATCH_ROTTEN_PLANT.getHolder().get(),
                             List.of(
                                     CountPlacement.of(UniformInt.of(104, 228)), 
                                     PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, 
                                     InSquarePlacement.spread(), 
                                     SurfaceRelativeThresholdFilter.of(Heightmap.Types.WORLD_SURFACE_WG, Integer.MIN_VALUE, -10)
                                     )));
             
     public static RegistryObject<PlacedFeature> BURIAL = 
             PLACED_FEATURES.register("burial", 
                     ()-> OreGenUtils.createPlacedOreFeature(ORE_BURIED_REMAINS.getHolder().get(), 
                             AshenwheatConfig.buried_remains_cfg));

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

    public static PlacedFeature createPlacedCaveFeature(Holder<ConfiguredFeature<GlowLichenConfiguration, ?>> cf,
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
