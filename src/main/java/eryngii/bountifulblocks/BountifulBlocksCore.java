package eryngii.bountifulblocks;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/*
 * コメントアウトでエリンギの解説が付いています。
 * 分かる範囲でしか解説していないため、曖昧な部分や誤った部分も多いかと思いますので、
 * あくまで参考程度に
 */

@Mod(modid="bountifulblocksmod", name="1.8BlocksMod", version="1.0")

public class BountifulBlocksCore {
	/*
	 * メタデータ関連の処理は赤砂蛇凪浜様のWikiと、
	 * reginn666様のWikiを参考にさせていただきました。
	 * */
	
	  //全面同じテクスチャのブロック。代表者はDiorite
	  public static Block blockDiorite;
	  //土と同じ耐久レベルのブロック 
	  public static Block blockCoarseDirt;
	  //フェンス類。
	  public static Block blockFenceX;
      //バリアブロック
	  public static Block blockBarrier;

	  //面ごとにテクスチャが違うブロック。処理が面倒なので個別登録
	  //処理についてはRedSandstoneのほうに解説をつけ、他は省略しました
	  public static Block blockRedSandStone;
	  public static Block blockSmoothRedSandStone;
	  public static Block blockChiseledRedSandStone;
	  public static Block blockPurpurPillar;
	  
	  //明かり類。今回はシーランタンのみ
	  public static Block blockSeaLantern;
	  
	  //以下MayaCraft
	  public static Block blockCannabis;//苗
	  public static Item itemCannabisPlant;//全体
	  public static Item itemCannabisLeaf;//葉
	  public static Item itemCannabisPowder;//粉
	  public static Block poppy;

	  @Mod.EventHandler
	  public void preInit(FMLPreInitializationEvent event)
	{
			//コンフィグをmodidではなく任意の名前で生成するためにFileインスタンスを生成してコンフィグクラスに渡している
			
		  File cfgfile = new File(event.getModConfigurationDirectory(), "BountifulBlocksMod.cfg");
			BountifulBlocksConfig.preLoad(cfgfile);
			
			/*メタデータを保持するブロック類。registerBlockメソッドの第二引数に該当クラスを渡している*/
			
			blockDiorite = new DioriteBlock();
			GameRegistry.registerBlock(blockDiorite, ItemDioriteBlock.class, "blockDiorite");

			blockCoarseDirt = new CoarseDirtBlock();
			GameRegistry.registerBlock(blockCoarseDirt, ItemCoarseDirtBlock.class, "blockCoarseDirt");

			//ここで指定するテクスチャは、Minecraft本体のテクスチャファイル内を探していて都合が悪いので空
			blockFenceX = new FenceBlockX("", Material.wood);
			GameRegistry.registerBlock(blockFenceX, ItemFenceBlockX.class, "blockFenceX");
			
			//blockHalfX = new HalfBlockX(null,0);
			//GameRegistry.registerBlock(blockHalfX, ItemHalfBlockX.class, "blockHalfX");
			/*
			blockStairX = new DioriteBlock();
			GameRegistry.registerBlock(blockDiorite, ItemDioriteBlock.class, "blockDiorite");
			*/
		
			/*以下メタデータを保持しないブロック類*/


			blockRedSandStone = new RedSandStoneBlock();
			GameRegistry.registerBlock(blockRedSandStone, "blockRedSandStone");

			blockChiseledRedSandStone = new CRSSBlock();
			GameRegistry.registerBlock(blockChiseledRedSandStone, "blockCRSS");
			
			blockSmoothRedSandStone = new SRSSBlock();
			GameRegistry.registerBlock(blockSmoothRedSandStone, "blockSRSS");

			blockPurpurPillar = new PurpurPillarBlock();
			GameRegistry.registerBlock(blockPurpurPillar, "blockPurpurPillar");
			
			blockBarrier = new BarrierBlock();
			GameRegistry.registerBlock(blockBarrier, "blockBarrier");
			
			blockSeaLantern = new SeaLanternBlock();
			GameRegistry.registerBlock(blockSeaLantern, "blockSeaLantern");
			
			blockCannabis = new CannabisBlock();
			GameRegistry.registerBlock(blockCannabis, "blockCannabis");
			
			itemCannabisPlant = new Item()
					.setCreativeTab(CreativeTabs.tabMaterials)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemCannabisPlant")/*システム名の登録*/
					.setTextureName("bountifulmod:cannabis_plant");/*テクスチャの指定*/
			GameRegistry.registerItem(itemCannabisPlant, "itemCannabisPlant");
			
			itemCannabisLeaf = (new ItemCannabisLeaf(1, 1.0F, false))
					.setCreativeTab(CreativeTabs.tabFood)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemCannabisLeaf")/*システム名の登録*/
					.setTextureName("bountifulmod:cannabis_leaf");/*テクスチャの指定*/
			GameRegistry.registerItem(itemCannabisLeaf, "itemCannabisLeaf");
			
			itemCannabisPowder = (new ItemCannabisPowder(1, 1.0F, false))
					.setCreativeTab(CreativeTabs.tabFood)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemCannabisPowder")/*システム名の登録*/
					.setTextureName("bountifulmod:cannabis_powder");/*テクスチャの指定*/
			GameRegistry.registerItem(itemCannabisPowder, "itemCannabisPowder");
			
}
	  @Mod.EventHandler
	  public void init(FMLInitializationEvent event){

		  	//レシピ登録
		  RecipeRegister.init();
    
	     }


	        
	    

}


