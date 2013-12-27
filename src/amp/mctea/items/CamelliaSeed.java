package amp.mctea.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;

public class CamelliaSeed extends ItemSeeds{
	public CamelliaSeed(int id, int plantId, int soilId) {
		super(id, plantId, soilId);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
		setUnlocalizedName("seedCamellia");
		setTextureName("amp_mctea:seeds_camellia");
	}
}
