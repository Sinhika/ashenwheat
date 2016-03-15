package akkamaddi.ashenwheat.code;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ScintillaWheatCrop extends AkkamaddiCrop
{

    public ScintillaWheatCrop()
    {
        super();
    	setBlockName("scintillaWheatCrop");
    	setBlockTextureName("ashenwheat:scintillaWheatCrop_00");
    	setLightLevel(0.55F);
    	setFertilityDividend(30.0F);  // much slower growing than wheat.
    }


    /* (non-Javadoc)
	 * @see akkamaddi.ashenwheat.code.AkkamaddiCrop#func_149866_i()
	 */
	@Override
	protected Item func_149866_i() {
		return AshenWheatCore.scintillaSeeds;
	}


	/* (non-Javadoc)
	 * @see akkamaddi.ashenwheat.code.AkkamaddiCrop#func_149865_P()
	 */
	@Override
	protected Item func_149865_P() {

		return AshenWheatCore.scintillaWheatSheaf;
	}


	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (AshenWheatCore.MakeScintillawheatScintillate == true)
        {
            float f1 = (float)x + 0.5F;
            float f2 = (float)y + 0.3F;
            float f3 = (float)z + 0.5F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            float f5 = random.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle("instantSpell", (double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        }
    }
} // end class ScintillaWheatCrop
