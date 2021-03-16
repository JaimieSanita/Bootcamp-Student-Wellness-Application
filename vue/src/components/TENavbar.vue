<template>
<div class="navbar">
 <new-goal-form >New Goal Form</new-goal-form>
    <new-exercise-form/>
    <div class="goal-container">
      <goal-list />
    </div>

</div>
  
</template>

<script>
import GoalList from "../components/GoalList";
import NewExerciseForm from "./NewExerciseForm.vue";

import NewGoalForm from "./NewGoalForm.vue";
export default {
  name:"te-navbar",
  components: {
    GoalList,
    NewGoalForm,
    NewExerciseForm,
  },
};
</script>

<style>
.container {
  display: flex;
  justify-content: space-evenly;
}

.goal-container {
  margin-top: 20px;
  display: flex;
}
.exercise-container {
  margin-top: 20px;
  display: flex;
}
</style>