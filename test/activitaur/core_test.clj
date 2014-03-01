(ns activitaur.core-test
  (:require [clojure.test :refer :all]
            [activitaur.core :refer :all]
            [activitaur.data :refer :all]))

(def next-number-store (atom 0))

(defn next-number [] (swap! next-number-store inc))

(defn generate-user-id [] (next-number))

(defn generate-timestamp [] (java.util.Date.))

(deftest interact-last-activity
  (testing "last activity is never by default"
    (is
      (= (interact (->LastActivityRequest (generate-user-id)))
         never)))

  (testing "last activity is the timestamp passed to activity"
    (let [user-id (generate-user-id)
          timestamp (generate-timestamp)]
      (interact (->ActivityRequest user-id timestamp))
      (is
        (= (interact (->LastActivityRequest user-id))
           (->Sometime timestamp)))))

  (testing "last activity is stored per user"
    (let [user-id (generate-user-id)
          other-user-id (generate-user-id)
          timestamp (generate-timestamp)]
      (interact (->ActivityRequest user-id timestamp))
      (is
        (= (interact (->LastActivityRequest other-user-id))
           never)))))

(deftest interact-activity
  (testing "activity returns an empty response"
    (is
      (= (interact (->ActivityRequest (generate-user-id) (generate-timestamp)))
         nothing))))
