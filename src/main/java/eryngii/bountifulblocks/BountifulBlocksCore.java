package eryngii.bountifulblocks;

import java.awt.Color;
import java.io.File;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
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
	 * 
	 * Tick関連の処理に関しては、はやぶさ様の提案を参考に、
	 * regin666様のWikiをもとに行いました
	 * Tick関連の処理における時間の処理は、はやぶさ様の
	 * ShowPlayingTimeModを参考にさせていただきました。
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
	  public static Block blockBone;
	  
	  //明かり類。今回はシーランタンのみ
	  public static Block blockSeaLantern;
	  //マグマブロック
	  public static Block blockMagma;
	  
	  //以下MayaCraft
	  public static Block blockCannabis;//苗
	  public static Item itemCannabisPlant;//全体
	  public static Item itemCannabisLeaf;//葉
	  public static Item itemDryCannabisLeaf;//乾燥物
	  public static Item itemCannabisPowder;//粉
	  public static Block blockOpiumPoppy;//苗
	  public static Item itemOpiumPoppyPlant;//全体
	  public static Item itemOpiumPoppy;//使用部分
	  public static Item itemDryOpiumPoppy;//乾燥物
	  public static Item itemOpiumPoppyPowder;//粉
	  
	  public static Block blockFreshCannabis;//乾燥前
	  public static Block blockFreshOpiumPoppy;//乾燥前
	  public static Block blockCannabisContainer;//圧縮ブロック.2つをメタデータで処理
	  

		public static Item bonsaiManEgg;//盆栽マンのスポーンエッグ。デバッグ用に近いが一応残す
		public static Item superBonsaiManEgg;
		public static Item rabbitEgg;
		public static Item polarBearEgg;
		
		public boolean Flag=false;//1回だけ実行する判定用。複数薬物使用対策で一応個別に分ける
		public boolean Flag2=false;//1回だけ実行する判定用
		public boolean Flag3=false;//1回だけ実行する判定用
		public boolean Flag4=false;//1回だけ実行する判定用
		public boolean Flag5=false;//1回だけ実行する判定用
		public boolean Flag6=false;//1回だけ実行する判定用
	  
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
			
			blockBone = new BoneBlock();
			GameRegistry.registerBlock(blockBone, "blockBone");
			
			blockBarrier = new BarrierBlock();
			GameRegistry.registerBlock(blockBarrier, "blockBarrier");
			
			blockSeaLantern = new SeaLanternBlock();
			GameRegistry.registerBlock(blockSeaLantern, "blockSeaLantern");
			
			blockMagma = new MagmaBlock();
			GameRegistry.registerBlock(blockMagma, "blockMagma");
			
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
			
			itemDryCannabisLeaf = (new ItemDryCannabisLeaf(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemDryCannabisLeaf")/*システム名の登録*/
					.setTextureName("bountifulmod:dry_cannabis_leaf");/*テクスチャの指定*/
			GameRegistry.registerItem(itemDryCannabisLeaf, "itemDryCannabisLeaf");
			
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
			
			itemDryOpiumPoppy = (new ItemDryOPoppy(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemDryOpiumPoppy")/*システム名の登録*/
					.setTextureName("bountifulmod:dry_opoppy");/*テクスチャの指定*/
			GameRegistry.registerItem(itemDryOpiumPoppy, "itemDryOpiumPoppy");
			
			itemOpiumPoppyPowder = (new ItemOPoppyPowder(1, 1.0F, false))
					.setCreativeTab(tabsMaya)/*クリエイティブのタブ*/
					.setUnlocalizedName("itemOpiumPoppyPowder")/*システム名の登録*/
					.setTextureName("bountifulmod:opoppy_powder");/*テクスチャの指定*/
			GameRegistry.registerItem(itemOpiumPoppyPowder, "itemOpiumPoppyPowder");
			
			
			blockCannabisContainer = new CannabisContainerBlock();
			GameRegistry.registerBlock(blockCannabisContainer, ItemCannabisContainerBlock.class, "blockCannabisContainer");
			
			
			blockFreshCannabis = new FreshCannabisBlock();
			GameRegistry.registerBlock(blockFreshCannabis, "blockFreshCannabis");
			
			blockFreshOpiumPoppy = new FreshOpiumPoppyBlock();
			GameRegistry.registerBlock(blockFreshOpiumPoppy, "blockFreshOpiumPoppy");
			
			
			bonsaiManEgg = new ItemBonsaiManEgg(Color.BLACK.getRGB(), Color.GREEN.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(BountifulBlocksCore.tabsMaya)
					//システム名の登録
					.setUnlocalizedName("BonsaimanEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(bonsaiManEgg, "bonsaiManEgg");
					
			superBonsaiManEgg = new ItemSuperBonsaiManEgg(Color.BLACK.getRGB(), Color.RED.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(BountifulBlocksCore.tabsMaya)
					//システム名の登録
					.setUnlocalizedName("SuperBonsaimanEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(superBonsaiManEgg, "SuperBonsaiManEgg");
					
					
					int intValueP = Integer.parseInt( "936c59",16);
					Color rabbitPrimary = new Color( intValueP );
					int intValueS = Integer.parseInt( "513830",16);
					Color rabbitSecondary = new Color( intValueS );
					
			rabbitEgg = new ItemRabbitEgg(rabbitPrimary.getRGB() , rabbitSecondary.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(CreativeTabs.tabMisc)
					//システム名の登録
					.setUnlocalizedName("RabbitEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(rabbitEgg, "RabbitEgg");
			
			polarBearEgg = new ItemPolarBearEgg(Color.WHITE.getRGB(), Color.GRAY.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(CreativeTabs.tabMisc)
					//システム名の登録
					.setUnlocalizedName("PolarBearEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(polarBearEgg, "PolarBearEgg");
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
	  //開始時の時間を代入する
	  public static long startedtime;

		@EventHandler
		public void postInit(FMLPostInitializationEvent event) {
			//postInitで起動時を取得
			//この実装は安全なのか…？
			long i = System.currentTimeMillis();
			System.out.println(i);
			startedtime = i;
			System.out.println(startedtime);
	}
	    
		
	  @Mod.EventHandler
	  public void init(FMLInitializationEvent event){
			/*
			 * Eventの登録
			 */
			FMLCommonHandler.instance().bus().register(this);
			
		  //盆栽マンの登録。スポーン地点を大量に登録しているが動くかどうかは不明
		    EntityRegistry.registerModEntity(EntityBonsaiMan.class, "BonsaimanEntity", 0, this, 250, 1, false);
		    EntityRegistry.registerModEntity(EntitySuperBonsaiMan.class, "SuperBonsaimanEntity", 1, this, 250, 1, false);
		    EntityRegistry.registerModEntity(EntityRabbit.class, "RabbitEntity", 2, this, 250, 1, false);
		    EntityRegistry.registerModEntity(EntityPolarBear.class, "PolarBearEntity", 3, this, 250, 1, false);

	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.forest);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.beach);
	        EntityRegistry.addSpawn(EntityBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.desert);
	        
	        
			 
		     EntityRegistry.addSpawn(EntitySuperBonsaiMan.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.savanna);
		     
			 
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);
	        //Render設定
	        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(EntityBonsaiMan.class, new RenderBonsaiMan());
			RenderingRegistry.registerEntityRenderingHandler(EntitySuperBonsaiMan.class, new RenderBonsaiMan());
			RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RenderRabbit());
			RenderingRegistry.registerEntityRenderingHandler(EntityPolarBear.class, new RenderPolarBear());
	        }

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
	  

		@SubscribeEvent
		public void onServerTick(TickEvent.ServerTickEvent event)
		{
			/*
			 * ここにServerに関するtick処理を書く.
			 */
		}

		@SubscribeEvent
		public void onClientTick(TickEvent.ClientTickEvent event)
		{
			/*
			 * ここにClientに関するtick処理を書く.
			 */
		}
		

		@SubscribeEvent
		public void onWorldTick(TickEvent.WorldTickEvent event)
		{
			/*
			 * ここにWorldに関するtick処理を書く.
			 * event.worldでWorldのインスタンスを取得できる.
			 */

			EntityPlayer entP =  Minecraft.getMinecraft().thePlayer;//プレイヤーのインスタンス取得

			}
		

		@SubscribeEvent
		public void onPlayerTick(TickEvent.PlayerTickEvent event)
		{
			/*
			 * ここにPlayerに関するtick処理を書く.
			 * event.playerでEntityPlayerのインスタンスを取得できる.
			 */
			//フラッシュバックの設定に用いる
			long nowtime = System.currentTimeMillis();//現在時間を取得
	    	long calculation = (nowtime - ItemCannabisLeaf.depstartedtime)/1000L; //現在時間 - 使用時にセットした時間を秒単位に修正
	    	
	    	if(!Flag){
	    	if(ItemCannabisLeaf.depStart=true){//保険。意味はないと思うが、誤作動の防止目的
	    	if(calculation == 900)//900だった場合(=15分)
    		{
	    		
	    		//Worldのインスタンス取得。
	    		World world = Minecraft.getMinecraft().theWorld;

	    		//以下、吐き気のポーション。設定の意味はItemCannabisLeaf他参照
	    		int potionID = Potion.confusion.id;
	    		int duration = 120 * 20;
	    		int amplifier = 2;

	    		PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
	    		
	    		//効果付与
	    		event.player.addPotionEffect(Effect);
	             
	    		world.playSoundAtEntity(event.player, "bountifulmod:cannabisbgm", 1.0F, 1.0F);
	             
	    		
	    		//一度だけ実行させるためのフラグ。Falseのときのみ実行されるため、2度目以降は実行されない
	    		Flag=true;
	    			}
	    		}
	    	
	    	if(calculation == 903){Flag= false;}
	    	//3秒ほど後にまたFlagをfalseにして、フラッシュバックが何度でも起こるようにしている。
	    	}
	    	
	    //-------------乾燥葉---------------
	    	long calculation2 = (nowtime - ItemDryCannabisLeaf.depstartedtime)/1000L; //現在時間 - 使用時にセットした時間を秒単位に修正
    	
	    	if(!Flag2){
	    	if(ItemDryCannabisLeaf.depStart=true){//保険。意味はないと思うが、誤作動の防止目的
	    	if(calculation2 == 900)//900だった場合(=15分)
	    	{
    		
	    		//Worldのインスタンス取得。
	    		World world = Minecraft.getMinecraft().theWorld;

	    		//以下、吐き気のポーション。設定の意味はItemCannabisLeaf他参照
	    		int potionID = Potion.confusion.id;
	    		int duration = 120 * 20;
	    		int amplifier = 2;

	    		PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
    		
	    		//効果付与
	    		event.player.addPotionEffect(Effect);
             
	    		world.playSoundAtEntity(event.player, "bountifulmod:cannabisbgm", 1.0F, 1.0F);
             
    		
	    		//一度だけ実行させるためのフラグ。Falseのときのみ実行されるため、2度目以降は実行されない
	    		Flag2=true;
    			}
    			}
	    	}
	    	if(calculation2 == 903){Flag2= false;}
	    	//3秒ほど後にまたFlagをfalseにして、フラッシュバックが何度でも起こるようにしている。
    		
		   //-------------粉---------------
    	long calculation3 = (nowtime - ItemCannabisPowder.depstartedtime)/1000L; //現在時間 - 使用時にセットした時間を秒単位に修正
	
    	if(!Flag3){
    	if(ItemCannabisPowder.depStart=true){//保険。意味はないと思うが、誤作動の防止目的
    	if(calculation3 == 900)//900だった場合(=15分)
    	{
		
    		//Worldのインスタンス取得。
    		World world = Minecraft.getMinecraft().theWorld;

    		//以下、吐き気のポーション。設定の意味はItemCannabisLeaf他参照
    		int potionID = Potion.confusion.id;
    		int duration = 120 * 20;
    		int amplifier = 2;

    		PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
		
    		//効果付与
    		event.player.addPotionEffect(Effect);
         
    		world.playSoundAtEntity(event.player, "bountifulmod:cannabisbgm", 1.0F, 1.0F);
         
		
    		//一度だけ実行させるためのフラグ。Falseのときのみ実行されるため、2度目以降は実行されない
    		Flag3=true;
			}
			}
    	}
    	if(calculation3 == 903){Flag3= false;}
    	//3秒ほど後にまたFlagをfalseにして、フラッシュバックが何度でも起こるようにしている。
    	
		   //-------------異様な植物---------------
 	long calculation4 = (nowtime - ItemDryCannabisLeaf.depstartedtime)/1000L; //現在時間 - 使用時にセットした時間を秒単位に修正
	
 	if(!Flag4){
 	if(ItemOPoppy.depStart=true){//保険。意味はないと思うが、誤作動の防止目的
 	if(calculation4 == 900)//900だった場合(=15分)
 	{
		
 		//Worldのインスタンス取得。
 		World world = Minecraft.getMinecraft().theWorld;

 		//以下、吐き気のポーション。設定の意味はItemCannabisLeaf他参照
 		int potionID = Potion.confusion.id;
 		int duration = 120 * 20;
 		int amplifier = 2;

 		PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
		
 		//効果付与
 		event.player.addPotionEffect(Effect);
      
 		world.playSoundAtEntity(event.player, "bountifulmod:cannabisbgm", 1.0F, 1.0F);
      
		
 		//一度だけ実行させるためのフラグ。Falseのときのみ実行されるため、2度目以降は実行されない
 		Flag4=true;
			}
			}
 	}
 	if(calculation4 == 903){Flag4= false;}
 	//3秒ほど後にまたFlagをfalseにして、フラッシュバックが何度でも起こるようにしている。
		
    	
			
		   //-------------異様な植物の乾燥物---------------
	long calculation5 = (nowtime - ItemDryOPoppy.depstartedtime)/1000L; //現在時間 - 使用時にセットした時間を秒単位に修正
	
	if(!Flag5){
	if(ItemDryOPoppy.depStart=true){//保険。意味はないと思うが、誤作動の防止目的
	if(calculation5 == 900)//900だった場合(=15分)
	{
		
		//Worldのインスタンス取得。
		World world = Minecraft.getMinecraft().theWorld;

		//以下、吐き気のポーション。設定の意味はItemCannabisLeaf他参照
		int potionID = Potion.confusion.id;
		int duration = 120 * 20;
		int amplifier = 2;

		PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
		
		//効果付与
		event.player.addPotionEffect(Effect);
   
		world.playSoundAtEntity(event.player, "bountifulmod:cannabisbgm", 1.0F, 1.0F);
   
		
		//一度だけ実行させるためのフラグ。Falseのときのみ実行されるため、2度目以降は実行されない
		Flag5=true;
			}
			}
	}
	if(calculation5 == 903){Flag5= false;}
	//3秒ほど後にまたFlagをfalseにして、フラッシュバックが何度でも起こるようにしている。
	
	   //-------------異様な植物の粉末---------------
long calculation6 = (nowtime - ItemOPoppyPowder.depstartedtime)/1000L; //現在時間 - 使用時にセットした時間を秒単位に修正

if(!Flag6){
if(ItemOPoppyPowder.depStart=true){//保険。意味はないと思うが、誤作動の防止目的
if(calculation6 == 900)//900だった場合(=15分)
{
	
	//Worldのインスタンス取得。
	World world = Minecraft.getMinecraft().theWorld;

	//以下、吐き気のポーション。設定の意味はItemCannabisLeaf他参照
	int potionID = Potion.confusion.id;
	int duration = 120 * 20;
	int amplifier = 2;

	PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
	
	//効果付与
	event.player.addPotionEffect(Effect);

	world.playSoundAtEntity(event.player, "bountifulmod:cannabisbgm", 1.0F, 1.0F);

	
	//一度だけ実行させるためのフラグ。Falseのときのみ実行されるため、2度目以降は実行されない
	Flag6=true;
		}
		}
}
if(calculation6 == 903){Flag6= false;}
//3秒ほど後にまたFlagをfalseにして、フラッシュバックが何度でも起こるようにしている。
}


		@SubscribeEvent
		public void onRenderTick(TickEvent.RenderTickEvent event)
		{
			/*
			 * ここにRenderに関するtick処理を書く.
			 * event.renderTickTimeでtick timeを取得できる.
			 */
	}
	     }

	        
	    




