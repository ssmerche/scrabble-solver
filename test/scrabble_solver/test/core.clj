(ns scrabble-solver.test.core
  (:use [midje.sweet] [scrabble-solver.core :as scrabble-solver]))

(def words ["A" "a" "aa" "aal" "sims" "miss" "Aani" "aardvark" 
                "aardwolf" "Aaron" "Aaronic" "Aaronical" "Aaronite" 
                "Aaronitic" "Aaru" "Ab" "aba" "Ababdeh" "Ababua" "abac"])

(fact (scrabble-solver/solve-with words "aa") => (just #{"a" "aa"}))
(fact (scrabble-solver/solve-with words "ab") => (just #{"a" "ab"}))
(fact (scrabble-solver/solve-with words "sims") => (just #{"sims" "miss"}))
(fact (scrabble-solver/solve-with words "aalm") => (just #{"a" "aa" "aal"}))
