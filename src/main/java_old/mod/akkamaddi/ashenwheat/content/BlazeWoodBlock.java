package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class BlazeWoodBlock extends RotatedPillarBlock
{

    public BlazeWoodBlock(Properties p_55926_)
    {
        super(p_55926_);
        // TODO Auto-generated constructor stub
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction,
            boolean simulate)
    {
        BlockState toolModifiedState;
        
        if (ToolActions.AXE_STRIP == toolAction) 
        {
            toolModifiedState = ModBlocks.stripped_blaze_wood.get().defaultBlockState()
                    .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
        }
        else {
            toolModifiedState = super.getToolModifiedState(state, context, toolAction, simulate);
        }
        return toolModifiedState;
    }

} // end class
