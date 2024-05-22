import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router';
// import { loadLayoutMiddleware } from "./middleware/loadLayoutMiddleware";

import Home from '../pages/Home.vue';
import Login from '../pages/Login.vue';
import Register from '../pages/Register.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {layout: 'LayoutDefault'}
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {layout: 'LayoutDefault'}
  },
  
  {
    path: '/register',
    name: 'Register',
    component: Register,
    meta: {layout: 'LayoutUser'}
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});


export default router;