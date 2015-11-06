(ns leiningen.new.clj-web-template
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "clj-web-template"))

(defn clj-web-template
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data ["src/{{sanitized}}/views.clj" (render "views.clj" data)]
["project.clj" (render "project.clj" data)]
["test/{{sanitized}}/handler_test.clj" (render "handler_test.clj" data)]
["src/{{sanitized}}/db.clj" (render "db.clj" data)]
["src/{{sanitized}}/core.clj" (render "core.clj" data)]
["src/{{sanitized}}/config/utils.clj" (render "utils.clj" data)]
["src/{{sanitized}}/handler.clj" (render "handler.clj" data)]
["resources/db/migrations/20150920195353-create-example-table.up.sql" (render "20150920195353_create_example_table.up.sql")]
["resources/db/queries/examples.sql" (render "examples.sql")]
["resources/db/migrations/20150920195353-create-example-table.down.sql" (render "20150920195353_create_example_table.down.sql")]
)))