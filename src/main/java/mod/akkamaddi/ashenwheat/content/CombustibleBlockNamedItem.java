package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.common.extensions.IForgeItem;

public class CombustibleBlockNamedItem extends BlockNamedItem implements IForgeItem
{

    public CombustibleBlockNamedItem(Block blockIn, Properties properties)
    {
        super(blockIn, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        if (itemStack.getItem() == ModItems.ash_seeds.get()) {
            return 25;
        }
        return -1;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType)
    {
        return this.getBurnTime(itemStack);
    }

    
} // end-class
