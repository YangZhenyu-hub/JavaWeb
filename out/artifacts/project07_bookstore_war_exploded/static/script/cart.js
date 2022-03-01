window.onload = function () {
    var vue=new Vue({
        el:"#cart_div",
        data: {
            cart:{}
        },
        methods: {
            getCart: function () {
                axios({
                    method:"POST",
                    url:"cart.do",
                    params:{
                        operate:'cartInfo'
                    }
                }).then(function (value){
                    console.log(value)
                    vue.cart=value.data;
                    console.log(vue.cart)
                }).catch(function (reason){})
            },
            editCart:function (cartItemId , buyCount) {
                axios({
                    method: "POST",
                    url: "cart.do",
                    params:{
                        operate:'editCart',
                        cartItemId:cartItemId,
                        buyCount:buyCount
                    }
                }).then(function (value){
                    // 刷新界面
                    vue.getCart();
                })
            }
        },
        mounted: function(){
            this.getCart();
        }
    })
};