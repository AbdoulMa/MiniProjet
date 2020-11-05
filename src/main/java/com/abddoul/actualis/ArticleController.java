package com.abddoul.actualis;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

	private final ArticleRepository articleRepository;
	
	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	@GetMapping("/articles")
	public List<Article> getArticles(){
		return (List<Article>) articleRepository.findAll();
	}
	
	
	
	
}
