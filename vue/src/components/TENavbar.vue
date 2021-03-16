<template>
<div class="menu">
 <new-goal-form >New Goal Form</new-goal-form>
    <new-exercise-form/>
      <goal-list />
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
.navbar{
  display: flex;
}


</style>