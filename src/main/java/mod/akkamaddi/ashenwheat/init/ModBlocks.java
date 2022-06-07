package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.CarvedOssidRoot;
import mod.akkamaddi.ashenwheat.content.EnderClamBlock;
import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.content.ModHayBlock;
import mod.akkamaddi.ashenwheat.content.OssidRootBlock;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
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
 
    // Blaze Tree blocks
    public static final RegistryObject<LeavesBlock> blaze_leaves = BLOCKS.register("blaze_leaves", 
            () -> new LeavesBlock(Block.Properties.of(Material.LEAVES, MaterialColor.COLOR_YELLOW).strength(0.2F).randomTicks()
                    .noOcclusion().sound(SoundType.GRASS).isSuffocating((a,b,c)->{return false;}).isViewBlocking((a,b,c)->{return false;})            
                    .lightLevel(LightUtils.setFixedLight(10))));
    public static final RegistryObject<RotatedPillarBlock> blaze_log = BLOCKS.register("blaze_log", 
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, (a ) -> {
                return a.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_YELLOW : MaterialColor.PODZOL;
            }).strength(2.0F).sound(SoundType.WOOD)));
    
    // blaze WOOD - a block covered in bark on all sides.
    public static final RegistryObject<RotatedPillarBlock> blaze_wood = BLOCKS.register("blaze_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.PODZOL)
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
    public static final RegistryObject<SaplingBlock> blaze_sapling_block = BLOCKS.register("blaze_sapling_block", 
            () -> new SaplingBlock(new BlazeTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission()
                    .randomTicks().instabreak().sound(SoundType.GRASS)));
    
    // blaze PLANKS
    public static final RegistryObject<Block> blaze_planks = BLOCKS.register("blaze_planks", 
            () -> new Block(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.COLOR_YELLOW)
                    .strength(2.0F,3.0F).sound(SoundType.WOOD)));
    
    // Flax (crop) blocks
    public static final RegistryObject<ModCropsBlock> flax_crop = BLOCKS.register("flax_crop", 
            ()-> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE)
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
    public static final RegistryObject<OreBlock> buried_remains = BLOCKS.register("buried_remains",
            ()->new OreBlock(Block.Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_RED)
                    .strength(1.0F).sound(SoundType.SLIME_BLOCK)));
} // end class
