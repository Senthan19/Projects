import { useState, useEffect } from "react";
import "./asserts/CustomerHomePage.css";
import axios from "axios";
import { IoCartOutline } from "react-icons/io5";
import {CgProfile} from "react-icons/cg";
import Cart from "./Cart";
import Profile from "./Profile";
import OrderItem from "./OrderItem";

  
export default function CustomerHomePage() {
    const [activeTab,setActiveTab] = useState("Products");
    const [category, setCategory] = useState("all");
    const [products, setProducts] = useState([]);
    const user = JSON.parse(localStorage.getItem("user"));

    useEffect(() => {
        const fetchProducts = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/products/byCategoryName/${category}`);
                if (response.status === 200) {
                    setProducts(response.data);
                }
            } catch (e) {
                console.log(e);
            }
        };
        if (category && category !== "Category") {
            fetchProducts();
        }
    }, [category]);
    useEffect(()=> {
        const cart = async () => {
            try {
                const res = await axios.post("http://localhost:8080/api/cart/create",{user:{id:user.id}});
                if(res.status === 200) {
                    localStorage.setItem("cart",JSON.stringify(res.data.id));
                }
            }catch(e) {
                console.log(e);
            }
        };
        cart();
        const orderTable = async ()=> {
            try {
            const res = await axios.post("http://localhost:8080/api/ordertable/create",{id:user?.id});
            if(res.data) {
                localStorage.setItem("order",JSON.stringify(res.data));
                 }
            } catch(e) {
                console.log(e);
            }
        }
        orderTable();
        const addAddress = async ()=> {
            try {
            const res = await axios.post("http://localhost:8080/api/address/add",{
                user:{
                    id:user?.id
                }
            }
            );
            if(res.data) {
                localStorage.setItem("address",JSON.stringify(res.data));
                }
            } catch(e) {
                console.log(e);
            }
            
        }
        addAddress();
    },[user?.id]);

    const hanldeAddCart = async (productId,e) => {
            e.preventDefault();
            const cartId = JSON.parse(localStorage.getItem("cart"));
            if(!cartId) {
                console.log("No Id is Found");
                return;
            }

            try {
                const res = await axios.post("http://localhost:8080/api/cartItems/add",{
                    quantity:1,
                    cart: {
                        id:cartId
                    },
                    product: {
                        id:productId
                    }
                });

                if(res.status === 200) {
                    console.log(res.data);
                }

            } catch(e) {
                console.log(e);
            }
    }
    return (
        <div>
            <nav className="navbar">
                <form onClick={()=>setActiveTab("Products")}>
                    <select 
                        onChange={e => setCategory(e.target.value)}
                        id="category">
                        <option value="all">Category</option>
                        <option value="Mobiles">Mobiles</option>
                        <option value="Mobile_Accessories">Mobile Accessories</option>
                        <option value="Pants">Pants</option>
                        <option value="Shirts">Shirts</option>
                    </select>
                </form>
                <div>
                    <IoCartOutline id="cart-icon" style={{fontSize:"2rem",cursor:"pointer"}} onClick={()=>setActiveTab("cart")}></IoCartOutline>
                    <CgProfile  id = "profile-icon" style={{fontSize:"2rem",cursor:"pointer",marginRight:"20px"}} onClick={()=>setActiveTab("profile")}></CgProfile>
                </div>
            </nav>
            <div className="content">
                {activeTab === "Products" && 
                    <div className="products">
                        {products.map(product => (
                            <div key={product.id} id="product">
                                <img src={product.imageUrl} alt=""/>
                                <h4>Name: {product.name}</h4>
                                <p style={{fontSize:"1.3rem"}}>Description:{product.description}</p>
                                <p>Price:{"$"}{product.price}</p>
                                <button onClick={(e)=> hanldeAddCart(product.id,e)}>Add to Cart</button>
                            </div>
                        ))}
                    </div>
                }
                {activeTab === "cart" && <Cart/>}
                {activeTab === "profile" && <Profile setActiveTab={setActiveTab}/>} 
                {activeTab === "Order" && <OrderItem/>}
            </div>
        </div>
    );
}
