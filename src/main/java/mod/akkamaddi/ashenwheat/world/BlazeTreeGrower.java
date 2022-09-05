package mod.akkamaddi.ashenwheat.world;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;

public class BlazeTreeGrower extends AbstractTreeGrower
{

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive)
    {
        return ServerLifecycleHooks.getCurrentServer().registryAccess().registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY)
                .getOrCreateHolderOrThrow(ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY,
                        new ResourceLocation(Ashenwheat.MODID, "blaze_tree")));
    }

} // end class
