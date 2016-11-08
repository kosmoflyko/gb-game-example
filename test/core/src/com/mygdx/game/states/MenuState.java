package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.PlatformerGame;

/**
 * Main menu game state
 */
public class MenuState extends AbstractState {
    private Texture backgroundImg;
    private Texture btnPlay;
    private BitmapFont font;

    /**
     * Constructor
     *
     * @param gsm Game State Manager for managed game states
     */
    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, PlatformerGame.WIDTH, PlatformerGame.HEIGHT);
        backgroundImg = new Texture("sky.png");
        btnPlay = new Texture("playbtn.png");
        font = new BitmapFont(); // by default use Arial without support cyrillic symbols
    }

    /**
     * Handle touch for run game
     */
    private void handleInput(){
        if (Gdx.input.isTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        // Draw background image
        batch.draw(backgroundImg, 0, 0);
        // Draw text
        font.draw(batch,"Touch for play", PlatformerGame.WIDTH/2 - 50, PlatformerGame.HEIGHT/2 + 50);
        // Draw button for run game
        batch.draw(btnPlay, PlatformerGame.WIDTH / 2 - btnPlay.getWidth() / 2, PlatformerGame.HEIGHT / 2 - btnPlay.getHeight() / 2);
        batch.end();
    }

    @Override
    public void dispose() {
        backgroundImg.dispose();
        btnPlay.dispose();
        font.dispose();
    }
}
