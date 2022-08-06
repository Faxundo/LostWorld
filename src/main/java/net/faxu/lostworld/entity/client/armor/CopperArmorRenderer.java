package net.faxu.lostworld.entity.client.armor;

import net.faxu.lostworld.item.custom.CopperArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CopperArmorRenderer extends GeoArmorRenderer<CopperArmorItem> {
    public CopperArmorRenderer() {
        super(new CopperArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
