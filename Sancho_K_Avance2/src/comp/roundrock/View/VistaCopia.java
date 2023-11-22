package comp.roundrock.View;
import comp.roundrock.*;
import comp.roundrock.Utilitarios.Utils;

import java.util.ArrayList;
import java.util.List;

public class VistaCopia {

    public Componente capturarNuevoComponente() {

        Componente componente = null;
        String modelo, tipoComponente, categoria, capacidad, duracionBateria, opcionComponente, chipset;
        int rating, idComponente, cantidadNucleos, cantidadVentiladores;
        double precio;
        Utils.limpiar();

        Utils.establecerColorAzul();
        System.out.println("Registro de Componente:");
        Utils.reiniciarColores();
        opcionComponente = Utils.leerString(String.format("%-20s: ", "Tipo de componente (Seleccione una de las siguientes opciones)\n1.Ram \n2.Procesador \n3.Almacenamiento \n4.Fuente de Poder \n5.Tarjeta Madre \n6.Tarjeta de Video "));

        if (opcionComponente.equals("1")) {
            System.out.println("A continuación ingrese las siguientes características de la RAM");
            modelo = Utils.leerString(String.format("%-20s: ", "Modelo"));
            capacidad = Utils.leerString(String.format("%-20s: ", "Capacidad (Elija entre 64, 128, 256,  512, 1024 GB)"));
            idComponente = Utils.leerEntero(String.format("%-20s: ", "Identificador del componente"));
            tipoComponente = "Ram";
            rating = Utils.leerEntero(String.format("%-20s: ", "Rating"));
            precio = Utils.leerEntero(String.format("%-20s: ", "Precio"));

            Componente nuevoComp = new Ram(rating, tipoComponente, idComponente, precio, modelo, capacidad);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);


        } else if (opcionComponente.equals("2")) {
            System.out.println("A continuación ingrese las siguientes características del Procesador");
            modelo = Utils.leerString(String.format("%-20s: ", "Modelo"));
            cantidadNucleos = Utils.leerEntero((String.format("%-20s: ", "Cantidad de Nucleos")));
            idComponente = Utils.leerEntero(String.format("%-20s: ", "Identificador del componente"));
            tipoComponente = "Procesador";
            rating = Utils.leerEntero(String.format("%-20s: ", "Rating"));
            precio = Utils.leerEntero(String.format("%-20s: ", "Precio"));

            Componente nuevoComp = new Procesador(rating, tipoComponente, idComponente, precio, modelo, cantidadNucleos);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        } else if (opcionComponente.equals("3")) {
            System.out.println("A continuación ingrese las siguientes características de Almacenamiento");
            modelo = Utils.leerString(String.format("%-20s: ", "Modelo"));
            categoria = Utils.leerString((String.format("%-20s: ", "Categoria")));
            capacidad = Utils.leerString((String.format("%-20s: ", "Capacidad")));
            idComponente = Utils.leerEntero(String.format("%-20s: ", "Identificador del componente"));
            tipoComponente = "Almacenamiento";
            rating = Utils.leerEntero(String.format("%-20s: ", "Rating"));
            precio = Utils.leerEntero(String.format("%-20s: ", "Precio"));

            Componente nuevoComp = new Almacenamiento(rating, tipoComponente, idComponente, precio, categoria, capacidad, modelo);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);


        } else if (opcionComponente.equals("4")) {
            System.out.println("A continuación ingrese las siguientes características de la Fuente de Poder");
            modelo = Utils.leerString(String.format("%-20s: ", "Modelo"));
            duracionBateria = Utils.leerString((String.format("%-20s: ", "Duración de la batería")));
            idComponente = Utils.leerEntero(String.format("%-20s: ", "Identificador del componente"));
            tipoComponente = "Fuente de Poder";
            rating = Utils.leerEntero(String.format("%-20s: ", "Rating"));
            precio = Utils.leerEntero(String.format("%-20s: ", "Precio"));

            Componente nuevoComp = new FuentePoder(rating, tipoComponente, idComponente, precio, duracionBateria, modelo);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        } else if (opcionComponente.equals("5")) {
            System.out.println("A continuación ingrese las siguientes características de la Tarjeta Madre");
            modelo = Utils.leerString(String.format("%-20s: ", "Modelo"));
            chipset = Utils.leerString((String.format("%-20s: ", "Chipset")));
            idComponente = Utils.leerEntero(String.format("%-20s: ", "Identificador del componente"));
            tipoComponente = "Tarjeta Madre";
            rating = Utils.leerEntero(String.format("%-20s: ", "Rating"));
            precio = Utils.leerEntero(String.format("%-20s: ", "Precio"));

            Componente nuevoComp = new TarjetaMadre(rating, tipoComponente, idComponente, precio, chipset, modelo);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);
        } else if (opcionComponente.equals("6")) {
            System.out.println("A continuación ingrese las siguientes características de la Tarjeta de Video");
            modelo = Utils.leerString(String.format("%-20s: ", "Modelo"));
            cantidadVentiladores = Utils.leerEntero((String.format("%-20s: ", "Cantidad de Ventiladores")));
            idComponente = Utils.leerEntero(String.format("%-20s: ", "Identificador del componente"));
            tipoComponente = "Tarjeta de Video";
            rating = Utils.leerEntero(String.format("%-20s: ", "Rating"));
            precio = Utils.leerEntero(String.format("%-20s: ", "Precio"));

            Componente nuevoComp = new TarjetaVideo(rating, tipoComponente, idComponente, precio, modelo, cantidadVentiladores);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        } else
            opcionComponente = Utils.leerString(String.format("%-20s: ", "Opción Incorrecta\n(Seleccione una de las siguientes opciones)\n1.Ram \n2.Procesador \n3.Almacenamiento \n4.Fuente de Poder \n5.Tarjeta Madre \n6.Tarjeta de Video "));
        Utils.limpiar();
        return componente;
    }


    public void listarComponente(List<Componente> componentes) {
        boolean impar = false;
        Utils.limpiar();
        Utils.establecerColorAzul();
        System.out.printf("%-10s %-20s %-20s\n", "Tipo", "Precio", "Modelo");
        if (componentes != null && componentes.size() > 0) {
            for (Componente c : componentes) {
                impar = !impar;
                if (impar) {
                    Utils.establecerColorAmarillo();
                } else {
                    Utils.establecerColorVerde();
                }
                System.out.printf("%-10s %-20.2f %-20s\n", c.getTipoComponente(), c.getPrecio(), c.getModelo());
            }
            Utils.establecerColorMangenta();
            System.out.println("EOF");
        } else {
            Utils.establecerColorRojo();
            System.out.println("NO HAY DATOS");
        }
        Utils.reiniciarColores();
    }


    public Computadora capturarNuevaComputadora() {

        Componente componente = null;
        //String modelo, tipoComponente, categoria, capacidad, duracionBateria, opcionComponente, chipset;
        //int rating, idComponente, cantidadNucleos, cantidadVentiladores;
        //double precio;
        String opcionComponente, ram, ramAdicional, decideCapacidadAdicional, almacenamiento, opcionesSobremesa, cantidadHDD, cantidadSSD, tarjetaVideo, tipoHDD, tipoSSD;
        Utils.limpiar();

        Utils.establecerColorAzul();
        System.out.println("Registro de Familia:");
        Utils.reiniciarColores();
        opcionComponente = Utils.leerString(String.format("%-20s: ", "Tipo de Familia (Seleccione una de las siguientes opciones)\n1.Escolar \n2.Sobremesa \n3.Portables \n4.Servidores"));

        if (opcionComponente.equals("1")) {
            System.out.println("A continuación ingrese la información acerca del tipo de Familia 'Escolar'");
            ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
            if (ram.equals("4")) {
                System.out.println("Capacidad elegida de manera satisfactoria");
                ram = "4";
                decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                if (decideCapacidadAdicional.equals("1")) {
                    ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
                } else if (decideCapacidadAdicional.equals("2")) {
                    System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                }
                ;
            } else if (ram.equals("8")) {
                System.out.println("Capacidad elegida de manera satisfactoria");
                ram = "8";
                decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                if (decideCapacidadAdicional.equals("1")) {
                    ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
                    System.out.println(ramAdicional);
                    System.out.println("Capacidad adicional elegida de manera satisfactoria");
                } else if (decideCapacidadAdicional.equals("2")) {
                    System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                }

            } else if (ram.equals("16")) {
                System.out.println("Capacidad elegida de manera satisfactoria");
                ram = "16";
                decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                if (decideCapacidadAdicional.equals("1")) {
                    ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
                    System.out.println(ramAdicional);
                    System.out.println("Capacidad adicional elegida de manera satisfactoria");
                } else if (decideCapacidadAdicional.equals("2")) {
                    System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                }

            }
            almacenamiento = Utils.leerString(String.format("%-20s: ", "Capacidad de almacenamiento. (Elija entre \n1. 1 HDD(1 Tb) \n2. 1 SSD(12GB)"));
            if (almacenamiento.equals("1")) {
                System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                System.out.println(almacenamiento);
                almacenamiento = "1 HDD(1 Tb)";
            } else if (almacenamiento.equals("2")) {
                System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                System.out.println(almacenamiento);
                almacenamiento = "1 SSD(12GB)";
            }

            System.out.println("Esta familia de computadoras no acepta tarjetas de video");

            /*Definir donde se va a guardar lo de la familia Escolar, que es de la linea 142 a la 194*/


           // componente // aca iba a implementar lo de la nueva clase familia, para que se guarde como familia y no como componente, e ignora las lineas de abajo, fue un copy paste que iba editando conforme fuera necesario para ir metiendo mas IFs


        } else if (opcionComponente.equals("2")) {
            opcionesSobremesa = Utils.leerString(String.format("%-20s: ", "Tipo de computadora de la familia Sobremesa (Seleccione una de las siguientes opciones) \nA. Oficina \nB. Gaming \nC. Workstation \nSeleccione una opcion: "));
            if (opcionesSobremesa.equals("A")) {
                System.out.println("A continuacion ingrese la informacion necesaria para el tipo de computadora Oficina");
                ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '8', '16' GB)"));

                if (ram.equals("8")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "8";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
                        System.out.println(ramAdicional);
                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }

                } else if (ram.equals("16")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "16";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre  '8', '16' GB)"));
                        System.out.println(ramAdicional);
                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }

                }
                almacenamiento = Utils.leerString(String.format("%-20s: ", "Capacidad de almacenamiento disponible para Oficna: 1 SSD (256GB) \n Ingrese 1 para confirmar: "));
                if (almacenamiento.equals("1")) {
                    System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                    System.out.println(almacenamiento);
                    almacenamiento = "1 SSD (256GB) ";
                } else {
                    System.out.println("Error, intente nuevamente");

                    System.out.println("Esta subfamilia de computadoras no acepta tarjetas de video");
                }
            } else if (opcionesSobremesa.equals("B")) {
                System.out.println("A continuacion ingrese los detalles de los componentes de 'Gaming' ");
                ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
                if (ram.equals("16")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "16";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }
                    ;
                } else if (ram.equals("8")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "24";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
                        System.out.println(ramAdicional);
                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }

                } else if (ram.equals("32")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "32";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
                        System.out.println(ramAdicional);
                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }
                }
                almacenamiento = Utils.leerString(String.format("%-20s: ", "Capacidad de almacenamiento. (Elija el tipo de almacenamiento entre \n1. HDD \n2. SSD "));
                if (almacenamiento.equals("1")) {
                    cantidadHDD = Utils.leerString(String.format("%-20s: ", "Digite la cantidad de sticks de HDD que desea (MAXIMO 2  sticks)"));
                    if (cantidadHDD.equals("1")) {
                        tipoHDD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 1Tb \n2. 2Tb)"));
                        if (tipoHDD.equals("1")) {
                            almacenamiento = "HDD 1Tb ";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        } else if (tipoHDD.equals("2")) {
                            almacenamiento = "HDD 2Tb";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        }
                    } else if (cantidadHDD.equals("2")) {
                        tipoHDD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 1Tb \n2. 2Tb \n3. 1 Stick de Tb y 1 Stick 2 Tb)"));
                        if (tipoHDD.equals("1")) {
                            almacenamiento = "HDD 1Tb ";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        } else if (tipoHDD.equals("2")) {
                            almacenamiento = "HDD 2Tb";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        } else if (tipoHDD.equals("3")) {
                            almacenamiento = "1 Stick HDD de 1Tb y 1 Stick HDD de 2 Tb";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");

                        }
                    }
                } else if (almacenamiento.equals("2")) {
                    cantidadSSD = Utils.leerString(String.format("%-20s: ", "Digite la cantidad de sticks de SSD que desea (MAXIMO 2  sticks, MINIMO 1 de 256gb)"));
                    if (cantidadSSD.equals("1")) {
                        tipoSSD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 256GB \n2. 1Tb \n3. 1 SSD de 256GB y 1 SSD de 1Tb )"));
                        if (tipoSSD.equals("1")) {
                            almacenamiento = "256 GB ";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        } else if (tipoSSD.equals("2")) {
                            almacenamiento = "1 Tb";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        }
                    } else if (cantidadSSD.equals("2")) {
                        tipoHDD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 1Tb \n2. 2Tb \n3. 1 Stick de Tb y 1 Stick 2 Tb)"));
                        if (tipoHDD.equals("1")) {
                            almacenamiento = "SSD 256GB ";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        } else if (tipoHDD.equals("2")) {
                            almacenamiento = "SSD 2Tb";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
                        } else if (tipoHDD.equals("3")) {
                            almacenamiento = "1 Stick SSD de 256 y 1 Stick SSD de 1 Tb";
                            System.out.println(almacenamiento);
                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");

                        }

                    }
                }

                System.out.println("Ingrese a continuacion los detalles sobre la tarjeta de video");
                tarjetaVideo = Utils.leerString(String.format("%-20s: ", "Modelo de Tarjeta de Video"));
                System.out.println(tarjetaVideo);
                System.out.println("Tarjeta de video ingresada correctamente");
            } else if (opcionesSobremesa.equals("C")) {
                System.out.println("A continuacion ingrese los detalles de los componentes de 'Workstation' ");
                ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '32', '64' GB)"));
                if (ram.equals("32")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "32";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '32', '64' GB)"));
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }
                    ;
                } else if (ram.equals("64")) {
                    System.out.println("Capacidad elegida de manera satisfactoria");
                    ram = "64";
                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
                    if (decideCapacidadAdicional.equals("1")) {
                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '32', '64' GB)"));
                        System.out.println(ramAdicional);
                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
                    } else if (decideCapacidadAdicional.equals("2")) {
                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");

                    }


                }


            }

        }


        //} else
        // opcionComponente = Utils.leerString(String.format("%-20s: ", "Opción Incorrecta\n(Seleccione una de las siguientes opciones)\n1.Ram \n2.Procesador \n3.Almacenamiento \n4.Fuente de Poder \n5.Tarjeta Madre \n6.Tarjeta de Video "));
        Utils.limpiar();
        return null;
    }


    public Familia capturarNuevaFamilia() {

        Familia familia = null;
        String opcionFamilia, opcionSobremesa, opcionPortable,tipoFamilia, subFamilia, duracionBateria;
        double precio;
        float rating, peso;
        int idFamilia;

        ArrayList<String> listaComponentes = new ArrayList<>();
        Utils.establecerColorAzul();
        System.out.println("Registro de Familia:");
        Utils.reiniciarColores();
        opcionFamilia = Utils.leerString(String.format("%-20s: ", "Tipo de Familia (Seleccione una de las siguientes opciones)\n1.Escolar \n2.Sobremesa \n3.Portables \n4.Servidores \nIngrese una opcion: "));
        if (opcionFamilia.equals("1")) {
            tipoFamilia = "Escolar";
            precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
            rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
            System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
            listaComponentes.add(0, "RAM: 4, 8 o 16GB en maximo 2 sticks");
            listaComponentes.add(1, "Almacenamiento:  1 HDD(1 Tb) o un SSD (128GB)");
            listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
            for (String componente : listaComponentes) {
                System.out.println("- " + componente);
            }


            Familia nuevaFamiliaEscolar = new Escolar(tipoFamilia, listaComponentes,precio, rating);
            familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);


        } else if (opcionFamilia.equals("2")) {
            opcionSobremesa =  Utils.leerString(String.format("%-20s: ", "Tipo de Sobremesa (Seleccione una de las siguientes opciones) \n201. Oficina \n202. Gaming \n203. Workstation \nIngrese una opcion: "));
            if (opcionSobremesa.equals("201")) {
                tipoFamilia = "Sobremesa";
                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
                listaComponentes.add(0, "RAM: 8 o 16GB en maximo 2 sticks");
                listaComponentes.add(1, "Almacenamiento:  1 SSD (128GB)");
                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");

                for (String componente : listaComponentes) {
                    System.out.println("- " + componente);
                }
                subFamilia = "Oficina";

                Familia nuevaSubfamiliaOficina = new Sobremesa(tipoFamilia, listaComponentes,precio, rating, subFamilia);
                familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);


            } else if (opcionSobremesa.equals("202")) {
                tipoFamilia = "Sobremesa";
                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
                listaComponentes.add(0, "RAM: 16, 24 o 32GB en maximo 4 sticks");
                listaComponentes.add(1, "Almacenamiento: hasta 2 HDD (1TB a 2TB), mínimo un SSD (de 256GB a 1TB)");
                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora si acepta tarjeta de video");
                subFamilia = "Gaming";
                for (String componente : listaComponentes) {
                    System.out.println("- " + componente);
                }

                Familia nuevaSubfamiliaGaming = new Sobremesa(tipoFamilia, listaComponentes,precio, rating, subFamilia);
                familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);

            } else if (opcionSobremesa.equals("203")) {
                tipoFamilia = "Sobremesa";
                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
                listaComponentes.add(0, "RAM: 32 o 64GB en maximo 8 sticks");
                listaComponentes.add(1, "Almacenamiento:  Mínimo 1 HDD y máximo 2 (1Tb a 2TB), mínimo un SSD (de 256GB a 1TB)");
                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora si acepta tarjeta de video");
                subFamilia = "Workstation";
                for (String componente : listaComponentes) {
                    System.out.println("- " + componente);
                }

                Familia nuevaSubfamiliaWorkstation = new Sobremesa(tipoFamilia, listaComponentes,precio, rating, subFamilia);
                familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);

            }

        } else if (opcionFamilia.equals("3")) {
            opcionPortable = Utils.leerString(String.format("%-20s: ", "Tipo de Portable (Seleccione una de las siguientes opciones) \n301. Casa \n302. Trabajo  \nIngrese una opcion: "));
            if (opcionPortable.equals("301")) {
                tipoFamilia = "Portable";
                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
                listaComponentes.add(0, "RAM: 8 o 16B en maximo 2 sticks");
                listaComponentes.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
                listaComponentes.add(3, "Duracion de bateria: de 8 a 10 horas de duracion");
                for (String componente : listaComponentes) {
                    System.out.println("- " + componente);
                }

                subFamilia = "Casa";
                peso =  Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el peso: ")));

                Familia nuevaSubfamiliaCasa = new Portable(tipoFamilia, precio, rating,listaComponentes, subFamilia, peso);
                familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);

            } else if (opcionPortable.equals("302")) {
                tipoFamilia = "Portable";
                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
                listaComponentes.add(0, "RAM: 8 o 16B en maximo 2 sticks");
                listaComponentes.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
                listaComponentes.add(2, "Tarjeta de video: Admite Tarjeta de Video (GPU calculo científico, GPU renderizado, GPU homeworking)");
                listaComponentes.add(3, "Duracion de bateria: Opciones de 8, 10 y 16 horas de duracion");
                for (String componente : listaComponentes) {
                    System.out.println("- " + componente);
                }
                peso =  Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el peso: ")));

                subFamilia = "Trabajo";


                Familia nuevaSubfamiliaTrabajo = new Portable(tipoFamilia, precio, rating,listaComponentes, subFamilia, peso);
                familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);

            }

        } else if (opcionFamilia.equals("4")) {
            tipoFamilia = "Servidor";
            precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
            rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
            System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
            listaComponentes.add(0, "RAM: 64 / 128 / 256 / 512 / 1024 GB (máximo 16 sticks)");
            listaComponentes.add(1, "Almacenamiento:  32 / 64 /128 TB");
            listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no admite cambios de tarjeta de video)");
            listaComponentes.add(3, "Fuentes de poder: maximo 8");
            for (String componente : listaComponentes) {
                System.out.println("- " + componente);
            }


            Familia nuevaSubfamiliaTrabajo = new Servidor(tipoFamilia, precio, rating,listaComponentes);
            familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);

        }
        return familia;
    }

    public void listarFamilia(List<Familia> familias) {
        boolean impar = false;
        Utils.limpiar();
        Utils.establecerColorAzul();
        System.out.printf("%-10s \n", "Tipo de familia");
        if (familias != null && familias.size() > 0) {
            for (Familia f : familias) {
                impar = !impar;
                if (impar) {
                    Utils.establecerColorAmarillo();
                } else {
                    Utils.establecerColorVerde();
                }
                System.out.printf("%-10s\n", f.getTipoFamilia());
            }
            Utils.establecerColorMangenta();

        } else {
            Utils.establecerColorRojo();
            System.out.println("NO HAY DATOS");
        }
        Utils.reiniciarColores();

    }

}





