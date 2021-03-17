<template>
  <div class="te-main">
    <div class="goal-container">
      <h1 class="title">Your Goals</h1>
      <goal-list />
    </div>
    <div class="exercise-container">
      <h1 class="title">Your Exercises</h1>
      <exercise-list />
    </div>
  </div>
</template>

<script>
import ExerciseList from "./ExerciseList.vue";
import GoalList from "./GoalList.vue";

export default {
  name: 'te-main',
  components: {
    GoalList,
    ExerciseList,
  },
};
</script>

<style scoped>
.goal-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
  margin-bottom: 20px;
}
.exercise-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
  margin-bottom: 20px;
}
.te-main {
  margin-left: 20px;
}

</style>