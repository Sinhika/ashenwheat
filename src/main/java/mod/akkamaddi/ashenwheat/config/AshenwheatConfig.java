package mod.akkamaddi.ashenwheat.config;

import mod.alexndr.simplecorelib.api.config.SimpleConfig;

/**
 * This holds the baked (runtime) values for our config.
 * These values should never be from changed outside this package.
 * This can be split into multiple classes (Server, Client, Player, Common)
 * but has been kept in one class for simplicity
 *
 * @author Cadiboo
 */
public final class AshenwheatConfig extends SimpleConfig
{
    public static AshenwheatConfig INSTANCE = new AshenwheatConfig();
    
	// Client
	public static boolean MakeAshenwheatFlame;
    public static boolean MakeAshenBalesFlame;
    public static boolean MakeScintillawheatScintillate;
    public static boolean MakeScintillaBalesScintillate;
    public static boolean MakeScintillationsSmaller;
    public static boolean MakeOssidCropGloom;
    public static boolean MakeOssidLanternGloom;
    public static boolean MakeThunderGrassSmoke;
    public static boolean MakeThunderGrassSmokeSmaller;

	// Server
	public static boolean SeedsInChests = true;
	
    public static boolean DropAshSeeds = true; 
    public static boolean DropScintillaSeeds = true;
    public static boolean DropOssidSeeds = true;
    public static boolean DropThunderSeeds = true;
    public static boolean DropRottenSeeds = false;
    public static boolean DropFlaxSeed = false;
    
    public static int relWeightWheatSeeds = 10;
    public static int relWeightAshSeeds = 8;
    public static int relWeightScintillaSeeds = 3;
    public static int relWeightOssidSeeds = 5;
    public static int relWeightThunderSeeds = 4;
    public static int relWeightFlaxSeeds = 4;
    public static int relWeightRottenSeed = 2;
    
    public static float growthRateAshenWheat = 0.96F;  // compared to wheat = 1.0
    public static float growthRateScintillaWheat = 0.83F; 
    public static float growthRateOssidRoot = 0.89F;
    public static float growthRateThunderGrass = 0.5F; // but doesn't mind having neighbors...
    public static float neighborFactorThunderGrass = 5.0F; // wheat = 1.0F
    
    public static boolean EnablePeacefulPack = false;
    public static boolean GenerateBlazeTrees = false;
    public static boolean GenerateFlax = false;
    public static boolean GenerateRottenPlants = false;
    public static boolean GenerateEnderClams = false;
    public static boolean GenerateBuriedRemains = false;
    public static boolean EnableSpiderEyeDrops = false;
    public static float SpiderEyeDropChance = 1.0F;
    
//    public static Lazy<ModOreConfig> buried_remains_cfg = 
//            Lazy.of( ()->new ModOreConfig(ModOreConfig.UNIFORM, 2, 
//                    100, true, 
//                    VerticalAnchor.absolute(10), 
//                    VerticalAnchor.absolute(128)));
} // end class
