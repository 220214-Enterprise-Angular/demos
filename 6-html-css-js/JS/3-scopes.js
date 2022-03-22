/**
 * 4 Main Scopes in JS
 *
 * 1. Global - variables declared are accesible from ANYWHERE in the application
 * 2. Functional/Local - variables declared within the function are ONLY accessible within the function
 * 3. Block Scope - anything in between {} (think of a for-loop)
 * 4. Lexical Scope - when you nest functions within eachother with a process called CLOSURE
 */

// variables decalred with VAR are by default GLOBAL
// variables declared with LET or CONST are BLOCK SCOPED

var foo = "Foo"; // he we have declared a global variable
let bar = "Bar"; // let & const prevent globally scoping variables

// we can access global varibales by calling them from the window object (when we call window in Node it is just the glboal objects)
// in order for this to work you need to run it in the browser
// console.log(window.foo); // this return "Foo"
// console.log(window.bar); // this returns undefined because Const and Let can't be globally scoped to the window object

// can I INVOKE the function on a line before its declaration YES, thanks to hoisting
funScope();

function funScope() {
  // you cannot access variable declared within a function outside of the function!
  var d = "dog"; // functioanl scope
  const c = "cat"; // functional scope
  console.log(c);

  let x = "xylophone";

  if (true) {
    console.log(x);
    if (true) {
      const r = "racoon";
      if (true) {
        console.log(r);
      }
    }
  }
  // console.log(r); // because I can't access a nested variable inside of a block scope
}

// I can't access c within the functional scope
//console.log(c); // c is not defined
// console.log(d); // d is not defined
