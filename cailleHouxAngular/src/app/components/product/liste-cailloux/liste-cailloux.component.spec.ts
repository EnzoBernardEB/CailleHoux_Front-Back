import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeCaillouxComponent } from './liste-cailloux.component';

describe('ListeCaillouxComponent', () => {
  let component: ListeCaillouxComponent;
  let fixture: ComponentFixture<ListeCaillouxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeCaillouxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeCaillouxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
