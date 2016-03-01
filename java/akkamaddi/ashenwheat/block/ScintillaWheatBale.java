package akkamaddi.ashenwheat.block;

import java.util.Random;

import net.minecraft.block.BlockHay;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import akkamaddi.ashenwheat.AshenWheatCore;

public class ScintillaWheatBale extends BlockHay
{
    public ScintillaWheatBale()
    {
        super();
        setTickRandomly(true);
        setBlockName("scintillaWheatBale");
        setBlockTextureName("ashenwheat:scintillaWheatBale");
        setLightLevel(1.0F);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (AshenWheatCore.MakeScintillaBalesScintillate == true)
        {
            float f1 = (float)x - 0.5F;
            float f2 = (float)y - 0.5F;
            float f3 = (float)z - 0.5F;
            float f4 = random.nextFloat() * 2.0f;
            float f5 = random.nextFloat() * 2.0f;
            float f6 = random.nextFloat() * 2.0f;
            world.spawnParticle("instantSpell", (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 0.0D, 0.0D, 0.0D);
        }
        else
        {
            return;
        }
    }
}
