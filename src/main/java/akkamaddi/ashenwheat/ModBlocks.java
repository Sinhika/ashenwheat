package akkamaddi.ashenwheat;

import akkamaddi.ashenwheat.block.AkkamaddiCrop;
import akkamaddi.ashenwheat.block.AshWheatBale;
import akkamaddi.ashenwheat.block.AshWheatCrop;
import akkamaddi.ashenwheat.block.BlockBaseHay;
import akkamaddi.ashenwheat.block.OssidRoot;
import akkamaddi.ashenwheat.block.OssidRootCrop;
import akkamaddi.ashenwheat.block.ScintillaWheatBale;
import akkamaddi.ashenwheat.block.ScintillaWheatCrop;
import akkamaddi.ashenwheat.block.ThunderGrassCrop;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
	// crop blocks
	public static AkkamaddiCrop ashWheatCrop = new AshWheatCrop();
	public static AkkamaddiCrop ossidRootCrop = new OssidRootCrop();
	public static AkkamaddiCrop scintillaWheatCrop = new ScintillaWheatCrop();
	public static AkkamaddiCrop thunderGrassCrop = new ThunderGrassCrop();

	// hay bale blocks
	public static BlockBaseHay ashWheatBale = 
			new AshWheatBale().setCreativeTab(AshenWheatCore.tabAshenwheat);
	public static BlockBaseHay scintillaWheatBale = 
			new ScintillaWheatBale().setCreativeTab(AshenWheatCore.tabAshenwheat);

	// Ossid roots & lanterns
	public static OssidRoot ossidRoot = 
			new OssidRoot(false).setCreativeTab(AshenWheatCore.tabAshenwheat);
	public static OssidRoot ossidLantern = 
			new OssidRoot(true).setCreativeTab(AshenWheatCore.tabAshenwheat);

	public static void register(IForgeRegistry<Block> registry) 
	{
		registry.registerAll(
				ashWheatCrop, ossidRootCrop, scintillaWheatCrop, thunderGrassCrop,
				ashWheatBale, scintillaWheatBale, ossidRoot, ossidLantern
				);
	} // end register()

	public static void registerItemBlocks(IForgeRegistry<Item> registry) 
	{
		// NB: crops do not have itemBlocks.
		registry.registerAll(
				ashWheatBale.createItemBlock(), scintillaWheatBale.createItemBlock(),
				ossidRoot.createItemBlock(), ossidLantern.createItemBlock()
				);
	} // end registerItemBlocks()

	public static void registerModels() 
	{
		// NB: crops do not have itemBlock models.
		ashWheatBale.registerItemModel(Item.getItemFromBlock(ashWheatBale));
		scintillaWheatBale.registerItemModel(Item.getItemFromBlock(scintillaWheatBale));
		ossidRoot.registerItemModel(Item.getItemFromBlock(ossidRoot));
		ossidLantern.registerItemModel(Item.getItemFromBlock(ossidLantern));
	} // end registerModels

} // end class
