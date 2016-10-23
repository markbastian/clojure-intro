(ns examples.gutenberg
  (:require [clojure.string :as s]))

(defonce common-words
         (->> "https://raw.githubusercontent.com/first20hours/google-10000-english/master/20k.txt"
              slurp
              s/split-lines
              (map s/upper-case)))

(defn top-words [n]
  (complement (into #{} (take n common-words))))

(defonce pride-and-prejudice
         (slurp "https://www.gutenberg.org/files/1342/1342-0.txt"))

(defonce normalized
         (-> pride-and-prejudice
             (s/replace #"\W+" "|")
             (s/split #"\|")
             (->> (map s/upper-case))))

(def filtered-normalized
  (->> normalized
       (filter (top-words 500))))

#_(->> normalized
       frequencies
       (sort-by second #(compare %2 %1))
       (filter (comp (top-words 1000) first))
       (take 50))

(def two-words
  (->> filtered-normalized
       (partition 2 1)
       (map (partial s/join " "))))

(->> two-words
     frequencies
     (sort-by second #(compare %2 %1))
     (take 150))