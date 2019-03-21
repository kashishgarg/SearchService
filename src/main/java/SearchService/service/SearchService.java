package SearchService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SearchService.trie.TrieBuilder;

@Service
public class SearchService {
	
	@Autowired
	TrieBuilder trieBuilder;
	
	public boolean searchSuggestions(String key) {
		return trieBuilder.getTrie().searchWordInTrie(key);
	}

}