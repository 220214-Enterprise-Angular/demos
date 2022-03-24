var count = 5; // we have implicitly set the type of the variable cont to a number!
// count = 'apples'; // our compiler doens't allow this
/** TS is STATICALLY TYPED - you cannot reassigne a variable of a different type */
var x = 10; // we are implying a number type
// declare & intialization
var a; // declare the variable and its type
a = 100; // initialize it here
a = 1000; // we can reassign no problem
// a = 'apples'; // can't do this!
var b = true; // full intiialization (declaring type AND value)
var c = 'kiwi';
var d = 'dog';
d = 400; // we can reassing the value because its type is any
var e = ['one', 1, false, c];
var f = [10, 20, 30, 40];
console.log(e[2]); // returns the boolean value false
var numString = "32";
var numNum = +x; // the + infront converts string to number type
// Enums allow use to define a named constant
var Color;
(function (Color) {
    Color[Color["red"] = 0] = "red";
    Color[Color["blue"] = 1] = "blue";
    Color[Color["green"] = 2] = "green";
})(Color || (Color = {})); // when we transpile this will look weird
var backgroundColor = Color.blue;
