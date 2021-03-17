<template>
<div class="te-main">
    <h1 class="title">Your Goals</h1>
  <div class="goal-container">
      <goal-list/>
  </div>
  <h1 class="title">Your Exercises</h1>
  <h1 class="title">Your Meals</h1>
</div>
</template>

<script>
import GoalList from './GoalList.vue'
export default {
  components: { 
      GoalList },

}
</script>

<style scoped>
.goal-container {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  width: auto;
  height: 250px;
  margin-bottom: 20px;
}
.te-main{
    margin-left: 20px;
}

</style>