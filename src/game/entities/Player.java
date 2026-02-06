package game.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.input.KeyInput;
import game.util.Time;

public class Player extends Entity {

  private float speed = 360f;

  public Player(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void update() {

    float dx = (KeyInput.isDown(KeyEvent.VK_A) ? -1 : 0) + (KeyInput.isDown(KeyEvent.VK_D) ? 1 : 0);
    float dy = (KeyInput.isDown(KeyEvent.VK_W) ? -1 : 0) + (KeyInput.isDown(KeyEvent.VK_S) ? 1 : 0);

    if (dx != 0 && dy != 0) {
      float len = (float) Math.sqrt(dx * dx + dy * dy);
      dx /= len;
      dy /= len;
    }
    vx = speed * dx;
    vy = speed * dy;
  }

  @Override
  public void fixedUpdate() {
    super.fixedUpdate();

    x += vx * Time.FIXED_DELTA;
    y += vy * Time.FIXED_DELTA;
  }

  @Override
  public void render(Graphics2D g, float alpha) {
    float renderX = lerp(prevX, x, alpha);
    float renderY = lerp(prevY, y, alpha);

    g.setColor(Color.WHITE);
    g.fillRect((int) renderX, (int) renderY, 32, 32);
  }
}
