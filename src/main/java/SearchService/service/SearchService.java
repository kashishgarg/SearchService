package SearchService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SearchService.exception.InvalidPrefixException;
import SearchService.trie.Trie;
import SearchService.trie.TrieBuilder;
import SearchService.trie.TrieNode;

@Service
public class SearchService {
	
	@Autowired
	TrieBuilder trieBuilder;
	@Autowired
	Trie trie;
	public boolean searchSuggestions(String key) {
		return trieBuilder.getTrie().searchWordInTrie(key);
	}
	
	public List<String> giveSuggestions(String prefix) {
		Trie trie = trieBuilder.getTrie();
		trie.clearList();
		try {
			TrieNode node = trie.getPrefixNode(prefix);
			trie.searchSuggestionsRec(node, prefix);
		}
		catch(Exception e) {
			throw new InvalidPrefixException();
		}	
		
		return trie.getResults();
	}

}