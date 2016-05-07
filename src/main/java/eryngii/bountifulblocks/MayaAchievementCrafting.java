package eryngii.bountifulblocks;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MayaAchievementCrafting  extends MayaAchievementBase {

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