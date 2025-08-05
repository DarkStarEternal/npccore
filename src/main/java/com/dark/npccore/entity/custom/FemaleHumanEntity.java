package com.dark.npccore.entity.custom;

import com.dark.npccore.entity.client.FemaleHumanRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.RenderNameTagEvent;
import org.jetbrains.annotations.Nullable;

public class FemaleHumanEntity extends Monster {
    private Integer dialogueKey = -1; // Default value
    private Integer dialogueRandomizer = -1; //Randomize the chosen answer from the pool with this value

    public FemaleHumanEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 0.1));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_SPEED, 0.4)
                .add(Attributes.MOVEMENT_SPEED, 2.5)
                .add(Attributes.FOLLOW_RANGE, 2)
                .add(Attributes.ATTACK_DAMAGE, 1);
    }

    @Override
    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }


    public void setDialogueKey(int key) {
        this.dialogueKey = key;
    }

    public void setDialogueRandomizer(int randomizer) {
        this.dialogueRandomizer = randomizer;
    }

    public int getDialogueKey() {
        return this.dialogueKey;
    }
    public int getDialogueRandomizer() {
        return this.dialogueRandomizer;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("DialogueKey", Integer.toString(this.dialogueKey));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("DialogueKey")) {
            this.dialogueKey = Integer.valueOf(tag.getString("DialogueKey"));
        }
    }
}
