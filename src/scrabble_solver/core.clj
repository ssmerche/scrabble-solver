(ns scrabble-solver.core
  (:require [clojure.set :as sets] [clojure.string :as string]))

(defn supermultiset?
  [mset1 mset2]
  (if (sets/superset? (set (keys mset1)) (set (keys mset2)))
	(every? #(>= (mset1 (key %)) (mset2 (key %))) mset2)
    false))

(def sort-by-length (partial sort #(compare (.length %2) (.length %))))

(defn solve-with
  [words letters]
  (let [freqs (frequencies letters)]
    (sort-by-length (filter #(supermultiset? freqs (frequencies %)) words))))
