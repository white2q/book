<template>
  <div id="login">
    <a-form
      layout="vertical"
      style="margin: 0 auto"
      :model="form"
      :style="{ width: '600px' }"
      @submit="handleSubmit"
    >
      <h2 style="margin-bottom: 16px">用户登录</h2>

      <a-form-item
        :rules="{
          required: true,
          message: '账号不能为空',
        }"
        field="userAccount"
        label="账号"
      >
        <a-input
          id="inp"
          v-model.trim="form.userAccount"
          placeholder="请输入账号(测试账号:test)"
        />
      </a-form-item>
      <a-form-item
        :rules="{
          required: true,
          message: '请确保密码不少于8位',
          minLength: 8,
        }"
        field="userPassword"
        label="密码"
      >
        <a-input-password
          v-model="form.userPassword"
          placeholder="请输入密码(测试密码：12345678)"
        />
      </a-form-item>

      <a-row class="grid-demo" style="margin-bottom: 16px">
        <a-col flex="auto">
          <a-button class="btn-login" type="primary" html-type="submit"
            >登录
          </a-button>
        </a-col>
      </a-row>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { onMounted, reactive } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";
import message from "@arco-design/web-vue/es/message";
import axios from "axios";

const router = useRouter();
const route = useRoute();
const store = useStore();

const form = reactive({
  userAccount: "",
  userPassword: "",
});

onMounted(() => {
  const user = store.state.loginUser;
  if (user != null) {
    form.userAccount = user.userAccount;
    form.userPassword = user.userPassword;
  }
});

const handleSubmit = async () => {
  axios.post("http://user/login", form).then((res) => {
    if (res.data.data.code === 0) {
      store.dispatch("user/getLoginUser");
      router.push({
        path: (route.query.redirect as string) || "/",
        replace: true,
      });
      return;
    } else {
      message.error("登录失败");
    }
  });
};
</script>

<style scoped>
#login .btn-login {
  width: 15vh;
  margin: 0 auto;
}
</style>
