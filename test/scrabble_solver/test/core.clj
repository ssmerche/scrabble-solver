(ns scrabble-solver.test.core
  (:use [midje.sweet] [scrabble-solver.core :as scrabble-solver]))

(def words ["a" "aa" "aal" "sims" "miss" "aani" "aardvark" 
                "aardwolf" "aaron" "aaronic" "aaronical" "aaronite" 
                "aaronitic" "aaru" "ab" "aba" "ababdeh" "ababua" "abac"])

(fact (scrabble-solver/solve-with words "aa") => (just #{"A" "AA"}))
(fact (scrabble-solver/solve-with words "ab") => (just #{"A" "AB"}))
(fact (scrabble-solver/solve-with words "aaronical") => (just #{"A" "AA" "AAL" "AANI" "AARON" "AARONIC" "AARONICAL"}))
(fact (scrabble-solver/solve-with words "sims") => (just #{"SIMS" "MISS"}))
(fact (scrabble-solver/solve-with words "aalm") => (just #{"A" "AA" "AAL"}))
