/**
 * Checked exception thrown when a dictionary cannot be created or when
 * the dictionary could not be written to a text file.
 * @author Alejandro Guzman 10/15/15
 *
 */
public class DictionaryException extends Exception {

	public DictionaryException() {
		
	}
	
	public DictionaryException(String message) {
		super(message);
	}
}
