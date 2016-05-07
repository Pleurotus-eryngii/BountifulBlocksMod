package eryngii.bountifulblocks;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MayaAchievementBase extends Achievement {


	//ベース。Craftingに継承するために置いてあるが、これ自体を利用する場合もある
    public MayaAchievementBase(String Str, int int1, int int2, ItemStack Stack, Achievement ach, ArrayList<Achievement> a) {
        super("achievement.bountifulmod" + Str, "bountifulmod." + Str, int1, int2, Stack, ach);
        a.add(this);
    }



}
