<template>
  <div class="header">
    <div class="banner-container">
      <div id="nav">
        <router-link
          id="link"
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </div>
    </div>
    <div class="hello-container">
      <img class="logo-image" src="../assets/logo.png" />
      <h1 class="title" style="position: relative; left: 180px">
        Welcome to {{ this.$store.state.profile.firstName }}'s Tech Wellovater!
      </h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "te-header",
};
</script>

<style scoped>
.banner-container {
  background-color: #8cc63f;
  color: black;
  display: flex;
  justify-content: flex-end;
}
.hello-container {
  background-color: #00adee;
  display: flex;
  justify-content: flex-start;
  font-family: proxima-nova;
  height: 90px;
  margin-top: 10px;
  margin-bottom: 10px;
}
h1 {
  color: black;
  display: flex;
  padding: 30px;
  position: relative;
  padding-left: 24%;
}

#nav {
 margin: 5px;
  
}
#link {
  color: white;
}
</style>