(ns scrabble-solver.core
  (:require [clojure.set :as sets] [clojure.string :as string]))

(def points-per-letter
  "Points for each letter in scrabble"
  {\A 1 \B 3 \C 3 \D 2 \E 1 \F 4 \G 2 \H 4 \I 1 \J 8
   \K 5 \L 1 \M 3 \N 1 \O 1 \P 3 \Q 10 \R 1 \S 1 \T 1
   \U 1 \V 4 \W 4 \X 8 \Y 4 \Z 10})

(defn score 
  "Sum the points for each letter in the word to get the score"
  [word] 
  (reduce #(+ %1 (points-per-letter %2)) 0 (string/upper-case word)))

(defn match?
  "See if we can make a word by comparing the frequencies of the letters we have
   with the letter frequencies of the word we want"
  [letters word]
  (let [letter-freqs (frequencies letters) 
        word-freqs (frequencies word)]
    (every? #(>= (letter-freqs (key %) 0) 
                 (word-freqs (key %) 0)) word-freqs)))

(defn solve-with
  "Search for the words we can make with the our letters and return them sorted
   descending by score"
  [words letters]
  (let [letters (string/upper-case letters)
        words (set (map string/upper-case words))]
    (->> words (filter #(match? letters %)) (sort-by score >))))
