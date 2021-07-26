<template>
  <div id="cart">
      <Header/>
    <div class="container">
    <h3>Моя корзина</h3>
    <div v-if="this.id==null">У вас нет товаров в корзине</div>
    <div class="card-item" v-for="order in orders" :key="order.orderid">
        <h6>{{order.itemid}}</h6>
        <button @click="removeFromCart()">Убрать</button>
    </div>
    </div>
  </div>
</template>

<script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js"></script>
<script>
import axios from 'axios';
import Header from "../../components/Header.vue";

export default{
  name: 'Cart',
  components: {
      Header,
  },
  data(){
      return{
          id: this.$route.params.id,
          orders: [],
          categoryname: ''
      }
  },
  methods: {
      allOrders() {
      axios.get("http://localhost:8086/cart/getorders").then(response => {
            console.log(response.data)
            for (let res in response.data){
                    if (response.data[res].userid == this.id){
                        this.orders.push({
                            orderid: response.data[res].orderid,
                            userid: response.data[res].userid,
                            itemid: response.data[res].itemid,
                        })
                }
                }
                    }).catch(error => {
                        console.log(error)
                    })
    },

    categoryName() {
      axios.get(`http://localhost:8086/category/getcategory/${this.id}`).then(response => {
            console.log(response.data)
            this.categoryname = response.data.categoryname;
                    }).catch(error => {
                        console.log(error)
                    })
    },
  },
  mounted(){
      this.allItems();
      this.categoryName();
  }
}
</script>


<style  scoped src='../../assets/styles/IntroPage.css'>

</style>