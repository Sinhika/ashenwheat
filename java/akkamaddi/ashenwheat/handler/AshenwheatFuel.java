package akkamaddi.ashenwheat.handler;

import akkamaddi.ashenwheat.AshenWheatCore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class AshenwheatFuel implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuelStack)
    {
    	Item fuel = fuelStack.getItem();
        if (fuel == AshenWheatCore.ashWheatSheaf)
        {
            return 100;
        }

        if (fuel == AshenWheatCore.ashBread)
        {
            return 600;
        }

        if (fuel == AshenWheatCore.ashCookie)
        {
            return 50;
        }

        if (fuel == AshenWheatCore.ashSeeds)
        {
            return 25;
        }

        if (fuelStack.isItemEqual(new ItemStack(AshenWheatCore.ashWheatBale)))
        {
            return 2400;
        }

        return 0;
    }
}
