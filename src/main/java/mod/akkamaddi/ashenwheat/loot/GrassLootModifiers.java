package mod.akkamaddi.ashenwheat.loot;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class GrassLootModifiers
{

    public static class SeedEntry extends WeightedRandom.Item
    {
        public final ResourceLocation seed_name;
        
        public SeedEntry(ResourceLocation seed_id, int itemWeightIn)
        {
            super(itemWeightIn);
            seed_name = seed_id;
        }
    } // end-class SeedEntry

    public static class GrassLootModifier extends LootModifier
    {
        private final int wheat_chance = 10;
        private List<SeedEntry> dropped_seeds = new ArrayList<SeedEntry>();
        
        public GrassLootModifier(ILootCondition[] conditionsIn, int ashen, int scintilla, 
                                 int ossid, int thunder)
        {
            super(conditionsIn);
            dropped_seeds.add(new SeedEntry(new ResourceLocation("minecraft:wheat_seeds"), 
                                wheat_chance));
            if (AshenwheatConfig.DropAshSeeds) {
                dropped_seeds.add(new SeedEntry(new ResourceLocation(Ashenwheat.MODID, "ash_seeds"),
                                   ashen));
            }
            if (AshenwheatConfig.DropScintillaSeeds) {
                dropped_seeds.add(new SeedEntry(new ResourceLocation(Ashenwheat.MODID, "scintilla_seeds"),
                        scintilla));
            }
            if (AshenwheatConfig.DropOssidSeeds) {
                dropped_seeds.add(new SeedEntry(new ResourceLocation(Ashenwheat.MODID, "ossid_seeds"),
                        ossid));
            }
            if (AshenwheatConfig.DropThunderSeeds) {
                dropped_seeds.add(new SeedEntry(new ResourceLocation(Ashenwheat.MODID, "thunder_seeds"),
                        thunder));
            }
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
                    SeedEntry se = WeightedRandom.getRandomItem(context.getRandom(), dropped_seeds);
                    net.minecraft.item.Item seedItem = ForgeRegistries.ITEMS.getValue(se.seed_name);
                    newLoot.add(new ItemStack(seedItem, stack.getCount()));
                }
                // anything else, pass through unaltered.
                else {
                    newLoot.add(stack);
                }
            }
            return newLoot;
        }
    } // end-class GrassLootModifer

    public static class Serializer extends GlobalLootModifierSerializer<GrassLootModifier>
    {

        @Override
        public GrassLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition)
        {
            int ashen_chance = JSONUtils.getInt(object, "ashenwheat_chance");
            int scintilla_chance = JSONUtils.getInt(object, "scintillawheat_chance");
            int ossid_chance = JSONUtils.getInt(object, "ossid_chance");
            int thunder_chance = JSONUtils.getInt(object, "thundergrass_chance");
            return new GrassLootModifier(ailootcondition, ashen_chance, scintilla_chance, ossid_chance,
                                         thunder_chance);
        }

    } // end-class Serializer
   
} // end-class
