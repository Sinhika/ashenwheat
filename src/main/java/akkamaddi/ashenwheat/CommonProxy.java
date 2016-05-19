package akkamaddi.ashenwheat;

import akkamaddi.ashenwheat.handler.ConfigHandler;
import akkamaddi.ashenwheat.handler.LootHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.preInit(event);
        Content.preInitialize();
	} // end preInit()
	
    public void load(FMLInitializationEvent event)
    {
        if (ConfigHandler.dropAsh) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.ashSeeds), 8);
        }

        if (ConfigHandler.dropScintilla) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.scintillaSeeds), 3);
        }
        
        if (ConfigHandler.dropOssid) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.ossidSeeds), 5);
        }
        
        if (ConfigHandler.dropThunder) { 
        	MinecraftForge.addGrassSeed(new ItemStack(Content.thunderSeeds), 4); 
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
    
} // end class
