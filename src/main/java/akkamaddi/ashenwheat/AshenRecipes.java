package akkamaddi.ashenwheat;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AshenRecipes 
{
	public static void doAshenRecipes() 
	{
		// smelting
		GameRegistry.addSmelting(ModItems.ashBread, new ItemStack(
				Items.COAL, 1, 1), 0.5F);
		GameRegistry.addSmelting(ModBlocks.scintillaWheatBale,
				new ItemStack(ModItems.scintillatingAsh), 0.5F);
		GameRegistry.addSmelting(ModBlocks.ossidRoot,
				new ItemStack(ModItems.calcifiedAsh), 0.4F);
		GameRegistry.addSmelting(ModItems.thunderSeeds,
				new ItemStack(ModItems.unstableSoot), 0.4F);

	} // end doAshenRecipes()
} // end class AshenRecipes
