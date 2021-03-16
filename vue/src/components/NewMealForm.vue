<template>
  <div class="container">
    <form class="box form">
      <section>
        <b-field label="Let's log a meal!" type="is-primary" v-if="!this.$store.state.currentEditingMeal">
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
    "$store.state.meals": function(){
      this.$store.commit('SET_CURRENT_EDITING_MEAL', null);
      this.selectedCategory = '';
      this.currentMeal = null;
    },
    "$store.state.currentEditingMeal": function () {
      const mealId = this.$store.state.currentEditingMeal;
      if (mealId) {
        this.selectedCategory = "";
        MealService.getMealById(mealId).then((response) => {
          this.currentMeal = response.data;
          this.selectedCategory = this.currentMeal.category;
        });
      }
    },
  },
  methods: {
    saveFood() {
      this.newFood.complete = false;
      this.$store.commit("ADD_NEW_MEAL", this.newFood);
      this.newFood = {
        userFoodsId: '',
        foodId: "",
        name: "",
        servings: "",
        userId: "",
        userMealsId: 0,
      };
    },
  },
};
</script>

<style>
</style>