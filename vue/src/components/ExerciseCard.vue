<template>
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
      <img src="../assets/exerciseIcon.png" class="exerciseIcon" />
      <p> Wow! You
        <strong>{{ exercise.exerciseName }}</strong> for
      </p>
      <p>
        <strong>{{ exercise.exerciseLength }}</strong> minutes today!
      </p>
      <p>You burned {{ exercise.caloriesBurn }}!!!!!!</p>
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
      exerciseService.delete(id).then((response) => {
        if (response.status === 204) {
          this.$store.commit("DELETE_EXERCISE", id);
        }
      });
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
      this.$store.commit(
        "SET_CURRENT_EDITING_EXERCISE",
        this.exercise.userExerciseId
      );
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
  background-color: lightgreen;
}
.flexibility-exercise {
  background-color: lightsalmon;
}
.strength_exercise {
  background-color: lightyellow;
}
.endurance-exercise {
  background-color: lightskyblue;
}

.card {
  margin: 10px;
  margin-bottom: 20px;
}
</style>