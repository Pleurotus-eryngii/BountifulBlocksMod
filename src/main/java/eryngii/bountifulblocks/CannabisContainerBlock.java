package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class CannabisContainerBlock   extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;
 
    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;
 
    public CannabisContainerBlock() {
        super(Material.wood);
        setCreativeTab(BountifulBlocksCore.tabsMaya);/*クリエイティブタブの選択*/
        setBlockName("blockCannabisContainer");/*システム名の設定*/
        setBlockTextureName("bountifulmod:cannabiscontainer");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
   
    }
}
