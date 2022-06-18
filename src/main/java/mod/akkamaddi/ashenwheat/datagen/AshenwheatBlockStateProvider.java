package mod.akkamaddi.ashenwheat.datagen;

import java.util.ArrayList;
import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.DataGenerator;
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
        ModelFile buriedRemainsModel = this.models().cubeAll("buried_remains", modLoc("block/remains"));
        this.itemModels().withExistingParent("buried_remains", modLoc("block/buried_remains"));
        this.simpleBlock(ModBlocks.buried_remains.get(), new ConfiguredModel(buriedRemainsModel));
        
        registerTreeBlocks();
        registerCropBlocks();
        registerMisc();
    } // end registerStatesAndModels

    // tree blocks
    private void registerTreeBlocks()
    {
        // blaze_leaves
        ModelFile leaves = this.models().cubeAll("blaze_leaves", modLoc("block/blaze_leaves"));
        this.simpleBlock(ModBlocks.blaze_leaves.get(), leaves);
        this.itemModels().withExistingParent("blaze_leaves", modLoc("block/blaze_leaves"));

        // blaze log
        this.logBlock(ModBlocks.blaze_log.get());
        this.itemModels().withExistingParent("blaze_log", modLoc("block/blaze_log"));
        
        // blaze_wood - a block covered in bark on all sides.
        this.axisBlock(ModBlocks.blaze_wood.get(), modLoc("block/blaze_log"), modLoc("block/blaze_log"));
        this.itemModels().withExistingParent("blaze_wood", modLoc("block/blaze_wood"));
       
        // stripped_blaze_log - a log with no bark.
        this.logBlock(ModBlocks.stripped_blaze_log.get());
        this.itemModels().withExistingParent("stripped_blaze_log", modLoc("block/stripped_blaze_log"));
        
        // stripped_blaze_wood 
        this.axisBlock(ModBlocks.stripped_blaze_wood.get(), modLoc("block/stripped_blaze_log"), modLoc("block/stripped_blaze_log"));
        this.itemModels().withExistingParent("stripped_blaze_wood", modLoc("block/stripped_blaze_wood"));
        
        // blaze_planks
        ModelFile planks = this.models().cubeAll("blazewood_planks", modLoc("block/blaze_planks"));
        this.simpleBlock(ModBlocks.blazewood_planks.get(), planks);
        this.itemModels().withExistingParent("blazewood_planks", modLoc("block/blazewood_planks"));
        
        // blaze_sapling
        ModelFile sapling = this.models().cross("blaze_sapling", modLoc("block/blaze_sapling"));
        this.simpleBlock(ModBlocks.blaze_sapling.get(), sapling);
        // sapling item model handled elsewhere.
        
        // blazewood_pressure_plate
        ModelFile blazewoodPlateModel = this.models().pressurePlate("blazewood_plate",
                modLoc("block/blaze_planks"));
        ModelFile blazewoodPlateModel_down = this.models().pressurePlateDown("blazewood_plate_down",
                modLoc("block/blaze_planks"));
        this.itemModels().withExistingParent("blazewood_plate", modLoc("block/blazewood_plate"));
        this.buildWeightedPressurePlateBlockState(ModBlocks.blazewood_pressure_plate.get(), 
                blazewoodPlateModel, blazewoodPlateModel_down);
        
        // blazewood_slab
        this.slabBlock(ModBlocks.blazewood_slab.get(), modLoc("block/blazewood_planks"), modLoc("block/blaze_planks"));
        
        // blazewood_stairs
        this.stairsBlock(ModBlocks.blazewood_stairs.get(), modLoc("block/blaze_planks"));
        
    } // end registerTreeBlocks
    
    // Ender clam
    private void registerMisc()
    {
        ModelFile enderclam_model = this.models().orientableWithBottom("ender_clam", 
                modLoc("block/ender_clam_side"), 
                modLoc("block/ender_clam_front"), 
                modLoc("block/ender_clam_bottom"),
                modLoc("block/ender_clam_top"));
        this.horizontalBlock(ModBlocks.ender_clam.get(), enderclam_model);
        this.itemModels().withExistingParent("ender_clam", modLoc("block/ender_clam"));
    }
    
    // crop blocks
    private void registerCropBlocks()
    {
        // rotten plant/crop
        List<ModelFile> rp_models = new ArrayList<ModelFile>(2);
        for (int ii=0; ii < 2; ii ++)
        {
            rp_models.add(this.models().crop("rottenplant_0" + ii, modLoc("block/rottenplant_0" + ii)));
        } // end-for
        this.getVariantBuilder(ModBlocks.rotten_crop.get())
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 0).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 1).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 2).addModels(new ConfiguredModel(rp_models.get(1)));
        
        // flax
        List<ModelFile> flax_models = new ArrayList<ModelFile>(3);
        for (int ii=0; ii < 3; ii++)
        {
            flax_models.add(this.models().crop("flax_0" + ii, modLoc("block/flax_0" + ii)));
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
