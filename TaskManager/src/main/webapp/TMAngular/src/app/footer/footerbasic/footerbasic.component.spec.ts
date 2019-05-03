import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterbasicComponent } from './footerbasic.component';

describe('FooterbasicComponent', () => {
  let component: FooterbasicComponent;
  let fixture: ComponentFixture<FooterbasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterbasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterbasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
