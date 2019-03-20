import axios from 'axios'

axios.defaults.baseURL = 'http://localhost/merit/api'
axios.defaults.headers['token'] = sessionStorage.getItem('token')

export default {
  getToken(context, payloads) {
    return axios.post('/user/token', payloads).then((res) => {
      if (!res.data.code || res.data.code !== 200) {
        console.error(res.data.msg)
        return false
      }
      context.commit('updateToken', {token: res.data.data.token})
    }).catch(function (err) {
      console.error(err.message)
    })
  },
  fetchOwnInfo(context, payloads) {
    return axios.get('/user/self', payloads).then((res) => {
      if (!res.data.code || res.data.code !== 200) {
        console.error(res.data.msg)
        return false
      }
      context.commit('updateSelfInfo', res.data.data)
    }).catch(function (err) {
      console.error(err.message)
    })
  },
  fetchUsers(context, {page, count}) {
    let start = (page-1)*count
    let end = start + count
    return axios.get('/user/list', {start, end}).then((res) => {
      if (!res.data.code || res.data.code !== 200) {
        console.error(res.data.msg)
        return false
      }
      context.commit('updateUsers', {users: res.data.data})
    }).catch(function (err) {
      console.error(err.message)
    })
  },
  deleteUser(context, { userId }) {
    return axios.delete('/user/'+userId).then((res) => {
      if(!res.data.code || res.data.code !== 200) {
        console.error(res.data.msg)
        return false
      }
      context.commit('deleteUser', {userId: userId})
    })
  }
}
