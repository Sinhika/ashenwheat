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
        serverDropAshSeeds = builder.comment("Should ashenwheat seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropAsh")
                .define("DropAshSeeds", true);
        serverDropScintillaSeeds = builder.comment("Should scintilla-wheat seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropScintilla")
                .define("DropScintillaSeeds", false);
        serverDropOssidSeeds = builder.comment("Should ossidroot seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropOssid")
                .define("DropOssidSeeds", true);
        serverDropThunderSeeds = builder.comment("Should thundergrass seeds drop from breaking grass?")
                .translation(Ashenwheat.MODID + "config.dropThunder")
                .define("DropThunderSeeds", true);
        builder.pop();
        
	} // end ServerConfig()

} // end class
