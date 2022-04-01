import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  text: string = 'contact page';
  contactForm: FormGroup; // alter this by changing line 8 of your ts.config to FALSE (turn off strict mode)

  contact = {
    name: '',
    email: '',
    text: ''
  }

  // change this value to tru e by triggering the onSubmit() method
  submitted: boolean = false;

  constructor() {
    this.createForm(); // when the class is instantiated it sets the CONTROLS! for the form groups
   }

  createForm(): void {
    // a FormGroup is an object containing data to alter an HTML form
    // we must use ATTRIBUTE binding on the form to apply this FormGroup
    this.contactForm = new FormGroup({
        'name': new FormControl(this.contact.name, [
            Validators.required, // there needs to be some text!
            Validators.minLength(4)
        ]),
        'email': new FormControl(this.contact.email, [
            Validators.required,
            Validators.email
        ]),
        'text': new FormControl(this.contact.text, Validators.required)
    });
}

  onSubmit(): void {
    this.submitted = true;
  }

}
