package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class CombustibleBlockNamedItem extends ItemNameBlockItem implements IItemExtension
{

    public CombustibleBlockNamedItem(Block blockIn, Properties properties)
    {
        super(blockIn, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
    {
        if (itemStack.getItem() == ModItems.ash_seeds.get()) {
            return 25;
        }
        return -1;
    }

    
} // end-class
