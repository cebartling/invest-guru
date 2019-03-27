import Vue from "vue";
import App from "@/App.vue";
import router from "@/router";
import store from "@/store";
import apolloProvider from "@/appsync";
import BootstrapVue from "bootstrap-vue";

Vue.config.productionTip = false;

Vue.use(BootstrapVue);

new Vue({
  router,
  store,
  apolloProvider,
  render: h => h(App)
}).$mount("#app");
