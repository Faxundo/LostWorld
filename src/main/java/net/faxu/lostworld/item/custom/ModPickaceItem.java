package net.faxu.lostworld.item.custom;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ModPickaceItem extends PickaxeItem {
    //Needed this object why the vanilla version is protected and don't can be used with liberty
    public ModPickaceItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
