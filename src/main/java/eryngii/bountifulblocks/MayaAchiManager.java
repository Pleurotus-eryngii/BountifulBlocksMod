package eryngii.bountifulblocks;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MayaAchiManager {
	    public static enum Key
	    {
	        CallingFrom(0), DangerousChallenge(1), MoreEffect(3), Poppy(4), NotFlower(5), Deeply(6);

	        Key(int localId)
	        {
	        }
	    }

	    public static Map<Key, MayaAchi> achievementList = Maps.newEnumMap(Key.class);
	    public static ArrayList<MayaAchi> itemPickupMap = Lists.newArrayList();
	    public static ArrayList<MayaAchi> itemCraftingMap = Lists.newArrayList();
	    public static ArrayList<MayaAchi> itemSmeltingMap = Lists.newArrayList();

	    public static EnumSet<Key> unregisteredKeys = EnumSet.allOf(Key.class);

	    public static void add(MayaAchi ach)
	    {
	        achievementList.put(ach.key, ach);
	        unregisteredKeys.remove(ach.key);
	    }

	    public static MayaAchi[] getAllAsArray()
	    {
	        return achievementList.values().toArray(new MayaAchi[0]);
	    }

	    public static MayaAchi get(Key key)
	    {
	        return achievementList.get(key);
	    }

	    public static void achieveCraftingItem(ItemStack itemstack, EntityPlayer player)
	    {
	        for (MayaAchi ach : itemCraftingMap)
	        {
	            if (ach.triggerMatches(itemstack))
	            {
	                player.triggerAchievement(ach);
	            }
	        }
	    }

	    public static void achieveItemPickup(ItemStack itemstack, EntityPlayer player)
	    {
	        for (MayaAchi ach : itemPickupMap)
	        {
	            if (ach.triggerMatches(itemstack))
	            {
	                player.triggerAchievement(ach);
	            }
	        }
	    }

	    public static void achieveSmeltingItem(ItemStack itemstack, EntityPlayer player)
	    {
	        for (MayaAchi ach : itemSmeltingMap)
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
