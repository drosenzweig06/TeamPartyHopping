/**
 * This class models a Party for CS300 P05 Team Party Hopping, similarly to P02.
 * However, unlike P02 we will send Agents to a Party by clicking on it,
 * so it will no longer have a character ID as in P02.
 */
public class Party extends Object implements Clickable{
    /**
     * The image associated with this Party
     */
    private processing.core.PImage image;
    /**
     * A reference to the TeamManagementSystem for this application window -
     * the Party may need to access specific methods you have defined, not just the
     * PApplet rendering methods, so you will need the reference to be of type
     * TeamManagementSystem here (vs Agent's PApplet reference).
     */
    private static TeamManagementSystem tms;
    /**
     * The x-position of the center of this Party
     */
    private float x;
    /**
     * The y-position of the center of this Party
     */
    private float y;
    /**
     * Constructs a Party represented by the given image at the given (x,y) coordinates
     *
     * @param x - the x-position of this Party
     * @param y - the y-position of this Party
     * @param image - the image representing this Party
     */
    public Party(int x, int y, processing.core.PImage image) {

    }
    /**
     * Draws the image associated with this party to its (x,y) location
     */
    public void draw() {

    }
    /**
     * Accessor method for the current x-coordinate of this Party
     *
     * @return the current x-coordinate of this agent
     */
    public float getX() {
        return x;
    }
    /**
     * Accessor method for the current y-coordinate of this Party
     *
     * @return the current y-coordinate of this agent
     */
    public float getY() {
        return y;
    }
    /**
     * Determines whether the mouse is over this party.
     *
     * @return true if the mouse is anywhere over the image associated with this party,
     * false otherwise.
     */
    public boolean isMouseOver() {

    }
    /**
     * This method is required by the Clickable interface, but does nothing
     */
    public void mousePressed() {

    }
    /**
     * Defines the behavior of this Party when the mouse is released.
     * If the mouse is over this party, the Party gets the active team from the
     * TeamManagementSystem and sends them to this party.
     */
    public void mouseReleased() {

    }
    /**
     * Initializes the class TeamManagementSystem reference to the provided value.
     *
     * @param processing - a reference to the TeamManagementSystem object representing
     *                  this program's application window
     */
    public static void setProcessing(TeamManagementSystem processing) {

    }
}
