package eryngii.bountifulblocks;

import eryngii.bountifulblocks.MayaAchiManager.Key;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MayaAchis 
{
	

		public static void load()
	    {
		
	 
	    	MayaAchi.create(Key.CallingFrom, -3, 0, BountifulBlocksCore.itemCannabisPlant,null)
	    	.setTriggerItemCrafting (new ItemStack(BountifulBlocksCore.blockCannabis))
            .registerStat();
	        
	    	MayaAchi.create(Key.DangerousChallenge, 0, 0, BountifulBlocksCore.itemCannabisLeaf, Key.CallingFrom)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.itemCannabisLeaf))
            .registerStat();
	    	
	    	MayaAchi.create(Key.MoreEffect, 3, 0, BountifulBlocksCore.itemCannabisPowder, Key.CallingFrom)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.itemCannabisPowder))
            .registerStat();
	    	
	    	MayaAchi.create(Key.Poppy, -3, 3, BountifulBlocksCore.itemOpiumPoppyPlant, null)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.blockOpiumPoppy))
            .registerStat();
	    	
	    	MayaAchi.create(Key.NotFlower, 0, 3, BountifulBlocksCore.itemOpiumPoppy, Key.Poppy)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.itemOpiumPoppy))
            .registerStat();
	    	
	    	MayaAchi.create(Key.Deeply, 3, 3, BountifulBlocksCore.itemOpiumPoppyPowder, Key.NotFlower)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.itemOpiumPoppyPowder))
            .registerStat();
	    	
	    	// Add a new achievement page for the mod
	        Achievement[] array = MayaAchiManager.getAllAsArray();
	        AchievementPage.registerAchievementPage(new AchievementPage("MayaCraft", array));

	        if (!MayaAchiManager.unregisteredKeys.isEmpty())
	        {
	            throw new IllegalStateException(String.format("Unregistered Achievements Found: %s", MayaAchiManager.unregisteredKeys));
	        }
	    }
	}

