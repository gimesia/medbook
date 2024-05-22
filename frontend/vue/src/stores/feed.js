import { defineStore } from 'pinia';


// NOTE: this is just a template so far
export const useCounterStore = defineStore('counter', {
  state: () => ({
    count: 0,
  }),
  actions: {
    increment() {
      this.count++;
    },
  },
});
