package akkamaddi.ashenwheat.code;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ashenwheat", name = "Ashenwheat", version = "1.7.10-1.1.0")

public class AshenWheatCore
{
    
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
			return AshenWheatCore.ashWheatSheaf;
		}
    };

    // The instance of your mod that Forge uses.
   @Instance(value = "ashenwheat")
   public static AshenWheatCore instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "akkamaddi.ashenwheat.code.ClientProxy", serverSide = "SimpleOres.plugins.ashenwheatc.CommonProxy")
    public static CommonProxy proxy;

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
		ossidRootCrop = new OssidRootCrop(ossidRoot);
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

        AshenRecipes.doAshenRecipes();
        
    } // end preinit()

   /**
    * Do your mod setup. Build whatever data structures you care about. 
    */
   @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
        GameRegistry.registerFuelHandler(new AshenwheatFuel());
        MinecraftForge.EVENT_BUS.register(new AshyBonemeal());
       
        if (dropAsh) {
        	MinecraftForge.addGrassSeed(new ItemStack(ashSeeds), 4);
        }

        if (dropScintilla) {
        	MinecraftForge.addGrassSeed(new ItemStack(scintillaSeeds), 1);
        }
        
        if (dropOssid) {
        	MinecraftForge.addGrassSeed(new ItemStack(ossidSeeds), 3);
        }
        
        if (dropThunder) { 
        	MinecraftForge.addGrassSeed(new ItemStack(thunderSeeds), 2); 
        }
        
        if (seedsInChests){
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashSeeds),2,8,20));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaSeeds),2,4,10));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ossidSeeds),2,6,15));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.thunderSeeds),2,6,15));

        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaSeeds),4,8,16));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaWheatSheaf),2,4,6));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashCookie),6,16,12));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaCookie),6,16,12));
        
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashSeeds),2,6,10));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaSeeds),1,3,2));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ossidSeeds),2,4,5));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.thunderSeeds),2,4,5));
        
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashWheatSheaf),2,4,5));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaWheatSheaf),1,3,2));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashCookie),6,16,4));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaCookie),6,16,2));
        
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashSeeds),2,6,15));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaSeeds),1,3,5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ossidSeeds),2,4,10));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.thunderSeeds),2,4,10));

        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ashSeeds),1,4,3));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.scintillaSeeds),1,2,1));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.ossidSeeds),1,3,2));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(AshenWheatCore.thunderSeeds),1,3,2));
        }
        
    } // end load()

   /**
    * Handle interaction with other mods, complete your setup based on this.
    */
   @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    } // end postInit()
} // end class AshenWheatCore
