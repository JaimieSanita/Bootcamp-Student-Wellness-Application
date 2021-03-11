<template>
  <div class="container">
    <form class="box form">
      <section>
        <b-field label="Let's set a goal!" type="is-info">
          <b-select v-model="selectedCategory" placeholder="Category" :expanded="true" >
            <option value=""></option>
            <option value="Exercise">Exercise</option>
            <option value="Nutrition">Nutrition</option>
            <option value="Sanity">Sanity</option>
          </b-select>
        </b-field>
   
        <add-exercise v-if="selectedCategory === 'Exercise'"/>
        <add-food v-if="selectedCategory === 'Nutrition'"/>
        <!--add-sanity-->
      </section>
    </form>
  </div>
</template>

<script>
import AddExercise from '../components/AddExercise.vue';
import AddFood from './AddFood.vue';

export default {
  components: { 
      AddExercise,
      AddFood
      },
  data() {
    return {
      newGoal: {
        category: "",
        activtity: "",
        dayAssigned: "03/11/2021",
        perWeek: 0,
        duration: 0,
      },
      selectedCategory: '',
    };
  },
  computed:{
    assignDate:{
      get:()=>{
        return date.parse(this.dateAssigned);
      },
      set:(dt) =>{
        this.dateAssigned = dt.toString();
      },
    },
  },
  methods: {
    saveGoal() {
      this.newGoal.complete = false;
      this.$store.commit("ADD_NEW", this.newGoal);
      this.newGoal = {
        category: "",
        activtity: "",
        dayAssigned: "01/01/1900",
        perWeek: 0,
        duration: 0,
      };
    },


  },
};
</script>

<style>
</style>