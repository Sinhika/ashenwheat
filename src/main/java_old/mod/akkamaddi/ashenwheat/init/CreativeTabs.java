package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * This class holds all our ItemGroups (Formerly called CreativeTabs).
 * Static initialisers are fine here.
 *
 * @author Cadiboo
 */
public final class CreativeTabs
{
	// formerly MOD_ITEM_GROUP
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ashenwheat.MODID);
	
	public static final RegistryObject<CreativeModeTab> SIMPLECORE_TAB = CREATIVE_MODE_TABS.register("ashenwheat_tab",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("item_group." + Ashenwheat.MODID + ".ashenwheat_tab"))
				.icon(() -> new ItemStack(ModItems.ash_wheat_sheaf.get()))
				.displayItems((parameters, output) -> {
					output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
										.map(RegistryObject::get)
										.map(b -> (new ItemStack(b.asItem())))
										.toList()
										);
					output.acceptAll(ModItems.ITEMS.getEntries().stream()
							.map(RegistryObject::get)
							.map(b -> (new ItemStack(b)))
							.toList()
							);
				}).build());

} // end class ModItemGroups
