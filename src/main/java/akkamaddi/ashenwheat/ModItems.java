package akkamaddi.ashenwheat;

import akkamaddi.ashenwheat.item.ItemBase;
import akkamaddi.ashenwheat.item.ItemBaseFood;
import akkamaddi.ashenwheat.item.ItemBaseSeeds;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems 
{
	// Just Plain Items
    public static ItemBase unstableSoot = 
    		new ItemBase("unstablesoot").setCreativeTab(AshenWheatCore.tabAshenwheat);
    public static ItemBase calcifiedAsh = 
    		new ItemBase("calcifiedash").setCreativeTab(AshenWheatCore.tabAshenwheat);
	public static ItemBase ashWheatSheaf = 
			new ItemBase("ashwheatsheaf").setCreativeTab(AshenWheatCore.tabAshenwheat);
	public static ItemBase scintillaWheatSheaf = 
			new ItemBase("scintillawheatsheaf").setCreativeTab(AshenWheatCore.tabAshenwheat);
	public static ItemBase scintillatingAsh = 
			new ItemBase("scintillatingash").setCreativeTab(AshenWheatCore.tabAshenwheat);
	
	// Food Items
	public static ItemBaseFood ashBread = new ItemBaseFood("ashbread", 4, 0.5F, false);
	public static ItemBaseFood ashCookie = 
			(ItemBaseFood) new ItemBaseFood("ashcookie", 1, 0.1F, false)
						.setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2, 1), 1.0F);

	public static ItemBaseFood scintillaBread = new ItemBaseFood("scintillabread",4, 0.7F, false);
	public static ItemBaseFood scintillaCookie = 
			(ItemBaseFood) new ItemBaseFood("scintillacookie",1, 0.1F, false)
						.setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3, 1), 1.0F);

	// Seed Items
	public static ItemBaseSeeds ashSeeds = 
							new ItemBaseSeeds("ashseeds", ModBlocks.ashWheatCrop, Blocks.FARMLAND);
	public static ItemBaseSeeds ossidSeeds = 
						new ItemBaseSeeds("ossidseeds", ModBlocks.ossidRootCrop, Blocks.FARMLAND);
	public static ItemBaseSeeds scintillaSeeds = 
			new ItemBaseSeeds("scintillaseeds", ModBlocks.scintillaWheatCrop, Blocks.FARMLAND);
	public static ItemBaseSeeds thunderSeeds = 
			new ItemBaseSeeds("thunderseeds", ModBlocks.thunderGrassCrop, Blocks.FARMLAND);
	
	public static void register(IForgeRegistry<Item> registry) 
	{
		registry.registerAll(
				unstableSoot, calcifiedAsh, ashWheatSheaf, scintillaWheatSheaf, scintillatingAsh,
				ashBread, ashCookie, scintillaBread, scintillaCookie,
				ashSeeds, ossidSeeds, scintillaSeeds, thunderSeeds
				);
	} // end register()
	
	public static void registerModels() 
	{
		unstableSoot.registerItemModel();
		calcifiedAsh.registerItemModel();
		ashWheatSheaf.registerItemModel();
		scintillaWheatSheaf.registerItemModel();
		ashBread.registerItemModel();
		ashCookie.registerItemModel();
		scintillaBread.registerItemModel();
		scintillaCookie.registerItemModel();
		ashSeeds.registerItemModel();
		ossidSeeds.registerItemModel();
		scintillaSeeds.registerItemModel();
		thunderSeeds.registerItemModel();
	} // end registerModels()

} // end class
