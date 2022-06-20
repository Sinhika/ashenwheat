package mod.akkamaddi.ashenwheat.world;

import java.util.Random;

import com.mojang.serialization.Codec;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

public class ShallowGraveFeature extends Feature<CountConfiguration>
{

    public ShallowGraveFeature(Codec<CountConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CountConfiguration> pContext)
    {
        int ii = 0;
        Random random = pContext.random();
        WorldGenLevel level = pContext.level();
        BlockPos blockpos = pContext.origin();
        int jj = pContext.config().count().sample(random);

        for(int kk = 0; kk < jj; ++kk) 
        {
           int mm = random.nextInt(8) - random.nextInt(8);
           int i1 = random.nextInt(8) - random.nextInt(8);
           int j1 = level.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX() + mm, blockpos.getZ() + i1);
           BlockPos blockpos1 = new BlockPos(blockpos.getX() + mm, j1-1, blockpos.getZ() + i1);
           BlockState blockstate = ModBlocks.buried_remains.get().defaultBlockState();
           // TODO check underpos for dirt.
           BlockPos underpos = blockpos1.below();
           if (level.getBlockState(blockpos1).is(Blocks.GRASS_BLOCK))// && bstate_down.is(BlockTags.DIRT)) 
           {
               BlockPos adjpos = blockpos1.east();  // TODO change to underpos.below()
               
               level.setBlock(blockpos1, blockstate, 2);  // TODO change to underpos
               if (level.getBlockState(adjpos).is(Blocks.GRASS_BLOCK))  // TODO change to dirt check
               {
                   level.setBlock(adjpos, blockstate, 2);
               }
              ++ii;
           }
        } // end-for
        return ii > 0;
    } // end place.

    
} // end class
