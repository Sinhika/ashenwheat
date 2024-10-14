package mod.akkamaddi.ashenwheat;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.akkamaddi.ashenwheat.loot.WheatInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both
 * PHYSICAL sides in this class
 */
@EventBusSubscriber(modid = Ashenwheat.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    private static final WheatInjectionLookup lootLookupMap = new WheatInjectionLookup();

    /**
     * Intercept villager trades list and modify it.
     */
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent evt)
    {
        if (evt.getType() == VillagerProfession.FARMER)
        {
            Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
            // add novice trades.
            trades.get(1).add(new BasicItemListing( new ItemStack(ModItems.ash_wheat_sheaf.get(), 20), new ItemStack(Items.EMERALD), 
                                16, 2, 0.05F));
            trades.get(1).add(new BasicItemListing( new ItemStack(Items.EMERALD),  new ItemStack(ModItems.ash_bread.get(), 6), 
                    16, 1, 0.05F));
            
            // add apprentice trades
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD),  new ItemStack(ModItems.flax_fibre.get(), 4), 
                    12, 5, 0.05F));
            
            // add journeyman trade
            trades.get(3).add(new BasicItemListing( new ItemStack(Items.EMERALD,3),  new ItemStack(ModItems.ash_cookie.get(), 6), 
                    12, 10, 0.05F));
            // add master trade
            trades.get(5).add(new BasicItemListing( new ItemStack(Items.EMERALD,3),  new ItemStack(ModItems.scintilla_cookie.get(), 3), 
                    12, 30, 0.05F));
        }
    } // end onVillagerTrades

    
    /**
     * intercept wandering trader trades list and modify it.
     */
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent evt)
    {
        List<ItemListing> trades = evt.getGenericTrades();
        List<ItemListing> rare_trades = evt.getRareTrades();
        
        // add generic Ashenwheat trades.
        trades.add(new BasicItemListing(1, new ItemStack(ModItems.ash_seeds.get()), 12, 3));
        trades.add(new BasicItemListing(1, new ItemStack(ModItems.thunder_seeds.get()), 12, 3));
        trades.add(new BasicItemListing(1, new ItemStack(ModItems.ossid_seeds.get()), 12, 3));
        trades.add(new BasicItemListing(1, new ItemStack(ModItems.flax_seed.get()), 12, 4));
        
        // add rare Ashenwheat trades.
        rare_trades.add(new BasicItemListing(2, new ItemStack(ModItems.scintilla_seeds.get()), 4, 6));
        rare_trades.add(new BasicItemListing(2, new ItemStack(ModItems.rotten_seeds.get()), 4, 6));
        rare_trades.add(new BasicItemListing(5, new ItemStack(ModBlocks.blaze_sapling.get().asItem()), 4, 6));
        
    } // end onWandererTrades
    
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
