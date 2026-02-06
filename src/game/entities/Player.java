package game.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.input.KeyInput;
import game.util.Time;

public class Player extends Entity {

  private float speed = 360f;
  private static final float DIAGONAL_MULTIPLIER = (float) Math.cos(Math.PI / 4);

  public Player(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void update() {

    vx = 0;
    vy = 0;

    int dx = (KeyInput.isDown(KeyEvent.VK_A) ? -1 : 0) + (KeyInput.isDown(KeyEvent.VK_D) ? 1 : 0);
    int dy = (KeyInput.isDown(KeyEvent.VK_W) ? -1 : 0) + (KeyInput.isDown(KeyEvent.VK_S) ? 1 : 0);

    if (dx != 0 && dy != 0) {
      vx += speed * dx * DIAGONAL_MULTIPLIER;
      vy += speed * dy * DIAGONAL_MULTIPLIER;
    } else {
      vx += speed * dx;
      vy += speed * dy;
    }
  }

  @Override
  public void fixedUpdate() {
    x += vx * Time.FIXED_DELTA;
    y += vy * Time.FIXED_DELTA;
  }

  @Override
  public void render(Graphics2D g) {
    g.setColor(Color.WHITE);
    g.fillRect((int) x, (int) y, 32, 32);
  }
}
