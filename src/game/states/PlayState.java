package game.states;

import java.awt.Graphics2D;
import java.util.HashSet;

import game.core.GameState;
import game.entities.Entity;
import game.entities.Player;

public class PlayState extends GameState {

  private static HashSet<Entity> entities = new HashSet<>();

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

  public void render(Graphics2D g) {
    for (Entity e : entities) {
      e.render(g);
    }
  }

}
