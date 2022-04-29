import Vue from 'vue';

let MyAxiosLink = new Vue({

    data: {
        base_address_app_service : "http://localhost:8091",
        address_customer: "/customers",
        address_order: "/orders"
    },
    methods: {
    }
})

export default MyAxiosLink;