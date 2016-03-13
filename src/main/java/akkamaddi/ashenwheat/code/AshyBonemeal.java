package akkamaddi.ashenwheat.code;

import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AshyBonemeal
{
    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
        if (event.block == AshenWheatCore.ashWheatCrop)
        {
            int l = event.world.getBlockMetadata(event.x, event.y, event.z) + MathHelper.getRandomIntegerInRange(event.world.rand, 0, 2);

            if (l < 7)
            {
                ++l;
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            }

            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            event.setResult(Result.ALLOW);
            //event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
        }

        if (event.block == AshenWheatCore.scintillaWheatCrop)
        {
            int l = event.world.getBlockMetadata(event.x, event.y, event.z) + MathHelper.getRandomIntegerInRange(event.world.rand, 0, 1);

            if (l < 7)
            {
                ++l;
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            }

            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            event.setResult(Result.ALLOW);
            //event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
        }
        
        if (event.block == AshenWheatCore.ossidRootCrop)
        {
            int l = event.world.getBlockMetadata(event.x, event.y, event.z) + MathHelper.getRandomIntegerInRange(event.world.rand, 0, 1);

            if (l < 7)
            {
                ++l;
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            }

            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            event.setResult(Result.ALLOW);
            //event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
        }

        if (event.block == AshenWheatCore.thunderGrassCrop)
        {
            int l = event.world.getBlockMetadata(event.x, event.y, event.z) + MathHelper.getRandomIntegerInRange(event.world.rand, 0, 1);

            if (l < 7)
            {
                ++l;
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            }

            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            event.setResult(Result.ALLOW);
            //event.world.setBlockMetadataWithNotify(event.X, event.Y, event.Z, 7, 2);
        }
    }
}
