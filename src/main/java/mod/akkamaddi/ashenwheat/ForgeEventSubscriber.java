package mod.akkamaddi.ashenwheat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.loot.ChestLootHandler;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both
 * PHYSICAL sides in this class
 */
@EventBusSubscriber(modid = Ashenwheat.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Forge Event Subscriber");

    /**
     * add mods seeds to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (AshenwheatConfig.SeedsInChests) 
        {
            String prefix = "minecraft:chests/";
            String name = event.getName().toString();

            if (name.startsWith(prefix)) 
            {
                String file = name.substring(name.indexOf(prefix) + prefix.length());
                
                // village chests are a bit more complicated now, but use the old
                // village_blacksmith chest loot table anyway.
                if (file.startsWith("village/village_")) 
                {
                    file = "village_blacksmith";
                }
                else if (file.startsWith("stronghold_")) 
                {
                    file = "stronghold";
                }
                switch (file) {
                case "simple_dungeon":
                case "stronghold":
                case "woodland_mansion":
                case "shipwreck_supply":
                case "buried_treasure":
                case "pillager_outpost":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool("simple_dungeon"));
                    break;
                case "village_blacksmith":
                case "desert_pyramid":
                case "abandoned_mineshaft":
                case "jungle_temple":
                case "igloo_chest":
                    LOGGER.debug("Attempting to inject loot pool for " + file);
                    event.getTable().addPool(ChestLootHandler.getInjectPool(file));
                    break;
                default:
                    // cases deliberately ignored:
                    // nether locations, because none of the seeds are nether-based
                    // underwater, because seeds get soggy and rot.
                    // dispensers, because you don't shoot seeds at people.
                    break;
                } // end-switch
            } // end-if chest loot
        } // end-if SeedsInChest
    } // end LootLoad()
    
} // end class
