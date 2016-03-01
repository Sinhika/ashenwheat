package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.AshenWheatCore;

public class OssidRootCrop extends AkkamaddiCrop
{
	
    public OssidRootCrop()
    {
    	super();
    	setBlockName("ossidVine");
    	setBlockTextureName("ashenwheat:ossidVine_00");
     	setMinFertilityDivisor(6.36F);
    	setFertilityDividend(70.0F);
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

	@Override
	protected Item func_149866_i() {
        return AshenWheatCore.ossidSeeds;
	}

	@Override
	protected Item func_149865_P() {
			return Item.getItemFromBlock(AshenWheatCore.ossidRoot);
	}
   

} // end class OssidRootCrop
