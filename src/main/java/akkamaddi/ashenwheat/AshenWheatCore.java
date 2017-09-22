package akkamaddi.ashenwheat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	dependencies=ModInfo.DEPENDENCIES, acceptedMinecraftVersions=ModInfo.ACCEPTED_VERSIONS,
	updateJSON=ModInfo.VERSIONURL)

public class AshenWheatCore
{
    @SidedProxy(clientSide="akkamaddi.ashenwheat.ClientProxy", 
    			serverSide="akkamaddi.ashenwheat.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static AshenWheatCore instance;
    
    public static CreativeTabs tabAshenwheat = new CreativeTabs("tabashenwheat") 
    {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.ashWheatSheaf);
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
    } // end preInit()

   /**
    * Do your mod setup. Build whatever data structures you care about. 
    */
   @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
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
