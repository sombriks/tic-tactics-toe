// TODO see what happens when htmx starts to change the document
const { createApp, ref } = Vue
const { useStorage } = VueUse

createApp({
  setup() {
    const footer = ref('Tic Tactics Toe')
    const count = useStorage('my-count', 0) // returns Ref<number>
    return {
      footer, count
    }
  }
}).mount('#app')

// proper htmx/vue integration would be vue refs participating in htmx requests,
// vue events able to trigger htmx and
