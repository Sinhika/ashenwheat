package mod.akkamaddi.ashenwheat.init;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * This class holds all our ItemGroups (Formerly called CreativeTabs).
 * Static initialisers are fine here.
 *
 * @author Cadiboo
 */
public final class ModItemGroups
{
    public static final CreativeModeTab MOD_ITEM_GROUP = 
            new ModItemGroup(Ashenwheat.MODID, () -> new ItemStack(ModItems.ash_wheat_sheaf.get()));
   
    public static final class ModItemGroup extends CreativeModeTab 
    {
        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) 
        {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return iconSupplier.get();
        }

    } // end class ModItemGroups$ModItemGroup

} // end class ModItemGroups
