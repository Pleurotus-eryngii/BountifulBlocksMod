package eryngii.bountifulblocks.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemRawRabbit  extends ItemFood
{
 
	public ItemRawRabbit(int par1, float par2, boolean par3)
	{
		super(par1, par2, par3);
		this.setUnlocalizedName("RawRabbit");	//システム名の登録
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setTextureName("bountifulmod:rawrabbit");	//テクスチャの指定
		this.setMaxStackSize(64);	//スタックできる量
	}
 
 
}
