package amp.mctea.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CupFull extends Item {

	public CupFull(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    

    
/*
 * Initial code for effects of drinking tea. 
 * 
 * Copied initial code from ItemBucketMilk. ___EDIT THIS LATER___
 */    
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }

        if (!world.isRemote)
        {
            player.clearActivePotions();
            player.getFoodStats().addStats(2, 0);
            player.setHealth(player.getHealth() + 2);
        }

        return stack.stackSize <= 0 ? new ItemStack(Item.bucketEmpty) : stack;
    }
}
