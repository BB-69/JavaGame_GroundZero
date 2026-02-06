package game.util;

public final class Time {

    public static float deltaTime;
    public static final float FIXED_DELTA = 1f / 60f;

    private static long lastTime;

    private Time() {
    }

    public static void init() {
        lastTime = System.nanoTime();
    }

    public static float update() {
        long now = System.nanoTime();
        deltaTime = (now - lastTime) / 1_000_000_000f;
        lastTime = now;
        return deltaTime;
    }
}
