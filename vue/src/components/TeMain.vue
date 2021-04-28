<template>
  <div class="te-main">
    <div class="goal-container">
      <h3 class="title">Your Goals</h3>
      <goal-list />
    </div>
    <!--
    <div class="exercise-container">
      <h2 class="title">Your Exercises</h2>
      <exercise-list />
    </div>
    -->
  </div>
</template>

<script>
//import ExerciseList from "./ExerciseList.vue";
import GoalList from "./GoalList.vue";

export default {
  name: 'te-main',
  components: {
    GoalList,
    //ExerciseList,
  },
};
</script>

<style scoped>
.goal-container {
  display: flex;
  flex-direction: column;
  margin-top: 15px;
  margin-bottom: 90px;
  
}
.exercise-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}


</style>