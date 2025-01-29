// tic tactics toe

let score
let moves
let eventLog
let finished

function attack(cardFromBoard) {
  // if(!eventLog) eventLog = document.getElementById("event-log")
  if (finished) {
    console.log("<p>game already ended</p>")
    return
  }

  const cardFromDeck = document.querySelector(".square.in-deck.attacker.ready")

  cardFromDeck.classList.remove("ready")
  cardFromDeck.classList.add("done")

  fight({ cardFromBoard, cardFromDeck })
  printScoreBoard()
  checkFinish()
}

function fight({ cardFromBoard, cardFromDeck }) {
  // battle! TODO implement effects (reveal, attack, defend) and terrains
  const ch = cardFromBoard.dataset.index
  score[ch] = cardFromDeck.dataset.attack - cardFromBoard.dataset.defense
  if (score[ch] > 0) {
    cardFromBoard.classList.remove("ready", "face-down")
    cardFromBoard.classList.add("done")
  } else {
    cardFromBoard.classList.remove("face-down")
    cardFromBoard.classList.add("ready")
    cardFromBoard.innerHTML = `${cardFromBoard.dataset.code}
A: ${cardFromBoard.dataset.attack}
D: ${cardFromBoard.dataset.defense}`
  }
  moves.push({ cardFromBoard, cardFromDeck })
  eventLog.innerHTML += `<i>${cardFromDeck.dataset.code} attacks ${cardFromBoard.dataset.code}</i>`
}

function printScoreBoard() {
  const b = score
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

  let points = 0;
  let squares = 9;
  for (let i = 0; i < score.length; i++) {
    if (score[i] > 0) {
      squares++
      points += Math.pow(2, i)
    }
  }

  // win table      84
  //
  //  1   2   4      7
  //  8  16  32     56
  // 64 128 256    448
  //
  // 73 146 292    273
  const winValues = [7, 56, 448, 73, 146, 292, 84, 273]
  if (winValues.find(v => (v & points) == v)) {
    console.log("line, column or diagonal taken, you won!")
    eventLog.innerHTML += "<p>Victory!</p>"
    finished = true
  }

  if (!document.querySelector(".square.in-deck.attacker.ready")) {
    console.log("deck is empty, game over!")
    eventLog.innerHTML += "<p>You lose!</p>"
    finished = true
  }
}

function share(url) {
  console.log(url)
}

document.addEventListener("DOMContentLoaded", () => {
  eventLog = document.getElementById("event-log")
  eventLog.innerHTML += "<p>ready</p>"

  score = [0, 0, 0, 0, 0, 0, 0, 0, 0]
  moves = []

})
