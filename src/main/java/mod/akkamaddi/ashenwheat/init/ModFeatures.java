package mod.akkamaddi.ashenwheat.init;

import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.world.NetherTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Ashenwheat.MODID);
    
    // equivalent of a TreeFeature entry.
    public static RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> BLAZE_TREE = 
            CONFIGURED_FEATURES.register("blaze_tree", () -> new ConfiguredFeature<>(Feature.TREE, createBlazeTree().build()));
    
           
    /** PlacedFeature registry */
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
                             List.of( CountOnEveryLayerPlacement.of(4))));

    
     /** STATIC HELPER METHODS **/
    /**
     * Factory function that supplies a PlacedFeature for a RegistryObject.
     * @param cf
     * @param placements
     * @return
     */
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
