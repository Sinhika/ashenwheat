package mod.akkamaddi.ashenwheat.datagen;

import java.util.ArrayList;
import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatBlockStateProvider extends SimpleBlockStateProvider
{

    public AshenwheatBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Ashenwheat.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // simple models & blockstates
        ModelFile buriedRemainsModel = this.models().cubeAll("buried_remains", 
                                            new ResourceLocation(Ashenwheat.MODID, "block/remains"));
        this.itemModels().withExistingParent("buried_remains", new ResourceLocation(Ashenwheat.MODID, "block/buried_remains"));
        this.simpleBlock(ModBlocks.buried_remains.get(), new ConfiguredModel(buriedRemainsModel));
        
        registerTreeBlocks();
        registerCropBlocks();
        registerMisc();
    } // end registerStatesAndModels

    // TODO tree blocks
    private void registerTreeBlocks()
    {
        
    } // end registerTreeBlocks
    
    // Ender clam
    private void registerMisc()
    {
        ModelFile enderclam_model = this.models().orientableWithBottom("ender_clam", 
                new ResourceLocation(Ashenwheat.MODID, "block/ender_clam_side"), 
                new ResourceLocation(Ashenwheat.MODID, "block/ender_clam_front"), 
                new ResourceLocation(Ashenwheat.MODID, "block/ender_clam_bottom"),
                new ResourceLocation(Ashenwheat.MODID, "block/ender_clam_top"));
        this.horizontalBlock(ModBlocks.ender_clam.get(), enderclam_model);
        this.itemModels().withExistingParent("ender_clam", new ResourceLocation(Ashenwheat.MODID, "block/ender_clam"));
    }
    
    // crop blocks
    private void registerCropBlocks()
    {
        // rotten plant/crop
        List<ModelFile> rp_models = new ArrayList<ModelFile>(2);
        for (int ii=0; ii < 2; ii ++)
        {
            rp_models.add(this.models().crop("rottenplant_0" + ii, new ResourceLocation(Ashenwheat.MODID, "block/rottenplant_0" + ii)));
        } // end-for
        this.getVariantBuilder(ModBlocks.rotten_crop.get())
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 0).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 1).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 2).addModels(new ConfiguredModel(rp_models.get(1)));
        
        // TODO flax
        List<ModelFile> flax_models = new ArrayList<ModelFile>(3);
        for (int ii=0; ii < 3; ii++)
        {
            flax_models.add(this.models().crop("flax_0" + ii, new ResourceLocation(Ashenwheat.MODID, "block/flax_0" + ii)));
        } // end-for
        this.getVariantBuilder(ModBlocks.flax_crop.get())
            .partialState().with(CropBlock.AGE, 0).addModels(new ConfiguredModel(flax_models.get(0)))
            .partialState().with(CropBlock.AGE, 1).addModels(new ConfiguredModel(flax_models.get(0)))
            .partialState().with(CropBlock.AGE, 2).addModels(new ConfiguredModel(flax_models.get(0)))
            .partialState().with(CropBlock.AGE, 3).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 4).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 5).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 6).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 7).addModels(new ConfiguredModel(flax_models.get(2)));

    } // end registerCropBlocks
    
 
} // end class
