/**
 * The THIS keyword
 * 
 * In JavaScript, "this" refers to the object that it belongs to
 * 
 * - alone, it refers to the global object
 * - in a FUNCTION, this still refers to the global object
 * - in a METHOD, this refers to the owner object (rememebr that a method is function that belongs to the object)
 * - in `strict mode` "this" in a function returns undefined
 */
// 'use strict' // (introduced in ES5)

this.x = 10; // by default this has been declared with "var" keyword
this.dog = 'Larry';

console.log(this); // reutrns the global object in Node {}

function foo() {

    console.log(this); // reutnrs undefined in strict mode

}

foo();

console.log(this.dog)

// obj literal
const person = {

    firstName : 'Bob',
    lastName : 'Smith',
    id : '1234',
    sayFullName: function() {
        return this.firstName; // this refers to the property of this object
    }
}

