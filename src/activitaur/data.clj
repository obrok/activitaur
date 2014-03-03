(ns activitaur.data)

(defrecord ActivityRequest [user-id timestamp])

(defrecord LastActivityRequest [user-id])

(defrecord Never [])

(defrecord Sometime [timestamp])

(def never (->Never))

(defprotocol TimeResponsable
  (->time-response [this]))

(extend-protocol TimeResponsable
  nil (->time-response [_] never)
  java.util.Date (->time-response [this] (->Sometime this)))

(defrecord Nothing [])

(def nothing (->Nothing))
