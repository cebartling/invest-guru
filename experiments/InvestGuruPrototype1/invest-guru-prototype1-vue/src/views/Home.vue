<template>
  <div class="home">
    <h1>{{ symbol }}</h1>
    <div>
      <simple-moving-average-chart-container
        :symbol="symbol"
      ></simple-moving-average-chart-container>
    </div>
  </div>
</template>

<script>
import SimpleMovingAverageChartContainer from "@/components/charts/SimpleMovingAverageChartContainer";

export default {
  name: "home",
  data() {
    return {
      symbol: "TSLA"
    };
  },
  components: { SimpleMovingAverageChartContainer }
};
</script>
