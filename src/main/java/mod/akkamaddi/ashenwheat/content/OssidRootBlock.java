package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class OssidRootBlock extends ModHayBlock
{

    public OssidRootBlock(Properties properties)
    {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
            InteractionHand handIn, BlockHitResult hit)
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
                worldIn.playSound((Player) null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F,
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
            return InteractionResult.SUCCESS;
        }
        else
        {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
    } // end onBlockActivated()


} // end class
