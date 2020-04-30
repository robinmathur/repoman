import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerformaComponent } from './proforma.component';

describe('PerformaComponent', () => {
  let component: PerformaComponent;
  let fixture: ComponentFixture<PerformaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerformaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerformaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
