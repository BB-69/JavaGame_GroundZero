package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import game.core.GameState;
import game.entities.Entity;
import game.entities.Player;
import game.util.Time;

public class PlayState extends GameState {

  private static ArrayList<Entity> entities = new ArrayList<>();

  public PlayState() {
    entities.add(new Player(0, 0));
  }

  public void fixedUpdate() {
    for (Entity e : entities) {
      e.fixedUpdate();
    }
  }

  public void update() {
    for (Entity e : entities) {
      e.update();
    }
  }

  public void render(Graphics2D g, float alpha) {
    for (Entity e : entities) {
      e.render(g, alpha);
    }

    g.setFont(new Font("Arial", Font.BOLD, 24));
    g.setColor(Color.WHITE);

    g.drawString(String.format("%.2f FPS", Math.clamp(1 / Time.deltaTime, 0, 67.67)), 10, 35);
  }
}
