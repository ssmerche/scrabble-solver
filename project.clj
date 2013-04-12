(defproject scrabble-solver "0.1.0-SNAPSHOT"
  :description "Show which words you can make given some letters"
  :url "http://github.com/ssmerche/scrabble-solver"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [midje "1.5.0"]]
  :plugins [[lein-midje "3.0.0"]
            [lein-marginalia "0.7.1"]]
  :main scrabble-solver.main)
