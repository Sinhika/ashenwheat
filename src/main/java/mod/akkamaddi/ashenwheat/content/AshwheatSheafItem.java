package mod.akkamaddi.ashenwheat.content;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class AshwheatSheafItem extends Item implements IForgeItem
{

    public AshwheatSheafItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return 100;
    }

    
} // end-class
