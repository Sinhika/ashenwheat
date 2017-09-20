package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import akkamaddi.ashenwheat.handler.ConfigHandler;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
        setUnlocalizedName(getName());
        setRegistryName(ModInfo.ID, getName());
    }

    public String getName()
    {
    	if (isLit) { 
    		return "ossidlantern";	
    	} else { 
    		return "ossidroot"; 
    	}
    } // end getName()
   
	public void registerItemModel(Item itemBlock) {
		AshenWheatCore.proxy.registerItemRenderer(itemBlock, 0, getName());
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this);
	}

	@Override
	public OssidRoot setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
    	if (this.isLit == false) return;
    		
        if (ConfigHandler.MakeOssidLanternGloom == true)
        {
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
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
