import java.util.Iterator;

/**
 * This method write and represent a Huffman tree, which extends the LinkedBinaryTree<T> class, and also implement the Comparable interface. 
 * More precisely, extends LinkedBinaryTree<HuffmanPair>.
 * @author Mu He
 * @param <T>
 */

//Unsolved problem exists. 2.

public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree> {

	/**
	 * creates an empty Huffman tree, directly from superclass.
	 */
	public HuffmanTree() {
		super();
	}

	/**
	 * creates a Huffman tree which only has one root, a Huffman pair. Directly from superclass.
	 * @param element
	 */
	public HuffmanTree(HuffmanPair element) {
		super(element);
	}

	/**
	 * creates a Huffman tree rooted at a node containing element. 
	 * The roots of the left subtree and right subtree are its left child and right child respectively.
	 * @param element
	 * @param leftSubtree
	 * @param rightSubtree
	 */
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {
		super(element);
		super.getRoot().setLeft(leftSubtree.getRoot());
		super.getRoot().setRight(rightSubtree.getRoot());
	}

	/**
	 * Build the Huffman tree from this ordered list of Huffman pairs.
	 * @param pairsList
	 * 		an ordered list of Huffman pairs in ascending order by frequency
	 */
	public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList) {

			
		ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
		Iterator<HuffmanPair> iterator = pairsList.iterator();
			while (iterator.hasNext()) {
				buildList.add(new HuffmanTree(iterator.next()));
//				if(buildList.first().getRoot().getElement().getCharacter() == iterator.next().getCharacter())i++;
			}
//			if (i == buildList.size()) {
//				ArrayOrderedList<HuffmanTree> new_buildList = new ArrayOrderedList<HuffmanTree>();
//				new_buildList.add(buildList.first());
//				buildList = new_buildList;
//			}
//			else {	
			while (buildList.size() > 1) {
				HuffmanTree lefttree = buildList.removeFirst(); HuffmanTree righttree = buildList.removeFirst();
				//totalFre = the total weights of both trees.
				int totalFre = lefttree.getRoot().getElement().getFrequency() + righttree.getRoot().getElement().getFrequency();
				HuffmanPair root = new HuffmanPair(totalFre);
				buildList.add(new HuffmanTree(root, lefttree, righttree));
			}
		this.setRoot(buildList.first().getRoot());
	}

	/**
	 * This method will return a string representation of a Huffman tree by doing a preorder traversal of the tree.
	 * @see LinkedBinaryTree#toString()
	 */
	@Override
	public String toString() {
		Iterator<HuffmanPair> temp;
		String result = "";
		temp = super.iteratorPreOrder();
		while (temp.hasNext()) {
			result += temp.next().toString();
		}
		return result;
	}
	/**
	 * It will compare the frequencies in the root node of the trees.
	 * (so that the add method of ArrayOrderedList can put that node in its correct place in the ordered list buildList in the algorithm to build a Huffman tree. )
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(HuffmanTree otherTree) {
		return super.getRoot().getElement().getFrequency() - ((HuffmanPair) otherTree.getRoot().getElement()).getFrequency();
	}


}
