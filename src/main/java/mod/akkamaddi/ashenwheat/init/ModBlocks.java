package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.BlazeLogBlock;
import mod.akkamaddi.ashenwheat.content.BlazeSaplingBlock;
import mod.akkamaddi.ashenwheat.content.BlazeWoodBlock;
import mod.akkamaddi.ashenwheat.content.CarvedOssidRoot;
import mod.akkamaddi.ashenwheat.content.EnderClamBlock;
import mod.akkamaddi.ashenwheat.content.FlaxCropBlock;
import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.content.ModHayBlock;
import mod.akkamaddi.ashenwheat.content.OssidRootBlock;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.akkamaddi.ashenwheat.world.BlazeTreeGrower;
import mod.alexndr.simplecorelib.api.content.MultifunctionPressurePlateBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, Ashenwheat.MODID);

    // Ashenwheat blocks
    public static final RegistryObject<ModCropsBlock> ash_wheat_crop = BLOCKS.register("ash_wheat_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_RED)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<ModHayBlock> ash_wheat_bale = BLOCKS.register("ash_wheat_bale", 
            () -> new ModHayBlock(Block.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_RED)
                            .strength(0.5F).sound(SoundType.GRASS)));
    
    // Scintillawheat blocks
    public static final RegistryObject<ModCropsBlock> scintilla_wheat_crop = BLOCKS.register("scintilla_wheat_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.SAND)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<ModHayBlock> scintilla_wheat_bale = BLOCKS.register("scintilla_wheat_bale", 
            () -> new ModHayBlock(Block.Properties.of(Material.GRASS, MaterialColor.SAND)
                            .strength(0.5F).sound(SoundType.GRASS)));
    
    // Ossidroot blocks
    public static final RegistryObject<ModCropsBlock> ossid_root_crop = BLOCKS.register("ossid_root_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<OssidRootBlock> ossid_root = BLOCKS.register("ossid_root", 
            () -> new OssidRootBlock(Block.Properties.of(Material.VEGETABLE, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<CarvedOssidRoot> carved_ossid_root = BLOCKS.register("carved_ossid_root", 
            () -> new CarvedOssidRoot(Block.Properties.of(Material.VEGETABLE, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD)));
   public static final RegistryObject<CarvedOssidRoot> ossid_lantern = BLOCKS.register("ossid_lantern", 
            () -> new CarvedOssidRoot(Block.Properties.of(Material.VEGETABLE, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD)
                            .lightLevel(LightUtils.setFixedLight(15))));
    
    // Thundergrass blocks
    public static final RegistryObject<ModCropsBlock> thunder_grass_crop = BLOCKS.register("thunder_grass_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.COLOR_CYAN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));

    // Flax (crop) blocks
    public static final RegistryObject<FlaxCropBlock> flax_crop = BLOCKS.register("flax_crop", 
            ()-> new FlaxCropBlock(Block.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));
           
    // Rotten Plant (crop) blocks
    public static final RegistryObject<RottenPlantBlock> rotten_crop = BLOCKS.register("rotten_crop", 
            ()-> new RottenPlantBlock(Block.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS)));
    
    // Enderclam blocks
    public static final RegistryObject<EnderClamBlock> ender_clam = BLOCKS.register("ender_clam", 
            () -> new EnderClamBlock(BlockBehaviour.Properties.of(Material.SHULKER_SHELL, MaterialColor.COLOR_CYAN)
                    .strength(3.0F).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));
    
    // Buried Remains blocks
    public static final RegistryObject<DropExperienceBlock> buried_remains = BLOCKS.register("buried_remains",
            ()->new DropExperienceBlock(Block.Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_RED)
                    .strength(1.0F).sound(SoundType.SLIME_BLOCK)));

    // Blaze Tree blocks
    public static final RegistryObject<LeavesBlock> blaze_leaves = BLOCKS.register("blaze_leaves", 
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES, MaterialColor.COLOR_YELLOW).strength(0.2F).randomTicks()
                    .noOcclusion().sound(SoundType.GRASS).isSuffocating((a,b,c)->{return false;}).isViewBlocking((a,b,c)->{return false;})            
                    .lightLevel(LightUtils.setFixedLight(10))));
    public static final RegistryObject<BlazeLogBlock> blaze_log = BLOCKS.register("blaze_log", 
            () -> new BlazeLogBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, (a ) -> {
                return a.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_YELLOW : MaterialColor.PODZOL;
            }).strength(2.0F).sound(SoundType.WOOD)));
    
    // blaze WOOD - a block covered in bark on all sides.
    public static final RegistryObject<BlazeWoodBlock> blaze_wood = BLOCKS.register("blaze_wood",
            () -> new BlazeWoodBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.PODZOL)
                    .strength(2.0F).sound(SoundType.WOOD)));
    // stripped blaze log - a log with no bark.
    public static final RegistryObject<RotatedPillarBlock> stripped_blaze_log = BLOCKS.register("stripped_blaze_log", 
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_YELLOW)
                    .strength(2.0F).sound(SoundType.WOOD)));
    // stripped blaze wood - ??
    public static final RegistryObject<RotatedPillarBlock> stripped_blaze_wood = BLOCKS.register("stripped_blaze_wood", 
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_YELLOW)
                    .strength(2.0F).sound(SoundType.WOOD)));
    
    // sapling
    public static final RegistryObject<BlazeSaplingBlock> blaze_sapling = BLOCKS.register("blaze_sapling", 
            () -> new BlazeSaplingBlock(new BlazeTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission()
                    .randomTicks().instabreak().sound(SoundType.GRASS)));
    
    // blaze PLANKS
    public static final RegistryObject<Block> blazewood_planks = BLOCKS.register("blazewood_planks", 
            () -> new Block(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_YELLOW)
                    .strength(2.0F,3.0F).sound(SoundType.WOOD)));
    
    // blazewood plank Aesthetic blocks
    // blazewood stairs
    public static final RegistryObject<StairBlock> blazewood_stairs = BLOCKS.register("blazewood_stairs", 
            () -> new StairBlock( () -> blazewood_planks.get().defaultBlockState(),  Block.Properties.copy(blazewood_planks.get())));
    
    // blazewood slabs
    public static final RegistryObject<SlabBlock> blazewood_slab = BLOCKS.register("blazewood_slab", 
            () -> new SlabBlock(Block.Properties.copy(blazewood_planks.get())));
    
    // blazewood pressure plate
    public static final RegistryObject<MultifunctionPressurePlateBlock> blazewood_pressure_plate = BLOCKS.register("blazewood_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING, 20,
                    Block.Properties.of(Material.WOOD, MaterialColor.WOOD)
                    .noCollission().strength(0.5F).sound(SoundType.WOOD)));
            
    // blazewood button
    public static final RegistryObject<WoodButtonBlock> blazewood_button = BLOCKS.register("blazewood_button", 
            () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
            
    // blazewood fence
    public static final RegistryObject<FenceBlock> blazewood_fence = BLOCKS.register("blazewood_fence", 
            () -> new FenceBlock(Block.Properties.of(Material.WOOD, ModBlocks.blazewood_planks.get().defaultMaterialColor())
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));
       
    // blazewood fence gate
    public static final RegistryObject<FenceGateBlock> blazewood_fence_gate = BLOCKS.register("blazewood_fence_gate", 
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, ModBlocks.blazewood_planks.get().defaultMaterialColor())
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    // TODO blazewood sign
    // TODO blazewood door
    // TODO blazewood trapdoor
 } // end class
