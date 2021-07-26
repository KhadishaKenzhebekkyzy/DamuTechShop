<template>
    <div class="signIn">
        <div className="container">
            <router-link to="/category-1">
                <h5>Damu Tech Shop</h5>
            </router-link>
            <div class="card">
                            <h1>Sign Up</h1>
                            
                                    <input
                                            required
                                            type="text"
                                            placeholder="Enter username"
                                            className="inputFormsignin"
                                            v-model="username"
                                        />
                                    <input
                                            required
                                            type="password"
                                            placeholder="Enter password"
                                            className="inputFormsignin"
                                            v-model="password"
                                        />
                            <button type="submit" @click="signUp()">Sign up</button>
                            <p>Already have an account?<a href="/sign-in"> Sign in</a></p>
                    </div>
                </div>
            </div>
</template>


<script>
import axios from 'axios'
export default{
    components:{
    },
    data(){
        return{
            username: '',
            email: '',
            password: ''
        }
    },
    methods: {
        signUp(){
            axios.post('http://127.0.0.1:8000/auth/users/', {username: this.username, email: this.email, password: this.password}).then(response => {
                console.log(response.data)
                this.$router.push({ path: '/sign-in' })
                        }).catch(error => {
                            console.log(error)
                            alert('You did not sign up due to wrong inputs!')
                        })
    }
    }
}
</script>


<style scoped src="../../assets/styles/Enter.css">

</style>