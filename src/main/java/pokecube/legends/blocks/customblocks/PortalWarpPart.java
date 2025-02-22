package pokecube.legends.blocks.customblocks;

import net.minecraft.util.StringRepresentable;

public enum PortalWarpPart implements StringRepresentable
{
    //@formatter:off
    TOP("top"),
    TOP_LEFT("top_left"),
    TOP_RIGHT("top_right"),
    MIDDLE("middle"),
    MIDDLE_LEFT("middle_left"),
    MIDDLE_RIGHT("middle_right"),
    BOTTOM("bottom"),
    BOTTOM_LEFT("bottom_left"),
    BOTTOM_RIGHT("bottom_right");
    //@formatter:on

    private final String name;

    PortalWarpPart(final String name)
    {
        this.name = name;
    }

    @Override
    public String getSerializedName()
    {
        return this.name;
    }
}