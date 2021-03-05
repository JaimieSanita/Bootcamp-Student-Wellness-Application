<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <add-food/>
    <add-profile/>
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
import AddFood from "../components/AddFood"
import AddProfile from '../components/AddProfile.vue';
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
    AddProfile,
    EditFood,
    EditProfile,
    FoodSummary,
    ProfileSummary,
    SaveMeal,
    StarSummary,
    WeightSummary },
};
</script>
