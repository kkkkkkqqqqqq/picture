<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import zhCN from 'ant-design-vue/es/locale/zh_CN';
import dayjs from 'dayjs';
import 'dayjs/locale/zh-cn';
import { ref } from 'vue';

// 设置 dayjs 语言
dayjs.locale('zh-cn');

// 设置 Ant Design Vue 语言
const locale = ref(zhCN);
</script>

<template>
  <div id="app">
    <a-config-provider :locale="locale">
      <BasicLayout />
    </a-config-provider>
  </div>
</template>

