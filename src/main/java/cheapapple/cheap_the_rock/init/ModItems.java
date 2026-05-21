package cheapapple.cheap_the_rock.init;

import cheapapple.cheap_the_rock.CheapappleTheRock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item PICK = new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "pick")))
    );

    public static void init() {
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CheapappleTheRock.MOD_ID, "pick")), PICK);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(PICK);
        });
    }
}
