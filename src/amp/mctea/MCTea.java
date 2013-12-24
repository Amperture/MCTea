package amp.mctea;

import amp.mctea.lib.Reference;
import amp.mctea.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * MCTea
 * 
 * @author W. Alex "Amp" Best
 * @license LGPL v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MCTea {
	
	@Instance( Reference.MOD_ID )
	public static MCTea instance;
	
	
	@SidedProxy(clientSide = "amp.mctea.proxy.ClientProxy", serverSide = "amp.mctea.proxy.CommonProxy")
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
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
