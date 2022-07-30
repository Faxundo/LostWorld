package net.faxu.lostworld;

import net.fabricmc.api.ModInitializer;
import net.faxu.lostworld.block.ModBlocks;
import net.faxu.lostworld.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostWorld implements ModInitializer {
	public static final String MOD_ID = "lostworld";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
