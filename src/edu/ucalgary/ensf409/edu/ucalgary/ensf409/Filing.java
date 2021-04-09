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

class Filing extends Furniture{
    private int rails;
    private int drawers;
    private int cabinet;

    public Filing(String ID, int PRICE, String MANUID, String TYPE, int rails, int drawers, int cabinet) {
        super(ID, PRICE, MANUID, TYPE);
        this.rails = rails;
        this.drawers = drawers;
        this.cabinet = cabinet;
    }

    public int getRails() {
        return rails;
    }

    public int getDrawers() {
        return drawers;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setRails(int rails) {
        this.rails = rails;
    }

    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }
}
//End class definition