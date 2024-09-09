// TODO see what happens when htmx starts to change the document
const { createApp, ref } = Vue
const { useStorage } = VueUse

createApp({
  setup() {
    const message = ref('Hello vue!')
    const count = useStorage('my-count', 0) // returns Ref<number>
    return {
      message, count
    }
  }
}).mount('#app')
