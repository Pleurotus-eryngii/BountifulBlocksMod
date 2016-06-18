package eryngii.bountifulblocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntityBonsaiMan extends EntityMob{
	//Entityの設定。具体的にはMOBの挙動を指定するものである。
	
	 public EntityBonsaiMan(World world)
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
    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.8D, false));
    //this.tasks.addTask(1, new EntityAISwimming(this));
    this.tasks.addTask(5, new EntityAIWander(this, 0.5D));
    this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    this.tasks.addTask(6, new EntityAILookIdle(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 1, true));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 1, true));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPig.class, 1, true));
	    }
	 
		@Override
		protected void applyEntityAttributes()
		{
			//各種設定。移動速度、ついていく（索敵？）距離、ノックバック、体力
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
			this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(128D);
			this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(100D);
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
		}
	    @Override
	    public boolean isAIEnabled() { return true; }
	 
	    @Override
	    protected void func_145780_a(int x, int y, int z, Block block)
	    {
	    	//歩く音
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	    }
	 
	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "";
	    }
	    
	    
	    
	    @Override
	     public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }
	  
	     @Override
	     //ドロップアイテム。希望によっては2体同じEntityを登録して2種の植物をドロップさせるのが一番単純
	     public Item getDropItem() { return BountifulBlocksCore.itemCannabisPlant; }
	     


}
