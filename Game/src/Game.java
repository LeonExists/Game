public class Game {
    public static void sleep(final int millis)
    {
        try { 
            Thread.sleep(millis);
        }
        catch (final InterruptedException e) {}
    }
}
