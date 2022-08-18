package mod.akkamaddi.ashenwheat.content;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlaxCropBlock extends ModCropsBlock
{

    public FlaxCropBlock(Properties builder)
    {
        super(builder);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos)
    {
        return pState.is(BlockTags.DIRT) || pState.is(Blocks.GRASS_BLOCK) || pState.is(Blocks.FARMLAND);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        BlockPos blockpos = pPos.below();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        if (this.mayPlaceOn(blockstate, pLevel, blockpos)) 
{
            return true;
        }
        return false;
    }

} // end class
