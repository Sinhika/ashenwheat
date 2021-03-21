package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class CarvedOssidRoot extends HorizontalBlock
{
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public CarvedOssidRoot(Properties builder)
    {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
     }

     protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
     }

     public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) 
     {
         return true;
     }
     
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
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
