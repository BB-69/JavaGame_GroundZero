package game;

import game.util.Time;

public class GameLoop implements Runnable {

  private Thread thread;
  private boolean running;

  private GamePanel panel;

  private float accumulator = 0f;

  public GameLoop(GamePanel panel) {
    this.panel = panel;
  }

  public void start() {
    if (running)
      return;
    running = true;
    Time.init();
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    while (running) {

      float frameTime = Time.update();
      if (frameTime > 0.25f)
        frameTime = 0.25f; // safety clamp

      accumulator += frameTime;

      // FIXED UPDATE
      while (accumulator >= Time.FIXED_DELTA) {
        Engine.fixedUpdate();
        accumulator -= Time.FIXED_DELTA;
      }

      // VARIABLE UPDATE
      Engine.update();
      panel.repaint();
    }
  }
}
