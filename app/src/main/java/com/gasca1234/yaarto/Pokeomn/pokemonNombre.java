package com.gasca1234.yaarto.Pokeomn;


    public class pokemonNombre {
        private int number;
        private String name;
        private String url;

        public pokemonNombre(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String nombre) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public  int getNumber() {
            String[] urlPartes = url.split("/");
            return Integer.parseInt(urlPartes[urlPartes.length - 1]);
        }

        public void setNumber(int number) {
            this.number = number;
        }



    }

