(ns test-typed
  (:require [clojure.core.typed :as t :refer [defn> def>]]))

(t/tc-ignore (require '[test-typed2]))


(defn> my-fn1 :- String [a :- String] a)
(my-fn1 "e")



(defn> my-fn2 :- (Value 2) [a :- (Value 2)] a)
(my-fn2 2)



(defn> my-fn3 :- (U (Value 2) String) [a :- (U (Value 2) String)] a)
(my-fn3 2)
(my-fn3 "e")


(t/ann ^:no-check test-typed2/check-me Number)


(def> x :- Any 1)

(def> y :- (HMap :mandatory {:b Number})  {:b 3})


(def> ii :- Number test-typed2/check-me)


#_(t/cf y)

#_(t/cf {:a 1} #_(HMap :mandatory {:a Number}))

#_(t/check-ns)
