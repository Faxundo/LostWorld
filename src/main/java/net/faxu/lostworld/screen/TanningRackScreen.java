package net.faxu.lostworld.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.item.custom.KnifeItem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TanningRackScreen extends HandledScreen<TanningRackScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(LostWorld.MOD_ID, "textures/gui/tanning_rack_gui.png");

    public TanningRackScreen(TanningRackScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.playerInventoryTitleY = 80;
    }

    @Override
    protected void init() {
        super.init();
        titleX = 99;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, (backgroundHeight + 10));
        if (!handler.getSlot(0).hasStack()) {
            drawTexture(matrices, x + 46, y + 51, 177, 43, 16, 16);
        }
        if (!handler.getSlot(1).hasStack()) {
            drawTexture(matrices, x + 27, y + 17, 177, 59, 16, 16);
        }
        if (!handler.getSlot(2).hasStack()) {
            drawTexture(matrices, x + 64, y + 17, 177, 75, 16, 16);
        }
        if ((handler.getSlot(0).hasStack() || handler.getSlot(1).hasStack())) {
            if (!(handler.getSlot(0).getStack().getItem() instanceof KnifeItem)
                    || !(handler.getSlot(1).getStack().getItem().equals(Items.LEATHER))) {
                drawTexture(matrices, x + 102, y + 32, 177, 1, 28, 21);
            }
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
