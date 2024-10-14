package mod.akkamaddi.ashenwheat.config;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

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
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue serverSeedsInChests;
    private static final ModConfigSpec.BooleanValue serverDropAshSeeds;
    private static final ModConfigSpec.BooleanValue serverDropScintillaSeeds;
    private static final ModConfigSpec.BooleanValue serverDropOssidSeeds;
    private static final ModConfigSpec.BooleanValue serverDropThunderSeeds;
    private static final ModConfigSpec.IntValue server_relWeightWheatSeeds;
    private static final ModConfigSpec.IntValue server_relWeightAshSeeds;
    private static final ModConfigSpec.IntValue server_relWeightScintillaSeeds;
    private static final ModConfigSpec.IntValue server_relWeightOssidSeeds;
    private static final ModConfigSpec.IntValue server_relWeightThunderSeeds;
    private static final ModConfigSpec.DoubleValue serverGrowthRateAshenWheat;
    private static final ModConfigSpec.DoubleValue serverGrowthRateScintillaWheat;
    private static final ModConfigSpec.DoubleValue serverGrowthRateOssidRoot;
    private static final ModConfigSpec.DoubleValue serverGrowthRateThunderGrass;
    private static final ModConfigSpec.DoubleValue serverNeighborFactorThunderGrass;

    private static final ModConfigSpec.BooleanValue serverDropFlaxSeed;
    private static final ModConfigSpec.IntValue server_relWeightFlaxSeeds;
    //private static final ModConfigSpec.BooleanValue serverEnableFlaxRecipes;

    private static final ModConfigSpec.BooleanValue serverDropRottenSeeds;
    private static final ModConfigSpec.IntValue server_relWeightRottenSeeds;
    private static final ModConfigSpec.BooleanValue serverEnableSpiderEyeDrops;
    private static final ModConfigSpec.DoubleValue serverSpiderEyeDropChance;


    static {
        BUILDER.push("General");
        serverSeedsInChests = BUILDER.comment("Should seeds appear in some chests?" )
                .translation(Ashenwheat.MODID + "config.seedsInChests")
                .define("seedsInChests", true);
        BUILDER.pop();

        // due to beta feedback, default to true for everything except 
        // Scintilla wheat, as by the time most people find chests, they
        // can already kill creepers & skeletons easily--eliminating the
        // early-game usefulness of Ossid Root & Thunder Grass. Ash wheat
        // is just another source of charcoal, so no need to make it rare
        // by default. Glowstone, on the other hand, should be rare pre-Nether.
        BUILDER.push("Wild Grass Drops");
        server_relWeightWheatSeeds = BUILDER.comment("Relative weight of wheat seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.relWeightWheatSeeds")
                .defineInRange("relWeightWheatSeeds", 10, 0, 100);

        serverDropAshSeeds = BUILDER.comment("Should ashenwheat seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropAsh")
                .define("DropAshSeeds", true);
        server_relWeightAshSeeds = BUILDER.comment("Relative weight of ashenwheat seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.relWeightAshSeeds")
                .defineInRange("relWeightAshSeeds", 8, 0, 100);

        serverDropScintillaSeeds = BUILDER.comment("Should scintilla wheat seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropScintilla")
                .define("DropScintillaSeeds", false);
        server_relWeightScintillaSeeds = BUILDER.comment("Relative weight of scintilla wheat seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.relWeightScintillaSeeds")
                .defineInRange("relWeightScintillaSeeds", 3, 0, 100);

        serverDropOssidSeeds = BUILDER.comment("Should ossidroot seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropOssid")
                .define("DropOssidSeeds", true);
        server_relWeightOssidSeeds = BUILDER.comment("Relative weight of ossidroot seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.relWeightOssidSeeds")
                .defineInRange("relWeightOssidSeeds", 5, 0, 100);

        serverDropThunderSeeds = BUILDER.comment("Should thundergrass seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropThunder")
                .define("DropThunderSeeds", true);
        server_relWeightThunderSeeds = BUILDER.comment("Relative weight of thundergrass seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.relWeightThunderSeeds")
                .defineInRange("relWeightThunderSeeds", 4, 0, 100);
        BUILDER.pop();

        BUILDER.push("Crop Growth Rates");
        serverGrowthRateAshenWheat = BUILDER.comment("Ashenwheat growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateAshenWheat")
                .defineInRange("growthRateAshenwheat", 0.96, 0.01, 100.0);
        serverGrowthRateScintillaWheat = BUILDER.comment("Scintilla growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateScintillaWheat")
                .defineInRange("growthRateScintillaWheat", 0.79, 0.01, 100.0);
        serverGrowthRateOssidRoot = BUILDER.comment("Ossid root growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateOssidRoot")
                .defineInRange("growthRateOssidRoot", 0.89, 0.01, 100.0);
        serverGrowthRateThunderGrass = BUILDER.comment("Thundergrass growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateThunderGrass")
                .defineInRange("growthRateThunderGrass", 0.5, 0.01, 100.0);
        serverNeighborFactorThunderGrass = BUILDER.comment("Thundergrass neighbor tolerance (wheat = 1.0), aka f_min")
                .translation(Ashenwheat.MODID + "config.serverNeighborFactorThunderGrass")
                .defineInRange("neighborFactorThunderGrass", 5.0, 0.1, 6.0);
        BUILDER.pop();

        // imports from Wuppy29's old Peaceful Pack mod.
        BUILDER.push("Wuppy29's Peaceful Pack");
        BUILDER.push("Flax");
//        serverEnableFlaxRecipes = BUILDER.comment("Enable flax recipes")
//                .translation(Ashenwheat.MODID + "config.serverEnableFlaxRecipes")
//                .define("enableFlaxRecipes", true);
        serverDropFlaxSeed = BUILDER.comment("Should flax seed drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.serverDropFlaxSeed")
                .define("dropFlaxSeed", false);
        server_relWeightFlaxSeeds = BUILDER.comment("Relative weight of flax seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.server_relWeightFlaxSeed")
                .defineInRange("relWeightFlaxSeeds", 4, 0, 100);
        BUILDER.pop();
        BUILDER.push("Rotten Plant");
        serverDropRottenSeeds = BUILDER.comment("Should rotten seed drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.serverDropRottenSeeds")
                .define("dropRottenSeeds", false);
        server_relWeightRottenSeeds = BUILDER.comment("Relative weight of rotten seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.server_relWeightRottenSeeds")
                .defineInRange("relWeightRottenSeeds", 1, 0, 100);
        BUILDER.pop();
        BUILDER.push("Spider Eyes");
        serverEnableSpiderEyeDrops  = BUILDER.comment("Enable spider eyes dropping from cobwebs")
                .translation(Ashenwheat.MODID + "config.serverEnableSpiderEyeDrops")
                .define("enableSpiderEyeDrops", true);
        serverSpiderEyeDropChance = BUILDER.comment("Chance that spider eyes will drop from cobwebs")
                .translation(Ashenwheat.MODID + ".config.serverSpiderEyeDropChance")
                .defineInRange("spiderEyeDropChance", 0.50D, 0.0D, 1.00D);
        BUILDER.pop();
        BUILDER.pop();

    } // end static block

    public static final ModConfigSpec SPEC = BUILDER.build();

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
    
    public static boolean EnableSpiderEyeDrops = false;
    public static float SpiderEyeDropChance = 1.0F;

    public static void onLoad(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getType() == ModConfig.Type.STARTUP)
        {
            AshenwheatConfig.growthRateAshenWheat = serverGrowthRateAshenWheat.get().floatValue();
            AshenwheatConfig.growthRateScintillaWheat = serverGrowthRateScintillaWheat.get().floatValue();
            AshenwheatConfig.growthRateOssidRoot = serverGrowthRateOssidRoot.get().floatValue();
            AshenwheatConfig.growthRateThunderGrass = serverGrowthRateThunderGrass.get().floatValue();
            AshenwheatConfig.neighborFactorThunderGrass = serverNeighborFactorThunderGrass.get().floatValue();
        }

        if (event.getConfig().getType() == ModConfig.Type.COMMON)
        {
            AshenwheatConfig.SeedsInChests = serverSeedsInChests.get();
            AshenwheatConfig.DropAshSeeds = serverDropAshSeeds.get();
            AshenwheatConfig.DropOssidSeeds = serverDropOssidSeeds.get();
            AshenwheatConfig.DropScintillaSeeds = serverDropScintillaSeeds.get();
            AshenwheatConfig.DropThunderSeeds = serverDropThunderSeeds.get();

            AshenwheatConfig.relWeightWheatSeeds = server_relWeightWheatSeeds.get();
            AshenwheatConfig.relWeightAshSeeds = server_relWeightAshSeeds.get();
            AshenwheatConfig.relWeightScintillaSeeds = server_relWeightScintillaSeeds.get();
            AshenwheatConfig.relWeightOssidSeeds = server_relWeightOssidSeeds.get();
            AshenwheatConfig.relWeightThunderSeeds = server_relWeightThunderSeeds.get();
            AshenwheatConfig.relWeightFlaxSeeds = server_relWeightFlaxSeeds.get();
            AshenwheatConfig.relWeightRottenSeed = server_relWeightRottenSeeds.get();

            AshenwheatConfig.DropFlaxSeed = serverDropFlaxSeed.get();
            AshenwheatConfig.DropRottenSeeds = serverDropRottenSeeds.get();
            AshenwheatConfig.EnableSpiderEyeDrops = serverEnableSpiderEyeDrops.get();
            AshenwheatConfig.SpiderEyeDropChance = serverSpiderEyeDropChance.get().floatValue();
        }
    } // end onLoad()

} // end class
