<template>
    <div class="signIn">
        <div className="container">
            <router-link to="/category-1">
                <h5>Damu Tech Shop</h5>
            </router-link>
            <div class="card">
                            <h1>Sign In</h1>
                            
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
                            <button type="submit" @click="signIn()">Sign in</button>
                            <p>Don't have an account?<a href="/sign-up"> Sign up</a></p>
                        </div>
                    </div>
                </div>
</template>

<script>
import axios from 'axios'

export default{
    data() {
        return {
            username: '',
            password: '',
            id: '',
            user: {},
            token: '',
            isLoggedIn: false
        }
    },
    props:{
        // username: String
    },
    methods: {
        signIn(){
            axios.post('http://127.0.0.1:8000/auth/token/login', {username: this.username, password: this.password}).then(response => {
                this.token = response.data.auth_token
                localStorage.setItem("token", this.token)
                localStorage.setItem("isLoggedIn", true)
                this.getUserDetails()
                        }).catch(error => {
                            console.log(error)
                            alert('You did not sign in!')
                        })
    },
        getUserDetails(){
            axios.get(`http://127.0.0.1:8000/user/${this.username}`).then(response => {
                this.id = response.data.id
                localStorage.setItem("id", this.id)
                this.user = response.data
                this.$router.push(
                    { 
                        path: '/user-'+this.id+'/dashboard' , 
                        query: {
                            id:this.id, 
                            userInfo: this.user,
                            token: this.token
                        }
                    }
                )
        }).catch(error => {
            console.log(error)
        })
}
    },
    watch: {
        token: {
            handler() {
                localStorage.setItem('token', JSON.stringify(this.token));
            },
            deep: true,
        },
    },
}
</script>

<style scoped src="../../assets/styles/Enter.css">

</style>