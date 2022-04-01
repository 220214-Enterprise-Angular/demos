import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  // Sanity test - does the component load?
  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Angular Unit Testing'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('Angular Unit Testing'); // testing the value of a property
  });

  it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Welcome to Angular Unit Testing');
  });
});

/**
 * What is BDD - Behavior Driven Development?
 * BDD is a subset of TDD - is an Agile software development methodoloyg in which an
 * application is documented and designed around the behavior a user EXPECTS to
 * experience when interacting with it.
 *
 * What is Jasmine? (Specification)
 * Jasmine is the testing framework where we call different methods and classes.
 *
 *
 * What is Karma? (Implementation)
 * Karma is a task runner - it's the mechanism that runs our tests
 * and prints the results to the the command line, and runs our tests
 * in the browser of our choice
 */
