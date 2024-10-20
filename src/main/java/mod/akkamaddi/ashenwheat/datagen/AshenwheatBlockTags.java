package mod.akkamaddi.ashenwheat.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AshenwheatBlockTags extends MiningBlockTags
{

    public AshenwheatBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Ashenwheat.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider)
    {
         super.addTags(pProvider);
         registerMiscTags();
         registerLogTags();
         registerPlankBlockTags();
    }

    @Override protected void registerOreTags()
    {

    }


    private void registerPlankBlockTags()
    {
        this.tag(BlockTags.WOODEN_STAIRS)
            .add(ModBlocks.blazewood_stairs.get());
        this.tag(BlockTags.STAIRS)
            .add(ModBlocks.blazewood_stairs.get());
        
        this.tag(BlockTags.WOODEN_SLABS)
            .add(ModBlocks.blazewood_slab.get());
        this.tag(BlockTags.SLABS)
            .add(ModBlocks.blazewood_slab.get());
        
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
            .add(ModBlocks.blazewood_pressure_plate.get());
        this.tag(BlockTags.PRESSURE_PLATES)
            .add(ModBlocks.blazewood_pressure_plate.get());
        
        this.tag(BlockTags.WOODEN_BUTTONS)
            .add(ModBlocks.blazewood_button.get());
        this.tag(BlockTags.BUTTONS)
            .add(ModBlocks.blazewood_button.get());
        
        
        this.tag(Tags.Blocks.FENCES_WOODEN)
            .add(ModBlocks.blazewood_fence.get());
        this.tag(BlockTags.WOODEN_FENCES)
            .add(ModBlocks.blazewood_fence.get());
        this.tag(Tags.Blocks.FENCES)
            .add(ModBlocks.blazewood_fence.get());
        this.tag(BlockTags.FENCES)
            .add(ModBlocks.blazewood_fence.get());
        
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN)
            .add(ModBlocks.blazewood_fence_gate.get());
        this.tag(Tags.Blocks.FENCE_GATES)
            .add(ModBlocks.blazewood_fence_gate.get());
        this.tag(BlockTags.FENCE_GATES)
            .add(ModBlocks.blazewood_fence_gate.get());
    } // end registerPlankBlockTags()
    
    @Override
    protected void registerMiningTags()
    {
        // ender clams are tough and require a stone or better pickaxe to open without smashing the ender pearl inside.
        registerMineableTags(List.of(ModBlocks.ender_clam.get()), List.of(ModBlocks.ender_clam.get()), List.of(), List.of(), List.of());
        // no tool requirement, but it's faster to shovel buried remains.
        registerShovelableTags(List.of(ModBlocks.buried_remains.get()));
        // wood blocks already included via the minecraft logs/plnks/etc tags.
     }

    protected void registerLogTags()
    {
        this.tag(TagUtils.modBlockTag(Ashenwheat.MODID, "blaze_logs"))
            .add(ModBlocks.blaze_log.get())
            .add(ModBlocks.blaze_wood.get())
            .add(ModBlocks.stripped_blaze_log.get())
            .add(ModBlocks.stripped_blaze_wood.get());
        
        this.tag(BlockTags.PLANKS)
            .add(ModBlocks.blazewood_planks.get());

        this.tag(BlockTags.LEAVES)
            .add(ModBlocks.blaze_leaves.get());
        
        this.tag(BlockTags.SAPLINGS)
            .add(ModBlocks.blaze_sapling.get());

        this.tag(BlockTags.LOGS)
            .addTag(TagUtils.modBlockTag(Ashenwheat.MODID, "blaze_logs"));
   
   } // end registerLogTags()
    
    protected void registerMiscTags()
    {
        this.tag(BlockTags.CROPS)
            .add(ModBlocks.ash_wheat_crop.get())
            .add(ModBlocks.flax_crop.get())
            .add(ModBlocks.ossid_root_crop.get())
            .add(ModBlocks.scintilla_wheat_crop.get())
            .add(ModBlocks.thunder_grass_crop.get())
            .add(ModBlocks.rotten_crop.get())
            .add(ModBlocks.flax_crop.get());

        this.tag(BlockTags.MAINTAINS_FARMLAND)
	        .add(ModBlocks.ash_wheat_crop.get())
	        .add(ModBlocks.flax_crop.get())
	        .add(ModBlocks.ossid_root_crop.get())
	        .add(ModBlocks.scintilla_wheat_crop.get())
	        .add(ModBlocks.thunder_grass_crop.get())
	        .add(ModBlocks.flax_crop.get());

    } // end registerMiscTags()
    
} // end class
