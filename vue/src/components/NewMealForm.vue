<template>
  <div class="container">
    <form class="box form">
      <section>
        <b-field label="Let's log a meal!" type="is-primary">
          <b-select
            v-model="selectedCategory"
            placeholder="Category"
            :expanded="true"
          >
            <option value=""></option>
            <option value="breakfast">Breakfast</option>
            <option value="lunch">Lunch</option>
            <option value="dinner">Dinner</option>
            <option value="dessert">Dessert</option>
            <option value="snack">Snack</option>
          </b-select>
        </b-field>

        <add-exercise-goal
          v-if="selectedCategory === 'breakfast'"
          :exisitingMeal="currentMeal"
        />
        <add-nutrition-goal
          v-if="selectedCategory === 'lunch'"
          :exisitingMeal="currentMeal"
        />
        <add-sanity-goal
          v-if="selectedCategory === 'dinner'"
          :exisitingMeal="currentMeal"
        />
          <add-sanity-goal
          v-if="selectedCategory === 'dessert'"
          :exisitingMeal="currentMeal"
        />
          <add-sanity-goal
          v-if="selectedCategory === 'snack'"
          :exisitingMeal="currentMeal"
        />
      </section>
    </form>
  </div>
</template>

<script>
import AddExerciseGoal from "./AddExerciseGoal.vue";
import AddNutritionGoal from "./AddNutritionGoal.vue";
import AddSanityGoal from "./AddSanityGoal.vue";
import GoalService from "../services/GoalService.js";

const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  name: "new-meal-form",
  components: {
    AddExerciseGoal,
    AddNutritionGoal,
    AddSanityGoal,
  },
  data() {
    return {
      currentMeal: null,
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
  watch: {
    "$store.state.currentEditingGoal": function () {
      const goalId = this.$store.state.currentEditingGoal;
      if (goalId) {
        GoalService.getGoalById(goalId).then((response) => {
          this.currentMeal = response.data;
          this.selectedCategory = this.currentMeal.category;
        });
      } else {
        //reset
        this.currentMeal = null;
        this.selectedCategory = "";
      }
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