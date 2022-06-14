package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

public class RottenPlantBlock extends ModCropsBlock
{
    public static final int ROTTEN_MAX_AGE = 2;
    public static final IntegerProperty ROTTEN_AGE = BlockStateProperties.AGE_2;
    
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] { 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), 
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D) };

    public RottenPlantBlock(Properties builder)
    {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(ROTTEN_AGE, Integer.valueOf(0)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) 
    {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
     }

    @Override
    public int getMaxAge()
    {
        return RottenPlantBlock.ROTTEN_MAX_AGE;
    }


    @Override
    public IntegerProperty getAgeProperty()
    {
        return RottenPlantBlock.ROTTEN_AGE;
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
        return pState.is(BlockTags.BASE_STONE_OVERWORLD);
    }

    
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        BlockPos blockpos = pPos.below();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        if (blockstate.is(BlockTags.BASE_STONE_OVERWORLD) && (pLevel.getRawBrightness(pPos, 0) < 13)) 
        {
            return true;
        }
        return false;
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
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) 
    {
        pBuilder.add(ROTTEN_AGE);
    }

} // end-class
