package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.BlockHay;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import akkamaddi.ashenwheat.handler.ConfigHandler;

public class ScintillaWheatBale extends BlockHay
{
	private final String name = "scintillawheatbale";
	
    public ScintillaWheatBale()
    {
        super();
        setTickRandomly(true);
        setLightLevel(1.0F);
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }

    public String getName()
    {
    	return name;
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
}