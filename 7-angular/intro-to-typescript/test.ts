function doSomething() {

    for (let i=0; i<5; i++) {
        console.log(i);
    }

    // The TypeScript compiler will inform us of unreachable code.
    console.log(i); // TSC will still transpile this code to ES5 (not 6), which is old gen code
}

doSomething();
