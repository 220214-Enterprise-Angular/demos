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


// 2. Function expression - assign an anonymous function to a variable
const divide2 = function(x, y) {
    return x/y;
}

let num1 = 20;
let num2 = 4;

// console log the quotient of divide2(num1, num2);
console.log(divide2(num1, num2));

console.log(divide2(0, 10));

if (num1 > 0 && num2 > 0) {

    console.log(divide2(num1, num2));

} else {
    console.warn('You cannot divide by 0!');
}

// 3. Arrow Function Expression (introduced in ES6 EcmaScript 6)
const divide3 = (x, y) => {
    return x/y;
}

// 4. Concise Arrow Function Expression (using arrow functions introduced in ES6)
const divide4 = (x, y) => x/y;