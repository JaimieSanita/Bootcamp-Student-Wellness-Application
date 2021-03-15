<template>
  <div class="container">
    <form class="box form">
      <section>
        <b-field label="Let's set a goal!" type="is-info">
          <b-select
            v-model="selectedCategory"
            placeholder="Category"
            :expanded="true"
          >
            <option value=""></option>
            <option value="Exercise">Exercise</option>
            <option value="Nutrition">Nutrition</option>
            <option value="Sanity">Sanity</option>
          </b-select>
        </b-field>

        <add-exercise-goal v-if="selectedCategory === 'Exercise'" />
        <add-nutrition-goal v-if="selectedCategory === 'Nutrition'" />
        <add-sanity-goal v-if="selectedCategory === 'Sanity'" />
      </section>
    </form>
  </div>
</template>

<script>
import AddExerciseGoal from "./AddExerciseGoal.vue";
import AddNutritionGoal from "./AddNutritionGoal.vue";
import AddSanityGoal from "./AddSanityGoal.vue";

const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  components: {
    AddExerciseGoal,
    AddNutritionGoal,
    AddSanityGoal,
  },
  data() {
    return {
      newGoal: {
        userId: "",
        category: "",
        categoryId: "",
        activtity: "",
        date: "03/11/2021",
        perWeek: 0,
        duration: 0,
        complete: false,
      },
      selectedCategory: "",
    };
  },
  computed: {
    assignDate: {
      get: function () {
        return new Date(this.newGoal.date);
      },
      set: function (dt) {
        this.newGoal.date = dt.toLocaleDateString(locale, dateFormat);
      },
    },
  },
  methods: {
    saveGoal() {
      this.newGoal.complete = false;
      this.$store.commit("ADD_NEW", this.newGoal);
      this.newGoal = {
        userId: "",
        categoryId: "",
        category: "",
        activtity: "",
        date: "01/01/1900",
        perWeek: 0,
        duration: 0,
        complete: false,
      };
    },
  },
};
</script>

<style>
</style>