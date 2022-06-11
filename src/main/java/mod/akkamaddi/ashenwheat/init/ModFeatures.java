package mod.akkamaddi.ashenwheat.init;

import mod.alexndr.simplecorelib.SimpleCoreLib;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    /** ConfiguredFeature<?, ?> registry */
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SimpleCoreLib.MODID);
    
    public static RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> BLAZE_TREE = 
            CONFIGURED_FEATURES.register("blaze_tree", () -> new ConfiguredFeature<>(Feature.TREE, createBlazeTree().build()));
    
    
    private static TreeConfiguration.TreeConfigurationBuilder createBlazeTree()
    {
        return createStraightBlobTree(ModBlocks.blaze_log.get(), ModBlocks.blaze_leaves.get(), 4, 2, 0, 2).ignoreVines();
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
