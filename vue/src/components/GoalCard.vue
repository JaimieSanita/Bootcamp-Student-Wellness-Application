<template>

<div class="box">
  <div class="card">
    <header v-bind:class="{
        'exercise-goal': goal.categoryId === 1,
        'nutrition-goal': goal.categoryId === 2,
        'sanity-goal': goal.categoryId === 3,
      }">
      <p class="card-header-title">{{ goal.date }}'s Goal</p>
    </header>
    <div class="card-content">
        <exercise-goal-content v-if="goal.categoryId === 1" v-bind:key="goal.userId" v-bind:goal="goal"/>
        <nutrition-goal-content v-if="goal.categoryId === 2" v-bind:key="goal.userId" v-bind:goal="goal"/>
        <sanity-goal-content v-if="goal.categoryId === 3" v-bind:key="goal.userId" v-bind:goal="goal"/>
    </div>
  <!--  <b-button
      v-bind:class="{
        'goal-incomplete': goal.complete,
        'goal-complete': !goal.complete,
      }"
      v-on:click="goalStatusChanger()"
      :expanded="true"
    >
      {{ goal.complete ? "Complete" : "Incomplete" }}
    </b-button> -->

    <footer class="card-footer">
      <a href="#" class="card-footer-item" v-on:click.prevent="editGoal">Edit</a>
      <a href="#" class="card-footer-item" v-on:click.prevent="deleteGoal(goal.userGoalsId)"
        >Delete</a
      >
    </footer>
  </div>
  </div>
  
</template>

<script>
import goalService from "../services/GoalService.js";
import exerciseGoalContent from "../components/ExerciseGoalContent.vue";
import nutritionGoalContent from "../components/NutritionGoalContent.vue";
import sanityGoalContent from "../components/SanityGoalContent.vue";


export default {
  name: "goal-card",
  props: ["goal"],
  components: {
    exerciseGoalContent,
    nutritionGoalContent,
    sanityGoalContent,

  },
  data() {
    return {
      selectedCategory: "",
      isComplete: false,
 
    };
  },

  methods: {
    goalColorChanger() {
      this.$store.commit("CHANGE_COLOR", this.goal);
    },
    goalStatusChanger() {
      this.$store.commit("FLIP_STATUS", this.goal);
      alert("Congrats! You did it!");
    },
    deleteGoal(id) {
     if( confirm("Are you sure you want to delete this goal?")){
      goalService.delete(id).then((response)=>{
      if(response.status === 204){
      this.$store.commit("DELETE_GOAL", id);
       }
       });
     }
    },
    updateGoal(goal){
      goalService.update(this.$store.state.user.username, goal).then((response)=>{
        if(response.status === 201){
          this.$store.commit("UPDATE_GOAL", goal);
        }
      });
    },
    editGoal(){
      this.$store.commit('SET_CURRENT_EDITING_GOAL', this.goal.userGoalsId);
    },
  },
};
</script>

<style>
.goal {
  border: 2px solid black;
  border-radius: 10px;
  width: 200px;
  height: auto;
  margin: 20px;
}
.card{
 margin: 10px;
  margin-bottom: 20px;
    width: 200px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.goal .goal-complete {
  font-size: 1.5rem;
}
.exercise-goal {
  background-color: #8CC63F;
}
.nutrition-goal {
  background-color: #00ADEE;
}
.sanity-goal {
  background-color: #999999;
}
.card{
  flex: 1 1 0px;
  transition: transform 300ms ease 100ms;
}
.card-header-title{
  justify-content: center;
}

.box:hover .card {
  transform: translateX(-25%);
}

.card:hover ~ .card {
  transform: translateX(25%);
}

.box .card:hover {
  transform: scale(1.5);
}

body {
  overflow: hidden;
}




</style>