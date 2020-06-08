package mod.akkamaddi.ashenwheat.config;

/**
 * This holds the baked (runtime) values for our config.
 * These values should never be from changed outside this package.
 * This can be split into multiple classes (Server, Client, Player, Common)
 * but has been kept in one class for simplicity
 *
 * @author Cadiboo
 */
public final class AshenwheatConfig 
{
	// Client
	public static boolean MakeAshenwheatFlame;
    public static boolean MakeAshenBalesFlame;
    public static boolean MakeScintillawheatScintillate;
    public static boolean MakeScintillaBalesScintillate;
    public static boolean MakeOssidCropGloom;
    public static boolean MakeOssidLanternGloom;
    public static boolean MakeThunderGrassSmoke;

	// Server
	public static boolean SeedsInChests;
    public static boolean DropAshSeeds = true;
    public static boolean DropScintillaSeeds = false;
    public static boolean DropOssidSeeds = true;
    public static boolean DropThunderSeeds = true;

} // end class
