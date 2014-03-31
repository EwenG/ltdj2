(ns service
  (:require [io.pedestal.service.http :as bootstrap]
            [io.pedestal.service.http.route :as route]
            [io.pedestal.service.http.body-params :as body-params]
            [io.pedestal.service.http.route.definition :refer [defroutes]]
            [ring.util.response :as ring-resp]))


(def rr (async/chan))

(async/go (async/put! rr 2))
(async/close! rr)

(async/go-loop []
         (when-let [val (async/<! rr)]
           (prn val)
           (recur)))

(defn home-page
  [request]
  (ring-resp/response "Hello World!"))

(defroutes routes
           [[["/" {:get home-page}]]])

(def service {::bootstrap/routes        #(deref #'routes)
              ::bootstrap/resource-path "/public"})

