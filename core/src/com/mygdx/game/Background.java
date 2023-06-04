package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Background {

    class BGPicture{
        private Texture ty;
        private Vector2 pos;
        public BGPicture(Vector2 pos){
            ty = new Texture("back.jpg");
            this.pos = pos;
        }
    }
    private int speed;
    private BGPicture[] backs;
    public Background(){
        speed = 20;
        backs = new BGPicture[2];
        backs[0] = new BGPicture(new Vector2(0,0));
        backs[1] = new BGPicture(new Vector2(0,1200));
    }

    public void render(SpriteBatch batch){
        for (BGPicture back : backs) {
            batch.draw(back.ty, back.pos.x, back.pos.y);
        }
    }

    public void update(){
        for (BGPicture back : backs) {
            back.pos.y -= speed;
        }

        if(backs[0].pos.y < -1200){
            backs[0].pos.y = 0;
            backs[1].pos.y = 1200;
        }
    }
}

