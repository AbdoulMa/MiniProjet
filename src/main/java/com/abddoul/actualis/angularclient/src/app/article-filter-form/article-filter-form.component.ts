import { Component} from '@angular/core';
import { FormsModule,ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import {registerLocaleData,DatePipe} from '@angular/common';
import localeFr from  '@angular/common/locales/fr';
registerLocaleData(localeFr,'fr')
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from '../article.service';
import { Article } from '../article';

@Component({
  selector: 'app-article-filter-form',
  templateUrl: './article-filter-form.component.html',
  styleUrls: ['../article-list/article-list.component.css','./article-filter-form.component.css']
})
export class ArticleFilterFormComponent  {

  pipe : DatePipe;
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

        this.pipe = new DatePipe('fr-FR'); // Date en français
       }

       onSubmit() {
        this.articleService.getFilteredArticles(this.filterForm.get('dateDebut').value, this.filterForm.get('dateFin').value, this.filterForm.get('regions').value, this.filterForm.get('secteurs').value).subscribe( data => {
          this.articles = data;
          this.gotoArticlesList();
        });
       }

       gotoArticlesList() {
            this.router.navigate(['/filterarticles']);
       }




}
