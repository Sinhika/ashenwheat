package akkamaddi.ashenwheat.handler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
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
    	
        if (event.getBlock().getBlock() == Content.ashWheatCrop)
        {
        	int l = event.getBlock().getBlock().getMetaFromState(event.getBlock());
            l += MathHelper.getRandomIntegerInRange(event.getWorld().rand, 0, 2);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }
            state = event.getBlock().getBlock().getStateFromMeta(l);
            event.getWorld().setBlockState(event.getPos(), state, 2);
            event.setResult(Result.ALLOW);
        } // end if ashWheatCrop

        if (event.getBlock().getBlock() == Content.scintillaWheatCrop)
        {
        	int l = event.getBlock().getBlock().getMetaFromState(event.getBlock());
            l += MathHelper.getRandomIntegerInRange(event.getWorld().rand, 0, 1);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }

            state = event.getBlock().getBlock().getStateFromMeta(l);
            event.getWorld().setBlockState(event.getPos(), state, 2);
            event.setResult(Result.ALLOW);
        } // end if scintillaWheatCrop
        
        if (event.getBlock().getBlock() == Content.ossidRootCrop)
        {
        	int l = event.getBlock().getBlock().getMetaFromState(event.getBlock());
            l += MathHelper.getRandomIntegerInRange(event.getWorld().rand, 0, 1);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }

            state = event.getBlock().getBlock().getStateFromMeta(l);
            event.getWorld().setBlockState(event.getPos(), state, 2);
            event.setResult(Result.ALLOW);
        } // end if ossidRootCrop

        if (event.getBlock().getBlock() == Content.thunderGrassCrop)
        {
        	int l = event.getBlock().getBlock().getMetaFromState(event.getBlock());
            l += MathHelper.getRandomIntegerInRange(event.getWorld().rand, 0, 1);

            if (l < 7)
            {
                ++l;
            }
            if (l > 7) { 
            	l = 7;
            }
            state = event.getBlock().getBlock().getStateFromMeta(l);
            event.getWorld().setBlockState(event.getPos(), state, 2);
            event.setResult(Result.ALLOW);
        } // end if thunderGrassCrop
        
    } // end onUseBonemeal()
    
} // end class AshyBonemeal
