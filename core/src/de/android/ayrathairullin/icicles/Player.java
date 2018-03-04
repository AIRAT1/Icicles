package de.android.ayrathairullin.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player {
    public static final String TAG = Player.class.getName();

    private Vector2 position;
    private Viewport viewport;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(viewport.getWorldWidth() / 2, Constants.PLAYER_HEAD_HEIGHT);
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PLAYER_COLOR);
        renderer.set(ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_HEAD_SEGMENTS);
        Vector2 torsoTop = new Vector2(position.x, position.y - Constants.PLAYER_HEAD_RADIUS);
        Vector2 torsoBottom = new Vector2(torsoTop.x, torsoTop.y - 2 * Constants.PLAYER_HEAD_RADIUS);

        renderer.rectLine(torsoTop, torsoBottom, Constants.PLAYER_LIMB_WIDTH);
        renderer.rectLine(torsoTop.x, torsoTop.y,
                torsoTop.x + Constants.PLAYER_HEAD_RADIUS,
                torsoTop.y - Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_LIMB_WIDTH);
        renderer.rectLine(torsoTop.x, torsoTop.y,
                torsoTop.x - Constants.PLAYER_HEAD_RADIUS,
                torsoTop.y - Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_LIMB_WIDTH);
        renderer.rectLine(torsoBottom.x, torsoBottom.y,
                torsoBottom.x + Constants.PLAYER_HEAD_RADIUS,
                torsoBottom.y - Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_LIMB_WIDTH);
        renderer.rectLine(torsoBottom.x, torsoBottom.y,
                torsoBottom.x - Constants.PLAYER_HEAD_RADIUS,
                torsoBottom.y - Constants.PLAYER_HEAD_RADIUS, Constants.PLAYER_LIMB_WIDTH);
    }
}
