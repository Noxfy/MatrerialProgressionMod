package com.noxfy.matrerialprogression.items;

import com.noxfy.matrerialprogression.Matrerialprogression;
import com.noxfy.matrerialprogression.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

import java.util.Map;

public class SteelArmorMaterial {
    public static final int BASE_DURABILITY = 15;
    public static final RegistryKey<EquipmentAsset> STEEL_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Matrerialprogression.MOD_ID, "steel"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 5,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 2
            ),
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ModTags.REPAIRS_STEEL_ARMOR,
            STEEL_ARMOR_MATERIAL_KEY
    );
}
