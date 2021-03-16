<template>
  <body class="HolyGrail">
  <te-header></te-header>
    <div class="HolyGrail-body">
      <main class="HolyGrail-content">
      </main>
      <left-menu class="HolyGrail-nav"></left-menu>
      <te-aside class="HolyGrail-ads"></te-aside>
    </div>
    <te-footer>footer</te-footer>
  </body>
</template>

<script>
import TeAside from '../components/TeAside.vue';
import TeFooter from '../components/TeFooter.vue';
import LeftMenu from '../components/LeftMenu.vue';
import TeHeader from '../components/TeHeader'

import TabMenu from '../components/TabMenu.vue';


export default {
  name: "home",
  components: {
    LeftMenu,
    TeFooter,
    TeAside,
    TeHeader,
    
    TabMenu
   
   
  },
};
</script>
<style scoped>
.HolyGrail {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
.HolyGrail-content{
  display: flex;
  flex-direction: column;
  align-items: flex-end;
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
