package amp.mctea.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import amp.mctea.MCTea;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockCamelliaCrop extends BlockCrops implements ITileEntityProvider{
	
	public BlockCamelliaCrop(int id){
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("camelliaCrop");
		setHardness(0.1F);
	}
	
	@Override
    protected int getCropItem(){
        return MCTea.teaLeaf.itemID; 
    }
	
	@Override
	protected int getSeedItem(){
		return MCTea.seedsCamellia.itemID;
	}
	
	public boolean hasTileEntity(int metadata){
		return true;
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
			if (cropMeta == 7){
				
				if ( world.isRemote ) return true;

				world.setBlock(x, y, z, blockID, 6, 3);
				EntityItem leafEntity = new EntityItem(world, x, y, z, new ItemStack(MCTea.teaLeaf.itemID, 1, 0));
				world.spawnEntityInWorld(leafEntity);
				world.playSoundAtEntity(player, "mob.sheep.shear", 1.0f, 1.2f);
				
				//Kinda wish I wasn't pointing the damgeItem function at the Player as a LivingEntity...
				//Look into alternative methods of damaging the Shears.
				player.getHeldItem().damageItem(1, player);
				
				
				return true;
			}
		} return false;
	}

	public TileEntity createNewTileEntity(World world){
		return new TileEntityCamelliaCrop();
	}
	
	public Icon[] iconArray;
	public String[] textureArray = {"camellia_1", "camellia_1", "camellia_1", "camellia_1", "camellia_1", "camellia_1", "camellia_2", "camellia_3"};
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icons){
		this.iconArray = new Icon[textureArray.length];
		
		for (int i = 0; i < this.iconArray.length; i++){
			this.iconArray[i] = icons.registerIcon("amp_mctea:" + textureArray[i]);
		}
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        return iconArray[meta];
    }
}