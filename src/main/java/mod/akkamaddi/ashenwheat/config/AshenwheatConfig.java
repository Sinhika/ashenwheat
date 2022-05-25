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
    
    public static int relWeightWheatSeeds = 10;
    public static int relWeightAshSeeds = 8;
    public static int relWeightScintillaSeeds = 3;
    public static int relWeightOssidSeeds = 5;
    public static int relWeightThunderSeeds = 4;

    public static float growthRateAshenWheat = 0.96F;  // compared to wheat = 1.0
    public static float growthRateScintillaWheat = 0.83F; 
    public static float growthRateOssidRoot = 0.89F;
    public static float growthRateThunderGrass = 0.5F; // but doesn't mind having neighbors...
    public static float neighborFactorThunderGrass = 5.0F; // wheat = 1.0F
    
    public static boolean EnablePeacefulPack;
    public static boolean GenerateBlazeTrees;
    public static boolean GenerateFlax;
    public static boolean GenerateRottenPlants;
    public static boolean GenerateEnderClams;
    public static boolean EnableSpiderEyeDrops;
    
} // end class
