<template>
  <div class="container">
    <form class="box form">
      <section>
        <b-field
          label="Let's log an exercise!"
          type="is-primary"
          v-if="!this.$store.state.currentEditingExercise"
        >
          <b-select
            v-model="selectedCategory"
            placeholder="Category"
            :expanded="true"
          >
            <option value=""></option>
            <option value="balance">Balance</option>
            <option value="flexibility">Flexibility</option>
            <option value="strength">Strength</option>
            <option value="endurance">Endurance</option>
          </b-select>
        </b-field>

        <add-strength-form
          v-if="selectedCategory === 'strength'"
          :exisitingExercise="currentExercise"
        />
        <add-flexibility-form
          v-if="selectedCategory === 'flexibility'"
          :exisitingExercise="currentExercise"
        />
        <add-balance-form
          v-if="selectedCategory === 'balance'"
          :exisitingExercise="currentExercise"
        />
        <add-endurance-form
          v-if="selectedCategory === 'endurance'"
          :exisitingExercise="currentExercise"
        />
      </section>
    </form>
  </div>
</template>

<script>
import addStrengthForm from "../components/AddStrengthForm.vue";
import ExerciseService from "../services/ExerciseService.js";
import AddBalanceForm from "./AddBalanceForm.vue";
import AddEnduranceForm from "./AddEnduranceForm.vue";
import AddFlexibilityForm from "./AddFlexibilityForm.vue";
const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  components: {
    addStrengthForm,
    AddFlexibilityForm,
    AddBalanceForm,
    AddEnduranceForm,
  },
  data() {
    return {
      currentExercise: null,
      selectedCategory: "",
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
  watch: {
    "$store.state.exercises": function () {
      this.$store.commit("SET_CURRENT_EDITING_EXERCISE", null);
      this.selectedCategory = "";
      this.currentExercise = null;
    },
    "$store.state.currentEditingExercise": function () {
      const exerciseId = this.$store.state.currentEditingExercise;
      if (exerciseId) {
        this.selectedCategory = "";
        ExerciseService.getExerciseById(exerciseId).then((response) => {
          this.currentExercise = response.data;
          this.selectedCategory = this.currentExercise.exerciseCategory;
        });
      }
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