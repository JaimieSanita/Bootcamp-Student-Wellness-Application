<template>


  <div class="card">
    <header v-bind:class="{
        'exercise-goal': goal.categoryId === 1,
        'nutrition-goal': goal.categoryId === 2,
        'sanity-goal': goal.categoryId === 3,
      }">
      <p class="card-header-title">{{ goal.date }}'s Goal</p>
    </header>
    <div class="card-content" style="text-align: center;">
        <exercise-goal-content v-if="goal.categoryId === 1" v-bind:key="goal.userId" v-bind:goal="goal"/>
        <nutrition-goal-content v-if="goal.categoryId === 2" v-bind:key="goal.userId" v-bind:goal="goal"/>
        <sanity-goal-content v-if="goal.categoryId === 3" v-bind:key="goal.userId" v-bind:goal="goal"/>
    </div>
    <div id="checkbox" style="text-align: center;">
    <b-field>
            <b-checkbox v-model="checkboxCustom"
                true-value="Complete"
                false-value="Incomplete">
                {{ checkboxCustom }}
            </b-checkbox>
        </b-field>
  </div>
    <footer class="card-footer">
      <a href="#" class="card-footer-item" v-on:click.prevent="editGoal">Edit</a>
      <a href="#" class="card-footer-item" v-on:click.prevent="deleteGoal(goal.userGoalsId)"
        >Delete</a
      >
    </footer>
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
       checkbox: false,
      checkboxCustom: 'Incomplete'
 
    };
  },

  methods: {
    goalColorChanger() {
      this.$store.commit("CHANGE_COLOR", this.goal);
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
.card {
 margin: 10px;
  margin-bottom: 20px;
    max-width: 250px;
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
.card-content{
  justify-content: center;
}

.box:hover .card {
  transform: translateX(-25%);
}

.card:hover ~ .card {
  transform: translateX(25%);
}

.card:hover {
  transform: scale(1.5);
}

body {
  overflow: hidden;
}
.complete{
  background-color: #999999;
}




</style>