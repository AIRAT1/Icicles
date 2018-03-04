package de.android.ayrathairullin.icicles.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import de.android.ayrathairullin.icicles.Constants;
import de.android.ayrathairullin.icicles.Icicles;
import de.android.ayrathairullin.icicles.Player;

public class IciclesScreen implements Screen{
    public static final String TAG = IciclesScreen.class.getName();
    private ExtendViewport iciclesViewport;
    private ScreenViewport hudViewport;
    private SpriteBatch batch;
    private BitmapFont font;
    private ShapeRenderer renderer;
    private Player player;
    private Icicles icicles;
    private int topScore;

    @Override
    public void show() {
        iciclesViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        hudViewport = new ScreenViewport();
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        icicles = new Icicles(iciclesViewport);
        player = new Player(iciclesViewport);
        topScore = 0;
    }

    @Override
    public void resize(int width, int height) {
        iciclesViewport.update(width, height, true);
        hudViewport.update(width, height, true);
        font.getData().setScale(Math.min(width, height) / Constants.HUD_FONT_REFERENCE_SCREEN_SIZE);
        player.init();
        icicles.init();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render(float delta) {
        icicles.update(delta);
        player.update(delta);
        if (player.hitByIcicle(icicles)) {
            icicles.init();
        }
        iciclesViewport.apply(true);
        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setProjectionMatrix(iciclesViewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);
        icicles.render(renderer);
        player.render(renderer);
        renderer.end();

        topScore = Math.max(topScore, icicles.iciclesDodged);
        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "Deaths: " + player.deaths,
                Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN);
        font.draw(batch, "Score: " + icicles.iciclesDodged + "\nTop Score: " + topScore,
                hudViewport.getWorldWidth() - Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN,
                0, Align.right, false);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }
}
