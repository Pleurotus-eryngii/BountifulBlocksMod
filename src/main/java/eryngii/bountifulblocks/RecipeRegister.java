package eryngii.bountifulblocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeRegister {
	public static void init(){
		
		//以下レシピ登録
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,2,0),
	            "#@",
	            "@#",
	            '#', Blocks.cobblestone,
	            '@', Items.quartz
	    );

	    GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,2,1),
	    	       new ItemStack(BountifulBlocksCore.blockDiorite,1,0),
	    	       Blocks.cobblestone
	    	);
	    
	    GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,2,2),
	    		new ItemStack(BountifulBlocksCore.blockDiorite,1,0),
	 	       Items.quartz
	 	);
		
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,4,3),
	            "##",
	            "##",
	            '#', new ItemStack(BountifulBlocksCore.blockDiorite,1,0)
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,4,4),
	            "##",
	            "##",
	            '#', new ItemStack(BountifulBlocksCore.blockDiorite,1,1)
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,4,5),
	            "##",
	            "##",
	            '#', new ItemStack(BountifulBlocksCore.blockDiorite,1,2)
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockCoarseDirt,4,0),
	            "#@",
	            "@#",
	            '#', Blocks.gravel,
	            '@', Blocks.dirt
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,4,8),
	            "#@",
	            "@#",
	            '#', new ItemStack(Items.dye,1,4),
	            '@', Blocks.cobblestone
	    );
	    
	    
	    GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,9),
	    		new ItemStack(BountifulBlocksCore.blockDiorite,1,8),
	 	        new ItemStack(Items.dye,1,2)
	 	);
	    
	    GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,10),
	    		new ItemStack(BountifulBlocksCore.blockDiorite,1,8),
	 	        new ItemStack(Items.dye,1,1)
	 	);
	    
	    GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,11),
	    		new ItemStack(BountifulBlocksCore.blockDiorite,1,8),
	 	        new ItemStack(Items.dye,1,4)
	 	);

	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,14),
	            "###",
	            "###",
	            "###",
	            '#', new ItemStack(Items.nether_wart)
	   
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,15),
	            "@#",
	            "#@",
	            '#', new ItemStack(Items.nether_wart),
	            '@', new ItemStack(Items.netherbrick)
	   
	    );
	    

	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockBone,1),
	            "###",
	            "###",
	            "###",
	            '#', new ItemStack(Items.dye,1,15)
	   
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,4,6),
	            "##",
	            "##",
	            '#', new ItemStack(BountifulBlocksCore.blockDiorite,1,8)
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,4,7),
	            "###",
	            "#@#",
	            "###",
	            '#', new ItemStack(BountifulBlocksCore.blockDiorite,1,8),
	            '@', new ItemStack(Items.dye,1,0)
	    );
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockSeaLantern),
	            "###",
	            "#@#",
	            "###",
	            '#', new ItemStack(BountifulBlocksCore.blockDiorite,1,8) ,
	            '@', Blocks.redstone_lamp
	    );
	   
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockMagma),
	            "##",
	            "##",
	            '#', new ItemStack(Items.magma_cream) 
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockRedSandStone),
	            "##",
	            "##",
	            '#', new ItemStack(Blocks.sand,1,1)
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockSmoothRedSandStone),
	            "##",
	            "##",
	            '#', new ItemStack(BountifulBlocksCore.blockRedSandStone)
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockChiseledRedSandStone,3),
	            "###",
	            "   ",
	            "###",
	            '#', new ItemStack(BountifulBlocksCore.blockRedSandStone)
	   
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
	    

	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,13),
	            "##",
	            "##",
	            '#', Blocks.end_stone
	    );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockDiorite,1,12),
	            "#@",
	            "@#",
	            '#', Blocks.end_stone,
	            '@', new ItemStack(Items.dye,1,5)
	      );
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockPurpurPillar),
	            "@",
	            "@",
	            '@', new ItemStack(BountifulBlocksCore.blockDiorite,1,12)
	      );
	    
	   GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockFenceX,4,0),
	            "   ",
	    		"@@@",
	            "@ @",
	            '@', new ItemStack(Blocks.planks,1,4)
	      );
	      
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockFenceX,4,1),
	            "   ",
	    		"@@@",
	            "@ @",
	            '@', new ItemStack(Blocks.planks,1,5)
	      );
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockFenceX,4,2),
	    		"   ",
	    		"@@@",
	            "@ @",
	            '@', new ItemStack(Blocks.planks,1,2)
	      );
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockFenceX,4,3),
	    		"   ",
	    		"@@@",
	            "@ @",
	            '@', new ItemStack(Blocks.planks,1,1)
	      );
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockFenceX,4,4),
	    		"   ",
	    		"@@@",
	            "@ @",
	            '@', new ItemStack(Blocks.planks,1,3)
	      );
	      
	    GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.blockCoarseDirt,3,1),
	    		new ItemStack(Blocks.dirt,9)
	 	);
	    
	    GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockBarrier),
	            "###",
	            "# #",
	            "###",
	            '#', Blocks.glass
	            );
	    
	    GameRegistry.addRecipe(new ItemStack(Items.leather),
	            "##",
	            "##",
	            '#', BountifulBlocksCore.rabbitHide
	    );
	    
		GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick,1,0),new ItemStack(Blocks.stonebrick,1,2),0.1f);
		GameRegistry.addSmelting(new ItemStack(BountifulBlocksCore.rawRabbit,1),new ItemStack(BountifulBlocksCore.cookedRabbit,1),0.35f);
		 
		     
		

		     }
}
