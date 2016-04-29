package eryngii.bountifulblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class FenceBlockX extends BlockFence
{
	//登録や描画などの際に使用する数値
	private IIcon[] iicon = new IIcon[5];



    //StringはStrでも何でもいい
    public FenceBlockX(String str, Material p_i45406_2_)
    {
        super(str , p_i45406_2_);
        setCreativeTab(CreativeTabs.tabDecorations);/*クリエイティブタブの選択*/
        setBlockName("blockFenceX");/*システム名の設定*/
        setBlockTextureName("bountifulmod:blockfence");/*CoreのStr部分での指定は使えないので、ここで設定し直し*/
    }
    
 
	
 //テクスチャの設定。blockfence_メタデータの値
    @Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < 5; i ++) {
			this.iicon[i] = register.registerIcon(this.getTextureName()+ "_" + i);
		}
	}
//インベントリ内でのテクスチャだが、metaで上手くmetadataを受け取れないので全て同じになっている
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		
		return iicon[meta];
		

	}
//タブへの追加処理
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		for (int i = 0; i < 5; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	//ドロップアイテムのダメージを指定するメソッド。
	@Override
	public int damageDropped(int meta) {
		return meta;
	}


}

