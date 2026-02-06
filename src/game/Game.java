package game;

import game.core.StateManager;
import game.states.PlayState;
import game.input.KeyInput;
import game.input.MouseInput;

public final class Game {

  public static void init(GamePanel panel) {
    KeyInput.init(panel);
    MouseInput.init(panel);

    StateManager.setState(new PlayState());
  }
}
