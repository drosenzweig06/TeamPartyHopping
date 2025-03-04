import processing.core.PApplet;

public interface Clickable {
    private void draw() {

    }
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
    private void mouseReleased() {

    }
    private void mousePressed() {

    }
}
