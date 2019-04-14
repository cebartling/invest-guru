<template>
  <div class="front-door mt-4">
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
      if (eventInfo === "signedIn") {
        this.$router.push({ name: "home" });
      } else if (eventInfo === "signedOut") {
        this.$router.push({ name: "frontDoor" });
      }
    });
  }
};
</script>

<style scoped>
.front-door {
}
</style>
