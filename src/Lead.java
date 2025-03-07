import java.io.File;
import processing.core.PImage;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;
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
        super(x, y);
    }
    /**
     * Annotates a Lead's agent representation by drawing an inverted black triangle
     * over the circle in the color corresponding to this Lead's selection/team status.
     */
    @Override
    public void draw() {
        super.draw();
        processing.fill(0);
        double doubleX1 = getX() - diameter/3.0;
        float x1 = (float) doubleX1;
        double doubleY1 = getY() - diameter/5.0;
        float y1 = (float) doubleY1;
        double doubleX2 = getX() + diameter/3.0;
        float x2 = (float) doubleX2;
        double doubleY2 = getY() - diameter/5.0;
        float y2 = (float) doubleY2;
        float x3 = getX();
        double doubleY3 = getY() + diameter/3.0;
        float y3 = (float) doubleY3;
        processing.triangle(x1, y1, x2, y2, x3, y3);
    }
    /**
     * Defines the specific behavior of this team lead when the mouse is released.
     * If this lead was activated by the mouse being released, this method activates
     * ALL the members of this lead's team (if this lead has a team).
     */
    @Override
    public void mouseReleased() {
        super.mouseReleased();
        if (this.isActive()){
            if (this.getTeam() != null) {
                Team t = this.getTeam();
                t.selectAll();
            }
        }
    }
}
