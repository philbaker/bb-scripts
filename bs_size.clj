#!/usr/bin/env bb

(def sizes {:h1 40
            :h2 32
            :h3 28
            :h4 24
            :h5 20
            :h6 16
            :p 16
            :display-1 90
            :display-2 82.5
            :display-3 67.5
            :display-4 52.5})

(sizes (keyword (first *command-line-args*)))
