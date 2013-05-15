(defproject chai-latte "0.2.1"
  :description      "A ClojureScript port of the chai assertion library"
  :url              "https://github.com/contentjon/chai-latte"
  :license          {:name         "MIT"
                     :url          "http://opensource.org/licenses/MIT"
                     :distribution :repo
                     :comments     "Same license as Chai"}

  :min-lein-version "2.0.0"
  :plugins          [[lein-cljsbuild "0.3.0"]]
  :dependencies     [[contentjon/kit.cljs "0.1.0"]]
  :profiles         {:dev {:dependencies [[org.clojure/clojure "1.5.1"]
                                          [mocha-latte "0.1.0"]]}}
  :cljsbuild
  {:builds
   [{:source-paths ["src" "test"],
     :id "unit",
     :compiler
     {:pretty-print  true,
      :output-to     "test/unit.js",
      :optimizations :simple}}]})
