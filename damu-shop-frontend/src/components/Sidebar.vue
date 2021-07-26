<template>
  <div class="wrapper">
        <nav id="sidebar">

            <ul class="list-unstyled components">
                <p><b>Категории</b></p>
                <li v-for="category in this.categories" :key="category.id">>
                    <a 
                        v-bind:href="'/category-'+category.id"
                    >{{category.categoryname}}</a>
                </li>
            </ul>

        </nav>
    </div>
</template>

<script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js"></script>
<script>
import axios from 'axios'

export default{
  name: 'Sidebar',
  components: {
  },
  data(){
      return{
          categories: {}
      }
  },
  methods: {
      allCategories() {
      axios.get("http://localhost:8086/category/getcategories").then(response => {
            console.log(response.data)
            this.categories = response.data
                    }).catch(error => {
                        console.log(error)
                    })
    },
  },
  mounted(){
      this.allCategories();
  }
}
</script>


<style >

</style>