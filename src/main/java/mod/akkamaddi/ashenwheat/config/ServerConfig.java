package mod.akkamaddi.ashenwheat.config;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraftforge.common.ForgeConfigSpec;

/**
 * For configuration settings that change the behaviour of code on the LOGICAL SERVER.
 * This can be moved to an inner class of ExampleModConfig, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 */
final class ServerConfig 
{

    final ForgeConfigSpec.BooleanValue serverSeedsInChests;
    final ForgeConfigSpec.BooleanValue serverDropAshSeeds;
    final ForgeConfigSpec.BooleanValue serverDropScintillaSeeds;
    final ForgeConfigSpec.BooleanValue serverDropOssidSeeds;
    final ForgeConfigSpec.BooleanValue serverDropThunderSeeds;
    final ForgeConfigSpec.IntValue server_relWeightWheatSeeds;
    final ForgeConfigSpec.IntValue server_relWeightAshSeeds;
    final ForgeConfigSpec.IntValue server_relWeightScintillaSeeds;
    final ForgeConfigSpec.IntValue server_relWeightOssidSeeds;
    final ForgeConfigSpec.IntValue server_relWeightThunderSeeds;
    final ForgeConfigSpec.DoubleValue serverGrowthRateAshenWheat;
    final ForgeConfigSpec.DoubleValue serverGrowthRateScintillaWheat; 
    final ForgeConfigSpec.DoubleValue serverGrowthRateOssidRoot;
    final ForgeConfigSpec.DoubleValue serverGrowthRateThunderGrass;
    final ForgeConfigSpec.DoubleValue serverNeighborFactorThunderGrass;
    
    final ForgeConfigSpec.BooleanValue serverDropFlaxSeed;
    final ForgeConfigSpec.IntValue server_relWeightFlaxSeeds;
    final ForgeConfigSpec.BooleanValue serverEnableFlaxRecipes;
    
    final ForgeConfigSpec.BooleanValue serverDropRottenSeeds;
    final ForgeConfigSpec.IntValue server_relWeightRottenSeeds;
    final ForgeConfigSpec.BooleanValue serverEnableSpiderEyeDrops;
    final ForgeConfigSpec.DoubleValue serverSpiderEyeDropChance;
    
	ServerConfig(final ForgeConfigSpec.Builder builder) 
	{	
        builder.push("General");
        serverSeedsInChests = builder.comment("Should seeds appear in some chests?" )
                .translation(Ashenwheat.MODID + "config.seedsInChests")
                .define("seedsInChests", true);
        builder.pop();
        
        // due to beta feedback, default to true for everything except 
        // Scintilla wheat, as by the time most people find chests, they
        // can already kill creepers & skeletons easily--eliminating the
        // early-game usefulness of Ossid Root & Thunder Grass. Ash wheat
        // is just another source of charcoal, so no need to make it rare
        // by default. Glowstone, on the other hand, should be rare pre-Nether.
        builder.push("Wild Grass Drops");
        server_relWeightWheatSeeds = builder.comment("Relative weight of wheat seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.relWeightWheatSeeds")
                .defineInRange("relWeightWheatSeeds", 10, 0, 100);

        serverDropAshSeeds = builder.comment("Should ashenwheat seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropAsh")
                .define("DropAshSeeds", true);
        server_relWeightAshSeeds = builder.comment("Relative weight of ashenwheat seeds in grass drops")
                 .translation(Ashenwheat.MODID + "config.relWeightAshSeeds")
                 .defineInRange("relWeightAshSeeds", 8, 0, 100);
        
        serverDropScintillaSeeds = builder.comment("Should scintilla wheat seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropScintilla")
                .define("DropScintillaSeeds", false);
        server_relWeightScintillaSeeds = builder.comment("Relative weight of scintilla wheat seeds in grass drops")
                 .translation(Ashenwheat.MODID + "config.relWeightScintillaSeeds")
                 .defineInRange("relWeightScintillaSeeds", 3, 0, 100);
        
        serverDropOssidSeeds = builder.comment("Should ossidroot seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropOssid")
                .define("DropOssidSeeds", true);
        server_relWeightOssidSeeds = builder.comment("Relative weight of ossidroot seeds in grass drops")
                 .translation(Ashenwheat.MODID + "config.relWeightOssidSeeds")
                 .defineInRange("relWeightOssidSeeds", 5, 0, 100);
        
        serverDropThunderSeeds = builder.comment("Should thundergrass seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropThunder")
                .define("DropThunderSeeds", true);
        server_relWeightThunderSeeds = builder.comment("Relative weight of thundergrass seeds in grass drops")
                 .translation(Ashenwheat.MODID + "config.relWeightThunderSeeds")
                 .defineInRange("relWeightThunderSeeds", 4, 0, 100);
        builder.pop();
        
        builder.push("Crop Growth Rates");
        serverGrowthRateAshenWheat = builder.comment("Ashenwheat growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateAshenWheat")
                .defineInRange("growthRateAshenwheat", 0.96, 0.01, 100.0);
        serverGrowthRateScintillaWheat = builder.comment("Scintilla growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateScintillaWheat")
                .defineInRange("growthRateScintillaWheat", 0.79, 0.01, 100.0); 
        serverGrowthRateOssidRoot = builder.comment("Ossid root growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateOssidRoot")
                .defineInRange("growthRateOssidRoot", 0.89, 0.01, 100.0);
        serverGrowthRateThunderGrass = builder.comment("Thundergrass growth rate (wheat = 1.0)")
                .translation(Ashenwheat.MODID + "config.serverGrowthRateThunderGrass")
                .defineInRange("growthRateThunderGrass", 0.5, 0.01, 100.0);
        serverNeighborFactorThunderGrass = builder.comment("Thundergrass neighbor tolerance (wheat = 1.0), aka f_min")
                .translation(Ashenwheat.MODID + "config.serverNeighborFactorThunderGrass")
                .defineInRange("neighborFactorThunderGrass", 5.0, 0.1, 6.0);
        builder.pop();
        
        // imports from Wuppy29's old Peaceful Pack mod.
        builder.push("Wuppy29's Peaceful Pack");
        builder.push("Flax");
        serverEnableFlaxRecipes = builder.comment("Enable flax recipes")
                .translation(Ashenwheat.MODID + "config.serverEnableFlaxRecipes")
                .define("enableFlaxRecipes", true);
        serverDropFlaxSeed = builder.comment("Should flax seed drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.serverDropFlaxSeed")
                .define("dropFlaxSeed", false);
        server_relWeightFlaxSeeds = builder.comment("Relative weight of flax seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.server_relWeightFlaxSeed")
                .defineInRange("relWeightFlaxSeeds", 4, 0, 100);
        builder.pop();
        builder.push("Rotten Plant");
        serverDropRottenSeeds = builder.comment("Should rotten seed drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.serverDropRottenSeeds")
                .define("dropRottenSeeds", false);
        server_relWeightRottenSeeds = builder.comment("Relative weight of rotten seeds in grass drops")
                .translation(Ashenwheat.MODID + "config.server_relWeightRottenSeeds")
                .defineInRange("relWeightRottenSeeds", 1, 0, 100);
        builder.pop();
        builder.push("Spider Eyes");
        serverEnableSpiderEyeDrops  = builder.comment("Enable spider eyes dropping from cobwebs")
                .translation(Ashenwheat.MODID + "config.serverEnableSpiderEyeDrops")
                .define("enableSpiderEyeDrops", true);
        serverSpiderEyeDropChance = builder.comment("Chance that spider eyes will drop from cobwebs")
                .translation(Ashenwheat.MODID + ".config.serverSpiderEyeDropChance")
                .defineInRange("spiderEyeDropChance", 0.50D, 0.0D, 1.00D);
        builder.pop();
        builder.pop();
	} // end ServerConfig()

} // end class
