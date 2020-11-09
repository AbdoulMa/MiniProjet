import { Component} from '@angular/core';
import { FormsModule,ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from '../article.service';
import { Article } from '../article';

@Component({
  selector: 'app-article-filter-form',
  templateUrl: './article-filter-form.component.html',
  styleUrls: ['./article-filter-form.component.css']
})
export class ArticleFilterFormComponent  {

  articles : Article [] ;
  dateDebut : FormControl;
  dateFin : FormControl;
  region : FormControl;
  secteurs : FormControl;
  filterForm : FormGroup;

  constructor(private route: ActivatedRoute,
    private router: Router,
      private articleService: ArticleService) {
        this.filterForm = new FormGroup({
          dateDebut : new FormControl(),
          dateFin : new FormControl(),
          regions : new FormControl(),
          secteurs : new FormControl()
        });
       }

       onSubmit() {
         // this.articleService.getFilteredArticles().subscribe(result => this.gotoUserList());
         alert(this.filterForm.get('dateDebut').value);
         alert(this.filterForm.get('dateFin').value);
        this.articleService.getFilteredArticles(this.filterForm.get('dateDebut').value, this.filterForm.get('dateFin').value, this.filterForm.get('regions').value, this.filterForm.get('secteurs').value).subscribe( data => {
          this.articles = data;
          this.gotoArticlesList();
        });
       }

       gotoArticlesList() {
            this.router.navigate(['/filterarticles']);
       }




}
