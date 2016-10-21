# Chapter 2: Functions
As stated in the last chapter, Clojure has 4 key literal collections:
 * Vector []
 * Map {}
 * Set #{}
 * List ()
 
The first three are common in data modeling, but list is different. 
When Clojure encounters a list, it resolves the first item in the list to a
function, special form, or macro and then calls that item with the remainder of the
list as arguments.

Armed with that knowledge, consider the following code, both of which call a predefined add function:
```clojure
(add 1 2) ;Clojure
```

```java
add(1, 2); //Java
```

Q. Since Clojure is hosted on the JVM, are these equivalent? In other words, 
is this code identical save for the relocation of the parenthesis in the Clojure code?

A. Yes and No. Yes, both call the add function with the arguments 1 and 2, but the
Clojure form can also be thought of as a list containing a symbol (add) and two values (1 and 2).

In this light, consider the following function definition in Clojure:
```clojure
(defn add [a b] (+ a b))
```

You can view the above in two ways:
* A function definition (add) with two arguments (a and b) that returns the sum of the arguments.
* A list with the following contents:
  * defn
  * add, a symbol that is being defined
  * a vector containing two symbols (a and b)
  * a list 

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

Notice that there isn't any way to actually use the functions we've just defined.
They're just abstract functions that get dropped into the ether. So, knowing
what we do of our first two examples we can combine them into a single function.
```clojure
;Define the symbol add to be the following fn.
(def add (fn [x y] (+ x y)))
```