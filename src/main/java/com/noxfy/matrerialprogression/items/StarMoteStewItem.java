package com.noxfy.matrerialprogression.items;

import com.noxfy.matrerialprogression.Matrerialprogression;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class StarMoteStewItem extends Item {
    public StarMoteStewItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        int amplifier = -1;

        StatusEffectInstance effect = user.getStatusEffect(Matrerialprogression.STARRY_EFFECT);

        if (effect != null) {
            amplifier = effect.getAmplifier() + 1; // +1 because levels are zero-based
        }
        // give food
        if (amplifier > 9) {
            return user.getStackInHand(Hand.MAIN_HAND);
        }

        user.removeStatusEffect(Matrerialprogression.STARRY_EFFECT);
        user.addStatusEffect(new StatusEffectInstance(Matrerialprogression.STARRY_EFFECT, StatusEffectInstance.INFINITE, amplifier, false, false));
        return super.finishUsing(stack, world, user);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
