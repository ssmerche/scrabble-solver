(ns scrabble-solver.test.core
  (:use [midje.sweet] [scrabble-solver.core :as scrabble-solver]))

(def words ["a" "aa" "aal" "sims" "miss" "aani" "aardvark" 
                "aardwolf" "aaron" "aaronic" "aaronical" "aaronite" 
                "aaronitic" "aaru" "ab" "aba" "ababdeh" "ababua" "abac"])

(fact (scrabble-solver/solve-with words "aa") => (just #{"a" "aa"}))
(fact (scrabble-solver/solve-with words "ab") => (just #{"a" "ab"}))
(fact (scrabble-solver/solve-with words "aaronical") => (just #{"a" "aa" "aal" "aani" "aaron" "aaronic" "aaronical"}))
(fact (scrabble-solver/solve-with words "sims") => (just #{"sims" "miss"}))
(fact (scrabble-solver/solve-with words "aalm") => (just #{"a" "aa" "aal"}))
