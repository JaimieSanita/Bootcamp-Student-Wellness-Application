<template>
  <form class="box form" v-on:submit.prevent>
    <section>
      <b-field label="ADD EXERCISE GOAL"> </b-field>

      <b-field label="Name" type="is-info">
        <b-select
          placeholder="Activity"
          :expanded="true"
          class="activity-input"
          v-model="newGoal.activity"
        >
          <option value="Run">Run</option>
          <option value="Walk">Walk</option>
          <option value="Stretch">Stretch</option>
          <option value="Swim">Swim</option>

        </b-select>
      </b-field>

      <b-field label="Duration">
        <b-numberinput
          class="duration-input"
          v-model="newGoal.duration"
          type="is-info"
          value="minutes"
        ></b-numberinput>
      </b-field>

      <b-field label="Select a date">
        <b-datepicker
          :focused-date="date"
          :first-day-of-week="1"
          placeholder="Click to select..."
          v-model="assignDate"
        >
          <b-field>
            <b-autocomplete
              open-on-focus
              readonly
              v-model="month"
              :data="months"
              field="name"
              @select="selectMonth"
            >
            </b-autocomplete>
            <p class="control">
              <span class="button is-static">{{ date.getFullYear() }}</span>
            </p>
          </b-field>
        </b-datepicker>
      </b-field>
      <b-button v-on:click="saveGoal" class="button is-link" type="is-info"
        >Add Exercise Goal</b-button
      >
    </section>
  </form>
</template>

<script>
export default {
  data() {
    return {
      newGoal: {
        category: "Exercise",
        activity: "",
        dayAssigned: (new Date()).toLocaleDateString(),
        perWeek: 0,
        duration: 0,
        complete: false,
      },
      date: new Date(),
      month: null,
      months: [
        { name: "January", value: 0 },
        { name: "February", value: 1 },
        { name: "March", value: 2 },
        { name: "April", value: 3 },
        { name: "May", value: 4 },
        { name: "June", value: 5 },
        { name: "July", value: 6 },
        { name: "August", value: 7 },
        { name: "September", value: 8 },
        { name: "October", value: 9 },
        { name: "November", value: 10 },
        { name: "December", value: 11 },
      ],
    };
  },
  computed: {
    assignDate: {
      get: function()  {
        const goal = this.newGoal;
        return new Date(this.newGoal.dayAssigned);
      },
      set: function (dt) {
        this.newGoal.dayAssigned = dt.toLocaleDateString();
      },
    },
  },
  methods: {
    selectMonth(option) {
      if (option) {
        this.date = new Date(this.date);
        this.date.setMonth(option.value);
      }
    },

    mounted() {
      this.month = this.months.filter(
        (item) => item.value == this.date.getMonth()
      )[0].name;
    },
    saveGoal() {
      this.newGoal.complete = false;
      this.$store.commit("ADD_NEW", this.newGoal);
      this.newGoal = {
        category: "Exercise",
        activity: "",
        dayAssigned: (new Date()).toLocaleDateString(),
        perWeek: 0,
        duration: 0,
      };
    },
  },
};
</script>

<style scoped>
.box {
  display: inline-flex;
  align-items: center;
}
</style>