<template>
  <div class="container">
    <form class="box form">
      <section>
        <b-field label="LOG A MEAL" type="is-primary" v-if="!this.$store.state.currentEditingMeal">
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

       
       

           
     
      </section>
    </form>
  </div>
</template>

<script>



const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  name: "meal-form",
  components: {

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