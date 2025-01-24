// tic tactics toe

const warrior = { a: 5, d: 4, name: "warrior" }
const wizard = { a: 2, d: 7, name: "wizard" }
const archer = { a: 3, d: 6, name: "archer" }
const barbarian = { a: 7, d: 2, name: "barbarian" }
const druid = { a: 4, d: 5, name: "druid" }
const rogue = { a: 2, d: 7, name: "rogue" }
const paladin = { a: 8, d: 1, name: "paladin" }
const necromancer = { a: 2, d: 7, mame: "necromancer" }
const monk = { a: 1, d: 8, name: "monk" }

const deck = [warrior, warrior, paladin, paladin, paladin, monk, archer, rogue, barbarian]

const board = [archer, wizard, monk, archer, wizard, monk, archer, wizard, monk]

const challenge = [0, 0, 0, 0, 0, 0, 0, 0, 0]

const moves = []

let finished = false

function attack(d, b) {
  if (challenge[b] && challenge[b] > 0 || moves.find(m => m.d == d)) {
    return console.log("move already made or invalid")
  }

  challenge[b] = deck[d].a - board[b].d

  moves.push({ d, b })
  console.log(`${deck[d].name} attacks ${board[b].name}`)
}

