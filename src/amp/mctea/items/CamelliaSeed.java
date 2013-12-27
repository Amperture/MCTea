package amp.mctea.items;

import amp.mctea.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CamelliaSeed extends Item {
	public CamelliaSeed(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
		setUnlocalizedName("seedCamellia");
		setTextureName("amp_mctea:seeds_camellia");
	}
}
