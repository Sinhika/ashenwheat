package akkamaddi.ashenwheat;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import akkamaddi.ashenwheat.block.AshWheatBale;
import akkamaddi.ashenwheat.block.AshWheatCrop;
import akkamaddi.ashenwheat.block.OssidRoot;
import akkamaddi.ashenwheat.block.OssidRootCrop;
import akkamaddi.ashenwheat.block.ScintillaWheatBale;
import akkamaddi.ashenwheat.block.ScintillaWheatCrop;
import akkamaddi.ashenwheat.block.ThunderGrassCrop;
import akkamaddi.ashenwheat.item.AshBread;
import akkamaddi.ashenwheat.item.AshCookie;
import akkamaddi.ashenwheat.item.AshSeeds;
import akkamaddi.ashenwheat.item.AshenWheatSheaf;
import akkamaddi.ashenwheat.item.OssidAsh;
import akkamaddi.ashenwheat.item.OssidSeeds;
import akkamaddi.ashenwheat.item.ScintillaBread;
import akkamaddi.ashenwheat.item.ScintillaCookie;
import akkamaddi.ashenwheat.item.ScintillaSeeds;
import akkamaddi.ashenwheat.item.ScintillaWheatSheaf;
import akkamaddi.ashenwheat.item.ScintillatingAsh;
import akkamaddi.ashenwheat.item.ThunderSeeds;
import akkamaddi.ashenwheat.item.UnstableSoot;

public class Content 
{
	/**
	 * Loads all the Ashenwheat content, by calling the methods below.
	 */
	public static void preInitialize()
	{
		try {
			doItems();
//			LogHelper.verboseInfo(ModInfo.ID,
//					"All items were added successfully");
		} 
		catch (Exception e) {
//			LogHelper.severe(ModInfo.ID,
//							"Items were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
		try {
			doBlocks();
//			LogHelper.verboseInfo(ModInfo.ID,
//					"All blocks were added successfully");
		} 
		catch (Exception e) {
//			LogHelper.severe(ModInfo.ID,
//							"Blocks were not added successfully. This is a serious problem!");
			e.printStackTrace();
		}
	} // end preInitialize()

	public static void doItems()
	{
		ashWheatSheaf = new AshenWheatSheaf();
		ashBread = new AshBread(4, 0.5F, false);
		ashCookie = new AshCookie( 1, 0.1F, false);

		scintillaWheatSheaf = new ScintillaWheatSheaf();
		scintillaBread = new ScintillaBread( 4, 0.7F, false);
		scintillaCookie = new ScintillaCookie( 1, 0.1F, false);
		scintillatingAsh = new ScintillatingAsh();

		calcifiedAsh = new OssidAsh();

		unstableSoot = new UnstableSoot();        
        
	} // end doItems()
	
	public static void doBlocks() {
		ashWheatBale = new AshWheatBale();
		ashWheatCrop = new AshWheatCrop();
		ashSeeds = new AshSeeds(ashWheatCrop, Blocks.FARMLAND);

		scintillaWheatBale = new ScintillaWheatBale();
		scintillaWheatCrop = new ScintillaWheatCrop();
		scintillaSeeds = new ScintillaSeeds(scintillaWheatCrop, Blocks.FARMLAND);

		ossidRoot = new OssidRoot(false);
		ossidLantern = new OssidRoot(true);
		ossidRootCrop = new OssidRootCrop();
		ossidSeeds = new OssidSeeds(ossidRootCrop, Blocks.FARMLAND);

		thunderGrassCrop = new ThunderGrassCrop();
		thunderSeeds = new ThunderSeeds(thunderGrassCrop, Blocks.FARMLAND);
	} // end doBlocks();

	
   
    public static Block ashWheatCrop;
    public static Block ashWheatBale;
    public static Item ashSeeds;
    public static Item ashWheatSheaf;
    public static Item ashBread;
    public static Item ashCookie;

    public static Block scintillaWheatCrop;
    public static Block scintillaWheatBale;
    public static Item scintillaSeeds;
    public static Item scintillaWheatSheaf;
    public static Item scintillaBread;
    public static Item scintillaCookie;
    public static Item scintillatingAsh;

    public static Block ossidRootCrop;
    public static Block ossidRoot;
    public static Block ossidLantern;
    public static Item ossidSeeds;
    public static Item calcifiedAsh;
    
    public static Block thunderGrassCrop;
    public static Item thunderSeeds;
    public static Item unstableSoot;
    
} // end class Content
