package eryngii.bountifulblocks.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemRabbitFoot  extends ItemFood
{
 
	public ItemRabbitFoot(int par1, float par2, boolean par3)
	{
		super(par1, par2, par3);
		this.setUnlocalizedName("RabbitFoot");	//システム名の登録
		this.setTextureName("bountifulmod:rabbitfoot");	//テクスチャの指定
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(64);	//スタックできる量
		this.setPotionEffect(Potion.jump.id, 60, 0, 1.0F);
	}
 
 
}
