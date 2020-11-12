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
/**
 * Application principale
 * @author root
 *
 */
@SpringBootApplication
public class ActualisApplication {

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

	public static void main(String[] args) {
		SpringApplication.run(ActualisApplication.class, args);
	}

	/**
	 * Initialisation du répertoire d'articles
	 * 
	 * @param articleRepository
	 * @return
	 */
	@Bean
	CommandLineRunner init(ArticleJpaRepository articleRepository) {
		return args -> {
			JSONParser parser = new JSONParser();
			// Chargement des articles du fichier json 
			try {
				Object obj = parser.parse(new FileReader("./site_articles.json"));

				JSONArray jsonArray = (JSONArray) obj;

				Iterator<JSONObject> iterator = jsonArray.iterator();
				while (iterator.hasNext()) {
					Article article = new Article(iterator.next());
					articleRepository.save(article);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		};
	}
}
