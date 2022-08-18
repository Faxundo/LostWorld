package net.faxu.lostworld.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.faxu.lostworld.LostWorld;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
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
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
