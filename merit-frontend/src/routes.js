import Login from './views/Login.vue'
import NotFound from './views/404.vue'
import Home from './views/Home.vue'
import Table from './views/nav1/UsersList.vue'
import user from './views/nav1/UserInfo.vue'
import Clazz from './views/nav1/Clazz.vue'
import Course from './views/nav1/Course.vue'
import Specialty from './views/nav1/Specialty.vue'
import Lab from './views/nav1/Lab.vue'
import Arrange from './views/nav1/Arrange.vue'
import Arranges from './views/nav1/Arranges.vue'

let routes = [
  {
    path: '/login',
    component: Login,
    name: '',
    hidden: true,
    alias: '/'
  },
  {
    path: '/404',
    component: NotFound,
    name: '',
    hidden: true
  },
  {
    path: '/home/user',
    component: Home,
    name: '用户管理',
    iconCls: 'el-icon-message',
    children: [
      {path: '/home/user/me/', component: user, name: '我的信息'},
      {path: '/home/user/users/', component: Table, name: '用户列表'},
    ]
  },
  {
    path: '/home/teaching',
    component: Home,
    name: '教务管理',
    iconCls: 'fa fa-id-card-o',
    children: [
      {path: '/home/teaching/clazz/', component: Clazz, name: '班级管理'},
      {path: '/home/teaching/course/', component: Course, name: '课程管理'},
      {path: '/home/teaching/specialty/', component: Specialty, name: '专业管理'}
    ]
  },
  {
    path: '/home/lab',
    component: Home,
    name: '机房排课',
    iconCls: 'fa fa-id-card-o',
    children: [
      {path: '/home/lab/', component: Lab, name: '机房管理'},
      {path: '/home/lab/arranges/', component: Arranges, name: '自由排课'},
      {path: '/home/lab/arrange/', component: Arrange, name: '批量排课'}
    ]
  }
];

export default routes;
