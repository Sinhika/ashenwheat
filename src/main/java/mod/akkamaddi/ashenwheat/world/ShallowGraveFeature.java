package mod.akkamaddi.ashenwheat.world;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.ReplaceBlockFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;

public class ShallowGraveFeature extends ReplaceBlockFeature
{

    public ShallowGraveFeature(Codec<ReplaceBlockConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ReplaceBlockConfiguration> pContext)
    {
        WorldGenLevel level = pContext.level();
        BlockPos blockpos = pContext.origin();
        ReplaceBlockConfiguration replaceblockconfiguration = pContext.config();
        Random rand = pContext.random();
        
        for (int ii=0; ii < 32; ii++)
        {
            int jj = (blockpos.getX() + rand.nextInt(6)) - rand.nextInt(6); 
            int kk = (blockpos.getY() + rand.nextInt(4)) - rand.nextInt(4); 
            int mm = (blockpos.getZ() + rand.nextInt(6)) - rand.nextInt(6); 
            BlockPos bpos_target = new BlockPos(jj, kk, mm);
            BlockState bstate = level.getBlockState(bpos_target);
            BlockState bstate_up = level.getBlockState(new BlockPos(jj, kk+1, mm));
         
            for(OreConfiguration.TargetBlockState targetState : replaceblockconfiguration.targetStates)
            {
                if (targetState.target.test(bstate, rand) && bstate_up.getBlock() == Blocks.GRASS_BLOCK) 
                {
                    level.setBlock(bpos_target, targetState.state, 2);
                    break;
                }
            } // end-for
            
        } // end-for
        return true;
    } // end place.

    
} // end class
