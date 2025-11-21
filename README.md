# 🍽 Swiggy-Style Order Tracking System (Spring Boot + Thymeleaf)

This is a simple Swiggy-Style **Food Order Tracking Application** built using  
**Spring Boot + Thymeleaf + MVC Architecture (No JavaScript Version).**

The project demonstrates:

✔ Order creation  
✔ Order status update (Restaurant side)  
✔ Customer tracking page (auto-refresh based)  
✔ Beautiful UI pages (Home, Login, Register, Restaurant, Delivery Partner)  
✔ Fully responsive + clean modern design  

---

# 🚀 Features

### 👤 Customer
- Create account & login  
- Place order  
- Track order status  
- Auto-refresh tracking page (every few seconds)  
- Swiggy-style card UI  

### 🍽 Restaurant
- Accept and update order status:
  - Order Placed
  - Preparing
  - Ready
  - Picked Up
  - On The Way
  - Delivered

### 🚴 Delivery Partner
- Update delivery status  
- Update current location (just form inputs for now)  
- Clean UI with orange gradient  

### 🎨 UI Features
- Swiggy-like orange gradient theme  
- Modern rounded cards  
- Centered layout  
- Smooth design for all pages  
- Consistent theme across:
  - Home page  
  - Register page  
  - Login page  
  - Customer tracking page  
  - Restaurant status update page  
  - Delivery partner update page  

---

# 🏗 Tech Stack

| Layer | Technologies Used |
|-------|-------------------|
| Backend | Spring Boot, Spring MVC |
| Frontend | Thymeleaf + HTML5 + CSS3 |
| Database | (Optional) MySQL or H2 |
| Design | Custom CSS, Gradient UI |
| Build Tool | Maven |

---

# 📁 Project Structure

src
├─ main
│   ├─ java
│   │   └─ com.example.swiggyrealtimeordertracking
│   │        ├─ controller
│   │        │     ├─ HomeController.java
│   │        │     ├─ OrderController.java
│   │        │     ├─ RestaurantController.java
│   │        │     ├─ DeliveryController.java
│   │        ├─ service
│   │        ├─ entity
│   ├─ resources
│   │   ├─ templates
│   │   │     ├─ home.html
│   │   │     ├─ login.html
│   │   │     ├─ register.html
│   │   │     ├─ restaurant-update.html
│   │   │     ├─ delivery-update.html
│   │   │     ├─ order-status.html
│   │   └─ application.properties

---

# 📌 Key Endpoints

### 🧾 Order
| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | `/order/create` | Create new order |
| POST | `/order/{id}/status` | Update order status |
| GET | `/order/{id}/status-page` | Customer tracking page (auto-refresh) |

---

### 🍽 Restaurant
| Method | Endpoint |
|--------|----------|
| GET | `/restaurant` |
| POST | `/order/{id}/status` |

---

### 🚴 Delivery Partner
| Method | Endpoint |
|--------|----------|
| GET | `/delivery/{id}/page` |
| POST | `/delivery/update` |

---

# 📸 Pages Included

- ✔ Home Page  
- ✔ Login Page  
- ✔ Register Page  
- ✔ Restaurant Update Page  
- ✔ Delivery Partner Update Page  
- ✔ Customer Order Tracking Page  

All pages use the same:

🎨 Orange Gradient Background  
🎨 Center Card Box UI  
🎨 Buttons, Input Boxes, Shadows  
🎨 Swiggy-like modern layout  

---

# ▶️ How to Run

### 1️⃣ Clone the repo
```sh
git clone https://github.com/YOUR_USERNAME/your-repo-name.git

2️⃣ Build project
mvn clean install

3️⃣ Run Spring Boot
mvn spring-boot:run

4️⃣ Open the app
http://localhost:8080/


✔ Future Enhancements (Optional)


Add WebSocket real-time tracking


Google Maps live rider movement


Real ETA calculation


Animated timeline


Delivery partner GPS auto-detect



👨‍💻 Author
Your Name
Java | Spring Boot | Thymeleaf | Backend Developer

⭐ Support
If you like this project, please leave a ⭐ on GitHub!









