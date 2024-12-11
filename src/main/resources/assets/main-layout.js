htmx.logAll()

Alpine.store("ttt", {

  /**
   *
   * @param {HTMLElement} card
   * @param {HTMLElement[]} deck
   */
  attack(card, deck) {
    if(!deck.length) return
    console.log(card.dataset)
    console.log(deck[0].dataset)

    deck[0].parentElement.removeChild(deck[0])
    deck.shift()
  }
})
