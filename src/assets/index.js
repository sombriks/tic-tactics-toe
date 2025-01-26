// tic tactics toe basic cards

const warrior = { a: 5, d: 4, name: "warrior" }
const wizard = { a: 2, d: 7, name: "wizard" }
const archer = { a: 3, d: 6, name: "archer" }
const barbarian = { a: 7, d: 2, name: "barbarian" }
const druid = { a: 4, d: 5, name: "druid" }
const rogue = { a: 2, d: 7, name: "rogue" }
const paladin = { a: 8, d: 1, name: "paladin" }
const necromancer = { a: 2, d: 7, mame: "necromancer" }
const monk = { a: 1, d: 8, name: "monk" }

const deck = [warrior, warrior, paladin, //
  paladin, paladin, monk,//
  archer, rogue, barbarian]

const board = [archer, wizard, monk, //
  archer, wizard, monk, //
  archer, wizard, monk]

const challenge = [0, 0, 0, 0, 0, 0, 0, 0, 0]

const moves = []

let finished = false

function attack(cardFromBoard) {
  const cardFromDeck = document.querySelector(".square.in-deck.attacker.ready")
  console.log({cardFromBoard, cardFromDeck})

  if (finished) return
  if (d > 8 || b > 8 || d < 0 || b < 0 //
    || (challenge[b] && challenge[b] > 0) //
    || moves.find(m => m.d == d)) {
    return console.log("move already made or invalid")
  }

  // battle! TODO implement effects (reveal, attack, defend) and terrains
  challenge[b] = deck[d].a - board[b].d

  moves.push({ d, b })
  console.log(`${deck[d].name} attacks ${board[b].name}`)
  printBoard()
  checkFinish()
}

function printBoard() {
  const b = challenge
  console.log(`
${b[0]} ${b[1]} ${b[2]}
${b[3]} ${b[4]} ${b[5]}
${b[6]} ${b[7]} ${b[8]}
  `)
}

function checkFinish() {
  // winning finish if:
  // - one line taken (row, col, diag)
  // - deck is empty (9 moves)

  let score = 0;
  let squares = 9;
  for (let i = 0; i < challenge.length; i++) {
    if (challenge[i] > 0) {
      squares++
      score += Math.pow(2, i)
    }
  }

  // win table      84
  //
  //  1   2   4      7
  //  8  16  32     56
  // 64 128 256    448
  //
  // 73 146 292    273
  const winvalues = [7, 56, 448, 73, 146, 292, 84, 273]
  if (winvalues.find(v => (v & score) == v)) {
    console.log("line, column or diagonal taken, you won!")
    finished = true
  }

  if (moves.length == 9) {
    console.log("deck is empty, game over!")
    finished = true
  }
}


