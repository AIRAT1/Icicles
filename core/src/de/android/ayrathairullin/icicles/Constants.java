package de.android.ayrathairullin.icicles;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final float WORLD_SIZE = 10f;
    public static final Color BACKGROUND_COLOR = Color.BLUE;
    public static final float PLAYER_HEAD_RADIUS = .5f;
    public static final float PLAYER_HEAD_HEIGHT = 4f * PLAYER_HEAD_RADIUS;
    public static final float PLAYER_LIMB_WIDTH = .1f;
    public static final int PLAYER_HEAD_SEGMENTS = 20;
    public static final Color PLAYER_COLOR = Color.BLACK;
    public static final float ICICLES_HEIGHT = 1f;
    public static final float ICICLES_WIDTH = .5f;
    public static final Color ICICLE_COLOR = Color.WHITE;
    public static final float PLAYER_MOVEMENT_SPEED = 10f;
    public static final float ACCELEROMETER_SENSITIVITY = .5f;
    public static final float GRAVITATIONAL_ACCELERATION = 9.81f;
    public static final Vector2 ICICLES_ACCELERATION = new Vector2(0, -5);
    public static final float ICICLE_SPAWNS_PER_SECOND = 10;
    public static final float HUD_FONT_REFERENCE_SCREEN_SIZE = 480;
    public static final float HUD_MARGIN = 20;
}
