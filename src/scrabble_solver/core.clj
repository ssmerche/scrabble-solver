(ns scrabble-solver.core
  (:require [clojure.set :as sets] [clojure.string :as string]))

(defn supermultiset?
  [mset1 mset2]
  (if (sets/superset? (set (keys mset1)) (set (keys mset2)))
	(every? #(>= (mset1 (key %)) (mset2 (key %))) mset2)
    false))

(defn add-entry
  [entries word]
  (let [k (frequencies word) v (entries k)]
       (assoc entries k (conj v word))))

(defn frequency-table [words] (reduce add-entry {} words))

(defn solve
  [entries letters]
  (let [valid-keys (filter #(supermultiset? (frequencies letters) %) (keys entries))]
    (flatten (map entries valid-keys))))

(defn solve-with
  [words letters]
  (let [entries (frequency-table words)]
    (solve entries letters)))


