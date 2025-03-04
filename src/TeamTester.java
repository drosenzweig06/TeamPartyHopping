//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Team Tester
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
/**
 * A short tester class for verifying some of the Agent and Team behaviors in P05.
 */
public class TeamTester {
  /**
   * Verifies that an Agent’s initial position is set correctly upon creation.
   * 
   * This test should:
   * - Create two agents at different (x,y) coordinates
   * - Verify that their getX() and getY() methods return the expected values
   * - Verify that their initial positions match the coordinates provided to their constructors
   * 
   * @return true if both agents are created with correct coordinates; false otherwise
   */
  public static boolean testAgentInitialPosition() {
    int x1 = 4;
    int y1 = 5;
    Agent agent1 = new Agent(x1, y1);
    int x2 = 1;
    int y2 = 2;
    Agent agent2 = new Agent(x2, y2);
    if (agent1.getX() != x1){//unexpected behavior
      return false;
    }
    if (agent1.getY() != y1){//unexpected behavior
      return false;
    }
    if (agent2.getX() != x2){//unexpected behavior
      return false;
    }
    if (agent2.getY() != y2){//unexpected behavior
      return false;
    }
    //TODO: check about originalX, originalY, if needed for this
    return true;
  }
  /**
   * Verifies that an Agent moves correctly when given a destination.
   * This test should:
   * - Create an agent at a known position
   * - Set a destination that is at least 10 pixels away in both x and y directions
   * - Call the move() method once
   * - Verify that the agent has moved closer to the destination but has not reached it
   * - Verify that the movement follows the expected trajectory
   * 
   * @return true if agent movement behavior is correct; false otherwise
   */
  public static boolean testAgentMovement() {
    //Test scenario 1: should move up two pixels and right one pixel
    {
      int x = 0;
      int y = 0;
      Agent a1 = new Agent(x, y);
      float x1 = 12;
      float y1 = 24;
      a1.setDestination(x1, y1);
      double dist1 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      a1.move();
      double dist2 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      if (dist2 >= dist1 || dist2 == 0){ //unexpected behavior - didn't move closer or reached it
        return false;
      }
      //Expected trajectory is up two pixels and right one pixel
      if (a1.getY() != 2){//unexpected behavior - didn't move up two pixels
        return false;
      }
      if (a1.getX() != 1){//unexpected behavior - didn't move right one pixel
        return false;
      }
    }
    //Test scenario 2: should move right two pixels and down one pixel
    {
      int x = 0;
      int y = 0;
      Agent a1 = new Agent(x, y);
      float x1 = 24;
      float y1 = -12;
      a1.setDestination(x1, y1);
      double dist1 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      a1.move();
      double dist2 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      if (dist2 >= dist1 || dist2 == 0){ //unexpected behavior - didn't move closer or reached it
        return false;
      }
      //Expected trajectory is right two pixels and down one pixel
      if (a1.getX() != 2){//unexpected behavior - didn't move right two pixels
        return false;
      }
      if (a1.getY() != -1){//unexpected behavior - didn't move down one pixel
        return false;
      }
    }
    //Test scenario 3: should move down two pixels and left one pixel
    {
      int x = 0;
      int y = 0;
      Agent a1 = new Agent(x, y);
      float x1 = -12;
      float y1 = -24;
      a1.setDestination(x1, y1);
      double dist1 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      a1.move();
      double dist2 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      if (dist2 >= dist1 || dist2 == 0){ //unexpected behavior - didn't move closer or reached it
        return false;
      }
      //Expected trajectory is down two pixels and left one pixel
      if (a1.getY() != -2){//unexpected behavior - didn't move down two pixels
        return false;
      }
      if (a1.getX() != -1){//unexpected behavior - didn't move left one pixel
        return false;
      }
    }
    //Test scenario 4: should move left two pixels and up one pixel
    {
      int x = 0;
      int y = 0;
      Agent a1 = new Agent(x, y);
      float x1 = -24;
      float y1 = 12;
      a1.setDestination(x1, y1);
      double dist1 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      a1.move();
      double dist2 = Math.sqrt(Math.pow((x1 - a1.getX()), 2) + Math.pow((y1 - a1.getY()), 2));
      if (dist2 >= dist1 || dist2 == 0){ //unexpected behavior - didn't move closer or reached it
        return false;
      }
      //Expected trajectory is left two pixels and up one pixel
      if (a1.getX() != -2){//unexpected behavior - didn't move left two pixels
        return false;
      }
      if (a1.getY() != 1){//unexpected behavior - didn't move up one pixel
        return false;
      }
    }
    return true;
  }
  /**
   * Verifies that an Agent without a destination remains stationary.
   * 
   * This test should:
   * - Create an agent at a specific position
   * - Record its initial position
   * - Call the move() method
   * - Verify that the agent’s position has not changed
   * 
   * @return true if agent remains stationary when no destination is set; false otherwise
   */
  public static boolean testAgentStationary() {
    return false;
  }
  /**
   * Verifies that creating a Team with multiple Leads throws an IllegalArgumentException.
   * 
   * This test should:
   * - Create an ArrayList of Agents that includes multiple Lead instances
   * - Attempt to create a Team with this ArrayList
   * - Verify that an IllegalStateException is thrown
   * 
   * @return true if the correct exception is thrown; false otherwise
   */
  public static boolean testMultipleLeadsException() {
    return false;
  }
  /**
   * Verifies behavior around empty teams.
   * 
   * This test should:
   * - Create an empty ArrayList
   * - Attempt to create a Team with this ArrayList
   * - Verify that an IllegalArgumentException is thrown
   * - Add at least one Agent to the ArrayList and create a valid team
   * - Remove all agents from the team
   * - Verify that the Team's size is now zero
   * @return
   */
  public static boolean testEmptyTeam() {
    return false;
  }
  /**
   * Verifies that a Team can be created successfully with exactly one Lead.
   * 
   * This test should:
   * - Create an ArrayList with one Lead and multiple regular Agents
   * - Create a Team with this ArrayList
   * - Verify that the Team is created successfully
   * - Verify that the Team size matches the ArrayList size
   * - Verify that all Agents are properly added to the Team
   * - Verify that the hasLead method correctly reports that this team has a Lead
   * 
   * @return true if Team creation succeeds with correct composition; false otherwise
   */
  public static boolean testValidTeamCreation() {
    return false;
  }
  /**
   * Verifies that a new Agent can be added to an existing Team.
   * 
   * This test should:
   * - Create a valid Team with one Lead and at least one Agent
   * - Create a new Agent
   * - Add the new Agent to the Team using addAgent()
   * - Verify that the Team size has increased
   * - Verify that the new Agent is now a member of the Team
   * 
   * @return true if Agent is successfully added to Team; false otherwise
   */
  public static boolean testAddAgentToTeam() {
    return false;
  }
  /**
   * Verifies that Team’s center coordinates are calculated correctly.
   * 
   * This test should:
   * - Create a Team with at least three Agents at known positions
   * - Calculate the expected center coordinates manually
   * - Compare the expected values with getCenterX() and getCenterY() results
   * - Verify that adding a new Agent updates the center coordinates correctly
   * 
   * @return true if center coordinates are calculated correctly; false otherwise
   */
  public static boolean testTeamCenter() {
    return false;
  }
  /**
   * Runs all tests and displays results
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("-----------------------------------------------------------");
    System.out.println("testAgentInitialPosition: " + (testAgentInitialPosition() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testAgentMovement: " + (testAgentMovement() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testAgentStationary: " + (testAgentStationary() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testMultipleLeadsException: " + (testMultipleLeadsException() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testEmptyTeam: " + (testEmptyTeam() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testValidTeamCreation: " + (testValidTeamCreation() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testAddAgentToTeam: " + (testAddAgentToTeam() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
    System.out.println("testTeamCenter: " + (testTeamCenter() ? "Pass" : "Failed!"));
    System.out.println("-----------------------------------------------------------");
  }

}
