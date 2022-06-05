package mod.akkamaddi.ashenwheat.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class AshenwheatLootTableProvider extends BlockLootTableProvider
{

    public AshenwheatLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        specialDropTable(ModBlocks.buried_remains.get(), Items.ROTTEN_FLESH);
        cropDropTable(ModBlocks.rotten_crop.get(), Items.ROTTEN_FLESH, 1, ModItems.rotten_seeds.get(), 1, 2);
        return tables;
    }

    protected void cropDropTable(ModCropsBlock cropBlock, Item primary_drop, int max_primary, ItemNameBlockItem seed_item, 
                                 int max_seeds, int max_age)
    {
        blockTable(cropBlock, 
                LootTable.lootTable()
                    .withPool(createCropDrops(cropBlock, primary_drop, max_primary, seed_item, max_seeds, max_age)));
    } // end CropDropTable()
    
    protected static LootPool.Builder createCropDrops(Block cb, Item primary_drop, int max_primary, 
                                                      ItemNameBlockItem seed_item, int max_seeds, int max_age)
    {
        IntegerProperty prop = (cb instanceof RottenPlantBlock) ? RottenPlantBlock.AGE : CropBlock.AGE;
        
         LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(primary_drop)
                 .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, max_primary)))
                 .when(ExplosionCondition.survivesExplosion())
                 .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(cb)
                         .setProperties(StatePropertiesPredicate.Builder.properties()
                                 .hasProperty(prop, max_age)))
                 .otherwise(LootItem.lootTableItem(seed_item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))));
         
         LootPoolEntryContainer.Builder<?> builder2 = LootItem.lootTableItem(seed_item)
                 .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, max_seeds)))
                 .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(cb)
                         .setProperties(StatePropertiesPredicate.Builder.properties()
                                 .hasProperty(prop, max_age)));
                 
         return LootPool.lootPool().add(builder).add(builder2);
         
    } // end createCropDrops()
    
} // end class
