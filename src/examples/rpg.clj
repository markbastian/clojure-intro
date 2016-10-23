(ns examples.rpg)

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
   {:name "Sam"
    :race :halfling
    :class :fighter
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Merry"
    :race :halfling
    :class :fighter
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Pippin"
    :race :halfling
    :class :fighter
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Strider"
    :race :human
    :class :ranger
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Gimli"
    :race :dwarf
    :class :fighter
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Legolas"
    :race :elf
    :class :ranger
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}
   {:name "Boromir"
    :race :human
    :class :fighter
    :HP 24
    :attributes {:STR 15 :CON 12 :DEX 17 :INT 9 :WIS 12 :CHA 4}}])

(count fellowship)

(map #(update % :HP + 10) fellowship)

