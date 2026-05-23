package cheapapple.cheap_the_rock.init;

import cheapapple.cheap_the_rock.CheapappleTheRock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DISTORTION_GUITAR = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.distortion_guitar"));
    public static final SoundEvent ELECTRIC_GUITAR = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.electric_guitar"));

    public static final SoundEvent SKULL_GUITAR = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.skull_guitar"));
    public static final SoundEvent SANS_SYNTH = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.sans_synth"));

    public static final SoundEvent ENTITY_ROCK_THROW = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "entity.rock.throw"));

    public static void init() {
        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.distortion_guitar"), DISTORTION_GUITAR);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.electric_guitar"), ELECTRIC_GUITAR);

        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.skull_guitar"), SKULL_GUITAR);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "block.note_block.sans_synth"), SANS_SYNTH);

        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "entity.rock.throw"), ENTITY_ROCK_THROW);
    }
}
