console.log("In the functions script!!");


// 4 ways to declare a function in JavaScript

// 1. Classic Function declaration
function divide1(x, y) {
    return x/y;
}

// invoke the function
let x = 10;
let y = 2;

// store the return value of that function in variable called quotient
let quotient = divide1(x, y);
let anotherQuotient = divide1(100, 50);

console.log(x + ' divided by ' + y + ' is equal to ' + quotient);

// In ES6 - EcmaScript 6 (introduced in 2015), template literals were introduced
// template literals are created with backticks `` which are below your esc key in the top left 
console.log(`${x} divided by ${y} is equal to ${quotient}`);

