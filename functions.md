# Chapter 2: Functions

The first function we'll discuss is def. def *defines* a symbol.
```clojure
(def x) ;Define the symbol x. You typically will not do this.
(def x 4) ;Define the symbol x and bind it to the value 4. This is the common approach.
```

The next function we'll discuss is fn. fn creates a function.
```clojure
(fn [x y] (+ x y)) ;A function that adds two values together.
(fn add [x y] (+ x y))  ;Same as above, but names the function.
```
