(defproject elon-clj "0.1.0-SNAPSHOT"
  :description "A small headless CMS"
  :url "http://github.com/mahnve/elon-cms"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [yada "1.1.28"]
                 [aleph "0.4.1"]
                 [bidi "2.0.9"]
                 [com.taoensso/timbre "4.5.1"]
                 [hiccup "1.0.5"]
                 [com.layerware/hugsql "0.4.7"]
                 [h2 "0.2.0"]
                 [mount "0.1.10"]
                 [prismatic/schema "1.1.2"]
                 [aero "1.0.0"]
                 [honeysql "0.7.0"]
                 [clj-aws-s3 "0.3.10"]
                 [fivetonine/collage "0.2.1"]
                 [joplin "0.3.6"]
                 [ragtime "0.6.1"]
                 [com.soundcloud/prometheus-clj "2.4.0"]]
  :main ^:skip-aot elon-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
