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
		GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick,1,0),new ItemStack(Blocks.stonebrick,1,2),0.1f);
		 
		     
		GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.itemCannabisLeaf,4),
				new ItemStack(BountifulBlocksCore.itemCannabisPlant,1)
				);
		     
		GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockCannabis),
		    	"##",
		    	"##",
	             '#',new ItemStack(Items.wheat_seeds)
				);
		     
		GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockCannabis,3),
				"@@",
				"@@",
				'@', new ItemStack(BountifulBlocksCore.itemCannabisPlant,1)
				);
		     
		GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.itemCannabisPowder,2),
				new ItemStack(BountifulBlocksCore.itemCannabisLeaf,1)
				);
		     
		GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.itemOpiumPoppy,4),
				new ItemStack(BountifulBlocksCore.itemOpiumPoppyPlant,1)
				);
		     
		GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockOpiumPoppy),
				"#",
				"#",
				'#',new ItemStack(Items.wheat_seeds)
				);
		    	
		GameRegistry.addRecipe(new ItemStack(BountifulBlocksCore.blockOpiumPoppy,3),
				"@@",
				"@@",
				'@', new ItemStack(BountifulBlocksCore.itemOpiumPoppyPlant,1)
				);
		     
		GameRegistry.addShapelessRecipe(new ItemStack(BountifulBlocksCore.itemOpiumPoppyPowder,2),
				new ItemStack(BountifulBlocksCore.itemOpiumPoppy,1)
		  	);
		     }
}
