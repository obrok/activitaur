(ns activitaur.atomic-map-test
  (:require [clojure.test :refer :all]
            [activitaur.atomic-map :refer :all]))

(deftest atomic-merge-test
  (let [a-map (atom {:a :b})]
    (atomic-merge a-map {:c :d})
    (is (= @a-map {:a :b, :c :d}))))
