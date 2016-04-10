package eryngii.bountifulblocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
 
@Mod(modid="bountifulblocksmod", name="1.8BlocksMod", version="1.0")

public class BountifulBlocksCore {
	  public static Block blockDiorite;
	  /*public static Block blockAndesite;
	  public static Block blockGranite;
	  public static Block blockPoliDiorite;
	  public static Block blockPoliAndesite;
	  public static Block blockPoliGranite;
	  */
	 
	  @EventHandler
	  public void preInit(FMLPreInitializationEvent event)
	{
		//ブロックのインスタンス生成
		blockDiorite = new DioriteBlock();
		//ブロックの登録。登録文字列はMOD内で被らなければ何でも良い。
		GameRegistry.registerBlock(blockDiorite, ItemDioriteBlock.class, "blockDiorite");
		
		
		/*blockAndesite = new AndesiteBlock();
		GameRegistry.registerBlock(blockDiorite, "blockDiorite");
		
		blockGranite = new GraniteBlock();
		GameRegistry.registerBlock(blockDiorite, "blockDiorite");
		
		blockPoliDiorite = new PoliDioriteBlock();
		GameRegistry.registerBlock(blockDiorite, "blockDiorite");
		
		blockPoliAndesite = new PoliAndesiteBlock();
		GameRegistry.registerBlock(blockDiorite, "blockDiorite");
		
		blockPoliGranite = new PoliGraniteBlock();
		GameRegistry.registerBlock(blockDiorite, "blockDiorite");
		*/
		
 
	}
	  @EventHandler
		public void init(FMLInitializationEvent event)
		{
			//ブロック名の登録
			//LanguageRegistry.addName(new ItemStack(blockSample, 1, <メタデータ>), "<名前>");
			//LanguageRegistry.instance().addNameForObject(new ItemStack(blockSample, 1, <メタデータ>), "<言語>", "<名前>");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 0), "Diorite");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 0), "ja_JP", "閃緑岩");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 1), "Andesite");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 1), "ja_JP", "安山岩");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 2), "Granite");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 2), "ja_JP", "花崗岩");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 3), "Polished Diorite");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 3), "ja_JP", "磨かれた閃緑岩");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 4), "Polished Andesite");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 4), "ja_JP", "磨かれた安山岩");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 5), "Polished Granite");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 5), "ja_JP", "磨かれた花崗岩");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 6), "Prismarine Bricks");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 6), "ja_JP", "プリズマリンレンガ");
			LanguageRegistry.addName(new ItemStack(blockDiorite, 1, 7), "Dark Prismarine");
			LanguageRegistry.instance().addNameForObject(new ItemStack(blockDiorite, 1, 7), "ja_JP", "ダークプリズマリン");

			
		}
	  
}
