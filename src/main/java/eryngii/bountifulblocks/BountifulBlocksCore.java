package eryngii.bountifulblocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@Mod(modid="bountifulblocksmod", name="1.8BlocksMod", version="1.0")

public class BountifulBlocksCore {
	/*
	 * メタデータ関連の処理は赤砂蛇凪浜様のWikiと、
	 * reginn666氏のWikiを参考にさせていただきました。
	 * */
	
	//全面同じテクスチャのブロック。代表者はDiorite
	  public static Block blockDiorite;
	//土と同じ耐久レベルのブロック 
	  public static Block blockCoarseDirt;
	//フェンス類。
	  public static Block blockFenceX;

	  //面ごとにテクスチャが違うブロック。処理が面倒なので個別登録
	  public static Block blockRedSandStone;
	  public static Block blockSRSS;//SmoothRedSandStone
	  public static Block blockCRSS;//ChiseledRedSandStone
	  public static Block blockPurpurPillar;
	  

	  @EventHandler
	  public void preInit(FMLPreInitializationEvent event)
	{
		//ブロックのインスタンス生成
		blockDiorite = new DioriteBlock();
		//ブロックの登録。登録文字列はMOD内で被らなければ何でも良い。
		GameRegistry.registerBlock(blockDiorite, ItemDioriteBlock.class, "blockDiorite");
		
		blockCoarseDirt = new CoarseDirtBlock();
		GameRegistry.registerBlock(blockCoarseDirt, ItemCoarseDirtBlock.class, "blockCoarseDirt");
		
		//ここで指定するテクスチャは、Minecraft本体のテクスチャファイル内を探していて都合が悪いので空
		blockFenceX = new FenceBlockX("", Material.wood);
		GameRegistry.registerBlock(blockFenceX, ItemFenceBlockX.class, "blockFenceX");
		
		
		blockRedSandStone = new RedSandStoneBlock();
		GameRegistry.registerBlock(blockRedSandStone, "blockRedSandStone");
		
		blockCRSS = new CRSSBlock();
		GameRegistry.registerBlock(blockCRSS, "blockCRSS");
		
		blockSRSS = new SRSSBlock();
		GameRegistry.registerBlock(blockSRSS, "blockSRSS");
		
		blockPurpurPillar = new PurpurPillarBlock();
		GameRegistry.registerBlock(blockPurpurPillar, "blockPurpurPillar");
		
		

	}


}
