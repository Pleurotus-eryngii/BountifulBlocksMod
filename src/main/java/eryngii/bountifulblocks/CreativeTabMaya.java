package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMaya extends CreativeTabs
	{
		public CreativeTabMaya(String label)
		{
			super(label);
		}
	 
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return BountifulBlocksCore.itemCannabisPlant;
		}
	 
		@Override
		@SideOnly(Side.CLIENT)
		public String getTranslatedTabLabel()
		{
			return "MayaCraft";
		}
	 
	}

