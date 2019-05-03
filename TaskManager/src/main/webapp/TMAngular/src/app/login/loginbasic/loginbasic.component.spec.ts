import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginbasicComponent } from './loginbasic.component';

describe('LoginbasicComponent', () => {
  let component: LoginbasicComponent;
  let fixture: ComponentFixture<LoginbasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginbasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginbasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
