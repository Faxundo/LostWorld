package net.faxu.lostworld.block.custom;

import net.faxu.lostworld.block.entity.ModBlockEntities;
import net.faxu.lostworld.block.entity.TanningRackBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;


public class TanningRackBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public TanningRackBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof TanningRackBlockEntity) {
                ItemScatterer.spawn(world, pos, (TanningRackBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TanningRackBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.TANNING_RACK, TanningRackBlockEntity::tick);
    }

        public static final VoxelShape SHAPE_N = Stream.of(
                Block.createCuboidShape(0, 0, 0, 16, 5, 16),
                Block.createCuboidShape(2, 15, 1, 14, 15, 13),
                Block.createCuboidShape(0, 5, 13, 16, 16, 16),
                Block.createCuboidShape(0, 5, 0, 2, 16, 13),
                Block.createCuboidShape(14, 5, 0, 16, 16, 13),
                Block.createCuboidShape(2, 5, 1, 14, 12, 13),
                Block.createCuboidShape(2, 5, 0, 14, 15, 1)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(-1.0658141036401503e-14, 0, 3.552713678800501e-15, 15.999999999999991, 5, 16.000000000000004),
            Block.createCuboidShape(1.0000000000000009, 15, 1.9999999999999876, 13, 15, 13.999999999999986),
            Block.createCuboidShape(12.99999999999999, 5, 3.552713678800501e-15, 15.99999999999999, 16, 16.000000000000004),
            Block.createCuboidShape(-2.6645352591003757e-15, 5, 13.999999999999993, 13, 16, 15.999999999999993),
            Block.createCuboidShape(-2.6645352591003757e-15, 5, 4.440892098500626e-15, 13, 16, 2.0000000000000036),
            Block.createCuboidShape(1.0000000000000009, 5, 1.9999999999999876, 13, 12, 13.999999999999986),
            Block.createCuboidShape(-2.6645352591003757e-15, 5, 1.9999999999999876, 0.9999999999999973, 15, 13.999999999999986)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(0, 0, 0, 16, 5, 16),
            Block.createCuboidShape(2, 15, 3, 14, 15, 15),
            Block.createCuboidShape(0, 5, 0, 16, 16, 3),
            Block.createCuboidShape(14, 5, 3, 16, 16, 16),
            Block.createCuboidShape(0, 5, 3, 2, 16, 16),
            Block.createCuboidShape(2, 5, 3, 14, 12, 15),
            Block.createCuboidShape(2, 5, 15, 14, 15, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(-5.329070518200751e-15, 0, -1.0658141036401503e-14, 15.999999999999995, 5, 15.99999999999999),
            Block.createCuboidShape(2.999999999999986, 15, 2.000000000000007, 14.999999999999986, 15, 14.000000000000007),
            Block.createCuboidShape(-3.1086244689504383e-15, 5, -1.0658141036401503e-14, 2.999999999999996, 16, 15.99999999999999),
            Block.createCuboidShape(2.999999999999986, 5, 3.1086244689504383e-15, 15.99999999999999, 16, 2.000000000000003),
            Block.createCuboidShape(2.999999999999986, 5, 13.999999999999991, 15.99999999999999, 16, 15.999999999999991),
            Block.createCuboidShape(2.999999999999986, 5, 2.000000000000007, 14.999999999999986, 12, 14.000000000000007),
            Block.createCuboidShape(14.999999999999988, 5, 2.000000000000007, 15.99999999999999, 15, 14.000000000000007)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }
}
