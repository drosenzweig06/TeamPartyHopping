public class Agent implements Clickable {
    private float destX;
    private float destY;
    protected static int diameter;
    private boolean isActive;
    protected boolean isDragging;
    private int oldMouseX;
    private int oldMouseY;
    private float originalX;
    private float originalY;
    protected static processing.core.PApplet processing;
    protected Team team;
    private float xPos;
    private float yPos;

    public Agent(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public static int diameter() {
        return diameter;
    }

    protected void drag() {

    }

    public void draw() {
        if(isDragging) {
            drag();
        } else if(isMoving()) {
            move();
        }
        processing.fill(getColor());
        processing.ellipse(xPos, yPos, diameter, diameter);
    }

    protected int getColor() {
        if(isActive) {
            return processing.color(0, 255, 0);
        } else if(team != null) {
            return team.getColor();
        } else {
            return processing.color(255, 255, 0);
        }
    }

    public Team getTeam() {
        return team;
    }

    public float getX() {
        return xPos;
    }

    public float getY() {
        return yPos;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isMouseOver() {

    }

    protected boolean isMoving() {
        return destX != -1 && destY != -1;
    }

    public void mousePressed() {

    }

    public void mouseReleased() {

    }

    protected void move() {

    }

    public void setDestination(float x, float y) {
        destX = x;
        destY = y;
        isActive = false;
    }

    public static void setProcessing(processing.core.PApplet processing) {

    }

    public void setTeam(Team t) {
        this.team = t;
    }

    protected void startDragging() {
        isDragging = true;
        oldMouseX = processing.mouseX;
        oldMouseY = processing.mouseY;
        originalX = xPos;
        originalY = yPos;
    }

    protected void stopDragging() {
        isDragging = false;
    }

    public void toggleActive() {

    }
}
