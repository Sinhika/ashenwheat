package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class CombustibleBlockItem extends BlockItem implements IItemExtension
{

    public CombustibleBlockItem(Block blockIn, Properties builder)
    {
        super(blockIn, builder);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
    {
        if (itemStack.getItem() == ModItems.ash_wheat_bale.get())
        {
            return 2400;
        }
        
        return -1;
    }
    
} // end-class
