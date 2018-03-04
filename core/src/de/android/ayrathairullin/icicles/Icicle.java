package de.android.ayrathairullin.icicles;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

class Icicle {
    Vector2 position;
    private Vector2 velocity;

    Icicle(Vector2 position) {
        this.position = position;
        this.velocity = new Vector2();
    }

    void update(float delta) {
        velocity.mulAdd(Constants.ICICLES_ACCELERATION, delta);
        position.mulAdd(velocity, delta);
    }

    void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.ICICLE_COLOR);
        renderer.set(ShapeType.Filled);
        renderer.triangle(position.x, position.y,
                position.x - Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT / 2,
                position.x + Constants.ICICLES_WIDTH / 2, position.y + Constants.ICICLES_HEIGHT / 2);
    }
}
