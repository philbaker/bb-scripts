#!/usr/bin/env bb
(require '[cheshire.core :as json]
         'clojure.walk
         'clojure.string)

(defn get-status [name url] 
  (->> (slurp url)
       (json/parse-string)
       (clojure.walk/keywordize-keys)
       (:status)
       (:description)
       (str name ": ")))

(def services 
  [{:name "CircleCI"
    :url "https://status.circleci.com/api/v2/status.json"}
   {:name "Github"
    :url "https://www.githubstatus.com/api/v2/summary.json"}
   {:name "Trello"
    :url "https://trello.status.atlassian.com/api/v2/status.json"}])

(doall (for [{:keys [name url]} services]
           (println (get-status name url))))
