(defproject chai-latte "0.2.0-SNAPSHOT"
  :description      "A ClojureScript port of the chai assertion library"
  :min-lein-version "2.0.0"
  :plugins          [[lein-cljsbuild "0.3.0"]]
  :dependencies     [[org.clojure/clojure "1.4.0"]
                     [mocha-latte         "0.1.0-SNAPSHOT"]]
  :cljsbuild
  {:builds
   [{:source-paths ["src" "test"],
     :id "unit",
     :compiler
     {:pretty-print  true,
      :output-to     "test/unit.js",
      :optimizations :simple}}]})
