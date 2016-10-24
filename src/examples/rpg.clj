(ns examples.rpg)

(def fellowship
  [{:name "Gandalf"
    :race :human
    :class :magic-user
    :HP 100
    :attributes {:STR 13 :CON 13 :DEX 17 :INT 18 :WIS 18 :CHA 16}}
   {:name "Frodo"
    :race :halfling
    :class :thief
    :HP 24
    :attributes {:STR 9 :CON 12 :DEX 17 :INT 16 :WIS 12 :CHA 16}}
   {:name "Sam"
    :race :halfling
    :class :fighter
    :HP 20
    :attributes {:STR 11 :CON 15 :DEX 12 :INT 11 :WIS 14 :CHA 12}}
   {:name "Merry"
    :race :halfling
    :class :fighter
    :HP 20
    :attributes {:STR 12 :CON 13 :DEX 13 :INT 10 :WIS 10 :CHA 14}}
   {:name "Pippin"
    :race :halfling
    :class :fighter
    :HP 23
    :attributes {:STR 12 :CON 11 :DEX 12 :INT 9 :WIS 9 :CHA 13}}
   {:name "Strider"
    :race :human
    :class :ranger
    :HP 24
    :attributes {:STR 17 :CON 18 :DEX 13 :INT 14 :WIS 16 :CHA 13}}
   {:name "Gimli"
    :race :dwarf
    :class :fighter
    :HP 24
    :attributes {:STR 18 :CON 16 :DEX 13 :INT 10 :WIS 10 :CHA 8}}
   {:name "Legolas"
    :race :elf
    :class :ranger
    :HP 24
    :attributes {:STR 13 :CON 12 :DEX 18 :INT 15 :WIS 12 :CHA 14}}
   {:name "Boromir"
    :race :human
    :class :fighter
    :HP 24
    :attributes {:STR 16 :CON 15 :DEX 14 :INT 12 :WIS 9 :CHA 10}}])