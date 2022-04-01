import { BrowserModule, By} from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ContactComponent } from './contact.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// we define a test suite with the describe keyword
describe('ContactComponent', () => {
  let component: ContactComponent;
  let fixture: ComponentFixture<ContactComponent>;
  let de: DebugElement; // Using Debug Element , you can query the dom for further tests
  let el: HTMLElement; // to store elements that we query with DebugElement

  beforeEach(async () => {
    await TestBed.configureTestingModule({ // this configures the environemnt for the class we want to test
      declarations: [ ContactComponent ],
      imports: [ // since we're testing this INDIVIDUAL component, we need the declare the modules it needs
          BrowserModule,
          FormsModule,
          ReactiveFormsModule
      ]
    })
    // after we've compiled our components, initialize our variables to test
    .compileComponents().then(() => {
      fixture = TestBed.createComponent(ContactComponent);
      component = fixture.componentInstance; // ContactComponent test instance

      // we are testing the behavior of the FORM
      de = fixture.debugElement.query(By.css('form'))
      el = de.nativeElement; // saving the queried form element to our el variable

    });
  });

  // Snity test is fine! keep it - just checking that the compinent is created
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // we use waitForAsync() because we need to wait for the code to compile and the component to set up
  it('should set submitted to true', waitForAsync(() => {
    // what is it?
    component.onSubmit(); // WHEN this....
    expect(component.submitted).toBeTruthy();  // EXPECT THIS (comes from Jasmine (testing framework))
  }))

  it(`should have as text 'contact-page'`, waitForAsync(() => {

    // testing that the text property of the component is equals to this string value
    expect(component.text).toEqual('contact page')

  }))

  // test for valid and invalid forms:L

  // test for valid input fields
  it(`form should be valid`, waitForAsync(() => {

    component.contactForm.controls['email'].setValue('asdf@mail.com'); // this is a VALID email
    // i need to set the value of the REST of the contact form input fields
    component.contactForm.controls['name'].setValue('asdfg');  // this is VALID // we have a vlaidator set for
    component.contactForm.controls['text'].setValue('asdf'); // this is VALID

    expect(component.contactForm.valid).toBeTruthy();
  }))

  // test for invalid input fields
  it(`form should be invalid`, waitForAsync(() => {

    component.contactForm.controls['email'].setValue('bobmail'); // no @ or . , violates validator
    component.contactForm.controls['name'].setValue('bob'); // less than 4 characters, violates validator
    component.contactForm.controls['text'].setValue(''); // empty string violated require validator

    expect(component.contactForm.valid).toBeFalsy();
  }))
});
