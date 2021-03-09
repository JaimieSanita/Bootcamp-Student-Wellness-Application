<template>
  <div class="home">
    <h1 class="title">Welcome to {{this.$store.state.user.username}}'s TE Wellness Tracker!</h1>
    <div class="container">
    <add-food/>
    <add-exercise/>
    </div>
  </div>
</template>

<script>
import AddExercise from '../components/AddExercise.vue';
import AddFood from "../components/AddFood"

export default {
  name: "home",
  components: { 
    AddFood,
    AddExercise },
};
</script>
<style scoped>
.container{
  display: flex;
  justify-content: space-evenly;
}
h1{
  display: flex;
  justify-content: center;
}

</style>
