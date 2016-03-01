package akkamaddi.ashenwheat.handler;

import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.Content;

public class AshyBonemeal
{
    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event)
    {
        if (event.block == Content.ashWheatCrop)
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

        if (event.block == Content.scintillaWheatCrop)
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
        
        if (event.block == Content.ossidRootCrop)
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

        if (event.block == Content.thunderGrassCrop)
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
