console.log("Hello World!");

/**
 * PRIMITIVE DATATYPES
 * 
 * - boolean
 * - number
 * - string
 * - null
 * - undefined
 * 
 * REFERENCE DATATYPES
 * - objects
 * - arrays
 * - functions (it's an object)
 */

// How do we declare a variable in JS?
var num = 5; // the datatype of num is automatially inferred upon initialization
// Up UNTIL 2015, var was the only way to declare a variable

console.log(typeof(num)) // typeOf returns the string value of a pritmive type

var fruit = "apple";
console.log(typeof(fruit));
var vegetable = 'pumpkin';
console.log(typeof(vegetable));

// var allows global variables in which if a variable was declared OUTSIDE of a function, 
// you couldn't reuse that name within the function

// by default if you don't supply a keyword for intializing a variable it's declared with var;
animal = 'Tiger';

var x; // declaration
x = 9; // initialization

// In 2015 EcmaScript 6 was introduced - this is a standard of JavaScript which allowed a new
// way to declare variables

let firstName = 'Bob';
// since I declared name as LET, I can reassign the value
firstName = 'Steve';
firstName = 22; // because JavaScript is loosely and dyanmically typed! 

const tree = 'Willow';
// tree = 'pine'; // variables declared with CONST cannot be reassigned a value!!!!!

console.log(tree);

let z; // declared but not intilizaed
console.log(z); // returnes undefined (A DATA TYPE IN JAVASCRIPT)






