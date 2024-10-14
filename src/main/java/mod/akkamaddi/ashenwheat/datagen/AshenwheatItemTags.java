package mod.akkamaddi.ashenwheat.datagen;

import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AshenwheatItemTags extends MiningItemTags
{

    public AshenwheatItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, 
			CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, Ashenwheat.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider)
    {
        super.addTags(lookupProvider);
        registerLogTags();
        registerWoodPlankItems();
        registerMisc();
    }

    private void registerMisc()
    {
    	this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
    		.add(ModItems.ash_seeds.get())
    		.add(ModItems.scintilla_seeds.get())
    		.add(ModItems.flax_seed.get());
    }
    
    private void registerWoodPlankItems()
    {
        this.tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.blazewood_stairs.get().asItem());
        this.tag(ItemTags.STAIRS).add(ModBlocks.blazewood_stairs.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS).add(ModBlocks.blazewood_slab.get().asItem());
        this.tag(ItemTags.SLABS).add(ModBlocks.blazewood_slab.get().asItem());

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.blazewood_pressure_plate.get().asItem());

        this.tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.blazewood_button.get().asItem());
        this.tag(ItemTags.BUTTONS).add(ModBlocks.blazewood_button.get().asItem());

        this.tag(Tags.Items.FENCES_WOODEN).add(ModBlocks.blazewood_fence.get().asItem());
        this.tag(Tags.Items.FENCES).add(ModBlocks.blazewood_fence.get().asItem());

        this.tag(Tags.Items.FENCE_GATES_WOODEN).add(ModBlocks.blazewood_fence_gate.get().asItem());
        this.tag(Tags.Items.FENCE_GATES).add(ModBlocks.blazewood_fence_gate.get().asItem());
    }

    protected void registerLogTags()
    {
        this.tag(TagUtils.modTag(Ashenwheat.MODID, "blaze_logs"))
            .add(ModBlocks.blaze_log.get().asItem())
            .add(ModBlocks.blaze_wood.get().asItem())
            .add(ModBlocks.stripped_blaze_log.get().asItem())
            .add(ModBlocks.stripped_blaze_wood.get().asItem());
        
        this.tag(ItemTags.NON_FLAMMABLE_WOOD)
            .add(ModBlocks.blaze_log.get().asItem())
            .add(ModBlocks.blaze_wood.get().asItem())
            .add(ModBlocks.stripped_blaze_log.get().asItem());
        
        this.tag(ItemTags.PLANKS)
            .add(ModBlocks.blazewood_planks.get().asItem());
        
        this.tag(ItemTags.LEAVES)
            .add(ModBlocks.blaze_leaves.get().asItem());
        
        this.tag(ItemTags.SAPLINGS)
            .add(ModBlocks.blaze_sapling.get().asItem());
        
        this.tag(ItemTags.LOGS)
            .addTag(TagUtils.modTag(Ashenwheat.MODID, "blaze_logs"));
   
   } // end registerLogTags()
  
} // end class
