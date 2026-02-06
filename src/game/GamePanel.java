package game;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel {

  public static final int WIDTH = 800;
  public static final int HEIGHT = 600;

  private GameLoop loop;

  public GamePanel() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    requestFocus();

    loop = new GameLoop(this);
  }

  public void start() {
    loop.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.BLACK);
    g2.fillRect(0, 0, WIDTH, HEIGHT);

    Engine.render(g2);

    g2.dispose();
  }
}
