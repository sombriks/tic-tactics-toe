htmx.logAll()

Alpine.store("ttt", {

  /**
   * @param {HTMLElement} card
   * @param {HTMLElement[]} deck
   *
   * @param {Number} card.dataset.cp
   */
  attack(card, deck) {
    // no cards, game over
    if (!deck.length) return
    // TODO there is a line, game over


    // burn top card on deck
    deck[0].parentElement.removeChild(deck[0])
    const aCard = deck.shift()

    // fight if not taken
    if ("taken" !== card.dataset.status) {
      card.dataset.cp -= aCard.dataset.cp
    }

    // check if we got the square in the board
    if (card.dataset.cp < 0) {
      card.dataset.cp *= -1
      // TODO get from css variables
      console.log(getComputedStyle(aCard).border)
      card.style.borderColor =  getComputedStyle(aCard).getPropertyValue("borderColor")
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
