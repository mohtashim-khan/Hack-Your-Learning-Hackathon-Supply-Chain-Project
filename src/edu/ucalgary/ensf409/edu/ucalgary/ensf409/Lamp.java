/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Filing is a basic class that stores all the string variables from the
 *SQL database provided by the course instructors.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

class Lamp extends Furniture{
    private int base;
    private int bulb;

    public Lamp(String ID, int PRICE, String MANUID, String TYPE, int base, int bulb) {
        super(ID, PRICE, MANUID, TYPE);
        this.base = base;
        this.bulb = bulb;
    }

    public int getBase() {
        return base;
    }

    public int getBulb() {
        return bulb;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setBulb(int bulb) {
        this.bulb = bulb;
    }
}
//End class definition
