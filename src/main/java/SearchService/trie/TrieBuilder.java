package SearchService.trie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class TrieBuilder {
	
	static final String FILE_PATH = "/static/words.txt";
	
	private FileReader fr;
	private BufferedReader br;
	private String str;
	
	
	private Trie trie;
	
	@Autowired
	public TrieBuilder(Trie trie) {
		this.trie = trie;
		addWordsToTrie();
	}
	
	public Trie getTrie() {
		return trie;
	}
	
	public void addWordsToTrie() {
		
			InputStream inputStream=null;
			try {
				ClassPathResource resource = new ClassPathResource("/SearchService/list.txt");
				inputStream = resource.getInputStream();
				InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader);
				while((str = reader.readLine()) != null) {
					String st = str.replaceAll("[^a-z]", "").trim();
					System.out.println(st);
					trie.addWordToTrie(st);
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Adding words to trie");
//			String[] words = {"and", "port", "and", "joke", "an"};
//			for(int i = 0; i < words.length; i++) {
//				String st = words[i].replaceAll("[^a-z]", "").trim();
//				trie.addWordToTrie(st);
//			}
	}
	
}