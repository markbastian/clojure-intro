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

(def two-words
  (->> filtered-normalized
       (partition 2 1)
       (map (partial s/join " "))))

(->> two-words
     frequencies
     (sort-by second #(compare %2 %1))
     (take 150))

(defn normalize [text]
  (-> text
      (s/replace #"\W+" "|")
      (s/split #"\|")
      (->> (map s/upper-case))))

(defn name-finder [url]
  (->> url
       slurp
       normalize
       (filter (top-words 1500))
       (partition 2 1)
       (map (partial s/join " "))
       frequencies
       (sort-by second #(compare %2 %1))
       (take 150)))

(name-finder "https://www.gutenberg.org/files/1342/1342-0.txt")
(name-finder "http://www.gutenberg.org/cache/epub/84/pg84.txt")
(name-finder "https://www.gutenberg.org/files/11/11-0.txt")