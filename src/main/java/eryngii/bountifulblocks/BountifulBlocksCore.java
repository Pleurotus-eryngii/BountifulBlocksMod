package eryngii.bountifulblocks;

import java.awt.Color;
import java.io.File;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;

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
	 * なお、実績関連の処理はつてと様の豆腐Craft
	 * 及びShift様のSextiarySector
	 * を参考にさせていただきました。
	 * 
	 * 村人関連の処理と、そのコメントアウトは
	 * ModdingWikiのものを引用いたしました。
	 * 更に、つてと様の豆腐Craftを参考に一部修正を行いました
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
	  
	  public static Block blockCannabisContainer;//圧縮ブロック
	  public static Block blockOpiumPoppyContainer;//圧縮ブロック
	  

		public static Item bonsaiManEgg;//盆栽マンのスポーンエッグ。デバッグ用に近いが一応残す
	  
	  //クリエイティブタブ
	  public static final CreativeTabs tabsMaya = new CreativeTabMaya("Maya");
	  //村人。
	  public static VillagerMaya villagerMaya;
	  public static int mayaVillagerProfession = 114514;
	
	  //プロキシ。Wikiでの登録手法では上手くいかなかったためきっちり登録した
	  @SidedProxy(clientSide = "eryngii.bountifulblocks.ClientProxy", 
						  serverSide = "eryngii.bountifulblocks.CommonProxy")
	  public static CommonProxy proxy;
	  public static ClientProxy clientproxy;
	    
	    
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
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemCannabisPlant")/*システム名の登録*/
					.setTextureName("bountifulmod:cannabis_plant");/*テクスチャの指定*/
			GameRegistry.registerItem(itemCannabisPlant, "itemCannabisPlant");
			
			//引数は左から満腹度回復量、腹持ち、オオカミに食べさせられるかどうか
			itemCannabisLeaf = (new ItemCannabisLeaf(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemCannabisLeaf")/*システム名の登録*/
					.setTextureName("bountifulmod:cannabis_leaf");/*テクスチャの指定*/
			GameRegistry.registerItem(itemCannabisLeaf, "itemCannabisLeaf");
			
			itemCannabisPowder = (new ItemCannabisPowder(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemCannabisPowder")/*システム名の登録*/
					.setTextureName("bountifulmod:cannabis_powder")/*テクスチャの指定*/;
			GameRegistry.registerItem(itemCannabisPowder, "itemCannabisPowder");
			
			
			blockOpiumPoppy = new OPoppyBlock();
			GameRegistry.registerBlock(blockOpiumPoppy, "blockOpiumPoppy");
			
			itemOpiumPoppyPlant = new Item()
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppyPlant")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy_plant");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppyPlant, "itemOpiumPoppyPlant");
			
			itemOpiumPoppy = (new ItemOPoppy(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppy")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppy, "itemOpiumPoppy");
			

			itemOpiumPoppyPowder = (new ItemOPoppyPowder(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppyPowder")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy_powder");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppyPowder, "itemOpiumPoppyPowder");
			
			
			blockCannabisContainer = new CannabisContainerBlock();
			GameRegistry.registerBlock(blockCannabisContainer, "blockCannabisContainer");
			
			blockOpiumPoppyContainer = new OpiumPoppyContainerBlock();
			GameRegistry.registerBlock(blockOpiumPoppyContainer, "blockOpiumPoppyContainer");
			
			bonsaiManEgg = new ItemBonsaiManEgg(Color.BLACK.getRGB(), Color.GREEN.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(BountifulBlocksCore.tabsMaya)
					//システム名の登録
					.setUnlocalizedName("BonsaimanEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(bonsaiManEgg, "bonsaiManEgg");
			
			/*
			//ブロックやアイテムの登録後に行わないと、アイテムが描画できずクラッシュしてしまう
			if (BountifulBlocksConfig.achievement)
		     {
		         MayaAchievements.load();
		     }
		*/
			//実績の登録
			MayaAchievements.initAchievements();
			
}
	    
		
	  @EventHandler
	  public void init(FMLInitializationEvent event){
		  
		  //盆栽マンの登録。スポーン地点を大量に登録しているが動くかどうかは不明
		    EntityRegistry.registerModEntity(EntityBonsaiMan.class, "BonsaimanEntity", 0, this, 250, 1, false);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.forest);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.beach);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.desert);
	        //Render設定
	        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(EntityBonsaiMan.class, new RenderBonsaiMan());

		  villagerMaya = new VillagerMaya();
		  
			/*
			 * 村人の職業IDを登録しています
			 */
	                VillagerRegistry.instance().registerVillagerId(mayaVillagerProfession);
	 
			/*
			 * 村人を登録しています
			 */
			VillagerRegistry.instance().registerVillageTradeHandler(mayaVillagerProfession, villagerMaya);
	 
			/*
			 * 村人の家を登録しています
			 */
			VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleMayaHouse());
	                /*
	                 * #Forge1.7.10-10.13.0.1230現在
	                 * 通常は、registerStructureで建物のStructureStartを継承したクラスを登録した後
	                 * func_143031_aで建物のStructureComponentを継承したクラスを登録する必要がありますが
	                 * 今回は、両方でComponentVillageSampleHouseを登録しています
	                 */
	                MapGenStructureIO.registerStructure(ComponentVillageMayaHouse.class, "VCHSH");
	                MapGenStructureIO.func_143031_a(ComponentVillageMayaHouse.class, "VCHSHP");
	 
	               proxy.init();
	                

	    		  	//レシピ登録
	    		  RecipeRegister.init();

	    	        }
	     }

	        
	    

}


