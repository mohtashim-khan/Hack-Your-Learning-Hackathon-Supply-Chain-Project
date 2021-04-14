/**
@author    Mohtashim Khan <a href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
@version    1.1
@since      1.0
*/
package edu.ucalgary.ensf409;

public class DatabaseProcessException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
    public DatabaseProcessException() {}

    // Constructor that accepts a message
    public DatabaseProcessException(String message)
    {
       super(message);
    }
}