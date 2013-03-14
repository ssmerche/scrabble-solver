(ns scrabble-solver.main 
  (:require [scrabble-solver.core :as solver] 
            [clojure.string :as string]
            [clojure.java.io :as io]))

(defn massage-words [words num-letters] 
  (filter #(<= 2 (.length %) num-letters) words))

(defn word-output [word] (str word " (" (solver/score word) ") "))

(defn -main
  "I don't do a whole lot."
  [& args]
  (if (empty? args)
    (println "ERROR: no letters given")
    (with-open [rdr (io/reader (or (second args) "/usr/share/dict/words"))]
      (let [letters (first args)
            words (massage-words (line-seq rdr) (.length letters))]
        (println (str "words for " letters))
        (apply println (map word-output (solver/solve-with words letters)))))))
