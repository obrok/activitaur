(defproject activitaur "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[quickie "0.2.5"]]
  :main ^:skip-aot activitaur.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})