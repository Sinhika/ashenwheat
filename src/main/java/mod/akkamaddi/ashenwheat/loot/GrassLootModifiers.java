package mod.akkamaddi.ashenwheat.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModCodecs;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GrassLootModifiers
{
    
    public static class GrassLootModifier extends LootModifier
    {
        private SimpleWeightedRandomList<Item> dropped_seeds;
        private final List<Item> seeds;
        
        public static final MapCodec<GrassLootModifier> CODEC =
                RecordCodecBuilder.mapCodec( inst -> LootModifier.codecStart(inst)
                        .and( BuiltInRegistries.ITEM.byNameCodec().listOf().fieldOf("seeds")
                                      .forGetter(m -> m.seeds)
                    ).apply(inst, GrassLootModifier::new));
        
        public GrassLootModifier(LootItemCondition[] conditionsIn,  List<Item> seeds)
        {
            super(conditionsIn);
            this.seeds = seeds;
            
            SimpleWeightedRandomList.Builder<Item> dropped_seeds_builder  = SimpleWeightedRandomList.<Item>builder();
            
            dropped_seeds_builder.add(Items.WHEAT_SEEDS, AshenwheatConfig.relWeightWheatSeeds);
            Ashenwheat.LOGGER.debug("GrassLootModifier: added minecraft:wheat_seeds");
            
            for (Item seedItem : seeds) 
            {
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
                if ((seedItem == ModItems.flax_seed.get()) &&  AshenwheatConfig.DropFlaxSeed)
                {
                    dropped_seeds_builder.add(ModItems.flax_seed.get(), AshenwheatConfig.relWeightFlaxSeeds);
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added flax_seed");
                }
                if ((seedItem == ModItems.rotten_seeds.get()) &&  AshenwheatConfig.DropRottenSeeds)
                {
                    dropped_seeds_builder.add(ModItems.rotten_seeds.get(), AshenwheatConfig.relWeightRottenSeed);
                    Ashenwheat.LOGGER.debug("GrassLootModifier: added rotten_seeds");
                }
            } // end-for
            dropped_seeds = dropped_seeds_builder.build();
        } // end-ctor

        @Override
        public MapCodec<? extends IGlobalLootModifier> codec()
        {
            return ModCodecs.seeds_from_grass.get();
        }


        /**
         * if minecraft:wheat_seeds drop from grass, re-roll what kind of seeds they really are, 
         * based on the weighted chances from the loot_modifier json. 
         */
        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
                LootContext context)
        {
            List<ItemStack> newLoot = new ObjectArrayList<ItemStack>();
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
            return (@NotNull ObjectArrayList<ItemStack>) newLoot;
        } // end doApply()
        
      } // end-class GrassLootModifer

} // end-class GrassLootModifiers
