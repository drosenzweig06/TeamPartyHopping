import java.io.File;
import processing.core.PImage;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class models a Team for the CS300 P05 Team Party Hopping project
 */
public class Team {
    /**
     * The color in which this team's members are drawn in the application window when not active
     */
    private int color;
    /**
     * A shared variable containing the identifier character to be used by the next
     * Team that is successfully created; initialized to 'A'
     */
    private static char idGenerator = 'A';
    /**
     * A list of the current members of this Team
     */
    private ArrayList<Agent> members;
    /**
     * This Team's unique identifier, set at construction
     */
    private final char TEAM_ID;
    /**
     * Attempts to create a new team from the provided list of agents, advancing the idGenerator
     * to the next value only if the team can be created successfully
     *
     * @param color - the color for this team's agents
     * @param agents - a list of the agents to be added to this team
     * @throws IllegalArgumentException - if the agents list is empty
     * @throws IllegalStateException - if the agents list contains more than one Lead
     */
    public Team(int color, ArrayList<Agent> agents) {
        int count = 0;
        if (agents == null || agents.isEmpty()) {
            throw new IllegalArgumentException("Cant have null or no agents");
        }
        for (int i = 0; i < agents.size(); i++) {
            if(agents.get(i) instanceof Lead) {
                count++;
            }
        }
        if(count > 1) {
         throw new IllegalStateException("Cant have more than one lead");
        }
        this.color = color;
        this.members = new ArrayList<>(agents);
        this.TEAM_ID = idGenerator++;
    }
    /**
     * Adds the given agent to this team's list. If the agent is already present in this team's
     * member list, this method does nothing
     *
     * @param a - the agent to add to the list
     *
     * @throws IllegalStateException - if the agent is a Lead that is not already
     * present in the list
     */
    public void addMember(Agent a) {
        if(a != null && !members.contains(a)) {
            members.add(a);
        }
    }
    /**
     * Accessor to determine whether a given agent is a member of this team
     *
     * @param a - the agent that may be a member of this team
     *
     * @return true if this agent is in the member list, false otherwise
     */
    public boolean contains(Agent a) {
        return members.contains(a);
    }
    /**
     * Finds the "center" x-coordinate of this team, defined as being halfway between the
     * leftmost and rightmost agents on this team
     *
     * @return the center x-coordinate of this team
     */
    public float getCenterX() {
        if(members.isEmpty()) {
            return 0;
        }
        float minX = members.get(0).getX();
        float maxX = members.get(0).getX();
        for(int i = 0; i < members.size(); i++) {
            if(members.get(i).getX() < minX) {
                minX = members.get(i).getX();
            }
            if(members.get(i).getX() > maxX) {
                maxX = members.get(i).getX();
            }
        }
        return (minX+maxX)/2;
    }
    /**
     * Finds the "center" y-coordinate of this team, defined as being halfway between the
     * topmost and bottommost agents on this team
     *
     * @return the center y-coordinate of this team
     */
    public float getCenterY() {
        if(members.isEmpty()) {
            return 0;
        }
        float minY = members.get(0).getY();
        float maxY = members.get(0).getY();
        for(int i = 0; i < members.size(); i++) {
            if(members.get(i).getY() < minY) {
                minY = members.get(i).getY();
            }
            if(members.get(i).getY() > maxY) {
                maxY = members.get(i).getY();
            }
        }
        return (minY+maxY)/2;
    }
    /**
     * Accessor method for the color value of this team
     *
     * @return the color value of this team
     */
    public int getColor() {
        return color;
    }
    /**
     * Accessor method for the team's ID character
     *
     * @return the team ID value
     */
    public char getTeamID() {
        return TEAM_ID;
    }
    /**
     * Accessor method for the total number of agents on this team
     *
     * @return the size of this team
     */
    public int getTeamSize() {
        return members.size();
    }
    /**
     * Reports whether this team currently has a Lead member
     *
     * @return true if this team currently has a Lead member, false otherwise
     */
    public boolean hasLead() {
        for (int i = 0; i < members.size(); i++){
            if (members.get(i) instanceof Lead) {
                return true;
            }
        }
        return false;
    }
    /**
     * Checks whether ALL members of a team have been selected
     *
     * @return true if ALL members of this team are active, false otherwise
     */
    public boolean isActive() {
        for(int i = 0; i < members.size(); i++) {
            if(!members.get(i).isActive()) {
                return false;
            }
        }
        return true;
    }
    /**
     * Updates the destination of all team members so that the team formation becomes a line
     * centered at getCenterX/getCenterY. Each member should be allocated their diameter
     * + 3 pixels worth of space in the line, to avoid overlapping with the agent next to them.
     * Hint: the total width of this line is equal to ((diameter+3)*teamSize)-3.
     */
    public void lineUp() {
        float centerX = getCenterX();
        float centerY = getCenterY();
        for (int i = 0; i < members.size(); i++) {
            members.get(i).setDestination(centerX + (i*10), centerY);
        }
    }
    /**
     * Removes the provided agent from this team
     *
     * @param a - the agent to remove
     *
     * @return true if the agent was removed from the team successfully, false otherwise
     */
    public boolean removeMember(Agent a) {
        if(members.contains(a)) {
            members.remove(a);
            return true;
        }
        return false;
    }
    /**
     * Activates ALL members of this team
     */
    public void selectAll() {
        for(int i = 0; i < members.size(); i++) {
            if(!members.get(i).isActive()) {
                members.get(i).toggleActive();
            }
        }
    }

    /**
     * Updates the destination of all team members so that the current team formation will be
     * maintained, but after movement is completed the team will be centered over the given Party
     *
     * @param p - the party to move the team to
     */
    public void sendToParty(Party p) {
        for(int i = 0; i < members.size(); i++) {
            members.get(i).setDestination(members.get(i).getX() + (p.getX()-getCenterX()),
                    members.get(i).getY() + (p.getY())-getCenterY());
        }
    }
}
