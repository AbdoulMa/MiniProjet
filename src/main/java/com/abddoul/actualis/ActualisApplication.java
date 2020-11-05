package com.abddoul.actualis;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActualisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActualisApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ArticleRepository articleRepository) {
		return args -> {
			JSONParser parser = new JSONParser();
			try {

	  			Object obj = parser.parse(new FileReader("./site_articles.json"));

	  			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
	  			JSONArray jsonArray = (JSONArray) obj;

	        // System.out.println(jsonArray);
	        Iterator<JSONObject> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				Article article = new Article(iterator.next());
				articleRepository.save(article);
			}
			articleRepository.findAll().forEach(System.out::println);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
			
		};
	}
}
