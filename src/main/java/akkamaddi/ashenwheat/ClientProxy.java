package akkamaddi.ashenwheat;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy 
{
    public void load(FMLInitializationEvent event)
    {
    	super.load(event);
    } // end load()
	
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) 
    {
    	ModItems.registerModels();
    	ModBlocks.registerModels();
    }
   
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
    	ModelLoader.setCustomModelResourceLocation(item, meta, 
    						new ModelResourceLocation(
    								new ResourceLocation(ModInfo.ID, id), "inventory"));
    } // end registerItemRenderer()
	
		
} // end class
