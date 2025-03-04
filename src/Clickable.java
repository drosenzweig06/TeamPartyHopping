import processing.core.PApplet;
/**
 * This interface models Clickable objects in a graphic application
 */
public interface Clickable {
    /**
     * Renders the clickable object to the application window
     */
    private void draw() {

    }
    /**
     * Determines whether the cursor is currently over this object
     *
     * @return true if the cursor is over the object, false otherwise
     */
    private boolean isMouseOver() {
        float agentX = agent.getX();
        float agentY = agent.getY();
        float agentWidth = agent.width();
        float agentHeight = agent.height();
        float mouseX = PApplet.
        float mouseY = processor.mouseY();
        if (mouseX > agentX - .5 * agentWidth && mouseX < agentX + .5 * agentWidth){
            if (mouseY > agentY - .5 * agentHeight && mouseY < agentY + .5 * agentHeight){
                return true;
            }
        }
        return false;
    }
    /**
     * Implements the behavior to be run each time the mouse is released
     */
    private void mouseReleased() {
    }
    /**
     * Implements the behavior to be run each time the mouse is pressed
     */
    private void mousePressed() {

    }
}
