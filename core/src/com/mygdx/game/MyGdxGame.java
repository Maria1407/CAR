package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Window;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Car car;
	Obstacles obstacles;
	boolean gameOver;
	Texture restartTexture;
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		car = new Car();
		obstacles = new Obstacles();
		gameOver = false;
		restartTexture = new Texture("Restart.jpg");
	}
	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		obstacles.render(batch);
		if(!gameOver) {
			car.render(batch);
		}
		else{
			batch.draw(restartTexture, 200, 200);
		}
		batch.end();
	}

	public void update(){
		bg.update();
		car.update();
		obstacles.update();
//		for (int i = 0; i < Obstacles.obs.length; i++) {
//			if(car.position.y > Obstacles.obs[i].position.y && car.position.y < Obstacles.obs[i].position.y+50){
//				if(!Obstacles.obs[i].emptySpace.contains(car.position)){
//					gameOver = true;
//				}
//			}
//		}
//		if(Gdx.input.isTouched() && gameOver){
//			recreate();
//		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	public void recreate(){
		car.recreate();
		obstacles.recreate();
		gameOver = false;
	}
}
