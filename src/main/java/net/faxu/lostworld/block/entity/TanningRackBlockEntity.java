package net.faxu.lostworld.block.entity;

import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.item.custom.KnifeItem;
import net.faxu.lostworld.item.inventory.ImplementedInventory;
import net.faxu.lostworld.recipe.TanningRackRecipe;
import net.faxu.lostworld.screen.TanningRackScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TanningRackBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 100;

    public TanningRackBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TANNING_RACK, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0:return TanningRackBlockEntity.this.progress;
                    case 1: return TanningRackBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: TanningRackBlockEntity.this.progress = value; break;
                    case 1: TanningRackBlockEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.lostworld.tanning_rack");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new TanningRackScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("tanning.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("tanning.progress");
    }

    public static void tick(World world, BlockPos pos, BlockState state, TanningRackBlockEntity entity) {
        if (entity.getStack(0).getItem() == ModItems.FLINT_KNIFE) {entity.maxProgress = 180;}
        if (entity.getStack(0).getItem() == ModItems.IRON_KNIFE) {entity.maxProgress = 140;}
        if (hasRecipe(entity) && hasNotReachedStackLimit(entity) && entity.getStack(0).getItem() instanceof KnifeItem) {
            entity.progress++;
            if (entity.progress == entity.maxProgress) {
                craftItem(entity);
                entity.resetProgress();
            } else if (entity.progress > entity.maxProgress) {
                entity.resetProgress();
            }
        } else {
            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean hasRecipe(TanningRackBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<TanningRackRecipe> match = world.getRecipeManager()
                .getFirstMatch(TanningRackRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(TanningRackBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<TanningRackRecipe> match = world.getRecipeManager()
                .getFirstMatch(TanningRackRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            ItemStack stack = entity.getStack(0);
            if (stack.getItem() instanceof KnifeItem) {
                if (!(stack.getDamage() == stack.getMaxDamage())) {
                    if (stack.damage(1, Random.create(0), null)) {
                        stack.decrement(1);
                    }
                }
                entity.removeStack(1,1);
                entity.removeStack(2,1);
                entity.setStack(3, new ItemStack(match.get().getOutput().getItem(),
                        entity.getStack(3).getCount() + 1));
            }
        }
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(3).getItem() == output.getItem() || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount();
    }

    private static boolean hasNotReachedStackLimit(TanningRackBlockEntity entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }
}
