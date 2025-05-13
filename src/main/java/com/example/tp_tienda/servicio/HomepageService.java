package com.example.tp_tienda.servicio;

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
        return " <h1 style=\"display: flex; justify-content: center; padding: 2rem\">  Bienvenidos/as a nuestra tienda de ropa </h1> <h4 style=\"display: flex; justify-content: center; padding: 1rem\"> ¿Qué deseas hacer?  </h4>  <div style=\"border: 1px solid #000; padding-top: 1rem; padding-bottom: 1rem\"  >  <a   href=\"admin\"     style=\"display: flex; justify-content: center; font-size: 1.8em\"    >Administrador</a  > <ul   style=\"  display: flex;   flex-direction: column;         padding-right: 1rem;       padding-left: 1rem;        align-items: center;       list-style: none;      \"    >  <li>       <a href=\"admin\">Ver todos los productos</a>      </li>      <li><a href=\"admin/agotados\">Ver Productos Agotados</a></li>       <li><a href=\"admin/tipo/calzado\">Ver Calzado</a></li>     <li><a href=\"admin/tipo/pantalon\">Ver Pantalones</a></li>     <li><a href=\"admin/tipo/remera\">Ver Remeras</a></li>     <li><a href=\"admin/tipo/chaqueta\">Ver Chaquetas</a></li>      <li><a href=\"admin/tipo/accesorio\">Ver Accesorios</a></li>    </ul>  </div>   <div    style=\"border: 1px solid #000; padding-top: 1rem; padding-bottom: 1rem\"   >     <a       href=\"cliente\"       style=\"         display: flex;         justify-content: center;         padding-right: 1rem;         padding-left: 1rem;         font-size: 1.8em;       \"       >Cliente</a     >     <ul       style=\"         display: flex;         flex-direction: column;         padding-right: 1rem;         padding-left: 1rem;         align-items: center;         list-style: none;       \"     >       <li>         <a href=\"cliente\">Ver todos los productos</a>        </li>        <li><a href=\"cliente/tipo/calzado\">Ver Calzado</a></li>        <li><a href=\"cliente/tipo/pantalon\">Ver Pantalones</a></li>        <li><a href=\"cliente/tipo/remera\">Ver Remeras</a></li>        <li><a href=\"cliente/tipo/chaqueta\">Ver Chaquetas</a></li>        <li><a href=\"cliente/tipo/accesorio\">Ver Accesorios</a></li>      </ul>    </div>";
    }
}
