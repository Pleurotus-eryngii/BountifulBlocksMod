package eryngii.bountifulblocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class PurpurPillarBlock extends Block
{

	   public PurpurPillarBlock() {
	        super(Material.rock);
	        setCreativeTab(CreativeTabs.tabBlock);/*クリエイティブタブの選択*/
	        setBlockName("blockPurpurPillar");/*システム名の設定*/
	     
	    }
	
	   @SideOnly(Side.CLIENT)
	IIcon sideIcon;

	@SideOnly(Side.CLIENT)
	IIcon topIcon;
	
	  @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int par1, int par2)
	    {
	         if(par1 == 0 || par1 == 1)
	         {
	                  return topIcon;
	         }
	         else
	         {
	                  return sideIcon;
	         }
	    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
		this.topIcon = register.registerIcon("bountifulmod:ppblocktop");
		
        this.sideIcon = register.registerIcon("bountifulmod:ppblockside");
    }
         }