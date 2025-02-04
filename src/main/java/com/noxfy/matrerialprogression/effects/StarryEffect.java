package com.noxfy.matrerialprogression.effects;

import com.noxfy.matrerialprogression.Matrerialprogression;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class StarryEffect extends StatusEffect {
    public StarryEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x000000);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            // Each level grants 2 extra HP (1 heart)
            if (player.getAttributeInstance(EntityAttributes.MAX_HEALTH).hasModifier(Identifier.of(Matrerialprogression.MOD_ID, "starry_effect"))) {
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).removeModifier(new EntityAttributeModifier(Identifier.of(Matrerialprogression.MOD_ID, "starry_effect"), amplifier * 2 + 2, EntityAttributeModifier.Operation.ADD_VALUE));
            }
            player.getAttributeInstance(EntityAttributes.MAX_HEALTH).addPersistentModifier(new EntityAttributeModifier(Identifier.of(Matrerialprogression.MOD_ID, "starry_effect"), amplifier * 2 + 2, EntityAttributeModifier.Operation.ADD_VALUE));
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public void onEntityRemoval(ServerWorld world, LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
        if (entity instanceof PlayerEntity player) {
            // Remove the extra health modifier when the effect ends
            player.getAttributeInstance(EntityAttributes.MAX_HEALTH).removeModifier(new EntityAttributeModifier(Identifier.of(Matrerialprogression.MOD_ID, "starry_effect"), amplifier * 2 + 2, EntityAttributeModifier.Operation.ADD_VALUE));
        }
        super.onEntityRemoval(world, entity, amplifier, reason);
    }


}
