package com.qualcomm.ftcrobotcontroller.opmodes;

/**
	The colors for each alliance.
*/


public enum AllianceColor {
    BLUE(180, 240), //hue ranges
    RED(0, 60);

    public final int min, max;

    AllianceColor(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMinHue()
    {
        return min;
    }

    public int getMaxHue()
    {
        return max;
    }
}