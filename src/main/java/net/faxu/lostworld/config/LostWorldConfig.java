package net.faxu.lostworld.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;


@Config(name = "lostworld")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class LostWorldConfig implements ConfigData {


    @Comment("Bleeding enchant or not")
    public boolean activateBleedingEnchantment = true;
    @Comment("Capture enchant or not")
    public boolean activateCaptureEnchantment = true;
    @Comment("Guard enchant or not")
    public boolean activateGuardEnchantment = true;
    @Comment("Mighty enchant or not")
    public boolean activateMightyEnchantment = true;

}
