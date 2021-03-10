<template>
  <div class="home">
    <h1 class="title">Welcome to {{this.$store.state.user.username}}'s TE Wellness Tracker!</h1>
     <new-goal-form/>
     <goal-list/>
    
    <div class="container">
     
    <add-food/>
    <add-exercise/>
    
    </div>
  </div>
</template>

<script>
import AddExercise from '../components/AddExercise.vue';
import AddFood from "../components/AddFood";
import GoalList from "../components/GoalList"
import NewGoalForm from '../components/NewGoalForm.vue';



export default {
  name: "home",
  components: { 
    AddFood,
    AddExercise,
    GoalList,
    NewGoalForm
    
     },
};
</script>
<style scoped>
.container{
  display: flex;
  justify-content: space-evenly;
}
h1{
  display: flex;
  justify-content: center;
}

</style>
