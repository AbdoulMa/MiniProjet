import { Component, OnInit } from '@angular/core';
import {registerLocaleData,DatePipe} from '@angular/common';
import localeFr from  '@angular/common/locales/fr';
registerLocaleData(localeFr,'fr')
import {Article} from '../article'
import {ArticleService} from '../article.service'

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  pipe : DatePipe;
  articles : Article [];

  constructor(private articleService : ArticleService) {
    this.pipe = new DatePipe('fr-FR'); // Date en français
  }

  ngOnInit(): void {
    this.articleService.findAll().subscribe( data => {
      this.articles = data;
    });
  }

}
