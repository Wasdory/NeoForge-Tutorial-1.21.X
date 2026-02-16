package net.wasdory.tutorialmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class BoneBowItem extends BowItem {
    public static final float DRAW_SPEED_MULTIPLIER = 10.0F;
    private static final float VELOCITY_MULTIPLIER = 3.5F;
    private static final float DAMAGE_MULTIPLIER = 1.5F;
    private static final int MAX_DRAW_TICKS = 18;

    public BoneBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        // В 1.21 используется onUseTick вместо onUsingTick
        if (livingEntity instanceof Player player) {
            int usedTicks = this.getUseDuration(stack, livingEntity) - remainingUseDuration;

            // Принудительная остановка после 18 тиков
            if (usedTicks > MAX_DRAW_TICKS) {
                player.stopUsingItem();  // Останавливаем использование

                // Автоматически выпускаем стрелу
                this.releaseUsing(stack, level, livingEntity, remainingUseDuration);
            }
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        // Ваш существующий код releaseUsing()...
        if (entityLiving instanceof Player player) {
            int usedTicks = this.getUseDuration(stack, entityLiving) - timeLeft;

            // Ограничиваем максимальное время для расчета силы
            if (usedTicks > MAX_DRAW_TICKS) {
                usedTicks = MAX_DRAW_TICKS;
            }

            // Остальной код releaseUsing()...
            ItemStack projectileStack = player.getProjectile(stack);
            if (!projectileStack.isEmpty()) {
                float power = getCustomPowerForTime(usedTicks);
                if (power >= 0.1F) {
                    // Стрельба...
                    List<ItemStack> projectiles = draw(stack, projectileStack, player);

                    if (level instanceof ServerLevel serverLevel && !projectiles.isEmpty()) {
                        this.shoot(
                                serverLevel,
                                player,
                                player.getUsedItemHand(),
                                stack,
                                projectiles,
                                power * VELOCITY_MULTIPLIER,
                                DAMAGE_MULTIPLIER,
                                power == 1.0F,
                                null
                        );
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS,
                            1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + power * 0.5F);

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    private float getCustomPowerForTime(int charge) {
        float f = (float) charge / DRAW_SPEED_MULTIPLIER;
        f = (f * f + f * 2.0F) / 3.0F;
        return Math.min(f, 1.0F);
    }

    @Override
    public int getEnchantmentValue() {
        return 3;
    }
}