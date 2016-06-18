package eryngii.bountifulblocks;

import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.util.ResourceLocation;

public class ClientProxy  extends CommonProxy {
    public void init() {
	/*
	 * 村人のテクスチャを指定しています
	 */
        VillagerRegistry.instance().registerVillagerSkin(BountifulBlocksCore.mayaVillagerProfession, new ResourceLocation("bountifulmod", "textures/mobs/vill4.png"));
    }
}
