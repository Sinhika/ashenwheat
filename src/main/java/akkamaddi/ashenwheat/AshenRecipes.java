package akkamaddi.ashenwheat;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AshenRecipes 
{
	public static void doAshenRecipes() 
	{

//		// recipes
//		GameRegistry.addRecipe(new ItemStack(ModItems.ashWheatBale, 1),
//				new Object[] { "AAA", "AAA", "AAA", 'A',
//			ModItems.ashWheatSheaf });
//		GameRegistry.addRecipe(new ItemStack(ModItems.ashCookie, 8),
//				new Object[] { "WCW", 'W', ModItems.ashWheatSheaf, 'C',
//						new ItemStack(Items.DYE, 1, 3) });
//
//		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ashSeeds,
//				2), new Object[] { ModItems.ashWheatSheaf });
//		GameRegistry.addShapelessRecipe(new ItemStack(
//				ModItems.ashWheatSheaf, 9),
//				new Object[] { ModItems.ashWheatBale });
//
//		GameRegistry.addRecipe(new ItemStack(ModItems.scintillaWheatBale,
//				1), new Object[] { "AAA", "AAA", "AAA", 'A',
//			ModItems.scintillaWheatSheaf });
//		GameRegistry.addRecipe(
//				new ItemStack(ModItems.scintillaCookie, 8), new Object[] {
//						"WCW", 'W', ModItems.scintillaWheatSheaf, 'C',
//						new ItemStack(Items.DYE, 1, 3) });
//
//		GameRegistry.addShapelessRecipe(new ItemStack(
//				ModItems.scintillaSeeds, 2),
//				new Object[] { ModItems.scintillaWheatSheaf });
//		GameRegistry.addShapelessRecipe(new ItemStack(
//				ModItems.scintillaWheatSheaf, 9),
//				new Object[] { ModItems.scintillaWheatBale });
//
//		GameRegistry.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 1), new Object[] {
//				"AA", "AA", 'A', ModItems.scintillatingAsh });
//
//		GameRegistry.addRecipe(new ItemStack(ModItems.ossidLantern, 1),
//				new Object[] { "A", "T", 'A', ModItems.ossidRoot, 'T', Blocks.TORCH });
//
//		GameRegistry.addShapelessRecipe(new ItemStack(
//				ModItems.ossidSeeds, 4),
//				new Object[] { ModItems.ossidRoot });
//		GameRegistry.addRecipe(new ItemStack(Items.DYE, 1, 15),
//				new Object[] { "AA", "AA", 'A', ModItems.calcifiedAsh });
//
//		GameRegistry.addRecipe(new ItemStack(Items.GUNPOWDER, 1), new Object[] {
//				"AAA", "AAA", "AAA", 'A', ModItems.unstableSoot });

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
