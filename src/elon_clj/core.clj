(ns elon-clj.core
  (:gen-class)
  (:require [aleph.http :as aleph]
            [yada.yada :as y]
            [bidi.ring :as bidi]))

(defn say-hello [ctx]
  (case (y/language ctx)
    "en" "Hello World"
    "sv" "Hej värld"))

(def hello-resource
  (y/resource {:methods
               {:get
                {:produces {:media-type "text/plain"
                            :language #{"en" "sv"}}
                 :response say-hello}}}))

(def hello
  (y/yada "hello world!!\n"))

(def hello-atom
  (y/yada (atom "hello atom world")))


(def routes
  ["" {"/" hello
       "/api" (y/swaggered ["/" {"hello" hello
                                 "hello-atom" hello-atom
                                 "hello-lang" hello-resource}]
                           {:info {:title "Hello World"
                                   :version "1.0"
                                   :description "Demo"}
                            :basePath "/api"})}])

(def handler
  (bidi/make-handler routes))

(defn dev-server []
  (aleph/start-server #(handler %) {:port 3000}))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
