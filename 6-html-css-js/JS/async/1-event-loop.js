function task(message) {

    // emulate some time consuming task
    let n = 10000000000;

    while (n > 0) {
        n--;
    }

    // when the loop finishes, we print out the message
    console.log(message);
}

// console.log('Start script!');
// task('Download complete'); // I have to wait for this to complete before the following code can run!
// console.log('Script done!');

// Callbacks to the rescue!
// an asynchronous function built into the browser
// console.log('Starting Script') // 1. 

// setTimeout(() => { // 2. 
//     task('Download complete')
// }, 1000); // takes in a callback and the amount of time to wait before completing it

// // ^ says wait 1000 miliseconds before exceuting the task() function

// console.log('Script done!'); // 3.


console.log('Hi');

setTimeout(() => { // the Event Loop identifies this as a callback and now by default we MUST wait until the call stack is
                  // empty for this run 
    // function to run
    console.log('Execute immediately!!!')
}, 0)

console.log('Bye')