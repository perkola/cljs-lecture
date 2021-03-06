(ns cljs-lecture.slides)

(def slides
  [
   "
   # ClojureScript
   ![cljs-logo](images/cljs-logo.png)
   "

   "
   # Agenda
   - Who am I?
   - Course takeaways
   - ClojureScript
   - Reagent
   - re-frame
   "

   "
   # Who am I?
   - William Perkola
   - MSc in Computer Science graduate from KTH
   - Software Engineer at TriOptima

   ![cljs-logo](images/trioptima-logo.png)
   "

   "
   # Course takeaways
   - Fun and modern
   - Used to be Java or Clojure
   - This is how it's done (almost)
     - The future is unknown
     - Requirements change a lot
     - The focus lies on writing good code
   "

   "
   # ClojureScript
   - Compiles to JavaScript
   - Includes most of Clojure
     - `clojure.core`
     - Persistent collections, sequence fns, etc
   - Some differences, i.e cljs number is just js number
   "

   "
   # ClojureScript
   - Google closure compiler
   - Seamless interop with js (though dependencies are a bit tricky at times)
   ```clojure
   (.log js/console \"hello\")
   ```
   "

   "
   # Code sharing
   - Code without interop is often identical in clj and cljs
   - `.cljc` (Clojure common)
   - Validation logic, utility functions and more
   "

   "
   # Figwheel
   - Change hiccup/css/other logic
     - Automatically reloads
     - State is preserved through reloads
   - Encourages writing \"reloadable\" code
   - Heads up display of compile errors
   "

   "
   # Figwheel
   ![figwheel](images/figwheel-errors.png)
   "

   "
   # Hiccup
   - Express html using Clojure data structures
   ```clojure
   [:div.example-class
     [:h1 \"Hello world\"]
     [:button {:on-click #(js/alert \"Clicked!\")} \"Click me!\"]]
   ```
   ```clojure
   <div class=\"example-class\">
     <h1>Hello world</h1>
     <button onclick=\"alert(\"Clicked!\")\">Click me!</button>
   </div>
   ```
   "

   "
   # Hiccup
   - All seq fns available to manipulate/generate hiccup
   ```clojure
   (interpose [:span.icon \" ▶ \"] links)
   ```
   ```clojure
   ([:a {:href \"/dashboard\"} \"Dashboard\"]
    [:span.icon \" ▶ \"]
    [:span \"Stats\"])
   ```
   "

   "
   # Reagent ![reagent-logo](images/reagent-logo.png)
   - React wrapper for cljs
   - Uses hiccup
   - Components are just Clojure functions
   - Like React, rerender component when input changes
   ```clojure
   (defn hello-component [name]
     [:div
       [:h1 \"Welcome\"]
       [:p \"Hello, \" name \"!\"]])
   ```
   "

   "
   # Reagent ![reagent-logo](images/reagent-logo.png)
   - Can use \"ratoms\" to rerender
   ```clojure
   (def turn (reagent/atom 0))

   (defn end-turn-component []
     [:div
       \"Turn: \" @turn
       [:button {:on-click #(swap! turn inc)}
         \"End turn\"]])
   ```
   "

   "
   # Performance
   - Intuitively, should be slower than js
     - Another layer on top of js, functional
     - However:
       - Very thin layer on top of js (e.g cljs functions are just js functions)
       - In practice often faster for React apps!
   "

   "
   # re-frame ![re-frame-logo](images/re-frame-logo.png)
   - Framework built on top of Reagent
   - Similar to Redux in js
   - Centralized state, \"app-db\"
   - Events + event handlers
   - Effects
   - Subscriptions
   "

   "
   # Events and event handlers
   ```clojure
   [:button-clicked some-parameter]

   (reg-event-fx :button-clicked handler-fn)
   ```
   "

   "
   # Effects
   - Returned by the handler as a map
   - Most common effect: `:db`
   - Others: local store, api calls etc
   - Effect handler
     - Performs the actual side effect
     - e.g Updates the app-db
   "

   "
   # Subscriptions
   - Query the app db
   - View can `subscribe`
   - re-render as subscription value changes
   - Can subscribe to other subscriptions
   ```clojure
   (reg-sub
     :firestone-deck
     (fn [db] (:deck db))

   (subscribe [:firestone-deck])
   ```
   "

   "
   # re-frame flow
   ![dominoes](images/re-frame-dominoes1.png)
   ![dominoes](images/re-frame-dominoes2.png)
   "

   "
   # re-frame-10x
   - Tools similar to Redux devtools
   - See current app-db, events etc
   "

   "
   # Thank you!
   - [https://clojurescript.org/](https://clojurescript.org/)
   - [https://reagent-project.github.io/](https://reagent-project.github.io/)
   - [https://github.com/Day8/re-frame](https://github.com/Day8/re-frame)
   "
   ])
