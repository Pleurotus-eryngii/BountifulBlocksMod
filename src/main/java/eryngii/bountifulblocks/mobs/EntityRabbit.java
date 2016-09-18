package eryngii.bountifulblocks.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eryngii.bountifulblocks.BountifulBlocksCore;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityRabbit extends EntityMob{
	//Entityの設定。具体的にはMOBの挙動を指定するものである。
	
	private int jumpDuration;
	private int jumpTicks;
    private boolean wasOnGround;
    private int currentMoveTypeDuration;
    private int carrotTicks;
	private EntityMoveHelper moveHelper;
	private EntityJumpHelper jumpHelper;

	
		 public EntityRabbit(World world)
		    {
			 super(world);
			 /*AIの設定。上から
			  * アタックするEntityの設定、第3引数はそこに向かっていく速さ
			  * 泳ぐAIの設定、身長を変えた影響で地面に埋まるバグが起きたためコメントアウト
			  * うろうろするAI、第2引数は恐らく速さだと思われる
			  * 近くを見るAI?バニラのゾンビから流用
			  * 見つめるAI
			  * 不明。ゾンビから流用。バグを防ぐため使われていそうなAIはすべて登録してある
			  * 攻撃目標のEntityの設定。これとAttackOnCollideをセットで設定しないと効果がない？
			  */
	    this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		    }
		 
			@Override
			protected void applyEntityAttributes()
			{
				//各種設定。移動速度、ついていく（索敵？）距離、ノックバック、体力
				super.applyEntityAttributes();
				this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
				this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(128D);
				this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5D);
			}
		    @Override
		    public boolean isAIEnabled() { return true; }
		 

		 
		    /**
		     * Returns the sound this mob makes when it is hurt.
		     */
		    @Override
		    protected String getHurtSound()
		    {
		        return "bountifulmod:mob.rabbit.hurt";
		    }


		    @Override
		    protected String getLivingSound()
		    {
		        return "bountifulmod:mob.rabbit.idle";
		    }
		    

		    

			@SideOnly(Side.CLIENT)
		    public float setJumpCompletion(float p_175521_1_)
		    {
		        return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + p_175521_1_) / (float)this.jumpDuration;
		    }

		
		    
		    @Override
		     public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }
		  
		     @Override
		     //ドロップアイテム。かわ。
		     public Item getDropItem() { return BountifulBlocksCore.rabbitHide; }

		     @Override
		     protected void dropRareDrop(int p_70600_1_)
		     {
		         switch (this.rand.nextInt(1))
		         {
		             case 0:
		                 this.dropItem(BountifulBlocksCore.rawRabbit, 1);
		                 break;
		         }
		     }

		     


		 

	 
}
