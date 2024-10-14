package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockLootSubProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class AshenwheatLootSubProvider extends SimpleBlockLootSubProvider {

	@Override
	protected void generate() {
		this.dropSelf(ModBlocks.blaze_log.get());
		this.dropSelf(ModBlocks.blaze_wood.get());
		this.dropSelf(ModBlocks.stripped_blaze_log.get());
		this.dropSelf(ModBlocks.stripped_blaze_wood.get());
		this.dropSelf(ModBlocks.blaze_sapling.get());
		this.dropMultiItemsWithFortune(ModBlocks.buried_remains.get(), Items.ROTTEN_FLESH, 1, 3);
		this.dropMultiItemsWithFortune(ModBlocks.ender_clam.get(), Items.ENDER_PEARL, 1, 1);

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
		this.dropCrops(ModBlocks.flax_crop.get(), ModItems.flax_fibre.get(), ModItems.flax_seed.get(), 7);
		this.dropCrops(ModBlocks.thunder_grass_crop.get(), ModItems.thunder_seeds.get(), ModItems.thunder_seeds.get(),
				7);
		this.dropCrops(ModBlocks.scintilla_wheat_crop.get(), ModItems.scintilla_wheat_sheaf.get(),
				ModItems.scintilla_seeds.get(), 7);
		this.dropCrops(ModBlocks.ash_wheat_crop.get(), ModItems.ash_wheat_sheaf.get(), ModItems.ash_seeds.get(), 7);
		this.dropCrops(ModBlocks.ossid_root_crop.get(), ModBlocks.ossid_root.get().asItem(), ModItems.ossid_seeds.get(),
				7);
		this.add(ModBlocks.blaze_leaves.get(), 
				createBlazeLeavesDrops(ModBlocks.blaze_leaves.get(), ModBlocks.blaze_sapling.get(), 
										NORMAL_LEAVES_SAPLING_CHANCES));
	}

	protected void dropCrops(ModCropsBlock cropBlock, Item primary_drop, ItemNameBlockItem seed_item, int max_age) {
		LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
				.hasBlockStateProperties(cropBlock)
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, max_age));
		this.add(cropBlock, this.createCropDrops(cropBlock, primary_drop, seed_item, lootitemcondition$builder));
	} // end CropDropTable()

	/**
	 * Used for blaze tree, same as droppingWithChancesAndSticks but adding in
	 * blaze_rod.
	 */
	protected LootTable.Builder createBlazeLeavesDrops(Block pOakLeavesBlock, Block pSaplingBlock, float... pChances) 
	{
		return this.createLeavesDrops(pOakLeavesBlock, pSaplingBlock, pChances)
				.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
						.add(this.applyExplosionCondition(pOakLeavesBlock, LootItem.lootTableItem(Items.BLAZE_ROD))
								.when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F,
										0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
	}

} // end class
