package mod.akkamaddi.ashenwheat.world;

import com.mojang.serialization.Codec;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
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
        RandomSource random = pContext.random();
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
           BlockPos underpos = blockpos1.below();
           if (level.getBlockState(blockpos1).is(BlockTags.WOLVES_SPAWNABLE_ON)
                        && level.getBlockState(underpos).is(BlockTags.DIRT))
           {
               BlockPos adjpos = underpos.east();
               
               level.setBlock(underpos, blockstate, 2); 
               if (level.getBlockState(adjpos).is(BlockTags.DIRT))
               {
                   level.setBlock(adjpos, blockstate, 2);
               }
              ++ii;
           }
        } // end-for
        return ii > 0;
    } // end place.

    
} // end class
