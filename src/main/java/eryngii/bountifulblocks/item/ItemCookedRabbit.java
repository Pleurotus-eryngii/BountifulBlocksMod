package eryngii.bountifulblocks.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemCookedRabbit  extends ItemFood
{
 
	public ItemCookedRabbit(int par1, float par2, boolean par3)
	{
		super(par1, par2, par3);
		this.setUnlocalizedName("CookedRabbit");	//システム名の登録
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setTextureName("bountifulmod:cookedrabbit");	//テクスチャの指定
		this.setMaxStackSize(64);	//スタックできる量
	}
 
 
}