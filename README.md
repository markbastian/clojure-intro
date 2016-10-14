Note: Check out [klipse](https://github.com/viebel/klipse)

# Tutorial 1: Clojure is a Data Centric Language
There are a lot of ways to look at the Clojure language. Some of the points often made
about it are that it is:
* Hosted
  * On the JVM as Clojure
  * On JavaScript runtimes as ClojureScript
  * On the CLR as .cljr files.
* Functional as opposed to Object-Oriented
* A Lisp
* Fun. Clojure developers are the [happiest](http://www.itworld.com/article/2693998/big-data/clojure-developers-are-the-happiest-developers.html)
* Data Oriented

In this series, I am going to take the data-oriented/data-first approach to Clojure. 
I think this is a less common approach, but has some major selling points:
 * Provides an easy introduction to what is often considered a hard language
 * Provides a fast path to productivity, especially if the task is data-centric
 * Helps developers understand idioms for creating Clojure programs
 
For this tutorial, there will be no code in the traditional sense. We will only be
looking at Clojure as data. Let's jump in...

## Clojure is data
Clojure's basic collections have a *literal syntax*. In other words, Clojure is written
exactly as it is evaluated. In most languages, primitives are evaluated literally.
For example, 5 is interpreted by the compiler as the number 5 and "ABC" is interpreted 
as the string "ABC". Generally, once you go beyond primitives this is no longer the case.

### Basic Types
The following basic primitives are present in Clojure:
* Strings
* Numbers
  * Double
  * Long
  * Ratio (Clojure only): 22/7
* Characters: Note that in ClojureScript there are no characters. Instead, strings are
converted to sequences of strings of length 1.
* Booleans
* nil

### Collections are Literal Data
In addition to the above primitives the following data structures are also treated literally.
##### Vector
```clojure
[] ;An empty vector
[1 2 3 4 5 6]
```

A Clojure vector is an array-like object with the following properties:
* Fast lookup by index
* Efficient tail addition and removal

##### Map
```clojure
{}
{ :name "Mark" :year 2016 }
```

A Clojure map is a hash map with the following properties:
* Efficient insertion and removal

##### Set
```clojure
#{}
#{ 1 2 3 4 5 }
```

A Clojure set is a standard hashset with the following properties:
* Fast indexing
* Efficient tail addition and removal

##### List
```clojure
()
'(1 2 3 4 5)
```
A Clojure list has the following properties:
* Efficient head addition and removal

##### Compared with other languages
Contrast this with the following examples of how data beyond primitives are represented
 in Java. In the vast majority of languages, data structures are represented by classes
 or by non-literal data structures.

A class representation.
```java
class Vector {
    private final double x;
    private final double y;
    private final double z;
}
```

A collection.
```java
List<Integer> list = new ArrayList<>();
```

#### Clojure Collections are Heterogeneous
In addition to being represented literally, data structures in Clojure are nested and
heterogeneous, meaning the contents of the collection can be of any type.
```clojure
;Let's model a ???
{ :name "Mark Bastian"
  :address { }
}
```

## Exercise 1: Model a problem as data

Think of a problem you are interested in. If you can't think of one, try the following:

```clojure

```

[functions](functions.md)

## Additional Resources
 * [Clojure Evaluation](http://clojure.org/reference/evaluation): 
 This is an excellent read on the basic types and literal collections of Clojure.
 It also discusses symbols, functions, macros, and other topics not covered in this 
 tutorial.

## License

Copyright © 2016 Mark Bastian

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
