import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Article} from './article'
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ArticleService {

  private articlesUrl : string;

  constructor(private  http: HttpClient) {
    this.articlesUrl = "http://localhost:8080/articles"
  }

  public findAll() : Observable<Article[]> {
    return this.http.get<Article[]> (this.articlesUrl);
  }

  public save(article : Article){
    return this.http.post<Article>(this.articlesUrl, article);
  }

}
