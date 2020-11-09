import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import {Article} from './article'
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ArticleService {

  private articlesUrl : string;
  private filteredArticlesUrl : string;

  constructor(private  http: HttpClient) {
    this.articlesUrl = "http://localhost:8080/articles"
    this.filteredArticlesUrl = "http://localhost:8080/articles/filtres"
    // this.filteredArticlesUrl = "http://localhost:8080/articles/filtres?beginDate=2019-01-01&endDate=null&regionName=bourgo&secteur=null"
  }

  public findAll() : Observable<Article[]> {
    return this.http.get<Article[]> (this.articlesUrl);
  }

  public save(article : Article){
    return this.http.post<Article>(this.articlesUrl, article);
  }

  public getFilteredArticles(beginDate : string, endDate :  string, region : string , secteur : string  ) :  Observable<Article[]>  {
    let params = new HttpParams();
   params = params.set('beginDate', beginDate);
   params = params.set('endDate', endDate);
   params = params.set('regionName', region);
   params = params.set('secteur', secteur);
    return this.http.get<Article[]>(this.filteredArticlesUrl, {params: params});
   // return this.http.post<Article>(this.articlesUrl,"beginDate=2019-01-01&endDate=null&regionName=bourgo&secteur=null");
  }

}
