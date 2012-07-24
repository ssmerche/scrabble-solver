(ns scrabble-solver.core
  (:require [clojure.set :as sets] [clojure.string :as string]))

(def points-per-letter
   {\A 1 \B 3 \C 3 \D 2 \E 1 \F 4 \G 2 \H 4 \I 1 \J 8
    \K 5 \L 1 \M 3 \N 1 \O 1 \P 3 \Q 10 \R 1 \S 1 \T 1
    \U 1 \V 4 \W 4 \X 8 \Y 4 \Z 10})

(defn score [word] (reduce #(+ %1 (points-per-letter %2)) 0  word))

(defn supermultiset?
  [mset1 mset2]
  (let [letters1 (-> mset1 keys set) letters2 (-> mset2 keys set)]
    (if (sets/superset? letters1 letters2)
      (every? #(>= (mset1 (key %)) (mset2 (key %))) mset2)
      false)))

(defn solve-with
  [words letters]
  (let [letters (string/upper-case letters)
        freqs (frequencies letters)
        words (set (map string/upper-case words))]
    (->> words (map string/upper-case) (filter #(supermultiset? freqs (frequencies %))) 
      (sort-by score >))))
