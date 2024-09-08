# [tic-tactics-toe][repo]

Tic-Tac-Toe with a card game twist

## Tech stack

- java 17
- sjf4-simple 2.0
- h2 2.3
- jdbi 3.45
- javalin 6.3
- j2html 1.6
- htmx.org 2.0
- vue 3.5

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
[bld]: https://rife2.com/bld
[handler-group]: https://javalin.io/documentation#handler-groups
