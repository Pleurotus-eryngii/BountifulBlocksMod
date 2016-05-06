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
	 * 
	 * なお、実績関連の処理はつてと様の豆腐Craftを参考にさせていただきました。
	 * */
	
	 public static final String resourceDomain = "bountifulmod:";
	 
   
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
	  public static Block blockOpiumPoppy;//苗
	  public static Item itemOpiumPoppyPlant;//全体
	  public static Item itemOpiumPoppy;//使用部分
	  public static Item itemOpiumPoppyPowder;//粉

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
			
			//引数は左から満腹度回復量、腹持ち、オオカミに食べさせられるかどうか
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
			
			
			blockOpiumPoppy = new OPoppyBlock();
			GameRegistry.registerBlock(blockOpiumPoppy, "blockOpiumPoppy");
			
			itemOpiumPoppyPlant = new Item()
					.setCreativeTab(CreativeTabs.tabMaterials)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppyPlant")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy_plant");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppyPlant, "itemOpiumPoppyPlant");
			
			itemOpiumPoppy = (new ItemOPoppy(1, 1.0F, false))
					.setCreativeTab(CreativeTabs.tabFood)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppy")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppy, "itemOpiumPoppy");
			

			itemOpiumPoppyPowder = (new ItemOPoppyPowder(1, 1.0F, false))
					.setCreativeTab(CreativeTabs.tabFood)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppyPowder")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy_powder");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppyPowder, "itemOpiumPoppyPowder");
			
			
			
			//ブロックやアイテムの登録後に行わないと、アイテムが描画できずクラッシュしてしまう
			if (BountifulBlocksConfig.achievement)
		     {
		         MayaAchievements.load();
		     }
		
}
	  @Mod.EventHandler
	  public void init(FMLInitializationEvent event){

		  	//レシピ登録
		  RecipeRegister.init();
    
	     }


	        
	    

}


