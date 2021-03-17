<template>
  <div class="exercise-container" >
    <exercise-card
    v-for="ex in $store.state.exercises" v-bind:key="ex.id" v-bind:exercise="ex"/>
  </div>
</template>

<script>
import ExerciseCard from './ExerciseCard.vue';
import ExerciseService from "../services/ExerciseService.js";


export default {
  name: "exercise-list",
  components: { 
      ExerciseCard,
     
      },
      created(){
        ExerciseService.getAllExercise().then((response)=>{
          if(response.status === 200){
          this.$store.commit('SET_EXERCISES', response.data);
          }
        });
      }
 
};

</script>

<style>
.goal-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>