package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
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
        else if (itemStack.getItem() == ModItems.ash_bread.get()) 
        {
            return 600;
        }
        else if (itemStack.getItem() == ModItems.ash_cookie.get()) 
        {
            return 50;
        }
        return -1;
    } // end getBurnTime

    @Override
    public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType)
    {
        return this.getBurnTime(itemStack);
    }

    
} // end-class
