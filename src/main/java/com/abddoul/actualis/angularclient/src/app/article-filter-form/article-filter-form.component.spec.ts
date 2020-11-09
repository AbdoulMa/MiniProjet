import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleFilterFormComponent } from './article-filter-form.component';

describe('ArticleFilterFormComponent', () => {
  let component: ArticleFilterFormComponent;
  let fixture: ComponentFixture<ArticleFilterFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleFilterFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleFilterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
