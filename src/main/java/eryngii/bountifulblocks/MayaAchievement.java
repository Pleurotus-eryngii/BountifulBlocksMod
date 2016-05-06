package eryngii.bountifulblocks;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MayaAchievement extends Achievement
{

	
	
	public final MayaAchievementManager.Key key;
    private List<AchievementTrigger> trigger = Lists.newArrayList();

    public static MayaAchievement create(MayaAchievementManager.Key key, int par3, int par4, Object obj, MayaAchievementManager.Key relation)
    {
    	//本当は種類ごとにBlock,ItemStackに振り分けるのだが、Itemしか使わないのでそのまま返している
    	return new MayaAchievement(key, par3, par4, (Item)obj, relation);
        /*if (obj instanceof Block)
        {
            return new MayaAchievement(key, par3, par4, (Block)obj, relation);
        }
        else if (obj instanceof Item)
        {
            return new MayaAchievement(key, par3, par4, (Item)obj, relation);
        }
       /*else if (obj instanceof ItemStack)
        {
            return new MayaAchievement(key, par3, par4, (ItemStack)obj, relation);
        }

        
        throw new RuntimeException("Caught an error in achievement registration.");
    */
    }

    private MayaAchievement(MayaAchievementManager.Key key, int par3, int par4, Block block, MayaAchievementManager.Key relation)
    {
        super(getId(key.name()), getId(key.name()), par3, par4, block, MayaAchievementManager.get(relation));
        this.key = key;
    }

    private MayaAchievement(MayaAchievementManager.Key key, int par3, int par4, Item item, MayaAchievementManager.Key relation)
    {
        super(getId(key.name()), getId(key.name()), par3, par4, item, MayaAchievementManager.get(relation));
        this.key = key;
    }

    private MayaAchievement(MayaAchievementManager.Key key, int par3, int par4, ItemStack itemstack, MayaAchievementManager.Key relation)
    {
        super(getId(key.name()), getId(key.name()), par3, par4, itemstack, MayaAchievementManager.get(relation));
        this.key = key;
    }

    private static String getId(String name)
    {
        return BountifulBlocksCore.resourceDomain + name;
    }

    public MayaAchievement setTriggerItemPickup(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchievementManager.itemPickupMap.contains(this))
        {
            MayaAchievementManager.itemPickupMap.add(this);
        }
        return this;
    }

    public MayaAchievement setTriggerItemCrafting(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchievementManager.itemCraftingMap.contains(this))
        {
            MayaAchievementManager.itemCraftingMap.add(this);
        }
        return this;
    }

    public MayaAchievement setTriggerSmelting(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchievementManager.itemSmeltingMap.contains(this))
        {
            MayaAchievementManager.itemSmeltingMap.add(this);
        }
        return this;
    }

    public MayaAchievement setTriggerTfCondenser(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchievementManager.itemCraftingMap.contains(this))
        {
            MayaAchievementManager.itemCraftingMap.add(this);
        }
        return this;
    }

    @Override
    public MayaAchievement initIndependentStat()
    {
        super.initIndependentStat();
        return this;
    }

    @Override
    public MayaAchievement setSpecial()
    {
        super.setSpecial();
        return this;
    }

    @Override
    public MayaAchievement registerStat()
    {
        super.registerStat();
        MayaAchievementManager.add(this);
        return this;
    }

    public List<AchievementTrigger> getTrigger()
    {
        return this.trigger;
    }

    public boolean triggerMatches(ItemStack itemStack)
    {
        for (AchievementTrigger trigger : this.trigger)
        {
            if (trigger.equals(itemStack))
            {
                return true;
            }
        }
        return false;
    }
    
}
