package SearchService.trie;

public class TrieNode {
	
	static final int ALPHABET_SIZE = 26;
	
	public TrieNode next[];
	private boolean isWordEnd;
	
	public TrieNode() {
		this.next = new TrieNode[ALPHABET_SIZE];
		this.isWordEnd = false;
	}
	
	public TrieNode(TrieNode another) {
		this.next = another.next;
		this.isWordEnd = another.isWordEnd;
	}

	public TrieNode[] getNext() {
		return next;
	}
	
	public void setNext(TrieNode[] next) {
		this.next = next;
	}

	public boolean isWordEnd() {
		return isWordEnd;
	}

	public void setWordEnd(boolean isWordEnd) {
		this.isWordEnd = isWordEnd;
	}
	
	

}
