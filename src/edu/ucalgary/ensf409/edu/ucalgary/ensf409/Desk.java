/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Desk is a basic class that stores all the string variables from the
 *SQL database provided by the course instructors.
 *
 */
//Package declaration
package edu.ucalgary.ensf409;

class Desk extends Furniture{
    private int legs;
    private int top;
    private int drawer;

    public Desk(String ID, int PRICE, String MANUID, String TYPE, int legs, int top, int drawer) {
        super(ID, PRICE, MANUID, TYPE);
        this.legs = legs;
        this.top = top;
        this.drawer = drawer;
    }

    public int getLegs() {
        return legs;
    }

    public int getTop() {
        return top;
    }

    public int getDrawer() {
        return drawer;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setDrawer(int drawer) {
        this.drawer = drawer;
    }
}
//End class definition