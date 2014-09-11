(ns blobstore.core
  (:gen-class)
  (:import org.jclouds.blobstore.BlobStore)
  (:use [clojure.pprint :only (pprint)])
  (:use [environ.core :only (env)])
  (:require [org.jclouds.blobstore2 :as bs]))

(defn -main
  "Small app to save a log message to a blobstore with Clojure."
  [& args]
  ;; Normally we would use clojure.tools.cli to parse-opts but
  ;; that's overkill for this example
  (def container (nth args 0))
  (def filename (nth args 1))
  (def payload (nth args 2))
  (def blobstore
    (bs/blobstore (env :blobstore-provider) (env :blobstore-identity) (env :blobstore-credential)))
  (def blob (bs/blob filename :payload payload))
  (bs/create-container blobstore container)
  (bs/put-blob blobstore container blob))
