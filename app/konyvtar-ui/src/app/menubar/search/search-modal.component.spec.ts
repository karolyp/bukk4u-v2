import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchModalComponentComponent } from './search-modal-component.component';

describe('SearchModalComponentComponent', () => {
  let component: SearchModalComponentComponent;
  let fixture: ComponentFixture<SearchModalComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchModalComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchModalComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
