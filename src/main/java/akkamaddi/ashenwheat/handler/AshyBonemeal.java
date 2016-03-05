package akkamaddi.ashenwheat.handler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import akkamaddi.ashenwheat.Content;

public class AshyBonemeal
{
    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
    	IBlockState state;
    	
        if (event.block.getBlock() == Content.ashWheatCrop)
        {
        	int l = event.block.getBlock().getMetaFromState(event.block);
            l += MathHelper.getRandomIntegerInRange(event.world.rand, 0, 2);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }
            state = event.block.getBlock().getStateFromMeta(l);
            event.world.setBlockState(event.pos, state, 2);
            event.setResult(Result.ALLOW);
        } // end if ashWheatCrop

        if (event.block.getBlock() == Content.scintillaWheatCrop)
        {
        	int l = event.block.getBlock().getMetaFromState(event.block);
            l += MathHelper.getRandomIntegerInRange(event.world.rand, 0, 1);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }

            state = event.block.getBlock().getStateFromMeta(l);
            event.world.setBlockState(event.pos, state, 2);
            event.setResult(Result.ALLOW);
        } // end if scintillaWheatCrop
        
        if (event.block.getBlock() == Content.ossidRootCrop)
        {
        	int l = event.block.getBlock().getMetaFromState(event.block);
            l += MathHelper.getRandomIntegerInRange(event.world.rand, 0, 1);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }

            state = event.block.getBlock().getStateFromMeta(l);
            event.world.setBlockState(event.pos, state, 2);
            event.setResult(Result.ALLOW);
        } // end if ossidRootCrop

        if (event.block.getBlock() == Content.thunderGrassCrop)
        {
        	int l = event.block.getBlock().getMetaFromState(event.block);
            l += MathHelper.getRandomIntegerInRange(event.world.rand, 0, 1);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }
            state = event.block.getBlock().getStateFromMeta(l);
            event.world.setBlockState(event.pos, state, 2);
            event.setResult(Result.ALLOW);
        } // end if thunderGrassCrop
        
    } // end onUseBonemeal()
    
} // end class AshyBonemeal
