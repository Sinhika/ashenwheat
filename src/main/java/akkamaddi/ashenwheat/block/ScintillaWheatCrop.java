package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.ModItems;
import akkamaddi.ashenwheat.handler.ConfigHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ScintillaWheatCrop extends AkkamaddiCrop
{
    public ScintillaWheatCrop()
    {
        super("scintillawheatcrop");
    	setLightLevel(0.55F);
    	setFertilityDividend(30.0F);
        setTickRandomly(true);
    }

	@Override
	protected Item getSeed() {
		return ModItems.scintillaSeeds;
	}


	/* (non-Javadoc)
	 * @see akkamaddi.ashenwheat.code.AkkamaddiCrop#func_149865_P()
	 */
	@Override
	protected Item getCrop() {
		return ModItems.scintillaWheatSheaf;
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if (ConfigHandler.MakeScintillawheatScintillate == true)
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, 
            		(double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
            		0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        }
    }
} // end class ScintillaWheatCrop
