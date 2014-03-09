(defproject ltdj2 "0.1.0-SNAPSHOT"
  :description ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [domina "1.0.2"]
                 [org.clojure/core.typed "0.2.34"]
                 [io.pedestal/pedestal.service "0.2.2"]
                 [io.pedestal/pedestal.service-tools "0.2.2"]
                 [javax.servlet/javax.servlet-api "3.1.0" :scope "test"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]])
