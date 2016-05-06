package eryngii.bountifulblocks;

import eryngii.bountifulblocks.MayaAchievementManager.Key;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MayaAchievements 
{
	

		public static void load()
	    {
		
	 
	    	MayaAchievement.create(Key.CallingFrom, -3, 0, BountifulBlocksCore.itemCannabisPlant,null)
	    	.setTriggerItemCrafting (new ItemStack(BountifulBlocksCore.blockCannabis))
            .registerStat();
	        
	    	MayaAchievement.create(Key.DangerousChallenge, 0, 0, BountifulBlocksCore.itemCannabisLeaf, Key.CallingFrom)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.itemCannabisLeaf,1,0))
            .registerStat();
	    	
	    	MayaAchievement.create(Key.MoreEffect, 3, 0, BountifulBlocksCore.itemCannabisPowder, Key.CallingFrom)
	    	.setTriggerItemCrafting(new ItemStack(BountifulBlocksCore.itemCannabisPowder,1,0))
            .registerStat();
	    	// Add a new achievement page for the mod
	        Achievement[] array = MayaAchievementManager.getAllAsArray();
	        AchievementPage.registerAchievementPage(new AchievementPage("MayaCraft", array));

	        if (!MayaAchievementManager.unregisteredKeys.isEmpty())
	        {
	            throw new IllegalStateException(String.format("Unregistered Achievements Found: %s", MayaAchievementManager.unregisteredKeys));
	        }
	    }
	}

