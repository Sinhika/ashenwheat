package akkamaddi.ashenwheat.handler;

import akkamaddi.ashenwheat.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class AshenwheatFuel
{
	@SubscribeEvent
    public void setBurnTimes(FurnaceFuelBurnTimeEvent event)
    {
        if (event.getItemStack().isItemEqual(new ItemStack(ModBlocks.ashWheatBale)))
        {
        	event.setBurnTime(2400);
        }
    }
} // end class
