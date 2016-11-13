package com.parkproject.parkit.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.parkproject.parkit.GameCallback;
import com.parkproject.parkit.ParkIt;


/**
 * Created by WhiteHope on 03.06.2016.
 */
public class SplashState extends State {

    private float splashDuration = 2;
    Image background;
    RunnableAction runnableAction;
    Table table;
    public SplashState(GameStateManager gsm, AssetManager assetManager, final ParkIt parkIt) {
        super(gsm, assetManager, parkIt);

        runnableAction = new RunnableAction(){
            @Override
            public void run() {
                parkIt.callback.startActivity();
            }
        };
        table = new Table(assetManager.get("skin.json",Skin.class));
        table.setBounds(0,0,cam.viewportWidth,cam.viewportHeight);
        table.add("park it"+".").getActor().addAction(Actions.sequence(Actions.alpha(0),Actions.alpha(1,splashDuration),Actions.alpha(0,splashDuration),runnableAction));
        background = new Image(new TextureRegion(new Texture("background.png")));
        background.setSize(cam.viewportWidth,cam.viewportHeight);

        stage.addActor(background);
        stage.addActor(table);
    }


    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(SpriteBatch batch, ShapeRenderer shapeRenderer) {
        batch.getColor().set(Color.WHITE);
        stage.draw();

    }

    @Override
    protected void handleInput() {


    }



    @Override
    public void dispose() {
        stage.dispose();

    }


    private void initAnimations(Array<Image> actors) {

        }
    }

