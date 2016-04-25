package eryngii.bountifulblocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class DoorBlockX extends BlockDoor{
	
	private IIcon[] iicon = new IIcon[14];
/*
    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;

    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < 14; i ++) {
			this.iicon[i] = register.registerIcon(this.getTextureName() + "_" + i);
		}
	}
    */
    public DoorBlockX() {
        super(Material.wood);
        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
        setBlockName("blockDoor");/*システム名の設定*/
        setBlockTextureName("bountifulmod:blockdoor");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
    }
 /*   
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		for (int i = 0; i < 14; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
*/
}
