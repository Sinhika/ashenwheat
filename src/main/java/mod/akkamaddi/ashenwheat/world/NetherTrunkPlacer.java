package mod.akkamaddi.ashenwheat.world;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class NetherTrunkPlacer extends TrunkPlacer
{
    @SuppressWarnings("hiding")
    public static final Codec<NetherTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70261_) -> {
        return trunkPlacerParts(p_70261_).apply(p_70261_, NetherTrunkPlacer::new);
     });

    public NetherTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB)
    {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type()
    {
        return TrunkPlacerType.STRAIGHT_TRUNK_PLACER;
    }

    @Override
    public List<FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel,
            BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, int pFreeTreeHeight, BlockPos pPos,
            TreeConfiguration pConfig)
    {
        for(int i = 0; i < pFreeTreeHeight; ++i) 
        {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        }

         return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(pFreeTreeHeight), 0, false));
    } // end placeTrunk()

} // end class
