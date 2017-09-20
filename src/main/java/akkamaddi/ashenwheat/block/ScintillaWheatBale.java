package akkamaddi.ashenwheat.block;

import java.util.Random;

import akkamaddi.ashenwheat.handler.ConfigHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ScintillaWheatBale extends BlockBaseHay
{
    public ScintillaWheatBale()
    {
        super("scintillawheatbale");
        setTickRandomly(true);
        setLightLevel(1.0F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if (ConfigHandler.MakeScintillaBalesScintillate == true)
        {
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
            world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, 
            					(double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 
            					0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        }
    }
} // end class
