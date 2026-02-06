package game.entities;

import java.awt.Graphics2D;

public abstract class Entity {

  protected float x, y;
  protected float vx, vy;

  public abstract void fixedUpdate(); // physics

  public abstract void update(); // input, animation

  public abstract void render(Graphics2D g);
}
