const cards = [
  {code: "KNT", attack: 5, defense: 4},
  {code: "WZD", attack: 2, defense: 7},
  {code: "ACH", attack: 3, defense: 6},
  {code: "BRB", attack: 7, defense: 2},
  {code: "DRD", attack: 4, defense: 5},
  {code: "RGE", attack: 2, defense: 7},
  {code: "PLD", attack: 8, defense: 1},
  {code: "NCR", attack: 2, defense: 7},
  {code: "MNK", attack: 1, defense: 8},
]

function randomCards(n) {
  const rand = []
  while (n-- > 0) {
    const card = cards[Math.floor(Math.random() * cards.length)]
    rand.push({...card, fights: 0, status: "ready"})
  }
  return rand
}
