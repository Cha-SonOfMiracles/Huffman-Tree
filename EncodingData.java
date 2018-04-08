
/**
 * This class is for you to write and represents a single pair of the data used
 * to encode a text message into its binary Huffman code (a symbol and its corresponding binary Huffman code).
 * @author Mu He
 */
public class EncodingData {
	/**
	 * a symbol that is to be encoded.
	 */
	private char symbol;
	/**
	 * the binary Huffman code of the symbol.(i.e. a string of 0¡¯s and 1¡¯s)
	 */
	private String encoding;

	/**
	 * The normal way to create a new EncodingData.
	 * @param symbol
	 * @param encoding
	 */
	public EncodingData(char symbol, String encoding) {
		this.symbol = symbol;
		this.encoding = encoding;
	}

	/**
	 * getter method of symbol attribute
	 * @return symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * getter method of encoding attribute
	 * @return encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * setter method of encoding attribute
	 * @param encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/* (non-Javadoc)
	 * test whether this and a given EncodingData has the same symbol attribute
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		EncodingData temp = (EncodingData) obj;
		return (symbol == temp.symbol);
	}

	/* (non-Javadoc)
	 * : method that gives a string representation of the symbol and its Huffman code
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "EncodingData [symbol=" + symbol + ", encoding=" + encoding + "]";
	}
}
