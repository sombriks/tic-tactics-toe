# [tic-tactics-toe][repo]

[![Java CI with bld](https://github.com/sombriks/tic-tactics-toe/actions/workflows/bld.yml/badge.svg)](https://github.com/sombriks/tic-tactics-toe/actions/workflows/bld.yml)

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
- [vueUse 10.9][vueuse]

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

- I enjoy the elegance of the [ApiBuilder][handler-group] very much.
- The best [j2html][j2html] example is [the site itself][views].
- Webjars helps me to keep all dependency version [in one place][project].
- The use of vue in non-sfc, no-build-step environments is a known progressive
  capability but always pleasant to see in action. Even the ecosystem honors
  this, as we can see in VueUse library.
- The [jdbi constructor mapper][constructor-mapper] works great with java
  records.
  

[repo]: https://github.com/sombriks/tic-tactics-toe
[java]: https://dev.java
[slf4j]: https://slf4j.org
[h2]: https://h2database.com/html/main.html
[jdbi]: https://jdbi.org
[javalin]: https://javalin.io
[j2html]: https://j2html.com
[htmx]: https://htmx.org
[vue]: https://vuejs.org
[vueuse]: https://vueuse.org/
[bld]: https://rife2.com/bld
[handler-group]: https://javalin.io/documentation#handler-groups
[views]: https://github.com/tipsy/j2html/blob/master/j2html-website/src/main/java/app/views/MainView.java
[project]: src/bld/java/io/sombriks/TictacticstoeBuild.java
[constructor-mapper]: https://jdbi.org/#_constructormapper
