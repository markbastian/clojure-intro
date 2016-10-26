(ns examples.gutenberg
  (:require [clojure.string :as s]))

(defonce pride-and-prejudice
         (slurp "https://www.gutenberg.org/files/1342/1342-0.txt"))

(defonce normalized
         (-> pride-and-prejudice
             (s/replace #"\W+" "|")
             (s/split #"\|")
             (->> (map s/upper-case))))

;Most frequent words pairs
(->> normalized
     frequencies
     (sort-by second #(compare %2 %1))
     (map first)
     (take 20))

;20 most frequent words pairs
(->> normalized
     (partition 2 1)
     (map (partial s/join " "))
     frequencies
     (sort-by second #(compare %2 %1))
     (map first)
     (take 20))

(defonce common-words
         (->> "https://raw.githubusercontent.com/first20hours/google-10000-english/master/20k.txt"
              slurp
              s/split-lines
              (map s/upper-case)))

(defn top-words [n]
  (complement (into #{} (take n common-words))))

(def filtered-normalized
  (->> normalized
       (filter (top-words 500))))

(def word-pairs
  (->> filtered-normalized
       (partition 2 1)
       (map (partial s/join " "))))

(->> word-pairs
     frequencies
     (sort-by second #(compare %2 %1))
     (take 10))

(defn normalize [text]
  (-> text
      (s/replace #"\W+" "|")
      (s/split #"\|")
      (->> (map s/upper-case))))

(defn name-finder [url & {:keys [filter-top] :or {filter-top 1500}}]
  (->> url
       slurp
       normalize
       (filter (top-words filter-top))
       (partition 2 1)
       (map (partial s/join " "))
       frequencies
       (sort-by second #(compare %2 %1))))

(take 20
      (name-finder
        "https://www.gutenberg.org/files/1342/1342-0.txt"
        :filter-top 200))

(take 20
      (name-finder
        "http://www.gutenberg.org/cache/epub/84/pg84.txt"
        :filter-top 200))

(take 20
      (name-finder
        "https://www.gutenberg.org/files/11/11-0.txt"
        :filter-top 200))

(take 20
      (name-finder
        "http://www.gutenberg.org/cache/epub/1661/pg1661.txt"
        :filter-top 200))

(take 20
      (name-finder
        "http://www.gutenberg.org/files/98/98-0.txt"
        :filter-top 200))
