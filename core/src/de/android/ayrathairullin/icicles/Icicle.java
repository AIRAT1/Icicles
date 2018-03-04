package de.android.ayrathairullin.icicles;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class Icicle {
    public static final String TAG = Icicle.class.getName();

    private Vector2 position;

    public Icicle(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.ICICLE_COLOR);
        renderer.set(ShapeType.Filled);
        renderer.triangle(position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT / 2,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT / 2);
    }
}
