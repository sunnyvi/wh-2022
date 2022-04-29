import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import request from "@/utils/request";
import store from './store'
import myAxios from './assets/axios_link'
import  './utils/dialog_config'

Vue.config.productionTip = false

Vue.use(ElementUI,{size:"mini"});

Vue.prototype.requests = request

Vue.prototype.myAxios = myAxios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
