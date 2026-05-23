package cheapapple.cheap_the_rock.world.feature;

import cheapapple.cheap_the_rock.block.BocchiRockBlock;
import cheapapple.cheap_the_rock.block.EightDirection;
import cheapapple.cheap_the_rock.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BocchiRocksFeature extends Feature<DefaultFeatureConfig> {
    public BocchiRocksFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        var random = context.getRandom();
        boolean generated = false;

        for (int i = 0; i < random.nextBetween(3, 6); i++) {
            int x = random.nextBetween(-3, 3);
            int z = random.nextBetween(-3, 3);
            BlockPos targetPos = world.getTopPosition(net.minecraft.world.Heightmap.Type.WORLD_SURFACE_WG, origin.add(x, 0, z));
            BlockPos floorPos = targetPos.down();

            if (world.getBlockState(floorPos).isOf(Blocks.GRASS_BLOCK)) {

                world.setBlockState(targetPos, Blocks.PINK_TULIP.getDefaultState(), 2);
                
                BlockPos rockPos = targetPos.east();
                if (world.getBlockState(rockPos).isAir() && world.getBlockState(rockPos.down()).isOf(Blocks.GRASS_BLOCK)) {
                    BlockState rockState = ModBlocks.BOCCHI_ROCK.getDefaultState().with(BocchiRockBlock.FACING, EightDirection.values()[random.nextBetween(0, 7)]);
                    world.setBlockState(rockPos, rockState, 2);
                    generated = true;
                }
            }
        }
        return generated;
    }
}
