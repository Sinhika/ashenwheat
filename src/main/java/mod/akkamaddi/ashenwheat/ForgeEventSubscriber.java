package mod.akkamaddi.ashenwheat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.loot.WheatInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
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
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Forge Event Subscriber");
    private static final WheatInjectionLookup lootLookupMap = new WheatInjectionLookup();

    /**
     * add mods seeds to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (AshenwheatConfig.SeedsInChests) 
        {
            LootUtils.LootLoadHandler(Ashenwheat.MODID, event, lootLookupMap);
        } // end-if SeedsInChest
    } // end LootLoad()
    
} // end class
