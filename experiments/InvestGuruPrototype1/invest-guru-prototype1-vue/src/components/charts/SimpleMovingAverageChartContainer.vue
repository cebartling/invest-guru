<template>
  <div class="simple-moving-average-chart">
    <simple-moving-average-chart
      v-if="loaded"
      :chart-data="chartData"
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
import { takeRight, each, find } from "lodash";

export default {
  name: "SimpleMovingAverageChartContainer",
  components: { SimpleMovingAverageChart },
  props: {
    symbol: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      numberOfObservations: 30,
      loaded: false,
      chartData: null,
      options: { responsive: true, maintainAspectRatio: false }
    };
  },
  methods: {
    buildChartDataSets(data) {
      const lastAverage50Observations = takeRight(
        data.simpleMovingAverageAnalytic.averages50,
        this.numberOfObservations
      );
      const lastAverage300Observations = takeRight(
        data.simpleMovingAverageAnalytic.averages300,
        this.numberOfObservations
      );

      const labels = [];
      const observations50averages = [];
      const observations300averages = [];
      each(lastAverage50Observations, average50Observation => {
        const match = find(
          lastAverage300Observations,
          average300Observation => {
            return average300Observation.date === average50Observation.date;
          }
        );
        if (match) {
          labels.push(average50Observation.date);
          observations50averages.push(average50Observation.value);
          observations300averages.push(match.value);
        }
      });

      return {
        labels: labels,
        datasets: [
          {
            backgroundColor: "#fc6c71",
            borderColor: "#FC2525",
            borderWidth: 2,
            label: "50 day simple moving average",
            fill: false,
            pointBackgroundColor: "#FC2525",
            pointBorderColor: "#FC2525",
            data: observations50averages
          },
          {
            borderColor: "#05CBE1",
            borderWidth: 2,
            label: "300 day simple moving average",
            fill: false,
            backgroundColor: "#8dd1e1",
            pointBackgroundColor: "#05CBE1",
            pointBorderColor: "#05CBE1",
            data: observations300averages
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
          symbol: this.symbol
        };
      },
      fetchPolicy: "cache-and-network",
      result({ data, loading, error }) {
        if (!loading && !error && data) {
          this.chartData = this.buildChartDataSets(data);
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
  padding: 12px;
  border: 1.5px solid rgb(223, 223, 223);
  border-radius: 5px;
}
</style>
