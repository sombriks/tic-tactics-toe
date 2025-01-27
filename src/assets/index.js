// tic tactics toe basic cards

const challenge = [0, 0, 0, 0, 0, 0, 0, 0, 0]

const moves = []

let finished = false

function attack(cardFromBoard) {
  if (finished) {
    console.log("game already ended")
    return
  }

  const cardFromDeck = document.querySelector(".square.in-deck.attacker.ready")
  if (!cardFromDeck) {
    console.log("no card left on deck. game over")
    finished = true
    return
  }
  cardFromDeck.classList.remove("ready")
  cardFromDeck.classList.add("hide")

  fight({cardFromBoard, cardFromDeck})
  printBoard()
  checkFinish()
}

function fight({cardFromBoard, cardFromDeck}) {
  // battle! TODO implement effects (reveal, attack, defend) and terrains
  const ch = cardFromBoard.dataset.index
  challenge[ch] = cardFromDeck.dataset.attack - cardFromBoard.dataset.defense
  if(challenge[ch] > 0) {
    cardFromBoard.classList.remove("ready")
    cardFromBoard.classList.add("hide")
  }
  moves.push({cardFromBoard, cardFromDeck})
  console.log(`${cardFromDeck.dataset.code} attacks ${cardFromBoard.dataset.code}`)
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


