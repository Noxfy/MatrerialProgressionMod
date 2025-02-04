package com.noxfy.matrerialprogression.items;


import com.noxfy.matrerialprogression.Matrerialprogression;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import static com.noxfy.matrerialprogression.Matrerialprogression.MOD_ID;
import static net.minecraft.item.Items.BOWL;

public class ModItems {
    //nether star stuff

    public static final RegistryKey<Item> STAR_MOTE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "star_mote"));
    public static final Item STAR_MOTE = register(new StarMoteItem(new Item.Settings().registryKey(STAR_MOTE_KEY)), STAR_MOTE_KEY);

    public static final ConsumableComponent STARRY_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.GLOWING, 3 * 20, 0), 1.0f))
            .build();
    public static final FoodComponent STARRY_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();

    public static final RegistryKey<Item> STAR_MOTE_STEW_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "star_mote_stew"));
    public static final Item STAR_MOTE_STEW = register(new StarMoteStewItem(new Item.Settings().food(STARRY_FOOD_COMPONENT, STARRY_FOOD_CONSUMABLE_COMPONENT).registryKey(STAR_MOTE_STEW_KEY).maxCount(1).useRemainder(BOWL)), STAR_MOTE_STEW_KEY);

    public static final RegistryKey<Item> STARRY_EYE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "starry_eye"));
    public static final Item STARRY_EYE = register(new StarryEyeItem(new Item.Settings().registryKey(STARRY_EYE_KEY)), STARRY_EYE_KEY);


    public static final RegistryKey<Item> BRONZE_SHIELD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "bronze_shield"));
    public static final Item BRONZE_SHIELD = register(new ShieldItem(
            new Item.Settings().maxDamage(150).repairable(Items.IRON_INGOT)
                    .attributeModifiers(AttributeModifiersComponent.builder()
                            .add(EntityAttributes.ARMOR, new EntityAttributeModifier(Identifier.of(Matrerialprogression.MOD_ID, "bronze_shield"), 4.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.HAND).build())
                    .registryKey(BRONZE_SHIELD_KEY)), BRONZE_SHIELD_KEY);


    //steel
    public static final ToolMaterial STEEL_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, // TODO
            250,
            6.0F,
            2.0F,
            14,
            ItemTags.IRON_TOOL_MATERIALS // TODO
    );

    public static final RegistryKey<Item> STEEL_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_ingot"));
    public static final Item STEEL_INGOT = register(new Item(new Item.Settings().registryKey(STEEL_INGOT_KEY)), STEEL_INGOT_KEY);

    public static final RegistryKey<Item> STEEL_NUGGET_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_nugget"));
    public static final Item STEEL_NUGGET = register(new Item(new Item.Settings().registryKey(STEEL_NUGGET_KEY)), STEEL_NUGGET_KEY);


    public static final RegistryKey<Item> STEEL_SWORD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_sword"));
    public static final Item STEEL_SWORD = register(new SwordItem(STEEL_TOOL_MATERIAL, 2f, -2.4f, new Item.Settings().registryKey(STEEL_SWORD_KEY)), STEEL_SWORD_KEY);

    public static final RegistryKey<Item> STEEL_PICKAXE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_pickaxe"));
    public static final Item STEEL_PICKAXE = register(new PickaxeItem(STEEL_TOOL_MATERIAL, 0f, -2.8f, new Item.Settings().registryKey(STEEL_PICKAXE_KEY)), STEEL_PICKAXE_KEY);

    public static final RegistryKey<Item> STEEL_AXE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_axe"));
    public static final Item STEEL_AXE = register(new AxeItem(STEEL_TOOL_MATERIAL, 5f, -3.9f, new Item.Settings().registryKey(STEEL_AXE_KEY)), STEEL_AXE_KEY);

    public static final RegistryKey<Item> STEEL_SHOVEL_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_shovel"));
    public static final Item STEEL_SHOVEL = register(new ShovelItem(STEEL_TOOL_MATERIAL, 0.5f, -3f, new Item.Settings().registryKey(STEEL_SHOVEL_KEY)), STEEL_SHOVEL_KEY);

    public static final RegistryKey<Item> STEEL_HOE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_hoe"));
    public static final Item STEEL_HOE = register(new HoeItem(STEEL_TOOL_MATERIAL, -2f, -1f, new Item.Settings().registryKey(STEEL_HOE_KEY)), STEEL_HOE_KEY);


    public static final RegistryKey<Item> STEEL_HELMET_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_helmet"));
    public static final Item STEEL_HELMET = register(new ArmorItem(SteelArmorMaterial.INSTANCE, EquipmentType.HELMET, new Item.Settings().registryKey(STEEL_HELMET_KEY).maxDamage(EquipmentType.HELMET.getMaxDamage(SteelArmorMaterial.BASE_DURABILITY))), STEEL_HELMET_KEY);

    public static final RegistryKey<Item> STEEL_CHESTPLATE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_chestplate"));
    public static final Item STEEL_CHESTPLATE = register(new ArmorItem(SteelArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, new Item.Settings().registryKey(STEEL_CHESTPLATE_KEY).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(SteelArmorMaterial.BASE_DURABILITY))), STEEL_CHESTPLATE_KEY);

    public static final RegistryKey<Item> STEEL_LEGGINGS_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_leggings"));
    public static final Item STEEL_LEGGINGS = register(new ArmorItem(SteelArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, new Item.Settings().registryKey(STEEL_LEGGINGS_KEY).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(SteelArmorMaterial.BASE_DURABILITY))), STEEL_LEGGINGS_KEY);

    public static final RegistryKey<Item> STEEL_BOOTS_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Matrerialprogression.MOD_ID, "steel_boots"));
    public static final Item STEEL_BOOTS = register(new ArmorItem(SteelArmorMaterial.INSTANCE, EquipmentType.BOOTS, new Item.Settings().registryKey(STEEL_BOOTS_KEY).maxDamage(EquipmentType.BOOTS.getMaxDamage(SteelArmorMaterial.BASE_DURABILITY))), STEEL_BOOTS_KEY);
    
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }

    public static void initialize() {
        //star stuff
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.NETHER_STAR, ModItems.STAR_MOTE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.ENDER_EYE, ModItems.STARRY_EYE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.ENDER_EYE, ModItems.STARRY_EYE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.addAfter(Items.RABBIT_STEW, ModItems.STAR_MOTE_STEW));

        //bronze
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.SHIELD, ModItems.BRONZE_SHIELD));

        //steel
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_INGOT, ModItems.STEEL_INGOT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_NUGGET, ModItems.STEEL_NUGGET));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_SWORD, ModItems.STEEL_SWORD));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_AXE, ModItems.STEEL_AXE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_BOOTS, ModItems.STEEL_BOOTS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_BOOTS, ModItems.STEEL_LEGGINGS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_BOOTS, ModItems.STEEL_CHESTPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_BOOTS, ModItems.STEEL_HELMET));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.IRON_HOE, ModItems.STEEL_SHOVEL));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(ModItems.STEEL_SHOVEL, ModItems.STEEL_PICKAXE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(ModItems.STEEL_PICKAXE, ModItems.STEEL_AXE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(ModItems.STEEL_AXE, ModItems.STEEL_HOE));
        //
    }
}