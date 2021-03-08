<template>
  <div class="home">
    <h1>Welcome to {{Name}}'s TE Wellness Tracker!</h1>
    <div class="container">
    <add-food/>
    <add-exercise/>
    </div>
    <edit-food/>
    <edit-profile/>
    <food-summary/>
    <profile-summary/>
    <save-meal/>
    <star-summary/>
    <weight-summary/>
  </div>
</template>

<script>
import AddExercise from '../components/AddExercise.vue';
import AddFood from "../components/AddFood"
import EditFood from '../components/EditFood.vue';
import EditProfile from '../components/EditProfile.vue';
import FoodSummary from '../components/FoodSummary.vue';
import ProfileSummary from '../components/ProfileSummary.vue';
import SaveMeal from '../components/SaveMeal.vue';
import StarSummary from '../components/StarSummary.vue';
import WeightSummary from '../components/WeightSummary.vue';
export default {
  name: "home",
  components: { 
    AddFood,
    EditFood,
    EditProfile,
    FoodSummary,
    ProfileSummary,
    SaveMeal,
    StarSummary,
    WeightSummary,
    AddExercise },
};
</script>
<style scoped>
.container{
  display: flex;
  justify-content: center;
}

</style>
