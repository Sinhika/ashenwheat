package mod.akkamaddi.ashenwheat.loot;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.WeighedRandom;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class GrassLootModifiers
{
    
    public static class SeedEntry extends WeighedRandom.WeighedRandomItem
    {
        public final Item seed_item;
        
        public SeedEntry(Item seed_id, int itemWeightIn)
        {
            super(itemWeightIn);
            seed_item = seed_id;
        }
    } // end-class SeedEntry

    public static class GrassLootModifier extends LootModifier
    {
        private List<SeedEntry> dropped_seeds = new ArrayList<SeedEntry>();
        
        public GrassLootModifier(LootItemCondition[] conditionsIn,  List<String> seeds)
        {
            super(conditionsIn);
            
            dropped_seeds.add(new SeedEntry(Items.WHEAT_SEEDS, AshenwheatConfig.relWeightWheatSeeds));
            Ashenwheat.LOGGER.debug("GrassLootModifier: added minecraft:wheat_seeds");
            
            for (String s : seeds) 
            {
                Item seedItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));
                if ((seedItem == ModItems.ash_seeds.get()) && AshenwheatConfig.DropAshSeeds)
                {
                    dropped_seeds.add(new SeedEntry(ModItems.ash_seeds.get(),
                                                    AshenwheatConfig.relWeightAshSeeds));
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added ash_seeds");
                    continue;
                }
                if ((seedItem == ModItems.scintilla_seeds.get()) && AshenwheatConfig.DropScintillaSeeds)
                {
                    dropped_seeds.add(new SeedEntry(ModItems.scintilla_seeds.get(),
                                                    AshenwheatConfig.relWeightScintillaSeeds));
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added scintilla_seeds");
                    continue;
                }
                if ((seedItem == ModItems.ossid_seeds.get()) && AshenwheatConfig.DropOssidSeeds)
                {
                    dropped_seeds.add(new SeedEntry(ModItems.ossid_seeds.get(),
                                                    AshenwheatConfig.relWeightOssidSeeds));
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added ossid_seeds");
                    continue;
                }
                if ((seedItem == ModItems.thunder_seeds.get()) && AshenwheatConfig.DropThunderSeeds)
                {
                    dropped_seeds.add(new SeedEntry(ModItems.thunder_seeds.get(),
                                      AshenwheatConfig.relWeightThunderSeeds));
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added thunder_seeds");
                }
            } // end-for
        } // end-ctor

        /**
         * if minecraft:wheat_seeds drop from grass, re-roll what kind of seeds they really are, 
         * based on the weighted chances from the loot_modifier json. 
         */
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            List<ItemStack> newLoot = new ArrayList<ItemStack>();
            for (ItemStack stack : generatedLoot) 
            {
                // if wheat_seeds, what is it REALLY?
                if (stack.getItem() == Items.WHEAT_SEEDS) 
                {
                    SeedEntry se = WeighedRandom.getRandomItem(context.getRandom(), dropped_seeds);
                    ItemStack new_stack = new ItemStack(se.seed_item, stack.getCount()); 
                    newLoot.add(new_stack);
                }
                // anything else, pass through unaltered.
                else {
                    newLoot.add(stack);
                }
            }
            return newLoot;
        } // end doApply()
        
        public static class Serializer extends GlobalLootModifierSerializer<GrassLootModifier>
        {
            @Override
            public GrassLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] ailootcondition)
            {
                List<String> seeds = new ArrayList<String>();
                
                JsonArray seedlist = GsonHelper.getAsJsonArray(object, "seeds");
                for (JsonElement je: seedlist)
                {
                    seeds.add(je.getAsString());
                }
                return new GrassLootModifier(ailootcondition, seeds);
            } // end read()

            @Override
            public JsonObject write(GrassLootModifier instance)
            {
                return makeConditions(instance.conditions);
            }
        } // end-class Serializer
       
    } // end-class GrassLootModifer

} // end-class
