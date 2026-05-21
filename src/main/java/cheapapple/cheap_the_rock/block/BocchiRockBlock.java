package cheapapple.cheap_the_rock.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.EnumMap;
import java.util.Map;

public class BocchiRockBlock extends FallingBlock {
    public static final EnumProperty<EightDirection> FACING = EnumProperty.of("facing", EightDirection.class);
    private static final Map<EightDirection, VoxelShape> SHAPES = new EnumMap<>(EightDirection.class);

    public BocchiRockBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, EightDirection.NORTH));
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }

    @Override
    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return state.getMapColor(world, pos).color;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(1.0F, 16);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        assert ctx.getPlayer() != null;
        float yaw = ctx.getPlayer().getYaw();
        return this.getDefaultState().with(FACING, getDirectionFromYaw(yaw));
    }

    private static EightDirection getDirectionFromYaw(float yaw) {
        yaw = (yaw % 360 + 360) % 360;

        if (yaw >= 337.5 || yaw < 22.5)   return EightDirection.NORTH;
        if (yaw >= 22.5 && yaw < 67.5)    return EightDirection.NORTH_WEST;
        if (yaw >= 67.5 && yaw < 112.5)   return EightDirection.EAST;
        if (yaw >= 112.5 && yaw < 157.5)  return EightDirection.SOUTH_EAST;
        if (yaw >= 157.5 && yaw < 202.5)  return EightDirection.SOUTH;
        if (yaw >= 202.5 && yaw < 247.5)  return EightDirection.SOUTH_WEST;
        if (yaw >= 247.5 && yaw < 292.5)  return EightDirection.WEST;
        return EightDirection.NORTH_EAST;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = SHAPES.get(state.get(FACING));
        return shape != null ? shape : Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
    }

    @Override
    protected float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected boolean isTransparent(BlockState state) {
        return true;
    }
}
