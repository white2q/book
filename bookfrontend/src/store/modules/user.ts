import { StoreOptions } from "vuex";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {},
  }),
  getters: {},
  // 异步
  actions: {},
  // crud
  mutations: {
    updateUser(state: { loginUser: any }, data: any) {
      state.loginUser = data;
    },
  },
} as StoreOptions<any>;
