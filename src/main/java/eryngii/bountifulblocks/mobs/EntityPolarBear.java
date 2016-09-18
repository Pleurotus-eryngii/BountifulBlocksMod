package eryngii.bountifulblocks.mobs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPolarBear extends EntityAnimal{
    private float field_189799_by;
    private float field_189800_bz;
    private int field_189797_bB;

    public EntityPolarBear(World p_i47154_1_)
    {
        super(p_i47154_1_);
        this.setSize(1.3F, 1.4F);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
	    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 1, true));
	    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.targetTasks.addTask(1, new EntityPolarBear.AIHurtByTarget());
    }

    public EntityAgeable createChild(EntityAgeable ageable)
    {
        return new EntityPolarBear(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return false;
    }


    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    }

    protected String getLivingSound()
    {
        return "bountifulmod:mob.polarbear.idle";
    }

    protected String getHurtSound()
    {
        return "bountifulmod:mob.polarbear.hurt";
    }

    protected String getDeathSound()
    {
        return "bountifulmod:mob.polarbear.death";
    }


    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }



    @SideOnly(Side.CLIENT)
    public float func_189795_r(float p_189795_1_)
    {
        return (this.field_189799_by + (this.field_189800_bz - this.field_189799_by) * p_189795_1_) / 6.0F;
    }

    protected float func_189749_co()
    {
        return 0.98F;
    }


    class AIAttackPlayer extends EntityAINearestAttackableTarget
    {
        public AIAttackPlayer()
        {
            super(EntityPolarBear.this, EntityPlayer.class, 20, true, true, null);
        }




        protected double getTargetDistance()
        {
            return super.getTargetDistance() * 0.5D;
        }
    }

    class AIHurtByTarget extends EntityAIHurtByTarget
    {
        public AIHurtByTarget()
        {
            super(EntityPolarBear.this, false);
        }



    }

    
        /**
         * Resets the task
         */


        protected double getAttackReachSqr(EntityLivingBase attackTarget)
        {
            return (double)(4.0F + attackTarget.width);
        }
    
        @Override
        protected void func_145780_a(int x, int y, int z, Block block)
        {
        	this.playSound("bountifulmod:mob.polarbear.step", 0.15F, 1.0F);
        }

	     @Override
	     //ドロップアイテム。さかな。
	     public Item getDropItem() { return Items.fish; }
	     


	
		
} 


