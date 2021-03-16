<template>
  <body class="HolyGrail">
    <te-header>Header</te-header>
    <div class="HolyGrail-body">
      <main class="HolyGrail-content">Main</main>
      <te-navbar class="HolyGrail-nav">navbar</te-navbar>
      <aside class="HolyGrail-ads">aside</aside>
    </div>
    <te-footer>footer</te-footer>
  </body>
</template>

<script>
import TEFooter from "../components/TEFooter.vue";

import TEHeader from "../components/TEHeader.vue";
import TENavbar from "../components/TENavbar.vue";

export default {
  name: "home",
  components: {
    TEHeader,
    TENavbar,
    TEFooter,
  },
};
</script>
<style scoped>
.HolyGrail {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}

.HolyGrail-body {
  display: flex;
  flex: 1;
}
.HolyGrail,
.HolyGrail-body {
  display: flex;
  flex-direction: column;
}

.HolyGrail-nav {
  order: -1;
}

@media (min-width: 768px) {
  .HolyGrail-body {
    flex-direction: row;
    flex: 1;
  }
  .HolyGrail-content {
    flex: 1;
  }
  .HolyGrail-nav, .HolyGrail-ads {
    /* 12em is the width of the columns */
    flex: 0 0 12em;
  }
}
.HolyGrail-content {
  flex: 1;
}

.HolyGrail-nav, .HolyGrail-ads {
  /* 12em is the width of the columns */
  flex: 0 0 12em;
}

.HolyGrail-nav {
  /* put the nav on the left */
  order: -1;
}
</style>
