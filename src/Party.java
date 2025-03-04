public class Party extends Object implements Clickable{
    private processing.core.PImage image;
    private static TeamManagementSystem tms;
    private float x;
    private float y;

    public Party(int x, int y, processing.core.PImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void draw() {
        if(tms != null && image != null) {
            tms.image(image, x, y);
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isMouseOver() {
        if(tms == null || image == null) {
            return false;
        }
        //KEEP WORKING ON
    }

    public void mousePressed() {
        //THIS METHOD IS INTENTIONALLY LEFT EMPTY
    }

    public void mouseReleased() {

    }

    public static void setProcessing(TeamManagementSystem processing) {
        tms = processing;
    }
}
