import Vue from 'vue'
import VueRouter from 'vue-router'



Vue.use(VueRouter)

const routes = [
  {
    path: '',
    name: 'Manage',
    component: () => import('../views/MainManage.vue'),
    redirect: '/home',
    children:[
      {
        path: '/home',
        name: 'home',
        component: ()=>import('../views/Home')
      },

      {
        path: '/order',
        name: 'order',
        component: ()=>import('../views/order/OrderManage')
      },
      {
        path: '/test',
        name: 'test',
        component: ()=>import('../views/TestView')
      }
    ]

  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
