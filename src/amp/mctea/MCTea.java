package amp.mctea;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import amp.mctea.blocks.BlockCamelliaCrop;
import amp.mctea.items.CamelliaSeed;
import amp.mctea.items.TeaLeaf;
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
	public static Block camelliaCrop;
	public static ItemSeeds seedsCamellia;
	public static Item teaLeaf;
	
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
		
		camelliaCrop = new BlockCamelliaCrop(500);
		LanguageRegistry.addName(camelliaCrop, "Camellia Plant");
		
		seedsCamellia = new CamelliaSeed(5000, camelliaCrop.blockID, Block.tilledField.blockID);
		LanguageRegistry.addName(seedsCamellia, "Camellia Seeds");
		MinecraftForge.addGrassSeed(new ItemStack(seedsCamellia), 10);
		
		teaLeaf = new TeaLeaf(501);
		LanguageRegistry.addName(teaLeaf, "Tea Leaf");
				
		proxy.registerRenderers();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}