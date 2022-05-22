package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModHayBlock extends HayBlock
{

    public ModHayBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand)
    {
        if (! worldIn.isClientSide) return;
        
        if (AshenwheatConfig.MakeAshenBalesFlame && (stateIn.getBlock() == ModBlocks.ash_wheat_bale.get()))
        {
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
            worldIn.addParticle(ParticleTypes.SMOKE, (double) (f1 + f4), (double) (f2 + f5), (double) (f3 + f6), 0.0D,
                    0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.FLAME, (double) ((f1 + 0.3) + (f6 * 0.7)),
                    (double) ((f2 + 0.3) + (f4 * 0.7)), (double) ((f3 + 0.3) + (f5 * 0.7)), 0.0D, 0.0D, 0.0D);
        }
        else if ( AshenwheatConfig.MakeOssidLanternGloom
           &&  (stateIn.getBlock() == ModBlocks.ossid_root.get()))
        {
            float f1 = (float) pos.getX() - 0.5F;
            float f2 = (float) pos.getY() - 0.5F;
            float f3 = (float) pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
            worldIn.addParticle(ParticleTypes.MYCELIUM, (double) (f1 + f4), (double) (f2 + f5), (double) (f3 + f6),
                    0.0D, 0.0D, 0.0D);
            worldIn.addParticle(ParticleTypes.UNDERWATER, (double) ((f1 + 0.3) + (f6 * 0.7)),
                    (double) ((f2 + 0.3) + (f4 * 0.7)), (double) ((f3 + 0.3) + (f5 * 0.7)), 0.0D, 0.0D, 0.0D);
        }
        else if (AshenwheatConfig.MakeScintillaBalesScintillate 
                && (stateIn.getBlock() == ModBlocks.scintilla_wheat_bale.get()))
        {
            float f1 = (float)pos.getX() - 0.5F;
            float f2 = (float)pos.getY() - 0.5F;
            float f3 = (float)pos.getZ() - 0.5F;
            float f4 = rand.nextFloat() * 2.0f;
            float f5 = rand.nextFloat() * 2.0f;
            float f6 = rand.nextFloat() * 2.0f;
            SimpleParticleType particle = 
                    AshenwheatConfig.MakeScintillationsSmaller ? ParticleTypes.ENCHANT : ParticleTypes.INSTANT_EFFECT;
            worldIn.addParticle(particle, 
                                (double)(f1 + f4), (double)(f2 + f5) , (double)(f3 + f6), 
                                0.0D, 0.0D, 0.0D);
        }
        else {
            super.animateTick(stateIn, worldIn, pos, rand);
        }
    } // end-animateTick()

} // end-class

