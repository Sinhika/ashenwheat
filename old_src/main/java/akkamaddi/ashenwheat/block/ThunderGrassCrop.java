package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.Content;
import akkamaddi.ashenwheat.ModInfo;
import akkamaddi.ashenwheat.handler.ConfigHandler;
import mcjty.lib.tools.ItemStackList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThunderGrassCrop extends AkkamaddiCrop
{
	private final String name = "thundergrass";
	
    public ThunderGrassCrop()
    {
    	super();
    	setLightLevel(0.45F);
    	setFertilityDividend(50.0F);
    	setMinFertilityDivisor(5.00F);  // doesn't mind having neighbors
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
	protected Item getSeed() {
		return Content.thunderSeeds;
	}


	/* (non-Javadoc)
	 * @see akkamaddi.ashenwheat.code.AkkamaddiCrop#func_149865_P()
	 */
	@Override
	protected Item getCrop() {
		return Content.thunderSeeds;
	}

	@Override
	public ItemStackList getDrops(IBlockState state, int fortune, Random rand) 
	{
		ItemStackList ret = ItemStackList.create();
		int metadata = ((Integer)state.getValue(AGE)).intValue();
		if (metadata >= GROWN) {
			int ndrops = this.getNumberDrops(fortune, rand);
			ret.add(new ItemStack(getSeed(), ndrops, 0));
		} else {
			ret.add(new ItemStack(this.getSeed(), 1));
		}
		return ret;
	}

	@Override
	public int getNumberDrops(int fortune, Random rand) 
	{
		int ndrops = 1;
		for (int i = 0; i < 3 + fortune; ++i) {
			if (rand.nextInt(15) <= GROWN) {
				ndrops++;
			}
		}
		if (fortune > 0) {
			ndrops = Math.max(ndrops, 2);
		}
		return ndrops;
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if (ConfigHandler.MakeThunderGrassSmoke == true)
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
            		(double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
            		0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        }
    }
} // end class ThunderGrassCrop
