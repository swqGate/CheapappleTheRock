package cheapapple.cheap_the_rock.block;

import net.minecraft.util.StringIdentifiable;

public enum EightDirection implements StringIdentifiable {
    NORTH("north"),
    NORTH_EAST("north_east"),
    EAST("east"),
    SOUTH_EAST("south_east"),
    SOUTH("south"),
    SOUTH_WEST("south_west"),
    WEST("west"),
    NORTH_WEST("north_west");

    private final String name;

    EightDirection(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
