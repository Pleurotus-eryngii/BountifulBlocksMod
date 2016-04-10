package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class GraniteBlock extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;
 
    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;
 
    public GraniteBlock() {
        super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
        setBlockName("blockGranite");/*システム名の設定*/
        setBlockTextureName("samplemod:block_granite");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
    }

}
