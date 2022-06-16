package mod.akkamaddi.ashenwheat.world;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.GlowLichenFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GlowLichenConfiguration;

public class CavePlantFeature extends GlowLichenFeature
{

    public CavePlantFeature(Codec<GlowLichenConfiguration> p_159838_)
    {
        super(p_159838_);
     }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     * @param pContext A context object with a reference to the level and the position the feature is being placed at
     */
   @Override
    public boolean place(FeaturePlaceContext<GlowLichenConfiguration> pContext)
    {
        // TODO Auto-generated method stub
        return super.place(pContext);
    }

    
} // end class
