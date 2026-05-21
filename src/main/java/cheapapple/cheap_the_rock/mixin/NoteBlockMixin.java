package cheapapple.cheap_the_rock.mixin;

import cheapapple.cheap_the_rock.init.ModBlocks;
import cheapapple.cheap_the_rock.init.ModItems;
import cheapapple.cheap_the_rock.init.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NoteBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(NoteBlock.class)
public class NoteBlockMixin {
	@Inject(method = "playNote", at = @At("HEAD"), cancellable = true)
	private void cheap_the_rock$interceptGuitarNote(Entity entity, BlockState state, World world, BlockPos pos, CallbackInfo ci) {
		if(world.getBlockState(pos.up()).isAir()) {
			BlockState blockBelow = world.getBlockState(pos.down());
			int note = state.get(NoteBlock.NOTE);
			float pitch = (float) Math.pow(2.0, (double) (note - 12) / 12.0);

			if (blockBelow.isOf(ModBlocks.AMP)) {
				world.playSound(
						null,
						pos,
						ModSounds.DISTORTION_GUITAR,
						net.minecraft.sound.SoundCategory.RECORDS,
						3.0F,
						pitch
				);

				if (world instanceof ServerWorld serverWorld)
					serverWorld.spawnParticles(
						net.minecraft.particle.ParticleTypes.NOTE,
						(double) pos.getX() + 0.5,
						(double) pos.getY() + 1.2,
						(double) pos.getZ() + 0.5,
						1,
						0.0,
						(double) note / 24.0,
						0.0,
						1.5
				);

				ci.cancel();
			}

			if (blockBelow.isOf(ModBlocks.BLOCK_OF_PICKS) || (entity instanceof LivingEntity livingEntity && livingEntity.getMainHandStack().isOf(ModItems.PICK))) {
				world.playSound(
						null,
						pos,
						ModSounds.ELECTRIC_GUITAR,
						net.minecraft.sound.SoundCategory.RECORDS,
						3.0F,
						pitch
				);

				if (world instanceof ServerWorld serverWorld)
					serverWorld.spawnParticles(
							net.minecraft.particle.ParticleTypes.NOTE,
							(double) pos.getX() + 0.5,
							(double) pos.getY() + 1.2,
							(double) pos.getZ() + 0.5,
							1,
							0.0,
							(double) note / 24.0,
							0.0,
							1.5
					);

				ci.cancel();
			}

			if (blockBelow.isOf(Blocks.SKELETON_SKULL) || blockBelow.isOf(Blocks.SKELETON_WALL_SKULL)) {
				world.playSound(
						null,
						pos,
						ModSounds.SKULL_GUITAR,
						net.minecraft.sound.SoundCategory.RECORDS,
						3.0F,
						pitch
				);

				if (world instanceof ServerWorld serverWorld)
					serverWorld.spawnParticles(
							net.minecraft.particle.ParticleTypes.NOTE,
							(double) pos.getX() + 0.5,
							(double) pos.getY() + 1.2,
							(double) pos.getZ() + 0.5,
							1,
							0.0,
							(double) note / 24.0,
							0.0,
							1.5
					);

				ci.cancel();
			}

			if (blockBelow.isOf(Blocks.WITHER_SKELETON_SKULL) || blockBelow.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)) {
				world.playSound(
						null,
						pos,
						ModSounds.SANS_SYNTH,
						net.minecraft.sound.SoundCategory.RECORDS,
						3.0F,
						pitch
				);

				if (world instanceof ServerWorld serverWorld)
					serverWorld.spawnParticles(
							net.minecraft.particle.ParticleTypes.NOTE,
							(double) pos.getX() + 0.5,
							(double) pos.getY() + 1.2,
							(double) pos.getZ() + 0.5,
							1,
							0.0,
							(double) note / 24.0,
							0.0,
							1.5
					);

				ci.cancel();
			}
		}
	}
}
