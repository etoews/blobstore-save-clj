(ns blobstore.core
  (:gen-class)
  (:import org.jclouds.blobstore.BlobStore)
  (:use [clojure.pprint :only (pprint)])
  (:use [environ.core :only (env)])
  (:require [org.jclouds.blobstore2 :as bs]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def my-blobstore
    (bs/blobstore (env :blobstore-provider) (env :blobstore-identity) (env :blobstore-credential)))
  (bs/create-container my-blobstore "hello")
  (def my-blob (bs/blob "world.txt" :payload "Hi!"))
  (bs/put-blob my-blobstore "hello" my-blob))
