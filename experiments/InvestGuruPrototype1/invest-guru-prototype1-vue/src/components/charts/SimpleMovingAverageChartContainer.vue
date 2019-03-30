<template>
  <div class="simple-moving-average-chart">
    <simple-moving-average-chart
      v-if="loaded"
      :chartdata="chartdata"
      :options="options"
    ></simple-moving-average-chart>
    <div class="alert alert-info" v-if="!loaded">
      Loading data...
    </div>
  </div>
</template>

<script>
import SimpleMovingAverageChart from "@/components/charts/SimpleMovingAverageChart";
import simpleMovingAverageAnalyticQuery from "@/graphql/SimpleMovingAverageAnalyticQuery";

export default {
  name: "SimpleMovingAverageChartContainer",
  components: { SimpleMovingAverageChart },
  data() {
    return {
      loaded: false,
      chartdata: null,
      options: { responsive: true, maintainAspectRatio: false }
    };
  },
  methods: {
    buildChartData() {
      // let observations = 0;
      // const today = moment();
      // while (observations < 10) {
      // }

      // const data1 = data.simpleMovingAverageAnalytic.averages50.map(
      //   observation => {
      //     // return { x: observation.date, y: observation.value };
      //     return observation.value;
      //   }
      // );
      // let data2 = data.simpleMovingAverageAnalytic.averages300.map(
      //   observation => {
      //     // return { x: observation.date, y: observation.value };
      //     return observation.value;
      //   }
      // );

      return {
        labels: [
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July"
        ],
        datasets: [
          {
            label: "Data One",
            backgroundColor: "#FC2525",
            data: [40, 39, 10, 40, 39, 80, 40]
          },
          {
            label: "Data Two",
            backgroundColor: "#05CBE1",
            data: [60, 55, 32, 10, 2, 12, 53]
          }
        ]
      };
    }
  },
  apollo: {
    simpleMovingAverageAnalytic: {
      query: simpleMovingAverageAnalyticQuery,
      variables() {
        return {
          symbol: "TSLA"
        };
      },
      fetchPolicy: "cache-and-network",
      result({ data, loading }) {
        if (!loading && data) {
          this.chartdata = this.buildChartData();
          this.loaded = true;
        }
      },
      error(error) {
        console.error("We've got an error!", error);
      }
    }
  }
};
</script>

<style scoped lang="scss">
.simple-moving-average-chart {
}
</style>
