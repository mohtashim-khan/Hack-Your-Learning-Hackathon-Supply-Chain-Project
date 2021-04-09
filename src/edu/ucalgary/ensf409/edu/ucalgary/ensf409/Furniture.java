/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Furniture is a basic class that provides a template for the other furniture objects
 *(chair, Desks, Filings, Lamp).
 *These furniture items are based from the SQL database provided by the course instructors.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

public class Furniture {
    final String ID;
    final int PRICE;
    final String MANUID;
    final String TYPE;

    public Furniture(String ID, int PRICE, String MANUID, String TYPE) {
        this.ID = ID;
        this.PRICE = PRICE;
        this.MANUID = MANUID;
        this.TYPE = TYPE;
    }

    public String getID() {
        return ID;
    }

    public int getPRICE() {
        return PRICE;
    }

    public String getMANUID() {
        return MANUID;
    }

    public String getTYPE() {
        return TYPE;
    }

}
//End class definition
