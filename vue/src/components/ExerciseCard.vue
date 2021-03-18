<template>
<div class="box">
  <div class="card">
    <header
      v-bind:class="{
        'balance-exercise': exercise.exerciseCategoryId === 1,
        'flexibility-exercise': exercise.exerciseCategoryId === 2,
        'strength-exercise': exercise.exerciseCategoryId === 3,
        'endurance-exercise': exercise.exerciseCategoryId === 4,
      }"
    >
      <p class="card-header-title">{{ exercise.date }}'s Exercise</p>
    </header>
    <div class="card-content">
      <h3 class="congratulations">CONGRATULATIONS!</h3>
      <img src="../assets/balance.png" class="balanceIcon" v-if="exercise.exerciseCategoryId === 1"/>
      <img src="../assets/flexibility.png" class="flexibilityIcon" v-if="exercise.exerciseCategoryId === 2"/>
      <img src="../assets/strength.png" class="strengthIcon" v-if="exercise.exerciseCategoryId === 3"/>
      <img src="../assets/endurance.png" class="enduranceIcon" v-if="exercise.exerciseCategoryId === 4"/>
      <div class="message">
      <p> You did
        <strong>{{ exercise.exerciseName }}</strong>
      </p>
      <p>  for
        <strong>{{ exercise.exerciseLength }}</strong> minutes today!
      </p>
      <p>You burned {{ exercise.caloriesBurn }} calories.</p>
      </div>
    </div>
    <footer class="card-footer">
      <a href="#" class="card-footer-item" v-on:click.prevent="editExercise"
        >Edit</a
      >
      <a
        href="#"
        class="card-footer-item"
        v-on:click.prevent="deleteExercise(exercise.userExerciseId)"
        >Delete</a
      >
    </footer>
  </div>
  </div>
</template>

<script>
import exerciseService from "../services/ExerciseService.js";

export default {
  name: "exercise-card",
  props: ["exercise"],
  components: {},
  data() {
    return {
      selectedCategory: "",
      isComplete: false,
    };
  },
  methods: {
    exerciseColorChanger() {
      this.$store.commit("CHANGE_COLOR", this.exercise);
    },
    ExerciseStatusChanger() {
      this.$store.commit("FLIP_STATUS", this.Exercise);
      alert("Congrats! You did it!");
    },
    deleteExercise(id) {
      if( confirm("Are you sure you want to delete this exercise?")){
      exerciseService.delete(id).then((response) => {
        if (response.status === 204) {
          this.$store.commit("DELETE_EXERCISE", id);
        }
      });
      }
    },
    updateExercise(exercise) {
      exerciseService
        .updateExercise(this.$store.state.user.username, exercise)
        .then((response) => {
          if (response.status === 201) {
            this.$store.commit("UPDATE_EXERCISE", exercise);
          }
        });
    },
    editExercise() {
      this.$store.commit("SET_CURRENT_EDITING_EXERCISE", this.exercise.userExerciseId);
    },
  },
};
</script>

<style scoped>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  height: 50px;
  width: 50px;
}
.exercise {
  border: 2px solid black;
  border-radius: 10px;
  width: 200px;
  height: auto;
  margin: 20px;
}

.exercise .exercise-complete {
  font-size: 1.5rem;
}
.balance-exercise {
  background-color: green;
}
.flexibility-exercise {
  background-color: rgb(1, 151, 1);
}
.strength-exercise {
  background-color: rgb(2, 196, 2);
}
.endurance-exercise {
  background-color: rgb(4, 228, 4);
}

.card {
  margin: 10px;
  margin-bottom: 20px;
    width: 200px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
.congratulations{
  color: gold;
  margin-bottom: 5px;
}
.card{
  flex: 1 1 0px;
  transition: transform 300ms ease 100ms;
}
.card-header-title{
  justify-content: center;
}
.message{
  background-color: white;
  align-items: center;
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