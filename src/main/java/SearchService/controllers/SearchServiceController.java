package SearchService.controllers;

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
	
}