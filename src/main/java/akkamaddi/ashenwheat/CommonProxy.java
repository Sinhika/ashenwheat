package akkamaddi.ashenwheat;

import akkamaddi.ashenwheat.handler.ConfigHandler;
import akkamaddi.ashenwheat.handler.LootHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.preInit(event);
 	} // end preInit()
	
    public void load(FMLInitializationEvent event)
    {
        if (ConfigHandler.dropAsh) {
        	MinecraftForge.addGrassSeed(new ItemStack(ModItems.ashSeeds), 8);
        }

        if (ConfigHandler.dropScintilla) {
        	MinecraftForge.addGrassSeed(new ItemStack(ModItems.scintillaSeeds), 3);
        }
        
        if (ConfigHandler.dropOssid) {
        	MinecraftForge.addGrassSeed(new ItemStack(ModItems.ossidSeeds), 5);
        }
        
        if (ConfigHandler.dropThunder) { 
        	MinecraftForge.addGrassSeed(new ItemStack(ModItems.thunderSeeds), 4); 
        }
        
        if (ConfigHandler.seedsInChests)
        {
            MinecraftForge.EVENT_BUS.register(new LootHandler());
        }
        
        AshenRecipes.doAshenRecipes();
    } // end load()
    
    public void postInit(FMLPostInitializationEvent event)
    {
    } // end postInit()    
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) 
    {
    	ModBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
    {
    	ModItems.register(event.getRegistry());
    	ModBlocks.registerItemBlocks(event.getRegistry());
        ModItems.registerOreDictionary();
    }   
    
    public void registerItemRenderer(Item item, int meta, String id) {
    }
} // end class
