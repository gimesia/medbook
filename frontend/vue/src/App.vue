<template>
  <component :is="layout">
    <router-view></router-view>
  </component>
</template>

<script>
import { computed } from "vue";
import { useRoute } from "vue-router";
import LayoutDefault from "./layouts/LayoutDefault.vue";
import LayoutUser from "./layouts/LayoutUser.vue";

export default {
  name: "App",
  components: {
    LayoutDefault,
    LayoutUser,
  },
  setup() {
    const route = useRoute();
    const layout = computed(() => {
      return route.meta.layout || "LayoutDefault";
    });
    return { layout };
  },
};
</script>

<style>
/* Add your styles here */
</style>
