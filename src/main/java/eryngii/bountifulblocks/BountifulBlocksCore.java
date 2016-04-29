package eryngii.bountifulblocks;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/*
 * コメントアウトでエリンギの解説が付いています。
 * 分かる範囲でしか解説していないため、曖昧な部分や誤った部分も多いかと思いますので、
 * あくまで参考程度に
 */

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
	  
	  public static Block blockSeaLantern;

	  //面ごとにテクスチャが違うブロック。処理が面倒なので個別登録
	  //処理についてはRedSandstoneのほうに解説をつけ、他は省略しました
	  public static Block blockRedSandStone;
	  public static Block blockSmoothRedSandStone;
	  public static Block blockChiseledRedSandStone;
	  public static Block blockPurpurPillar;
	  

	  @EventHandler
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
			if(BountifulBlocksConfig.is1_8Mode){
			//Fence類は全て1.8モードが有効であれば登録
			blockFenceX = new FenceBlockX("", Material.wood);
			GameRegistry.registerBlock(blockFenceX, ItemFenceBlockX.class, "blockFenceX");
			}
		
			/*以下メタデータを保持しないブロック類*/
			if(BountifulBlocksConfig.is1_8Mode){
			//1.8モードが有効であれば登録
			blockRedSandStone = new RedSandStoneBlock();
			GameRegistry.registerBlock(blockRedSandStone, "blockRedSandStone");

			blockChiseledRedSandStone = new CRSSBlock();
			GameRegistry.registerBlock(blockChiseledRedSandStone, "blockCRSS");
			}
			
			if(BountifulBlocksConfig.is1_9Mode){
			//1.9モードが有効であれば登録
			blockSmoothRedSandStone = new SRSSBlock();
			GameRegistry.registerBlock(blockSmoothRedSandStone, "blockSRSS");

			blockPurpurPillar = new PurpurPillarBlock();
			GameRegistry.registerBlock(blockPurpurPillar, "blockPurpurPillar");
		
			}
		//以下レシピ登録
        GameRegistry.addRecipe(new ItemStack(blockDiorite,2,0),
                "#@",
                "@#",
                '#', Blocks.cobblestone,
                '@', Items.quartz
        );

        GameRegistry.addShapelessRecipe(new ItemStack(blockDiorite,2,1),
        	       new ItemStack(blockDiorite,1,0),
        	       Blocks.cobblestone
        	);
        
        GameRegistry.addShapelessRecipe(new ItemStack(blockDiorite,2,2),
        		new ItemStack(blockDiorite,1,0),
     	       Items.quartz
     	);
	
        GameRegistry.addRecipe(new ItemStack(blockDiorite,4,3),
                "##",
                "##",
                '#', new ItemStack(blockDiorite,1,0)
        );
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,4,4),
                "##",
                "##",
                '#', new ItemStack(blockDiorite,1,1)
        );
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,4,5),
                "##",
                "##",
                '#', new ItemStack(blockDiorite,1,2)
        );
        
        GameRegistry.addRecipe(new ItemStack(blockCoarseDirt,4,0),
                "#@",
                "@#",
                '#', Blocks.gravel,
                '@', Blocks.dirt
        );
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,4,8),
                "#@",
                "@#",
                '#', new ItemStack(Items.dye,1,4),
                '@', Blocks.cobblestone
        );
        
        
        GameRegistry.addShapelessRecipe(new ItemStack(blockDiorite,1,9),
        		new ItemStack(blockDiorite,1,8),
     	        new ItemStack(Items.dye,1,2)
     	);
        
        GameRegistry.addShapelessRecipe(new ItemStack(blockDiorite,1,10),
        		new ItemStack(blockDiorite,1,8),
     	        new ItemStack(Items.dye,1,1)
     	);
        
        GameRegistry.addShapelessRecipe(new ItemStack(blockDiorite,1,11),
        		new ItemStack(blockDiorite,1,8),
     	        new ItemStack(Items.dye,1,4)
     	);
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,4,6),
                "##",
                "##",
                '#', new ItemStack(blockDiorite,1,8)
        );
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,4,8),
                "###",
                "#@#",
                "###",
                '#', new ItemStack(blockDiorite,1,8),
                '@', new ItemStack(Items.dye,1,0)
        );
        
        GameRegistry.addRecipe(new ItemStack(blockRedSandStone),
                "##",
                "##",
                '#', new ItemStack(Blocks.sand,1,1)
        );
        
        GameRegistry.addRecipe(new ItemStack(blockSmoothRedSandStone),
                "##",
                "##",
                '#', new ItemStack(blockRedSandStone)
        );
        
        GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick,1,3),
                "#",
                "#",
                '#', new ItemStack(Blocks.stone_slab,1,5)
        );
        
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone),
        		Blocks.cobblestone,
     	        new ItemStack(Blocks.vine)
     	);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick,1,1),
        		new ItemStack(Blocks.stonebrick,1,0),
     	        new ItemStack(Blocks.vine)
     	);
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,1,13),
                "##",
                "##",
                '#', Blocks.end_stone
        );
        
        GameRegistry.addRecipe(new ItemStack(blockDiorite,1,12),
                "#@",
                "@#",
                '#', Blocks.end_stone,
                '@', new ItemStack(Items.dye,1,5)
          );
		}
	
	  @Mod.EventHandler
	    public void init(FMLInitializationEvent event){
	 
	        GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick,1,0),new ItemStack(Blocks.stonebrick,1,2),0.1f);
	 
	            }
	        
	    

}


