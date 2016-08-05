package eryngii.bountifulblocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class FreshOpiumPoppyBlock   extends Block implements IGrowable {
	
	@SideOnly(Side.CLIENT)
	/*乾燥前のブロックと乾燥後のブロックを両方とも処理する。
	 * 時間で処理することもできるのだが、ドロップアイテムを変更するのが面倒なため植物を応用。
	 * Blockを継承しつつIGrowableも読み込むことで両方の特性を生かしている。
	 * あくまでテスト用のため、乾燥後の作業に関しての登録はまだ。
	 */
	private IIcon[] iIcon = new IIcon[2];
 
    public FreshOpiumPoppyBlock() {
    	super(Material.cactus);
        setCreativeTab(BountifulBlocksCore.tabsMaya);/*クリエイティブタブの選択*/
        setBlockName("blockFreshOpiumPoppy");/*システム名の設定*/
        setBlockTextureName("samplemod:freshcannabis");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
        setTickRandomly(true);


    }
    
 
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);
 
        int growStage = world.getBlockMetadata(x, y, z); // メタデータ=成長段階
        growStage++;
        if (growStage > 1) { // 0が1段階目なのでこうなる
            growStage = 1; // バグ防止
        }
        //1.7で仕様が変更したのか引数が一致しないので、BlockCropsを参考に末尾の2を追加
        world.setBlockMetadataWithNotify(x, y, z, growStage, 2);
    }
 
    
 
    @Override
    // 完全成長しているか確認するメソッド (2段階目が完全成長)
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
        return parWorld.getBlockMetadata(parX, parY, parZ) != 1;
    }
    public boolean bonemealenable(World world, int x, int y, int z, boolean isRemote) {
		return false;
	}




	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return false;
	}
 
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) {
		 //this.updateTick(world, x, y, z, random);
	}

 

	@Override
    public int getRenderType() { return 0; // 描画タイプ:0は通常 }
	}
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side,int meta) {
		return iIcon[meta];
	}
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return true;//普通に描画する。一応
    }
 
    @Override
    // ドロップする個数
    public int quantityDropped(int metadata, int fortune, Random random) {
        return metadata == 1 ? random.nextInt()*0 + 1  : 1; // 完全成長なら1、それ以外なら1つ
        //面倒だったのでランダム実装に0をかけるという最悪の実装
    }
 
    @Override
    // ドロップするアイテム。未確認だが、とりあえずこんな感じで処理できるはず。
    public Item getItemDropped(int metadata, Random random, int fortune) {
    	if(metadata==1){return BountifulBlocksCore.itemDryOpiumPoppy;}
    	else{
    		return  BountifulBlocksCore.itemOpiumPoppy;}
    	
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {

          // 全成長段階のテクスチャを登録
          iIcon[0] = parIIconRegister.registerIcon("bountifulmod:freshopoppy");
          iIcon[1] = parIIconRegister.registerIcon("bountifulmod:dryopoppy");

    }
  

    }
