package amp.mctea;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import amp.mctea.blocks.BlockTestBlock;
import amp.mctea.items.CamelliaSeed;
import amp.mctea.lib.Reference;
import amp.mctea.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * MCTea
 * 
 * @author W. Alex "Amp" Best
 * @license LGPL v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MCTea {
	
	public static Block testBlock;
	public static Item testItem;
	public static Item seedsCamellia;
	
	@Instance( Reference.MOD_ID )
	public static MCTea instance;
	
	@SidedProxy(clientSide = "amp.mctea.proxy.ClientProxy", serverSide = "amp.mctea.preoxy.CommonProxy")
	public static CommonProxy proxy;
	
	
	/**
	 * Code that executes prior to mod initialization into Minecraft.
	 * Examples:
	 * 
	 * Intializing items and blocks. MUST DO HERE.
	 * Setting up custom logger to write log data to.
	 * Loading language translations.
	 * Registering mod's key bindings and sounds.
	 * 
	 * @param event Forge ModLoader's pre-init event.
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
			
	}
	
	/**
	 * Code that executes during the mod initializing into MineCraft
	 * Examples:
	 * 
	 * Registering the GUI Handler
	 * Registering the different 
	 * 
	 * @param event
	 */
	@EventHandler
	public void init(FMLInitializationEvent event){
		
		/* 
		//Next 3 lines are referencing a new "Test Block" item.
		testBlock = new BlockTestBlock(500, Material.rock).setUnlocalizedName("testBlock");
		GameRegistry.registerBlock(testBlock, Reference.MOD_ID + testBlock.getUnlocalizedName().substring(5));
		LanguageRegistry.addName(testBlock, "Test Block");
		// Test Block
		
		// "Test Item"
		testItem = new TestItem(5000).setUnlocalizedName("testItem");
		LanguageRegistry.addName(testItem, "Test Item");
		// End "Test Item"
		
		// Test Shapeless Crafting Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(testBlock), new Object[]
		{
			new ItemStack(Item.diamond), new ItemStack(Block.stone), new ItemStack(Item.dyePowder, 1, 15) 
		});
		// End Test Shapeless Recipe
		
		//Test Crafting Recipe
		GameRegistry.addRecipe(new ItemStack(testBlock), new Object[]{
			"XZX",
			"CXC",
			'X', Item.ingotGold,
			'C', Block.stone,
			'Z', new ItemStack(Item.dyePowder, 1, 15)
		});
		//Test Crafting Recipe
		 * 
		 * 
		 */

		seedsCamellia = new CamelliaSeed(5000);
		LanguageRegistry.addName(seedsCamellia, "Camellia Seeds");
		
		proxy.registerRenderers();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
		
	
}	