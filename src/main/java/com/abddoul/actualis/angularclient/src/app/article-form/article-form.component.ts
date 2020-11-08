import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from '../article.service';
import { Article } from '../article';

@Component({
  selector: 'app-article-form',
  templateUrl: './article-form.component.html',
  styleUrls: ['./article-form.component.css']
})
export class ArticleFormComponent  {

  article : Article;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private articleService: ArticleService) {
           this.article = new Article();
         }

     onSubmit() {
	    this.articleService.save(this.article).subscribe(result => this.gotoUserList());
	  }


    gotoUserList() {
    	    this.router.navigate(['/articles']);
    	  }

}
