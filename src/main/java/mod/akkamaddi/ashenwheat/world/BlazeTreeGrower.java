package mod.akkamaddi.ashenwheat.world;

import mod.akkamaddi.ashenwheat.init.ModFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BlazeTreeGrower extends TreeGrower
{

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pFlowers)
    {
        return ModFeatures.BLAZE_TREE;
    }

} // end class
