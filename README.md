
# Android Online Shopping App

This it's the final project of Mobile App which we need to develop an Online Shopping App where the user can sign-in, browse products from an external API and buy products.



## Authors

- [@codeitamarjr](https://github.com/codeitamarjr)


## Roadmap

- Working on Product Listing


## Requirements

### Authentication
- [x]  Allow User to Signup
- [x]  Log In using username and password
- [x]  Store userID and token once logged in, to keep the user logged in (even after restarting the app)
### Product Listing
- [x]  List Product Categories
- [x]  On clicking a Category, list Products in that Category
On clicking a Product, show Product description, show buy button and controls to change quantity.
### Cart
Show cart summary
Show total amount
Purchase button to place an order, show order notification
### Show order history
List users orders
On clicking an Order, show Order details and Products ordered
On clicking a Product, take them to Product description page created for 3.3
### Show User details
Use the stored userID to show user details
Show a random circular profile image from https://thispersondoesnotexist.com/
Show Logout button, on click take back to Signup / Log In page (Restart should not auto login after logout)
### UI/Implementational Requirements
- [x] RecyclerView used for all Lists: Categories, Products, Orders
- [x]  If logged in, attach authentication token to all requests until logout
- [x]  Add a small "About this app" button in the profile page, that shows a page on click with your copyright details and credits
### Bonus
ViewPager2 with bottom TabLayout for: Shop, Cart, Orders, Profile icons
Show a map marker based on the GPS co-ordinates in user profile (Hint: Follow instructions given here)
## JSON API Links
Root URL: https://fakestoreapi.com

- User Signup: POST /users
- User Sign In: POST /auth/login
- Product Categories: GET /products/categories
- Products in a particular category: GET /products/categories/electronics
- Purchase a cart: POST /carts
- Retrieve order history for user id 2: GET /carts/user/2

More details available on https://fakestoreapi.com/docs
## Resources / DataTypes

All resources (User, Product, Cart, etc.) should have same structure as the JSON API responses for auto-parse using Gson and to build JSON back from objects for POST Requests without much manual intervention

E.g. User:

username
password
name
firstname
lastname
address
number
street
city
zipcode
geolocation
lat
long
phone
All information should be filled in (either from JSON or from user input). Exception: GPS co-ordinates (geolocation lat long), generate them randomly but add a text box to allow updates. 
