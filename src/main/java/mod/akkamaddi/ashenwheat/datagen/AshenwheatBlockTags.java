package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningBlockTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
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

    protected void registerLogTags()
    {
        this.tag(TagUtils.modBlockTag("minecraft", "logs"))
            .add(ModBlocks.blaze_log.get());
    
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
    }
} // end class
