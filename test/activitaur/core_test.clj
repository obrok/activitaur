(ns activitaur.core-test
  (:require [clojure.test :refer :all]
            [activitaur.core :refer :all]))

(def next-number-store (atom 0))

(defn next-number [] (swap! next-number-store inc))

(defn generate-user-id [] (next-number))

(deftest interact-last-activity
  (testing "last activity is never by default"
    (is
      (= (interact (->LastActivity (generate-user-id)))
         never))))

(deftest interact-activity
  (testing "activity returns an empty response"
    (is
      (= (interact (->Activity (generate-user-id)))
         nothing))))
