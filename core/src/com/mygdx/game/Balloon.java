package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

/**
 * @author Andrew
 */

public class Balloon extends BaseActor{

    public float speed;
    public float amplitude;
    public float oscillation;
    public float initialY;
    public float time;
    public float offsetX;

    public Balloon() {
        speed = 80 * MathUtils.random(0.5f, 2.0f);
        amplitude = 50 * MathUtils.random(0.5f, 2.0f);
        oscillation = 0.01f * MathUtils.random(0.5f, 2.0f);
        initialY = 120 * MathUtils.random(0.5f, 2.0f);
        time = 0;
        offsetX = -100;
        setTexture( new Texture(Gdx.files.internal("assets/red-balloon.png")));

        // Initial spawn location off-screen
        setX(offsetX);
    }

    public void act(float dt) {
        super.act(dt);
        time += dt;

        // Set starting location to left of window
        float xPos = speed * time + offsetX;
        float yPos = amplitude * MathUtils.sin(oscillation * xPos) + initialY;
        setPosition(xPos, yPos);
    }
}
