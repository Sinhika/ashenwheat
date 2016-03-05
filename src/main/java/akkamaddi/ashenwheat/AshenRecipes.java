package akkamaddi.ashenwheat;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class AshenRecipes {
	public static void doAshenRecipes() {
		// ore dictionary registrations
		OreDictionary.registerOre("cropAshenwheat", new ItemStack(
				Content.ashWheatSheaf));
		OreDictionary.registerOre("seedAshenwheat", new ItemStack(
				Content.ashSeeds));
		OreDictionary.registerOre("foodAshenBread", new ItemStack(
				Content.ashBread));
		OreDictionary.registerOre("foodAshenCookie", new ItemStack(
				Content.ashCookie));

		OreDictionary.registerOre("cropScintillawheat", new ItemStack(
				Content.scintillaWheatSheaf));
		OreDictionary.registerOre("seedScintillawheat", new ItemStack(
				Content.scintillaSeeds));
		OreDictionary.registerOre("foodScintillaBread", new ItemStack(
				Content.scintillaBread));
		OreDictionary.registerOre("foodScintillaCookie", new ItemStack(
				Content.scintillaCookie));

		OreDictionary.registerOre("cropOssidroot", new ItemStack(
				Content.ossidRoot));
		OreDictionary.registerOre("seedOssidroot", new ItemStack(
				Content.ossidSeeds));
		OreDictionary.registerOre("dustCalcifiedAsh", new ItemStack(
				Content.calcifiedAsh));
		OreDictionary.registerOre("dustAsh", new ItemStack(
				Content.calcifiedAsh));

		OreDictionary.registerOre("seedThundergrass", new ItemStack(
				Content.thunderSeeds));
		OreDictionary.registerOre("dustUnstableSoot", new ItemStack(
				Content.unstableSoot));

		// recipes
		GameRegistry.addRecipe(new ItemStack(Content.ashBread, 1),
				new Object[] { "AAA", 'A', Content.ashWheatSheaf });
		GameRegistry.addRecipe(new ItemStack(Content.ashWheatBale, 1),
				new Object[] { "AAA", "AAA", "AAA", 'A',
			Content.ashWheatSheaf });
		GameRegistry.addRecipe(new ItemStack(Content.ashCookie, 8),
				new Object[] { "WCW", 'W', Content.ashWheatSheaf, 'C',
						new ItemStack(Items.dye, 1, 3) });

		GameRegistry.addShapelessRecipe(new ItemStack(Content.ashSeeds,
				4), new Object[] { Content.ashWheatSheaf });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.ashWheatSheaf, 9),
				new Object[] { Content.ashWheatBale });

		GameRegistry
				.addRecipe(new ItemStack(Content.scintillaBread, 1),
						new Object[] { "AAA", 'A',
					Content.scintillaWheatSheaf });
		GameRegistry.addRecipe(new ItemStack(Content.scintillaWheatBale,
				1), new Object[] { "AAA", "AAA", "AAA", 'A',
			Content.scintillaWheatSheaf });
		GameRegistry.addRecipe(
				new ItemStack(Content.scintillaCookie, 8), new Object[] {
						"WCW", 'W', Content.scintillaWheatSheaf, 'C',
						new ItemStack(Items.dye, 1, 3) });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.scintillaSeeds, 4),
				new Object[] { Content.scintillaWheatSheaf });
		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.scintillaWheatSheaf, 9),
				new Object[] { Content.scintillaWheatBale });

		GameRegistry.addRecipe(new ItemStack(Items.glowstone_dust, 1), new Object[] {
				"AA", "AA", 'A', Content.scintillatingAsh });

		GameRegistry.addRecipe(new ItemStack(Content.ossidLantern, 1),
				new Object[] { "A", "T", 'A', Content.ossidRoot, 'T', Blocks.torch });

		GameRegistry.addShapelessRecipe(new ItemStack(
				Content.ossidSeeds, 4),
				new Object[] { Content.ossidRoot });
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 15),
				new Object[] { "AA", "AA", 'A', Content.calcifiedAsh });

		GameRegistry.addRecipe(new ItemStack(Items.gunpowder, 1), new Object[] {
				"AAA", "AAA", "AAA", 'A', Content.unstableSoot });

		// smelting
		GameRegistry.addSmelting(Content.ashBread, new ItemStack(
				Items.coal, 1, 1), 0.5F);
		GameRegistry.addSmelting(Content.scintillaWheatBale,
				new ItemStack(Content.scintillatingAsh), 0.5F);
		GameRegistry.addSmelting(Content.ossidRoot,
				new ItemStack(Content.calcifiedAsh), 0.4F);
		GameRegistry.addSmelting(Content.thunderSeeds,
				new ItemStack(Content.unstableSoot), 0.4F);

	} // end doAshenRecipes()
} // end class AshenRecipes
