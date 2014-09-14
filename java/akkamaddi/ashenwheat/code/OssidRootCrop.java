package akkamaddi.ashenwheat.code;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OssidRootCrop extends BlockStem
{
//    public static Icon ossidRootIcon_00;
//    public static Icon ossidRootIcon_01;
//    public static Icon ossidRootIcon_02;
//    public static Icon ossidRootIcon_03;
//    public static Icon ossidRootIcon_04;
//    public static Icon ossidRootIcon_05;
//    public static Icon ossidRootIcon_06;
//    public static Icon ossidRootIcon_07;
	private Block fruit;
	
    public OssidRootCrop(Block gourd)
    {
    	super(gourd);
    	fruit = gourd;
    	setBlockName("ossidVine");
//    	setBlockTextureName("ashenwheat:ossidVine");
    	setBlockTextureName("pumpkin_stem");
     	// setMinFertilityDivisor(6.36F);
    	// setFertilityDividend(70.0F);
    }

//    public void registerIcons(IIconRegister ir)
//    {
//        ossidRootIcon_00 = ir.registerIcon("ashenwheat:ossidVine_00");
//        ossidRootIcon_01 = ir.registerIcon("ashenwheat:ossidVine_01");
//        ossidRootIcon_02 = ir.registerIcon("ashenwheat:ossidVine_02");
//        ossidRootIcon_03 = ir.registerIcon("ashenwheat:ossidVine_03");
//        ossidRootIcon_04 = ir.registerIcon("ashenwheat:ossidVine_04");
//        ossidRootIcon_05 = ir.registerIcon("ashenwheat:ossidVine_05");
//        ossidRootIcon_06 = ir.registerIcon("ashenwheat:ossidVine_06");
//        ossidRootIcon_07 = ir.registerIcon("ashenwheat:ossidVine_07");
//    }

//    @Override
//    public void updateTick(World world, int x, int y, int z, Random random)
//    {
//        if (world.getBlockMetadata(x, y, z) >= 7)
//        {
//            return;
//        }
//
//        if (world.getBlockLightValue(x, y + 1, z) < 9)
//        {
//            return;
//        }
//
//        if (random.nextInt(isFertile(world, x, y - 1, z) ? 8 : 12) != 1)
//        {
//            return;
//        }
//
//        int meta = world.getBlockMetadata(x, y, z);
//        meta++;
//        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
//     } // end updateTick()

    /**
     * Generate a seed ItemStack for this crop.
     */
    protected Item getSeedItem()
    {
        return AshenWheatCore.ossidSeeds;
    }

    /**
     * Generate a crop produce ItemStack for this crop.
     */
    protected Block getCropItem()
    {
        return fruit;
    }
     
    /* (non-Javadoc)
	 * @see net.minecraft.block.BlockStem#getItem(net.minecraft.world.World, int, int, int)
	 */
    @SideOnly(Side.CLIENT)
	@Override
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) 
    {
    	return getSeedItem();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.BlockStem#getDrops(net.minecraft.world.World, int, int, int, int, int)
	 */
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z,
			int meta, int fortune) 
	{
	       ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

	        Item item = getSeedItem();

	        for (int i = 0; item != null && i < 3; i++)
	        {
	            if (world.rand.nextInt(15) <= meta)
	                ret.add(new ItemStack(item));
	        }
	        return ret;
	}

	@SideOnly(Side.CLIENT)
	@Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (AshenWheatCore.MakeOssidCropGloom == true)
        {
            float f1 = (float)x + 0.5F;
            float f2 = (float)y + 0.3F;
            float f3 = (float)z + 0.5F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            float f5 = random.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle("townaura", (double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 0.0D, 0.0D, 0.0D);
            // world.spawnParticle("flame", (double)(f1+f4), (double)(f2+f4+f5) , (double)(f3+f5), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        }
    } // end randomDisplayTick()
   
} // end class OssidRootCrop
