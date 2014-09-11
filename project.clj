(defproject blobstore "0.1.0-SNAPSHOT"
  :description "Small app to save a log message to a blobstore with Clojure"
  :url "https://github.com/everett-toews/blobstore-save-clj"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.logging "0.3.0"]
                 [environ "1.0.0"]
                 [org.apache.jclouds.labs/rackspace-cloudfiles-us "1.8.0"]]
  :main ^:skip-aot blobstore.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
