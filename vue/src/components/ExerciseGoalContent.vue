<template>
  <div class="content-container">
    <img src="../assets/667-biking-outline.gif" class="exerciseIcon" />
    <p>
      You will <strong>{{ goal.activity }}</strong> for
    </p>
    <p>
      <strong>{{ goal.duration }}</strong> minutes today!
    </p>
  </div>
</template>

<script>
export default {
  name: "exercise-goal-content",
  props: ["goal"],
  data() {
    return {
      selectedCategory: "",
      isComplete: false,
    };
  },
};
</script>

<style scoped>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  height: 50px;
  width: 50px;
}
</style>