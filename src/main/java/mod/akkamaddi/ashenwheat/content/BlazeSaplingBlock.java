package mod.akkamaddi.ashenwheat.content;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.PlantType;

public class BlazeSaplingBlock extends SaplingBlock
{

    public BlazeSaplingBlock(TreeGrower pTreeGrower, Properties pProperties)
    {
        super(pTreeGrower, pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos)
    {
        return pState.is(Blocks.NETHERRACK) || pState.is(net.neoforged.neoforge.common.Tags.Blocks.ORES_IN_GROUND_NETHERRACK);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        // TODO Auto-generated method stub
        return super.canSurvive(pState, pLevel, pPos);
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos)
    {
        return PlantType.NETHER;
    }

    
} // end class
