package cheapapple.cheap_the_rock.init;

import cheapapple.cheap_the_rock.CheapappleTheRock;
import cheapapple.cheap_the_rock.entity.BocchiRockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntityTypes {
    public static EntityType<BocchiRockEntity> BOCCHI_ROCK;

    public static void init() {
        BOCCHI_ROCK = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(CheapappleTheRock.MOD_ID, "bocchi_rock"),
                EntityType.Builder.<BocchiRockEntity>create(BocchiRockEntity::new, SpawnGroup.MISC)
                        .dropsNothing()
                        .dimensions(0.25F, 0.25F)
                        .maxTrackingRange(4)
                        .trackingTickInterval(10)
                        .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(CheapappleTheRock.MOD_ID, "bocchi_rock")))
        );
    }
}
