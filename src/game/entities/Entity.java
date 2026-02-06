package game.entities;

import java.awt.Graphics2D;

public abstract class Entity {

  protected float x, y;
  protected float prevX, prevY;
  protected float vx, vy;

  public abstract void update(); // input, animation

  public void fixedUpdate() {
    prevX = x;
    prevY = y;
  } // physics

  public abstract void render(Graphics2D g, float alpha);

  protected float lerp(float a, float b, float t) {
    return a + (b - a) * t;
  }
}
