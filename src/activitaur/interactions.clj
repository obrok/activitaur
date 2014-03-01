(ns activitaur.interactions
  (:require [activitaur.data :refer :all]))

(def last-activity-store (atom never))

(defn activity [request]
  (swap!
    last-activity-store
    (constantly (->Sometime (:timestamp request))))
  nothing)

(defn last-activity [request] @last-activity-store)
