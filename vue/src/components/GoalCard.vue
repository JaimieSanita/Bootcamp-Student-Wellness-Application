<template>
  <div class="goal" v-bind:class="{status:goal.complete}">
      <h1>Goal from {{goal.dayAssigned}}</h1>
    <h2 class="goal-category">Category: {{ goal.category }}</h2>
    <img
     
    />
    <h3 class="goal-activity">Activity: {{ goal.activity }}</h3>
    
    <h2 class="goal-perWeek">Times Per Week: {{ goal.perWeek }}</h2>
    <h2 class="goal-duration">Duration: {{ goal.duration }}</h2>
    <button v-bind:class="{ 'goal-incomplete': goal.complete, 'goal-complete': !goal.complete}" v-on:click="goalStatusChanger()">
      {{ goal.complete ? "Incomplete" : "Completed" }}
    </button>
  </div>
</template>

<script>
export default {
  name: "goal-card",
  props: ["goal"],
methods: {
    goalStatusChanger() {
      this.$store.commit("FLIP_STATUS", this.goal);
    },
  },
};
</script>

<style>
.goal {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: auto;
  margin: 20px;
}

.goal-complete {
  background-color: lightgray;
}

.goal .goal-complete {
  font-size: 1.5rem;
}

</style>