package eryngii.bountifulblocks;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MayaAchievements {

    private static ArrayList<Achievement> core = new ArrayList<Achievement>();
    //Core
    public static Achievement CallingFrom;
    public static Achievement DangerousChallenge;
    public static Achievement MoreEffect;
    public static Achievement Poppy;
    public static Achievement NotFlower;
    public static Achievement Deeply;

    public static void initAchievements() {

    	//第3引数のItemStackに登録したアイテムやブロックがクラフトされた際に実績が取得されるようになっている
        CallingFrom = new MayaAchievementCrafting("CallingFrom", -3, 0, new ItemStack(BountifulBlocksCore.blockCannabis), (Achievement) null, core).registerStat();
        DangerousChallenge = new MayaAchievementCrafting("DangerousChallenge", 0, 0, new ItemStack(BountifulBlocksCore.itemCannabisLeaf), CallingFrom,core).registerStat();
        MoreEffect = new  MayaAchievementCrafting("MoreEffect", 3, 0, new ItemStack(BountifulBlocksCore.itemCannabisPowder), DangerousChallenge,core).registerStat();
        Poppy = new  MayaAchievementCrafting("Poppy", -3, 3, new ItemStack(BountifulBlocksCore.blockOpiumPoppy), null,core).registerStat();
        NotFlower = new  MayaAchievementCrafting("NotFlower", 0, 3, new ItemStack(BountifulBlocksCore.itemOpiumPoppy), Poppy,core).registerStat();
        Deeply = new MayaAchievementCrafting("Deeply", 3, 3, new ItemStack(BountifulBlocksCore.itemOpiumPoppyPowder), NotFlower,core).registerStat();
        AchievementPage.registerAchievementPage(new AchievementPageBase("achievement.bountifulmod", core));

    }

}