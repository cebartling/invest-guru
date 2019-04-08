<template>
  <div class="front-door">
    <amplify-authenticator></amplify-authenticator>
  </div>
</template>

<script>
import { AmplifyEventBus } from "aws-amplify-vue";

export default {
  name: "FrontDoor",
  data() {
    return {};
  },
  mounted() {
    AmplifyEventBus.$on("authState", eventInfo => {
      console.log("FrontDoor: Amplify emitted", eventInfo);
    });
  }
};
</script>

<style scoped>
.front-door {
}
</style>
