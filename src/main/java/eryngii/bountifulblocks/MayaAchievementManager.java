package eryngii.bountifulblocks;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MayaAchievementManager {
	    public static enum Key
	    {
	        CallingFrom(0), DangerousChallenge(1), MoreEffect(3);

	        Key(int localId)
	        {
	        }
	    }

	    public static Map<Key, MayaAchievement> achievementList = Maps.newEnumMap(Key.class);
	    public static ArrayList<MayaAchievement> itemPickupMap = Lists.newArrayList();
	    public static ArrayList<MayaAchievement> itemCraftingMap = Lists.newArrayList();
	    public static ArrayList<MayaAchievement> itemSmeltingMap = Lists.newArrayList();

	    public static EnumSet<Key> unregisteredKeys = EnumSet.allOf(Key.class);

	    public static void add(MayaAchievement ach)
	    {
	        achievementList.put(ach.key, ach);
	        unregisteredKeys.remove(ach.key);
	    }

	    public static MayaAchievement[] getAllAsArray()
	    {
	        return achievementList.values().toArray(new MayaAchievement[0]);
	    }

	    public static MayaAchievement get(Key key)
	    {
	        return achievementList.get(key);
	    }

	    public static void achieveCraftingItem(ItemStack itemstack, EntityPlayer player)
	    {
	        for (MayaAchievement ach : itemCraftingMap)
	        {
	            if (ach.triggerMatches(itemstack))
	            {
	                player.triggerAchievement(ach);
	            }
	        }
	    }

	    public static void achieveItemPickup(ItemStack itemstack, EntityPlayer player)
	    {
	        for (MayaAchievement ach : itemPickupMap)
	        {
	            if (ach.triggerMatches(itemstack))
	            {
	                player.triggerAchievement(ach);
	            }
	        }
	    }

	    public static void achieveSmeltingItem(ItemStack itemstack, EntityPlayer player)
	    {
	        for (MayaAchievement ach : itemSmeltingMap)
	        {
	            if (ach.triggerMatches(itemstack))
	            {
	                player.triggerAchievement(ach);
	            }
	        }
	    }

	    public static void achieve(EntityPlayer player, Key key)
	    {
	        player.triggerAchievement(get(key));
	    }
	    }
