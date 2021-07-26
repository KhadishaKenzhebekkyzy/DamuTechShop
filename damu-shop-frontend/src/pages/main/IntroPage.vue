<template>
  <div id="intro">
    <Header/>
    <div class="row">
      <div class="col-md-2">
        <div class="container-1">
          <Sidebar/>
        </div>
      </div>
      <div class="col-md-10">
        <div class="container">
          <h3>Онлайн-магазин</h3> 
          <Items/>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js"></script>
<script>
import Sidebar from "../../components/Sidebar.vue"
import Items from "../../pages/main/Items.vue"
import Header from "../../components/Header.vue"

export default{
  name: 'App',
  components: {
    Sidebar,
    Items,
    Header,
  }
}
</script>


<style  scoped src='../../assets/styles/IntroPage.css'>

</style>