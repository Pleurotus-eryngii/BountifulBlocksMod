package eryngii.bountifulblocks;

import java.awt.Color;
import java.io.File;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import eryngii.bountifulblocks.blocks.BarrierBlock;
import eryngii.bountifulblocks.blocks.BoneBlock;
import eryngii.bountifulblocks.blocks.CRSSBlock;
import eryngii.bountifulblocks.blocks.CoarseDirtBlock;
import eryngii.bountifulblocks.blocks.DioriteBlock;
import eryngii.bountifulblocks.blocks.FenceBlockX;
import eryngii.bountifulblocks.blocks.MagmaBlock;
import eryngii.bountifulblocks.blocks.PurpurPillarBlock;
import eryngii.bountifulblocks.blocks.RedSandStoneBlock;
import eryngii.bountifulblocks.blocks.SRSSBlock;
import eryngii.bountifulblocks.blocks.SeaLanternBlock;
import eryngii.bountifulblocks.item.ItemCoarseDirtBlock;
import eryngii.bountifulblocks.item.ItemCookedRabbit;
import eryngii.bountifulblocks.item.ItemDioriteBlock;
import eryngii.bountifulblocks.item.ItemFenceBlockX;
import eryngii.bountifulblocks.item.ItemHuskEgg;
import eryngii.bountifulblocks.item.ItemPolarBearEgg;
import eryngii.bountifulblocks.item.ItemRabbitEgg;
import eryngii.bountifulblocks.item.ItemRabbitFoot;
import eryngii.bountifulblocks.item.ItemRawRabbit;
import eryngii.bountifulblocks.item.ItemStrayEgg;
import eryngii.bountifulblocks.mobs.EntityHusk;
import eryngii.bountifulblocks.mobs.EntityPolarBear;
import eryngii.bountifulblocks.mobs.EntityRabbit;
import eryngii.bountifulblocks.mobs.EntityStray;
import eryngii.bountifulblocks.mobs.RenderHusk;
import eryngii.bountifulblocks.mobs.RenderPolarBear;
import eryngii.bountifulblocks.mobs.RenderRabbit;
import eryngii.bountifulblocks.mobs.RenderStray;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

/*
 * コメントアウトでエリンギの解説が付いています。
 * 分かる範囲でしか解説していないため、曖昧な部分や誤った部分も多いかと思いますので、
 * あくまで参考程度に
 */

@Mod(modid="bountifulblocksmod", name="1.8/1.9/1.10BlocksMod", version="Beta1.0")

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

		public static Item rabbitEgg;
		public static Item polarBearEgg;
		public static Item strayEgg;
		public static Item huskEgg;
		
		public static Item rabbitHide;
		public static Item rawRabbit;
		public static Item cookedRabbit;
		public static Item rabbitFoot;
		

	    
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
			

					
					//カラーコードをColorに変換して色を取得する。Pは全体色、Sは斑点
					int intRabbitP = Integer.parseInt( "936c59",16);
					Color rabbitPrimary = new Color( intRabbitP );
					int intRabbitS = Integer.parseInt( "513830",16);
					Color rabbitSecondary = new Color( intRabbitS );

					
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
					
					int intStrayP = Integer.parseInt( "617617",16);
					Color strayPrimary = new Color( intStrayP );
					int intStrayS = Integer.parseInt( "9babac",16);
					Color straySecondary = new Color( intStrayS );
					
			strayEgg = new ItemStrayEgg(strayPrimary.getRGB() , straySecondary.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(CreativeTabs.tabMisc)
					//システム名の登録
					.setUnlocalizedName("StrayEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(strayEgg, "StrayEgg");
					

					int intHuskP = Integer.parseInt( "59503b",16);
					Color huskPrimary = new Color( intHuskP );
					int intHuskS = Integer.parseInt( "e6cc94",16);
					Color huskSecondary = new Color( intHuskS );
					
			huskEgg = new ItemHuskEgg(huskPrimary.getRGB() , huskSecondary.getRGB())
					//クリエイティブタブの登録
					.setCreativeTab(CreativeTabs.tabMisc)
					//システム名の登録
					.setUnlocalizedName("HuskEgg")
					//テクスチャ名の登録
					.setTextureName("spawn_egg");
					//GameRegistryへの登録
					GameRegistry.registerItem(huskEgg, "HuskEgg");
			
			rabbitHide = new Item()
					//クリエイティブタブの登録
					.setCreativeTab(CreativeTabs.tabMaterials)
					//システム名の登録
					.setUnlocalizedName("RabbitHide")
					//テクスチャ名の登録
					.setTextureName("bountifulmod:rabbithide");
					//GameRegistryへの登録
					GameRegistry.registerItem(rabbitHide, "RabbitHide");

			rawRabbit = (new ItemRawRabbit(3, 1.0F, true));
			GameRegistry.registerItem(rawRabbit, "RawRabbit");
			
			cookedRabbit = (new ItemCookedRabbit(5, 1.0F, true));
			GameRegistry.registerItem(cookedRabbit, "CookedRabbit");
			
			rabbitFoot = (new ItemRabbitFoot(0, 0.0F, false));
			GameRegistry.registerItem(rabbitFoot, "RabbitFoot");
			
			

	
			
			
	}
	    
		
	  @Mod.EventHandler
	  public void init(FMLInitializationEvent event){
			/*
			 * Eventの登録
			 */
			FMLCommonHandler.instance().bus().register(this);
			
		  //盆栽マンの登録。スポーン地点を大量に登録しているが動くかどうかは不明
		    EntityRegistry.registerModEntity(EntityRabbit.class, "RabbitEntity", 2, this, 250, 1, false);
		    EntityRegistry.registerModEntity(EntityPolarBear.class, "PolarBearEntity", 3, this, 250, 1, false);
		    EntityRegistry.registerModEntity(EntityStray.class, "StrayEntity", 4, this, 250, 1, false);
		    EntityRegistry.registerModEntity(EntityHusk.class, "HuskEntity", 5, this, 250, 1, false);
		     
			 
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.desert);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.forest);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.taiga);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.coldTaiga);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.coldTaigaHills);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.iceMountains);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.jungleHills);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.forestHills);
		     EntityRegistry.addSpawn(EntityRabbit.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.desertHills);
		     EntityRegistry.addSpawn(EntityHusk.class, 20, 1, 4, EnumCreatureType.monster, BiomeGenBase.desert);
		     EntityRegistry.addSpawn(EntityHusk.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.desertHills);
		     EntityRegistry.addSpawn(EntityStray.class, 20, 1, 4, EnumCreatureType.monster, BiomeGenBase.icePlains);
		     EntityRegistry.addSpawn(EntityStray.class, 20, 1, 4, EnumCreatureType.creature, BiomeGenBase.iceMountains);
	        //Render設定
	        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RenderRabbit());
			RenderingRegistry.registerEntityRenderingHandler(EntityPolarBear.class, new RenderPolarBear());
			RenderingRegistry.registerEntityRenderingHandler(EntityStray.class, new RenderStray());
			RenderingRegistry.registerEntityRenderingHandler(EntityHusk.class, new RenderHusk());
	        }

	 

	                

	    		  	//レシピ登録
	    		  RecipeRegister.init();

	    	        }
	  

	     }

	        
	    




