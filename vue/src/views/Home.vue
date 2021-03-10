<template>
  <div class="home">
    <div class="banner-container">
      <h3 class="banner-title">Never forget, you're always elevating!</h3>
    </div>
    <div class="welcome-container">
      <h1 class="title">
        Welcome to {{ this.$store.state.profile.firstName }}'s TE Wellness
        Tracker!
      </h1>
    </div>
    <new-goal-form />
    <goal-list />

    <div class="container">
      <add-food />
      <add-exercise />
    </div>
  </div>
</template>

<script>
import AddExercise from "../components/AddExercise.vue";
import AddFood from "../components/AddFood";
import GoalList from "../components/GoalList";
import NewGoalForm from "../components/NewGoalForm.vue";

export default {
  name: "home",
  components: {
    AddFood,
    AddExercise,
    GoalList,
    NewGoalForm,
  },
};
</script>
<style scoped>
.container {
  display: flex;
  justify-content: space-evenly;
}

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
h1{
  color: white;
  display: flex;
  padding: 30px;

}

</style>
