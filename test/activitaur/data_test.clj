(ns activitaur.data-test
  (:require [clojure.test :refer :all]
            [activitaur.data :refer :all]))

(deftest ->time-response-test
  (is (= (->time-response nil) never))
  (let [timestamp (java.util.Date.)]
    (is (= (->time-response timestamp) (->Sometime timestamp)))))
