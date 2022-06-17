package mod.akkamaddi.ashenwheat.world;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

public class EnderClamFeature extends Feature<CountConfiguration>
{

    public EnderClamFeature(Codec<CountConfiguration> pCodec)
    {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CountConfiguration> pContext)
    {
        int i = 0;
        Random random = pContext.random();
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        int j = pContext.config().count().sample(random);

        for(int k = 0; k < j; ++k) 
        {
           int l = random.nextInt(8) - random.nextInt(8);
           int i1 = random.nextInt(8) - random.nextInt(8);
           int j1 = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR, blockpos.getX() + l, blockpos.getZ() + i1);
           BlockPos blockpos1 = new BlockPos(blockpos.getX() + l, j1, blockpos.getZ() + i1);
           BlockState blockstate = ModBlocks.ender_clam.get().defaultBlockState();
           if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER)) 
           {
              worldgenlevel.setBlock(blockpos1, blockstate, 2);
              ++i;
           }
        } // end-for
        return i > 0;
    } // end place()
    
} // end class
