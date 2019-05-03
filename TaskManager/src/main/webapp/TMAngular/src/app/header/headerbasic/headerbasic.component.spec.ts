import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderbasicComponent } from './headerbasic.component';

describe('HeaderbasicComponent', () => {
  let component: HeaderbasicComponent;
  let fixture: ComponentFixture<HeaderbasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderbasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderbasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
