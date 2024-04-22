<template>
  <div id="home">
    <div class="content">
      <a-space direction="vertical" fill>
        <a-card>
          <div class="font">借阅管理</div>
          <hr />
          <a-space direction="horizontal" align="center" fill>
            <a-form :model="form" :layout="'inline'">
              <a-form-item field="name" label="借阅人">
                <a-input v-model="searchParams.userName" placeholder="请输入" />
              </a-form-item>
              <a-form-item field="post" label="图书名称">
                <a-input v-model="searchParams.bookName" placeholder="请输入" />
              </a-form-item>
            </a-form>
            <div class="btn" style="right: 0; position: absolute">
              <a-button @click="doSearch" type="primary">查询</a-button>
              <a-button @click="doClear" type="text">重置</a-button>
            </div>
          </a-space>
        </a-card>
        <a-card>
          <div class="font">借阅信息</div>
          <a-table
            :pagination="{
              total,
              showTotal: true,
              pageSize: searchParams.pageSize,
              current: searchParams.current,
            }"
            :columns="columns"
            :data="data"
            @page-change="onPageChange"
          >
            <template #lendTime="{ record }">
              {{ moment(record.createTime).format("YYYY/MM/DD HH:mm:ss") }}
            </template>
            <template #backTime="{ record }">
              <div v-if="record.status == 2">
                {{ moment(record.updateTime).format("YYYY/MM/DD HH:mm:ss") }}
              </div>
            </template>
            <template #status="{ record }">
              <div v-if="record.status == 0">待借阅</div>
              <div v-else>已借阅</div>
            </template>
            <template #option="{ record }">
              <a-space>
                <a-button @click="option(record.id, 1)" type="text"
                  >借阅
                </a-button>
                <a-button @click="option(record.id, 2)" type="text"
                  >归还
                </a-button>
              </a-space>
            </template>
          </a-table>
        </a-card>
      </a-space>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, reactive, ref, watchEffect } from "vue";
import axios from "axios";
import moment from "moment";

const columns = [
  {
    title: "图书名称",
    dataIndex: "bookName",
  },
  {
    title: "借阅时间",
    slotName: "lendTime",
  },
  {
    title: "归还时间",
    slotName: "backTime",
  },
  {
    title: "借阅状态",
    slotName: "status",
  },
  {
    title: "借阅人",
    dataIndex: "userName",
  },
  {
    title: "操作",
    slotName: "option",
  },
];

const total = ref(0);

const form = reactive({
  name: "",
  post: "",
});

const data = ref([{}]);

const searchParams = ref({
  current: 1,
  pageSize: 10,
  userName: "",
  bookName: "",
});

const doClear = () => {
  searchParams.value = {
    ...searchParams.value,
    userName: "",
    bookName: "",
  };
};

const option = (id: number, status: number) => {
  axios
    .post("http://localhost:8080/book/option", { id, status })
    .then((res) => {
      console.log(res);
    });
};

const doSearch = () => {
  // search info
  axios
    .post("http://localhost:8080/book/list/page", {
      ...searchParams.value,
      current: 1,
    })
    .then((res) => {
      console.log(res);
      data.value = res.data.data.records;
      total.value = res.data.data.total;
    });
};

const onPageChange = (e: number) => {
  searchParams.value = {
    ...searchParams.value,
    current: e,
  };
};

const loadData = () => {
  axios
    .post("http://localhost:8080/book/list/page", {
      current: searchParams.value.current,
      pageSize: searchParams.value.pageSize,
    })
    .then((res) => {
      data.value = res.data.data.records;
      total.value = res.data.data.total;
    });
};

watchEffect(() => {
  loadData();
});

onMounted(() => {
  loadData();
});
</script>

<style scoped>
#home {
  width: 100vw;
}

.content {
  width: 80vw;
  margin: 0 auto;
}

.font {
  font-size: 20px;
  font-weight: bold;
  padding-bottom: 16px;
  text-align: left;
}
</style>
