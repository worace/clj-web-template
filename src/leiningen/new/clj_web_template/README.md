## {{name}}

Simple example app attempting to put together a straightforward
clojure web stack, including:

*  Log configuration using [timbre](https://github.com/ptaoussanis/timbre)
*  DB access using Postgres via [JDBC](https://github.com/clojure/java.jdbc)
*  DB queries using [Yesql](https://github.com/krisajenkins/yesql)
*  DB migrations using [Migratus](https://github.com/yogthos/migratus)
*  [HTTP-Kit webserver](http://www.http-kit.org/)
*  code reloading thanks to [ring reload middleware](https://github.com/ring-clojure/ring/wiki/Reloading)
*  Procfile for heroku

## Running

To start a web server for the application, run:

    lein run

## DB Migrations

Migrations are managed using the [Migratus](https://github.com/yogthos/migratus)
library.

Migration files are stored in `resources/db/migrations`.

You can create a new migration file using:

```
lein migratus create create-examples-table
```

Once your migrations are prepared, you can run them with:

```
lein migratus migrate
```

or revert the last one with:

```
lein migratus rollback
```

## DB Setup

The db will need to be created in the appropriate postgres
server.

__Locally__

```
createdb {{ns-name}}_development
```

__Heroku__

```
heroku addons:create heroku-postgresql:hobby-dev
```

## License

Copyright © 2015 FIXME
