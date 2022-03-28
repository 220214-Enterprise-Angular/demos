/**
 * Counting different things 
 * birds
 * cars
 * 10+ things
 * tc
 */


//Solve the issue of sharing a global variable with CLOSURE
// Closure is JS's way of encapsulation


let count = 0;
function countCar() {

    return 'Car count is: ' + ++count;
}

console.log(countCar());
console.log(countCar());

// function countApples() {
//     return `Apple count is ` + ++count; // won't work!
// }


function makeCounter(noun) {


    let count = 0;

    function countNoun() 
    {
        return noun + ' count is ' + ++count;
    }

    return countNoun;

}

makeCounter('apples');



