package akkamaddi.ashenwheat.code;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ThunderGrassCrop extends AkkamaddiCrop
{

    public ThunderGrassCrop()
    {
    	super();
    	setBlockName("thundergrass");
    	setBlockTextureName("ashenwheat:thundergrass_00");
    	setLightLevel(0.45F);
    	setMinFertilityDivisor(5.00F);  // doesn't mind having neighbors
    	setFertilityDividend(70.0F);    // slower-growing than ashenwheat
    }
 
     /* (non-Javadoc)
	 * @see akkamaddi.ashenwheat.code.AkkamaddiCrop#func_149866_i()
	 */
	@Override
	protected Item func_149866_i() {
		return AshenWheatCore.thunderSeeds;
	}

	/* (non-Javadoc)
	 * @see akkamaddi.ashenwheat.code.AkkamaddiCrop#func_149865_P()
	 */
	@Override
	protected Item func_149865_P() {
		return AshenWheatCore.thunderSeeds;
	}


	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (AshenWheatCore.MakeThunderGrassSmoke == true)
        {
            float f1 = (float)x + 0.5F;
            float f2 = (float)y + 0.3F;
            float f3 = (float)z + 0.5F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            float f5 = random.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle("smoke", (double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        }
    }
	
	@Override
	public ArrayList<ItemStack> getDrops(int metadata, int fortune, Random rand) 
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		if (metadata >= GROWN) {
			int ndrops = this.getNumberDrops(fortune, rand);
			ret.add( new ItemStack(getSeedItem(), ndrops, 0 ));
		}
		else {
			ret.add( new ItemStack(this.getSeedItem(), 1));
		}
		return ret;
	}

	@Override
	public int getNumberDrops(int fortune, Random rand) 
	{
		int ndrops = 1;
        for (int i = 0; i < 3 + fortune; ++i)
        {
            if (rand.nextInt(15) <= GROWN)
            {
                ndrops++;
            }
        }
        if (fortune > 0) {
        	ndrops = Math.max(ndrops, 2);
        }
		return ndrops;
	}

} // end class ThunderGrassCrop
