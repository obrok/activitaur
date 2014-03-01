(ns activitaur.core
  (:gen-class)
  (:require [activitaur.interactions :refer :all]
            [activitaur.data :refer :all]))

(defprotocol RequestModel
  (interact [request]))

(extend activitaur.data.LastActivity
  RequestModel {:interact activitaur.interactions/last-activity})

(extend activitaur.data.Activity
  RequestModel {:interact activitaur.interactions/activity})
