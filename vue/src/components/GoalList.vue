<template>
  <div class="goal-container" >
    <goal-card
    v-for="gl in $store.state.goals" v-bind:key="gl.id" v-bind:goal="gl"/>
  </div>
</template>

<script>
import GoalCard from '../components/GoalCard.vue';
export default {
  components: { 
      GoalCard 
      },
  name: "goal-list",
};

</script>

<style>
.goal-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>