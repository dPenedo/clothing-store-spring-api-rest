package com.example.clothing_store.entities;

public enum TypeProduct {
    SHOES {
        public String toString(){
            return "SHOES";
        }
    },
    PANTS {
        public String toString(){
            return "PANTS";
        }
    },
    SHIRT {
        public String toString(){
            return "SHIRT";
        }
    },
    JACKET {
        public String toString(){
            return "JACKET";
        }
    },
    ACCESORY {
        public String toString(){
            return "ACCESORY";
        }
    },
    NO_TYPE {
        public String toString(){
            return "NO_TYPE";
        }
    }
}
