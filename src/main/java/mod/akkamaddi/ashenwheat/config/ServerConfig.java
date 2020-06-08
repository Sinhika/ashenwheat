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
	} // end ServerConfig()

} // end class
