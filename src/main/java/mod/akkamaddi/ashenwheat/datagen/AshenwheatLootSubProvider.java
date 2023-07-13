package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class AshenwheatLootSubProvider extends SimpleBlockLootSubProvider
{

	@Override
	protected void generate() 
	{
		this.dropSelf(ModBlocks.blaze_log.get());
		this.dropSelf(ModBlocks.blaze_wood.get());
		this.dropSelf(ModBlocks.stripped_blaze_log.get());
		this.dropSelf(ModBlocks.stripped_blaze_wood.get());
		this.dropSelf(ModBlocks.blaze_sapling.get());
		this.dropOther(ModBlocks.buried_remains.get(), Items.ROTTEN_FLESH);
		this.dropOther(ModBlocks.ender_clam.get(), Items.ENDER_PEARL);
		this.dropSelf(ModBlocks.blazewood_planks.get());
		this.dropSelf(ModBlocks.blazewood_stairs.get());
		this.dropSelf(ModBlocks.blazewood_pressure_plate.get());
		this.dropSelf(ModBlocks.blazewood_button.get());
		this.dropSelf(ModBlocks.blazewood_fence.get());
		this.dropSelf(ModBlocks.blazewood_fence_gate.get());
		this.dropSelf(ModBlocks.carved_ossid_root.get());
		this.dropSelf(ModBlocks.ossid_lantern.get());
		this.dropSelf(ModBlocks.ossid_root.get());
		this.dropSelf(ModBlocks.ash_wheat_bale.get());
		this.dropSelf(ModBlocks.scintilla_wheat_bale.get());
		
		this.dropSlab(ModBlocks.blazewood_slab.get());
		this.dropCrops(ModBlocks.rotten_crop.get(), Items.ROTTEN_FLESH, ModItems.rotten_seeds.get(), 2);
		this.dropCrops(ModBlocks.flax_crop.get(), ModItems.flax_fibre.get(), ModItems.rotten_seeds.get(), 7);
		this.dropCrops(ModBlocks.thunder_grass_crop.get(), ModItems.thunder_seeds.get(), ModItems.thunder_seeds.get(), 7);
		this.dropCrops(ModBlocks.scintilla_wheat_crop.get(), ModItems.scintilla_wheat_sheaf.get(), ModItems.scintilla_seeds.get(), 7);
		this.dropCrops(ModBlocks.ash_wheat_crop.get(), ModItems.ash_wheat_sheaf.get(), ModItems.ash_seeds.get(), 7);
		this.dropCrops(ModBlocks.ossid_root_crop.get(), ModBlocks.ossid_root.get().asItem(), ModItems.ossid_seeds.get(), 7);
	}

    protected void dropCrops(ModCropsBlock cropBlock, Item primary_drop, ItemNameBlockItem seed_item, int max_age)
    {
    	LootItemCondition.Builder lootitemcondition$builder = 
    			LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
    				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, max_age));
    	this.add(cropBlock, this.createCropDrops(cropBlock, primary_drop, seed_item, lootitemcondition$builder));
    } // end CropDropTable()
    
//    
//     
//    protected static LootPool.Builder createCropDrops(ModCropsBlock cb, Item primary_drop, int max_primary, 
//                                                      ItemNameBlockItem seed_item, int max_age)
//    {
//        IntegerProperty prop = cb.getAgeProperty();
//        
//         LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(primary_drop)
//                 .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, max_primary)))
//                 .when(ExplosionCondition.survivesExplosion())
//                 .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(cb)
//                         .setProperties(StatePropertiesPredicate.Builder.properties()
//                                 .hasProperty(prop, max_age)))
//                 .otherwise(LootItem.lootTableItem(seed_item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))));
//         
//         return LootPool.lootPool().add(builder);
//         
//    } // end createCropDrops()
//    
//    protected static LootPool.Builder createSeedDrops(ModCropsBlock cb, ItemNameBlockItem seed_item, int max_seeds, int max_age)
//    {
//        IntegerProperty prop = cb.getAgeProperty();
//       LootPoolEntryContainer.Builder<?> builder2 = LootItem.lootTableItem(seed_item)
//                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, max_seeds)))
//                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(cb)
//                        .setProperties(StatePropertiesPredicate.Builder.properties()
//                                .hasProperty(prop, max_age)));
//                
//        return LootPool.lootPool().add(builder2);
//        
//    } // createSeedDrops()
//    

    
} // end class
