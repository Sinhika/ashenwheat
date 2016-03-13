package akkamaddi.ashenwheat.code;

import com.InfinityRaider.AgriCraft.api.v1.IAgriCraftPlant;
import com.InfinityRaider.AgriCraft.api.v1.IAgriCraftSeed;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.IPlantable;

@Optional.Interface(modid = "AgriCraft", iface = "com.InfinityRaider.AgriCraft.api.v1.IAgriCraftSeed")
public class AshSeeds extends ItemSeeds implements IPlantable, IAgriCraftSeed
{
    public AshSeeds(Block cropBlock, Block soilBlock)
    {
        super(cropBlock, soilBlock);
        setUnlocalizedName("ashSeeds");
    }

    @Override
    public void registerIcons(IIconRegister ir)
    {
        this.itemIcon = ir.registerIcon("ashenwheat:ashSeeds");
    }

    /* OPTIONAL AGRICRAFT METHODS */
    
	@Optional.Method(modid="AgriCraft")
	@Override
	public IAgriCraftPlant getPlant() {
		return (IAgriCraftPlant) getPlant(null, -1, -1, -1);
	}

	@Optional.Method(modid="AgriCraft")
	@Override
	public int tier() {
		return 2;	// TODO adjust later if we need to.
	}

	@Optional.Method(modid="AgriCraft")
	@Override
	@SideOnly(Side.CLIENT)
	public String getInformation() {
		return "A blackened wheat grain that is warm to the touch, seed of the ashenwheat.";
	}

	@Optional.Method(modid="AgriCraft")
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack) {
		return this.itemIcon;
	}
} // end class AshSeeds
