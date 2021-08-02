package org.example.problems.experiments;

import java.awt.Color;

enum Status
{
    OFF ("Off"),
    TRAINING ("Training", new Color(255, 191, 128)),
    BEGINNER ("Beginner", new Color(128, 255, 138)),
    INTERMEDIATE ("Intermediate", new Color(128, 212, 255)),
    ADVANCED ("Advanced", new Color(255, 128, 128));
    public static final Color defaultColor = Color.WHITE;

    public final String name;
    public final Color color;


    static Color getDefault() {
        return defaultColor;
    }

    Status(String name)
    {
        this(name, getDefault());
    }
    Status(String name, Color color)
    {
        this.name = name;
        this.color = color;
    }
}