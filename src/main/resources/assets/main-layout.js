htmx.logAll()

Alpine.store("ttt", {

  /**
   * @param {HTMLElement} card
   *
   * @param {Number} card.dataset.cp
   */
  attack(card) {
    // HATEOAS
    const deck = document.querySelectorAll(".deck .attacker");
    const board = document.querySelectorAll(".board .card");

    // no cards left on deck, challenge over
    if (!deck.length) return

    // card already taken, nothing to do
    if (card.dataset.status === "taken") return

    // there is a line, challenge over
    if (this.checkLines(board)) return

    // burn top card on deck
    const aCard = deck[0].parentElement.removeChild(deck[0])

    // fight if not taken
    if ("taken" !== card.dataset.status) {
      card.dataset.cp -= aCard.dataset.cp
    }

    // check if we got the square in the board
    if (card.dataset.cp < 0) {
      card.dataset.cp *= -1
      card.className = "card attacker"
      card.dataset.status = "taken"
    }

    // it's ready to fight more now
    if ("face-down" === card.dataset.status) {
      card.dataset.status = "ready"
    }

    // TODO how to make it reactive?
    card.querySelector("div").innerHTML = card.dataset.cp
  },
  checkLines(board) {
    if (!board) return false
    let statuses = ""
    let i = -1
    while (++i < 9) statuses += board[i].dataset.status === "taken" ? "1" : "0"
    console.log(statuses)
    const wins = [
      "111000000",
      "000111000",
      "000000111",
      "100100100",
      "010010010",
      "001001001",
      "100010001",
      "001010100"
    ]
    return false
  }
})
