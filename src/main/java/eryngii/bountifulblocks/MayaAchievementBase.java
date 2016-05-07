package eryngii.bountifulblocks;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MayaAchievementBase extends Achievement {


    public MayaAchievementBase(String Str, int int1, int int2, ItemStack Stack, Achievement ach, ArrayList<Achievement> a) {
        super("achievement.bountifulmod" + Str, "bountifulmod." + Str, int1, int2, Stack, ach);
        a.add(this);
    }



}
