package SearchService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SearchService.service.SearchService;

@RestController
public class SearchServiceController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/search/{searchKeyword}", method=RequestMethod.GET)
	public boolean searchOptions(@PathVariable("searchKeyword") String searchKeyword) {
		
		return searchService.searchSuggestions(searchKeyword);
	}
	
	@RequestMapping(value="/suggestions/{prefix}", method=RequestMethod.GET)
	public List<String> giveSuggestions(@PathVariable("prefix") String prefix) {
		return searchService.giveSuggestions(prefix);
	}
	
}