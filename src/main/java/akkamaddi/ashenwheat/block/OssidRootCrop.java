package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.ModBlocks;
import akkamaddi.ashenwheat.ModItems;
import akkamaddi.ashenwheat.handler.ConfigHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OssidRootCrop extends AkkamaddiCrop
{
    public OssidRootCrop()
    {
    	super("ossidvine");
    	setFertilityDividend(28.0F);
        setTickRandomly(true);
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
        return ModItems.ossidSeeds;
	}

	@Override
	protected Item getCrop() {
			return Item.getItemFromBlock(ModBlocks.ossidRoot);
	}
	
	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, 
			net.minecraft.world.IBlockAccess world, 
			BlockPos pos, IBlockState state, int fortune) 
	{
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;

		int metadata = ((Integer)state.getValue(AGE)).intValue();
		if (metadata >= GROWN) {
			int ndrops = this.getNumberDrops(fortune, rand, metadata);
			drops.add(new ItemStack(getCrop(), ndrops, 0));
		} 
		else {
			drops.add(new ItemStack(this.getSeed(), 1));
		}
	} // end getDrops()

	@Override
	public int getNumberDrops(int fortune, Random rand, int age) {
		int ndrops = 1;
		for (int i = 0; i < fortune; ++i) {
			if (rand.nextInt(15) <= GROWN) {
				ndrops++;
			}
		}
		return ndrops;
	} // end ()
   

} // end class OssidRootCrop
