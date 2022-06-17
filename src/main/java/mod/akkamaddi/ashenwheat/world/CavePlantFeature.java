package mod.akkamaddi.ashenwheat.world;

import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.GlowLichenFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GlowLichenConfiguration;

public class CavePlantFeature extends GlowLichenFeature
{
    protected final BushBlock cavePlantBlock;
    
    public CavePlantFeature(Codec<GlowLichenConfiguration> p_159838_, BushBlock cpb)
    {
        super(p_159838_);
        this.cavePlantBlock = cpb;
     }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     * @param pContext A context object with a reference to the level and the position the feature is being placed at
     */
   @Override
   public boolean place(FeaturePlaceContext<GlowLichenConfiguration> pContext)
   {
       WorldGenLevel worldgenlevel = pContext.level();
       BlockPos blockpos = pContext.origin();
       Random random = pContext.random();
       GlowLichenConfiguration cave_config = pContext.config();
       if (!worldgenlevel.getBlockState(blockpos).isAir())
       {
           return false;
       } 
       else
       {
           List<Direction> list = getShuffledDirections(cave_config, random);
           if (placeCavePlantIfPossible(worldgenlevel, blockpos, worldgenlevel.getBlockState(blockpos),
                   cave_config, random, list))
           {
               return true;
           } 
           else
           {
               BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();

               for (Direction direction : list)
               {
                   blockpos$mutableblockpos.set(blockpos);
                   List<Direction> list1 = getShuffledDirectionsExcept(cave_config, random,
                           direction.getOpposite());

                   for (int i = 0; i < cave_config.searchRange; ++i)
                   {
                       blockpos$mutableblockpos.setWithOffset(blockpos, direction);
                       BlockState blockstate = worldgenlevel.getBlockState(blockpos$mutableblockpos);
                       if (!blockstate.isAir())
                       {
                           break;
                       }

                       if (placeCavePlantIfPossible(worldgenlevel, blockpos$mutableblockpos, blockstate,
                               cave_config, random, list1))
                       {
                           return true;
                       }
                   } // end-for i
               } // end-for direction
               return false;
           } // end-else
       } // end-else
   } // end place()
    
   public boolean placeCavePlantIfPossible(WorldGenLevel pLevel, BlockPos pPos, BlockState pState,
                       GlowLichenConfiguration pConfig, Random pRandom, List<Direction> pDirections)
   {
       BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();

       for (Direction direction : pDirections)
       {
           BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos.setWithOffset(pPos, direction));
           if (blockstate.is(pConfig.canBePlacedOn))
           {
               BlockState blockstate1 = cavePlantBlock.defaultBlockState()
                       .setValue(RottenPlantBlock.ROTTEN_AGE, RottenPlantBlock.ROTTEN_MAX_AGE);
               if (blockstate1 == null)
               {
                   return false;
               }

               pLevel.setBlock(pPos, blockstate1, 3);
               pLevel.getChunk(pPos).markPosForPostprocessing(pPos);
               // unlike GlowLichen, cave plants don't spread.
               return true;
           } // end-if
       } // end-for direction

       return false;
   } // end 

} // end class
