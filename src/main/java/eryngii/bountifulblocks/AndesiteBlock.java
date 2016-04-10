package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class AndesiteBlock extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;
 
    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;
 
    public AndesiteBlock() {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
        setBlockName("blockAndesite");/*システム名の設定*/
        setBlockTextureName("samplemod:block_andesite");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
    }

}