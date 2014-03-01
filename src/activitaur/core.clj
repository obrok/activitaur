(ns activitaur.core
  (:gen-class))

(def nothing :nothing)

(defprotocol RequestModel
  (interact [request]))

(def never :never)

(defrecord LastActivity [user-id]
  RequestModel (interact [this] never))

(defrecord Activity [user-id]
  RequestModel (interact [this] nothing))
