package com.bwbjustin.colorblocks;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class CSSColors {
    private CSSColors() {}
    
    private static final TreeMap<String, Integer> COLORS = new TreeMap<>();
    
    static {
        put("Alice Blue", 0xF0F8FF);
        put("Antique White", 0xFAEBD7);
        put("Aquamarine", 0x7FFFD4);
        put("Azure", 0xF0FFFF);
        put("Beige", 0xF5F5DC);
        put("Bisque", 0xFFE4C4);
        put("Black", 0x000000);
        put("Blanched Almond", 0xFFEBCD);
        put("Blue", 0x0000FF);
        put("Blue Violet", 0x8A2BE2);
        put("Brown", 0xA52A2A);
        put("Burlywood", 0xDEB887);
        put("Cadet Blue", 0x5F9EA0);
        put("Chartreuse", 0x7FFF00);
        put("Chocolate", 0xD2691E);
        put("Coral", 0xFF7F50);
        put("Cornflower Blue", 0x6495ED);
        put("Cornsilk", 0xFFF8DC);
        put("Crimson", 0xDC143C);
        put("Cyan", 0x00FFFF);
        put("Dark Blue", 0x00008B);
        put("Dark Cyan", 0x008B8B);
        put("Dark Goldenrod", 0xB8860B);
        put("Dark Gray", 0xA9A9A9);
        put("Dark Green", 0x006400);
        put("Dark Khaki", 0xBDB76B);
        put("Dark Magenta", 0x8B008B);
        put("Dark Olive Green", 0x556B2F);
        put("Dark Orange", 0xFF8C00);
        put("Dark Orchid", 0x9932CC);
        put("Dark Red", 0x8B0000);
        put("Dark Salmon", 0xE9967A);
        put("Dark Sea Green", 0x8FBC8F);
        put("Dark Slate Blue", 0x483D8B);
        put("Dark Slate Gray", 0x2F4F4F);
        put("Dark Turquoise", 0x00CED1);
        put("Dark Violet", 0x9400D3);
        put("Deep Pink", 0xFF1493);
        put("Deep Sky Blue", 0x00BFFF);
        put("Dim Gray", 0x696969);
        put("Dodger Blue", 0x1E90FF);
        put("Firebrick", 0xB22222);
        put("Floral White", 0xFFFAF0);
        put("Forest Green", 0x228B22);
        put("Gainsboro", 0xDCDCDC);
        put("Ghost White", 0xF8F8FF);
        put("Gold", 0xFFD700);
        put("Goldenrod", 0xDAA520);
        put("Gray", 0x808080);
        put("Green", 0x008000);
        put("Green Yellow", 0xADFF2F);
        put("Honeydew", 0xF0FFF0);
        put("Hot Pink", 0xFF69B4);
        put("Indian Red", 0xCD5C5C);
        put("Indigo", 0x4B0082);
        put("Ivory", 0xFFFFF0);
        put("Khaki", 0xF0E68C);
        put("Lavender", 0xE6E6FA);
        put("Lavender Blush", 0xFFF0F5);
        put("Lawn Green", 0x7CFC00);
        put("Lemon Chiffon", 0xFFFACD);
        put("Light Blue", 0xADD8E6);
        put("Light Coral", 0xF08080);
        put("Light Cyan", 0xE0FFFF);
        put("Light Goldenrod Yellow", 0xFAFAD2);
        put("Light Gray", 0xD3D3D3);
        put("Light Green", 0x90EE90);
        put("Light Pink", 0xFFB6C1);
        put("Light Salmon", 0xFFA07A);
        put("Light Sea Green", 0x20B2AA);
        put("Light Sky Blue", 0x87CEFA);
        put("Light Slate Gray", 0x778899);
        put("Light Steel Blue", 0xB0C4DE);
        put("Light Yellow", 0xFFFFE0);
        put("Lime", 0x00FF00);
        put("Lime Green", 0x32CD32);
        put("Linen", 0xFAF0E6);
        put("Magenta", 0xFF00FF);
        put("Maroon", 0x800000);
        put("Medium Aquamarine", 0x66CDAA);
        put("Medium Blue", 0x0000CD);
        put("Medium Orchid", 0xBA55D3);
        put("Medium Purple", 0x9370DB);
        put("Medium Sea Green", 0x3CB371);
        put("Medium Slate Blue", 0x7B68EE);
        put("Medium Spring Green", 0x00FA9A);
        put("Medium Turquoise", 0x48D1CC);
        put("Medium Violet Red", 0xC71585);
        put("Midnight Blue", 0x191970);
        put("Mint Cream", 0xF5FFFA);
        put("Misty Rose", 0xFFE4E1);
        put("Moccasin", 0xFFE4B5);
        put("Navajo White", 0xFFDEAD);
        put("Navy", 0x000080);
        put("Old Lace", 0xFDF5E6);
        put("Olive", 0x808000);
        put("Olive Drab", 0x6B8E23);
        put("Orange", 0xFFA500);
        put("Orange Red", 0xFF4500);
        put("Orchid", 0xDA70D6);
        put("Pale Goldenrod", 0xEEE8AA);
        put("Pale Green", 0x98FB98);
        put("Pale Turquoise", 0xAFEEEE);
        put("Pale Violet Red", 0xDB7093);
        put("Papaya Whip", 0xFFEFD5);
        put("Peach Puff", 0xFFDAB9);
        put("Peru", 0xCD853F);
        put("Pink", 0xFFC0CB);
        put("Plum", 0xDDA0DD);
        put("Powder Blue", 0xB0E0E6);
        put("Purple", 0x800080);
        put("Rebecca Purple", 0x663399);
        put("Red", 0xFF0000);
        put("Rosy Brown", 0xBC8F8F);
        put("Royal Blue", 0x4169E1);
        put("Saddle Brown", 0x8B4513);
        put("Salmon", 0xFA8072);
        put("Sandy Brown", 0xF4A460);
        put("Sea Green", 0x2E8B57);
        put("Seashell", 0xFFF5EE);
        put("Sienna", 0xA0522D);
        put("Silver", 0xC0C0C0);
        put("Sky Blue", 0x87CEEB);
        put("Slate Blue", 0x6A5ACD);
        put("Slate Gray", 0x708090);
        put("Snow", 0xFFFAFA);
        put("Spring Green", 0x00FF7F);
        put("Steel Blue", 0x4682B4);
        put("Tan", 0xD2B48C);
        put("Teal", 0x008080);
        put("Thistle", 0xD8BFD8);
        put("Tomato", 0xFF6347);
        put("Turquoise", 0x40E0D0);
        put("Violet", 0xEE82EE);
        put("Wheat", 0xF5DEB3);
        put("White", 0xFFFFFF);
        put("White Smoke", 0xF5F5F5);
        put("Yellow", 0xFFFF00);
        put("Yellow Green", 0x9ACD32);
    }
    
    public static int get(String key) {
        return COLORS.get(key);
    }
    
    public static void put(String key, int value) {
        COLORS.put(key, value);
    }
    
    public static void forEach(BiConsumer<String, Integer> action) {
        for (Map.Entry<String, Integer> entry : COLORS.entrySet())
            action.accept(entry.getKey(), entry.getValue());
    }
}
