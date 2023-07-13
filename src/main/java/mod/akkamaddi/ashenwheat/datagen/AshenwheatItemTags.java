package mod.akkamaddi.ashenwheat.datagen;

import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

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
        
        this.tag(TagUtils.modTag("minecraft", "non_flammable_wood"))
            .add(ModBlocks.blaze_log.get().asItem())
            .add(ModBlocks.blaze_wood.get().asItem())
            .add(ModBlocks.stripped_blaze_log.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "planks"))
            .add(ModBlocks.blazewood_planks.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "leaves"))
            .add(ModBlocks.blaze_leaves.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "saplings"))
            .add(ModBlocks.blaze_sapling.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "logs"))
            .addTag(TagUtils.modTag(Ashenwheat.MODID, "blaze_logs"));
   
   } // end registerLogTags()
  
} // end class
