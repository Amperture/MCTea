package amp.mctea.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;


public class BlockCamelliaCrop extends BlockCrops{
	public BlockCamelliaCrop(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("camelliaCrop");
	}
}