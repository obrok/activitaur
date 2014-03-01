(ns activitaur.atomic-map)

(defn atomic-merge [atomic-map other-map]
  (swap!
    atomic-map
    #(merge % other-map)))
