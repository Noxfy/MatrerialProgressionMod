package com.noxfy.matrerialprogression.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StarryEyeItem extends Item {
    public StarryEyeItem(Settings settings) {
        super(settings);
    }
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 0;
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.END_PORTAL_FRAME) && !(Boolean)blockState.get(EndPortalFrameBlock.EYE)) {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                BlockState blockState2 = (BlockState)blockState.with(EndPortalFrameBlock.EYE, true);
                Block.pushEntitiesUpBeforeBlockChange(blockState, blockState2, world, blockPos);
                world.setBlockState(blockPos, blockState2, 2);
                world.updateComparators(blockPos, Blocks.END_PORTAL_FRAME);
                context.getStack().decrement(1);
                world.syncWorldEvent(1503, blockPos, 0);
                BlockPattern.Result result = EndPortalFrameBlock.getCompletedFramePattern().searchAround(world, blockPos);
                if (result != null) {
                    BlockPos blockPos2 = result.getFrontTopLeft().add(-3, 0, -3);

                    for(int i = 0; i < 3; ++i) {
                        for(int j = 0; j < 3; ++j) {
                            world.setBlockState(blockPos2.add(i, 0, j), Blocks.END_PORTAL.getDefaultState(), 2);
                        }
                    }

                    world.syncGlobalEvent(1038, blockPos2.add(1, 0, 1), 0);
                }

                return ActionResult.SUCCESS;
            }
        } else {
            return ActionResult.PASS;
        }
    }
}
