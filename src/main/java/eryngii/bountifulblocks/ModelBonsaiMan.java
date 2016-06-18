package eryngii.bountifulblocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBonsaiMan  extends ModelBase {
	//Bipedを継承するのが早いが、その場合身長の変更などがしにくい
    // モデルの直方体を代入する変数
	//fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Tree;
    ModelRenderer Tree2;
    ModelRenderer Tree3;
    ModelRenderer Tree4;
    ModelRenderer Tree5;
    ModelRenderer Tree6;
    ModelRenderer MyHead2;
    ModelRenderer Myhead;
 
    public ModelBonsaiMan() {
    	this(0.0F);
    }
    	
    	public ModelBonsaiMan(float size){
    		//super(size, 0.0F, 128, 64);
    		
    		 textureWidth = 128;
    		    textureHeight = 64;
    		    
    		      head = new ModelRenderer(this, 0, 29);
    		      head.addBox(-4F, -8F, -4F, 8, 8, 8);
    		      head.setRotationPoint(0F, -6F, 0F);
    		      head.setTextureSize(64, 32);
    		      head.mirror = true;
    		      setRotation(head, 0F, 0F, 0F);
    		      body = new ModelRenderer(this, 16, 45);
    		      body.addBox(-4F, 0F, -2F, 8, 15, 4);
    		      body.setRotationPoint(0F, -6F, 0F);
    		      body.setTextureSize(64, 32);
    		      body.mirror = true;
    		      setRotation(body, 0F, 0F, 0F);
    		      rightarm = new ModelRenderer(this, 40, 26);
    		      rightarm.addBox(-3F, -2F, -2F, 4, 15, 4);
    		      rightarm.setRotationPoint(-5F, -4F, 0F);
    		      rightarm.setTextureSize(64, 32);
    		      rightarm.mirror = true;
    		      setRotation(rightarm, 0F, 0F, 0F);
    		      leftarm = new ModelRenderer(this, 40, 45);
    		      leftarm.addBox(-1F, -2F, -2F, 4, 15, 4);
    		      leftarm.setRotationPoint(5F, -4F, 0F);
    		      leftarm.setTextureSize(64, 32);
    		      leftarm.mirror = true;
    		      setRotation(leftarm, 0F, 0F, 0F);
    		      rightleg = new ModelRenderer(this, 0, 45);
    		      rightleg.addBox(-2F, 0F, -2F, 4, 15, 4);
    		      rightleg.setRotationPoint(-2F, 9F, 0F);
    		      rightleg.setTextureSize(64, 32);
    		      rightleg.mirror = true;
    		      setRotation(rightleg, 0F, 0F, 0F);
    		      leftleg = new ModelRenderer(this, 0, 45);
    		      leftleg.addBox(-2F, 0F, -2F, 4, 15, 4);
    		      leftleg.setRotationPoint(2F, 9F, 0F);
    		      leftleg.setTextureSize(64, 32);
    		      leftleg.mirror = true;
    		      setRotation(leftleg, 0F, 0F, 0F);
    		      Tree = new ModelRenderer(this, 33, 11);
    		      Tree.addBox(0F, 0F, 0F, 2, 4, 2);
    		      Tree.setRotationPoint(-3F, -18F, -1F);
    		      Tree.setTextureSize(64, 32);
    		      Tree.mirror = true;
    		      setRotation(Tree, 0F, 0F, 0F);
    		      Tree2 = new ModelRenderer(this, 41, 11);
    		      Tree2.addBox(0F, 0F, 0F, 1, 1, 2);
    		      Tree2.setRotationPoint(-1F, -18F, -1F);
    		      Tree2.setTextureSize(64, 32);
    		      Tree2.mirror = true;
    		      setRotation(Tree2, 0F, 0F, 0F);
    		      Tree3 = new ModelRenderer(this, 33, 7);
    		      Tree3.addBox(0F, 0F, 0F, 2, 2, 2);
    		      Tree3.setRotationPoint(-2F, -20F, -1F);
    		      Tree3.setTextureSize(64, 32);
    		      Tree3.mirror = true;
    		      setRotation(Tree3, 0F, 0F, 0F);
    		      Tree4 = new ModelRenderer(this, 41, 2);
    		      Tree4.addBox(0F, 0F, 0F, 5, 3, 6);
    		      Tree4.setRotationPoint(0F, -22F, -3F);
    		      Tree4.setTextureSize(64, 32);
    		      Tree4.mirror = true;
    		      setRotation(Tree4, 0F, 0F, 0F);
    		      Tree5 = new ModelRenderer(this, 0, 20);
    		      Tree5.addBox(0F, 0F, 0F, 4, 3, 6);
    		      Tree5.setRotationPoint(-6F, -22F, -3F);
    		      Tree5.setTextureSize(64, 32);
    		      Tree5.mirror = true;
    		      setRotation(Tree5, 0F, 0F, 0F);
    		      Tree6 = new ModelRenderer(this, 20, 21);
    		      Tree6.addBox(0F, 0F, 0F, 5, 4, 4);
    		      Tree6.setRotationPoint(-3F, -25F, -2F);
    		      Tree6.setTextureSize(64, 32);
    		      Tree6.mirror = true;
    		      setRotation(Tree6, 0F, 0F, 0F);
    		      MyHead2 = new ModelRenderer(this, 0, 0);
    		      MyHead2.addBox(-5F, 13F, -5F, 6, 6, 7);
    		      MyHead2.setRotationPoint(-5F, -4F, 0F);
    		      MyHead2.setTextureSize(64, 32);
    		      MyHead2.mirror = true;
    		      setRotation(MyHead2, 0F, 0F, 0F);
    		      Myhead = new ModelRenderer(this, 38, 19);
    		      Myhead.addBox(-4F, 14F, -6F, 4, 4, 1);
    		      Myhead.setRotationPoint(-5F, -4F, 0F);
    		      Myhead.setTextureSize(64, 32);
    		      Myhead.mirror = true;
    		      setRotation(Myhead, 0F, 0F, 0F);
      }
      
      public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
      {
        //ここから下のあらゆる処理は各種動作。ModelBipedという、人型のEntityによく使われる動作をそのまま持ってきている。
    	//植木鉢が連動して動くよう、関節位置を合わせて腕の動きと同じものを登録
    	//頭の植木は動かなくても問題なさそうなので現在設定せず。今後調整する
    	  super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        Tree.render(f5);
        Tree2.render(f5);
        Tree3.render(f5);
        Tree4.render(f5);
        Tree5.render(f5);
        Tree6.render(f5);
        MyHead2.render(f5);
        Myhead.render(f5);
        
      
      }
      private void setRotation(ModelRenderer model, float x, float y, float z)
      {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
      }
      
      public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
      {
        //super.setRotationAngles(f, f1, f2, f3, f4, f5, f6);
    	  this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
          this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
          this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
          this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
          this.rightarm.rotateAngleZ = 0.0F;
          this.leftarm.rotateAngleZ = 0.0F;
          this.MyHead2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
          this.MyHead2.rotateAngleZ = 0.0F;
          this.Myhead.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
          this.Myhead.rotateAngleZ = 0.0F;
          this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
          this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
          this.rightleg.rotateAngleY = 0.0F;
          this.leftleg.rotateAngleY = 0.0F;
          
          float f7;
          float f8;
          
          if (this.onGround > -9990.0F)
          {
              f7 = this.onGround;
              this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f7) * (float)Math.PI * 2.0F) * 0.2F;
              this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
              this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
              this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
              this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
              this.rightarm.rotateAngleY += this.body.rotateAngleY;
              this.leftarm.rotateAngleY += this.body.rotateAngleY;
              this.leftarm.rotateAngleX += this.body.rotateAngleY;
              this.MyHead2.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
              this.MyHead2.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
              this.MyHead2.rotateAngleY += this.body.rotateAngleY;
              this.Myhead.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
              this.Myhead.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
              this.Myhead.rotateAngleY += this.body.rotateAngleY;
              f7 = 1.0F - this.onGround;
              f7 *= f7;
              f7 *= f7;
              f7 = 1.0F - f7;
              f7 = MathHelper.sin(f7 * (float)Math.PI);
              float f9 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
              this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f9));
              this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
              this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
              this.MyHead2.rotateAngleX = (float)((double)this.MyHead2.rotateAngleX - ((double)f7 * 1.2D + (double)f9));
              this.MyHead2.rotateAngleY += this.body.rotateAngleY * 2.0F;
              this.MyHead2.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
              this.Myhead.rotateAngleX = (float)((double)this.Myhead.rotateAngleX - ((double)f7 * 1.2D + (double)f9));
              this.Myhead.rotateAngleY += this.body.rotateAngleY * 2.0F;
              this.Myhead.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
          }
      }

    }