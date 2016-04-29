package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;


public class BarrierBlock extends Block
	 {
	//インベントリ内、設置時それぞれのテクスチャ
    @SideOnly(Side.CLIENT)
    IIcon inInventory;
	
    @SideOnly(Side.CLIENT)
    IIcon inWorld;
    
    private boolean field_149996_a;
    private String field_149995_b;
    private static final String __OBFID = "CL_00000254";
	     public BarrierBlock() {
	         super(Material.glass);
	         setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
	         setBlockName("blockBarrier");/*システム名の設定*/
	         setBlockTextureName("bountifulmod:barrier");
	         /*以下のものは消しても結構です*/
	         setStepSound(Block.soundTypeStone);/*ブロックの上を歩いた時の音*/
	         setLightOpacity(1);/*ブロックの透過係数。デフォルト０（不透過）*/
	         setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);/*当たり判定*/;
	     }
	    
	     //テクスチャの読み込み。このままだと設置時にもインベントリのテクスチャが適用される
	     //可能性があるので、あとで設置時の処理を行っている
	 	@Override
		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister iconRegister)
		{
			this.inInventory = iconRegister.registerIcon("bountifulmod:barrierinv");
			this.inWorld = iconRegister.registerIcon("bountifulmod:barrier");

		}
	 	//設置時の処理。全ての面に透明テクスチャを適用(reginn66氏のWikiより
	 	@Override
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side)
		{

			if (side == ForgeDirection.UP.ordinal() || side == ForgeDirection.DOWN.ordinal())
			{
				return this.inWorld;
			}
			int meta = iBlockAccess.getBlockMetadata(x, y, z);

			return side == meta ? this.inWorld : this.inWorld;
		}

//インベントリ内。
	     @SideOnly(Side.CLIENT)
	     public IIcon getIcon(int side, int meta)
	     {
	         
	 			return this.inInventory;
	 		
	     }
	     
	     /*以下はBlockGlassとBlockGlassが継承しているBlockBreakeableからのコピー。
	     *見た目に関係があるのはshouldSideBeRendered(左右のブロックの側面が見えるようにする)だけ
	     *だが、不具合を防ぐために全て引用した
	     */
	     public int getRenderBlockPass()
	     {
	         return 0;
	     }
	     public boolean renderAsNormalBlock()
	     {
	         return false;
	     }

	     protected boolean canSilkHarvest()
	     {
	         return true;
	     }
	     public boolean isOpaqueCube()
	     {
	         return false;
	     }
	     public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
	     {
	         Block var6 = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);

	         if (this == Blocks.glass )
	         {
	             if (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.getBlockMetadata(p_149646_2_ - Facing.offsetsXForSide[p_149646_5_], p_149646_3_ - Facing.offsetsYForSide[p_149646_5_], p_149646_4_ - Facing.offsetsZForSide[p_149646_5_]))
	             {
	                 return true;
	             }

	             if (var6 == this)
	             {
	                 return false;
	             }
	         }

	         return !this.field_149996_a && var6 == this ? false : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
	     }

	     }

