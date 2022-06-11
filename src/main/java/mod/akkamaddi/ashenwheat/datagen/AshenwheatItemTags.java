package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatItemTags extends MiningItemTags
{

    public AshenwheatItemTags(DataGenerator gen,  ExistingFileHelper existingFileHelper)
    {
        super(gen, new AshenwheatBlockTags(gen, existingFileHelper), Ashenwheat.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        super.addTags();
        registerLogTags();
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
            .add(ModBlocks.blaze_planks.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "leaves"))
            .add(ModBlocks.blaze_leaves.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "saplings"))
            .add(ModBlocks.blaze_sapling.get().asItem());
        
        this.tag(TagUtils.modTag("minecraft", "logs"))
            .addTag(TagUtils.modTag(Ashenwheat.MODID, "blaze_logs"));
   
   } // end registerLogTags()
  
} // end class
