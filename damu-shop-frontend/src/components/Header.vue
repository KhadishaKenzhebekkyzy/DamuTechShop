<template>
      <nav class="navbar navbar-expand-lg navbar-light">
        <router-link to="/category-1">
          <h4>Damu Tech Shop</h4>
        </router-link>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="text-align:right; justify-content:right">
          <ul class="navbar-nav mr-auto" style="text-align:right; justify-content:right">
            <li class="nav-item" style="margin-left: 650px; margin-right:30px; margin-top:7px">
            </li>
            <li class="nav-item" v-if="!this.isLoggedIn">
              <router-link to="/sign-in">
                <button class="login">
                    Войти
                </button>
              </router-link>
              <router-link to="/sign-up">
                <button class="login">
                    Зарегистрироваться
                </button>
              </router-link>
            </li>
            <li class="nav-item" v-if="this.isLoggedIn">
              <router-link to="cart/">
                <button class="cart">
                    Корзина
                </button>
              </router-link>
            </li>
          </ul>
        </div>
      </nav>
</template>

<style>

</style>

<script>

export default{
  name: 'Header',
  data(){
    return{
      isLoggedIn: false,
      id: JSON.parse(localStorage.getItem('id'))
    }
  },
  method:{
      
  },
  mounted(){
        if (localStorage.getItem('isLoggedIn')) {
            this.isLoggedIn = JSON.parse(localStorage.getItem('isLoggedIn'));
        }
        if (localStorage.getItem('id')) {
            this.id = JSON.parse(localStorage.getItem('id'));
        }
    }
}
</script>

<style scoped src="../assets/styles/IntroPage.css">
</style>