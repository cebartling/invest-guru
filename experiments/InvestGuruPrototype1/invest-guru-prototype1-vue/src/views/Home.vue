<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
import HelloWorld from "@/components/HelloWorld.vue";
import simpleMovingAverageAnalyticQuery from "@/graphql/SimpleMovingAverageAnalyticQuery";

export default {
  name: "home",
  components: {
    HelloWorld
  },
  apollo: {
    simpleMovingAverageAnalytic: {
      query: simpleMovingAverageAnalyticQuery,
      variables: {
        symbol: "TSLA"
      },
      fetchPolicy: "cache-and-network"
    }
  }
};
</script>
