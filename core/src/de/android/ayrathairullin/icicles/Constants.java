package de.android.ayrathairullin.icicles;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Constants {
    public static final float WORLD_SIZE = 10f;
    public static final Color BACKGROUND_COLOR = Color.BLUE;
    static final float PLAYER_HEAD_RADIUS = .5f;
    static final float PLAYER_HEAD_HEIGHT = 4f * PLAYER_HEAD_RADIUS;
    static final float PLAYER_LIMB_WIDTH = .1f;
    static final int PLAYER_HEAD_SEGMENTS = 20;
    static final Color PLAYER_COLOR = Color.BLACK;
    static final float ICICLES_HEIGHT = 1f;
    static final float ICICLES_WIDTH = .5f;
    static final Color ICICLE_COLOR = Color.WHITE;
    static final float PLAYER_MOVEMENT_SPEED = 10f;
    static final float ACCELEROMETER_SENSITIVITY = .5f;
    static final float GRAVITATIONAL_ACCELERATION = 9.81f;
    static final Vector2 ICICLES_ACCELERATION = new Vector2(0, -5);
    public static final float HUD_FONT_REFERENCE_SCREEN_SIZE = 480;
    public static final float HUD_MARGIN = 20;

    public static final String EASY_LABEL = "Cold";
    public static final String MEDIUM_LABEL = "Colder";
    public static final String HARD_LABEL = "Coldest";

    static final float EASY_SPAWNS_PER_SECOND = 5;
    static final float MEDIUM_SPAWNS_PER_SECOND = 15;
    static final float HARD_SPAWNS_PER_SECOND = 25;

    public static final Color EASY_COLOR = new Color(0.2f, 0.2f, 1, 1);
    public static final Color MEDIUM_COLOR = new Color(0.5f, 0.5f, 1, 1);
    public static final Color HARD_COLOR = new Color(0.7f, 0.7f, 1, 1);

    public static final float DIFFICULTY_WORLD_SIZE = 480.0f;

    public static final float DIFFICULTY_BUBBLE_RADIUS = DIFFICULTY_WORLD_SIZE / 9;

    public static final float DIFFICULTY_LABEL_SCALE = 1.5f;

    public static final Vector2 EASY_CENTER = new Vector2(DIFFICULTY_WORLD_SIZE / 4, DIFFICULTY_WORLD_SIZE / 2);
    public static final Vector2 MEDIUM_CENTER = new Vector2(DIFFICULTY_WORLD_SIZE / 2, DIFFICULTY_WORLD_SIZE / 2);
    public static final Vector2 HARD_CENTER = new Vector2(DIFFICULTY_WORLD_SIZE * 3 / 4, DIFFICULTY_WORLD_SIZE / 2);

    public enum Difficulty {
        EASY(EASY_SPAWNS_PER_SECOND, EASY_LABEL),
        MEDIUM(MEDIUM_SPAWNS_PER_SECOND, MEDIUM_LABEL),
        HARD(HARD_SPAWNS_PER_SECOND, HARD_LABEL);

        float spawnRate;
        public String label;

        Difficulty(float spawnRate, String label) {
            this.spawnRate = spawnRate;
            this.label = label;
        }
    }
}
