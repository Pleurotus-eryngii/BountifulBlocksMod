package eryngii.bountifulblocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@Mod(modid="bountifulblocksmod", name="1.8BlocksMod", version="1.0")

public class BountifulBlocksCore {
	  public static Block blockDiorite;

	  @EventHandler
	  public void preInit(FMLPreInitializationEvent event)
	{
		//ブロックのインスタンス生成
		blockDiorite = new DioriteBlock();
		//ブロックの登録。登録文字列はMOD内で被らなければ何でも良い。
		GameRegistry.registerBlock(blockDiorite, ItemDioriteBlock.class, "blockDiorite");

	}


}
