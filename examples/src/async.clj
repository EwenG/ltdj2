(ns async
  (:require [clojure.core.async :as async :refer [<! >! close! filter< map< go go-loop]]
            [clojure.core.typed :as t :refer [Map]]
            [clojure.core.typed.async :as ta]))


(def my-chan (ta/chan> Map))

(def transformed-chan (->> (filter< :print-me my-chan)
                           (map< :content)
                           (map< #(+ 2 %))))

(go-loop [] (when-let [val (<! transformed-chan)]
                (prn val)
                (recur)))

(go (>! my-chan {:print-me "e" :content 9}))

(close! my-chan)
