package mod.akkamaddi.ashenwheat.world;

import mod.akkamaddi.ashenwheat.init.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BlazeTreeGrower extends AbstractTreeGrower
{

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive)
    {
        return ModFeatures.BLAZE_TREE.getHolder().get();
    }

} // end class
