# WoltDeliveries ( JAVA )
This project focuses on developing an algorithm for route planning between customers and restaurants. The algorithm aims to find the shortest route for a delivery person (e.g., working for Wolt) from a restaurant to a customer, and then create an optimized route from the restaurant to multiple customers.

The algorithm works by continuously searching for the nearest customer based on the distance from the current location to the next destination. It selects the closest point (node) and adds it to the route.

At the beginning of the project, I researched how Wolt couriers operate by checking Wolt’s website and Google. I explored whether couriers receive single or multiple orders and if they have the option to choose their preferred order. I also spoke to friends who work as Wolt couriers, and they mentioned they dislike having to choose orders. They prefer receiving orders in a prearranged sequence or route, as this eliminates the hassle of comparing and deciding on routes to customers.

This inspired me to design an algorithm that generates the shortest route from a specific restaurant to multiple customers for a courier. This way, the courier only needs to follow the route and deliver to customers without constantly deciding the next destination. This approach saves time for both the courier and the company.