package com.noxfy.matrerialprogression;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Item> REPAIRS_STEEL_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "repairs_steel_armor"));
}
