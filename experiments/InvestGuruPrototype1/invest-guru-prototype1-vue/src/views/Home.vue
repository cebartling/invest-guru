<template>
  <div class="home">
    <h1>Home</h1>
    <div>
      <simple-moving-average-chart-container></simple-moving-average-chart-container>
    </div>
  </div>
</template>

<script>
import simpleMovingAverageAnalyticQuery from "@/graphql/SimpleMovingAverageAnalyticQuery";
import SimpleMovingAverageChartContainer from "@/components/charts/SimpleMovingAverageChartContainer";

export default {
  name: "home",
  components: { SimpleMovingAverageChartContainer }
};
</script>
