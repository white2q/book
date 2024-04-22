import { RouteRecordRaw } from "vue-router";
import IndexView from "@/views/IndexView.vue";
import LoginView from "@/views/LoginView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "主页",
    component: IndexView,
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
];
