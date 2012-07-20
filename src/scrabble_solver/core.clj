(ns scrabble-solver.core
  (:require [clojure.set :as sets] [clojure.string :as string]))

(defn supermultiset?
  [mset1 mset2]
  (let [letters1 (-> mset1 keys set) letters2 (-> mset2 keys set)]
    (if (sets/superset? letters1 letters2)
      (every? #(>= (mset1 (key %)) (mset2 (key %))) mset2)
      false)))

(def sort-by-length (partial sort #(compare (.length %2) (.length %))))

(defn solve-with
  [words letters]
  (let [freqs (frequencies letters)]
    (->> words (filter #(supermultiset? freqs (frequencies %))) sort-by-length)))
