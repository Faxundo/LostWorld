package net.faxu.lostworld.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;


@Config(name = "lostworld")
@Config.Gui.Background("minecraft:textures/block/stone.png")
public class LostWorldConfig implements ConfigData {


    @Comment("Bleeding enchant is enabled or not")
    public boolean activateBleedingEnchantment = true;
    @Comment("Capture enchant is enabled or not")
    public boolean activateCaptureEnchantment = true;
    @Comment("Guard enchant is enabled or not")
    public boolean activateGuardEnchantment = true;
    @Comment("Mighty enchant is enabled or not")
    public boolean activateMightyEnchantment = true;
    @Comment("Butchering enchant is enabled or not")
    public boolean activateButcheringEnchantment = true;
    @Comment("Slingshot can use Punch or no")
    public boolean SlingshotUsePunchEnchantment = true;
}
