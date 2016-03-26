package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.Content;

public class AshWheatCrop extends AkkamaddiCrop
{
	private final String name = "ashwheatcrop";
	
    public AshWheatCrop()
    {
    	super();
        setLightLevel(0.5F);
    	setFertilityDividend(26.0F);
        setTickRandomly(true);
        setUnlocalizedName(name);
        GameRegistry.registerBlock(this, name);
    }

    public String getName()
    {
    	return name;
    }
    
	@Override
	protected Item getSeed() {
		return Content.ashSeeds;
	}

	@Override
	protected Item getCrop() {
		return Content.ashWheatSheaf;
	}

	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random)
    {
        if (AshenWheatCore.MakeAshenwheatFlame == true)
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;
            float f5 = random.nextFloat() * -0.6F - -0.3F;
            world.spawnParticle(EnumParticleTypes.FLAME, 
            					(double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
            					0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            return;
        }
    }
} // end class AshWheatCrop
