function doSomething() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }

    // Var is NOT block scoped! We can access it outside the loop
    console.log(i); 
}

doSomething();
