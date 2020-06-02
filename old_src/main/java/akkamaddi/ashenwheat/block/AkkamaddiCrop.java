package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.ModInfo;
import mcjty.lib.tools.ItemStackList;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * new common class used by various crops.
 * @author cyhiggin
 *
 */
abstract public class AkkamaddiCrop extends BlockCrops implements IGrowable 
{
	protected String modname = ModInfo.ID;
	protected float fertilityDividend = 25.0F;  // default: same as vanilla wheat.
	protected float minFertilityDivisor = 2.0F; // default: same as vanilla wheat (pre-1.8.9).
	protected static final int GROWN = 7; // metadata of a mature crop
	
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
	
    /**
     * Get the Item that this Block should drop when harvested.
     */
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ((Integer)state.getValue(AGE)).intValue() == GROWN ? this.getCrop() : this.getSeed();
    }

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockBush#getPlantType(net.minecraft.world.IBlockAccess, int, int, int)
	 */
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) 
	{
		return net.minecraftforge.common.EnumPlantType.Crop;
	}

	/**
	 * @param fd the fertilityDividend to set
	 */
	public void setFertilityDividend(float fd) {
		this.fertilityDividend = fd;
	}
	
	/**
	 * @param minFertilityDivisor the minFertilityDivisor to set
	 */
	public void setMinFertilityDivisor(float minFertilityDivisor) {
		this.minFertilityDivisor = minFertilityDivisor;
	}


    @Override
    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, 
    										  BlockPos pos, IBlockState state, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
		return getDrops(state, fortune, rand);
    }
    
    /**
     * if crop is mature, return 1 fruit plus a number of seeds; if not mature, return seed.
     * Overrideable.
     * 
     * @param state current block state (obtain AGE from this)
     * @param fortune fortune mod to apply
     * @param rand current RNG.
     * @return list of drops.
     */
 	public ItemStackList getDrops(IBlockState state, int fortune, Random rand) 
	{
		ItemStackList ret = ItemStackList.create();

		if ( ((Integer)state.getValue(AGE)).intValue() >= GROWN) 
		{
			int ndrops = getNumberDrops(fortune, rand);
			ret.add( new ItemStack(getCrop(), 1, 0 ));
			ret.add( new ItemStack(getSeed(), ndrops, 0 ));
		}
		else {
			ret.add( new ItemStack(this.getSeed(), 1));
		}
		return ret;
	}

	/**
	 * Drops are a function of age, luck, and fortune modifier
	 * @param fortune fortune mod
	 * @param rand RNG
	 * @return number of drops
	 */
	public int getNumberDrops(int fortune, Random rand) 
	{
		int ndrops = 0;
		for (int i = 0; i < 3 + fortune; ++i) {
			if (rand.nextInt(15) <= GROWN) {
				ndrops++;
			}
		}
		if (fortune > 0) {
			ndrops = Math.max(ndrops, 1);
		}
		return ndrops;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockCrops#updateTick(net.minecraft.world.World, int, int, int, java.util.Random)
	 */
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		this.checkAndDropBlock(worldIn, pos, state);

        if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
        {
            int i = this.getAge(state);

            if (i < this.getMaxAge())
            {
                float f = getGrowthChance(this, worldIn, pos);
                f = Math.max(f, minFertilityDivisor);
                
                if (rand.nextInt((int)(fertilityDividend / f) + 1) == 0)
                {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                }
            }
        }
    }  // end updateTick()

} // end class AkkamaddiCrop
