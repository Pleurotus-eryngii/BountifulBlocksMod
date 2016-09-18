package eryngii.bountifulblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SeaLanternBlock extends Block
{

 
    public SeaLanternBlock() {
        super(Material.glass);
        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
        setBlockName("blockSeaLantern");/*システム名の設定*/
        setBlockTextureName("bountifulmod:blocksealantern");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
        setLightLevel(1.0F);/*明るさ 1.0F = 15*/
    }
    
}