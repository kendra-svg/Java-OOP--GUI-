package comp.roundrock.View;
import comp.roundrock.*;
import comp.roundrock.Controller.FamiliaControlador;
import comp.roundrock.DAO.ComponenteDAO;
import comp.roundrock.DAO.Memory.ComponenteDAOMemoria;
import comp.roundrock.DAO.Memory.FamiliaDAOMemoria;
import comp.roundrock.Utilitarios.Utils;
import comp.roundrock.Controller.ComponenteControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Vista extends JFrame {



        private JButton registrarRAMButton;
        private JButton registrarProcesadorButton;
        private JButton registrarAlmacenamientoButton;
        private JButton registrarFuenteDePoderButton;
        private JButton registrarTarjetaMadreButton;
        private JButton registrarTarjetaVideoButton;

        private JButton guardarRAMButton;

        private JButton guardarProcesadorButton;

        private JButton guardarAlmacenamientoButton;

        private JButton guardarFuentePoder;

        private JButton guardarTarjetaMadre;

        private JButton guardarTarjetaVideo;

        private JButton volverAlMenuBoutton;

         private JButton mostrarComponentesButton;



        private JTextField txtModelo;

        private JTextField txtChipset;

        private JPanel inicializacionGeneralPaneles;

        private JTextField txtCantidadVentiladores;
        private JTextField txtPrecio;
        private JTextField txtCategoria;
        private JTextField txtCapacidad;
        private JTextField txtRating;

        private JTextField txtDuracionBateria;
        private JTextField txtIdComponente;

        private JPanel panelPrincipal;

        private JPanel panelPrueba;

        private JPanel panelPrincipalMostrarComponentes;

        private JPanel panelRegistroProcesador;

        private Componente componente;

        private JButton registrarComponenteButton;
        private JButton listarComponenteButton;
        private JButton registrarFamiliaButton;
        private JButton listarFamiliasButton;
        private JButton salirButton;


        /*private ComponenteDAO componenteDAO;*/

        private ComponenteControlador componenteControlador;



        private Vista vista;

        List<String> listaDeComponentes = new ArrayList<>();

    private JFrame frameListaComponentes;


    ComponenteDAOMemoria componenteDAO = new ComponenteDAOMemoria();



    public Vista() {


            panelPrincipal = new JPanel();
            getContentPane().add(panelPrincipal);

            /*panelPrincipalMostrarComponentes = new JPanel();
            /*getContentPane().add(panelPrincipalMostrarComponentes);*/

    }

    /*public void inicializacionGeneralPaneles(){
        panel
    }*/

    public void panelInit() {

            panelPrincipalMostrarComponentes = new JPanel();
            getContentPane().add(panelPrincipalMostrarComponentes);
    }

    public void panelInitProcesador() {
        panelRegistroProcesador = new JPanel();
        getContentPane().add(panelRegistroProcesador);

    }

    public void crearVista() {

    }



        public void initComponents() {
            setTitle("Registro de componente");
            setSize(1500, 1500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);


            txtModelo = new JTextField();
            txtPrecio = new JTextField();
            txtCategoria = new JTextField();
            txtCapacidad = new JTextField();
            txtRating = new JTextField();
            txtIdComponente = new JTextField();
            txtChipset = new JTextField();
            txtCantidadVentiladores = new JTextField();
            txtDuracionBateria = new JTextField();

            registrarRAMButton = new JButton("Registrar RAM");
            registrarProcesadorButton = new JButton("Registrar Procesador");
            registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
            registrarFuenteDePoderButton = new JButton("Registrar Fuente de Poder");
            registrarTarjetaMadreButton= new JButton("Registrar Tarjeta Madre");
            registrarTarjetaVideoButton = new JButton("Registrar Tarjeta de Video");


            componenteControlador = new ComponenteControlador(componenteDAO, vista);

            registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPanelRAM();
                }
            });

            registrarProcesadorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPanelProcesador();
                }
            });

            registrarAlmacenamientoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPanelAlmacenamiento();
                }
            });

            registrarFuenteDePoderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPanelFuentePoder();
                }
            });

            registrarTarjetaVideoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPanelTarjetaVideo();
                }
            });

            registrarTarjetaMadreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPanelTarjetaMadre();
                }
            });




            JPanel panelComponentes = new JPanel();
            panelComponentes.add(registrarRAMButton);
            panelComponentes.add(registrarAlmacenamientoButton);
            panelComponentes.add(registrarProcesadorButton);
            panelComponentes.add(registrarFuenteDePoderButton);
            panelComponentes.add(registrarTarjetaVideoButton);
            panelComponentes.add(registrarTarjetaMadreButton);

            panelPrincipal.add(panelComponentes);



        }


        public void initListaComponente(){
            setTitle("Listar componentes");
            setSize(900, 900);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            panelPrincipalMostrarComponentes = new JPanel();
            mostrarPanelListarComponentes();


            /*mostrarComponentesButton = new JButton("Mostrar Componentes");

            /mostrarComponentesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    mostrarPanelListarComponentes();
                }
            });*/

            JPanel panelMainComponentes = new JPanel();
            panelMainComponentes.add(mostrarComponentesButton);

            /*-panelPrincipalMostrarComponentes.add(panelMainComponentes);*/


        }

        private void mostrarPanelListarComponentes() {

            JPanel panelLista = new JPanel();
            panelLista.add(new JLabel("Tipo de componente: " )); /*+ componente.getTipoComponente()));*/
            panelLista.add(new JLabel("Modelo: " )); /*+ componente.getModelo()));*/
            panelLista.add(new JLabel("Precio: " )); /*+ componente.getPrecio()));*/

            mostrarComponentesButton = new JButton("Mostrar Componentes");
            panelLista.add(mostrarComponentesButton);

            mostrarComponentesButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelLista.add(new JLabel("Tipo de componente: " )); /*+ componente.getTipoComponente()));*/
                    panelLista.add(new JLabel("Modelo: " )); /*+ componente.getModelo()));*/
                    panelLista.add(new JLabel("Precio: " )); /*+ componente.getPrecio()));*/;
                    revalidate();
                    repaint();

                }
            });
//          panelPrincipalMostrarComponentes.add(panelLista);
            panelPrincipalMostrarComponentes.add(panelLista);

            revalidate();
            repaint();
        }




        private void mostrarPanelRAM() {
            JPanel panelRAM = new JPanel(new GridLayout(6, 2));
            panelRAM.add(new JLabel("Modelo:"));
            panelRAM.add(txtModelo);
            panelRAM.add(new JLabel("Precio:"));
            panelRAM.add(txtPrecio);
            panelRAM.add(new JLabel("Capacidad (Elija entre 64, 128, 256, 512, 1024 GB):"));
            panelRAM.add(txtCapacidad);
            panelRAM.add(new JLabel("Rating:"));
            panelRAM.add(txtRating);
            panelRAM.add(new JLabel("Id Componente:"));
            panelRAM.add(txtIdComponente);
            guardarRAMButton = new JButton("Guardar RAM");
            panelRAM.add(guardarRAMButton);
            volverAlMenuBoutton = new JButton("Volver al menu principal");
            panelRAM.add(volverAlMenuBoutton);

            guardarRAMButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Componente nuevoComponente = capturarComponenteRam();
                    componenteDAO.agregar(nuevoComponente);
                    componenteDAO.imprimirEstado(); // Agrega esta línea
                    System.out.println("Componente agregado: " + nuevoComponente.getIdComponente());



                }
            });

            volverAlMenuBoutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            panelPrincipal.add(panelRAM);

            revalidate();
            repaint();
        }

        public Componente capturarComponenteRam() {

            Componente componente = null;
            String modelo = txtModelo.getText();
            String capacidad = txtCapacidad.getText();
            String idString = txtIdComponente.getText();
            String ratingString = txtRating.getText();
            String precioString = txtPrecio.getText();
            String tipoComponente = "Ram";

            int idComponente = Integer.parseInt(idString);
            int rating = Integer.parseInt(ratingString);
            double precio = Double.parseDouble(precioString);

            Componente nuevoComp = new Ram(rating, tipoComponente, idComponente, precio, modelo, capacidad);
            componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

            return componente;

        }


        private void mostrarPanelProcesador(){
            JPanel panelProcesador= new JPanel(new GridLayout(6, 2));
            panelProcesador.add(new JLabel("Modelo: "));
            panelProcesador.add(txtModelo);
            panelProcesador.add(new JLabel("Precio: "));
            panelProcesador.add(txtPrecio);
            panelProcesador.add(new JLabel("Cantidad de Nucleos: "));
            panelProcesador.add(txtCantidadVentiladores);
            panelProcesador.add(new JLabel("Rating: "));
            panelProcesador.add(txtRating);
            panelProcesador.add(new JLabel("Id Componente: "));
            panelProcesador.add(txtIdComponente);
            volverAlMenuBoutton = new JButton("Volver al menu principal");
            panelProcesador.add(volverAlMenuBoutton);
            guardarProcesadorButton = new JButton("Guardar Procesador");
            panelProcesador.add(guardarProcesadorButton);

            guardarProcesadorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Componente nuevoComponente = capturarComponenteProcesador();
                    componenteDAO.agregar(nuevoComponente);
                    componenteDAO.imprimirEstado(); // Agrega esta línea
                    System.out.println("Componente agregado: " + nuevoComponente.getIdComponente());
                }
            });

            volverAlMenuBoutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            panelPrincipal.add(panelProcesador);
            revalidate();
            repaint();
        }
        public Componente capturarComponenteProcesador() {

        Componente componente = null;
        String modelo = txtModelo.getText();
        String cantidadNucleosString = txtCapacidad.getText();
        String idString = txtIdComponente.getText();
        String ratingString = txtRating.getText();
        String precioString = txtPrecio.getText();
        String tipoComponente = "Procesador";

        int cantidadNucleos = Integer.parseInt(cantidadNucleosString);

        int idComponente = Integer.parseInt(idString);
        int rating = Integer.parseInt(ratingString);
        double precio = Double.parseDouble(precioString);

        Componente nuevoComp = new Procesador(rating, tipoComponente, idComponente, precio, modelo, cantidadNucleos);
        componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        return componente;

    }

    private void mostrarPanelAlmacenamiento() {
        setTitle("Registro de componente de Almacenamiento");
        setSize(1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel panelAlmacenamiento= new JPanel(new GridLayout(6, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);

        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Componente nuevoComponente = capturarComponenteAlmacenamiento();
                componenteDAO.agregar(nuevoComponente);
                componenteDAO.imprimirEstado(); // Agrega esta línea
                System.out.println("Componente agregado: " + nuevoComponente.getIdComponente());
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    public Componente capturarComponenteAlmacenamiento() {

        Componente componente = null;
        String modelo = txtModelo.getText();
        String capacidad = txtCapacidad.getText();
        String categoria = txtCapacidad.getText();
        String idString = txtIdComponente.getText();
        String ratingString = txtRating.getText();
        String precioString = txtPrecio.getText();
        String tipoComponente = "Almacenamiento";


        int idComponente = Integer.parseInt(idString);
        int rating = Integer.parseInt(ratingString);
        double precio = Double.parseDouble(precioString);

        Componente nuevoComp = new Almacenamiento(rating, tipoComponente, idComponente, precio, modelo, categoria, capacidad);
        componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        return componente;

    }

    private void mostrarPanelFuentePoder() {
        setTitle("Registro de componente de Fuente de Poder");
        setSize(1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel panelFuentePoder= new JPanel(new GridLayout(6, 2));
        panelFuentePoder.add(new JLabel("Modelo: "));
        panelFuentePoder.add(txtModelo);
        panelFuentePoder.add(new JLabel("Precio: "));
        panelFuentePoder.add(txtPrecio);
        panelFuentePoder.add(new JLabel("Rating: "));
        panelFuentePoder.add(txtRating);
        panelFuentePoder.add(new JLabel("Duración batería: "));
        panelFuentePoder.add(txtDuracionBateria);
        panelFuentePoder.add(new JLabel("Id Componente: "));
        panelFuentePoder.add(txtIdComponente);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelFuentePoder.add(volverAlMenuBoutton);
        guardarFuentePoder = new JButton("Guardar Fuente de Poder");
        panelFuentePoder.add(guardarFuentePoder);

        guardarFuentePoder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Componente nuevoComponente = capturarComponenteFuentePoder();
                componenteDAO.agregar(nuevoComponente);
                componenteDAO.imprimirEstado(); // Agrega esta línea
                System.out.println("Componente agregado: " + nuevoComponente.getIdComponente());
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelPrincipal.add(panelFuentePoder);
        revalidate();
        repaint();
    }

    public Componente capturarComponenteFuentePoder() {
        Componente componente = null;
        String modelo = txtModelo.getText();
        String idString = txtIdComponente.getText();
        String ratingString = txtRating.getText();
        String precioString = txtPrecio.getText();
        String duracionBateria = txtPrecio.getText();
        String tipoComponente = "Fuente de Poder";


        int idComponente = Integer.parseInt(idString);
        int rating = Integer.parseInt(ratingString);
        double precio = Double.parseDouble(precioString);

        Componente nuevoComp = new FuentePoder(rating, tipoComponente, idComponente, precio, modelo, duracionBateria);
        componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        return componente;

    }

    private void mostrarPanelTarjetaMadre() {
        setTitle("Registro de componente de Tarjeta Madre");
        setSize(1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel panelTarjetaMadre= new JPanel(new GridLayout(6, 2));
        panelTarjetaMadre.add(new JLabel("Modelo: "));
        panelTarjetaMadre.add(txtModelo);
        panelTarjetaMadre.add(new JLabel("Precio: "));
        panelTarjetaMadre.add(txtPrecio);
        panelTarjetaMadre.add(new JLabel("Rating: "));
        panelTarjetaMadre.add(txtRating);
        panelTarjetaMadre.add(new JLabel("Chipset: "));
        panelTarjetaMadre.add(txtChipset);
        panelTarjetaMadre.add(new JLabel("Id Componente: "));
        panelTarjetaMadre.add(txtIdComponente);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelTarjetaMadre.add(volverAlMenuBoutton);
        guardarTarjetaMadre = new JButton("Guardar Fuente de Poder");
        panelTarjetaMadre.add(guardarTarjetaMadre);

        guardarTarjetaMadre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Componente nuevoComponente = capturarComponenteTarjetaMadre();
                componenteDAO.agregar(nuevoComponente);
                componenteDAO.imprimirEstado(); // Agrega esta línea
                System.out.println("Componente agregado: " + nuevoComponente.getIdComponente());
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelPrincipal.add(panelTarjetaMadre);
        revalidate();
        repaint();
    }





    public Componente capturarComponenteTarjetaMadre(){
        Componente componente = null;
        String modelo = txtModelo.getText();
        String chipset = txtChipset.getText();
        String idString = txtIdComponente.getText();
        String ratingString = txtRating.getText();
        String precioString = txtPrecio.getText();
        String tipoComponente = "Tarjeta Madre";


        int idComponente = Integer.parseInt(idString);
        int rating = Integer.parseInt(ratingString);
        double precio = Double.parseDouble(precioString);

        Componente nuevoComp = new TarjetaMadre(rating, tipoComponente, idComponente, precio, modelo, chipset);
        componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        return componente;
    }

    private void mostrarPanelTarjetaVideo() {
        setTitle("Registro de componente de Tarjeta de Video");
        setSize(1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel panelTarjetaVideo= new JPanel(new GridLayout(6, 2));
        panelTarjetaVideo.add(new JLabel("Modelo: "));
        panelTarjetaVideo.add(txtModelo);
        panelTarjetaVideo.add(new JLabel("Precio: "));
        panelTarjetaVideo.add(txtPrecio);
        panelTarjetaVideo.add(new JLabel("Rating: "));
        panelTarjetaVideo.add(txtRating);
        panelTarjetaVideo.add(new JLabel("Cantidad de Ventiladores: "));
        panelTarjetaVideo.add(txtCantidadVentiladores);
        panelTarjetaVideo.add(new JLabel("Id Componente: "));
        panelTarjetaVideo.add(txtIdComponente);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelTarjetaVideo.add(volverAlMenuBoutton);
        guardarTarjetaVideo = new JButton("Guardar Fuente de Poder");
        panelTarjetaVideo.add(guardarTarjetaVideo);

        guardarTarjetaVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Componente nuevoComponente = capturarComponenteTarjetaVideo();
                componenteDAO.agregar(nuevoComponente);
                componenteDAO.imprimirEstado(); // Agrega esta línea
                System.out.println("Componente agregado: " + nuevoComponente.getIdComponente());
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panelPrincipal.add(panelTarjetaVideo);
        revalidate();
        repaint();
    }




    public Componente capturarComponenteTarjetaVideo(){
        Componente componente = null;
        String modelo = txtModelo.getText();
        String cantidadVentiladoresString = txtCantidadVentiladores.getText();
        String idString = txtIdComponente.getText();
        String ratingString = txtRating.getText();
        String precioString = txtPrecio.getText();
        String tipoComponente = "Tarjeta Video";

        int cantidadVentiladores = Integer.parseInt(cantidadVentiladoresString);
        int idComponente = Integer.parseInt(idString);
        int rating = Integer.parseInt(ratingString);
        double precio = Double.parseDouble(precioString);

        Componente nuevoComp = new TarjetaVideo(rating, tipoComponente, idComponente, precio, modelo, cantidadVentiladores);
        componente = new Componente(rating, tipoComponente, idComponente, precio, modelo);

        return componente;

    }



        public void listarComponentesRegistrados(){

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





