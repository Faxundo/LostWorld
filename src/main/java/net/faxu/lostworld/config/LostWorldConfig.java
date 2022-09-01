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
    @Comment("Curse of Rusty is enabled or not")
    public boolean activateRustyCurse = true;
    @Comment("Curse of Thorny Roses is enabled or not")
    public boolean activateThornyRoses = true;
    @Comment("Hunt enchant is enabled or not")
    public boolean activateHunt = true;
    @Comment("Assassinate enchant is enabled or not")
    public boolean activateAssassinate = true;
    @Comment("Multiple Impact enchant is enabled or not")
    public boolean activateMultipleImpact = true;
}
