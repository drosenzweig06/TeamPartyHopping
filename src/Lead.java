/**
 * Models a Team Lead agent for the CS300 P05 Team Party Hopping project.
 * Every Team can have at most one Lead, and clicking on that Team's Lead
 * selects ALL members of the Team at the same time.
 */
public class Lead extends Agent {
    /**
     * Constructs a new Lead at the given x,y coordinates.
     *
     * @param x - the x-position of this Lead
     * @param y - the y-position of this Lead
     */
    public Lead(int x, int y) {
    }
    /**
     * Annotates a Lead's agent representation by drawing an inverted black triangle
     * over the circle in the color corresponding to this Lead's selection/team status.
     */
    @Override
    public void draw() {

    }
    /**
     * Defines the specific behavior of this team lead when the mouse is released.
     * If this lead was activated by the mouse being released, this method activates
     * ALL the members of this lead's team (if this lead has a team).
     */
    @Override
    public void mouseReleased() {

    }
}
