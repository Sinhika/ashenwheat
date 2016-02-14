package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.BlockPumpkin;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OssidRoot extends BlockPumpkin
{
	private boolean blockType;
	
    protected OssidRoot(boolean isLit)
    {
    	super(isLit);
    	blockType = isLit;
        this.setBlockName("ossidRoot");
        this.setBlockTextureName("ashenwheat:ossid");
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
    	if (this.blockType == false) return;
    		
        if (AshenWheatCore.MakeOssidLanternGloom == true)
        {
            float f1 = (float)x - 0.5F;
            float f2 = (float)y - 0.5F;
            float f3 = (float)z - 0.5F;
            float f4 = random.nextFloat() * 2.0f;
            float f5 = random.nextFloat() * 2.0f;
            float f6 = random.nextFloat() * 2.0f;
            world.spawnParticle("townaura", (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 0.0D, 0.0D, 0.0D);
            world.spawnParticle("depthsuspend", (double)((f1 + 0.3) + (f6 * 0.7)), (double)((f2 + 0.3) + (f4 * 0.7)) , (double)((f3 + 0.3) + (f5 * 0.7)), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        } // end-else
        
     } // end randomDisplayTick()
} // end class OssidRoot
