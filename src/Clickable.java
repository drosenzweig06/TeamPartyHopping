/**
 * This interface models Clickable objects in a graphic application
 */
public interface Clickable {
    /**
     * Renders the clickable object to the application window
     */
    void draw();
    /**
     * Determines whether the cursor is currently over this object
     *
     * @return true if the cursor is over the object, false otherwise
     */
    boolean isMouseOver();
    /**
     * Implements the behavior to be run each time the mouse is released
     */
    void mouseReleased();
    /**
     * Implements the behavior to be run each time the mouse is pressed
     */
    void mousePressed();
}
