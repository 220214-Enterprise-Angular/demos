var count = 5; // we have implicitly set the type of the variable cont to a number!
// count = 'apples'; // our compiler doens't allow this

/** TS is STATICALLY TYPED - you cannot reassigne a variable of a different type */

let x = 10; // we are implying a number type

// declare & intialization
let a: number; // declare the variable and its type
a = 100;// initialize it here
a = 1000; // we can reassign no problem
// a = 'apples'; // can't do this!

let b: boolean = true; // full intiialization (declaring type AND value)
let c: string = 'kiwi';
let d: any = 'dog';
d = 400; // we can reassing the value because its type is any
let e: any[] = ['one', 1, false, c];
let f: number[] = [10, 20, 30 , 40];

console.log(e[2]); // returns the boolean value false

let numString = "32";
let numNum: number = +x; // the + infront converts string to number type

// Enums allow use to define a named constant
enum Color {"red", "blue", "green"} // when we transpile this will look weird
let backgroundColor = Color.blue;


