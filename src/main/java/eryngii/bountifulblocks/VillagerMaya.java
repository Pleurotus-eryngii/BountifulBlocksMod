package eryngii.bountifulblocks;

import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class VillagerMaya  implements IVillageTradeHandler {
	 
		@Override
		public void manipulateTradesForVillager(EntityVillager villager,
				MerchantRecipeList recipeList, Random random) {
			/*
			 * 今回新しく作成した職業用の取引内容を登録します
			 * 既存の職業に取引を追加したりもできます
			 */
			//if(villager.getProfession() == AddTrade.sampleVillagerProfession) {
				/*
				 * エメラルド１個で葉っぱ或いは実x10または粉x5
				 */
				recipeList.add(new MerchantRecipe( new ItemStack(Items.emerald, 1, 0), (new ItemStack(BountifulBlocksCore.itemCannabisLeaf, 10, 0))));
				recipeList.add(new MerchantRecipe( new ItemStack(Items.emerald, 1, 0), (new ItemStack(BountifulBlocksCore.itemOpiumPoppy, 10, 0))));
				recipeList.add(new MerchantRecipe( new ItemStack(Items.emerald, 1, 0), (new ItemStack(BountifulBlocksCore.itemCannabisPowder, 10, 0))));
				recipeList.add(new MerchantRecipe( new ItemStack(Items.emerald, 1, 0), (new ItemStack(BountifulBlocksCore.itemOpiumPoppyPowder, 10, 0))));
				/*
				 * ブレイズロッド１個を村人に売ってエメラルド２個を買う取引を登録
				 */
				recipeList.add(new MerchantRecipe( new ItemStack(BountifulBlocksCore.itemCannabisLeaf), new ItemStack(Items.emerald, 2, 0)));
			//}
		}
}
