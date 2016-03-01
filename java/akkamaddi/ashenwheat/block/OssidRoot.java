package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.AshenWheatCore;

public class OssidRoot extends BlockPumpkin
{
	private boolean isLit;
	
    public OssidRoot(boolean isLit)
    {
    	super();
    	this.isLit = isLit;
    	
    	if (isLit) // ossid lantern
    	{
    		setLightLevel(1.0F);
            setTickRandomly(true);
    	}
        GameRegistry.registerBlock(this, getName());
        setUnlocalizedName(getName());
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }

    public String getName()
    {
    	if (isLit) { 
    		return "ossidlantern";	
    	} else { 
    		return "ossidroot"; 
    	}
    } // end getName()
   
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random)
    {
    	if (this.isLit == false) return;
    		
        if (AshenWheatCore.MakeOssidLanternGloom == true)
        {
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = random.nextFloat() * 2.0f;
            float f5 = random.nextFloat() * 2.0f;
            float f6 = random.nextFloat() * 2.0f;
            world.spawnParticle(EnumParticleTypes.TOWN_AURA, 
            					(double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 
            					0.0D, 0.0D, 0.0D, new int[0]);
            world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH,  (double)((f1 + 0.3) + (f6 * 0.7)), 
            					(double)((f2 + 0.3) + (f4 * 0.7)) , (double)((f3 + 0.3) + (f5 * 0.7)), 
            					0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        } // end-else
        
     } // end randomDisplayTick()
} // end class OssidRoot
