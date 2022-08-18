package net.faxu.lostworld;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.faxu.lostworld.block.ModBlocks;
import net.faxu.lostworld.block.entity.ModBlockEntities;
import net.faxu.lostworld.config.LostWorldConfig;
import net.faxu.lostworld.effect.ModEffects;
import net.faxu.lostworld.enchantment.ModEnchantments;
import net.faxu.lostworld.item.ModItems;
import net.faxu.lostworld.networking.ModMessages;
import net.faxu.lostworld.particle.ModParticles;
import net.faxu.lostworld.util.ModLootTableModifiers;
import net.faxu.lostworld.util.ModRegistries;
import net.faxu.lostworld.world.feature.ModConfiguredFeatures;
import net.faxu.lostworld.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class LostWorld implements ModInitializer {
	public static LostWorldConfig CONFIG = new LostWorldConfig();
	public static final String MOD_ID = "lostworld";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModOreGeneration.generateOres();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();
		ModLootTableModifiers.modifyLootTables();
		ModEffects.registerEffects();
		ModParticles.registerParticles();
		ModEnchantments.registerModEnchantments();
		ModMessages.registerC2SPackets();

		GeckoLib.initialize();

		ModBlockEntities.registerAllBlockEntities();

		AutoConfig.register(LostWorldConfig.class, JanksonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(LostWorldConfig.class).getConfig();
	}
}
