#Introduction to Clojure

---

#Quick Intro

----

#About Clojure
* Clojure is a Lisp dialect
* It is hosted
  * Clojure targets the JVM
  * ClojureScript targets JS
  * There are other efforts

----

#Why?
* There is a resurgence in functional languages
* Clojure is a full-stack, multipurpose language
* Clojure has extremely powerful abstractions on data
* Clojure is highly expressive
* Clojure has a consistent track record of success

----

#Who?
* Amazon
* eBay
* Puppet Labs
* Walmart
* Clearwater Analytics
* [And many, many others...](http://clojure.org/community/companies)

---

#Getting Started

----

#[Leiningen](http://leiningen.org/)
* The most popular Clojure build tool
* To get started, do the following:
  1. `lein new clojure-intro`
  2. `cd clojure-intro`
  3. `lein repl`
* REPL = Read-Evaluate-Print-Loop

----

#REPL Intro
Try the following:
* `(prn "Hello World!")`
* `(+ 0 1 2 3 4 5 6 7 8 9)`
* `(inc 0)`
* `(def r (range 10))`
* `(prn r)`
* `(map inc r)`

----

#REPL Help
Try the following:
* `(doc def)`
* `(source map)`
* `(javadoc java.lang.Math)`

----

#IDEs
* Clojure has low IDE dependence, but...
* Popular options
  * Cursive Clojure IntelliJ Plugin
  * Emacs
  * Lighttable
  * Nightcode
* We'll be using the Community Edition of Cursive

----

#Cursive Clojure
* Start IntelliJ IDEA
* File > Open...
* Navigate to the <font color="red">`clojure-intro`</font> folder
* Select the project.clj file and press OK

----

##Navigating your project
* Select the *Project* vertical tab on the left side of the frame
* If the above is not visible, click the box at bottom left and select *Project*
* You can see a tree view representing your project
* Your code will be located in the src folder

----

#Launching a REPL
* Right-click on the project folder
* Select "Run 'REPL for clojure-intro'"
* A REPL window will appear at right
* Ctrl+M will load a Clojure file (ns)
* Ctrl+T will evaluate the current form
* Everything works as it did in the shell

---

#Clojure is Data

----

#Clojure as Data
* Clojure is Homoiconic
  * This just means it is written in its own data structures
  * Code as data
* It excels at data manipulation
* The data abstraction is very powerful, as we shall see

----

# Basic Types
The following basic primitives are present in Clojure:
* Strings: `"This is a string"`
* Numbers
  * Double: `3.14159`
  * Long: `42`
  * Ratio (Clojure only): `22/7`
* Characters (Not in cljs): `\A`
* Booleans: `true` or `false`
* Keywords: `:these :are :keywords`
* `nil`

----

### Collections are Literal Data
In addition to the above primitives the following data 
structures are also treated literally....

----

# Vector
```clojure
[] ;An empty vector
[1 2 3 4 5 6]
```

A Clojure vector is an array-like object with the following properties:
* Fast lookup by index
* Efficient tail addition and removal

----

# Map
```clojure
{}
{ :name "Mark" :year 2016 }
```

A Clojure map is a hash map with the following properties:
* Efficient insertion and removal
* It is common to use keywords as map keys
* *Anything* can be a map key or value

----

# Set
```clojure
#{}
#{ 1 2 3 4 5 }
```

A Clojure set is a standard hashset with the following properties:
* Efficient insertion and removal

----

# List
```clojure
()
'(1 2 3 4 5)
```
A Clojure list has the following properties:
* Efficient head addition and removal
* Lists are not indexed
* Lists generally aren't used for data modeling
* Lists are evaluated unless quoted

----

#Summary
```clojure
(def all-the-data
  { :string "This is a string"
    :characters \A
    :numbers [1 2.3 (/ 22 7)]
    :booleans #{ true false }
    :nil nil})
```

----

#Exercise
Model this scenario using Clojure data structures:
* RPG Character Stats
  * Name: String
  * Race: Human, Elf, Orc, Halfling
  * Class: Figher, Magic User, Cleric
  * HP: Integer
  * Attributes: STR, CON, DEX, INT, WIS, CHA (3 - 18)

----

#A Solution
```clojure
{
  :name "Dirk the Daring"
  :race :elf
  :class :fighter
  :HP 24
  :attributes {
    :STR 15
    :CON 12
    :DEX 17
    :INT 9
    :WIS 12
    :CHA 4
  }}
```

----

#Congratulations!
You've just learned 1/2 of the Clojure programming language.

---

#Evaluation

----

#[Evaluation](https://clojure.org/reference/evaluation)
Clojure is a very simple language, following these rules:
1. Primitives evaluate to themselves
2. Symbols are resolved
3. Vectors, sets, and maps yield vectors, sets, and maps whose contents are evaluated
4. Lists are *calls* to a function, special form, or macro

----

#Functions
Functions are generally defined by a list containing:
  * defn: A macro joining the def and fn special forms
  * A symbol naming the function
  * A vector of arguments
  * The function body
  * The last form is returned
  
```clojure
(defn add [a b] (+ a b))
=> #'user/add
(add 2 4)
=> 6
```

----

#Defining Functions
Explicit Functions
```clojure
(defn add[a b](+ a b))
```

Lambdas
```clojure
(fn [a b](+ a b))
```

Shorthand Lambda Syntax
```clojure
#(+ %1 %2)
#(Math/sqrt %)
```

----

#Exercise
Write a function that computes the average of 3 numbers.

----

#Solutions
```clojure
(defn avg[a b c]
  (/ (+ a b c) 3.0))
=> #'examples.rpg/avg
(avg 7 42 3.14)
=> 17.38
((fn [a b c](/ (+ a b c) 3.0))
  7 42 3.14)
=> 17.38
(#(/ (+ %1 %2 %3) 3.0)
  7 42 3.14)
=> 17.38
```

----

#[Special Forms](http://clojure.org/reference/special_forms)
* Calls that do not follow the regular rules of evaluation
* Required building blocks for the language
* `(pprint (keys (. clojure.lang.Compiler specials)))`
* `&, monitor-exit, case*, try, reify*, finally, loop*, do, letfn*, if, 
clojure.core/import*, new, deftype*, let*, fn*, recur, set!, ., var, 
quote, catch, throw, monitor-enter, def`

----

#The if special form
What if this expression followed the standard rules of evaluation?
```clojure
(if true 
  (cheap-calculation) 
  (really-expensive-calculation-followed-by-world-war-3))
```
* Normally all collection contents are evaluated
* `if` only evaluates one branch
* Special forms are otherwise like regular functions

----

#Macros
* Functions evaluate their contents
* Macros take unevaluated forms, process them, then evaluate them
* This allows developers to extend the language as desired
* This is what makes Clojure homoiconic

----

###Macros: Motivational Example
Are these statements identical with the exception of their language:

Clojure
```clojure
(+ 1 2)
```

Java
```java
1 + 2;
```

----

###Macros: Motivational Example
* Until evaluation, `(+ 1 2)` is a list containing a symbol and two values.
* A macro can manipulate this form prior to evaluation.
* This is what is meant as *homoiconicity* or "code as data."

----

#A Simple Macro
```clojure
(defmacro bizarro [[f & r]]
  (case f
    + (apply - r)
    - (apply + r)
    / (apply * r)
    * (apply / r)))
```

----

#A Bizarre World of Macros
```clojure
(+ 1 2)
=> 3
(bizarro (+ 1 1))
=> 0
(+ 3 2)
=> 5
(bizarro (+ 3 2))
=> 1
```

----

#Macros
* Take unevaluated forms
* Manipulate them
* Return the manipulated form to be evaluated
* Allow you to extend the language

----

#Clojure Summary
###Clojure is data
```clojure
(def all-the-data
  { :string "This is a string"
    :characters \A
    :numbers [1 2.3 (/ 22 7)]
    :booleans #{ true false }
    :nil nil})
```
###That can be evaluated
* Resolve the symbols
* Lists are calls to special forms, macros, or functions
* Evaluate everything else
* (ᗧ • • •)

---

#Functional Sorcery

#Higher order functions
* Functions that take or return functions
* `(map inc [1 2 3 4 5])`
* `(comp inc inc)`

----

>"It is better to have 100 functions operate on one data structure 
than 10 functions on 10 data structures."

*-Alan Perlis*

----

#The Sequence Abstraction
* Nearly every 

----

#Map
* Apply a function to all members of a collection
* If n collections are provided, the function takes n arguments
and is appliet to each collection simultaneously
```clojure
(map inc [1 2 3 4 5])
=> (2 3 4 5 6)
(map * [1 2 3][2 9 5])
=> (2 18 15)
(map #(%1 %2) [str inc dec](repeat 3))
=> ("3" 4 2)
```

----

#Reduce
* Computes a single value by applying a function pairwise
to each member of a collection
* A "seed" value can be provided as a first argument
to the first function application
```clojure
(reduce + [1 2 3 4 5])
=> 15
(reduce #(str %1 %2) "" [1 2 3 4 5])
=> "12345"
```

----

#Filter
* Keep only elements passing a predicate
```clojure
(filter even? (range 10))
=> (0 2 4 6 8)
```

----

#Exercises
Open *examples/rpg.clj* to find the following data structure:
```clojure
(def fellowship
  [{:name "Gandalf"
    :race :human
    :class :magic-user
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Frodo"
    :race :halfling
    :class :thief
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
    ...
```
Then, work through the following exercises.

----

#Questions:
* How many members of the party are there?
* What are the names of each character?
* What is the total number of HP in the group?
  * Hint: Combine map and reduce
* Increase 

---

#THE END
Questions?

----

## Additional Resources
 * [Clojure Evaluation](http://clojure.org/reference/evaluation): 
 This is an excellent read on the basic types and literal collections of Clojure.
 It also discusses symbols, functions, macros, and other topics not covered in this 
 tutorial.

----

## License

Copyright © 2016 Mark Bastian

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
