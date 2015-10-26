/**
 * Simple fraction class to represent fractions.
 * @postcondition Fraction objects are always stored in reduced form.
 * 					Fraction objects always carry their sign in their numerator only.
 * @author Alejandro Guzman
 * @version 7/24/2015
 *
 */
public class Fraction {
	private int numerator;
	private int denominator;
	
	/**
	 * Default constructor.
	 * @Postcondition numerator is 0 and denominator is 1
	 */
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	/**
	 * Creates a fraction object with a specific numerator.
	 * @param numerator the numerator of the fraction.
	 * @Postcondition denominator is 1.
	 */
	public Fraction(int numerator) {
		this.numerator = numerator;
		this.denominator = 1;
	}
	
	/**
	 * Creates a fraction object with a specific numerator and denominator.
	 * @param numerator top portion of a fraction.
	 * @param denominator bottom portion of a fraction.
	 */
	public Fraction(int numerator, int denominator) {
		if (isDenominatorZero(denominator)) {
			throw new IllegalArgumentException();
		}
		
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		
		int divisor = Math.abs(gcd(numerator, denominator));
		this.numerator = numerator / divisor;
		this.denominator = denominator /divisor;		
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	/**
	 * Test if other equals this fraction.
	 * @return true if both fractions are equal false otherwise.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Fraction otherObject = (Fraction) other;
		return otherObject.numerator == this.numerator &&
				otherObject.denominator == this.denominator;
	}
	
	/**
	 * Adds two fractions.
	 * @param other the other fraction to add to this.
	 * @return newFraction the result of adding two fractions.
	 */
	public Fraction add(Fraction other) {
		int thisNumerator = this.numerator * other.denominator;
		int otherNumerator = other.numerator * this.denominator;
		int commonDenominator = this.denominator * other.denominator;
		return new Fraction(thisNumerator + otherNumerator, commonDenominator);
	}
	
	/**
	 * Divides two fractions.
	 * @param other the other fraction to divide to this.
	 * @return newFraction the result of dividing two fractions.
	 * @throws IllegalArgumentException when other is zero.
	 */
	public Fraction div(Fraction other) {
		if (other.numerator == 0) {
			throw new IllegalArgumentException();
		}
		return new Fraction(this.numerator * other.denominator,
				this.denominator * other.numerator);
	}
	
	/**
	 * Multiplies two fractions.
	 * @param other the other fraction to multiply to this.
	 * @return newFraction the result of multiplying two fractions.
	 */
	public Fraction mul(Fraction other) {
		return new Fraction(this.numerator * other.numerator,
				this.denominator * other.denominator);
	}
	
	/**
	 * Subtract two fractions.
	 * @param other the other fraction to subtract from this.
	 * @return newFractions the result of subtracting two fractions.
	 */
	public Fraction sub(Fraction other) {
		int thisNumerator = this.numerator * other.denominator;
		int otherNumerator = other.numerator * this.denominator;
		int commonDenominator = this.denominator * other.denominator;
		return new Fraction(thisNumerator - otherNumerator, commonDenominator);
	}
	
	/**
	 * Displays in fraction form the fraction. If denominator is 1 fraction
	 * will only display numerator otherwise both numerator and denominator
	 * will be displayed separated by /. (eg: 5/1)
	 * @return A string representation of the fraction.
	 */
	public String toString() {
		String result = (this.denominator == 1) ? this.numerator + "" : this.numerator + "/" + this.denominator;
		return result;
	}
	
	public double value() {
		return this.numerator / ((double) this.denominator);
	}
	
	/**
	@Override
	public int hashCode() {
		final int HASH_MULTIPLIER = 31;
		int h1 = this.numerator;
		int h2 = this.denominator;
		int h = HASH_MULTIPLIER * h1 + h2;
		return h;
	}
	*/
	
	private int gcd(int numerator, int denominator) {
		while (denominator != 0) {
			int temp = denominator;
			denominator = numerator % denominator;
			numerator = temp;
		}
		return numerator;
	}
	
	private boolean isDenominatorZero(int denominator) {
		return denominator == 0;
	}
}
