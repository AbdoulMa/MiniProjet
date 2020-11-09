import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleFormComponent } from './article-form/article-form.component';
import { ArticleFilterFormComponent} from './article-filter-form/article-filter-form.component';
const routes: Routes = [
  { path: 'articles', component: ArticleListComponent },
  { path: 'addarticle', component: ArticleFormComponent },
  { path: 'filterarticles', component: ArticleFilterFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
