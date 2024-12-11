htmx.logAll()

Alpine.store("ttt", {

  attack(card, deck) {
    console.log(card.dataset)
    console.log(deck[0].dataset)
  }
})
