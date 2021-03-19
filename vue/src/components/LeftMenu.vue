<template>
  <div class="menu">
    <div class="goals">
    <new-goal-form/>
    </div>
    <div class="exercise">
    <new-exercise-form />
    </div>
    <div class="meal">
    <new-meal-form/>
    </div>
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
.goals{
padding: 20px;
}
.exercise{
padding:20px;
}
.meal{
padding: 20px;
}

</style>