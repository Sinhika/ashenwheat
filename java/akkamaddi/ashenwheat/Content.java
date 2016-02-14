package akkamaddi.ashenwheat;

import akkamaddi.ashenwheat.item.AshenWheatSheaf;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class Content 
{
	/**
	 * Loads all the Ashenwheat content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		try {
			doItems();
//			LogHelper.verboseInfo(ModInfo.ID,
//					"All items were added successfully");
		} 
		catch (Exception e) {
//			LogHelper.severe(ModInfo.ID,
//							"Items were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doBlocks();
//			LogHelper.verboseInfo(ModInfo.ID,
//					"All blocks were added successfully");
		} 
		catch (Exception e) {
//			LogHelper.severe(ModInfo.ID,
//							"Blocks were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize()

	public static void doItems()
	{
		ashWheatCrop = new AshWheatCrop();
		ashWheatSheaf = new AshenWheatSheaf().setCreativeTab(AshenWheatCore.tabAshenwheat);
		ashSeeds = new AshSeeds(ashWheatCrop, Blocks.farmland)
			.setCreativeTab(AshenWheatCore.tabAshenwheat);
		ashWheatBale = new AshWheatBale().setCreativeTab(AshenWheatCore.tabAshenwheat);
		
		ashBread = new AshBread(4, 0.5F, false).setCreativeTab(AshenWheatCore.tabAshenwheat);
		ashCookie = new AshCookie( 1, 0.1F, false).setCreativeTab(AshenWheatCore.tabAshenwheat);

		scintillaWheatCrop = new ScintillaWheatCrop();
		scintillaSeeds = new ScintillaSeeds(scintillaWheatCrop, Blocks.farmland)
			.setCreativeTab(AshenWheatCore.tabAshenwheat);
		scintillaWheatSheaf = new ScintillaWheatSheaf()
				.setCreativeTab(AshenWheatCore.tabAshenwheat);
		
		scintillaWheatBale = new ScintillaWheatBale().setCreativeTab(AshenWheatCore.tabAshenwheat);
		
		scintillaBread = new ScintillaBread( 4, 0.7F, false)
				.setCreativeTab(AshenWheatCore.tabAshenwheat);
		scintillaCookie = new ScintillaCookie( 1, 0.1F, false)
				.setCreativeTab(AshenWheatCore.tabAshenwheat);
		scintillatingAsh = new ScintillatingAsh()
				.setCreativeTab(AshenWheatCore.tabAshenwheat);

		ossidRoot = new OssidRoot(false).setCreativeTab(AshenWheatCore.tabAshenwheat);
		ossidRootCrop = new OssidRootCrop();
		ossidLantern = new OssidRoot(true).setBlockName("ossidLantern").setLightLevel(1.0F)
				.setCreativeTab(AshenWheatCore.tabAshenwheat);
		ossidSeeds = new OssidSeeds(ossidRootCrop,Blocks.farmland)
				.setCreativeTab(AshenWheatCore.tabAshenwheat);
		calcifiedAsh = new OssidAsh().setCreativeTab(AshenWheatCore.tabAshenwheat);

		thunderGrassCrop = new ThunderGrassCrop();
		thunderSeeds = new ThunderSeeds(thunderGrassCrop, Blocks.farmland)
				.setCreativeTab(AshenWheatCore.tabAshenwheat);
		unstableSoot = new UnstableSoot().setCreativeTab(AshenWheatCore.tabAshenwheat);        
        
        GameRegistry.registerItem(ashSeeds, "ashSeeds");
        GameRegistry.registerItem(ashWheatSheaf, "ashWheatSheaf");
        GameRegistry.registerItem(ashBread, "ashBread");
        GameRegistry.registerItem(ashCookie, "ashCookie");
        GameRegistry.registerBlock(ashWheatCrop, "ashWheatCrop");
        GameRegistry.registerBlock(ashWheatBale, "ashWheatBale");

        GameRegistry.registerItem(scintillaSeeds, "scintillaSeeds");
        GameRegistry.registerItem(scintillaWheatSheaf, "scintillaWheatSheaf");
        GameRegistry.registerItem(scintillaBread, "scintillaBread");
        GameRegistry.registerItem(scintillaCookie, "scintillaCookie");
        GameRegistry.registerItem(scintillatingAsh, "scintillatingAsh");
        GameRegistry.registerBlock(scintillaWheatCrop, "scintillaWheatCrop");
        GameRegistry.registerBlock(scintillaWheatBale, "scintillaWheatBale");
        
        GameRegistry.registerBlock(ossidRootCrop, "ossidVine");
        GameRegistry.registerBlock(ossidRoot, "ossidRoot");
        GameRegistry.registerBlock(ossidLantern, "ossidLantern");
        GameRegistry.registerItem(ossidSeeds, "ossidSeeds");
        GameRegistry.registerItem(calcifiedAsh, "calcifiedAsh");
        
        GameRegistry.registerBlock(thunderGrassCrop, "thundergrass");
        GameRegistry.registerItem(thunderSeeds, "thunderSeeds");
        GameRegistry.registerItem(unstableSoot, "unstableSoot");

	} // end doItems()
	
	public static void doBlocks()
	{
		
	} // end doBlocks();

    public static void setLoot()
    {
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ashSeeds),2,8,20));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(scintillaSeeds),2,4,10));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ossidSeeds),2,6,15));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(thunderSeeds),2,6,15));

        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(scintillaSeeds),4,8,16));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(scintillaWheatSheaf),2,4,6));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ashCookie),6,16,12));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(scintillaCookie),6,16,12));
        
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ashSeeds),2,6,10));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(scintillaSeeds),1,3,2));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ossidSeeds),2,4,5));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(thunderSeeds),2,4,5));
        
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ashWheatSheaf),2,4,5));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(scintillaWheatSheaf),1,3,2));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ashCookie),6,16,4));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(scintillaCookie),6,16,2));
        
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ashSeeds),2,6,15));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(scintillaSeeds),1,3,5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ossidSeeds),2,4,10));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(thunderSeeds),2,4,10));

        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ashSeeds),1,4,3));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(scintillaSeeds),1,2,1));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ossidSeeds),1,3,2));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(thunderSeeds),1,3,2));
    }
    
    public static Block ashWheatCrop;
    public static Block ashWheatBale;
    public static Item ashSeeds;
    public static Item ashWheatSheaf;
    public static Item ashBread;
    public static Item ashCookie;

    public static Block scintillaWheatCrop;
    public static Block scintillaWheatBale;
    public static Item scintillaSeeds;
    public static Item scintillaWheatSheaf;
    public static Item scintillaBread;
    public static Item scintillaCookie;
    public static Item scintillatingAsh;

    public static Block ossidRootCrop;
    public static Block ossidRoot;
    public static Block ossidLantern;
    public static Item ossidSeeds;
    public static Item calcifiedAsh;
    
    public static Block thunderGrassCrop;
    public static Item thunderSeeds;
    public static Item unstableSoot;
    
} // end class Content
