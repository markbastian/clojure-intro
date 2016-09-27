# l1-getting-started

Part 1: Getting Started

### Clojure is a 

### Basic Types

* Strings
* Numbers
  * Double
  * Long
  * Ratio (Clojure only): 22/7

### Core Collections
Clojure core collections have a literal syntax, meaning they are written exactly as they are meant to be interpreted.

The core collections are:

#### Vector
```clojure
[] ;An empty vector
[1 2 3 4 5 6]
```

A Clojure vector is an array-like object with the following properties:
* Fast lookup by index
* Efficient tail addition and removal

#### Map
```clojure
{}
{ :name "Mark" :year 2016 }
```

A Clojure map is a hash map with the following properties:
* Efficient insertion and removal

#### Set
```clojure
#{}
#{ 1 2 3 4 5 }
```

A Clojure set is a standard hashset with the following properties:
* Fast indexing
* Efficient tail addition and removal

#### List
```clojure
()
'(1 2 3 4 5)
```

A Clojure list has the following properties:
* Efficient head addition and removal


### Collections are Heterogeneous

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
