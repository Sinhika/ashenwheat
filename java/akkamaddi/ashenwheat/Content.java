package akkamaddi.ashenwheat;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import akkamaddi.ashenwheat.block.AshWheatBale;
import akkamaddi.ashenwheat.block.AshWheatCrop;
import akkamaddi.ashenwheat.block.OssidRoot;
import akkamaddi.ashenwheat.block.OssidRootCrop;
import akkamaddi.ashenwheat.block.ScintillaWheatBale;
import akkamaddi.ashenwheat.block.ScintillaWheatCrop;
import akkamaddi.ashenwheat.block.ThunderGrassCrop;
import akkamaddi.ashenwheat.item.AshBread;
import akkamaddi.ashenwheat.item.AshCookie;
import akkamaddi.ashenwheat.item.AshSeeds;
import akkamaddi.ashenwheat.item.AshenWheatSheaf;
import akkamaddi.ashenwheat.item.OssidAsh;
import akkamaddi.ashenwheat.item.OssidSeeds;
import akkamaddi.ashenwheat.item.ScintillaBread;
import akkamaddi.ashenwheat.item.ScintillaCookie;
import akkamaddi.ashenwheat.item.ScintillaSeeds;
import akkamaddi.ashenwheat.item.ScintillaWheatSheaf;
import akkamaddi.ashenwheat.item.ScintillatingAsh;
import akkamaddi.ashenwheat.item.ThunderSeeds;
import akkamaddi.ashenwheat.item.UnstableSoot;

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
		ashWheatSheaf = new AshenWheatSheaf();
		ashBread = new AshBread(4, 0.5F, false);
		ashCookie = new AshCookie( 1, 0.1F, false);

		scintillaWheatSheaf = new ScintillaWheatSheaf();
		scintillaBread = new ScintillaBread( 4, 0.7F, false);
		scintillaCookie = new ScintillaCookie( 1, 0.1F, false);
		scintillatingAsh = new ScintillatingAsh();

		calcifiedAsh = new OssidAsh();

		unstableSoot = new UnstableSoot();        
        
	} // end doItems()
	
	public static void doBlocks()
	{
		ashWheatBale = new AshWheatBale();
		ashWheatCrop = new AshWheatCrop();
		ashSeeds = new AshSeeds(ashWheatCrop, Blocks.farmland);
		
		scintillaWheatBale = new ScintillaWheatBale();
		scintillaWheatCrop = new ScintillaWheatCrop();
		scintillaSeeds = new ScintillaSeeds(scintillaWheatCrop, Blocks.farmland);
		
		ossidRoot = new OssidRoot(false);
		ossidLantern = new OssidRoot(true);
		ossidRootCrop = new OssidRootCrop();
		ossidSeeds = new OssidSeeds(ossidRootCrop,Blocks.farmland);
		
		thunderGrassCrop = new ThunderGrassCrop();
		thunderSeeds = new ThunderSeeds(thunderGrassCrop, Blocks.farmland);
	} // end doBlocks();

	
	public static void doItemRenderers()
	{
    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
    	renderItem.getItemModelMesher().register(Content.ashBread, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((AshBread) Content.ashBread).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.ashCookie, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((AshCookie) Content.ashCookie).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.ashWheatSheaf, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((AshenWheatSheaf) Content.ashWheatSheaf).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.ashSeeds, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((AshSeeds) Content.ashSeeds).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.ossidSeeds, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((OssidSeeds) Content.ossidSeeds).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.calcifiedAsh, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((OssidAsh) Content.calcifiedAsh).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.scintillaSeeds, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ScintillaSeeds) Content.scintillaSeeds).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.scintillaWheatSheaf, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ScintillaWheatSheaf) Content.scintillaWheatSheaf).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.scintillaBread, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ScintillaBread) Content.scintillaBread).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.scintillaCookie, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ScintillaCookie) Content.scintillaCookie).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.scintillatingAsh, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ScintillatingAsh) Content.scintillatingAsh).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.thunderSeeds, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ThunderSeeds) Content.thunderSeeds).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Content.unstableSoot, 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((UnstableSoot) Content.unstableSoot).getName(), 
    								      "inventory"));
		
    	// block items in inventory.
    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(Content.ashWheatBale), 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((AshWheatBale) Content.ashWheatBale).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(Content.scintillaWheatBale), 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((ScintillaWheatBale) Content.scintillaWheatBale).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(Content.ossidRoot), 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((OssidRoot) Content.ossidRoot).getName(), 
    								      "inventory"));
    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(Content.ossidLantern), 0, 
    			new ModelResourceLocation(ModInfo.ID + ":" + ((OssidRoot) Content.ossidLantern).getName(), 
    								      "inventory"));
   	
	} // end doItemRenderers()
	
		
	
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
