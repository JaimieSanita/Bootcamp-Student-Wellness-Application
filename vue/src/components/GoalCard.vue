<template>
  <div class="card">
    <header class="card-header">
      <p class="card-header-title">{{ goal.dayAssigned }}'s Goal</p>
    </header>
    <div class="card-content">
      <div class="content">
        <p>{{ goal.category }}</p>
        <p>{{ goal.activity }}</p>
        <p>{{ goal.perWeek }} per Week</p>
        <p>{{ goal.duration }} minutes per Day</p>
      </div>
    </div>
    <b-button
      
      v-bind:class="{
        'goal-incomplete': goal.complete,
        'goal-complete': !goal.complete,
      }"
      v-on:click="goalStatusChanger()"
      expanded="true"
    >
      {{ goal.complete ? "Complete" : "Incomplete" }}
    </b-button>
    <footer class="card-footer">
      <a href="#" class="card-footer-item">Edit</a>
      <a href="#" class="card-footer-item">Delete</a>
    </footer>
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

.goal .goal-complete {
  font-size: 1.5rem;
}
</style>