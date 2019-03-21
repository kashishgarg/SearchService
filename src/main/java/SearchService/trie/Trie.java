package SearchService.trie;

import org.springframework.stereotype.Component;

@Component
public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
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

}