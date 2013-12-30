package amp.mctea.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TeaLeaf extends Item {

	public TeaLeaf(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
		setUnlocalizedName("teaLeaf");
		setTextureName("amp_mctea:tea_leaf");
	}
	
	

}
