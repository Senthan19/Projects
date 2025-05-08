import axios from "axios";
import { useState,useEffect } from "react";
import { FaTrashAlt } from "react-icons/fa";
import "./asserts/CartItems.css"
export default function Cart() {
    const[products,setProducts] = useState([]);
    const cartId = JSON.parse(localStorage.getItem("cart"));
    const[showOrderConfirm,setShowOrderConfirm] = useState(false);
    const[showOrder,setOrder] = useState({});
    const address = JSON.parse(localStorage.getItem("address")).address;
    const [isChecked, setIsChecked] = useState(false);

    const deleteTask = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/api/cartItems/delete/${id}`);
         
            setProducts(prevProducts => prevProducts.filter(product => product.id !== id));
        } catch(e) {
            console.log(e);
        }
    }
    useEffect(() => {
        const getProducts = async () => {
            try {
                const res = await axios.get(`http://localhost:8080/api/cartItems/get/${cartId}`);
                setProducts(res.data);
            } catch(e) {
                console.log(e);
            }
        }
        getProducts();
    },[cartId]);

    const showConfirm = (p,e)=> {
        e.preventDefault();
        setShowOrderConfirm(!showOrderConfirm)
        setOrder(
            p
        );
    }
    
    const setOrderItem = async (e) => {
        e.preventDefault();
        try {
            if (isChecked) {
                console.log("Selected Address:", address);
    
                // You can now send it in the payload
                const orderTable = JSON.parse(localStorage.getItem("order"));
                const res = await axios.post("http://localhost:8080/api/order-items/create", {
                    product: { id: showOrder.product.id },
                    orderTable: { id: orderTable.id },
                    address: address
                });
               console.log(res.data);
               deleteTask(showOrder.id);
               setShowOrderConfirm(!showOrderConfirm)

            }
        } catch (e) {
            console.error("Error placing order", e);
        }
    };
    
    return(
        <div style={{position:"relative"}}>
        <div className="cartitems" style={{position:"relative"}}>
            {products.map(product=>(
                <div key={product.id} id="products">
                    <div className="product_with_img">
                    <img src={product.product.imageUrl} alt="img"/>
                    <div>
                    <p style={{textDecoration:"none"}}>Name: {product.product.name}</p>
                    <p style={{textDecoration:"none"}}>Description: {product.product.description}</p>
                    <p style={{textDecoration:"none"}}>Price: {product.product.price}</p>
                    <p style={{textDecoration:"none"}}>Quantity: {product.quantity}</p>
                    <p style={{textDecoration:"none"}}>Total Price: {product.product.price*product.quantity}</p>
                    </div>
                    </div>
                    <div className="order_delete">
                        <button style={{borderRight:"1px solid black"}} onClick={(e) => showConfirm(product,e)}>ORDER</button>
                        <button onClick={()=>deleteTask(product.id)}><FaTrashAlt style={{display:"inline-block"}}/>{" "}DELETE</button>
                    </div>
                </div>
            ))}
             {   showOrderConfirm &&
            <div 
            style={{
                position: "fixed",
                zIndex: "3",
                width: "350px",
                left: "50%",
                top: "50%",
                transform: "translate(-50%, -50%)",
                border: "1px solid aqua",
                boxShadow: "5px 5px 20px black, -5px -5px 20px black",
                color: "white",
                backgroundColor: "gray"
                }}
            >
                <img src={showOrder.product.imageUrl} style={{width:"100%",height:"300px"}} alt="order_img"/>
                <p style={{textDecoration:"none"}}>Name: {showOrder.product.name}</p>
                    <p style={{textDecoration:"none"}}>Description: {showOrder.product.description}</p>
                    <p style={{textDecoration:"none"}}>Price: {showOrder.product.price}</p>
                    <p style={{textDecoration:"none"}}>Quantity: {showOrder.quantity}</p>
                    <p style={{textDecoration:"none"}}>Total Price: {showOrder.product.price*showOrder.quantity}</p>
                    <form>
                    <label>
                        <input 
                            type="checkbox" 
                            checked={isChecked} 
                            onChange={() => setIsChecked(!isChecked)} 
                        />
                        {address}
                        </label>

                    </form>
                <div style={{display:"flex"}}>
                    <button onClick={(e)=>setOrderItem(e)}>Order Confirm</button>
                    <button onClick={()=>setShowOrderConfirm(!showOrderConfirm)}>Cancel</button>
                </div>
            </div>
            }
        </div>
        </div>
    )
}