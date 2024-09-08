# [tic-tactics-toe][repo]

Tic-Tac-Toe with a card game twist

## Tech stack

- [java 17][java]
- [slf4j-simple 2.0][slf4j]
- [h2 2.3][h2]
- [jdbi 3.45][jdbi]
- [javalin 6.3][javalin]
- [j2html][j2html]
- [htmx.org 2.0][htmx]
- [vue 3.5][vue]

## How to build

Project is managed with [bld][bld]. Call the wrapper:

```bash
./bld download compile uberjar
```

## How to run

```bash
java -jar build/dist/tictacticstoe-0.1.0-uber.jar
```

Or:

```bash
./bld run
```

## Noteworthy

- I enjoy the elegance of the [ApiBuilder][handler-group]

[repo]: https://github.com/sombriks/tic-tactics-toe
[java]: https://dev.java
[slf4j]: https://slf4j.org
[h2]: https://h2database.com/html/main.html
[jdbi]: https://jdbi.org
[javalin]: https://javalin.io
[j2html]: https://j2html.com
[htmx]: https://htmx.org
[vue]: https://vuejs.org
[bld]: https://rife2.com/bld
[handler-group]: https://javalin.io/documentation#handler-groups
