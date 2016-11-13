package com.parkproject.parkit;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.parkproject.parkit.control.BetterSkinLoader;
import com.parkproject.parkit.states.GameStateManager;
import com.parkproject.parkit.states.SplashState;

public class ParkIt extends ApplicationAdapter {
	GameStateManager gsm;
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	AssetManager assetManager;


	public GameCallback callback;
	public ParkIt(GameCallback callback){
		this.callback = callback;
	}
	@Override
	public void create () {

		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		assetManager = new AssetManager();
		gsm = new GameStateManager();
		assetManager.setLoader(Skin.class, new BetterSkinLoader(assetManager.getFileHandleResolver()));
		loadAssets();
		gsm.push(new SplashState(gsm, assetManager,this));
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);


	}

	private void loadAssets() {
		assetManager.load("park_it_atlas.atlas", TextureAtlas.class);
		assetManager.load("skin.json",Skin.class, new BetterSkinLoader.SkinParameter("park_it_atlas.atlas"));
		assetManager.finishLoading();

	}

	@Override
	public void render () {
		gsm.handleInput();
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch, shapeRenderer);

	}

	public static float calculateHeight(float changedWidth, Actor actor, TextureRegion texture){

		if(texture == null){
			return actor.getHeight() * changedWidth /actor.getWidth();
		}

		return texture.getRegionHeight() * actor.getWidth() / texture.getRegionWidth();
	}

}
