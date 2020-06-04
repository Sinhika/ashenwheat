package mod.akkamaddi.ashenwheat.config;

import net.minecraftforge.fml.config.ModConfig;

/**
 * This bakes the config values to normal fields
 *
 * @author Cadiboo
 * It can be merged into the main ExampleModConfig class, but is separate because of personal preference and to keep the code organised
 */
public final class ConfigHelper 
{

	public static void bakeClient(final ModConfig config) 
	{
	    AshenwheatConfig.MakeAshenwheatFlame = ConfigHolder.CLIENT.clientMakeAshenwheatFlame.get();
	    AshenwheatConfig.MakeAshenBalesFlame = ConfigHolder.CLIENT.clientMakeAshenBalesFlame.get();
	    AshenwheatConfig.MakeOssidCropGloom = ConfigHolder.CLIENT.clientMakeOssidCropGloom.get();
	    AshenwheatConfig.MakeOssidLanternGloom = ConfigHolder.CLIENT.clientMakeOssidLanternGloom.get();
	    AshenwheatConfig.MakeScintillaBalesScintillate = ConfigHolder.CLIENT.clientMakeScintillaBalesScintillate.get();
	    AshenwheatConfig.MakeScintillawheatScintillate = ConfigHolder.CLIENT.clientMakeScintillawheatScintillate.get();
	    AshenwheatConfig.MakeThunderGrassSmoke = ConfigHolder.CLIENT.clientMakeThunderGrassSmoke.get();
	}

	public static void bakeServer(final ModConfig config) 
	{
	    AshenwheatConfig.SeedsInChests = ConfigHolder.SERVER.serverSeedsInChests.get();
	    AshenwheatConfig.DropAshSeeds = ConfigHolder.SERVER.serverDropAshSeeds.get();
	    AshenwheatConfig.DropOssidSeeds = ConfigHolder.SERVER.serverDropOssidSeeds.get();
	    AshenwheatConfig.DropScintillaSeeds = ConfigHolder.SERVER.serverDropScintillaSeeds.get();
	    AshenwheatConfig.DropThunderSeeds = ConfigHolder.SERVER.serverDropThunderSeeds.get();
	}

} // end-class
