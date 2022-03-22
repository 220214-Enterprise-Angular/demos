/**
 * JavaScript Exceution Context
 * 
 * Everytime a JS engine executes a script, an Executoin Context is built
 * 
 * 2 phases: creation, execution
 * 
 * CREATION PHASE (STEP 1)
 * 1. Create the Global Object -> in browser that's the window, in Node it's the global object
 *
 * 2. Bind "this" to the Global Object
 * 
 * 3. Setup a memory heap for storing variable and function references.
 *
 *  4. Store function declarations in the memory heap and store variable
 * (within the global execution context as undefined)
 * 
 * 
 * EXECUTION PHASE (STEP 2)
 * 
 * JavaScript executes code line by line. 
 * In this phase it assigns values to variables and executes function calls like funScope() or console.log()
 * 
 * During execution phase,. variable hoisting (and function hoisting occurs)
 */

let c = 'Cat'; // during the creation phase, c is undefined (declared but not initalize)

// in phase 2, EXECUTION phase
let sum = add(90, 2);
console.log(sum);

console.log(a); // this is invoked during the execution phase - it will search for a
var a = "apple"; // during the creation phase "a" is decalred but not initialized

// variables declared with let & const are NOT hoisted meaning that they're not declared during
// console.log(b); // the creation phase -- this won't work
// let b = 'banana'; 

// RESEARCH: What is hoisting?

let sillyStr = '1' + 1; // this is 11
console.log(typeof(sillyStr)); // string



// console.log(subtract(10,2)); // this won't work, has to be below the function

// this function is HOISTED...since it's declared on the global object, it's beheavior
// is stored in memeory during the creation pahse (phase 1)...
function add(x, y) {
    return x + y;
}

// this can't be invoked in lines ABOVE its declaration, becuase we're assigning it to a variable!
// and variable are intialized in the second phase
const subtract = (x, y) => {

    return x - y;
}


