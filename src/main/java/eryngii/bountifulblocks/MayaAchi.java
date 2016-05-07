package eryngii.bountifulblocks;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class MayaAchi extends Achievement
{
	
	
	public final MayaAchiManager.Key key;
    private List<AchievementTrigger> trigger = Lists.newArrayList();

    public static MayaAchi create(MayaAchiManager.Key key, int par3, int par4, Object obj, MayaAchiManager.Key relation)
    {
        if (obj instanceof Block)
        {
            return new MayaAchi(key, par3, par4, (Block)obj, relation);
        }
        else if (obj instanceof Item)
        {
            return new MayaAchi(key, par3, par4, (Item)obj, relation);
        }
       else if (obj instanceof ItemStack)
        {
            return new MayaAchi(key, par3, par4, (ItemStack)obj, relation);
        }

        
        throw new RuntimeException("Caught an error in achievement registration.");
    
    }

    private MayaAchi(MayaAchiManager.Key key, int par3, int par4, Block block, MayaAchiManager.Key relation)
    {
        super(getId(key.name()), getId(key.name()), par3, par4, block, MayaAchiManager.get(relation));
        this.key = key;
    }

    private MayaAchi(MayaAchiManager.Key key, int par3, int par4, Item item, MayaAchiManager.Key relation)
    {
        super(getId(key.name()), getId(key.name()), par3, par4, item, MayaAchiManager.get(relation));
        this.key = key;
    }

    private MayaAchi(MayaAchiManager.Key key, int par3, int par4, ItemStack itemstack, MayaAchiManager.Key relation)
    {
        super(getId(key.name()), getId(key.name()), par3, par4, itemstack, MayaAchiManager.get(relation));
        this.key = key;
    }

    private static String getId(String name)
    {
        return BountifulBlocksCore.resourceDomain + name;
    }

    public MayaAchi setTriggerItemPickup(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchiManager.itemPickupMap.contains(this))
        {
            MayaAchiManager.itemPickupMap.add(this);
        }
        return this;
    }

    public MayaAchi setTriggerItemCrafting(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchiManager.itemCraftingMap.contains(this))
        {
            MayaAchiManager.itemCraftingMap.add(this);
        }
        return this;
    }

    public MayaAchi setTriggerSmelting(ItemStack item)
    {
        this.trigger.add(new TriggerItem(item));
        if (!MayaAchiManager.itemSmeltingMap.contains(this))
        {
            MayaAchiManager.itemSmeltingMap.add(this);
        }
        return this;

    }


    @Override
    public MayaAchi initIndependentStat()
    {
        super.initIndependentStat();
        return this;
    }

    @Override
    public MayaAchi setSpecial()
    {
        super.setSpecial();
        return this;
    }

    @Override
    public MayaAchi registerStat()
    {
        super.registerStat();
        MayaAchiManager.add(this);
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
  

