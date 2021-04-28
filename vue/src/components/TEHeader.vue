<template>
  <div class="header">
    <div class="banner-container">
      <div id="img">
      <img class="logo-image" src="../assets/logo.png" />
      </div>
      <div id="title">
      <h1 class="title">
        Welcome to {{ this.$store.state.profile.firstName }}'s Tech Wellovater!
      </h1>
      </div>
      <div id="nav">
        <b-button id="btn" outlined style="color: #8CC63F;"
          ><router-link
            id="link"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          ></b-button
        >
      </div>
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
  color: black;
  background-color: rgba(248, 248, 255, 0.5);
  display: flex;
  align-items: center;
  font-family: proxima-nova;
  height: 90px;
  
  margin-bottom: 10px;
  justify-content: space-between;
}
#img{
  display: flex;
  height: 90px;
   
}

#title{
  font: bold;
  padding: 5px;
  text-shadow: 1px 1px 1px #00adee;
  color: #3B3E42;
}

#nav {
  margin: 5px;
}
#link {
  color: black;
}

#link[data-v-4f3a458e] {
    color: #8CC63F;
}

</style>