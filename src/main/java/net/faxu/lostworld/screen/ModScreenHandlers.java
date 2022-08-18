package net.faxu.lostworld.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.faxu.lostworld.LostWorld;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<TanningRackScreenHandler> TANNING_RACK_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(LostWorld.MOD_ID, "tanning_rack"),
                    TanningRackScreenHandler::new);
}
