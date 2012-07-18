(ns scrabble-solver.main 
  (:require [scrabble-solver.core :as solver] [clojure.string :as string]))

(defn -main
  "I don't do a whole lot."
  [& args]
  (with-open [rdr (clojure.java.io/reader "/usr/share/dict/words")]
    (let [words (set (map string/lower-case (line-seq rdr)))
          frequency-table (solver/frequency-table words)]
      (prn args))))
