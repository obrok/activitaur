(ns activitaur.data)

(defrecord Activity [user-id timestamp])

(defrecord LastActivity [user-id])

(defrecord Never [])

(defrecord Sometime [timestamp])

(defrecord Nothing [])

(def never (->Never))

(def nothing (->Nothing))
