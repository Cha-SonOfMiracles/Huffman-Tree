import java.util.Iterator;

/**
 * This class uses a Huffman tree for encoding a character and decoding a code string.
 * @author Mu He
 */
public class HuffmanCoder {
	/**
	 * the private variable stores Huffman tree
	 */
	private HuffmanTree huffTree;

	/**
	 * an unordered list of encoding data, 
	 * 		which will be built when the Huffman tree is built, 
	 * 		and will be used for encoding a text file into a Huffman-coded compressed file.
	 */
	private ArrayUnorderedList<EncodingData> encodingList;

	/**
	 * this constructor will create the huffTree, using the 4th Huffman tree constructor. 
	 * It will also call the private helper method.
	 * @param pairsList
	 */
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList) {
		huffTree = new HuffmanTree(pairsList);
		encodingList = new ArrayUnorderedList<>();
		buildEncodingList(huffTree.getRoot(), "");
	}

	/**
	 * This method will take the specified string of binary digits that is a Huffman encoding, 
	 * and will return the original coded character.
	 * 
	 * @param code
	 * @return character / (char)0
	 * 		if not found, return (char)0.
	 */
	public char decode(String code) {
		BinaryTreeNode<HuffmanPair> current = huffTree.getRoot();
		for(char temp: code.toCharArray()) {
			if(temp == '0') current = current.getLeft();
			if(temp == '1') current = current.getRight();
		}
		if(current.isLeaf()) {return current.getElement().getCharacter();}
		else { return (char)0;}
	}

	/**
	 * This method will take the specified character and return the string representation of the binary Huffman encoding of that character.
	 * @param c
	 * @return the code that the aim has.
	 * @throws ElementNotFoundException
	 */
	public String encode(char c) throws ElementNotFoundException {		
		Iterator<EncodingData> iterator = encodingList.iterator();
		while(iterator.hasNext()&&c!=(char)0) {
			EncodingData scan = iterator.next();
			if(scan.getSymbol() == c) {
				return scan.getEncoding();
			}
		}
		throw new ElementNotFoundException("");
	}
	/**
	 * This method will build the unordered list encodingList (an attribute of the HuffmanCoder class) 
	 * from the Huffman tree huffTree.
	 * 
	 * @param node
	 * @param encoding
	 */
	private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding) {
		if(node.isLeaf()) {
			encodingList.addToRear(new EncodingData(node.getElement().getCharacter(),encoding));
		}else {
			buildEncodingList(node.getLeft(), encoding+"0");
			buildEncodingList(node.getRight(), encoding+"1");
		}
	}

	/**
	 *  This method will return a string representation of the encoding list. 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		Iterator<EncodingData> iterator = encodingList.iterator();
		String result = "";
		while(iterator.hasNext()) {
			EncodingData scan = iterator.next();
			result += "["+scan.getSymbol()+": "+scan.getEncoding()+"]"+"\n";
		}
		return result;
	}
}
