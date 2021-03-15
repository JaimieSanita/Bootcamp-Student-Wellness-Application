<template>
  <div class="card">
    <header v-bind:class="{
        'exercise-goal': goal.categoryId === 1,
        'nutrition-goal': goal.categoryId === 2,
        'sanity-goal': goal.categoryId === 3,
      }">
      <p class="card-header-title">{{ goal.date }}'s Goal</p>
    </header>
    <div class="card-content">
      <div class="content">
        <p>{{ goal.category }}</p>
        <p>{{ goal.activity }}</p>
        <p>{{ goal.duration }} minutes</p>
      </div>
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
      <a href="#" class="card-footer-item">Edit</a>
      <a href="#" class="card-footer-item" v-on:click="deleteGoal(goal.userGoalsId)"
        >Delete</a
      >
    </footer>
  </div>
</template>

<script>
import goalService from "../services/GoalService.js";

export default {
  name: "goal-card",
  props: ["goal"],
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
      goalService.delete(id).then((response)=>{
      if(response.status === 204){
      this.$store.commit("DELETE_GOAL", id);
       }
       });
    },
  },
};
</script>

<style>
.goal {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: auto;
  margin: 20px;
}

.goal .goal-complete {
  font-size: 1.5rem;
}
.exercise-goal {
  background-color: lightgreen;
}
.nutrition-goal {
  background-color: lightsalmon;
}
.sanity-goal {
  background-color: lightyellow;
}
</style>