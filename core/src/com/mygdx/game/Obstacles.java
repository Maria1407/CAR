package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair {
        Vector2 position;
        float speed;
        int offset;
        Rectangle emptySpace;

        public WallPair(Vector2 pos) {
            position = pos;
            speed = 20;
            offset = new Random().nextInt(500);
            emptySpace = new Rectangle(position.x, position.y, offset,50);
        }

        public void update() {
            position.y -= speed;
            if (position.y < 0) {
                position.y = 3000;
                offset = new Random().nextInt(150);
            }
            emptySpace.y = position.y;
        }
    }

    static WallPair[] obs;
    Texture txt;
    int betweenDistance;
    public Obstacles(){
        txt = new Texture("wall.jpg");
        obs = new WallPair[4];
        int startPosY=3000;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(new Random().nextInt(500),startPosY));
            startPosY += new Random().nextInt(300)+600;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < obs.length; i++) {
            batch.draw(txt, obs[i].position.x, obs[i].position.y);
        }
    }

    public void update(){
        for (int i = 0; i < obs.length; i++) obs[i].update();
    }

    public void recreate(){
        int startPosY=3000;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(new Random().nextInt(500),startPosY));
            startPosY += new Random().nextInt(300)+600;
        }
    }
}