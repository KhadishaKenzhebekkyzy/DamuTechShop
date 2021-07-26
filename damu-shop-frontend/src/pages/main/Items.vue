<template>
  <div id="items">
    <h5>Категория:<b> {{this.categoryname}}</b></h5>
    <div v-if="this.id==null">Выберите категорию товаров из списка</div>
    <div class="card-item" v-for="item in items" :key="item.itemid">
        <h6>{{item.itemname}}</h6>
        <p>Количество товара: {{item.itemcount}}</p>
        <h6><b>{{item.itemprice}} тг</b></h6>
        <button @click="addToCart()">В корзину</button>
    </div>
  </div>
</template>

<script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js"></script>
<script>
import axios from 'axios';

export default{
  name: 'Items',
  components: {
  },
  data(){
      return{
          id: this.$route.params.id,
          items: [],
          categoryname: '',
          userid: '',
          itemid: '',
      }
  },
  methods: {

      addToCart(){
            axios.post('http://localhost:8086/cart/addorders', {userid: this.userid, itemid: this.itemid}).then(response => {
                console.log(response.data)
                alert('Ваш товар успешно добавлен в корзину!')
                        }).catch(error => {
                            console.log(error)
                            alert('Произошла ошибка!')
                        })
      },

      allItems() {
      axios.get("http://localhost:8086/item/getitems").then(response => {
            console.log(response.data)
            for (let res in response.data){
                    if (response.data[res].categoryid == this.id){
                        console.log(response.data[res].categoryid)
                        this.items.push({
                            itemid: response.data[res].itemid,
                            itemname: response.data[res].itemname,
                            itemcount: response.data[res].itemcount,
                            itemprice: response.data[res].itemprice,
                            categoryid: response.data[res].categoryid,
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