package eryngii.bountifulblocks.mobs;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHusk extends RenderLiving {
	/*RenderLivingは生物系のRender。Renderではモデルが指定できない？*/
	//テクスチャの場所の設定。恐らくMOD本体のテクスチャ格納場所が指定できるように先に登録している
    public static final ResourceLocation texture = new ResourceLocation("bountifulmod:textures/mobs/husk.png");


    
    public RenderHusk() {
        // 引数:(ModelBase以降を継承したクラスのインスタンス、影の大きさ)
        super(new ModelZombie(), 0.4f);

}

    
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		//設定されたテクスチャを返すようにしている
		return texture;
	}
}