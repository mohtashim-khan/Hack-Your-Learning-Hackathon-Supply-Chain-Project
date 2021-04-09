/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Chair is a basic class that stores all the string variables from the
 *SQL database provided by the course instructors.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

class Chair extends Furniture{
    private int legs;
    private int arms;
    private int seat;
    private int cushion;

    public Chair(String ID, int PRICE, String MANUID, String TYPE, int legs, int arms, int seat, int cushion) {
        super(ID, PRICE, MANUID, TYPE);
        this.legs = legs;
        this.arms = arms;
        this.seat = seat;
        this.cushion = cushion;
    }

    public int getLegs() {
        return legs;
    }

    public int getArms() {
        return arms;
    }

    public int getSeat() {
        return seat;
    }

    public int getCushion() {
        return cushion;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setCushion(int cushion) {
        this.cushion = cushion;
    }

}
//End class definition