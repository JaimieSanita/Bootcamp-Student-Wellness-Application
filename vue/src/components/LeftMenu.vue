<template>
  <div class="menu">
    <new-goal-form>New Goal Form</new-goal-form>
    <new-exercise-form />
    <new-meal-form />
  </div>
</template>

<script>
import NewMealForm from "./NewMealForm";
import NewExerciseForm from "./NewExerciseForm.vue";
import NewGoalForm from "./NewGoalForm.vue";

export default {
  name: "left-menu",
  components: {
    NewGoalForm,
    NewExerciseForm,
    NewMealForm,
  },
};
</script>

<style>
.navbar {
  display: flex;
}
</style>