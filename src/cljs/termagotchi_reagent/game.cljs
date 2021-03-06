(ns termagotchi-reagent.game
  (:require
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [reagent.session :as session]
   [reitit.frontend :as reitit]
   [clerk.core :as clerk]
   [accountant.core :as accountant]))

(defn toggle-state
  [state]
  (case @state
    :normal (reset! state :sad)
    :sad (reset! state :normal)))

(defn image-src
  "returns name of image representing the state"
  [state]
  (case @state
    :normal "tamagotchi.png"
    :sad "tamagotchi-sad.png"
    "tamagotchi.png"))

(defn game
  [state]
  (let [text @state]

    [:<>
     [:img {:src (image-src state)
            :style {:max-width "100%"}}]
     [:button {:on-click #(toggle-state state)}text]
     [:p "Hunger levels 0/10"]]))


