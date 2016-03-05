package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import akkamaddi.ashenwheat.ModInfo;

/**
 * new common class used by various crops.
 * @author cyhiggin
 *
 */
abstract public class AkkamaddiCrop extends BlockCrops implements IGrowable 
{
	protected String modname = ModInfo.ID;
	protected float fertilityDividend = 25.0F;  // default: same as vanilla wheat.
	
	public AkkamaddiCrop() 
	{
		super();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockCrops#quantityDropped(java.util.Random)
	 */
	@Override
	public int quantityDropped(Random p_149745_1_) 
	{
		return 1;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockBush#getPlantType(net.minecraft.world.IBlockAccess, int, int, int)
	 */
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return net.minecraftforge.common.EnumPlantType.Crop;
	}

	/**
	 * @param fd the fertilityDividend to set
	 */
	public void setFertilityDividend(float fd) {
		this.fertilityDividend = fd;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockCrops#updateTick(net.minecraft.world.World, int, int, int, java.util.Random)
	 */
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(worldIn, pos, state, rand);

        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = ((Integer)state.getValue(AGE)).intValue();

            if (i < 7)
            {
                float f = getGrowthChance(this, worldIn, pos);

                if (rand.nextInt((int)(fertilityDividend / f) + 1) == 0)
                {
                    worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
                }
            }
        }
    }  // end updateTick()

} // end class AkkamaddiCrop
