<template>
  <div class="container">
    <form class="box form">
      <section>

          
       
            <b-autocomplete
                rounded
                v-model="food"
                :data="filteredDataArray"
                placeholder="Find a food"
              :expanded="true"
                clearable
                @select="option => selected = option">
                <template #empty>No results found</template>
            </b-autocomplete>

          <div class="buttons" >
            <b-button 
            class="btn"
            size="is-small" 
            v-on:click.prevent="addMoreFood"
                icon-left="">
                Add
            </b-button>
          </div>
            <b-autocomplete
                v-if="addFood"
                rounded
                v-model="food2"
                :data="filteredDataArray2"
                placeholder="Find a food"
              :expanded="true"
                clearable
                @select="option => selected = option">
                <template #empty>No results found</template>
            </b-autocomplete>
        
     
      </section>
    </form>
  </div>
</template>

<script>




export default {
  name: "add-meal",
  components: {
 
  },
  data() {
    return {
      food: '',
      food2: '',
      addFood: false,
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
                filteredDataArray2() {
                return this.data.filter((option) => {
                    return option
                        .toString()
                        .toLowerCase()
                        .indexOf(this.food2.toLowerCase()) >= 0
                })
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
    addMoreFood(){
        this.addFood = true;
    },
  },
};
</script>

<style>
.form{
    display: flex;
}
.btn{
    display: flex;
    align-content: flex-end;
}
</style>