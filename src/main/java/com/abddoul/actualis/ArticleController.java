package com.abddoul.actualis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	private final ArticleJpaRepository articleRepository;
	
	public ArticleController(ArticleJpaRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@GetMapping("/articles")
	public List<Article> getArticles(){
		return (List<Article>) articleRepository.findAll();
	}
	
	@PostMapping("/articles")
	public List<Article> getArticlesByCriterions(@RequestParam("beginDate") final String begin,@RequestParam("endDate") final String end, @RequestParam("regionName") final String regionName, @RequestParam("secteur") final String secteurName){
		List<Article> res = this.getArticles();
		try {
			Date beginDate = begin.equals("null") ? FORMATTER.parse("2000-01-01") : FORMATTER.parse(begin);
			Date endDate = end.equals("null") ? new Date() : FORMATTER.parse(end);
			res = articleRepository.findArticlesByCriterions(beginDate,endDate, regionName, secteurName);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
