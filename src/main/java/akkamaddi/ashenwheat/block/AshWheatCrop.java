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
import akkamaddi.ashenwheat.Content;
import akkamaddi.ashenwheat.ModInfo;
import akkamaddi.ashenwheat.handler.ConfigHandler;

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
        setRegistryName(ModInfo.ID, name);
        GameRegistry.register(this);
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
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand)
    {
        if (ConfigHandler.MakeAshenwheatFlame == true)
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
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
