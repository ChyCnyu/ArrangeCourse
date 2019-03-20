import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions'
import mutations from './mutations'

Vue.use(Vuex)

const state = {
  token: null,
  ownInfo: {name:"",id:"",email:"",phone:"",active:false,roleName:''},
  users: [
    {id: '201432559951', name: '李明', email: 'liming@qq.com', phone: '17266994312', active: true, roleName: '管理员'},
    {id: '201631063222', name: '油瓶大佬', email: 'youp@yypp.com', phone: '13123988923', active: true, roleName: '管理员'},
    {id: '200723395213', name: '张大中', email: 'zdz01@merit.com', phone: '15283229908', active: true, roleName: '管理员'},
    {id: '199702331483', name: '刘文轩', email: '199702331483@merit.com', phone: '18129019948', active: true, roleName: '教师'},
    {id: '201129459896', name: '房鹏', email: '201129459896@merit.com', phone: '13555120983', active: true, roleName: '教师'},
    {id: '200592985123', name: '黄娇', email: '200592985123@merit.com', phone: '17783820019', active: true, roleName: '教师'},
    {id: '209521487709', name: '吕星紫阳', email: '209521487709@merit.com', phone: '18200914432', active: true, roleName: '教师'},
    {id: '201194399110', name: '浪里浪', email: '88fa023@merit.com', phone: '18824001998', active: true, roleName: '教师'}
  ],
  classes: [
    {id: '3106', grade: 2016, specialty: '网络工程', courseId: '22301149'},
    {id: '4313', grade: 2016, specialty: '地质勘测', courseId: '32298842'},
    {id: '2201', grade: 2017, specialty: '社会工程', courseId: '29863278'},
    {id: '2223', grade: 2015, specialty: '地质勘测', courseId: '32298842'},
    {id: '2292', grade: 2018, specialty: '社会工程', courseId: '33591098'},
    {id: '3442', grade: 2015, specialty: '逆向工程', courseId: '22301149'},
    {id: '3243', grade: 2017, specialty: '网络工程', courseId: '22301149'},
    {id: '4229', grade: 2018, specialty: '乱入专业', courseId: '21299853'},
  ],
  courses: [
    {id: '22301149', name: 'Kali渗透测试', total: 80, exp: 40},
    {id: '32298842', name: '上山挖矿实践', total: 32, exp: 32},
    {id: '21299853', name: '精通Python Web开发', total: 120, exp: 36},
    {id: '29863278', name: '脚本小子的个人修养', total: 16, exp: 0},
    {id: '33591098', name: '后渗透理论与实践', total: 40, exp: 20},
  ],
  specialty: [
    {id: '91295322', name: '网络工程'},
    {id: '88401943', name: '地质勘测'},
    {id: '93352134', name: '社会工程'},
    {id: '89223452', name: '逆向工程'},
    {id: '47895298', name: '乱入专业'},
  ],
  arrangements: [
    {id: 1, clazzId: '3106', week: 8, weekDay: 2, seq: 4},
    {id: 2, clazzId: '3106', week: 8, weekDay: 2, seq: 5},
    {id: 3, clazzId: '3106', week: 8, weekDay: 5, seq: 6},
    {id: 4, clazzId: '3106', week: 8, weekDay: 5, seq: 7},
    {id: 5, clazzId: '3106', week: 9, weekDay: 1, seq: 5},
    {id: 6, clazzId: '3106', week: 9, weekDay: 3, seq: 5},
    {id: 7, clazzId: '3106', week: 9, weekDay: 5, seq: 6},
    {id: 8, clazzId: '3106', week: 9, weekDay: 5, seq: 7},
  ]
}

export default new Vuex.Store({
    actions,
    mutations,
    state
})
