package de.android.ayrathairullin.icicles;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.android.ayrathairullin.icicles.Constants.Difficulty;

public class Icicles {
    Difficulty difficulty;

    public int iciclesDodged;
    DelayedRemovalArray<Icicle> icicleList;
    private Viewport viewport;

    public Icicles(Viewport viewport, Difficulty difficulty) {
        this.difficulty = difficulty;
        this.viewport = viewport;
        init();
    }

    public void init() {
        icicleList = new DelayedRemovalArray<Icicle>(false, 100);
        iciclesDodged = 0;
    }

    public void update(float delta) {
        if (MathUtils.random() < delta * difficulty.spawnRate) {
            Vector2 newIciclePosition = new Vector2(
                    MathUtils.random() * viewport.getWorldWidth(),
                    viewport.getWorldHeight()
            );
            Icicle newIcicle = new Icicle(newIciclePosition);
            icicleList.add(newIcicle);
        }
        for (Icicle icicle : icicleList) {
            icicle.update(delta);
        }
        icicleList.begin();
        for (int i = 0; i < icicleList.size; i++) {
            if (icicleList.get(i).position.y < - Constants.ICICLES_HEIGHT) {
                iciclesDodged ++;
                icicleList.removeIndex(i);
            }
        }
        icicleList.end();
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.ICICLE_COLOR);
        for (Icicle icicle : icicleList) {
            icicle.render(renderer);
        }
    }
}
