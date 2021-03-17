<template>
  <nav class="panel is-primary is-pulled-right"> 
  <p class="panel-heading">
    Food History
  <p class="panel-tabs">
    <a>Name</a>
    <a>Number of Servings</a>
    <a>Total Calories</a>
  </p>
  <a class="panel-block is-active">
    <span class="panel-icon">
      <i class="fas fa-utensils" aria-hidden="true"></i>
    </span>
   Chicken 4 380 
  </a>
  
</nav>
</template>

<script>
export default {
    name:"food-history"

}
</script>

<style>
.panel{
resize: both;
width: 100%;
padding: 1px;


}

</style>