package akkamaddi.ashenwheat.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler 
{
	public static void preInit(FMLPreInitializationEvent event) 
	{
		File installDir = event.getModConfigurationDirectory();
		File configDir = new File(installDir, "akkamaddi");
		File configFile = new File(configDir, "ashenwheat.cfg");
		Configuration config = new Configuration(configFile);

		config.load();

		seedsInChests = config.get("xx Seeds in Chests",
				"Seeds appear in some chests, true or false", true).getBoolean(
				true);

		dropAsh = config.get("yy Wild Grass Drops",
				"Ashenwheat Seeds, false or true", false).getBoolean(false);
		dropScintilla = config.get("yy Wild Grass Drops",
				"Scintillawheat Seeds, false or true", false).getBoolean(false);
		dropOssid = config.get("yy Wild Grass Drops",
				"Ossidroot Seeds, false or true", false).getBoolean(false);
		dropThunder = config.get("yy Wild Grass Drops",
				"Thundergrass Seeds, false or true", false).getBoolean(false);

		MakeAshenwheatFlame = config.get("zz Boolean Configuration",
				"Flame particles on Ashenwheat crop, false or true", true)
				.getBoolean(true);
		MakeAshenBalesFlame = config.get("zz Boolean Configuration",
				"Flame and smoke particles on Ashenwheat bales, false or true",
				true).getBoolean(true);

		MakeScintillawheatScintillate = config
				.get("zz Boolean Configuration",
						"Scintillating particles on Scintillawheat crop, false or true",
						true).getBoolean(true);
		MakeScintillaBalesScintillate = config
				.get("zz Boolean Configuration",
						"Scintillating particles on Scintillawheat bales, false or true",
						true).getBoolean(true);

		MakeOssidCropGloom = config.get("zz Boolean Configuration",
				"Gloom particles on Ossidroot crop, false or true", true)
				.getBoolean(true);
		MakeOssidLanternGloom = config.get("zz Boolean Configuration",
				"Gloom particles on Ossid Lanterns, false or true", true)
				.getBoolean(true);

		MakeThunderGrassSmoke = config.get("zz Boolean Configuration",
				"Smoke particles on Thundergrass crop, false or true", true)
				.getBoolean(true);
		config.save();
	} // end preInit()

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
} // end class

