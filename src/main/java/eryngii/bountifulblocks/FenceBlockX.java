package eryngii.bountifulblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class FenceBlockX extends BlockFence
{
    private static final String __OBFID = "CL_00000242";
	private IIcon[] iicon = new IIcon[12];

    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;

    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;

    //どこかで見た手法。Java自体のエラーは無くなった
    public FenceBlockX(String str, Material p_i45406_2_)
    {
        super(str , p_i45406_2_);
        setCreativeTab(CreativeTabs.tabDecorations);/*クリエイティブタブの選択*/
        setBlockName("blockFenceX");/*システム名の設定*/
        setBlockTextureName("bountifulmod:blockfence");
    }
    
 
	
 
    @Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < 12; i ++) {
			this.iicon[i] = register.registerIcon(this.getTextureName()+ "_" + i);
		}
	}
    @SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return iicon[meta];
    }
    public int getMetadata(int meta) {
 		return meta;
 		}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		
		return iicon[meta];
		

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list) {
		for (int i = 0; i < 12; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	@Override
	public int damageDropped(int meta) {
		return meta;
	}


}

