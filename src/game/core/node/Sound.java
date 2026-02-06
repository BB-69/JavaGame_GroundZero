package game.core.node;

import javax.sound.sampled.*;

import game.core.AssetManager;

public class Sound {

  private Clip clip;

  public Sound(String name) {
    clip = AssetManager.getSound(name);
  }

  // === BASIC PLAY ===
  public void play() {
    playAt(0f);
  }

  // === PLAY AT TIME (seconds) ===
  public void playAt(float seconds) {
    if (seconds < 0f)
      seconds = 0f;

    clip.stop();

    int frame = (int) (seconds * clip.getFormat().getFrameRate());
    frame = Math.min(frame, clip.getFrameLength());

    clip.setFramePosition(frame);
    clip.start();
  }

  // === CONTROL ===
  public void stop() {
    pause();
    clip.start();
  }

  public void pause() {
    clip.stop();
  }

  public void resume() {
    clip.start();
  }

  public void loop() {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void setVolume(float db) {
    FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    vc.setValue(db);
  }
}
