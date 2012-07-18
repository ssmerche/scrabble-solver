(ns scrabble-solver.main 
  (:require [scrabble-solver.core :as solver] [clojure.string :as string]))

(def massage-words (comp set (partial map string/lower-case)))

(defn -main
  "I don't do a whole lot."
  [& args]
  (with-open [rdr (clojure.java.io/reader "/usr/share/dict/words")]
    (if (empty? args)
      (println "ERROR: no letters given")
      (let [letters (first args)
            words (filter #(<=  2 (.length %) (.length letters)) 
                          (massage-words (line-seq rdr)))]
        (println (str "words for " letters))
        (prn (solver/solve-with words letters))))))
