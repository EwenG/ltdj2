(ns async
  (:require [cljs.core.async :as async :refer [<! >! close! filter< map<]]
            [lt.objs.editor.pool :as pool]
            [lt.objs.command :as cmd])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))


(def my-chan (async/chan))

(def transformed-chan (->> (filter< :print-me my-chan)
                           (map< :content)
                           (map< #(+ 2 %))))

(go-loop [] (when-let [val (<! transformed-chan)]
                (prn val)
                (recur)))

(go (>! my-chan {:print-me "e" :content 5}))

(close! my-chan)











































(cmd/command {:command :ltdj2.insert
              :desc "ltdj2 insert"
              :exec #(lt.objs.editor/insert-at-cursor (pool/last-active)
"(def transformed-chan (->> (filter< :print-me my-chan)
                           (map< :content)
                           (map< #(+ 2 %))))")})
