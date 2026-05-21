package cheapapple.cheap_the_rock.init;

import cheapapple.cheap_the_rock.CheapappleTheRock;
import cheapapple.cheap_the_rock.block.AmpBlock;
import cheapapple.cheap_the_rock.block.BocchiRockBlock;
import cheapapple.cheap_the_rock.item.BocchiRockItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block BOCCHI_ROCK = new BocchiRockBlock(AbstractBlock.Settings.create()
            .mapColor(DyeColor.PINK)
            .nonOpaque()
            .strength(0.6F, 3.0F)
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CheapappleTheRock.MOD_ID, "bocchi_rock")))
    );

    public static Item BOCCHI_ROCK_ITEM = new BocchiRockItem(
            BOCCHI_ROCK,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "bocchi_rock")))
    );

    public static Block BLOCK_OF_PICKS = new Block(Block.Settings.create()
            .mapColor(DyeColor.PINK)
            .strength(0.3F, 3.0F)
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CheapappleTheRock.MOD_ID, "block_of_picks")))
    );

    public static Block AMP = new AmpBlock(Block.Settings.create()
            .mapColor(DyeColor.BLACK)
            .strength(1.0F, 3.5F)
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CheapappleTheRock.MOD_ID, "amp")))
    );

    public static void init() {
        Registry.register(Registries.BLOCK, RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CheapappleTheRock.MOD_ID, "bocchi_rock")), BOCCHI_ROCK);
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "bocchi_rock")), BOCCHI_ROCK_ITEM);

        Registry.register(Registries.BLOCK, RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CheapappleTheRock.MOD_ID, "block_of_picks")), BLOCK_OF_PICKS);
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "block_of_picks")),
                new BlockItem(BLOCK_OF_PICKS, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "block_of_picks")))));

        Registry.register(Registries.BLOCK, RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CheapappleTheRock.MOD_ID, "amp")), AMP);
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "amp")),
                new BlockItem(AMP, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "amp")))));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.add(BOCCHI_ROCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(BLOCK_OF_PICKS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
            content.add(AMP);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.add(AMP);
        });
    }
}
