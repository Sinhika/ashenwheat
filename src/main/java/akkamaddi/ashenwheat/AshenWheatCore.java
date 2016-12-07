package akkamaddi.ashenwheat;

import akkamaddi.ashenwheat.handler.AshenwheatFuel;
import mcjty.lib.compat.CompatCreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	dependencies=ModInfo.DEPENDENCIES, acceptedMinecraftVersions=ModInfo.ACCEPTED_VERSIONS,
	updateJSON="https://raw.githubusercontent.com/Sinhika/ashenwheat/1.11/update.json")

public class AshenWheatCore
{
    
    @SidedProxy(clientSide="akkamaddi.ashenwheat.ClientProxy", 
    			serverSide="akkamaddi.ashenwheat.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static AshenWheatCore instance;
    
    public static CompatCreativeTabs tabAshenwheat = new CompatCreativeTabs("tabAshenwheat") 
    {
 		@Override
		public Item getItem() {
			return Content.ashWheatSheaf;
		}
    };

     /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
   @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    } // end preinit()

   /**
    * Do your mod setup. Build whatever data structures you care about. 
    */
   @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        GameRegistry.registerFuelHandler(new AshenwheatFuel());
        proxy.load(event);
    } // end load()

   /**
    * Handle interaction with other mods, complete your setup based on this.
    */
   @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
	   proxy.postInit(event);
    } // end postInit()
} // end class AshenWheatCore
