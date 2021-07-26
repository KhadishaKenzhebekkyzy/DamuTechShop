import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

import SignIn from './pages/enter/SignIn.vue'
import SignUp from './pages/enter/SignUp.vue'
import App from './App.vue'
import IntroPage from './pages/main/IntroPage.vue'
import Items from './pages/main/Items.vue'
import Cart from './pages/user/Cart.vue'

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'introPage',
      component: IntroPage,
      children: [{
        path: '/category-:id/',
        name: 'items',
        component: Items,
      }]
    },
    {
      path: '/sign-in',
      name: 'signIn',
      component: SignIn
    },
    {
      path: '/sign-up',
      name: 'signUp',
      component: SignUp
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart
    },
    {
      path: '*',
      name: 'error',
      component: Error
    }
  ]
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
