#!/usr/bin/env bb

(import 'java.time.format.DateTimeFormatter
        'java.time.LocalDateTime)

(def date (LocalDateTime/now))
(def formatter (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm"))

(str (first *command-line-args*) (.format date formatter))
