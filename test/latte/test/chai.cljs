(ns latte.test.chai
  (:require [latte.chai :refer (expect)])
  (:require-macros [latte.core :refer (describe it)]))

(describe "expect"

  (describe "with simple JavaScript values"

    (it "works with all chai language chains" []

      (expect true :to.equal     true)
      (expect true :not.to.equal false)

      (expect (array 1 2 (array 3)) :to.deep.equal (array 1 2 (array 3)))

      (expect true :to.be.ok)
      (expect nil  :not.to.exist)
      (expect nil  :to.be.null)

      (expect 2 :to.be.above 1)

      (expect (array)       :to.be.empty)
      (expect (array 1 2 3) :to.include 2)
      (expect (array 1 2 3) :not.to.include 4)

      (expect (js-obj :a 1 :b 2) :to.include.keys :b)
      (expect (js-obj :a 1 :b 2) :not.to.include.keys :c)

      (expect (array 1 2 3) :to.have.length 3)
      (expect (array 1 2 3) :to.have.length.above 2)

      (expect "foo" :to.match #"foo")

      (expect
        (fn bad-fn []
          (throw (js/Error. "some error")))
        :to.throw
        js/Error)))

  (it "can check complex clojure types for equality" []

    (expect [:a :b :c]  :to.equal [:a :b :c])
    (expect {:foo :bar} :not.to.equal {:bar :foo}))

  (it "can check seqable types for emptiness" []

    (expect []  :to.be.empty)
    (expect {}  :to.be.empty)
    (expect #{} :to.be.empty)
    (expect '() :to.be.empty)

    (expect [:a]   :not.to.be.empty)
    (expect {:a 1} :not.to.be.empty)
    (expect #{:a}  :not.to.be.empty))

  (it "can check clojure collections for membership" []

    (expect [:a :b :c] :to.contain.value :a)
    (expect [:a :b :c] :not.to.contain.value :d)

    (expect [:a :b :c] :to.have.members [:a :c])
    (expect [:a :b :c] :not.to.have.members [:d :e])

    (expect
      (fn []
        (expect [:a :b :c] :to.have.members [:d]))
      :to.throw
      js/Error))

  (it "can check clojure maps for key presence" []

    (expect {:a 1 :b 2} :to.contain.keys :a)
    (expect {:a 1 :b 2} :to.contain.keys [:a :b])
    (expect
     (fn []
       (expect {:a 1 :b 2} :to.contain.keys [:a :b :c]))
     :to.throw
     js/Error)))
