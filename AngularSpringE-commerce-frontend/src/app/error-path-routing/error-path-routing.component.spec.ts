import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorPathRoutingComponent } from './error-path-routing.component';

describe('ErrorPathRoutingComponent', () => {
  let component: ErrorPathRoutingComponent;
  let fixture: ComponentFixture<ErrorPathRoutingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ErrorPathRoutingComponent]
    });
    fixture = TestBed.createComponent(ErrorPathRoutingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
