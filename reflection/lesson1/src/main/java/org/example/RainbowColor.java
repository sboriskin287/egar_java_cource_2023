package org.example;

public enum RainbowColor {
    //Color end string, color reset
    RESET("\033[0m"),

    // Regular Colors. Normal color, no bold, background color etc.
    RED("\033[0;31m"),      // RED
    GREEN("\033[0;32m"),    // GREEN
    YELLOW("\033[0;33m"),   // YELLOW
    BLUE("\033[0;34m"),     // BLUE
    MAGENTA("\033[0;35m"),  // MAGENTA
    CYAN("\033[0;36m");    // CYAN


    private final String code;

    RainbowColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
