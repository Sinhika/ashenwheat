package akkamaddi.ashenwheat.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.Content;
import akkamaddi.ashenwheat.ModInfo;
import akkamaddi.ashenwheat.handler.ConfigHandler;

public class OssidRootCrop extends AkkamaddiCrop
{
	private final String name = "ossidvine";
	
    public OssidRootCrop()
    {
    	super();
    	setFertilityDividend(28.0F);
        setTickRandomly(true);
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
        GameRegistry.register(this);
    }

    public String getName()
    {
    	return name;
    }
    
     
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if (ConfigHandler.MakeOssidCropGloom == true)
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle(EnumParticleTypes.TOWN_AURA, 
            					(double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
            					0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        }
    } // end randomDisplayTick()

	@Override
	protected Item getSeed() {
        return Content.ossidSeeds;
	}

	@Override
	protected Item getCrop() {
			return Item.getItemFromBlock(Content.ossidRoot);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(IBlockState state, int fortune, Random rand) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int metadata = ((Integer)state.getValue(AGE)).intValue();
		if (metadata >= GROWN) {
			int ndrops = this.getNumberDrops(fortune, rand);
			ret.add(new ItemStack(getCrop(), ndrops, 0));
		} else {
			ret.add(new ItemStack(this.getSeed(), 1));
		}
		return ret;
	} // end ()

	@Override
	public int getNumberDrops(int fortune, Random rand) {
		int ndrops = 1;
		for (int i = 0; i < fortune; ++i) {
			if (rand.nextInt(15) <= GROWN) {
				ndrops++;
			}
		}
		return ndrops;
	} // end ()
   

} // end class OssidRootCrop
