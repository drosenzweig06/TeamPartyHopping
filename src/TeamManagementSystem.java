//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TeamManagementSystem
// Course:   CS 300 Spring 2025
//
// Author:   Thomas Koltermann
// Email:    tpkoltermann@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Daniel Rosenzweig
// Partner Email:   drosenzweig@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         Lectures by Mouna Kacem
// Online Sources:
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;

///////////////////////////////////////////////////////////////////////////////////////////////////
// IMPORTANT NOTE: Completing this class will be MOST EFFICIENT if you have already written at least
// a draft version of the required instantiable classes and verified their behavior using the tester
// class methods. 
//
// The numbers associated with each TODO represent a recommended order of completion, but you may
// implement these methods in any order you wish.
//
// Reminder: Javadoc-style commenting is REQUIRED.
///////////////////////////////////////////////////////////////////////////////////////////////////

public class TeamManagementSystem extends PApplet {
  
  // General data fields for this program
  private Random randGen;               // A random number generator for creating Team colors
  private ArrayList<Clickable> objects; // Storage for the interactive components of the program
  private ArrayList<Team> teams;        // Storage for all Teams with at least one member
  private int bgColor;                  // The background color of the application window
  
  // Selection-related fields:
  private boolean isSelecting; // Indicates whether the user is currently creating a selection box
  private int selectionStartX; // The x-coordinate where the user began creating a selection box
  private int selectionStartY; // The y-coordinate where the user began creating a selection box
  
  public static void main(String[] args) {
    PApplet.main("TeamManagementSystem"); // PROVIDED
  }
  
  @Override
  public void settings() {
    // TODO #1 call PApplet's size() method giving it 800 as the width and 600 as the height
  }
  
  @Override
  public void setup() {
    // TODO #2 add setProcessing calls (see writeup)
    // TODO #3 set the imageMode so the x,y coordinates indicate the center of an object
    // TODO #4 initialize randGen and the ArrayLists
    // TODO #5 initialize the bgColor with R = 81, G = 125, B = 168
    
    // TODO #7 add the party objects (see writeup for suggested locations, but feel free to change)
    // TODO #8 add one agent at the center of the screen
  }
  
  @Override
  public void draw() {
    // TODO #6 draw the background using the bgColor value
    
    // TODO #14 draw the selection box if the user is currently selecting (see helper method below)
    
    // TODO #9 draw all Clickables in the objects list to the application window in the order they appear
    
    // TODO #11 use your helper method below to clear all empty teams from the teams list
    // TODO #12 if there are any teams left, do the following:
      // (1) begin with a y-coordinate of 20 and a text size of 16
      // (2) set PApplet's fill to (0,255,0) if the team is active, or just (255) if it is not
      // (3) print "Team " and the team's ID letter at x=10 and the current y-coordinate
      // (4) move the y-coordinate down by 20 and repeat if there are any other teams
  }
  
  public void clearEmptyTeams() {
    // TODO #10 implement this method - remove all teams with NO members from the teams list
  }
  
  public void drawSelectionBox() {
    // TODO #13 implement this method, see below for details:
    
    // The user's selection box is defined by the selectionStartX/selectionStartY coordinates and
    // the current position of the mouse. However, PApplet's rectangle drawing method requires the
    // coordinates of the upper left corner of the rectangle (which may not correspond to either of
    // those points) and the width/height of the rectangle to draw.
    
    // To draw this rectangle correctly:
    // (1) set PApplet's fill() to R=135, G=185, B=201
    // (2) call PApplet's rect() method using the upper left corner coordinates and the width/height
  }
  
  @Override
  public void mousePressed() {
    // TODO #15 if the mouse is over any of the Clickable objects, call only that object's 
    // mousePressed method and end the method

    // TODO #16 if the mouse is NOT over any of the Clickable objects, set isSelecting to true and
    // initialize the selectionStartX and selectionStartY values to the current mouse location
  }
  
  @Override
  public void mouseReleased() {
    // TODO #17 if the user is creating a selection box:
      // (1) determine whether all selected agents belong to a single team (see helper method below)
      // (2) if they do not, create a team out of the selected agents (see helper method below)
      // (3) either way, set isSelecting back to false
    
    // TODO #18 clear any empty teams (see helper method above)
    // TODO #19 call mouseReleased() on all Clickable objects
  }
  
  public Team detectTeam() {
    // TODO #20 find all agents within the selection box (this method will only be called when the
    // user was creating a selection box -- see helper method below)
    // TODO #21 if no agents were selected, return null
    // TODO #22 if all selected agents are on the same (non-null) team, return a reference to that
    // team, otherwise return null
    return null;
  }
  
  public ArrayList<Agent> getAllSelectedAgents() {
    // TODO #23 find the bounds of the selection box described by the selectionStart coordinates and
    // the current mouse location
    
    // TODO #24 add to this list all agents whose center (x,y) coordinate is within the bounds of
    // the selection box:
    ArrayList<Agent> agents = new ArrayList<>();
    return agents;
  }
  
  public void createTeam(ArrayList<Agent> selected) {
    // TODO #25 if no agents were selected, end the method
    // TODO #26 generate a random color for this team with R, G, and B values between 0 and 255
    // TODO #27 attempt to create a new team using the selected agents and this color
    // TODO #28 if the team is created successfully, add it to the teams list; otherwise do nothing
  }
  
  @Override
  public void keyPressed() {
    // TODO #29 if the key is a '.', add a normal agent at the mouse's current location
    // TODO #30 if the key is a ',', add a team lead at the mouse's current location
    // TODO #31 if the key is an 'r' and the mouse is over an agent, remove that agent
    
    // TODO #32 if the key is the lower-case version of any of the existing Team IDs, have that
    // Team's members line up
  }
  
  public Team getActiveTeam() {
    // TODO #33 find the first team in the teams list with all members active and return it
    // TODO #34 if no team has all members active, return null
    return null;
  }

}
