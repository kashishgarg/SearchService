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
	
	public List<String> searchSuggestionsRec(TrieNode root, String prefix) {
		if(prefix.length() == 0 || isLastNode(root))
			return results;
		if(root.isWordEnd() == true) {
			results.add(prefix);
		}
		for(int i = 0;i < ALPHABET_SIZE; i++) {
			if(root.next[i] != null) {
				prefix = prefix + (char)(97 + i);
				searchSuggestionsRec(root.next[i], prefix);
			}
		}
		return results;
	}
	
	private boolean isLastNode(TrieNode pcrawl) {
		for(int i = 0; i < ALPHABET_SIZE; i++) {
			if(pcrawl.next[i] != null)
				return false;
		}
		return true;
	}

}