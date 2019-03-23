package SearchService.trie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Trie {
	
	static final int ALPHABET_SIZE = 26;
	private TrieNode root;
	private List<String> results = new ArrayList<String>(); 
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	public TrieNode getRoot() {
		return this.root;
	}
	
	public void clearList() {
		results.clear();
	}
	
	public List<String> getResults() {
		return this.results;
	}
	
	public void addWordToTrie(String word) {
		if(word.length() == 0)
			return;
		
		TrieNode pCrawl = new TrieNode(root);
		int index;
		
		for(int i = 0; i < word.length(); i++) {
			index = word.charAt(i) - 'a';
			if(pCrawl.next[index] == null)
				pCrawl.next[index] = new TrieNode();
			pCrawl = pCrawl.next[index];
		}
		
		pCrawl.setWordEnd(true);
	}
	
	public boolean searchWordInTrie(String word) {
		if(word.length() == 0)
			return false;
		
		TrieNode pCrawl = new TrieNode(root);
		int index;
		
		for(int i = 0; i < word.length(); i++) {
			index = word.charAt(i) - 'a';
			if(pCrawl.getNext()[index] == null)
				return false;
			pCrawl = pCrawl.next[index];
		}
		return pCrawl.isWordEnd();
	}
	
	public void searchSuggestionsRec(TrieNode root, String prefix) {
		if(root.isWordEnd() == true) 
			results.add(prefix);
		if(isLastNode(root))
			return;
		for(int i = 0;i < ALPHABET_SIZE; i++) {
			if(root.next[i] != null) {
				searchSuggestionsRec(root.next[i], prefix + (char)(97 + i));
			}
		}
	}
	
	private boolean isLastNode(TrieNode pcrawl) {
		for(int i = 0; i < ALPHABET_SIZE; i++) {
			if(pcrawl.next[i] != null)
				return false;
		}
		return true;
	}
	
	public TrieNode getPrefixNode(String prefix) throws NullPointerException {
		TrieNode pCrawl = new TrieNode(root);
		int index;
		for(int i = 0; i < prefix.length(); i++) {
			index = prefix.charAt(i) - 'a';
			pCrawl = pCrawl.getNext()[index];
		}
		return pCrawl;
	}

}