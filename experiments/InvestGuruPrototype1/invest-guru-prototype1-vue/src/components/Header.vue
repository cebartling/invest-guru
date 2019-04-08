<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Invest Guru</a>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item" v-if="isSignOutShown">
          <amplify-sign-out></amplify-sign-out>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import { AmplifyEventBus } from "aws-amplify-vue";

export default {
  name: "Header",
  data() {
    return {
      isSignOutShown: !!this.getCurrentAuthenticatedUser()
    };
  },
  methods: {
    async getCurrentAuthenticatedUser() {
      try {
        return await this.$Amplify.Auth.currentAuthenticatedUser({
          bypassCache: false
        });
      } catch (onRejected) {
        return undefined;
      }
    }
  },
  mounted() {
    AmplifyEventBus.$on("authState", function() {
      this.isSignOutShown = !!this.getCurrentAuthenticatedUser();
    });
  }
};
</script>

<style scoped></style>
