package eryngii.bountifulblocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class OPoppyBlock extends BlockBush implements IGrowable {
    @SideOnly(Side.CLIENT)
    private IIcon[] icon;
	private IIcon[] iIcon = new IIcon[8];
	

    public OPoppyBlock() {
        super();
        setBlockTextureName("bountifulmod:opoppy_stage_0");
        setBlockName("blockOpiumPoppy");
        setCreativeTab(BountifulBlocksCore.tabsMaya);
        // たまに成長するようにする。
        setTickRandomly(true);
        setStepSound(soundTypeGrass);
        disableStats();
    }
 
    @Override
    protected boolean canPlaceBlockOn(Block parBlock)
    {
        return parBlock == Blocks.farmland;
    }
 
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        super.updateTick(world, x, y, z, random);
 
        int growStage = world.getBlockMetadata(x, y, z); // メタデータ=成長段階
        growStage++;
        if (growStage > 6) { // 0が1段階目なのでこうなる
            growStage = 6; // バグ防止
        }
        //1.7で仕様が変更したのか引数が一致しないので、BlockCropsを参考に末尾の2を追加
        world.setBlockMetadataWithNotify(x, y, z, growStage, 2);
    }
 
    
 
    @Override
    // 完全成長しているか確認するメソッド (7段階目が完全成長)
    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
        return parWorld.getBlockMetadata(parX, parY, parZ) != 7;
    }
    public boolean bonemealenable(World world, int x, int y, int z, boolean isRemote) {
		return true;
	}
    /*
    @Override
    // 骨粉処理
    public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ) {
        incrementGrowStage(parWorld, parRand, parX, parY, parZ);
    }

*/

	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		return world.rand.nextFloat() < 1.00D;//0.45D;
	}
 
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) {
		 this.updateTick(world, x, y, z, random);
	}

 

	@Override
    public int getRenderType() { return 1; // 描画タイプ:1はクロステクスチャ }
	}
    @SideOnly(Side.CLIENT)
	public IIcon getIcon(int side,int meta) {
		return iIcon[meta];
	}
 
    @Override
    // ドロップする個数
    public int quantityDropped(int metadata, int fortune, Random random) {
        return metadata == 6 ? random.nextInt()*0 + 3  : 1; // 完全成長なら3、それ以外なら1つ
        //面倒だったのでランダム実装に0をかけるという最悪の実装
    }
 
    @Override
    // ドロップするアイテム
    public Item getItemDropped(int metadata, Random random, int fortune) {
        
    		return  BountifulBlocksCore.itemOpiumPoppyPlant;
    	
    }
 
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {

          // 全成長段階のテクスチャを登録
          iIcon[0] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_0");
          iIcon[1] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_1");
          iIcon[2] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_2");
          iIcon[3] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_3");
          iIcon[4] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_4");
          iIcon[5] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_5");
          iIcon[6] = parIIconRegister.registerIcon("bountifulmod:opoppy_stage_6");
    }


}



