package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * Make one custom CropsBlock class for all the special crops in this mod.
 *
 */
public class ModCropsBlock extends CropsBlock
{
    protected static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

    protected float fertility_factor = 25.0F; // default for wheat.
    protected float min_f = 1.0F;             // default for wheat.
    
    public ModCropsBlock(Properties builder)
    {
        super(builder);
    }
    
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) 
    {
        return SHAPES[state.get(this.getAgeProperty())];
     }

    /**
     * Return the seed item for the corresponding block this actually is...
     */
    @Override
    protected IItemProvider getSeedsItem()
    {
        if (this == ModBlocks.ash_wheat_crop.get())
        {
            return ModItems.ash_seeds.get();
        }
        else if (this == ModBlocks.ossid_root_crop.get())
        {
            return ModItems.ossid_seeds.get();
        }
        else if (this == ModBlocks.scintilla_wheat_crop.get())
        {
            return ModItems.scintilla_seeds.get();
        }
        else if (this == ModBlocks.thunder_grass_crop.get())
        {
            return ModItems.thunder_seeds.get();
        }
        return super.getSeedsItem();
    } // getSeedsItems

    
    public float getFertility_factor()
    {
        return fertility_factor;
    }

    public float getMin_f()
    {
        return min_f;
    }

    public void setFertility_factor(float fertility_factor)
    {
        this.fertility_factor = fertility_factor;
    }

    public void setMin_f(float min_f)
    {
        this.min_f = min_f;
    }

    /**
     * display the random particle effect for this crop, whichever it is, if the
     * config allows.
     */
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (!worldIn.isRemote) return;

        if (AshenwheatConfig.MakeAshenwheatFlame && (stateIn.getBlock() == ModBlocks.ash_wheat_crop.get()))
        {
            float f1 = (float) pos.getX() + 0.5F;
            float f2 = (float) pos.getY() + 0.3F;
            float f3 = (float) pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.FLAME, (double) (f1 + f4), (double) (f2 + f4 + f5), (double) (f3 + f5),
                    0.0D, 0.0D, 0.0D);
        }
        else if (AshenwheatConfig.MakeOssidCropGloom && (stateIn.getBlock() == ModBlocks.ossid_root_crop.get()))
        {
            float f1 = (float) pos.getX() + 0.5F;
            float f2 = (float) pos.getY() + 0.3F;
            float f3 = (float) pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.MYCELIUM, (double) (f1 + f4), (double) (f2 + f4 + f5), (double) (f3 + f5),
                    0.0D, 0.0D, 0.0D);

        }
        else if (AshenwheatConfig.MakeScintillawheatScintillate
                && (stateIn.getBlock() == ModBlocks.scintilla_wheat_crop.get()))
        {
            float f1 = (float) pos.getX() + 0.5F;
            float f2 = (float) pos.getY() + 0.3F;
            float f3 = (float) pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.INSTANT_EFFECT, (double) (f1 + f4), (double) (f2 + f4 + f5),
                    (double) (f3 + f5), 0.0D, 0.0D, 0.0D);
        }
        else if (AshenwheatConfig.MakeThunderGrassSmoke && (stateIn.getBlock() == ModBlocks.thunder_grass_crop.get()))
        {
            float f1 = (float) pos.getX() + 0.5F;
            float f2 = (float) pos.getY() + 0.3F;
            float f3 = (float) pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.SMOKE, (double) (f1 + f4), (double) (f2 + f4 + f5), (double) (f3 + f5),
                    0.0D, 0.0D, 0.0D);

        }
        else
        {
            super.animateTick(stateIn, worldIn, pos, rand);
        }
    } // end animateTick()

    
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
    {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's
                                                   // light
        if (worldIn.getLightSubtracted(pos, 0) >= 9)
        {
            int i = this.getAge(state);
            if (i < this.getMaxAge())
            {
                float f = getModGrowthChance(this, worldIn, pos, min_f);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,
                        rand.nextInt((int) (fertility_factor / f ) + 1) == 0))
                {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            } // end-if < max age
        } // end-if light >= 9
    } // end tick()

    /**
     * 
     * @param blockIn
     * @param worldIn
     * @param pos
     * @return
     */
    protected static float getModGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos,
                                              float minf)
    {
        float f = 1.0F;
        BlockPos blockpos = pos.down();

        for (int i = -1; i <= 1; ++i)
        {
            for (int j = -1; j <= 1; ++j)
            {
                float f1 = 0.0F;
                BlockState blockstate = worldIn.getBlockState(blockpos.add(i, 0, j));
                if (blockstate.canSustainPlant(worldIn, blockpos.add(i, 0, j), net.minecraft.util.Direction.UP,
                        (net.minecraftforge.common.IPlantable) blockIn))
                {
                    f1 = 1.0F;
                    if (blockstate.isFertile(worldIn, blockpos.add(i, 0, j)))
                    {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock()
                || blockIn == worldIn.getBlockState(blockpos4).getBlock();
        boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock()
                || blockIn == worldIn.getBlockState(blockpos2).getBlock();
        if (flag && flag1)
        {
            f /= 2.0F;
        }
        else
        {
            boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock()
                    || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock()
                    || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock()
                    || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();
            if (flag2)
            {
                f /= 2.0F;
            }
        }
        f = Math.max(f, minf);
        return f;
    } // getModGrowthChance()
    
} // end class
