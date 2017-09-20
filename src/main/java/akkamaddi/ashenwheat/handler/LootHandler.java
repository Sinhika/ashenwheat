package akkamaddi.ashenwheat.handler;

import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import akkamaddi.ashenwheat.ModItems;

public class LootHandler 
{
	/** create LootFunction ranges */
	protected static LootFunction [] createCount(int min, int max) 
	{
		LootFunction [] result = new LootFunction [1];
		result[0] = new SetCount(new LootCondition[0], new RandomValueRange(min, max));
		return result;
	}
	
	/**
	 * add mods seeds to loot tables. 
	 */
	@SubscribeEvent
	public void LootLoad(LootTableLoadEvent event)
	{
		// add loot to pyramids, dungeons, blacksmith, mineshafts, etc
		if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON))
		{
			LootPool pool1 = event.getTable().getPool("pool1");
			pool1.addEntry(new LootEntryItem(ModItems.ashSeeds, 15, 0, createCount(2,6),
					new LootCondition[0], 
					ModItems.ashSeeds.getUnlocalizedName().substring(5)));
			pool1.addEntry(new LootEntryItem(ModItems.scintillaSeeds, 5, 0,
					createCount(1,3), new LootCondition[0], 
					ModItems.scintillaSeeds.getUnlocalizedName().substring(5)));
			pool1.addEntry(new LootEntryItem(ModItems.ossidSeeds, 10, 0, createCount(2,4),
					new LootCondition[0], 
					ModItems.ossidSeeds.getUnlocalizedName().substring(5)));
			pool1.addEntry(new LootEntryItem(ModItems.thunderSeeds, 10, 0,
					createCount(2,4), new LootCondition[0], 
					ModItems.thunderSeeds.getUnlocalizedName().substring(5)));
		} // end-if CHESTS_SIMPLE_DUNGEON
		else if (event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE))
		{
			LootPool pool_main = event.getTable().getPool("main");
			pool_main.addEntry(new LootEntryItem(ModItems.ashSeeds, 20, 0, createCount(2,8),
					new LootCondition[0], 
					ModItems.ashSeeds.getUnlocalizedName().substring(5)+"#1"));
			pool_main.addEntry(new LootEntryItem(ModItems.scintillaSeeds, 10, 0,
					createCount(2,4), new LootCondition[0], ModItems.scintillaSeeds
							.getUnlocalizedName().substring(5)+"#1"));
			pool_main.addEntry(new LootEntryItem(ModItems.ossidSeeds, 15, 0, createCount(2,6),
					new LootCondition[0], ModItems.ossidSeeds
							.getUnlocalizedName().substring(5)+"#1"));
			pool_main.addEntry(new LootEntryItem(ModItems.thunderSeeds, 15, 0,
					createCount(2,6), new LootCondition[0], ModItems.thunderSeeds
							.getUnlocalizedName().substring(5)+"#1"));
		} // end-else-if CHESTS_JUNGLE_TEMPLE
		else if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID))
		{
			LootPool pool1 = event.getTable().getPool("pool1");
			pool1.addEntry(new LootEntryItem(ModItems.scintillaSeeds, 6, 0,
					createCount(2,6), new LootCondition[0], ModItems.scintillaSeeds
							.getUnlocalizedName().substring(5)+"#2"));
			pool1.addEntry(new LootEntryItem(ModItems.scintillaWheatSheaf, 16, 0, createCount(2,4),
					new LootCondition[0], ModItems.scintillaWheatSheaf.getUnlocalizedName()
							.substring(5)));
			pool1.addEntry(new LootEntryItem(ModItems.ashCookie, 12, 0, createCount(6,16),
					new LootCondition[0], ModItems.ashCookie
							.getUnlocalizedName().substring(5)));
			pool1.addEntry(new LootEntryItem(ModItems.scintillaCookie, 12, 0,
					createCount(6,16), new LootCondition[0], ModItems.scintillaCookie
							.getUnlocalizedName().substring(5)));
		} // end-else-if CHESTS_DESERT_PYRAMID
		else if (event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH))
		{
			LootPool pool_main = event.getTable().getPool("main");
			pool_main.addEntry(new LootEntryItem(ModItems.ashSeeds, 10, 0, createCount(2,6),
					new LootCondition[0], ModItems.ashSeeds.getUnlocalizedName()
							.substring(5)+"#2"));
			pool_main.addEntry(new LootEntryItem(ModItems.scintillaSeeds, 2, 0,
					createCount(1,3), new LootCondition[0], ModItems.scintillaSeeds
							.getUnlocalizedName().substring(5)+"#3"));
			pool_main.addEntry(new LootEntryItem(ModItems.ossidSeeds, 5, 0, createCount(2,4),
					new LootCondition[0], ModItems.ossidSeeds
							.getUnlocalizedName().substring(5)+"#2"));
			pool_main.addEntry(new LootEntryItem(ModItems.thunderSeeds, 5, 0,
					createCount(2,4), new LootCondition[0], ModItems.thunderSeeds
							.getUnlocalizedName().substring(5)+"#2"));
			pool_main.addEntry(new LootEntryItem(ModItems.ashWheatSheaf, 5, 0, createCount(2,4),
					new LootCondition[0], ModItems.ashWheatSheaf.getUnlocalizedName()
							.substring(5)));
			pool_main.addEntry(new LootEntryItem(ModItems.scintillaWheatSheaf, 2, 0, createCount(1,3),
					new LootCondition[0], ModItems.scintillaWheatSheaf.getUnlocalizedName()
							.substring(5)+"#1"));
			pool_main.addEntry(new LootEntryItem(ModItems.ashCookie, 4, 0, createCount(6,16),
					new LootCondition[0], ModItems.ashCookie.getUnlocalizedName()
							.substring(5)+"#1"));
			pool_main.addEntry(new LootEntryItem(ModItems.scintillaCookie, 2, 0, createCount(6,16),
					new LootCondition[0], ModItems.scintillaCookie.getUnlocalizedName()
							.substring(5)+"#1"));
		} // end-else-if CHESTS_VILLAGE_BLACKSMITH
		else if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT))
		{
			LootPool pool1 = event.getTable().getPool("pool1");
			pool1.addEntry(new LootEntryItem(ModItems.ashSeeds, 3, 0, createCount(1,4),
					new LootCondition[0], ModItems.ashSeeds.getUnlocalizedName()
							.substring(5)+"#3"));
			pool1.addEntry(new LootEntryItem(ModItems.scintillaSeeds, 1, 0,
					createCount(1,2), new LootCondition[0], ModItems.scintillaSeeds
							.getUnlocalizedName().substring(5)+"#4"));
			pool1.addEntry(new LootEntryItem(ModItems.ossidSeeds, 2, 0, createCount(1,3),
					new LootCondition[0], ModItems.ossidSeeds
							.getUnlocalizedName().substring(5)+"#3"));
			pool1.addEntry(new LootEntryItem(ModItems.thunderSeeds, 2, 0,
					createCount(1,3), new LootCondition[0], ModItems.thunderSeeds
							.getUnlocalizedName().substring(5)+"#3"));
		} // end else-if CHESTS_ABANDONED_MINESHAFT
		// add in new structure igloo
		else if (event.getName().equals(LootTableList.CHESTS_IGLOO_CHEST))
		{
			LootPool pool_main = event.getTable().getPool("main");
			pool_main.addEntry(new LootEntryItem(ModItems.ashWheatSheaf, 9, 0, createCount(2,4),
					new LootCondition[0], ModItems.ashWheatSheaf.getUnlocalizedName()
							.substring(5)));
			pool_main.addEntry(new LootEntryItem(ModItems.ashBread, 14, 0, createCount(1,3),
					new LootCondition[0], ModItems.ashBread.getUnlocalizedName()
							.substring(5)));
		} // end else-if CHESTS_IGLOO_CHEST
		// none of the above? Not interested.
		else {
			return;
		}
	} // end LootLoad()
	
} // end class
