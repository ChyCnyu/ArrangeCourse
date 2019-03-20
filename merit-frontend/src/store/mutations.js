//test
export default {
  updateToken(state, {token}) {
    state.token = token
    sessionStorage.setItem('token', token)
  },
  updateSelfInfo(state, payloads) {
    state.ownInfo = payloads
    console.log(state.ownInfo)
  },
  deleteUser(state, { userId }) {
    for(let i in state.users) {
      if(state.users[i] === userId) {
        state.users.pop(i)
      }
    }
  }
}
