/**
 * This class Models an Agent for the CS300 P05 Team Party Hopping project
 * Note: the methods that are listed as protected in this documentation are
 * intended to be helper methods, for use only inside the class.
 * They are listed as protected for testing purposes.
 */
public class Agent extends Object implements Clickable {
    /**
     * This will store the x-coordinate that an Agent is actively moving to.
     */
    private float destX;
    /**
     * This will store the y-coordinate that an Agent is actively moving to.
     */
    private float destY;
    /**
     * The standard diameter of all Agent representations,
     * protected for access in the child class. Set to a default value of 20 for P05.
     */
    protected static int diameter;
    /**
     * Indicator of whether this Agent is currently active
     */
    private boolean isActive;
    /**
     * Indicator of whether this Agent is currently being dragged
     */
    protected boolean isDragging;
    /**
     * Storage for the previous x-position of the mouse,
     * for use in dragging Agents around the window
     */
    private int oldMouseX;
    /**
     * Storage for the previous y-position of the mouse,
     * for use in dragging Agents around the window
     */
    private int oldMouseY;
    /**
     * This will store the original x-coordinate of an agent when the mouse is pressed,
     * for determining whether the agent was dragged at all when the mouse is released.
     */
    private float originalX;
    /**
     * This will store the original y-coordinate of an agent when the mouse is pressed,
     * for determining whether the agent was dragged at all when the mouse is released.
     */
    private float originalY;
    /**
     * A reference to the application window, for creating visual representations
     */
    protected static processing.core.PApplet processing;
    /**
     * A reference to this Agent's assigned team, or null if this Agent does not yet have a team
     */
    protected Team team;
    /**
     * The x-position of the center of this Agent
     */
    private float xPos;
    /**
     * The y-position of the center of this Agent
     */
    private float yPos;
    /**
     * Constructs a new agent at the given x,y coordinate, and initializes any data
     * fields with non-default values.
     * @param x - the initial x-coordinate of this agent
     * @param y - the initial y-coordinate of this agent
     */
    public Agent(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }
    /**
     * Accesses the value of the class variable diameter
     *
     * @return the diameter of every Agent's representation
     */
    public static int diameter() {
        return diameter;
    }
    /**
     * Helper method containing the logic to update this agent's position
     * correctly while being dragged.
     */
    protected void drag() {
        float dx = processing.mouseX - xPos;
        float dy = processing.mouseY - yPos;
        xPos += dx;
        yPos += dy;
        oldMouseX = processing.mouseX;
        oldMouseY = processing.mouseY;
    }
    /**
     * Renders this agent to the application window after making any required updates to its
     * position, that is, if being dragged or if moving to a destination. Agents are rendered
     * as a circle of the class' diameter at their specific x,y coordinates, drawn in the color
     * returned by the helper method getColor().
     */
    public void draw() {
        if(isDragging) {
            drag();
        } else if(isMoving()) {
            move();
        }
        processing.fill(getColor());
        processing.ellipse(xPos, yPos, diameter, diameter);
    }
    /**
     * Helper method to determine the color to use for drawing this agent: When active,
     * always color(0,255,0) (green) Otherwise if part of a team, that team's color
     * Otherwise, color(255,255,0) (yellow)
     *
     * @return an integer representing the color that this agent should be drawn in
     */
    protected int getColor() {
        if(isActive) {
            return processing.color(0, 255, 0);
        } else if(team != null) {
            return team.getColor();
        } else {
            return processing.color(255, 255, 0);
        }
    }
    /**
     * Accessor method for the Team reference of this Agent
     *
     * @return a direct reference to the team that this agent is a member of,
     * or null if this agent is not a member of any team
     */
    public Team getTeam() {
        return team;
    }
    /**
     * Accessor method for the current x-coordinate of this Agent
     *
     * @return the current x-coordinate of this agent
     */
    public float getX() {
        return xPos;
    }
    /**
     * Accessor method for the current y-coordinate of this Agent
     *
     * @return the current y-coordinate of this agent
     */
    public float getY() {
        return yPos;
    }
    /**
     * Reports whether this Agent has been selected
     *
     * @return true if this agent is active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }
    /**
     * Determines whether the mouse is over this agent.
     *
     * @return true if the mouse is over this agent, false otherwise
     */
    public boolean isMouseOver() {
    return false; //TODO: change
    }
    /**
     * Helper method, reports whether this Agent is currently moving.
     *
     * @return true if this agent is moving, false otherwise
     */
    protected boolean isMoving() {
        return destX != -1 && destY != -1;
    }
    /**
     * Defines the behavior of this agent when it is clicked on. This method is called only
     * when the mouse is over the agent. An agent that has been clicked on should begin dragging
     * and note its current (x,y) position in the originalX/originalY fields,
     * but only if it is not already moving.
     */
    public void mousePressed() {

    }
    /**
     * Defines the behavior of this agent when the mouse is released. When the mouse is released,
     * all agents STOP dragging; if this agent's current (x,y) position is identical to the
     * values stored in its originalX/originalY, it has been activated. Regardless, all agents'
     * originalX/originalY values are reset to -1.
     */
    public void mouseReleased() {

    }
    /**
     * Helper method to move an agent 3 units toward its destination, if one is set;
     * if the agent is within 3 units of its destination, moves the agent directly
     * to its destination and resets the destination coordinates to (-1,-1).
     * If no destination is set, this method does nothing.
     */
    protected void move() {
        float distance = processing.dist(xPos, yPos, destX, destY);
        if (distance < 3){
            xPos = destX;
            yPos = destY;
            destX = -1;
            destY = -1;
        }
        //TODO: check what 3 units means
    }
    /**
     * Sets the destination coordinates of this agent to be the provided values
     * and deactivates the agent.
     *
     * @param x - this agent's new destination x-coordinate
     * @param y - this agent's new destination y-coordinate
     */
    public void setDestination(float x, float y) {
        destX = x;
        destY = y;
        isActive = false;
    }
    /**
     * Initializes the class PApplet reference to the provided value.
     *
     * @param processing - a reference to the PApplet object representing
     *                   this program's application window
     */
    public void setProcessing(processing.core.PApplet processing) {
        this.processing = processing;
    }
    /**
     * Sets the team of this agent to be the provided value. If this agent was already a member
     * of a team, this method should ALSO remove them from their previous team.
     *
     * @param t - the team to add this agent to
     */
    public void setTeam(Team t) {
        this.team = t;
    }
    /**
     * Helper method, sets this agent to be dragging and initializes
     * the oldMouseX and oldMouseY fields to the current location of the mouse.
     */
    protected void startDragging() {
        isDragging = true;
        oldMouseX = processing.mouseX;
        oldMouseY = processing.mouseY;
        originalX = xPos;
        originalY = yPos;
    }
    /**
     * Helper method, sets this agent to no longer be dragging.
     */
    protected void stopDragging() {
        isDragging = false;
    }
    /**
     * Switches the active status of this agent to its opposite -
     * if false, makes it true; if true, makes it false.
     */
    public void toggleActive() {
    isActive = !isActive;
    }
}
