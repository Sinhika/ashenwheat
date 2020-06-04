package mod.akkamaddi.ashenwheat.content;

import java.util.Random;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Make one custom CropsBlock class for all the special crops in this mod.
 *
 */
public class ModCropsBlock extends CropsBlock
{

    public ModCropsBlock(Properties builder)
    {
        super(builder);
    }

    /**
     * Return the seed item for the corresponding block this actually is...
     */
    @Override
    protected IItemProvider getSeedsItem()
    {
        if (this == ModBlocks.ash_wheat_crop.get()) {
            return ModItems.ash_seeds.get();
        }
        else if (this == ModBlocks.ossid_root_crop.get()) {
            return ModItems.ossid_seeds.get();
        }
        else if (this == ModBlocks.scintilla_wheat_crop.get()) {
            return ModItems.scintilla_seeds.get();
        }
        else if (this == ModBlocks.thunder_grass_crop.get()) {
            return ModItems.thunder_seeds.get();
        }
        return super.getSeedsItem();
    } // getSeedsItems

    /**
     * display the random particle effect for this crop, whichever it is, if the config allows.
     */
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (!worldIn.isRemote) return;
        
        if (AshenwheatConfig.MakeAshenwheatFlame && (stateIn.getBlock() == ModBlocks.ash_wheat_crop.get()))
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.FLAME, 
                                (double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
                                0.0D, 0.0D, 0.0D);
        }
        else if (AshenwheatConfig.MakeOssidCropGloom && (stateIn.getBlock() == ModBlocks.ossid_root_crop.get()))
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.ANGRY_VILLAGER, 
                                (double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
                                0.0D, 0.0D, 0.0D);
       
        }
        else if (AshenwheatConfig.MakeScintillawheatScintillate && (stateIn.getBlock() == ModBlocks.scintilla_wheat_crop.get()))
        {
            float f1 = (float) pos.getX() + 0.5F;
            float f2 = (float) pos.getY() + 0.3F;
            float f3 = (float) pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.ENCHANT, (double) (f1 + f4), (double) (f2 + f4 + f5),
                    (double) (f3 + f5), 0.0D, 0.0D, 0.0D);
        }
        else if (AshenwheatConfig.MakeThunderGrassSmoke && (stateIn.getBlock() == ModBlocks.thunder_grass_crop.get()))
        {
            float f1 = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.3F;
            float f3 = (float)pos.getZ() + 0.5F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
            float f5 = rand.nextFloat() * -0.6F - -0.3F;
            worldIn.addParticle(ParticleTypes.SMOKE, 
                    (double)(f1 + f4), (double)(f2 + f4 + f5) , (double)(f3 + f5), 
                    0.0D, 0.0D, 0.0D);
            
        }
        else {
            super.animateTick(stateIn, worldIn, pos, rand);
        }
    } // end animateTick()

} // end class
