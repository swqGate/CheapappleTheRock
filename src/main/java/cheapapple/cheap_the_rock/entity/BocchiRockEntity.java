package cheapapple.cheap_the_rock.entity;

import cheapapple.cheap_the_rock.init.ModBlocks;
import cheapapple.cheap_the_rock.init.ModEntityTypes;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalFluidTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BocchiRockEntity extends ThrownItemEntity {

    public BocchiRockEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BocchiRockEntity(ServerWorld serverWorld, LivingEntity owner, ItemStack stack) {
        super(ModEntityTypes.BOCCHI_ROCK, owner, serverWorld, stack);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.serverDamage(this.getDamageSources().thrown(this, this.getOwner()), 4);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getBlockStateAtPos().getFluidState().isIn(ConventionalFluidTags.WATER) && this.getEntityWorld().getBlockState(this.getBlockPos().up()).isAir()) {
            for (int i = 0; i < random.nextBetween(6, 10); i++) {
                this.getEntityWorld().addParticleClient(
                        ParticleTypes.SPLASH,
                        this.getEntityPos().x,
                        this.getEntityPos().y,
                        this.getEntityPos().z,
                        this.random.nextDouble() * 3,
                        0.2,
                        this.random.nextDouble() * 3
                );
            }
            this.setVelocity(this.getVelocity().multiply(0.6, -0.7, 0.6));
            this.velocityDirty = true;
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getEntityWorld().isClient()) {
            if (hitResult.getType() == HitResult.Type.BLOCK && hitResult instanceof BlockHitResult blockHit) {
                BlockPos blockPos = blockHit.getBlockPos();
                BlockState blockState = this.getEntityWorld().getBlockState(blockPos);

                if (!blockState.isAir() && (blockState.isIn(ConventionalBlockTags.GLASS_BLOCKS) || blockState.isIn(ConventionalBlockTags.GLASS_PANES))) {
                    this.getEntityWorld().breakBlock(blockPos, true, this.getOwner());
                }
            }
            this.getEntityWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.dropStack((ServerWorld) this.getEntityWorld(), new ItemStack(ModBlocks.BOCCHI_ROCK_ITEM, 1));
            this.discard();
        }
    }

    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    @Override
    protected Item getDefaultItem() {
        return ModBlocks.BOCCHI_ROCK_ITEM;
    }
}
