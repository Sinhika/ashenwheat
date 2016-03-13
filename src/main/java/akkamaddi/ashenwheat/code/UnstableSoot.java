package akkamaddi.ashenwheat.code;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class UnstableSoot extends Item
{
    public UnstableSoot()
    {
        super();
        setUnlocalizedName("unstableSoot");
    }

    @Override
    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}