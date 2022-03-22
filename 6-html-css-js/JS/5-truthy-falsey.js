/**
 * JS has a special way of coercing all different types to a boolean value opf either true or false
 * 
 * There are only 6 Falsey values and everything else is truthy
 * 
 * - 0
 * - null
 * - empty string
 * - false
 * - NaN
 * - undefined
 * 
 * !! checks for a variable's truthy/falsey value
 */

// this function is fully hoisted (meaning even i fit's declared at the bottom of the file, 
// it's treated as if it's the first line
function checkTruthy(input) {

    console.log(`
        input is ${input} and is of type ${typeof(input)}
        It has a truthy value of ${!!input}
    `);

}

let myName = ''; // is myName truthy or falsey?
console.log(!!myName); // returns false because it's an empty string

let username = 'spongebob';
let age = 0;

checkTruthy(age); // falsey
checkTruthy([]); // truthy .. because EVERYTHING except the 6 values above are truthy
checkTruthy('apple' * 14); // NaN - falsey

let emptyArr = [];
checkTruthy(emptyArr); // true
checkTruthy(emptyArr.length); // false because its length is 0 and 0 is a falsey value

let l = [3, 4, 5].length; // would return 3


