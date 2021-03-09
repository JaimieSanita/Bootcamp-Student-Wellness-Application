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
          <b-select placeholder="Category" expanded="true">
            <option value="Endurance">Exercise</option>
            <option value="Balance">Nutrition</option>
            <option value="Strength">Mental</option>
          </b-select>
        </b-field>
      </section>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newGoal: {
        category: "",
        activtity: "",
        dayAssigned: "",
        perWeek: 0,
        duration: 0,
      },
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
  },
};
</script>

<style>
</style>