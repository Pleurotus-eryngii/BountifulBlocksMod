package eryngii.bountifulblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MagmaBlock extends Block{

    public MagmaBlock() {
        super(Material.glass);
        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
        setBlockName("blockMagma");/*システム名の設定*/
        setBlockTextureName("bountifulmod:blockmagma");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
        setLightLevel(0.2F);/*明るさ 0.2F = 3*/
        this.setTickRandomly(true);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     * この部分がないとよくわからないがうまく動作しないので、しかたなく8分の1ブロックだけ低くしている
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - f), (double)(p_149668_4_ + 1));
    }
    

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     * ソウルサンドの処理を流用。1.10では独自のダメージを使用しているが、登録が面倒なためダメージ数が同じ
     * サボテンを使用している
     */
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
        p_149670_5_.attackEntityFrom(DamageSource.cactus, 1.0F);
    }
}
