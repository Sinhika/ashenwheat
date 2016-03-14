package akkamaddi.ashenwheat.code;

import static net.minecraftforge.common.EnumPlantType.Crop;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * new common class used by various crops.
 * @author Sinhika
 *
 */
abstract public class AkkamaddiCrop extends BlockCrops implements IGrowable 
{
	protected String modname = "ashenwheat";
	protected IIcon[] iIcon = new IIcon[8];
	protected float fertilityDividend = 25.0F;  // default: same as vanilla wheat.
	protected float minFertilityDivisor = 2.0F; // default: same as vanilla wheat.
	protected static final int GROWN = 7;       // metadata of a mature crop
	
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
	 * @see net.minecraft.block.BlockCrops#getItemDropped(int, java.util.Random, int)
	 */
	@Override
	public Item getItemDropped(int meta, Random r, int fortune) 
	{
        return ((meta >= GROWN) ? this.func_149865_P() : this.func_149866_i());
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockBush#getPlantType(net.minecraft.world.IBlockAccess, int, int, int)
	 */
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return Crop;
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
	abstract protected Item func_149866_i();

	@Override
    abstract protected Item func_149865_P();

	/** wrapper for obfuscated function func_149866_i() */
	public Item getSeedItem()
	{
		return func_149866_i();
	}

	/** wrapper for obfuscated function func_149865_P() */
	public Item getCropItem()
	{
		return func_149865_P();
	}
	
    /**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int parSide, int parGrowthStage) 
	{
		if (parGrowthStage < 0 || parGrowthStage > GROWN) {
			parGrowthStage = GROWN;
		}
		return iIcon[parGrowthStage];
	}

 	/*
	 * Need to implement the IGrowable interface methods
	 */
	/**
	 * func_149851_a() aka canFertilize()
	 * returns true if bonemeal is allowed, false otherwise
	 * 
	 * @see
	 * net.minecraft.block.IGrowable#func_149851_a(net.minecraft.world.World,
	 * int, int, int, boolean)
	 */
	// BlockCrops method fine //

	/**
	 * func_149852_a() aka shouldFertilize()
	 * returns true at the same time bonemeal is used if conditions for a
	 * growth-tick are acceptable
	 * 
	 * @see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World,
	 *      java.util.Random, int, int, int)
	 */
	// BlockCrops method fine //
	
	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockCrops#getDrops(net.minecraft.world.World, int, int, int, int, int)
	 * 
	 * override to force at least one item dropped.
	 */
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int metadata, int fortune) 
	{
		return getDrops(metadata, fortune, world.rand);
	} // end getDrops()

	public ArrayList<ItemStack> getDrops(int metadata, int fortune, Random rand) 
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		if (metadata >= GROWN) {
			int ndrops = getNumberDrops(fortune, rand);
			ret.add( new ItemStack(getCropItem(), 1, 0 ));
			ret.add( new ItemStack(getSeedItem(), ndrops, 0 ));
		}
		else {
			ret.add( new ItemStack(this.getSeedItem(), 1));
		}
		return ret;
	}

	public int getNumberDrops(int fortune, Random rand) 
	{
		int ndrops = 0;
        for (int i = 0; i < 3 + fortune; ++i)
        {
            if (rand.nextInt(15) <= GROWN)
            {
                ndrops++;
            }
        }
        if (fortune > 0) {
        	ndrops = Math.max(ndrops, 1);
        }
		return ndrops;
	}

	/**
	 * fertilize()
	 * processes the actual growth-tick logic, which is usually increasing
	 * metadata or replacing the block.
	 * 
	 * @see 
	 *      net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World
	 *      , * java.util.Random, int, int, int)
	 */
	@Override
	public void func_149853_b(World parWorld, Random parRand, int parX,
							  int parY, int parZ) 
	{
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ)
				+ MathHelper.getRandomIntegerInRange(parRand, 2, 5);

		if (growStage > GROWN) {
			growStage = GROWN;
		}
		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	} // end fertilize()

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockCrops#registerBlockIcons(net.minecraft.client.renderer.texture.IIconRegister)
	 */
	@Override
	public void registerBlockIcons(IIconRegister ir) 
	{
		String stem = modname + ":" + (this.getUnlocalizedName().substring(5)) + "_0";
		for (int i=0; i < this.iIcon.length; i++) {
			this.iIcon[i] = ir.registerIcon(stem + String.valueOf(i));
		} // end-for
	} // end registerBlockIcons()

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockCrops#updateTick(net.minecraft.world.World, int, int, int, java.util.Random)
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random r) 
	{
		this.checkAndDropBlock(world, x, y, z);
		 
        if (world.getBlockLightValue(x, y + 1, z) < 9)
        {
            return;
        }
        
        int meta = world.getBlockMetadata(x, y, z);
        if (meta >= GROWN)
        {
            return;
        }

        float f = getNeighborFertilityDivisor(world, x, y, z);
        if (r.nextInt((int)(fertilityDividend / f) + 1) == 0)
        {
        	meta++;
        	world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        }

 	} // end updateTick()

	/** find neighboring fertility divisor for growth rate. Used in updateTick().
	 * Based on BlockCrops.func_149864_n().  */
	protected float getNeighborFertilityDivisor(World world, int x, int y, int z) 
	{
		float f = 1.0F;
	    Block [] neighbors = new Block[8];
	    boolean [] flags = new boolean[3];
	    int ii, jj, kk;
	    
	    kk = 0;
	    for (ii = -1; ii < 2; ii++)
	    {
	    	for (jj = -1; jj < 2; jj++) 
	    	{
	    		float f1 = 0.0F;
	    		Block dirt = world.getBlock(x+ii, y-1, z+jj);
	    		if (dirt.canSustainPlant(world, x+ii, y-1, z+jj, ForgeDirection.UP, this))
	    		{
	    			f1 = 1.0F;
	    			if (dirt.isFertile(world, x+ii, y-1, z+jj)) {
	    				f1 = 3.0F;
	    			}
	    		}
	    		if (ii != 0 || jj != 0) {
	    			f1 /= 4.0F;
	    		}
	    		f += f1;
	    		
	    		if ((jj == ii) && (ii == 0)) continue;
	    		neighbors[kk] = world.getBlock(x+ii, y, z+jj);
	    		kk++;
	    	}
	    } // end-for
	    
	    flags[0] = neighbors[1] == this || neighbors[6] == this; // same column
	    flags[1] = neighbors[3] == this || neighbors[4] == this; // same row
	    flags[2] = neighbors[0] == this || neighbors[2] == this || neighbors[5] == this
	    		|| neighbors[7] == this;  // kitty-corner
	      
	    if (flags[2] || flags[0] && flags[1]) {
	    	f /= 2.0F;
	    }
	    if (f < minFertilityDivisor) {
	    	f = minFertilityDivisor;
	    }
	    return f;
	} // end getNeighborFertilityDivisor()
	
	
} // end class AkkamaddiCrop
