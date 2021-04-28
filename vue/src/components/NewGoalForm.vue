<template>
  <div class="container" >
    <form class="box form" style="background-color: rgba(248, 248, 255, 0.5);">
      <section>
        <b-field
          label="SET A GOAL"
          type="is-primary"
          v-if="!this.$store.state.currentEditingGoal"
        >
          <b-select
            v-model="selectedCategory"
            placeholder="Category"
            :expanded="true"
          >
            <option value=""></option>
            <option value="exercise">Exercise</option>
            <option value="nutrition">Nutrition</option>
            <option value="sanity">Sanity</option>
          </b-select>
        </b-field>

        <add-exercise-goal
          v-if="selectedCategory === 'exercise'"
          :exisitingGoal="currentGoal"
        />
        <add-nutrition-goal
          v-if="selectedCategory === 'nutrition'"
          :exisitingGoal="currentGoal"
        />
        <add-sanity-goal
          v-if="selectedCategory === 'sanity'"
          :exisitingGoal="currentGoal"
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
  name: "new-goal-form",
  components: {
    AddExerciseGoal,
    AddNutritionGoal,
    AddSanityGoal,
  },
  data() {
    return {
      currentGoal: null,
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
    "$store.state.goals": function(){
      this.$store.commit('SET_CURRENT_EDITING_GOAL', null);
      this.selectedCategory = '';
      this.currentGoal = null;
    },
    "$store.state.currentEditingGoal": function () {
      const goalId = this.$store.state.currentEditingGoal;
      if (goalId) {
        this.selectedCategory = "";
        GoalService.getGoalById(goalId).then((response) => {
          this.currentGoal = response.data;
          this.selectedCategory = this.currentGoal.category;
        });
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
.box form{
  background-color: rgba(248, 248, 255, 0.5);
}

</style>