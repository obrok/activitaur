(ns activitaur.interactions
  (:require [activitaur.data :refer :all]
            [activitaur.atomic-map :refer :all]))

(def last-activity-store (atom {}))

(defn activity [request]
  (atomic-merge
    last-activity-store
    {(:user-id request) (:timestamp request)})
  nothing)

(defn last-activity [request]
  (let [timestamp (get @last-activity-store (:user-id request))]
    (if (nil? timestamp)
      never
      (->Sometime timestamp))))
