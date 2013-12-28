package amp.mctea.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import amp.mctea.MCTea;


public class BlockCamelliaCrop extends BlockCrops{
	public BlockCamelliaCrop(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("camelliaCrop");
		setHardness(0.5F);
	}
	
	@Override
    protected int getCropItem(){
        return MCTea.teaLeaf.itemID; 
    }
	
	@Override
	protected int getSeedItem(){
		return MCTea.seedsCamellia.itemID;
	}
	
	
	/* 
	 * Tea Leaves can be harvested by shearing.
	 * Inspired by behavior of mDiyo's Natura mod. 
	 * 
	 * Behavior: Shearing Leaves will reset Camellia to a pre-harvestable 
	 * state, but should not require re-planting.
	 */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		
		if(player.getHeldItem().itemID == Item.shears.itemID){
			
			int cropMeta = world.getBlockMetadata(x, y, z);
			if (cropMeta >= 7){
				
				if ( world.isRemote ) return true;

				world.setBlock(x, y, z, blockID, 1, 3);
				EntityItem leafEntity = new EntityItem(world, x, y, z, new ItemStack(MCTea.teaLeaf.itemID, 3, 0));
				world.spawnEntityInWorld(leafEntity);
				world.playSoundAtEntity(player, "mob.sheep.shear", 1.0f, 1.2f);
				return true;
			}
		} return false;
	}
}