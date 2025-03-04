import java.util.ArrayList;
public class Team {
    private int color;
    private static char idGenerator = 'A';
    private ArrayList<Agent> members;
    private final char TEAM_ID;

    public Team(int color, ArrayList<Agent> agents) {
        if(agents == null || agents.isEmpty()) {
            throw new IllegalArgumentException("Cant have null or no agents");
        }
        //if(//MORE THAN ONE LEAD) {
         //throw new IllegalStateException("Cant have more than one lead");
        //}
        this.color = color;
        this.members = new ArrayList<>(agents);
        this.TEAM_ID = idGenerator++;
    }

    public void addMember(Agent a) {
        if(a != null && !members.contains(a)) {
            members.add(a);
        }
    }

    public boolean contains(Agent a) {
        return members.contains(a);
    }

    public float getCenterX() {
        if(members.isEmpty()) {
            return 0;
        }
        //NEEDS WORK
    }

    public float getCenterY() {
        if(members.isEmpty()) {
            return 0;
        }
        //NEEDS WORK
    }

    public int getColor() {
        return color;
    }

    public char getTeamID() {
        return TEAM_ID;
    }

    public int getTeamSize() {
        return members.size();
    }

    public boolean hasLead() {

    }

    public boolean isActive() {

    }

    public void lineUp() {
        float centerX = getCenterX();
        float centerY = getCenterY();
        for (int i = 0; i < members.size(); i++) {
            members.get(i).setDestination(centerX + (i*10), centerY);
        }
    }

    public boolean removeMember(Agent a) {
        return members.remove(a);
    }

    public void selectAll() {

    }

    public void sendToParty(Party p) {

    }
}
//
