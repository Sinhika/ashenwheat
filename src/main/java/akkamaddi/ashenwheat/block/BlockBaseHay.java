package akkamaddi.ashenwheat.block;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.block.BlockHay;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBaseHay extends BlockHay 
{
	protected String name;

	public BlockBaseHay(String name) 
	{
		super();
		this.name = name;
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
	}

	public void registerItemModel(Item itemBlock) {
		AshenWheatCore.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this);
	}

	@Override
	public BlockBaseHay setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

} // end class
