package net.faxu.lostworld.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.faxu.lostworld.LostWorld;
import net.faxu.lostworld.block.custom.BitterRootCropBlock;
import net.faxu.lostworld.block.custom.TanningRackBlock;
import net.faxu.lostworld.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    //BLOCKS
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3.5f).requiresTool()), ModItemGroup.LOSTWORLD);
    public static final Block SALT_BLOCK = registerBlock("salt_block",
            new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5f).sounds(BlockSoundGroup.SAND)), ModItemGroup.LOSTWORLD);
    //ORES
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool(),
            UniformIntProvider.create(3, 7)), ModItemGroup.LOSTWORLD);
    public static final Block TIN_ORE_DEEPSLATE = registerBlock("tin_ore_deepslate",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.LOSTWORLD);
    //CROPS
    public static final Block BITTER_ROOT_CROP = registerBlockWithoutItem("bitter_root_crop",
            new BitterRootCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    //UTIL
    public static final Block TANNING_RACK = registerBlock("tanning_rack",
            new TanningRackBlock(FabricBlockSettings.of(Material.WOOD).nonOpaque()), ModItemGroup.LOSTWORLD);

    //Register new Block
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(LostWorld.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(LostWorld.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(LostWorld.MOD_ID, name), block);
    }
    //Register Block like item
    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(LostWorld.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    //Message for debug view
    public static void registerModBlocks() {
        LostWorld.LOGGER.debug("Registering ModBlocks for " + LostWorld.MOD_ID);
    }
}
