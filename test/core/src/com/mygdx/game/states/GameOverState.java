package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.PlatformerGame;

/**
 * Game over game state
 */
public class GameOverState extends AbstractState {
    private Texture backgroundImg;
    private Texture gameOverImg;
    private BitmapFont font;
    private int counter;

    /**
     * Constructor
     *
     * @param gsm Game State Manager for managed game states
     */
    public GameOverState(GameStateManager gsm, int counter) {
        super(gsm);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, PlatformerGame.WIDTH, PlatformerGame.HEIGHT);
        backgroundImg = new Texture("sky.png");
        gameOverImg = new Texture("gameover.png");
        font = new BitmapFont();
        this.counter = counter;
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        // Draw background image
        batch.draw(backgroundImg, 0, 0);
        // Draw game over image
        batch.draw(gameOverImg, PlatformerGame.WIDTH / 2 - gameOverImg.getWidth() / 2, PlatformerGame.HEIGHT / 2 - gameOverImg.getHeight() / 2);
        // Draw text
        font.draw(batch,"Catch " + counter + " stars!", PlatformerGame.WIDTH/2 - 30, PlatformerGame.HEIGHT/2 - 50);
        batch.end();
    }

    @Override
    public void dispose() {
        backgroundImg.dispose();
        gameOverImg.dispose();
    }
}
