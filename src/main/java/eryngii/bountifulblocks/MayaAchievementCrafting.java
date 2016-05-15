package eryngii.bountifulblocks;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MayaAchievementCrafting  extends MayaAchievementBase {

	//クラフトを取得して実績解除するためのもの。
	
	//第一引数に実績のシステム名、第2引数にx軸位置、第3引数にy軸位置、第4引数にアイコンになり、尚且つ解除のトリガーとなるアイテム、
	//第5引数に前提となる別の実績(無い場合はnull)、第6引数には種類を登録する(今回は1種類)
    public MayaAchievementCrafting(String Str, int int1, int int2, ItemStack Stack, Achievement ach, ArrayList<Achievement> a) {
        super(Str, int1, int2, Stack, ach, a);
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onItemCraftedEvent(ItemCraftedEvent event) {
        if (checkItem(event.crafting, this.theItemStack) && event.player != null) {
            event.player.addStat(this, 1);
        }
    }

    private boolean checkItem(ItemStack p_151397_1_, ItemStack p_151397_2_) {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }


}