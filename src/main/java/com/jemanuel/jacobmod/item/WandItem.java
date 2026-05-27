package com.jemanuel.jacobmod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class WandItem extends Item {

    public WandItem(Item.Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Vec3 eyePos = player.getEyePosition();
            Vec3 endPos = eyePos.add(player.getLookAngle().scale(32.0));
            BlockHitResult hit = level.clip(new ClipContext(eyePos, endPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

            Vec3 targetPos = hit.getType() == HitResult.Type.MISS ? endPos : hit.getLocation();

            LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lightning.setPos(targetPos.x, targetPos.y, targetPos.z);
            level.addFreshEntity(lightning);

            player.getCooldowns().addCooldown(player.getItemInHand(hand), 40);
        }
        player.swing(hand);
        return InteractionResult.SUCCESS;
    }
}