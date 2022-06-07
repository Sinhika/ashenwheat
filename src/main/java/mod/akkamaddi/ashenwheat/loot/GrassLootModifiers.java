package mod.akkamaddi.ashenwheat.loot;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class GrassLootModifiers
{
    
    public static class GrassLootModifier extends LootModifier
    {
        private SimpleWeightedRandomList<Item> dropped_seeds;
        
        public GrassLootModifier(LootItemCondition[] conditionsIn,  List<String> seeds)
        {
            super(conditionsIn);
            
            SimpleWeightedRandomList.Builder<Item> dropped_seeds_builder  = SimpleWeightedRandomList.<Item>builder();
            
            dropped_seeds_builder.add(Items.WHEAT_SEEDS, AshenwheatConfig.relWeightWheatSeeds);
            Ashenwheat.LOGGER.debug("GrassLootModifier: added minecraft:wheat_seeds");
            
            for (String s : seeds) 
            {
                Item seedItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));
                if ((seedItem == ModItems.ash_seeds.get()) && AshenwheatConfig.DropAshSeeds)
                {
                    dropped_seeds_builder.add(ModItems.ash_seeds.get(), AshenwheatConfig.relWeightAshSeeds);
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added ash_seeds");
                    continue;
                }
                if ((seedItem == ModItems.scintilla_seeds.get()) && AshenwheatConfig.DropScintillaSeeds)
                {
                    dropped_seeds_builder.add(ModItems.scintilla_seeds.get(), AshenwheatConfig.relWeightScintillaSeeds);
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added scintilla_seeds");
                    continue;
                }
                if ((seedItem == ModItems.ossid_seeds.get()) && AshenwheatConfig.DropOssidSeeds)
                {
                    dropped_seeds_builder.add(ModItems.ossid_seeds.get(), AshenwheatConfig.relWeightOssidSeeds);
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added ossid_seeds");
                    continue;
                }
                if ((seedItem == ModItems.thunder_seeds.get()) && AshenwheatConfig.DropThunderSeeds)
                {
                    dropped_seeds_builder.add(ModItems.thunder_seeds.get(), AshenwheatConfig.relWeightThunderSeeds);
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added thunder_seeds");
                }
                if (AshenwheatConfig.EnablePeacefulPack)
                {
                    if ((seedItem == ModItems.flax_seed.get()) &&  AshenwheatConfig.GenerateFlax)
                    {
                        dropped_seeds_builder.add(ModItems.flax_seed.get(), AshenwheatConfig.relWeightFlaxSeeds);
                        Ashenwheat.LOGGER.debug("GrassLootModifier: added flax_seed");
                    }
                    if ((seedItem == ModItems.rotten_seeds.get()) &&  AshenwheatConfig.GenerateRottenPlants)
                    {
                        dropped_seeds_builder.add(ModItems.rotten_seeds.get(), AshenwheatConfig.relWeightRottenSeed);
                        Ashenwheat.LOGGER.debug("GrassLootModifier: added rotten_seeds");
                    }
               }
            } // end-for
            dropped_seeds = dropped_seeds_builder.build();
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
                    Item seed_item = dropped_seeds.getRandomValue(context.getRandom()).get();
                    ItemStack new_stack = new ItemStack(seed_item, stack.getCount()); 
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

} // end-class GrassLootModifiers
