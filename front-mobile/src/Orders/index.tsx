import React, { useEffect, useState } from 'react';
import { Alert, StyleSheet, Text, View } from 'react-native';
import { ScrollView, TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';
import { Order } from '../types';

function Orders() {
    const [orders, setOrders] = useState<Order[]>([]); 
    const [isLoading, setIsLoading] = useState(false);

    useEffect( () => {
        setIsLoading(true);
        fetchOrders()
            .then(response => setOrders(response.data))
            .catch(error => Alert.alert('Houve um erro ao buscar pedidos'))
            .finally(() => setIsLoading(false))
    }, []);
    
    return (
        <>
            <Header />
            <ScrollView style={styles.container}>
                {isLoading ? (
                    <View style={styles.loading}>
                    <Text>Carregando Pedidos</Text>
                    </View>
                ) :
                (
                    orders.map( item => (
                        <TouchableWithoutFeedback key={item.id}>
                            <OrderCard order={item} />
                        </TouchableWithoutFeedback>
                    ))
                )}
            </ScrollView>
        </>
    );
}

const styles = StyleSheet.create({
    container : {
        paddingRight: '5%',
        paddingLeft: '5%',

    },
    loading : {
        display: 'flex',
        textAlign: 'center'
    }
});

export default Orders;