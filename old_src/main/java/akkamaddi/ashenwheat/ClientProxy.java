package akkamaddi.ashenwheat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import akkamaddi.ashenwheat.block.AshWheatBale;
import akkamaddi.ashenwheat.block.OssidRoot;
import akkamaddi.ashenwheat.block.ScintillaWheatBale;
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

public class ClientProxy extends CommonProxy 
{
    public void load(FMLInitializationEvent event)
    {
    	super.load(event);
    	if (event.getSide() == Side.CLIENT) {
    		doItemRenderers();
    	}
    } // end load()
	
	public void doItemRenderers()
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
	
		
} // end class
