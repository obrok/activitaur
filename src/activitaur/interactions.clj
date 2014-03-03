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
  (->> (:user-id request)
       (get @last-activity-store)
       ->time-response))
