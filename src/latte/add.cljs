(ns latte.add)

(def chai       (js/require "chai"))
(def assertions (aget chai "Assertion"))

(defn method [k & args]
  (let [args      (apply hash-map args)
        assertion (:assertion args (constantly false))
        expected  (:expected args (comp clj->js first))]
    (.addMethod assertions (name k)
      (fn [& expectations]
        (this-as this
          (let [obj (aget this "_obj")]
            (.assert this
              (apply assertion obj expectations)
              (:message args)
              (:negation args)
              (expected expectations)
              (clj->js obj))))))))
