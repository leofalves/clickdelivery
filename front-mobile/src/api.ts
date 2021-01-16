import axios from "axios";

const API_URL = 'https://leofalves-clickdelivery.herokuapp.com';

export function fetchOrders() {
    return axios(`${API_URL}/orders`);
}