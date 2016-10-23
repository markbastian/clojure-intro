
#Symbols
`def` defines a symbol and binds it to a value (if provided)
```clojure
(def x 42)
(def y) ;This is rare
```

----

#Exercise
Bind your character from chapter 1 as the value *my-char*

----

#Solution
```clojure
(def my-char
  {
    :name "Dirk the Daring"
    :race :elf
    :class #{:fighter :magic-user}
    :HP 24
    :attributes {
      :STR 15
      :CON 12
      :DEX 17
      :INT 9
      :WIS 12
      :CHA 4
  }})
```

----

#Collections are Functions
* Vectors are functions of their indices
* Maps are functions of their keys
* Sets are functions of their elements
* Lists are not functions

----