package eryngii.bountifulblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class CoarseDirtBlock extends Block
{
	private IIcon[] iicon = new IIcon[2];

    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;

    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;

    public CoarseDirtBlock() {
        super(Material.cloth);
        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
        setBlockName("blockCoarseDirt");/*システム名の設定*/
        setBlockTextureName("bountifulmod:blockcoarsedirt");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
    }
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < 2; i ++) {
			this.iicon[i] = register.registerIcon(this.getTextureName() + "_" + i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return iicon[meta];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		for (int i = 0; i < 2; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

}