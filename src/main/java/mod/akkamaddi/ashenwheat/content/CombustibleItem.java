package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class CombustibleItem extends Item implements IForgeItem
{

    public CombustibleItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        if (itemStack.getItem() == ModItems.ash_wheat_sheaf.get())
        {
            return 100;
        }
        
        return super.getBurnTime(itemStack);
    } // end getBurnTime

    
} // end-class
