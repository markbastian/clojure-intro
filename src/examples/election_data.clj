(ns examples.election-data
  (:require [dk.ative.docjure.spreadsheet :as xl]))

(def popular-vote
  (->> (xl/load-workbook "2012pres.xls")
       (xl/select-sheet "Table 1. 2012 Pres Popular Vote")
       (xl/select-columns {:A :candidate-party
                           :B :votes
                           :C :votes-by-percent})
       (filter (fn [{:keys [votes votes-by-percent]}]
                 (every? number? [votes votes-by-percent])))
       (map #(update % :votes-by-percent * 100))
       (filter #(> (:votes-by-percent %) 0.5))))


(defn update-data [{:keys [dem-electors] :as d}]
  (if dem-electors
    (-> d
        (assoc :gop-electors 0)
        (update :dem-electors int))
    (-> d
        (assoc :dem-electors 0)
        (update :gop-electors int))))

(def state-vote
  (->> (xl/load-workbook "2012pres.xls")
       (xl/select-sheet "Table 2. Electoral &  Pop Vote")
       (xl/select-columns {:A :state
                           :B :dem-electors
                           :C :gop-electors
                           :D :dem-popular
                           :E :gop-popular
                           :F :other-popular
                           :G :total-vote})
       (drop 4)
       (take 51)
       (map update-data)))

(->> state-vote (map :dem-electors) (reduce +))
(->> state-vote (map :gop-electors) (reduce +))

(defn pct-diff [{:keys [dem-popular gop-popular]}]
  (let [diff (Math/abs (- dem-popular gop-popular))]
    (* 100 (/ diff (+ dem-popular gop-popular)))))

(sort-by pct-diff state-vote)


