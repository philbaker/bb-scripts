; get all JavaScript function names following "export default"
; bb exported_js_function_names.clj "path/to/file.js"

(ns exported-js-function-names
  (:require [babashka.fs :as fs]
            [clojure.string :as str]))

(let [[file-name] *command-line-args*]
  (str/join ", " (map #(str/trim %) 
                                 (remove nil? 
                                         (map #(last (last (re-seq #"(export function)(\s\w+)" %))) 
                                              (fs/read-all-lines file-name))))))
