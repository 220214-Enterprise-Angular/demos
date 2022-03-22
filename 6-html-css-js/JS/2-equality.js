/**
 * = is an assignment operator (let x = 9)
 * 
 * == compares an object on either side's VALUE but performs something called TYPE COERSION
 * 
 * === compares both value AND type on either side of the ===
 */

// this will return true or false
console.log(2 == '2'); // is the number 2 == to the string 2 - TRUE
console.log(2 === '2'); // is the number 2 === to the string 2 (in both value AND type) FALSE

// build a function that takes in two parameters and tests their equality for both == & ===

function compare(first, second) {

    console.log(`
    
        first param = ${first}, and is of type ${typeof(first)}
        second param = ${second}, and is of type ${typeof(second)}

        Is first == second? : ${first == second}
        Is first === second? : ${first === second} 
    `);
}

// invoke the compare() method on different values to test their equality
compare(2, '2');
compare("two", '2') // you can declare strings with ''. "", or ``
compare({}, {}); // 2 empty objects - FALSE in JS, 2 empty objects DO NOT have the same value
compare([], null);

let somethingInteresting = 'bob' * 10;
console.log(somethingInteresting); // returns NaN (not a Number)

// what is the Global Object?
// in the browser the  global object refers to the window
// in Node, we don't have a windows, so the global is just the global object

