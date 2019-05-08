import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeelistviewComponent } from './employeelistview.component';

describe('EmployeelistviewComponent', () => {
  let component: EmployeelistviewComponent;
  let fixture: ComponentFixture<EmployeelistviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeelistviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeelistviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
