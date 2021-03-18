<template>
  <div class="menu">
    <new-goal-form>New Goal Form</new-goal-form>
    <new-exercise-form />
    
  </div>
</template>

<script>

import NewExerciseForm from "./NewExerciseForm.vue";
import NewGoalForm from "./NewGoalForm.vue";

export default {
  name: "left-menu",
  components: {
    NewGoalForm,
    NewExerciseForm,

  },
};
</script>

<style>
.navbar {
  display: flex;

}

</style>