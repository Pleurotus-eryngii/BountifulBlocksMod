package eryngii.bountifulblocks;


import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemDioriteBlock extends ItemBlockWithMetadata {
	public ItemDioriteBlock(Block block) {
		super(block, block);
	}
 
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName() + "." + itemStack.getItemDamage();
	}
}
