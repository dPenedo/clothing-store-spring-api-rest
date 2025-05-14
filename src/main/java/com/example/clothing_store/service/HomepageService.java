package com.example.clothing_store.service;

import org.springframework.stereotype.Service;

@Service
public class HomepageService {
    public String getHomepage() {
        // return \" <h1 style=\\"display: flex; justify-content: center; padding:
        // 2rem\\"> Bienvenidos/as a nuestra tienda de ropa</h1><h4 style=\\"display:
        // flex; justify-content: center; padding: 1rem\\">¿Qué tipo de usuario
        // sos?</h4><a href=\\"admin\\" style=\\"display: flex;justify-content: center;
        // padding: 1rem; font-size: 1.5em; \\">Administrador</a><a href=\\"cliente\\"
        // style=\\" display: flex; justify-content: center; padding: 1rem; font-size:
        // 1.5em;\\">Cliente</a >\";
        return "<h1 style=\"display: flex; justify-content: center; padding: 2rem\">Welcome to our clothing store</h1>" +
                "<h4 style=\"display: flex; justify-content: center; padding: 1rem\">What would you like to do?</h4>" +
                "<div style=\"border: 1px solid #000; padding-top: 1rem; padding-bottom: 1rem\">" +
                "  <a href=\"admin\" style=\"display: flex; justify-content: center; font-size: 1.8em\">Admin</a>" +
                "  <ul style=\"display: flex; flex-direction: column; padding-right: 1rem; padding-left: 1rem; align-items: center; list-style: none\">" +
                "    <li><a href=\"admin\">View all products</a></li>" +
                "    <li><a href=\"admin/outofstock\">View Out of Stock Products</a></li>" +
                "    <li><a href=\"admin/type/footwear\">View Footwear</a></li>" +
                "    <li><a href=\"admin/type/pants\">View Pants</a></li>" +
                "    <li><a href=\"admin/type/shirt\">View Shirts</a></li>" +
                "    <li><a href=\"admin/type/jacket\">View Jackets</a></li>" +
                "    <li><a href=\"admin/type/accessory\">View Accessories</a></li>" +
                "  </ul>" +
                "</div>" +
                "<div style=\"border: 1px solid #000; padding-top: 1rem; padding-bottom: 1rem\">" +
                "  <a href=\"client\" style=\"display: flex; justify-content: center; padding-right: 1rem; padding-left: 1rem; font-size: 1.8em\">Customer</a>" +
                "  <ul style=\"display: flex; flex-direction: column; padding-right: 1rem; padding-left: 1rem; align-items: center; list-style: none\">" +
                "    <li><a href=\"client\">View all products</a></li>" +
                "    <li><a href=\"client/type/footwear\">View Footwear</a></li>" +
                "    <li><a href=\"client/type/pants\">View Pants</a></li>" +
                "    <li><a href=\"client/type/shirt\">View Shirts</a></li>" +
                "    <li><a href=\"client/type/jacket\">View Jackets</a></li>" +
                "    <li><a href=\"client/type/accessory\">View Accessories</a></li>" +
                "  </ul>" +
                "</div>";
    }
}
