let scores = new Array(10); // instantiating an Array object by passing a length of 10 to the constrcutor

console.log(scores);
//              0       1       2
let colors = ['red', 'blue', 'green'];
console.log(colors);

// accessing elements within the array
console.log(colors[1]) // return the second element ('blue')
// reassign the value of an element at the 2 index (3rd element\)
colors[2] = 'purple';
console.log(colors);

let size = colors.length; // grabs the # of elements in the array;

// JS arrays are dyanmic - we can change the size as we pleaseand add/remove element
colors.push('yellow');
console.log(colors);

// remove an element
colors.pop(colors); // removes the last elelemtn
console.log(colors); // removes the element at the end of the array (yellow)

// to remove the FIRST element you use shift()
colors.shift(); // removes the first element ('red')
console.log(colors);

// capture the index
console.log(colors.indexOf('purple')) // returns the index of purple
// returns -1 if it doesn't exist;

// declare some variables
let a = "ten";
let b = 10;
let c = true;
let d = {};
let e = null;
let f = '';
let g = 0;
let h = [];
let i = function(){} // assigning the variable i to an anonymous function

// build an array called list and add all the variables to it
const list = [a, b, c, d, e, f, g, h, i]; // arrays in JS can hold multiple different types

// iterate over it in 3 different ways
for (let j=0; j<list.length; j++) { //          == BASIC FOR LOOP ===

    console.log(list[j]) // print the element at the index of j
}

console.log('------------------------------------------------------')

//                                              == FOR IN LOOP ===
// returns the index of each element in the list
for (let elIndex in list) {
    console.log(list[elIndex])
}

console.log('------------------------------------------------------')

//                                              == FOR OF LOOP ==
// returns the actual element ( no need for the index) - similar to enhanced for-loop
for (let el of list) {
    console.log(el);
}

console.log('------------------------------------------------------')

// forEach() method
list.forEach(x => {
    console.log(x)
})

list.forEach(x => console.log(x))

// callback functions