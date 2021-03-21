package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

import net.minecraft.item.Item.Properties;

public class CombustibleBlockItem extends BlockItem implements IForgeItem
{

    public CombustibleBlockItem(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        if (itemStack.getItem() == ModItems.ash_wheat_bale.get())
        {
            return 2400;
        }
        
        return super.getBurnTime(itemStack);
    } // end getBurnTime

    
} // end-class
