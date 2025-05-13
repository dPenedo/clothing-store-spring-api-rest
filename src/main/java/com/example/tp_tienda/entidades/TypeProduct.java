package com.example.tp_tienda.entidades;

public enum TypeProduct {
    CALZADO{
        public String toString(){
            return "CALZADO";
        }
    },
    PANTALON{
        public String toString(){
            return "PANTALON";
        }
    },
    REMERA{
        public String toString(){
            return "REMERA";
        }
    },
    CHAQUETA{
        public String toString(){
            return "CHAQUETA";
        }
    },
    ACCESORIO{
        public String toString(){
            return "ACCESORIO";
        }
    },
    SIN_TIPO{
        public String toString(){
            return "SIN_TIPO";
        }
    }
}
