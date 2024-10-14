package mod.akkamaddi.ashenwheat.config;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraftforge.common.ForgeConfigSpec;

/**
 * For configuration settings that change the behaviour of code on the LOGICAL CLIENT.
 * This can be moved to an inner class of ExampleModConfig, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 */
final class ClientConfig 
{
    final ForgeConfigSpec.BooleanValue clientMakeAshenwheatFlame;
    final ForgeConfigSpec.BooleanValue clientMakeAshenBalesFlame;
    final ForgeConfigSpec.BooleanValue clientMakeScintillawheatScintillate;
    final ForgeConfigSpec.BooleanValue clientMakeScintillaBalesScintillate;
    final ForgeConfigSpec.BooleanValue clientMakeScintillationsSmaller;
    
    final ForgeConfigSpec.BooleanValue clientMakeOssidCropGloom;
    final ForgeConfigSpec.BooleanValue clientMakeOssidLanternGloom;
    final ForgeConfigSpec.BooleanValue clientMakeThunderGrassSmoke;
    final ForgeConfigSpec.BooleanValue clientMakeThunderGrassSmokeSmaller;
    
    
	ClientConfig(final ForgeConfigSpec.Builder builder) 
	{
        builder.push("Particle Effects");
        clientMakeAshenwheatFlame = builder.comment("Flame particles on Ashenwheat crop?")
                .translation(Ashenwheat.MODID + "config.MakeAshenwheatFlame")
                .define("MakeAshenwheatFlame", true);
        clientMakeAshenBalesFlame = builder.comment("Flame and smoke particles on Ashenwheat bales?")
                .translation(Ashenwheat.MODID + "config.MakeAshenBalesFlame")
                .define("MakeAshenBalesFlame", true);
        clientMakeScintillawheatScintillate = builder.comment("Scintillating particles on Scintillawheat crop?")
                .translation(Ashenwheat.MODID + "config.MakeScintillawheatScintillate")
                .define("MakeScintillawheatScintillate", true);
        clientMakeScintillaBalesScintillate = builder.comment("Scintillating particles on Scintillawheat bales?")
                .translation(Ashenwheat.MODID + "config.MakeScintillaBalesScintillate")
                .define("MakeScintillaBalesScintillate", true);
        clientMakeScintillationsSmaller = builder.comment("Like scintillations, but not quite so much?")
                .translation(Ashenwheat.MODID + "config.MakeScintillationsSmaller")
                .define("MakeScintillationsSmaller", false);
        clientMakeOssidCropGloom = builder.comment("Gloom particles on Ossidroot crop?")
                .translation(Ashenwheat.MODID + "config.MakeOssidCropGloom")
                .define("MakeOssidCropGloom", true);
        clientMakeOssidLanternGloom = builder.comment("Gloom particles on Ossidroots, Carved Ossidroots, and Ossidroot Lanterns?")
                .translation(Ashenwheat.MODID + "config.MakeOssidLanternGloom")
                .define("MakeOssidLanternGloom", true);
        clientMakeThunderGrassSmoke = builder.comment("Should thundergrass smoke?")
                .translation(Ashenwheat.MODID + "config.MakeThunderGrassSmoke")
                .define("MakeThunderGrassSmoke", true);
        clientMakeThunderGrassSmokeSmaller = builder.comment("Want smoke, but not that much?")
                .translation(Ashenwheat.MODID + "config.MakeThunderGrassSmokeSmaller")
                .define("MakeThunderGrassSmokeSmaller", false);
        builder.pop();
	    
	} // end ClientConfig()

} // end-class
