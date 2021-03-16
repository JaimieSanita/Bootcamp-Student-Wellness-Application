<template>
  <div class="header">
    <div class="banner-container">
      <h3 class="banner-title">Never forget, you're always elevating!</h3>
    </div>
    <div class="welcome-container">
      <h1 class="title">
        Welcome to {{ this.$store.state.profile.firstName }}'s Tech Wellovater!
      </h1>
    </div>
  </div>
</template>

<script>
export default {
  name:"te-header"
};
</script>

<style scoped>
.banner-container {
  background-color: #8cc63f;
  color: white;
  display: flex;
  justify-content: center;
}
.welcome-container {
  background-color: #00adee;
  display: flex;
  justify-content: space-around;

  height: 90px;
  margin: 10px;
}
h1 {
  color: white;
  display: flex;
  padding: 30px;
}
</style>