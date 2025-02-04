package com.noxfy.matrerialprogression;

import com.noxfy.matrerialprogression.effects.StarryEffect;
import com.noxfy.matrerialprogression.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class Matrerialprogression implements ModInitializer {

    public static String MOD_ID = "matrerialprogression";

    public static final RegistryEntry<StatusEffect> STARRY_EFFECT;

    static {
        STARRY_EFFECT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "starry_effect"), new StarryEffect());
    }

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}
