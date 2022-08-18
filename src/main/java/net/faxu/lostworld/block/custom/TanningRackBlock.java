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
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


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

    //    public static final VoxelShape SHAPE_N = Stream.of(
//            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
//            Block.createCuboidShape(0, 4, 12, 16, 17, 16),
//            Block.createCuboidShape(0, -0.9, 3.4, 16, 16.0, 3.4),
//            Block.createCuboidShape(15, 4, 0, 16, 16, 12),
//            Block.createCuboidShape(0, 4, 0, 1, 16, 12),
//            Block.createCuboidShape(0, -0.3, 2.6, 1, 16.6, 3.6),
//            Block.createCuboidShape(15, -0.3, 2.6, 16, 16.6, 3.6),
//            Block.createCuboidShape(4, 0, 0, 12, 1, 3),
//            Block.createCuboidShape(4, 3, 0, 12, 4, 3),
//            Block.createCuboidShape(3, 0, 0, 4, 3, 3),
//            Block.createCuboidShape(12, 0, 0, 13, 3, 3),
//            Block.createCuboidShape(4, 1, 3, 12, 3, 4)
//    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
//
//    public static final VoxelShape SHAPE_W = Stream.of(
//            Block.createCuboidShape(0.25, 0, -0.25, 16.25, 4, 15.75),
//            Block.createCuboidShape(12.25, 4, -0.25, 16.25, 17, 15.75),
//            Block.createCuboidShape(3.6, -0.9, -0.25, 3.6, 16, 15.75),
//            Block.createCuboidShape(0.25, 4, -0.25, 12.25, 16, 0.75),
//            Block.createCuboidShape(0.25, 4, 14.75, 12.25, 16, 15.75),
//            Block.createCuboidShape(2.1, 9.6, 14.75, 19.1, 10.6, 15.75),
//            Block.createCuboidShape(2.1, 9.6, -0.25, 19.1, 10.6, 0.75),
//            Block.createCuboidShape(0.25, 0, 3.75, 3.25, 1, 11.75),
//            Block.createCuboidShape(0.25, 3, 3.75, 3.25, 4, 11.75),
//            Block.createCuboidShape(0.25, 0, 11.75, 3.25, 3, 12.75),
//            Block.createCuboidShape(0.25, 0, 2.75, 3.25, 3, 3.75),
//            Block.createCuboidShape(3.25, 1, 3.75, 4.25, 3, 11.75)
//    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
//
//    public static final VoxelShape SHAPE_S = Stream.of(
//            Block.createCuboidShape(0, 0, -0.5, 16, 4, 15.5),
//            Block.createCuboidShape(0, 4, -0.5, 16, 17, 3.5),
//            Block.createCuboidShape(0, -0.9, 12, 16, 16, 12),
//            Block.createCuboidShape(0, 4, 3.5, 1, 16, 15.5),
//            Block.createCuboidShape(15, 4, 3.5, 16, 16, 15.5),
//            Block.createCuboidShape(15, -0.3, 11.8, 16, 16.6, 12.8),
//            Block.createCuboidShape(0, -0.3, 11.8, 1, 16.6, 12.8),
//            Block.createCuboidShape(4, 0, 12.5, 12, 1, 15.5),
//            Block.createCuboidShape(4, 3, 12.5, 12, 4, 15.5),
//            Block.createCuboidShape(12, 0, 12.5, 13, 3, 15.5),
//            Block.createCuboidShape(3, 0, 12.5, 4, 3, 15.5),
//            Block.createCuboidShape(4, 1, 11.5, 12, 3, 12.5)
//    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
//
//    public static final VoxelShape SHAPE_E = Stream.of(
//            Block.createCuboidShape(-0.25, 0, -0.25, 15.75, 4, 15.75),
//            Block.createCuboidShape(-0.25, 4, -0.25, 3.75, 17, 15.75),
//            Block.createCuboidShape(-2.4, 9.9, -0.25, 14.5, 9.9, 15.75),
//            Block.createCuboidShape(3.75, 4, 14.75, 15.75, 16, 15.75),
//            Block.createCuboidShape(3.75, 4, -0.25, 15.75, 16, 0.75),
//            Block.createCuboidShape(12.0, -0.3, -0.25, 13.0, 16.6, 0.75),
//            Block.createCuboidShape(12.0, -0.3, 14.75, 13.0, 16.6, 15.75),
//            Block.createCuboidShape(12.75, 0, 3.75, 15.75, 1, 11.75),
//            Block.createCuboidShape(12.75, 3, 3.75, 15.75, 4, 11.75),
//            Block.createCuboidShape(12.75, 0, 2.75, 15.75, 3, 3.75),
//            Block.createCuboidShape(12.75, 0, 11.75, 15.75, 3, 12.75),
//            Block.createCuboidShape(11.75, 1, 3.75, 12.75, 3, 11.75)
//    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        switch (state.get(FACING)) {
//            case NORTH:
//                return SHAPE_N;
//            case WEST:
//                return SHAPE_W;
//            case SOUTH:
//                return SHAPE_S;
//            case EAST:
//                return SHAPE_E;
//            default:
//                return SHAPE_N;
//        }
//    }
}
