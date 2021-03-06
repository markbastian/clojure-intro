(ns examples.java
  (:import (javax.swing JFrame JLabel Box JFormattedTextField)
           (java.awt BorderLayout Component)
           (java.awt.event ActionListener FocusListener)))


(defn c->f [c](-> c (* 9) (/ 5) (+ 32)))
(defn f->c [f](-> f (- 32) (* 5) (/ 9)))

(defn sync-components [this-comp that-comp f]
  (->> this-comp .getText Double/parseDouble f str (.setText that-comp)))

(defn action [this-comp that-comp f]
  (doto this-comp
    (.addFocusListener
      (reify FocusListener
        (focusGained [_ _])
        (focusLost [_ _] (sync-components this-comp that-comp f))))
    (.addActionListener
      (reify ActionListener
        (actionPerformed [_ _] (sync-components this-comp that-comp f))))))

(defn temp-app [initial-temp-celcius]
  (let [state (atom {:celcius initial-temp-celcius})
        f (JFormattedTextField. (-> @state :celcius c->f str))
        c (JFormattedTextField. (-> @state :celcius str))]
    (doto (JFrame.)
      (.setSize 400 150)
      (.setLayout (BorderLayout.))
      (.add (doto (Box/createVerticalBox)
              (.add (doto (Box/createHorizontalBox)
                      (.add ^Component  (action f c f->c))
                      (.add (JLabel. "F"))))
              (.add (doto (Box/createHorizontalBox)
                      (.add ^Component  (action c f c->f))
                      (.add (JLabel. "C"))))) BorderLayout/CENTER)
      (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE)
      (.setVisible true))))

;(temp-app 100.0)
