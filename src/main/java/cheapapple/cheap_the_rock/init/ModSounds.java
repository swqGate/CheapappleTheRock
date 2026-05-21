package cheapapple.cheap_the_rock.init;

import cheapapple.cheap_the_rock.CheapappleTheRock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DISTORTION_GUITAR = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "distortion_guitar"));
    public static final SoundEvent ELECTRIC_GUITAR = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "electric_guitar"));

    public static final SoundEvent SKULL_GUITAR = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "skull_guitar"));
    public static final SoundEvent SANS_SYNTH = SoundEvent.of(Identifier.of(CheapappleTheRock.MOD_ID, "sans_synth"));

    public static void init() {
        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "distortion_guitar"), DISTORTION_GUITAR);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "electric_guitar"), ELECTRIC_GUITAR);

        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "skull_guitar"), SKULL_GUITAR);
        Registry.register(Registries.SOUND_EVENT, Identifier.of(CheapappleTheRock.MOD_ID, "sans_synth"), SANS_SYNTH);
    }
}
