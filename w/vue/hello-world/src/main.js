import Vue from 'vue'
//import App from './App.vue'

//Vue.config.productionTip = false

new Vue({
  el: '#app',
  data:{
    message: 'xx',
    todos: [
      {text: 'yamada'},
      {text: 'takashi'},
      {text: 'aya'}
    ]
  },
  methods: {
    reverseMessage : function(){
      this.message = this.message.split('').reverse().join('')
    }
  }
})

