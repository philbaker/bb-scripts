#!/usr/bin/env bb
 
(let [url (first *command-line-args*)] 
  (cond
    (clojure.string/includes? (curl/get url) "wp-")
    "It's probably a WordPress site"
    :else
    "It's probably not a WordPress site"))
