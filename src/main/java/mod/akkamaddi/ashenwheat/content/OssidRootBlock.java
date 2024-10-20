package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ToolActions;

public class OssidRootBlock extends ModHayBlock
{

    public OssidRootBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack itemstack, BlockState state, Level worldIn, BlockPos pos,
                                           Player player, InteractionHand handIn, BlockHitResult hit)
    {
        if (itemstack.canPerformAction(ToolActions.SHEARS_CARVE))
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
                itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(handIn));
                worldIn.gameEvent(player, GameEvent.SHEAR, pos);
                player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
                return ItemInteractionResult.sidedSuccess(worldIn.isClientSide);
            }
            else
            {
                return ItemInteractionResult.sidedSuccess(worldIn.isClientSide);
            }
        }
        else
        {
            return super.useItemOn(itemstack, state, worldIn, pos, player, handIn, hit);
        }
    } // end onBlockActivated()


} // end class
