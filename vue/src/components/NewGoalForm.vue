<template>
  <div class="container">
    <form class="new-goal-form" v-on:submit.prevent="saveGoal">
      <input
        type="text"
        class="category-input"
        placeholder="Category"
        v-model="newGoal.category"
      />
      <input
        type="text"
        class="activity-input"
        placeholder="Activity"
        v-model="newGoal.activity"
      />
      <input
        type="text"
        class="day-ssigned-input"
        placeholder="Day Assigned"
        v-model="newGoal.dayAssigned"
      />
      <input
        type="text"
        class="per-week-input"
        placeholder="perWeek"
        v-model="newGoal.perWeek"
      />
      <input
        type="text"
        class="duration-input"
        placeholder="duration"
        v-model="newGoal.duration"
      />
      <button>ADD</button>
    </form>

    <form class="box form">
      <section>
        <b-field label="Let's set a goal!" type="is-info">
          <b-select v-model="selectedCategory" placeholder="Category" expanded="true" >
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
        dayAssigned: "",
        perWeek: 0,
        duration: 0,
      },
      selectedCategory: '',
    };
  },
  methods: {
    saveGoal() {
      this.newGoal.complete = false;
      this.$store.commit("ADD_NEW", this.newGoal);
      this.newGoal = {
        category: "",
        activtity: "",
        dayAssigned: "",
        perWeek: 0,
        duration: 0,
      };
    },
    toggleCategoryForm(category){
      this.selectedCategory = category;
          this.isActive  = !this.isActive;
         this.activeitem = item.name
    }

  },
};
</script>

<style>
</style>