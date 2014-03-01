(ns activitaur.data)

(defrecord ActivityRequest [user-id timestamp])

(defrecord LastActivityRequest [user-id])

(defrecord Never [])

(defrecord Sometime [timestamp])

(defrecord Nothing [])

(def never (->Never))

(def nothing (->Nothing))
