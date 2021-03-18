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

       
            <b-autocomplete
                rounded
                v-model="food"
                :data="filteredDataArray"
                placeholder="Find a food"
               
                clearable
                @select="option => selected = option">
                <template #empty>No results found</template>
            </b-autocomplete>

        <div class="buttons">
            <b-button size="is-small"
                icon-left="">
                Add Food
            </b-button>
        </div>
     
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
      food: '',
      currentMeal: null,
      selectedCategory: "",
      selected: null,
      data: [
                    'Banana',
                    'Apple',
                    'Coffee',
                    'Muffin',
                    'Bagel',
                    'Pork Chop',
                    'Steak',
                    'Chicken',
                    'Whole Wheat Pasta',
                    'Pasta',
                    'Brown Rice',
                    'White Rice',
                    'Ice Cream',
                    'Fruit Salad',
                ],
    };
  },

  computed: {
    filteredDataArray() {
                return this.data.filter((option) => {
                    return option
                        .toString()
                        .toLowerCase()
                        .indexOf(this.food.toLowerCase()) >= 0
                })
            },
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