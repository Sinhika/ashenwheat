package akkamaddi.ashenwheat.handler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.Content;

public class AshenwheatFuel implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuelStack)
    {
    	Item fuel = fuelStack.getItem();
        if (fuel == Content.ashWheatSheaf)
        {
            return 100;
        }

        if (fuel == Content.ashBread)
        {
            return 600;
        }

        if (fuel == Content.ashCookie)
        {
            return 50;
        }

        if (fuel == Content.ashSeeds)
        {
            return 25;
        }

        if (fuelStack.isItemEqual(new ItemStack(Content.ashWheatBale)))
        {
            return 2400;
        }

        return 0;
    }
}
