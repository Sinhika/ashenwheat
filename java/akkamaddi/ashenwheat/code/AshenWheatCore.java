package akkamaddi.ashenwheat.code;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import akkamaddi.ashenwheat.code.MFR.fertilizables.FertilizableCropPlant;
import akkamaddi.ashenwheat.code.MFR.harvestables.HarvestableCropPlant;
import akkamaddi.ashenwheat.code.MFR.plantables.PlantableCropPlant;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	dependencies=ModInfo.DEPENDENCIES)

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
        
        dropAsh = config.get("yy Wild Grass Drops", "Ashenwheat Seeds, false or true", false).getBoolean(false);
        dropScintilla = config.get("yy Wild Grass Drops", "Scintillawheat Seeds, false or true", false).getBoolean(false);
        dropOssid = config.get("yy Wild Grass Drops", "Ossidroot Seeds, false or true", false).getBoolean(false);
        dropThunder = config.get("yy Wild Grass Drops", "Thundergrass Seeds, false or true", false).getBoolean(false);
        
        MakeAshenwheatFlame = config.get("zz Boolean Configuration", "Flame particles on Ashenwheat crop, false or true", false).getBoolean(false);
        MakeAshenBalesFlame = config.get("zz Boolean Configuration", "Flame and smoke particles on Ashenwheat bales, false or true", false).getBoolean(false);

        MakeScintillawheatScintillate = config.get("zz Boolean Configuration", "Scintillating particles on Scintillawheat crop, false or true", false).getBoolean(false);
        MakeScintillaBalesScintillate = config.get("zz Boolean Configuration", "Scintillating particles on Scintillawheat bales, false or true", false).getBoolean(false);
        
        MakeOssidCropGloom = config.get("zz Boolean Configuration", "Gloom particles on Ossidroot crop, false or true", false).getBoolean(false);
        MakeOssidLanternGloom = config.get("zz Boolean Configuration", "Gloom particles on Ossid Lanterns, false or true", false).getBoolean(false);

        MakeThunderGrassSmoke = config.get("zz Boolean Configuration", "Smoke particles on Thundergrass crop, false or true", false).getBoolean(false);
        config.save();
        
        AshenRecipes.doAshenRecipes();
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
        	MinecraftForge.addGrassSeed(new ItemStack(Content.ashSeeds), 4);
        }

        if (dropScintilla) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.scintillaSeeds), 1);
        }
        
        if (dropOssid) {
        	MinecraftForge.addGrassSeed(new ItemStack(Content.ossidSeeds), 3);
        }
        
        if (dropThunder) { 
        	MinecraftForge.addGrassSeed(new ItemStack(Content.thunderSeeds), 2); 
        }
        
        if (seedsInChests)
        {
        	Content.setLoot();
        }
        
    } // end load()

   /**
    * Handle interaction with other mods, complete your setup based on this.
    */
   @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		if (Loader.isModLoaded("MineFactoryReloaded")) {
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerPlantable",new PlantableCropPlant(Content.ashSeeds, Content.ashWheatCrop));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerPlantable", new PlantableCropPlant(Content.scintillaSeeds, Content.scintillaWheatCrop));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerPlantable", new PlantableCropPlant(Content.ossidSeeds, Content.ossidRootCrop));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerPlantable", new PlantableCropPlant(Content.thunderSeeds, Content.thunderGrassCrop));

			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerHarvestable", new HarvestableCropPlant(Content.ashWheatCrop, 7));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerHarvestable", new HarvestableCropPlant(Content.scintillaWheatCrop, 7));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerHarvestable", new HarvestableCropPlant(Content.ossidRootCrop, 7));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerHarvestable", new HarvestableCropPlant(Content.thunderGrassCrop, 7));

			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerFertilizable", new FertilizableCropPlant((IGrowable)Content.ashWheatCrop, 7));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerFertilizable", new FertilizableCropPlant((IGrowable)Content.scintillaWheatCrop, 7));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerFertilizable", new FertilizableCropPlant((IGrowable)Content.ossidRootCrop, 7));
			powercrystals.minefactoryreloaded.api.FactoryRegistry.sendMessage("registerFertilizable", new FertilizableCropPlant((IGrowable)Content.thunderGrassCrop, 7));
		}
    } // end postInit()
} // end class AshenWheatCore
