package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * new common class used by various crops.
 * @author Sinhika
 *
 */
public class AkkamaddiCrop extends BlockCrops implements IGrowable
{
	protected String name;
	protected float fertilityDividend = 25.0F;  // default: same as vanilla wheat.
	protected float minFertilityDivisor = 2.0F; // default: same as vanilla wheat (pre-1.8.9).
	protected static final int GROWN = 7; // metadata of a mature crop
	
	public AkkamaddiCrop(String name) 
	{
		super();
		this.name = name;
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
	} // end ctor()

	@Override
	public AkkamaddiCrop setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
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
	public int getMaxAge() {
		return GROWN;
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
	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, 
						net.minecraft.world.IBlockAccess world, 
						BlockPos pos, IBlockState state, int fortune)
	{
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;

        int count = quantityDropped(state, fortune, rand);
        for (int i = 0; i < count; i++)
        {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != Items.AIR)
            {
                drops.add(new ItemStack(item, 1, this.damageDropped(state)));
            }
        }
        int age = getAge(state);
        if (age >= getMaxAge())
        {
			int ndrops = getNumberDrops(fortune, rand, age);
			drops.add(new ItemStack(getSeed(), ndrops, 0 ));
        } //end-if
		
	} // end getDrops()

	/**
	 * Drops are a function of age, luck, and fortune modifier
	 * @param fortune fortune mod
	 * @param rand RNG
	 * @param age AGE property of state
	 * @return number of drops
	 */
	public int getNumberDrops(int fortune, Random rand, int age) 
	{
		int ndrops = 0;
		for (int i = 0; i < 3 + fortune; ++i) 
		{
			if (rand.nextInt(2 * getMaxAge()) <= age) 
			{
				ndrops++;
			}
		}
		if (fortune > 0) {
			ndrops = Math.max(ndrops, 1);
		}
		return ndrops;
	} // end getNumberDrops()

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
                
                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0))
                {
                    f = Math.max(f, minFertilityDivisor);
                    
                    if (rand.nextInt((int)(fertilityDividend / f) + 1) == 0)
                    {
                        worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, 
                        						pos, state, worldIn.getBlockState(pos));
                    }
                } // end-if
            } // end-if
        } // end-if
    }  // end updateTick()

} // end class AkkamaddiCrop
