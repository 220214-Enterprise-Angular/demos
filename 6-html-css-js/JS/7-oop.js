// Object Oriented programming in JS
// it wasn't until ES6 that JavaScript introduced Classes

// Computer object

// Constructor function  (old school way of defining classes with JS before ES6)
function Computer(compName,  ramSizeGb, cpuCores, cpuSpeedGhz) {

    this.compName = compName;
    this.ramSizeGb = ramSizeGb;
    this.cpuCores = cpuCores;
    this.cpuSpeedGhz = cpuSpeedGhz;

    // a method is a function that belongs to a Class 
    this.printSpecs = function() {
        console.log(`This computer is named ${compName}.  It has  ${ramSizeGb} GB RAM.`)
    } // no return statement!

}

// The new keywor  creates a new empty object then fills out the properties according to the Computer function.
let myComputer = new Computer("MyPC", 4, 4, 4.2);
myComputer.printSpecs();


// in  ES6 the class keyword was introduced
class Animal {

    constructor(name, species) {
        this.name = name;
        this.species = species;
    }

    sing() {
        return `${this.name} can sing`;
    }

    dance() {
        return `${this.name} can dance`;
    }
}

let bingo = new Animal('Bingo', 'Dog');
console.log(bingo)

console.log(bingo.dance());

