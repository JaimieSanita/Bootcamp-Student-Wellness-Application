<template>
  <div class="container">
    <form class="box form">
      <section>
        <add-exercise v-show="isShowing" />
        <b-button type="is-primary" @click="isShowing ^= true">
          Let's Log an Exercise!
        </b-button>
      </section>
    </form>
  </div>
</template>

<script>
import addExercise from '../components/AddExercise.vue';
//import exerciseService from "../services/ExerciseService.js";
const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  components: {
    addExercise
  },
  data() {
    return {
     isShowing:false,
      newExercise: {
        userExerciseId:"",
        userId: "",
        exerciseCategoryId: "",
        exerciseName: "",
        date: "03/11/2021",
        duration: 0,
        caloriesBurned: 0,
        equipmentUsed: false,
      },
    };
  },
  computed: {
    assignDate: {
      get: function () {
        return new Date(this.newExercise.date);
      },
      set: function (dt) {
        this.newExercise.date = dt.toLocaleDateString(locale, dateFormat);
      },
    },
  },
  methods: {
    saveExercise() {
      this.newExercise.complete = false;
                this.$store.commit("ADD_NEW_EXERCISE", this.newExercise); 
          this.newExercise = {
            userExerciseId:"",
        userId: "",
        exerciseCategoryId: "",
        exerciseName: "",
        date: "01/01/2021",
        duration: 0,
        caloriesBurned: 0,
        equipmentUsed: false,
          };
        },
      },
};
</script>

<style scoped>
.box {
  display: inline-flex;
  align-items: center;
}
</style>