package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeItem;

public class CombustibleBlockNamedItem extends BlockNamedItem implements IForgeItem
{

    public CombustibleBlockNamedItem(Block blockIn, Properties properties)
    {
        super(blockIn, properties);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        if (itemStack.getItem() == ModItems.ash_seeds.get()) {
            return 25;
        }
        return super.getBurnTime(itemStack);
    }

    
} // end-class
