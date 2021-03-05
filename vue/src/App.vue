<template>
  <div id="app">
    <div id="nav">
      <add-food>Add Food</add-food>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import AddFood from './components/AddFood.vue'
export default {
  components: { 
    AddFood },

}
</script>

<style scoped>

</style>