<template>
  <div class="goal-list-container" >
    <goal-card
    v-for="gl in $store.state.goals" v-bind:key="gl.id" v-bind:goal="gl"/>
  </div>
</template>

<script>
import GoalCard from './GoalCard.vue';
import GoalService from "../services/GoalService.js";


export default {
  name: "goal-list",
  components: { 
      GoalCard,
     
      },
      created(){
        GoalService.getAll().then((response)=>{
          if(response.status === 200){
          this.$store.commit('SET_GOALS', response.data);
          }
        });
      }
 
};

</script>

<style>
.goal-list-container {
  display: flex;
  justify-content: space-evenly;
  flex-direction: row;
  flex-wrap: wrap;
}
</style>