(require '[cljs.build.api :as b]
         '[cljs.closure]
         '[clojure.java.io :as io])

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build
   (b/inputs "test" "src")
   {:main 'postal.client-tests
    :output-to "out/tests.js"
    :output-dir "out"
    :optimizations :none
    :language-in  :ecmascript5
    :language-out :ecmascript5
    :target :nodejs
    :verbose true})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))
