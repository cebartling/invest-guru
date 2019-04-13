import Vue from "vue";
import Router from "vue-router";
import Home from "@/views/Home.vue";
import FrontDoor from "@/views/FrontDoor";

Vue.use(Router);

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "frontDoor",
      component: FrontDoor,
      meta: { requiresAuth: false }
    },
    {
      path: "/home",
      name: "home",
      component: Home,
      meta: { requiresAuth: true }
    }
  ]
});

router.beforeResolve(async (to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    try {
      await Vue.prototype.$Amplify.Auth.currentAuthenticatedUser();
      next();
    } catch (e) {
      next({
        path: "/",
        query: {
          redirect: to.fullPath
        }
      });
    }
  }
  next();
});

export default router;
