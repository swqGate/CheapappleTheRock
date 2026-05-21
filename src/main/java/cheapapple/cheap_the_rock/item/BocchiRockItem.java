package cheapapple.cheap_the_rock.item;

import cheapapple.cheap_the_rock.entity.BocchiRockEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BocchiRockItem extends BlockItem {

    public BocchiRockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((Entity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_STONE_HIT, SoundCategory.NEUTRAL, 6.0F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (world instanceof ServerWorld serverWorld) {
            ProjectileEntity.spawnWithVelocity(BocchiRockEntity::new, serverWorld, itemStack, user, 0.0F, 1.5F, 1.0F);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.decrementUnlessCreative(1, user);
        return ActionResult.SUCCESS;
    }
}
