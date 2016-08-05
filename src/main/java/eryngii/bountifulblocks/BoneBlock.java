package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BoneBlock  extends BlockLog
{
	//メタデータで各方向のテクスチャを管理。ほとんどの処理はバニラの原木とかを参照
	@SideOnly(Side.CLIENT)
    public static IIcon[] sidetop = new IIcon[2];

    public BoneBlock()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeWood);
        setBlockName("blockBone");/*システム名の設定*/
    }


    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(int par1, int par2)
    {
      int direction = par2 & 0xC;
      int meta = par2 & 0x3;
      if (direction == 4)
      {
        if ((par1 == 5) || (par1 == 4)) {
          return sidetop[1];
        }
        return sidetop[0];
      }
      if (direction == 8)
      {
        if ((par1 == 2) || (par1 == 3)) {
          return sidetop[1];
        }
        return sidetop[0];
      }
      if ((par1 == 1) || (par1 == 0)) {
        return sidetop[1];
      }
      return sidetop[0];
    }
    
    public int func_149701_w()
    {
      return 0;
    }
    
    public int func_149660_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
      int meta = par9 & 0x3;
      int direction = 0;
      switch (par5)
      {
      case 0: 
      case 1: 
      default: 
        direction = 0;
        break;
      case 2: 
      case 3: 
        direction = 8;
        break;
      case 4: 
      case 5: 
        direction = 4;
      }
      par1World.setBlockMetadataWithNotify(par2, par3, par4, meta | direction, 3);
      return meta | direction;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(IIconRegister par1IconRegister)
    {
      sidetop[0] = par1IconRegister.registerIcon("bountifulmod:bone_block_side");
      sidetop[1] = par1IconRegister.registerIcon("bountifulmod:bone_block_top");
    }

    }