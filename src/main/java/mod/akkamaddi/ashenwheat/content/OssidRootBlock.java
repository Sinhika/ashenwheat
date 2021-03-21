package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class OssidRootBlock extends ModHayBlock
{

    public OssidRootBlock(Properties properties)
    {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit)
    {
        ItemStack itemstack = player.getItemInHand(handIn);
        if (itemstack.getItem() instanceof ShearsItem)
        {
            if (!worldIn.isClientSide)
            {
                Direction direction = hit.getDirection();
                Direction direction1 = direction.getAxis() == Direction.Axis.Y
                        ? player.getDirection().getOpposite()
                        : direction;
                worldIn.playSound((PlayerEntity) null, pos, SoundEvents.PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F,
                        1.0F);
                worldIn.setBlock(pos,
                        ModBlocks.carved_ossid_root.get().defaultBlockState().setValue(CarvedOssidRoot.FACING, direction1), 11);
                ItemEntity itementity = new ItemEntity(worldIn,
                        (double) pos.getX() + 0.5D + (double) direction1.getStepX() * 0.65D,
                        (double) pos.getY() + 0.1D,
                        (double) pos.getZ() + 0.5D + (double) direction1.getStepZ() * 0.65D,
                        new ItemStack(ModItems.ossid_seeds.get(), 4));
                itementity.setDeltaMovement(0.05D * (double) direction1.getStepX() + worldIn.random.nextDouble() * 0.02D,
                        0.05D, 0.05D * (double) direction1.getStepZ() + worldIn.random.nextDouble() * 0.02D);
                worldIn.addFreshEntity(itementity);
                itemstack.hurtAndBreak(1, player, (p_220282_1_) -> {
                    p_220282_1_.broadcastBreakEvent(handIn);
                });
            }
            return ActionResultType.SUCCESS;
        }
        else
        {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
    } // end onBlockActivated()


} // end class
