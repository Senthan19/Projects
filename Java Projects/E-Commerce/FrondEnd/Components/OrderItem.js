import axios from "axios";
import { useEffect, useState } from "react"
import "./asserts/CartItems.css";
export default function OrderItem() {
    const [orderItems,setOrderItems] = useState([]);

    useEffect(()=> {
        const result = async () => {
            try {
                const order = JSON.parse(localStorage.getItem("order"));
                const res = await axios.get(`http://localhost:8080/api/order-items/${order.id}`);
                if(res.status === 200) {
                    setOrderItems(res.data);
                }
            }catch(e) {
                console.log(e);
            }
        }
        result();
    },[]);

    const deleteOrder = async (id,e) => {
        e.preventDefault();
        try {
            await axios.delete(`http://localhost:8080/api/order-items/${id}`);
            setOrderItems(orderItems.filter(item => item.id !== id));
        } catch(e) {
            console.log(e);
        }
    }
    return(
      <div>
        <h1 style={{textAlign:"center",}}>YOUR ORDERS</h1>
        {orderItems.map(item => (
            <div key={item.id}>
                <div className="product_with_img">
                                    <img src={item.product.imageUrl} style={{height:"250px",width:"200px"}} alt="img"/>
                                    <div>
                                    <p style={{textDecoration:"none"}}>Name: {item.product.name}</p>
                                    <p style={{textDecoration:"none"}}>Description: {item.product.description}</p>
                                    <p style={{textDecoration:"none"}}>Price: {item.product.price}</p>
                                    <p style={{textDecoration:"none"}}>Total Price: {item.product.price}</p>
                                    <p style={{textDecoration:"none"}}>Ordered Date: {item.startDate.slice(0,10)}</p>
                                    <p style={{textDecoration:"none"}}>Expected Delivery: {item.endDate.slice(0,10)}</p>
                                    </div>
                                    </div>
                                    <div className="order_delete">
                                        <button onClick={(e)=>deleteOrder(item.id,e)}>Cancel</button>
                                    </div>
            </div>))
        }
      </div>
    )
}