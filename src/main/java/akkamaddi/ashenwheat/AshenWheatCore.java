package akkamaddi.ashenwheat;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import akkamaddi.ashenwheat.handler.AshenwheatFuel;
import akkamaddi.ashenwheat.handler.AshyBonemeal;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	dependencies=ModInfo.DEPENDENCIES, updateJSON="https://raw.githubusercontent.com/Sinhika/ashenwheat/master/update.json")

public class AshenWheatCore
{
    public static boolean MakeAshenwheatFlame;
    public static boolean MakeAshenBalesFlame;

    public static boolean MakeScintillawheatScintillate;
    public static boolean MakeScintillaBalesScintillate;
    
    public static boolean MakeOssidCropGloom;
    public static boolean MakeOssidLanternGloom;

    public static boolean MakeThunderGrassSmoke;
    
    public static boolean dropAsh;
    public static boolean dropScintilla;
    public static boolean dropOssid;
    public static boolean dropThunder;
    
    public static boolean seedsInChests;
    
    public static CreativeTabs tabAshenwheat = new CreativeTabs("tabAshenwheat") {
 		@Override
		public Item getTabIconItem() {
			return Content.ashWheatSheaf;
		}
    };

     /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry. Register recipes.
     */
   @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        File installDir = event.getModConfigurationDirectory();
        File configDir = new File(installDir, "akkamaddi");
        File configFile = new File(configDir, "ashenwheat.cfg");
        Configuration config = new Configuration(configFile);
        
        config.load();
         
        seedsInChests = config.get("xx Seeds in Chests", "Seeds appear in some chests, true or false", true).getBoolean(true);
        
        dropAsh = config.get("yy Wild Grass Drops", "Ashenwheat Seeds, false or true", true).getBoolean(true);
        dropScintilla = config.get("yy Wild Grass Drops", "Scintillawheat Seeds, false or true", true).getBoolean(true);
        dropOssid = config.get("yy Wild Grass Drops", "Ossidroot Seeds, false or true", true).getBoolean(true);
        dropThunder = config.get("yy Wild Grass Drops", "Thundergrass Seeds, false or true", true).getBoolean(true);
        
        MakeAshenwheatFlame = config.get("zz Boolean Configuration", "Flame particles on Ashenwheat crop, false or true", false).getBoolean(false);
        MakeAshenBalesFlame = config.get("zz Boolean Configuration", "Flame and smoke particles on Ashenwheat bales, false or true", false).getBoolean(false);

        MakeScintillawheatScintillate = config.get("zz Boolean Configuration", "Scintillating particles on Scintillawheat crop, false or true", false).getBoolean(false);
        MakeScintillaBalesScintillate = config.get("zz Boolean Configuration", "Scintillating particles on Scintillawheat bales, false or true", false).getBoolean(false);
        
        MakeOssidCropGloom = config.get("zz Boolean Configuration", "Gloom particles on Ossidroot crop, false or true", false).getBoolean(false);
        MakeOssidLanternGloom = config.get("zz Boolean Configuration", "Gloom particles on Ossid Lanterns, false or true", false).getBoolean(false);

        MakeThunderGrassSmoke = config.get("zz Boolean Configuration", "Smoke particles on Thundergrass crop, false or true", false).getBoolean(false);
        config.save();
        
        Content.preInitialize();
    } // end preinit()

   /**
    * Do your mod setup. Build whatever data structures you care about. 
    */
   @EventHandler
    public void load(FMLInitializationEvent event)
    {
        GameRegistry.registerFuelHandler(new AshenwheatFuel());
        MinecraftForge.EVENT_BUS.register(new AshyBonemeal());
       
        if (dropAsh) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.ashSeeds), 8);
        }

        if (dropScintilla) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.scintillaSeeds), 3);
        }
        
        if (dropOssid) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.ossidSeeds), 5);
        }
        
        if (dropThunder) { 
        	MinecraftForge.addGrassSeed(new ItemStack(Content.thunderSeeds), 4); 
        }
        
        if (seedsInChests)
        {
        	Content.setLoot();
        }
        
        if(event.getSide() == Side.CLIENT)
        {
        	Content.doItemRenderers();
        }
        
        AshenRecipes.doAshenRecipes();
        
    } // end load()

   /**
    * Handle interaction with other mods, complete your setup based on this.
    */
   @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    } // end postInit()
} // end class AshenWheatCore
