package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class CarvedOssidRoot extends HorizontalDirectionalBlock
{
    public CarvedOssidRoot(Properties builder)
    {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
     }

     @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
     }

     public boolean canEntitySpawn(BlockState state, BlockGetter worldIn, BlockPos pos, EntityType<?> type) 
     {
         return true;
     }
     
    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand)
    {
        if (! worldIn.isClientSide) return;
        if (AshenwheatConfig.MakeOssidLanternGloom 
            && ((stateIn.getBlock() == ModBlocks.carved_ossid_root.get())
                || (stateIn.getBlock() == ModBlocks.ossid_lantern.get())))
        {
            float f1 = (float) pos.getX() - 0.5F;
            float f2 = (float) pos.getY() - 0.5F;
            float f3 = (float) pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
            worldIn.addParticle(ParticleTypes.MYCELIUM, (double) (f1 + f4), (double) (f2 + f5), (double) (f3 + f6),
                    0.0D, 0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.UNDERWATER, (double) ((f1 + 0.3) + (f6 * 0.7)),
                    (double) ((f2 + 0.3) + (f4 * 0.7)), (double) ((f3 + 0.3) + (f5 * 0.7)), 0.0D, 0.0D, 0.0D);
        }
        super.animateTick(stateIn, worldIn, pos, rand);
    } // end animateTick()

} // end-class
