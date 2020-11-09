package com.abddoul.actualis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur 
 * @author root
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	private final ArticleJpaRepository articleRepository;

	public ArticleController(ArticleJpaRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	/**
	 * Méthodes qui retournes tous les articles
	 * @return 	liste d'articles
	 */
	@GetMapping("/articles")
	public List<Article> getArticles() {
		return (List<Article>) articleRepository.findAll();
	}
	
	/**
	 * Méthode d'ajout d'un article
	 * @param user
	 */
	   @PostMapping("/articles")
	    void addUser(@RequestBody Article article) {
	        articleRepository.save(article);
	    }

	/**
	 * Méthode de recherche par critères
	 * 
	 * @param begin       date de début
	 * @param end         date de fin
	 * @param regionName  nom de région
	 * @param secteurName nom de secteur
	 * @return listes des articles repondant au critères
	 */
	@RequestMapping(value ="/articles/filtres", method = RequestMethod.GET)
	public List<Article> getArticlesByCriterions(@RequestParam("beginDate") final String begin,
			@RequestParam("endDate") final String end, @RequestParam("regionName") final String regionName,
			@RequestParam("secteur") final String secteurName) {
		List<Article> res = this.getArticles();
		try {
			Date beginDate = begin.equals("null") ? FORMATTER.parse("2000-01-01") : FORMATTER.parse(begin);
			Date endDate = end.equals("null") ? new Date() : FORMATTER.parse(end);
			res = articleRepository.findArticlesByCriterions(beginDate, endDate, regionName, secteurName);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}

}
