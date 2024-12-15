htmx.logAll()

Alpine.store("ttt", {

  /**
   * @param {HTMLElement} card
   *
   * @param {Number} card.dataset.cp
   */
  attack(card) {
    const deck = document.querySelectorAll(".deck .attacker");
    const board = document.querySelectorAll(".board .defender");
    // no cards, game over
    if (!deck.length) return
    // TODO there is a line, game over

    // burn top card on deck
    const aCard = deck[0].parentElement.removeChild(deck[0])

    // fight if not taken
    if ("taken" !== card.dataset.status) {
      card.dataset.cp -= aCard.dataset.cp
    }

    // check if we got the square in the board
    if (card.dataset.cp < 0) {
      card.dataset.cp *= -1
      card.className="card attacker"
      card.dataset.status = "taken"
    }

    // it's ready to fight more now
    if ("face-down" === card.dataset.status) {
      card.dataset.status = "ready"
    }

    // TODO how to make it reactive?
    card.querySelector("div").innerHTML = card.dataset.cp
  }
})
