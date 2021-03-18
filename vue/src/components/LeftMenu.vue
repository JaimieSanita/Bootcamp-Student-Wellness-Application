<template>
  <div class="menu">
    <new-goal-form/>
    <new-exercise-form />
    <new-meal-form/>
    
  </div>
</template>

<script>

import NewExerciseForm from "./NewExerciseForm.vue";
import NewGoalForm from "./NewGoalForm.vue";
import NewMealForm from './NewMealForm.vue';

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
menu{
  width: 200;
}

</style>