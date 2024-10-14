package mod.akkamaddi.ashenwheat.config;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.alexndr.simplecorelib.api.config.SimpleConfig;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * For configuration settings that change the behaviour of code on the LOGICAL CLIENT.
 * This can be moved to an inner class of ExampleModConfig, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 */
public final class AshenwheatClientConfig extends SimpleConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue clientMakeAshenwheatFlame;
    private static final ModConfigSpec.BooleanValue clientMakeAshenBalesFlame;
    private static final ModConfigSpec.BooleanValue clientMakeScintillawheatScintillate;
    private static final ModConfigSpec.BooleanValue clientMakeScintillaBalesScintillate;
    private static final ModConfigSpec.BooleanValue clientMakeScintillationsSmaller;
    
    private static final ModConfigSpec.BooleanValue clientMakeOssidCropGloom;
    private static final ModConfigSpec.BooleanValue clientMakeOssidLanternGloom;
    private static final ModConfigSpec.BooleanValue clientMakeThunderGrassSmoke;
    private static final ModConfigSpec.BooleanValue clientMakeThunderGrassSmokeSmaller;


    static
	{
        BUILDER.push("Particle Effects");
        clientMakeAshenwheatFlame = BUILDER.comment("Flame particles on Ashenwheat crop?")
                .translation(Ashenwheat.MODID + "config.MakeAshenwheatFlame")
                .define("MakeAshenwheatFlame", true);
        clientMakeAshenBalesFlame = BUILDER.comment("Flame and smoke particles on Ashenwheat bales?")
                .translation(Ashenwheat.MODID + "config.MakeAshenBalesFlame")
                .define("MakeAshenBalesFlame", true);
        clientMakeScintillawheatScintillate = BUILDER.comment("Scintillating particles on Scintillawheat crop?")
                .translation(Ashenwheat.MODID + "config.MakeScintillawheatScintillate")
                .define("MakeScintillawheatScintillate", true);
        clientMakeScintillaBalesScintillate = BUILDER.comment("Scintillating particles on Scintillawheat bales?")
                .translation(Ashenwheat.MODID + "config.MakeScintillaBalesScintillate")
                .define("MakeScintillaBalesScintillate", true);
        clientMakeScintillationsSmaller = BUILDER.comment("Like scintillations, but not quite so much?")
                .translation(Ashenwheat.MODID + "config.MakeScintillationsSmaller")
                .define("MakeScintillationsSmaller", false);
        clientMakeOssidCropGloom = BUILDER.comment("Gloom particles on Ossidroot crop?")
                .translation(Ashenwheat.MODID + "config.MakeOssidCropGloom")
                .define("MakeOssidCropGloom", true);
        clientMakeOssidLanternGloom = BUILDER.comment("Gloom particles on Ossidroots, Carved Ossidroots, and Ossidroot Lanterns?")
                .translation(Ashenwheat.MODID + "config.MakeOssidLanternGloom")
                .define("MakeOssidLanternGloom", true);
        clientMakeThunderGrassSmoke = BUILDER.comment("Should thundergrass smoke?")
                .translation(Ashenwheat.MODID + "config.MakeThunderGrassSmoke")
                .define("MakeThunderGrassSmoke", true);
        clientMakeThunderGrassSmokeSmaller = BUILDER.comment("Want smoke, but not that much?")
                .translation(Ashenwheat.MODID + "config.MakeThunderGrassSmokeSmaller")
                .define("MakeThunderGrassSmokeSmaller", false);
        BUILDER.pop();
	    
	} // end static block

    public static final ModConfigSpec SPEC = BUILDER.build();

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

    public static void onLoad(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getType() == ModConfig.Type.CLIENT)
        {
            AshenwheatClientConfig.MakeAshenwheatFlame = clientMakeAshenwheatFlame.get();
            AshenwheatClientConfig.MakeAshenBalesFlame = clientMakeAshenBalesFlame.get();
            AshenwheatClientConfig.MakeOssidCropGloom = clientMakeOssidCropGloom.get();
            AshenwheatClientConfig.MakeOssidLanternGloom = clientMakeOssidLanternGloom.get();
            AshenwheatClientConfig.MakeScintillaBalesScintillate = clientMakeScintillaBalesScintillate.get();
            AshenwheatClientConfig.MakeScintillawheatScintillate = clientMakeScintillawheatScintillate.get();
            AshenwheatClientConfig.MakeScintillationsSmaller = clientMakeScintillationsSmaller.get();
            AshenwheatClientConfig.MakeThunderGrassSmoke = clientMakeThunderGrassSmoke.get();
            AshenwheatClientConfig.MakeThunderGrassSmokeSmaller = clientMakeThunderGrassSmokeSmaller.get();
        }
    } // end onLoad()
    
} // end-class
