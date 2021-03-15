<template>
  <form class="box form" v-on:submit.prevent>
    <section>
      <b-field label="ADD NUTRITION GOAL"> </b-field>

      <b-field label="Name" type="is-info">
        <b-select
          placeholder="Activity"
          :expanded="true"
          class="activity-input"
          v-model="newGoal.activity"
        >
          <option value=""></option>
          <option value="Water intake :">Min Water Intake</option>
          <option value="Calorie intake:">Max Calorie Intake</option>
         
        </b-select>
      </b-field>

        <b-field label="">
        <b-numberinput
          class="duration-input"
          v-model="newGoal.duration"
          type="is-info"
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
        >Add Nutrition Goal</b-button
      >
    </section>
  </form>
</template>

<script>
import goalService from "../services/GoalService.js";
const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  data() {
    return {
      newGoal: {
        userId: '',
        categoryId: 2,
        category: "Nutrition",
        activity: "",
        date: (new Date()).toLocaleDateString(locale, dateFormat),
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
      get: function () {
        return new Date(this.newGoal.date);
      },
      set: function (dt) {
        this.newGoal.date = dt.toLocaleDateString(locale, dateFormat);
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
      goalService.add(this.newGoal).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_NEW", response.data); 
          this.newGoal = {
            userId: "",
            categoryId: 2,
            category: "Nutrition",
            activity: "",
            date: new Date().toLocaleDateString(locale, dateFormat),
            perWeek: 0,
            duration: 0,
          };
        }
      });
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