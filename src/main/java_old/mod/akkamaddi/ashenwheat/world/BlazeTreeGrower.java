package mod.akkamaddi.ashenwheat.world;

import mod.akkamaddi.ashenwheat.init.ModFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BlazeTreeGrower extends AbstractTreeGrower
{

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive)
    {
        return ModFeatures.BLAZE_TREE;
    }

} // end class
