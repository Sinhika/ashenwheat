package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.BlockHay;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.AshenWheatCore;

public class ScintillaWheatBale extends BlockHay
{
	private final String name = "scintillawheatbale";
	
    public ScintillaWheatBale()
    {
        super();
        setTickRandomly(true);
        setLightLevel(1.0F);
        setUnlocalizedName(name);
        GameRegistry.registerBlock(this, name);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }

    public String getName()
    {
    	return name;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random)
    {
        if (AshenWheatCore.MakeScintillaBalesScintillate == true)
        {
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = random.nextFloat() * 2.0f;
            float f5 = random.nextFloat() * 2.0f;
            float f6 = random.nextFloat() * 2.0f;
            world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, 
            					(double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 
            					0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        }
    }
}
