package mod.akkamaddi.ashenwheat.datagen;

import java.util.Collection;
import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatBlockTags extends MiningBlockTags
{

    public AshenwheatBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, Ashenwheat.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
         super.addTags();
         registerMiscTags();
         registerLogTags();
    }

    
    @Override
    protected void registerMiningTags()
    {
        // ender clams are tough and require a stone or better pickaxe to open without smashing the ender pearl inside.
        registerMineableTags(List.of(ModBlocks.ender_clam.get()), List.of(ModBlocks.ender_clam.get()), List.of(), List.of(), List.of());
        // no tool requirement, but it's faster to shovel buried remains.
        registerShovelableTags(List.of(ModBlocks.buried_remains.get()), List.of(), List.of(), List.of(),List.of());
        // wood blocks already included via the minecraft logs/plnks/etc tags.
     }

    protected void registerLogTags()
    {
        this.tag(TagUtils.modBlockTag(Ashenwheat.MODID, "blaze_logs"))
            .add(ModBlocks.blaze_log.get())
            .add(ModBlocks.blaze_wood.get())
            .add(ModBlocks.stripped_blaze_log.get())
            .add(ModBlocks.stripped_blaze_wood.get());
        
        this.tag(TagUtils.modBlockTag("minecraft", "non_flammable_wood"))
            .add(ModBlocks.blaze_log.get())
            .add(ModBlocks.blaze_wood.get())
            .add(ModBlocks.stripped_blaze_log.get());
        
        this.tag(TagUtils.modBlockTag("minecraft", "planks"))
            .add(ModBlocks.blaze_planks.get());
        
        this.tag(TagUtils.modBlockTag("minecraft", "leaves"))
            .add(ModBlocks.blaze_leaves.get());
        
        this.tag(TagUtils.modBlockTag("minecraft", "saplings"))
            .add(ModBlocks.blaze_sapling_block.get());
        
        this.tag(TagUtils.modBlockTag("minecraft", "logs"))
            .addTag(TagUtils.modBlockTag(Ashenwheat.MODID, "blaze_logs"));
   
   } // end registerLogTags()
    
    protected void registerMiscTags()
    {
        this.tag(TagUtils.modBlockTag("minecraft", "crops"))
            .add(ModBlocks.ash_wheat_crop.get())
            .add(ModBlocks.flax_crop.get())
            .add(ModBlocks.ossid_root_crop.get())
            .add(ModBlocks.scintilla_wheat_crop.get())
            .add(ModBlocks.thunder_grass_crop.get())
            .add(ModBlocks.rotten_crop.get())
            .add(ModBlocks.flax_crop.get());
    } // end registerMiscTags()
    
    
    /**
     * As registerMineableTags(), but for axe-harvestable things like logs.
     * TODO: move to SimpleCoreLib in 1.19.
     * 
     * @param blocks - all the blocks that go under the mineable/axe tag.
     * @param stone_blocks  blocks that require a stone axe to harvest.
     * @param iron_blocks  blocks that require an iron axe to harvest.
     * @param diamond_blocks  blocks that require a diamond axe to harvest.
     * @param netherite_blocks blocks that require a netherite axe to harvest. (Forge tag only)
     */
    protected void registerAxeableTags(Collection<Block> blocks,
            Collection<Block> stone_blocks, Collection<Block> iron_blocks, 
            Collection<Block> diamond_blocks, Collection<Block> netherite_blocks)
    {
        TagsProvider.TagAppender<Block> foo = this.tag(TagUtils.modBlockTag("minecraft", "mineable/axe"));
        blocks.stream().forEach(b -> foo.add(b));
        
        if (stone_blocks != null && !stone_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> stone = this.tag(TagUtils.modBlockTag("minecraft", "needs_stone_tool"));
            stone_blocks.stream().forEach(b -> stone.add(b));
        }
        if (iron_blocks != null && !iron_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> iron = this.tag(TagUtils.modBlockTag("minecraft", "needs_iron_tool"));
            iron_blocks.stream().forEach(b -> iron.add(b));
        }
        if (diamond_blocks != null && !diamond_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> diamond = this.tag(TagUtils.modBlockTag("minecraft", "needs_diamond_tool"));
            diamond_blocks.stream().forEach(b -> diamond.add(b));
        }
        // NOTE: needs_netherite_tool is a FORGE tag, not a vanilla Minecraft tag.
        if (netherite_blocks != null && !netherite_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> netherite = this.tag(TagUtils.forgeBlockTag("needs_netherite_tool"));
            netherite_blocks.stream().forEach(b -> netherite.add(b));
        }
    } // end registerAxeableTags()
    
    /**
     * As registerMineableTags(), but for shovel-diggable things like dirts.
     * TODO: move to SimpleCoreLib in 1.19.
     * 
     * @param blocks - all the blocks that go under the mineable/shovel tag.
     * @param stone_blocks  blocks that require a stone shovel to dig.
     * @param iron_blocks  blocks that require an iron shovel to dig.
     * @param diamond_blocks  blocks that require a diamond shovel to dig.
     * @param netherite_blocks blocks that require a netherite shovel to dig. (Forge tag only)
     */
    protected void registerShovelableTags(Collection<Block> blocks,
            Collection<Block> stone_blocks, Collection<Block> iron_blocks, 
            Collection<Block> diamond_blocks, Collection<Block> netherite_blocks)
    {
        TagsProvider.TagAppender<Block> foo = this.tag(TagUtils.modBlockTag("minecraft", "mineable/shovel"));
        blocks.stream().forEach(b -> foo.add(b));
        
        if (stone_blocks != null && !stone_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> stone = this.tag(TagUtils.modBlockTag("minecraft", "needs_stone_tool"));
            stone_blocks.stream().forEach(b -> stone.add(b));
        }
        if (iron_blocks != null && !iron_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> iron = this.tag(TagUtils.modBlockTag("minecraft", "needs_iron_tool"));
            iron_blocks.stream().forEach(b -> iron.add(b));
        }
        if (diamond_blocks != null && !diamond_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> diamond = this.tag(TagUtils.modBlockTag("minecraft", "needs_diamond_tool"));
            diamond_blocks.stream().forEach(b -> diamond.add(b));
        }
        // NOTE: needs_netherite_tool is a FORGE tag, not a vanilla Minecraft tag.
        if (netherite_blocks != null && !netherite_blocks.isEmpty()) {
            TagsProvider.TagAppender<Block> netherite = this.tag(TagUtils.forgeBlockTag("needs_netherite_tool"));
            netherite_blocks.stream().forEach(b -> netherite.add(b));
        }
    } // end registerAxeableTags()
    
    
} // end class
