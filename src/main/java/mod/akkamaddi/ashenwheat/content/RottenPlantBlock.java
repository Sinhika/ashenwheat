package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.helpers.TagUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;

public class RottenPlantBlock extends ModCropsBlock
{
    @SuppressWarnings("hiding")
    public static final int MAX_AGE = 2;
    @SuppressWarnings("hiding")
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D) };

    public RottenPlantBlock(Properties builder)
    {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) 
    {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
     }

    @Override
    public int getMaxAge()
    {
        return RottenPlantBlock.MAX_AGE;
    }


    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos)
    {
        return PlantType.CAVE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos)
    {
        // rotten plant grows on stone in caves.
        return ForgeRegistries.BLOCKS.tags().getTag(TagUtils.modBlockTag("minecraft", "base_stone_overworld")).contains(pState.getBlock());
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand)
    {
        // rotten plant only grows in darkness on stone, but uses standard fertility formula.
        if (worldIn.getRawBrightness(pos, 0) < 2)
        {
            standardGrowthTick(state, worldIn, pos, rand);
        }
    } // end randomTick()

    @Override
    protected ItemLike getBaseSeedId()
    {
        return ModItems.rotten_seeds.get();
    }
    
    
} // end-class
