package com.abddoul.actualis;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActualisApplication {

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	public static void main(String[] args) {
		SpringApplication.run(ActualisApplication.class, args);
	}

	/**
	 * Initialisation du répertoire d'articles
	 * @param articleRepository
	 * @return
	 */
	@Bean
	CommandLineRunner init(ArticleJpaRepository articleRepository) {
		return args -> {
			JSONParser parser = new JSONParser();
			try {
	  			Object obj = parser.parse(new FileReader("./site_articles.json"));

	  			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
	  			JSONArray jsonArray = (JSONArray) obj;

	        Iterator<JSONObject> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				Article article = new Article(iterator.next());
				articleRepository.save(article);
			}
			
			// Test 
			// Tous les articles
			//articleRepository.findAll().forEach(System.out::println);
			
			// Articles entre deux dates de publications
			//articleRepository.findArticleBetweenDates(FORMATTER.parse("2010-01-01"),FORMATTER.parse("2020-01-01")).forEach(System.out::println);
			
		
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
			
		};
	}
}
