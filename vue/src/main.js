import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import Buefy from 'buefy'
import {ConfigProgrammatic} from 'buefy'
import 'buefy/dist/buefy.css'
import '../public/Main.scss'


import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(fas,far)

Vue.component('font-awesome-icon', FontAwesomeIcon)




Vue.config.productionTip = false
Vue.use(Buefy,{
  defaultIconComponent:'font-awesome-icon',
  defaultIconPack: 'fas'
})

ConfigProgrammatic.setOptions({
  defaultIconComponent:'font-awesome-icon',
  defaultIconPack: 'fas'
})


axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
