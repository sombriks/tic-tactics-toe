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

    // no cards, challenge over
    if (!deck.length) return

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
    const statuses = [[], [], []]
    statuses[0][0] = board[0].dataset.status
    statuses[0][1] = board[1].dataset.status
    statuses[0][2] = board[2].dataset.status
    statuses[1][0] = board[3].dataset.status
    statuses[1][1] = board[4].dataset.status
    statuses[1][2] = board[5].dataset.status
    statuses[2][0] = board[6].dataset.status
    statuses[2][1] = board[7].dataset.status
    statuses[2][2] = board[8].dataset.status
    // any horizontal
    console.log(statuses)
    return false
  }
})
