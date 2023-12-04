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

    private JButton registrarDuracionBateria;

    private JButton registrarFamiliaEscolar;

    private JButton registrarFamiliaSobremesa;

    private JButton registrarSobremesaOficina;

    private JButton registrarSobremesaGaming;

    private JButton registrarSobremesaWorkstation;

    private JButton registrarFamiliaPortable;

    private JButton registrarPortableCasa;

    private JButton registrarPortableTrabajo;

    private JButton registrarFamiliaServidor;

    private JButton registrarProcesadorButton;
    private JButton registrarAlmacenamientoButton;
    private JButton registrarFuenteDePoderButton;
    private JButton registrarTarjetaMadreButton;
    private JButton registrarTarjetaVideoButton;

    private JButton guardarRAMButton;

    private JButton guardarFamiliaEscolar;

    private JButton guardarFamiliaServidor;

    private JButton guardarSubfamiliaGaming;

    private JButton guardarSubfamiliaOficina;

    private JButton guardarSubFamiliaWorkstation;

    private JButton guardarSubfamiliaCasa;

    private JButton guardarSubfamiliaTrabajo;

    private JButton guardarProcesadorButton;

    private JButton guardarAlmacenamientoButton;

    private JButton guardarFuentePoder;

    private JButton guardarTarjetaMadre;

    private JButton guardarTarjetaVideo;

    private JButton volverAlMenuBoutton;

    private JButton mostrarComponentesButton;

    private JButton mostrarFamiliasButton;

    private JTextField txtModelo;

    private JTextField txtChipset;


    private JTextField txtCantidadVentiladores;
    private JTextField txtPrecio;
    private JTextField txtCategoria;
    private JTextField txtCapacidad;
    private JTextField txtRating;

    private JTextField txtTipoFamilia;

    private JTextField txtRam;

    private JTextField txtAlmacenamiento;

    private JTextField txtIdFamilia;

    private JTextField txtDuracionBateria;
    private JTextField txtIdComponente;

    private JTextField txtCantidadNucleos;

    private JPanel panelPrincipal;


    private Componente componente;


    private ComponenteControlador componenteControlador;


    private Vista vista;

    List<Componente> listaDeComponentes = new ArrayList<>();

    List<Computadora> listaDeComputadoras = new ArrayList<>();

    List<Familia> listaFamiliasRegistradas = new ArrayList<>();

    List<Portable> listaSubFamiliaTrabajo = new ArrayList<>();

    List<Portable> listaSubFamiliaCasa = new ArrayList<>();

    List<Sobremesa> listaSubfamiliaGaming = new ArrayList<>();

    List<Sobremesa> listaSubfamiliaOficina = new ArrayList<>();

    List<Sobremesa> listaSubfamiliaWorkstation = new ArrayList<>();

    List<Sobremesa> listFamiliaSobremesa = new ArrayList<>();

    List<Portable> listFamiliaPortable = new ArrayList<>();


    ComponenteDAOMemoria componenteDAO = new ComponenteDAOMemoria();

    public Vista() {

        panelPrincipal = new JPanel();
        getContentPane().add(panelPrincipal);

    }

    private boolean componentesInicializados = false;

    private boolean listaComponentesInicializada = false;

    public boolean isListaComponentesInicializada() {
        return listaComponentesInicializada;
    }

    private boolean familiasInicializadas = false;


    private boolean listaFamiliasInicializada = false;

    private JTextArea registrarComputadoraArea;

    private JButton registrarDetallesComputadoraButton;

    private JButton registrarComputadoraButton;

    private JTextField txtNombreComputadora;

    private JButton guardarDetallesButton;

    private JTextField txtIdComputadora;

    private JButton registrarIdComputadora;


    public void initComponents() {
        setTitle("Registro de componente");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }


        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();


        registrarRAMButton = new JButton("Registrar RAM");
        registrarProcesadorButton = new JButton("Registrar Procesador");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        registrarFuenteDePoderButton = new JButton("Registrar Fuente de Poder");
        registrarTarjetaMadreButton = new JButton("Registrar Tarjeta Madre");
        registrarTarjetaVideoButton = new JButton("Registrar Tarjeta de Video");
        volverAlMenuBoutton = new JButton("Menú Principal");


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
        panelComponentes.add(volverAlMenuBoutton);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.remove(panelComponentes);
                setVisible(false);

            }
        });
        panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }

    public void iniciaInitArmadoComputadora(){
        setTitle("Registro de Computadora");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }
        txtNombreComputadora = new JTextField();
        txtTipoFamilia = new JTextField();
        txtIdComputadora = new JTextField();

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarComputadoraButton = new JButton("Registrar Computadora");
//        registrarRAMButton = new JButton("Registrar RAM");
//        registrarProcesadorButton = new JButton("Registrar Procesador");
//        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
//        registrarFuenteDePoderButton = new JButton("Registrar Fuente de Poder");
//        registrarTarjetaMadreButton = new JButton("Registrar Tarjeta Madre");
//        registrarTarjetaVideoButton = new JButton("Registrar Tarjeta de Video");
        volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarComputadoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initArmadoComputadora();
            }
        });

//        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mostrarPanelRAM();
//            }
//        });
//
//        registrarProcesadorButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mostrarPanelProcesador();
//            }
//        });
//
//        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mostrarPanelAlmacenamiento();
//            }
//        });
//
//        registrarFuenteDePoderButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mostrarPanelFuentePoder();
//            }
//        });
//
//        registrarTarjetaVideoButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mostrarPanelTarjetaVideo();
//            }
//        });
//
//        registrarTarjetaMadreButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mostrarPanelTarjetaMadre();
//            }
//        });


        JPanel panelComponentes = new JPanel();
        panelComponentes.add(registrarComputadoraButton);
//        panelComponentes.add(registrarRAMButton);
//        panelComponentes.add(registrarAlmacenamientoButton);
//        panelComponentes.add(registrarProcesadorButton);
//        panelComponentes.add(registrarFuenteDePoderButton);
//        panelComponentes.add(registrarTarjetaVideoButton);
//        panelComponentes.add(registrarTarjetaMadreButton);
   panelComponentes.add(volverAlMenuBoutton);
//
        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.remove(panelComponentes);
                setVisible(false);

            }
        });
        panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }

    public void initArmadoComputadora(){
        setTitle("Registro de Computadora");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }
        txtNombreComputadora = new JTextField();

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtIdComputadora = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();


//        registrarDetallesComputadoraButton = new JButton("Registrar detalles finales de Computadora (nombre, id)");
        registrarComputadoraArea = new JTextArea("Registro de computadora");
        registrarComputadoraArea.setEditable(false);
        registrarRAMButton = new JButton("Registrar RAM");
        registrarProcesadorButton = new JButton("Registrar Procesador");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        registrarFuenteDePoderButton = new JButton("Registrar Fuente de Poder");
        registrarTarjetaMadreButton = new JButton("Registrar Tarjeta Madre");
        registrarTarjetaVideoButton = new JButton("Registrar Tarjeta de Video");
        registrarDetallesComputadoraButton = new JButton("Registrar detalles finales de Computadora (nombre, id)");
        volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarDetallesComputadoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelDetallesComputadora();
            }
        });

//        registrarIdComputadora.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMRegistroComputadora();
            }
        });

        registrarProcesadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelProcesadorRegistroComputadora();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoRegistroComputadora();
            }
        });

        registrarFuenteDePoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelFuentePoderRegistroComputadora();
            }
        });

        registrarTarjetaVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelTarjetaVideoRegistroComputadora();
            }
        });

        registrarTarjetaMadreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelTarjetaMadreRegistroComputadora();
            }
        });


        JPanel panelComponentes = new JPanel();
        panelComponentes.add(registrarComputadoraArea);
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        panelComponentes.add(registrarProcesadorButton);
        panelComponentes.add(registrarFuenteDePoderButton);
        panelComponentes.add(registrarTarjetaVideoButton);
        panelComponentes.add(registrarTarjetaMadreButton);
        panelComponentes.add(registrarDetallesComputadoraButton);
        panelComponentes.add(volverAlMenuBoutton);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.remove(panelComponentes);
                setVisible(false);

            }
        });
        panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }


    public void mostrarPanelRegistroComponenteEscolar(){
        setTitle("Registro de componente para Escolar");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        //volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMFamiliaEscolar();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoFamiliaEscolar();
            }
        });


        JPanel panelComponentes = new JPanel(new GridLayout(2, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);

        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }
    public void mostrarPanelRegistroComponenteServidor(){
        setTitle("Registro de componente para Servidor");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        registrarFuenteDePoderButton = new JButton("Registrar Fuente de Poder:");
        //volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMFamiliaServidor();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoFamiliaServidor();
            }
        });

        registrarFuenteDePoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelFuentePoderFamiliaServidor();
            }
        });


        JPanel panelComponentes = new JPanel(new GridLayout(2, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        panelComponentes.add(registrarFuenteDePoderButton);
        //panelComponentes.add(volverAlMenuBoutton);

//        volverAlMenuBoutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelPrincipal.remove(panelComponentes);
//                setVisible(false);
//
//            }
//        });
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }


    public void initListaComponente() {
        setTitle("Listar componentes");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        if (listaComponentesInicializada) {
            componentesInicializados = true;
        }

        mostrarComponentesButton = new JButton("Mostrar Componentes");
        volverAlMenuBoutton = new JButton("Menú Principal");

        mostrarComponentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mostrarPanelListarComponentes(listaDeComponentes);
            }
        });

        JPanel panelMainComponentes = new JPanel();
        panelMainComponentes.add(mostrarComponentesButton);
        panelMainComponentes.add(volverAlMenuBoutton);
        panelPrincipal.add(panelMainComponentes);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelMainComponentes);
            }
        });
        panelPrincipal.removeAll();
        panelPrincipal.add(panelMainComponentes);
        setVisible(true);
    }

    private void mostrarPanelListarComponentes(List<Componente> listaDeComponentes) { /*HASTA ACA*/
        JPanel panelLista = new JPanel(new GridLayout(listaDeComponentes.size(), 6));
        for (Componente componente : listaDeComponentes) {
            panelLista.add(new JLabel("Tipo de componente: "));
            JTextArea textAreaTipoComponente = new JTextArea(String.valueOf(componente.getTipoComponente()));
            textAreaTipoComponente.setEditable(false);
            panelLista.add(textAreaTipoComponente);
            panelLista.add(new JLabel("Modelo: "));
            JTextArea textAreaModelo = new JTextArea(componente.getModelo());
            textAreaModelo.setEditable(false);
            panelLista.add(textAreaModelo);
            panelLista.add(new JLabel("Precio: "));
            JTextArea textAreaPrecio = new JTextArea(String.valueOf(componente.getPrecio()));
            textAreaPrecio.setEditable(false);
            panelLista.add(textAreaPrecio);
        }

        panelPrincipal.add(panelLista);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelPrincipal.add(volverAlMenuBoutton);
        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelLista);
            }
        });
        revalidate();
        repaint();
    }


    private void mostrarPanelRAM() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 4, 8, 16, 24, 32 64, 128, 256, 512, 1024 GB):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelRAM);
            }
        });

        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }

    private void limpiarCamposRam() {
        txtModelo.setText("");
        txtPrecio.setText("");
        txtCapacidad.setText("");
        txtRating.setText("");
        txtIdComponente.setText("");
//        txtNombreComputadora.setText("");
//        txtCategoria.setText("");
//        txtIdFamilia.setText("");
//        txtAlmacenamiento.setText("");
//        txtChipset.setText("");
//        txtDuracionBateria.setText("");
//        txtCantidadVentiladores.setText("");
//        txtCantidadNucleos.setText("");
//        txtRam.setText("");
//        txtTipoFamilia.setText("");
//        txtIdComputadora.setText("");
    }

    private void limpiarCamposAlmacenamiento() {
        txtModelo.setText("");
        txtPrecio.setText("");
        txtCapacidad.setText("");
        txtRating.setText("");
        txtIdComponente.setText("");
//        txtNombreComputadora.setText("");
        txtCategoria.setText("");
//        txtIdFamilia.setText("");
//        txtAlmacenamiento.setText("");
//        txtChipset.setText("");
//        txtDuracionBateria.setText("");
//        txtCantidadVentiladores.setText("");
//        txtCantidadNucleos.setText("");
//        txtRam.setText("");
//        txtTipoFamilia.setText("");
//        txtIdComputadora.setText("");
    }

    private void limpiarCamposProcesador() {
        txtModelo.setText("");
        txtPrecio.setText("");
        //txtCapacidad.setText("");
        txtRating.setText("");
        txtIdComponente.setText("");
        txtCantidadNucleos.setText("");
    }

    private void limpiarCamposFuentePoder() {
        txtModelo.setText("");
        txtPrecio.setText("");
        txtRating.setText("");
        txtIdComponente.setText("");
        txtDuracionBateria.setText("");
    }

    private void limpiarCamposTarjetaVideo() {
        txtModelo.setText("");
        txtPrecio.setText("");
        txtRating.setText("");
        txtIdComponente.setText("");
        txtCantidadVentiladores.setText("");
    }

    private void limpiarCamposTarjetaMadre() {
        txtModelo.setText("");
        txtPrecio.setText("");
        txtRating.setText("");
        txtIdComponente.setText("");
        txtChipset.setText("");
    }

    private void limpiarCamposDetallesComputadora() {
        txtNombreComputadora.setText("");
        txtTipoFamilia.setText("");
        txtRating.setText("");
        txtPrecio.setText("");
        txtIdComputadora.setText("");
    }










    private void mostrarPanelRAMRegistroComputadora() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 4, 8, 16, 24, 32 64, 128, 256, 512, 1024 GB):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                panelPrincipal.remove(panelRAM);
                limpiarCamposRam();
                panelRAM.setVisible(false);
                //panelRAM.removeAll();
            }
        });
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }

    private void mostrarPanelDetallesComputadora() {
        JPanel panelDetallesComputadora = new JPanel(new GridLayout(8, 2));
        String modelo, tipoComponente, capacidad;
        panelDetallesComputadora.add(new JLabel("Nombre de Computadora:"));
        panelDetallesComputadora.add(txtNombreComputadora);
        panelDetallesComputadora.add(new JLabel("Tipo de familia:"));
        panelDetallesComputadora.add(txtTipoFamilia);
        panelDetallesComputadora.add(new JLabel("Precio:"));
        panelDetallesComputadora.add(txtPrecio);
        panelDetallesComputadora.add(new JLabel("Rating:"));
        panelDetallesComputadora.add(txtRating);
        panelDetallesComputadora.add(new JLabel("Id Computadora:"));
        panelDetallesComputadora.add(txtIdComputadora);
        guardarDetallesButton = new JButton("Guardar Detalles");
        panelDetallesComputadora.add(guardarDetallesButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelDetallesComputadora.add(volverAlMenuBoutton);


        guardarDetallesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCamposDetallesComputadora();
                panelDetallesComputadora.setVisible(false);
            }
        });

        panelPrincipal.add(panelDetallesComputadora);
        revalidate();
        repaint();
    }

    public Componente almacenaComponenteRam() {

        Componente componente1 = null;
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdComponente = txtIdComponente.getText();
        String textoModelo = txtModelo.getText();
        String textoCapacidad = txtCapacidad.getText();
        String tipoComponente = "Ram";

        Componente nuevoComp = new Ram(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo, textoCapacidad);
        componente = new Componente(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo);
        listaDeComponentes.add(componente);

        return componente1;

    }

    public Computadora almacenaDetalles(){
        //Computadora computadora = null;
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdComputadora = txtIdComputadora.getText();
        String textoTipoFamilia = txtTipoFamilia.getText();


        //listaDeComponentes = listaDeComponentes;

        Computadora computadora = new Computadora(listaDeComponentes, textoTipoFamilia, Integer.parseInt(textoRating), Integer.parseInt(textoIdComputadora), Double.parseDouble(textoPrecio));
        listaDeComputadoras.add(computadora);
        return computadora;
    }


    public Componente almacenaComponenteProcesador() {
        Componente componente1 = null;

        String textoPrecio = txtPrecio.getText();
        String textoCantidadNucleos = txtCantidadNucleos.getText();
        String textoRating = txtRating.getText();
        String textoIdComponente = txtIdComponente.getText();
        String textoModelo = txtModelo.getText();
        String tipoComponente = "Procesador";

        Componente nuevoComp = new Procesador(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo, Integer.parseInt(textoCantidadNucleos));
        componente = new Componente(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo);
        listaDeComponentes.add(componente);
        return componente1;
    }

    private void mostrarPanelProcesador() {
        JPanel panelProcesador = new JPanel(new GridLayout(6, 2));
        panelProcesador.add(new JLabel("Modelo: "));
        panelProcesador.add(txtModelo);
        panelProcesador.add(new JLabel("Precio: "));
        panelProcesador.add(txtPrecio);
        panelProcesador.add(new JLabel("Cantidad de Nucleos: "));
        panelProcesador.add(txtCantidadNucleos);
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
                almacenaComponenteProcesador();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelProcesador);
            }
        });

        panelPrincipal.add(panelProcesador);
        revalidate();
        repaint();
    }
    private void mostrarPanelProcesadorRegistroComputadora() {
        JPanel panelProcesador = new JPanel(new GridLayout(6, 2));
        panelProcesador.add(new JLabel("Modelo: "));
        panelProcesador.add(txtModelo);
        panelProcesador.add(new JLabel("Precio: "));
        panelProcesador.add(txtPrecio);
        panelProcesador.add(new JLabel("Cantidad de Nucleos: "));
        panelProcesador.add(txtCantidadNucleos);
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
                almacenaComponenteProcesador();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                panelPrincipal.remove(panelProcesador);
                limpiarCamposProcesador();
                panelProcesador.setVisible(false);
            }
        });

        panelPrincipal.add(panelProcesador);
        revalidate();
        repaint();
    }


    public Componente almacenaComponenteAlmacenamiento() {
        Componente componente1 = null;

        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdComponente = txtIdComponente.getText();
        String textoModelo = txtModelo.getText();
        String textoCapacidad = txtCapacidad.getText();
        String tipoComponente = "Almacenamiento";
        String textoCategoria = txtCategoria.getText();

        Componente  nuevoComp = new Almacenamiento(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo, textoCategoria, textoCapacidad);
        componente = new Componente(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo);
        listaDeComponentes.add(componente);
        return componente1;

    }

    private void mostrarPanelAlmacenamiento() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Elija entre las opciones de HDD o las opciones de SSD:"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 1 TB, 2TB, 32TB, 64TB o 128TB (si en categoría eligió HDD) o elija entre 128GB, 256GB, 512GB o 1Tb (si en categoría eligió SSD)"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoRegistroComputadora() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Elija entre las opciones de HDD o las opciones de SSD:"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 1 TB, 2TB, 32TB, 64TB o 128TB (si en categoría eligió HDD) o elija entre 128GB, 256GB, 512GB o 1Tb (si en categoría eligió SSD)"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                panelPrincipal.remove(panelAlmacenamiento);
                limpiarCamposAlmacenamiento();
                panelAlmacenamiento.setVisible(false);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoFamiliaEscolar() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Elija entre las opciones de HDD o las opciones de SSD:"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 1 TB (si en categoría eligió HDD) o elija entre 128GB (si en categoría eligió SSD)"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoFamiliaServidor() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Opción disponible: HDD"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 32TB, 64TB, 128TB"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoSubfamiliaCasaTrabajo() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(6, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
            panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 1 de 256GB o elija entre 1 SSD de 512GB"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoSubfamiliaOficina() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Opción disponible: SSD"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Opción disponible 256GB)"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoSubfamiliaGaming() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Elija entre las opciones de HDD o las opciones de SSD:"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 1 HDD de 1 TB o 2TB, o  2 HDD de 1 TB o 2TB (si en categoría eligió HDD) o elija entre 256GB o 1TB (si en categoría eligió SSD)"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelAlmacenamientoSubfamiliaWorkstation() {
        JPanel panelAlmacenamiento = new JPanel(new GridLayout(8, 2));
        panelAlmacenamiento.add(new JLabel("Modelo: "));
        panelAlmacenamiento.add(txtModelo);
        panelAlmacenamiento.add(new JLabel("Precio: "));
        panelAlmacenamiento.add(txtPrecio);
        panelAlmacenamiento.add(new JLabel("Categoría (Elija entre las opciones de HDD o las opciones de SSD:"));
        panelAlmacenamiento.add(txtCategoria);
        panelAlmacenamiento.add(new JLabel("Capacidad (Elija entre 1 HDD de 1 TB o 2TB, o  2 HDD de 1 TB o 2TB (si en categoría eligió HDD) o elija entre 256GB o 1TB (si en categoría eligió SSD)"));
        panelAlmacenamiento.add(txtCapacidad);
        panelAlmacenamiento.add(new JLabel("Rating: "));
        panelAlmacenamiento.add(txtRating);
        panelAlmacenamiento.add(new JLabel("Id Componente: "));
        panelAlmacenamiento.add(txtIdComponente);
        guardarAlmacenamientoButton = new JButton("Guardar Almacenamiento");
        panelAlmacenamiento.add(guardarAlmacenamientoButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelAlmacenamiento.add(volverAlMenuBoutton);
        guardarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaComponenteAlmacenamiento();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelAlmacenamiento);
            }
        });

        panelPrincipal.add(panelAlmacenamiento);
        revalidate();
        repaint();
    }

    private void mostrarPanelRAMFamiliaEscolar() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 4, 8, 16GB):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelRAM);
            }
        });

        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }

    private void mostrarPanelRAMFamiliaServidor() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 64, 128, 256, 512 0 1024GB):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelRAM);
            }
        });

        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }

    private void mostrarPanelRAMSubfamiliaCasaTrabajoOficina() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 8GB de capacidad o, elija entre 16GB de capacidad ):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelRAM);
            }
        });

        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }
    private void mostrarPanelRAMSubfamiliaGaming() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 16GB de capacidad, 24GB o  elija entre 32GB de capacidad ):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelRAM);
            }
        });

        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }
    private void mostrarPanelRAMSubfamiliaWorkstation() {
        JPanel panelRAM = new JPanel(new GridLayout(6, 2));
        String modelo, tipoComponente, capacidad;
        panelRAM.add(new JLabel("Modelo:"));
        panelRAM.add(txtModelo);
        modelo = String.valueOf(txtModelo);
        panelRAM.add(new JLabel("Precio:"));
        panelRAM.add(txtPrecio);
        panelRAM.add(new JLabel("Capacidad (Elija entre 32GB de capacidad, o  elija entre 64GB de capacidad ):"));
        panelRAM.add(txtCapacidad);
        capacidad = String.valueOf(txtCapacidad);
        panelRAM.add(new JLabel("Rating:"));
        panelRAM.add(txtRating);
        panelRAM.add(new JLabel("Id Componente:"));
        panelRAM.add(txtIdComponente);
        guardarRAMButton = new JButton("Guardar RAM");
        panelRAM.add(guardarRAMButton);
        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelRAM.add(volverAlMenuBoutton);
        tipoComponente = "Ram";

        guardarRAMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaComponenteRam();

            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelRAM);
            }
        });

        panelPrincipal.add(panelRAM);
        revalidate();
        repaint();
    }




    public Componente almacenaFuentePoder() {
        Componente componente1 = null;
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdComponente = txtIdComponente.getText();
        String textoModelo = txtModelo.getText();
        String textoDuracionBateria = txtDuracionBateria.getText();
        String tipoComponente = "Fuente de Poder";

        Componente nuevoComp = new FuentePoder(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo, textoDuracionBateria);
        componente = new Componente(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo);
        listaDeComponentes.add(componente);

        return componente1;

    }

    private void mostrarPanelFuentePoder() {
        JPanel panelFuentePoder = new JPanel(new GridLayout(6, 2));
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
                almacenaFuentePoder();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFuentePoder);
            }
        });

        panelPrincipal.add(panelFuentePoder);
        revalidate();
        repaint();
    }

    private void mostrarPanelFuentePoderRegistroComputadora() {
        JPanel panelFuentePoder = new JPanel(new GridLayout(6, 2));
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
                almacenaFuentePoder();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                panelPrincipal.remove(panelFuentePoder);
                limpiarCamposFuentePoder();
                panelFuentePoder.setVisible(false);
            }
        });

        panelPrincipal.add(panelFuentePoder);
        revalidate();
        repaint();
    }

    private void mostrarPanelFuentePoderSubfamiliaCasa() {
        JPanel panelFuentePoder = new JPanel(new GridLayout(6, 2));
        panelFuentePoder.add(new JLabel("Modelo: "));
        panelFuentePoder.add(txtModelo);
        panelFuentePoder.add(new JLabel("Precio: "));
        panelFuentePoder.add(txtPrecio);
        panelFuentePoder.add(new JLabel("Rating: "));
        panelFuentePoder.add(txtRating);
        panelFuentePoder.add(new JLabel("Duración batería (Elija entre 8 horas de duración o elija entre 10 horas de duración): "));
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
                almacenaFuentePoder();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFuentePoder);
            }
        });

        panelPrincipal.add(panelFuentePoder);
        revalidate();
        repaint();
    }

    private void mostrarPanelFuentePoderFamiliaServidor() {
        JPanel panelFuentePoder = new JPanel(new GridLayout(6, 2));
        panelFuentePoder.add(new JLabel("Modelo: "));
        panelFuentePoder.add(txtModelo);
        panelFuentePoder.add(new JLabel("Precio: "));
        panelFuentePoder.add(txtPrecio);
        panelFuentePoder.add(new JLabel("Rating: "));
        panelFuentePoder.add(txtRating);
        panelFuentePoder.add(new JLabel("Fuentes de poder: (Elija entre 1, 2, 3, 4, 5, 6, 7 u 8 fuentes de poder): "));
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
                almacenaFuentePoder();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFuentePoder);
            }
        });

        panelPrincipal.add(panelFuentePoder);
        revalidate();
        repaint();
    }
    private void mostrarPanelFuentePoderSubfamiliaTrabajo() {
        JPanel panelFuentePoder = new JPanel(new GridLayout(6, 2));
        panelFuentePoder.add(new JLabel("Modelo: "));
        panelFuentePoder.add(txtModelo);
        panelFuentePoder.add(new JLabel("Precio: "));
        panelFuentePoder.add(txtPrecio);
        panelFuentePoder.add(new JLabel("Rating: "));
        panelFuentePoder.add(txtRating);
        panelFuentePoder.add(new JLabel("Duración batería (Elija entre 8 horas de duración, 10, o 16  horas de duración): "));
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
                almacenaFuentePoder();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFuentePoder);
            }
        });

        panelPrincipal.add(panelFuentePoder);
        revalidate();
        repaint();
    }


    public Componente almacenaTarjetaMadre() {
        Componente componente1 = null;
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdComponente = txtIdComponente.getText();
        String textoModelo = txtModelo.getText();
        String textoChipset = txtChipset.getText();
        String tipoComponente = "Tarjeta Madre";

        Componente nuevoComp = new TarjetaMadre(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo, textoChipset);
        componente = new Componente(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo);
        listaDeComponentes.add(componente);

        return componente1;
    }

    private void mostrarPanelTarjetaMadre() {
        JPanel panelTarjetaMadre = new JPanel(new GridLayout(6, 2));
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

                almacenaTarjetaMadre();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelTarjetaMadre);
            }
        });

        panelPrincipal.add(panelTarjetaMadre);
        revalidate();
        repaint();
    }

    private void mostrarPanelTarjetaMadreRegistroComputadora() {
        JPanel panelTarjetaMadre = new JPanel(new GridLayout(6, 2));
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

                almacenaTarjetaMadre();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                panelPrincipal.remove(panelTarjetaMadre);
                limpiarCamposTarjetaMadre();
                panelTarjetaMadre.setVisible(false);
            }
        });

        panelPrincipal.add(panelTarjetaMadre);
        revalidate();
        repaint();
    }


    public Componente almacenaTarjetaVideo() {
        Componente componente1 = null;
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdComponente = txtIdComponente.getText();
        String textoModelo = txtModelo.getText();
        String textoChipset = txtChipset.getText();
        String tipoComponente = "Tarjeta Video";
        String textoCantidadVentiladores = txtCantidadVentiladores.getText();

        Componente nuevoComp = new TarjetaVideo(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo, Integer.parseInt(textoCantidadVentiladores));
        componente = new Componente(Integer.parseInt(textoRating), tipoComponente, Integer.parseInt(textoIdComponente), Double.parseDouble(textoPrecio), textoModelo);
        listaDeComponentes.add(componente);

        return componente1;

    }

    private void mostrarPanelTarjetaVideo() {
        JPanel panelTarjetaVideo = new JPanel(new GridLayout(6, 2));
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
        guardarTarjetaVideo = new JButton("Guardar Tarjeta de Video");
        panelTarjetaVideo.add(guardarTarjetaVideo);

        guardarTarjetaVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaTarjetaVideo();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelTarjetaVideo);
            }
        });

        panelPrincipal.add(panelTarjetaVideo);
        revalidate();
        repaint();
    }
    private void mostrarPanelTarjetaVideoRegistroComputadora() {
        JPanel panelTarjetaVideo = new JPanel(new GridLayout(6, 2));
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
        guardarTarjetaVideo = new JButton("Guardar Tarjeta de Video");
        panelTarjetaVideo.add(guardarTarjetaVideo);

        guardarTarjetaVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaTarjetaVideo();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                dispose();
//                panelPrincipal.remove(panelTarjetaVideo);
                limpiarCamposTarjetaVideo();
                panelTarjetaVideo.setVisible(false);
            }
        });

        panelPrincipal.add(panelTarjetaVideo);
        revalidate();
        repaint();
    }

    private void mostrarPanelTarjetaVideoSubfamiliaTrabajo() {
        JPanel panelTarjetaVideo = new JPanel(new GridLayout(6, 2));
        panelTarjetaVideo.add(new JLabel("Modelo (Elija entre GPU calculo científico, GPU renderizado, GPU homeworking): "));
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
        guardarTarjetaVideo = new JButton("Guardar Tarjeta de Video");
        panelTarjetaVideo.add(guardarTarjetaVideo);

        guardarTarjetaVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaTarjetaVideo();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelTarjetaVideo);
            }
        });

        panelPrincipal.add(panelTarjetaVideo);
        revalidate();
        repaint();
    }

    private void mostrarPanelTarjetaVideoSubfamiliaGaming() {
        JPanel panelTarjetaVideo = new JPanel(new GridLayout(6, 2));
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
        guardarTarjetaVideo = new JButton("Guardar Tarjeta de Video");
        panelTarjetaVideo.add(guardarTarjetaVideo);

        guardarTarjetaVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                almacenaTarjetaVideo();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelTarjetaVideo);
            }
        });

        panelPrincipal.add(panelTarjetaVideo);
        revalidate();
        repaint();
    }


    public void initFamilias() {
        setTitle("Registro de Familias");
        setSize(1100, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        if (!familiasInicializadas) {

            familiasInicializadas = true;
        }

        txtPrecio = new JTextField();
        txtRating = new JTextField();
        txtIdFamilia = new JTextField();

        registrarFamiliaEscolar = new JButton("Registrar familia Escolar");
        registrarFamiliaPortable = new JButton("Registrar familia Portable");
        registrarFamiliaServidor = new JButton("Registrar familia Servidor");
        registrarFamiliaSobremesa = new JButton("Registrar familia Sobremesa");
        volverAlMenuBoutton = new JButton("Menú Principal");

        registrarFamiliaEscolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelFamiliaEscolar();

            }
        });

        registrarFamiliaSobremesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initPanelFamiliaSobremesa();

            }
        });

        registrarFamiliaPortable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initPanelFamiliaPortable();
            }
        });

        registrarFamiliaServidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelFamiliaServidor();
            }
        });

        JPanel panelFamilias = new JPanel();
        panelFamilias.add(registrarFamiliaEscolar);
        panelFamilias.add(registrarFamiliaPortable);
        panelFamilias.add(registrarFamiliaServidor);
        panelFamilias.add(registrarFamiliaSobremesa);
        panelFamilias.add(volverAlMenuBoutton);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamilias);
            }
        });
        panelPrincipal.removeAll();
        panelPrincipal.add(panelFamilias);
        setVisible(true);

    }

    private void mostrarPanelFamiliaServidor(){
        ArrayList<String> listaComponentesFamiliaServidor = new ArrayList<>();
        listaComponentesFamiliaServidor.add(0, "64 / 128 / 256 / 512 / 1024 GB (máximo 16 sticks)");
        listaComponentesFamiliaServidor.add(1, "32 / 64 /128 TB");
        listaComponentesFamiliaServidor.add(2, "Tipo de computadora no admite cambios de tarjeta de video)");
        listaComponentesFamiliaServidor.add(3, "máximo 8");
        JPanel panelFamiliaServidor = new JPanel(new GridLayout(10, 2));
        panelFamiliaServidor.add(new JLabel("Precio"));
        panelFamiliaServidor.add(txtPrecio);
        panelFamiliaServidor.add(new JLabel("Rating"));
        panelFamiliaServidor.add(txtRating);
        panelFamiliaServidor.add(new JLabel("ID Familia: "));
        panelFamiliaServidor.add(txtIdFamilia);
        panelFamiliaServidor.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesFamiliaServidor.get(0));
        textAreaRam.setEditable(false);
        panelFamiliaServidor.add(textAreaRam);
        panelFamiliaServidor.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesFamiliaServidor.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelFamiliaServidor.add(textAreaAlmacenamiento);
        panelFamiliaServidor.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesFamiliaServidor.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelFamiliaServidor.add(textAreaTarjetaVideo);
        panelFamiliaServidor.add(new JLabel("Fuente de poder"));
        JTextArea textAreaFuentePoder = new JTextArea(listaComponentesFamiliaServidor.get(3));
        textAreaAlmacenamiento.setEditable(false);
        panelFamiliaServidor.add(textAreaFuentePoder);


        volverAlMenuBoutton = new JButton("Volver al menu principal");

        panelPrincipal.add(panelFamiliaServidor);

        guardarFamiliaServidor = new JButton("Guardar Familia Servidor");


        panelFamiliaServidor.add(guardarFamiliaServidor);
        panelFamiliaServidor.add(volverAlMenuBoutton);


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaServidor);
            }
        });

        guardarFamiliaServidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaFamiliaServidor();
            }
        });

        revalidate();
        repaint();
    }

    public Familia almacenaFamiliaServidor(){
        Familia familia = null;
        ArrayList<String> listaComponentesFamilia = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        float rating, peso;
        int idFamilia;
        listaComponentesFamilia.add(0, "RAM: 64 / 128 / 256 / 512 / 1024 GB (máximo 16 sticks)");
        listaComponentesFamilia.add(1, "Almacenamiento:  32 / 64 /128 TB");
        listaComponentesFamilia.add(2, "Tarjeta de video: Tipo de computadora no admite cambios de tarjeta de video)");
        listaComponentesFamilia.add(3, "Fuentes de poder: maximo 8");

        tipoFamilia = "Servidor";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();

        Familia nuevaFamiliaServidor= new Servidor(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating), listaComponentesFamilia);
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesFamilia, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(familia);


        return familia;

    }


    private void mostrarPanelFamiliaEscolar() {

        ArrayList<String> listaComponentesFamiliaEscolar = new ArrayList<>();
        listaComponentesFamiliaEscolar.add(0, "4, 8 o 16GB en maximo 2 sticks");
        listaComponentesFamiliaEscolar.add(1, " 1 HDD(1 Tb) o 1 SSD (128GB)");
        listaComponentesFamiliaEscolar.add(2, " Tipo de computadora no acepta tarjeta de video");
        JPanel panelFamiliaEscolar = new JPanel(new GridLayout(8, 2));
        panelFamiliaEscolar.add(new JLabel("Precio"));
        panelFamiliaEscolar.add(txtPrecio);
        panelFamiliaEscolar.add(new JLabel("Rating"));
        panelFamiliaEscolar.add(txtRating);
        panelFamiliaEscolar.add(new JLabel("ID Familia: "));
        panelFamiliaEscolar.add(txtIdFamilia);
        panelFamiliaEscolar.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesFamiliaEscolar.get(0));
        textAreaRam.setEditable(false);
        panelFamiliaEscolar.add(textAreaRam);
        panelFamiliaEscolar.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesFamiliaEscolar.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelFamiliaEscolar.add(textAreaAlmacenamiento);
        panelFamiliaEscolar.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesFamiliaEscolar.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelFamiliaEscolar.add(textAreaTarjetaVideo);

        volverAlMenuBoutton = new JButton("Volver al menu principal");

        panelPrincipal.add(panelFamiliaEscolar);

        guardarFamiliaEscolar = new JButton("Guardar Familia Escolar");


        panelFamiliaEscolar.add(guardarFamiliaEscolar);
        panelFamiliaEscolar.add(volverAlMenuBoutton);


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaEscolar);
            }
        });

        guardarFamiliaEscolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaFamiliaEscolar(listaFamiliasRegistradas);
            }
        });

        revalidate();
        repaint();
    }

    private void mostrarPanelFamiliaEscolarParaRegistroComponente() {

        ArrayList<String> listaComponentesFamiliaEscolar = new ArrayList<>();
        listaComponentesFamiliaEscolar.add(0, "4, 8 o 16GB en maximo 2 sticks");
        listaComponentesFamiliaEscolar.add(1, " 1 HDD(1 Tb) o 1 SSD (128GB)");
        listaComponentesFamiliaEscolar.add(2, " Tipo de computadora no acepta tarjeta de video");
        JPanel panelFamiliaEscolar = new JPanel(new GridLayout(8, 2));
        panelFamiliaEscolar.add(new JLabel("Precio"));
        panelFamiliaEscolar.add(txtPrecio);
        panelFamiliaEscolar.add(new JLabel("Rating"));
        panelFamiliaEscolar.add(txtRating);
        panelFamiliaEscolar.add(new JLabel("ID Familia: "));
        panelFamiliaEscolar.add(txtIdFamilia);
        panelFamiliaEscolar.add(new JLabel("RAM: Elija entre 4, 8 o 16GB"));
        panelFamiliaEscolar.add(txtRam);
        panelFamiliaEscolar.add(new JLabel("Almacenamiento: Elija entre 1 HDD(1 Tb) o 1 SSD (128GB)"));
        panelFamiliaEscolar.add(txtAlmacenamiento);
        panelFamiliaEscolar.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesFamiliaEscolar.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelFamiliaEscolar.add(textAreaTarjetaVideo);

        volverAlMenuBoutton = new JButton("Volver al menu principal");

        panelPrincipal.add(panelFamiliaEscolar);

        guardarFamiliaEscolar = new JButton("Guardar Familia Escolar");


        panelFamiliaEscolar.add(guardarFamiliaEscolar);
        panelFamiliaEscolar.add(volverAlMenuBoutton);


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaEscolar);
            }
        });

        guardarFamiliaEscolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaFamiliaEscolar(listaFamiliasRegistradas);
            }
        });

        revalidate();
        repaint();
    }

    public void initPanelSubCasa(){
        setTitle("Registro de Subfamilia Portable; Casa");
        setSize(1100, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarPanelSubfamiliaCasa();
    }

    public void initPanelRegistroComponenteSubCasa(){
        setTitle("Registro de Componente Portable; Casa");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarPanelRegistroComponenteSubCasa();
    }

    public void initPanelRegistroComponenteSubOficina(){
        setTitle("Registro de Componente Sobremesa; Oficina");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarPanelRegistroComponenteSubOficina();
    }

    public void initPanelRegistroComponenteSubGaming(){
        setTitle("Registro de Componente Sobremesa; Gaming");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarPanelRegistroComponenteSubGaming();
    }

    public void initPanelRegistroComponenteSubWorkstation(){
        setTitle("Registro de Componente Sobremesa; Workstation");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarPanelRegistroComponenteSubWorkstation();
    }



    public void initPanelRegistroComponenteSubTrabajo(){
        setTitle("Registro de Componente Portable; Trabajo");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       mostrarPanelRegistroComponenteSubTrabajo();

    }

    public void initPanelSubTrabajo(){
        setTitle("Registro de Subfamilia Portable; Trabajo");
        setSize(1200, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarPanelSubfamiliaTrabajo();
    }

    public void initPanelFamiliaPortable(){
        setTitle("Registro de Familias Portable");
        setSize(1200, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mostrarPanelFamiliaPortable();
    }
    public void iniciaInitPanelRegistroComponentePortable(){
        setTitle("Registro de Componente para Familia Portable");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initPanelRegistroComponentePortable();
    }

    public void iniciaInitPanelRegistroComponenteSobremesa(){
        setTitle("Registro de Componente para Familia Sobremesa");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initPanelRegistroComponenteSobremesa();
    }


    public void initPanelRegistroComponenteEscolar(){
        setTitle("Registro de Componente para Familia Escolar");
        setSize(1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mostrarPanelRegistroComponenteEscolar();
    }

    public void initPanelRegistroComponenteServidor(){
        setTitle("Registro de Componente para Familia Servidor");
        setSize(1500, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mostrarPanelRegistroComponenteServidor();
    }



    private void mostrarPanelFamiliaPortable() {
        JPanel panelFamiliaPortable = new JPanel();

        registrarPortableCasa = new JButton("Registrar  subfamilia Casa");
        registrarPortableTrabajo = new JButton("Registrar subfamilia Trabajo");
        volverAlMenuBoutton = new JButton("Volver al menu principal");

        registrarPortableCasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initPanelSubCasa();
            }
        });

        registrarPortableTrabajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                initPanelSubTrabajo();
            }
        });


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaPortable);
            }
        });

        panelFamiliaPortable.add(registrarPortableCasa);
        panelFamiliaPortable.add(registrarPortableTrabajo);
        panelFamiliaPortable.add(volverAlMenuBoutton);

        panelPrincipal.add(panelFamiliaPortable);


    }

    private void initPanelRegistroComponentePortable(){
        JPanel panelFamiliaPortable = new JPanel();

        registrarPortableCasa = new JButton("Registrar Comp para subfamilia Casa");
        registrarPortableTrabajo = new JButton("Registrar Comp para subfamilia Trabajo");
        volverAlMenuBoutton = new JButton("Volver al menu principal");

        registrarPortableCasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initPanelSubCasa();
                initPanelRegistroComponenteSubCasa();
            }
        });

        registrarPortableTrabajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //initPanelSubTrabajo();
                initPanelRegistroComponenteSubTrabajo();
            }
        });


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaPortable);
            }
        });

        panelFamiliaPortable.add(registrarPortableCasa);
        panelFamiliaPortable.add(registrarPortableTrabajo);
        panelFamiliaPortable.add(volverAlMenuBoutton);

        panelPrincipal.add(panelFamiliaPortable);

    }

    private void initPanelRegistroComponenteSobremesa(){
        JPanel panelFamiliaSobremesa = new JPanel();

        registrarSobremesaGaming = new JButton("Registrar Comp para subfamilia Gaming");
        registrarSobremesaOficina = new JButton("Registrar Comp para subfamilia Oficina");
        registrarSobremesaWorkstation = new JButton("Registrar Comp para subfamilia Workstation:");
        volverAlMenuBoutton = new JButton("Volver al menu principal");

        registrarSobremesaGaming.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //initPanelSubCasa();
                initPanelRegistroComponenteSubGaming();
            }
        });

        registrarSobremesaOficina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //initPanelSubTrabajo();
                initPanelRegistroComponenteSubOficina();
            }
        });

        registrarSobremesaWorkstation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initPanelRegistroComponenteSubWorkstation();
            }
        });


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaSobremesa);
            }
        });

        panelFamiliaSobremesa.add(registrarSobremesaGaming);
        panelFamiliaSobremesa.add(registrarSobremesaOficina);
        panelFamiliaSobremesa.add(registrarSobremesaWorkstation);
        panelFamiliaSobremesa.add(volverAlMenuBoutton);

        panelPrincipal.add(panelFamiliaSobremesa);

    }

    public void mostrarPanelSubfamiliaCasa() {
        setTitle("Registro subfamilia Casa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        ArrayList<String> listaComponentesSubFamiliaCasa = new ArrayList<>();

        listaComponentesSubFamiliaCasa.add(0, "8 o 16B en maximo 2 sticks");
        listaComponentesSubFamiliaCasa.add(1, " 1 SSD (256GB / 512GB)");
        listaComponentesSubFamiliaCasa.add(2, "Tipo de familia no acepta tarjeta de video");
        listaComponentesSubFamiliaCasa.add(3, "De 8 a 10 horas de duracion");

        JPanel panelSubfamiliaCasa = new JPanel(new GridLayout(10, 2));
        panelSubfamiliaCasa.add(new JLabel("Precio"));
        panelSubfamiliaCasa.add(txtPrecio);
        panelSubfamiliaCasa.add(new JLabel("Rating"));
        panelSubfamiliaCasa.add(txtRating);
        panelSubfamiliaCasa.add(new JLabel("ID Familia: "));
        panelSubfamiliaCasa.add(txtIdFamilia);
        panelSubfamiliaCasa.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesSubFamiliaCasa.get(0));
        textAreaRam.setEditable(false);
        panelSubfamiliaCasa.add(textAreaRam);
        panelSubfamiliaCasa.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesSubFamiliaCasa.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelSubfamiliaCasa.add(textAreaAlmacenamiento);
        panelSubfamiliaCasa.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesSubFamiliaCasa.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelSubfamiliaCasa.add(textAreaTarjetaVideo);
        panelSubfamiliaCasa.add(new JLabel("Duración de batería"));
        JTextArea textAreaDuracionBateria = new JTextArea(listaComponentesSubFamiliaCasa.get(3));
        textAreaDuracionBateria.setEditable(false);
        panelSubfamiliaCasa.add(textAreaDuracionBateria);

        volverAlMenuBoutton = new JButton("Volver al menu principal");
        guardarSubfamiliaCasa = new JButton("Guardar Subfamilia Casa");

        panelSubfamiliaCasa.add(guardarSubfamiliaCasa);
        panelSubfamiliaCasa.add(volverAlMenuBoutton);

        panelPrincipal.add(panelSubfamiliaCasa);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelSubfamiliaCasa);
            }
        });

        guardarSubfamiliaCasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaSubfamiliaCasa(listFamiliaPortable);
            }
        });

        revalidate();
        repaint();
    }

    public void mostrarPanelRegistroComponenteSubCasa(){
        setTitle("Registro de componente para Subfamilia Casa");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        //registrarDuracionBateria = new JButton("Registrar duración de Batería");
        registrarFuenteDePoderButton = new JButton("Registrar Batería");

        //volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMSubfamiliaCasaTrabajoOficina();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoSubfamiliaCasaTrabajo();
            }
        });

        registrarFuenteDePoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { mostrarPanelFuentePoderSubfamiliaCasa();

            }
        });




        JPanel panelComponentes = new JPanel(new GridLayout(2, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        panelComponentes.add(registrarFuenteDePoderButton);
        //panelComponentes.add(volverAlMenuBoutton);

//        volverAlMenuBoutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelPrincipal.remove(panelComponentes);
//                setVisible(false);
//
//            }
//        });
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }

    public void mostrarPanelRegistroComponenteSubTrabajo(){
        setTitle("Registro de componente para Subfamilia Trabajo");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        registrarTarjetaVideoButton = new JButton("Registrar Tarjerta de Video");
        registrarFuenteDePoderButton = new JButton("Registrar Batería");

        //volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMSubfamiliaCasaTrabajoOficina();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoSubfamiliaCasaTrabajo();
            }
        });

        registrarTarjetaVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelTarjetaVideoSubfamiliaTrabajo();
            }
        });

        registrarFuenteDePoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { mostrarPanelFuentePoderSubfamiliaTrabajo();

            }
        });




        JPanel panelComponentes = new JPanel(new GridLayout(2, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        panelComponentes.add(registrarFuenteDePoderButton);
        //panelComponentes.add(volverAlMenuBoutton);

//        volverAlMenuBoutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelPrincipal.remove(panelComponentes);
//                setVisible(false);
//
//            }
//        });
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }


    public void mostrarPanelSubfamiliaTrabajo() {
        setTitle("Registro subfamilia Trabajo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        ArrayList<String> listaComponentesSubFamiliaTrabajo = new ArrayList<>();

        listaComponentesSubFamiliaTrabajo.add(0, "8 o 16B en maximo 2 sticks");
        listaComponentesSubFamiliaTrabajo.add(1, "1 SSD (256GB / 512GB)");
        listaComponentesSubFamiliaTrabajo.add(2, " Admite (GPU calculo científico, \n GPU renderizado, \n GPU homeworking) \n");
        listaComponentesSubFamiliaTrabajo.add(3, "8, 10 y 16 horas de duracion");

        JPanel panelSubfamiliaTrabajo = new JPanel(new GridLayout(10, 2));
        panelSubfamiliaTrabajo.add(new JLabel("Precio"));
        panelSubfamiliaTrabajo.add(txtPrecio);
        panelSubfamiliaTrabajo.add(new JLabel("Rating"));
        panelSubfamiliaTrabajo.add(txtRating);
        panelSubfamiliaTrabajo.add(new JLabel("ID Familia: "));
        panelSubfamiliaTrabajo.add(txtIdFamilia);
        panelSubfamiliaTrabajo.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesSubFamiliaTrabajo.get(0));
        textAreaRam.setEditable(false);
        panelSubfamiliaTrabajo.add(textAreaRam);
        panelSubfamiliaTrabajo.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesSubFamiliaTrabajo.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelSubfamiliaTrabajo.add(textAreaAlmacenamiento);
        panelSubfamiliaTrabajo.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesSubFamiliaTrabajo.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelSubfamiliaTrabajo.add(textAreaTarjetaVideo);
        panelSubfamiliaTrabajo.add(new JLabel("Duración de batería"));
        JTextArea textAreaDuracionBateria = new JTextArea(listaComponentesSubFamiliaTrabajo.get(3));
        textAreaDuracionBateria.setEditable(false);
        panelSubfamiliaTrabajo.add(textAreaDuracionBateria);

        volverAlMenuBoutton = new JButton("Volver al menu principal");
        guardarSubfamiliaTrabajo = new JButton("Guardar Subfamilia Trabajo");

        panelSubfamiliaTrabajo.add(guardarSubfamiliaTrabajo);
        panelSubfamiliaTrabajo.add(volverAlMenuBoutton);

        panelPrincipal.add(panelSubfamiliaTrabajo);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelSubfamiliaTrabajo);
            }
        });

        guardarSubfamiliaTrabajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaSubfamiliaTrabajo();
            }
        });

        revalidate();
        repaint();
    }

    public void mostrarPanelRegistroComponenteSubGaming(){
        setTitle("Registro de componente para Subfamilia Gaming");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        //registrarDuracionBateria = new JButton("Registrar duración de Batería");
        //registrarFuenteDePoderButton = new JButton("Registrar Batería");
        registrarTarjetaVideoButton = new JButton("Registrar Tarjeta Video");

        //volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMSubfamiliaGaming();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoSubfamiliaGaming();
            }
        });

        registrarTarjetaVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelTarjetaVideoSubfamiliaGaming();
            }
        });





        JPanel panelComponentes = new JPanel(new GridLayout(3, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        panelComponentes.add(registrarTarjetaVideoButton);
       // panelComponentes.add(registrarFuenteDePoderButton);
        //panelComponentes.add(volverAlMenuBoutton);

//        volverAlMenuBoutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelPrincipal.remove(panelComponentes);
//                setVisible(false);
//
//            }
//        });
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }

    public void mostrarPanelRegistroComponenteSubWorkstation(){
        setTitle("Registro de componente para Subfamilia Gaming");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");
        //registrarDuracionBateria = new JButton("Registrar duración de Batería");
        //registrarFuenteDePoderButton = new JButton("Registrar Batería");
        registrarTarjetaVideoButton = new JButton("Registrar Tarjeta Video");

        //volverAlMenuBoutton = new JButton("Menú Principal");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMSubfamiliaWorkstation();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoSubfamiliaWorkstation();
            }
        });

        registrarTarjetaVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelTarjetaVideoSubfamiliaGaming();
            }
        });





        JPanel panelComponentes = new JPanel(new GridLayout(3, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        panelComponentes.add(registrarTarjetaVideoButton);
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }

    public void mostrarPanelRegistroComponenteSubOficina(){
        setTitle("Registro de componente para Subfamilia Oficina");
        setSize(1600, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!componentesInicializados) {
            // Si ya se han inicializado, simplemente muestra la ventana
            componentesInicializados = true;
        }

        txtModelo = new JTextField();
        txtPrecio = new JTextField();
        txtCategoria = new JTextField();
        txtCapacidad = new JTextField();
        txtRating = new JTextField();
        txtIdComponente = new JTextField();
        txtChipset = new JTextField();
        txtCantidadVentiladores = new JTextField();
        txtDuracionBateria = new JTextField();
        txtCantidadNucleos = new JTextField();

        registrarRAMButton = new JButton("Registrar RAM");
        registrarAlmacenamientoButton = new JButton("Registrar Almacenamiento");


        componenteControlador = new ComponenteControlador(componenteDAO, vista);

        registrarRAMButton.addActionListener(new ActionListener() { /*Esto hace que se muestre el panel de ram despues de hacer click en el boton*/
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRAMSubfamiliaCasaTrabajoOficina();
            }
        });

        registrarAlmacenamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelAlmacenamientoSubfamiliaOficina();
            }
        });

//        registrarFuenteDePoderButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) { mostrarPanelFuentePoderSubfamiliaCasa();
//
//            }
//        });




        JPanel panelComponentes = new JPanel(new GridLayout(2, 1));
        panelComponentes.add(registrarRAMButton);
        panelComponentes.add(registrarAlmacenamientoButton);
        // panelComponentes.add(registrarFuenteDePoderButton);
        //panelComponentes.add(volverAlMenuBoutton);

//        volverAlMenuBoutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelPrincipal.remove(panelComponentes);
//                setVisible(false);
//
//            }
//        });
        //panelPrincipal.removeAll();
        panelPrincipal.add(panelComponentes);
        setVisible(true);
    }

    public Familia almacenaSubfamiliaTrabajo(){
        Familia familia = null;
        ArrayList<String> listaComponentesSubfamiliaTrabajo = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        int idFamilia;
        listaComponentesSubfamiliaTrabajo.add(0, "RAM: 8 o 16B en maximo 2 sticks");
        listaComponentesSubfamiliaTrabajo.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
        listaComponentesSubfamiliaTrabajo.add(2, "Tarjeta de video: Admite Tarjeta de Video (GPU calculo científico, GPU renderizado, GPU homeworking)");
        listaComponentesSubfamiliaTrabajo.add(3, "Duracion de bateria: Opciones de 8, 10 y 16 horas de duracion");

        tipoFamilia = "Portable";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();
        subFamilia = "Trabajo";

        Portable portableTrabajo = new Portable(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating), listaComponentesSubfamiliaTrabajo, "Trabajo", Integer.parseInt(textoIdFamilia));
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesSubfamiliaTrabajo, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(portableTrabajo);
        listaSubFamiliaTrabajo.add(portableTrabajo);
        listFamiliaPortable.add(portableTrabajo);


        return familia;
    }

    public Familia almacenaSubfamiliaCasa(List<Portable> listFamiliaPortable) {
        Familia familia = null;
        ArrayList<String> listaComponentesSubfamiliaCasa = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        int idFamilia;

        listaComponentesSubfamiliaCasa.add(0, "RAM: 8 o 16B en maximo 2 sticks");
        listaComponentesSubfamiliaCasa.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
        listaComponentesSubfamiliaCasa.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
        listaComponentesSubfamiliaCasa.add(3, "Duracion de bateria: de 8 a 10 horas de duracion");

        tipoFamilia = "Portable";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();
        subFamilia = "Casa";

        Portable portableCasa = new Portable(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating), listaComponentesSubfamiliaCasa, "Casa", Integer.parseInt(textoIdFamilia));
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesSubfamiliaCasa, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(portableCasa);
        listaSubFamiliaCasa.add(portableCasa);
        listFamiliaPortable.add(portableCasa);






        return familia;
    }

    public Portable almacenaSubFamiliaCasa2(List<Portable> listFamiliaPortable) {
        ArrayList<String> listaComponentesFamilia = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        int idFamilia;
        Portable portable = null;
        listaComponentesFamilia.add(0, "RAM: 8 o 16B en maximo 2 sticks");
        listaComponentesFamilia.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
        listaComponentesFamilia.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
        listaComponentesFamilia.add(3, "Duracion de bateria: de 8 a 10 horas de duracion");

        tipoFamilia = "Portable";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();
        subFamilia = "Casa";

        portable = new Portable(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating), listaComponentesFamilia, subFamilia, Integer.parseInt(textoIdFamilia));
        listFamiliaPortable.add(portable);
        listaSubFamiliaCasa.add(portable);

        return portable;
    }

    public void initPanelFamiliaSobremesa() {
        setTitle("Registro de Familias Sobremesa");
        setSize(1200, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mostrarPanelFamiliaSobremesa();
    }



    private void mostrarPanelFamiliaSobremesa() {
        JPanel panelFamiliaSobremesa = new JPanel();

        registrarSobremesaGaming = new JButton("Registrar  subfamilia Gaming");
        registrarSobremesaOficina = new JButton("Registrar subfamilia Oficina");
        registrarSobremesaWorkstation = new JButton("Registrar subfamilia Workstation");
        volverAlMenuBoutton = new JButton("Volver al menu principal");

        registrarSobremesaGaming.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelSubfamiliaGaming();
            }
        });

        registrarSobremesaOficina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelSubfamiliaOficina();
            }
        });

        registrarSobremesaWorkstation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelSubfamiliaWorkstation();
            }
        });

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelFamiliaSobremesa);
            }
        });

        panelFamiliaSobremesa.add(registrarSobremesaWorkstation);
        panelFamiliaSobremesa.add(registrarSobremesaGaming);
        panelFamiliaSobremesa.add(registrarSobremesaOficina);
        panelFamiliaSobremesa.add(volverAlMenuBoutton);

        panelPrincipal.add(panelFamiliaSobremesa);

    }


    public void mostrarPanelSubfamiliaGaming() {
        ArrayList<String> listaComponentesSubFamiliaGaming = new ArrayList<>();

        listaComponentesSubFamiliaGaming.add(0, " 16, 24 o 32GB en maximo 4 sticks");
        listaComponentesSubFamiliaGaming.add(1, " Hasta 2 HDD (1TB a 2TB), mínimo un SSD (de 256GB a 1TB)");
        listaComponentesSubFamiliaGaming.add(2, "Tipo de subfamilia si acepta tarjeta de video");

        JPanel panelSubfamiliaGaming = new JPanel(new GridLayout(8, 2));
        panelSubfamiliaGaming.add(new JLabel("Precio"));
        panelSubfamiliaGaming.add(txtPrecio);
        panelSubfamiliaGaming.add(new JLabel("Rating"));
        panelSubfamiliaGaming.add(txtRating);
        panelSubfamiliaGaming.add(new JLabel("ID Familia: "));
        panelSubfamiliaGaming.add(txtIdFamilia);
        panelSubfamiliaGaming.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesSubFamiliaGaming.get(0));
        textAreaRam.setEditable(false);
        panelSubfamiliaGaming.add(textAreaRam);
        panelSubfamiliaGaming.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesSubFamiliaGaming.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelSubfamiliaGaming.add(textAreaAlmacenamiento);
        panelSubfamiliaGaming.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesSubFamiliaGaming.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelSubfamiliaGaming.add(textAreaTarjetaVideo);

        volverAlMenuBoutton = new JButton("Volver al menu principal");
        guardarSubfamiliaGaming = new JButton("Guardar Subfamilia Gaming");
        panelPrincipal.add(panelSubfamiliaGaming);

        panelSubfamiliaGaming.add(guardarSubfamiliaGaming);
        panelSubfamiliaGaming.add(volverAlMenuBoutton);

        panelPrincipal.add(panelSubfamiliaGaming);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelSubfamiliaGaming);
            }
        });

        guardarSubfamiliaGaming.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaSubfamiliaGaming(listaFamiliasRegistradas);
            }
        });

        revalidate();
        repaint();
    }

    public void mostrarPanelSubfamiliaOficina() {
        ArrayList<String> listaComponentesSubFamiliaOficina = new ArrayList<>();

        listaComponentesSubFamiliaOficina.add(0, "8 o 16GB en maximo 2 sticks");
        listaComponentesSubFamiliaOficina.add(1, " 1 SSD (128GB)");
        listaComponentesSubFamiliaOficina.add(2, "Tipo de subfamilia no acepta tarjeta de video");

        JPanel panelSubfamiliaOficina = new JPanel(new GridLayout(8, 2));
        panelSubfamiliaOficina.add(new JLabel("Precio"));
        panelSubfamiliaOficina.add(txtPrecio);
        panelSubfamiliaOficina.add(new JLabel("Rating"));
        panelSubfamiliaOficina.add(txtRating);
        panelSubfamiliaOficina.add(new JLabel("ID Familia: "));
        panelSubfamiliaOficina.add(txtIdFamilia);
        panelSubfamiliaOficina.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesSubFamiliaOficina.get(0));
        textAreaRam.setEditable(false);
        panelSubfamiliaOficina.add(textAreaRam);
        panelSubfamiliaOficina.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesSubFamiliaOficina.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelSubfamiliaOficina.add(textAreaAlmacenamiento);
        panelSubfamiliaOficina.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesSubFamiliaOficina.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelSubfamiliaOficina.add(textAreaTarjetaVideo);

        volverAlMenuBoutton = new JButton("Volver al menu principal");
        guardarSubfamiliaOficina = new JButton("Guardar Subfamilia Oficina");
        panelPrincipal.add(panelSubfamiliaOficina);

        panelSubfamiliaOficina.add(guardarSubfamiliaOficina);
        panelSubfamiliaOficina.add(volverAlMenuBoutton);

        panelPrincipal.add(panelSubfamiliaOficina);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelSubfamiliaOficina);
            }
        });

        guardarSubfamiliaOficina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaSubfamiliaOficina(listaFamiliasRegistradas);
            }
        });

        revalidate();
        repaint();
    }

    public void mostrarPanelSubfamiliaWorkstation() {
        ArrayList<String> listaComponentesSubFamiliaWorkstation = new ArrayList<>();

        listaComponentesSubFamiliaWorkstation.add(0, "32 o 64GB en maximo 8 sticks");
        listaComponentesSubFamiliaWorkstation.add(1, "Mínimo 1 HDD y máximo 2 (1Tb a 2TB), mínimo un SSD (de 256GB a 1TB)");
        listaComponentesSubFamiliaWorkstation.add(2, "Tipo de subfamilia si acepta tarjeta de video");

        JPanel panelSubfamiliaWorkstation = new JPanel(new GridLayout(8, 2));
        panelSubfamiliaWorkstation.add(new JLabel("Precio"));
        panelSubfamiliaWorkstation.add(txtPrecio);
        panelSubfamiliaWorkstation.add(new JLabel("Rating"));
        panelSubfamiliaWorkstation.add(txtRating);
        panelSubfamiliaWorkstation.add(new JLabel("ID Familia: "));
        panelSubfamiliaWorkstation.add(txtIdFamilia);
        panelSubfamiliaWorkstation.add(new JLabel("RAM"));
        JTextArea textAreaRam = new JTextArea(listaComponentesSubFamiliaWorkstation.get(0));
        textAreaRam.setEditable(false);
        panelSubfamiliaWorkstation.add(textAreaRam);
        panelSubfamiliaWorkstation.add(new JLabel("Almacenamiento"));
        JTextArea textAreaAlmacenamiento = new JTextArea(listaComponentesSubFamiliaWorkstation.get(1));
        textAreaAlmacenamiento.setEditable(false);
        panelSubfamiliaWorkstation.add(textAreaAlmacenamiento);
        panelSubfamiliaWorkstation.add(new JLabel("Tarjeta de Video"));
        JTextArea textAreaTarjetaVideo = new JTextArea(listaComponentesSubFamiliaWorkstation.get(2));
        textAreaTarjetaVideo.setEditable(false);
        panelSubfamiliaWorkstation.add(textAreaTarjetaVideo);

        volverAlMenuBoutton = new JButton("Volver al menu principal");
        guardarSubFamiliaWorkstation = new JButton("Guardar Subfamilia Workstation");
        panelPrincipal.add(panelSubfamiliaWorkstation);

        panelSubfamiliaWorkstation.add(guardarSubFamiliaWorkstation);
        panelSubfamiliaWorkstation.add(volverAlMenuBoutton);

        panelPrincipal.add(panelSubfamiliaWorkstation);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelSubfamiliaWorkstation);
            }
        });

        guardarSubFamiliaWorkstation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                almacenaSubfamiliaWorkstation(listaFamiliasRegistradas);
            }
        });

        revalidate();
        repaint();
    }

    public Familia almacenaSubfamiliaWorkstation(List<Familia> listaFamiliasRegistradas) {
        Familia familia = null;
        ArrayList<String> listaComponentesFamilia = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        float rating, peso;
        int idFamilia;
        listaComponentesFamilia.add(0, "RAM: 32 o 64GB en maximo 8 sticks");
        listaComponentesFamilia.add(1, "Almacenamiento:  Mínimo 1 HDD y máximo 2 (1Tb a 2TB), mínimo un SSD (de 256GB a 1TB)");
        listaComponentesFamilia.add(2, "Tarjeta de video: Tipo de computadora si acepta tarjeta de video");

        tipoFamilia = "Sobremesa";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();
        subFamilia = "Workstation";
        Sobremesa sobremesa = new Sobremesa(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating),  listaComponentesFamilia, subFamilia, Integer.parseInt(textoIdFamilia));
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesFamilia, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(sobremesa);
        listaSubfamiliaWorkstation.add(sobremesa);
        listFamiliaSobremesa.add(sobremesa);
        return familia;
    }


    public void initListaFamilias() {
        setTitle("Listar Familias");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        if (!listaFamiliasInicializada) {
            // Si ya se ha inicializado, simplemente muestra la ventana
            listaFamiliasInicializada = true;
        }

        mostrarFamiliasButton = new JButton("Mostrar Familias");
        volverAlMenuBoutton = new JButton("Menú Principal");

        mostrarFamiliasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelListarFamilias(listaFamiliasRegistradas, listFamiliaSobremesa, listFamiliaPortable);
            }
        });

        JPanel panelMainFamilias = new JPanel();
        panelMainFamilias.add(mostrarFamiliasButton);
        panelMainFamilias.add(volverAlMenuBoutton);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelMainFamilias);
            }
        });


        panelPrincipal.removeAll();
        panelPrincipal.add(panelMainFamilias);
        setVisible(true);
    }

    public void initRegistroComponenteFamilia() {
        setTitle("Registro de Componente a Familia");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        txtRam = new JTextField();
        txtAlmacenamiento = new JTextField();

        if (!listaFamiliasInicializada) {
            // Si ya se ha inicializado, simplemente muestra la ventana
            listaFamiliasInicializada = true;
        }

        mostrarFamiliasButton = new JButton("Mostrar Familias");
        volverAlMenuBoutton = new JButton("Menú Principal");

        mostrarFamiliasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRegistroComponenteAFamilia(listaFamiliasRegistradas, listFamiliaSobremesa, listFamiliaPortable);
            }
        });

        JPanel panelMainFamilias = new JPanel();
        panelMainFamilias.add(mostrarFamiliasButton);
        panelMainFamilias.add(volverAlMenuBoutton);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelMainFamilias);
            }
        });


        panelPrincipal.removeAll();
        panelPrincipal.add(panelMainFamilias);
        setVisible(true);
    }

    public Familia almacenaSubfamiliaOficina(List<Familia> listaFamiliasRegistradas) {
        Familia familia = null;
        ArrayList<String> listaComponentesFamilia = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        float rating, peso;
        int idFamilia;
        listaComponentesFamilia.add(0, "RAM: 8 o 16GB en maximo 2 sticks");
        listaComponentesFamilia.add(1, "Almacenamiento:  1 SSD (128GB)");
        listaComponentesFamilia.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");

        tipoFamilia = "Sobremesa";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();
        subFamilia = "Oficina";

        Sobremesa sobremesa = new Sobremesa(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating),  listaComponentesFamilia, subFamilia, Integer.parseInt(textoIdFamilia));
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesFamilia, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(sobremesa);
        listaSubfamiliaOficina.add(sobremesa);
        listFamiliaSobremesa.add(sobremesa);


        return familia;
    }

    public Familia almacenaSubfamiliaGaming(List<Familia> listaFamiliasRegistradas) {
        Familia familia = null;
        ArrayList<String> listaComponentesFamilia = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        float rating, peso;
        int idFamilia;
        listaComponentesFamilia.add(0, "RAM: 16, 24 o 32GB en maximo 4 sticks");
        listaComponentesFamilia.add(1, "Almacenamiento: hasta 2 HDD (1TB a 2TB), mínimo un SSD (de 256GB a 1TB)");
        listaComponentesFamilia.add(2, "Tarjeta de video: Tipo de computadora si acepta tarjeta de video");

        tipoFamilia = "Sobremesa";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();
        subFamilia = "Gaming";

        Sobremesa sobremesa = new Sobremesa(tipoFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating),  listaComponentesFamilia, subFamilia, Integer.parseInt(textoIdFamilia));
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesFamilia, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(sobremesa);
        listaSubfamiliaGaming.add(sobremesa);
        listFamiliaSobremesa.add(sobremesa);


        return familia;
    }


    public Familia almacenaFamiliaEscolar(List<Familia> listaFamiliasRegistradas) {
        Familia familia = null;
        ArrayList<String> listaComponentesFamilia = new ArrayList<>();
        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
        double precio;
        float rating, peso;
        int idFamilia;
        listaComponentesFamilia.add(0, "RAM: 4, 8 o 16GB en maximo 2 sticks");
        listaComponentesFamilia.add(1, "Almacenamiento:  1 HDD(1 Tb) o un SSD (128GB)");
        listaComponentesFamilia.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");

        tipoFamilia = "Escolar";
        String textoPrecio = txtPrecio.getText();
        String textoRating = txtRating.getText();
        String textoIdFamilia = txtIdFamilia.getText();

        Familia nuevaFamiliaEscolar = new Escolar(tipoFamilia, listaComponentesFamilia, Double.parseDouble(textoPrecio), Integer.parseInt(textoRating));
        familia = new Familia(tipoFamilia, Integer.parseInt(textoIdFamilia), listaComponentesFamilia, Integer.parseInt(textoRating), Double.parseDouble(textoPrecio));
        listaFamiliasRegistradas.add(familia);


        return familia;

    }

    public void mostrarPanelListarFamilias(List<Familia> listaFamiliasRegistradas, List<Sobremesa> listFamiliaSobremesa, List<Portable> listFamiliaPortable) {
        JPanel panelListaFamilias = new JPanel(new GridLayout(listaFamiliasRegistradas.size(), 6));
        for (Familia familia : listaFamiliasRegistradas) {
            panelListaFamilias.add(new JLabel("Tipo de Familia: "));
            JTextArea textAreaTipoFamilia = new JTextArea(String.valueOf(familia.getTipoFamilia()));
            textAreaTipoFamilia.setEditable(false);
            panelListaFamilias.add(textAreaTipoFamilia);
            String tipoFamiliaRegistrado = familia.getTipoFamilia();
            if ("Sobremesa".equals((tipoFamiliaRegistrado))) {
                for (Sobremesa sobremesa : listFamiliaSobremesa) {
                    if (sobremesa.getTipoFamilia().equals(tipoFamiliaRegistrado)  && sobremesa.getIdFamilia() == familia.getIdFamilia()) {
                        panelListaFamilias.add(new JLabel("Subfamilia: "));
                        JTextArea textAreaSubFamilia = new JTextArea(String.valueOf(sobremesa.getSubFamilia()));
                        textAreaSubFamilia.setEditable(false);
                        panelListaFamilias.add(textAreaSubFamilia);
                        break;

                    }
                }
            } else if ("Portable".equals(familia.getTipoFamilia())) {
                for (Portable portable : listFamiliaPortable) {
                    if (portable.getTipoFamilia().equals(tipoFamiliaRegistrado) && portable.getIdFamilia() == familia.getIdFamilia()) {
                        panelListaFamilias.add(new JLabel("Subfamilia: "));
                        JTextArea textAreaSubFamilia = new JTextArea(String.valueOf(portable.getSubFamilia()));
                        textAreaSubFamilia.setEditable(false);
                        panelListaFamilias.add(textAreaSubFamilia);
                        break;
                    }
                }
            } else {
                panelListaFamilias.add(new JLabel("Subfamilia: "));
                JTextArea textAreaSubFamilia = new JTextArea("No tiene subfamilia");
                textAreaSubFamilia.setEditable(false);
                panelListaFamilias.add(textAreaSubFamilia);
            }
            panelListaFamilias.add(new JLabel("Precio: "));
            JTextArea textAreaPrecio = new JTextArea(String.valueOf(familia.getPrecio()));
            textAreaPrecio.setEditable(false);
            panelListaFamilias.add(textAreaPrecio);
            panelListaFamilias.add(new JLabel("Rating: "));
            JTextArea textAreaRating = new JTextArea(String.valueOf(familia.getRating()));
            textAreaRating.setEditable(false);
            panelListaFamilias.add(textAreaRating);
        }

        panelPrincipal.add(panelListaFamilias);

        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelPrincipal.add(volverAlMenuBoutton);

        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelListaFamilias);
            }
        });

        revalidate();
        repaint();
    }

    public void mostrarPanelRegistroComponenteAFamilia(List<Familia> listaFamiliasRegistradas, List<Sobremesa> listFamiliaSobremesa, List<Portable> listFamiliaPortable) {
        JPanel panelListaFamilias = new JPanel(new GridLayout(listaFamiliasRegistradas.size(), 3));
        for (Familia familia : listaFamiliasRegistradas) {
            panelListaFamilias.add(new JLabel("Tipo de Familia: "));
            JTextArea textAreaTipoFamilia = new JTextArea(String.valueOf(familia.getTipoFamilia()));
            textAreaTipoFamilia.setEditable(false);
            panelListaFamilias.add(textAreaTipoFamilia);
            String tipoFamiliaRegistrado = familia.getTipoFamilia(); /*con cuidado*/
            if ("Sobremesa".equals((tipoFamiliaRegistrado))) {
                for (Sobremesa sobremesa : listFamiliaSobremesa) {
                    if (sobremesa.getTipoFamilia().equals(tipoFamiliaRegistrado)  && sobremesa.getIdFamilia() == familia.getIdFamilia()) {
                        panelListaFamilias.add(new JLabel("Subfamilia: "));
                        JTextArea textAreaSubFamilia = new JTextArea(String.valueOf(sobremesa.getSubFamilia()));
                        textAreaSubFamilia.setEditable(false);
                        panelListaFamilias.add(textAreaSubFamilia);
                        break;

                    }
                }
            } else if ("Portable".equals(familia.getTipoFamilia())) {
                for (Portable portable : listFamiliaPortable) {
                    if (portable.getTipoFamilia().equals(tipoFamiliaRegistrado) && portable.getIdFamilia() == familia.getIdFamilia()) {
                        panelListaFamilias.add(new JLabel("Subfamilia: "));
                        JTextArea textAreaSubFamilia = new JTextArea(String.valueOf(portable.getSubFamilia()));
                        textAreaSubFamilia.setEditable(false);
                        panelListaFamilias.add(textAreaSubFamilia);
                        break;
                    }
                }
            } else {
                panelListaFamilias.add(new JLabel("Subfamilia: "));
                JTextArea textAreaSubFamilia = new JTextArea("No tiene subfamilia");
                textAreaSubFamilia.setEditable(false);
                panelListaFamilias.add(textAreaSubFamilia);
            }
            panelListaFamilias.add(new JLabel("Id Familia: "));
            JTextArea textAreaId = new JTextArea(String.valueOf(familia.getIdFamilia()));
            textAreaId.setEditable(false);
            panelListaFamilias.add(textAreaId);

            txtPrecio = new JTextField();
            txtRating = new JTextField();
            txtIdFamilia = new JTextField();


            registrarFamiliaEscolar = new JButton("Registrar Comp para Escolar");
            registrarFamiliaPortable = new JButton("Registrar Comp para Portable");
            registrarFamiliaServidor = new JButton("Registrar Comp para Servidor");
            registrarFamiliaSobremesa = new JButton("Registrar Comp para Sobremesa");
            volverAlMenuBoutton = new JButton("Menú Principal");

            registrarFamiliaEscolar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    mostrarPanelFamiliaEscolarParaRegistroComponente();
                    //mostrarPanelRegistroComponenteEscolar();
                    initPanelRegistroComponenteEscolar();
                }
            });

            registrarFamiliaSobremesa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //initPanelFamiliaSobremesa();
                    iniciaInitPanelRegistroComponenteSobremesa();
                }
            });

            registrarFamiliaPortable.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //initPanelFamiliaPortable();
                    iniciaInitPanelRegistroComponentePortable();
                }
            });

            registrarFamiliaServidor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //mostrarPanelFamiliaServidor();
                    initPanelRegistroComponenteServidor();
                }

            });

            JPanel panelFamilias = new JPanel();
            panelFamilias.add(registrarFamiliaEscolar);
            panelFamilias.add(registrarFamiliaPortable);

            panelFamilias.add(registrarFamiliaServidor);
            panelFamilias.add(registrarFamiliaSobremesa);
            panelFamilias.add(volverAlMenuBoutton);
            panelPrincipal.removeAll();
            panelPrincipal.add(panelFamilias);

        }

        panelPrincipal.add(panelListaFamilias);


        volverAlMenuBoutton = new JButton("Volver al menu principal");
        panelPrincipal.add(volverAlMenuBoutton);


        volverAlMenuBoutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                panelPrincipal.remove(panelListaFamilias);
            }
        });

        revalidate();
        repaint();
    }


//    public void listarComponente(List<Componente> componentes) {
//        boolean impar = false;
//        Utils.limpiar();
//        Utils.establecerColorAzul();
//        System.out.printf("%-10s %-20s %-20s\n", "Tipo", "Precio", "Modelo");
//        if (componentes != null && componentes.size() > 0) {
//            for (Componente c : componentes) {
//                impar = !impar;
//                if (impar) {
//                    Utils.establecerColorAmarillo();
//                } else {
//                    Utils.establecerColorVerde();
//                }
//                System.out.printf("%-10s %-20.2f %-20s\n", c.getTipoComponente(), c.getPrecio(), c.getModelo());
//            }
//            Utils.establecerColorMangenta();
//            System.out.println("EOF");
//        } else {
//            Utils.establecerColorRojo();
//            System.out.println("NO HAY DATOS");
//        }
//        Utils.reiniciarColores();
//    }


//    public Computadora capturarNuevaComputadora() {
//
//        Componente componente = null;
//        //String modelo, tipoComponente, categoria, capacidad, duracionBateria, opcionComponente, chipset;
//        //int rating, idComponente, cantidadNucleos, cantidadVentiladores;
//        //double precio;
//        String opcionComponente, ram, ramAdicional, decideCapacidadAdicional, almacenamiento, opcionesSobremesa, cantidadHDD, cantidadSSD, tarjetaVideo, tipoHDD, tipoSSD;
//        Utils.limpiar();
//
//        Utils.establecerColorAzul();
//        System.out.println("Registro de Familia:");
//        Utils.reiniciarColores();
//        opcionComponente = Utils.leerString(String.format("%-20s: ", "Tipo de Familia (Seleccione una de las siguientes opciones)\n1.Escolar \n2.Sobremesa \n3.Portables \n4.Servidores"));
//
//        if (opcionComponente.equals("1")) {
//            System.out.println("A continuación ingrese la información acerca del tipo de Familia 'Escolar'");
//            ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
//            if (ram.equals("4")) {
//                System.out.println("Capacidad elegida de manera satisfactoria");
//                ram = "4";
//                decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                if (decideCapacidadAdicional.equals("1")) {
//                    ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
//                } else if (decideCapacidadAdicional.equals("2")) {
//                    System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                }
//                ;
//            } else if (ram.equals("8")) {
//                System.out.println("Capacidad elegida de manera satisfactoria");
//                ram = "8";
//                decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                if (decideCapacidadAdicional.equals("1")) {
//                    ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
//                    System.out.println(ramAdicional);
//                    System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                } else if (decideCapacidadAdicional.equals("2")) {
//                    System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                }
//
//            } else if (ram.equals("16")) {
//                System.out.println("Capacidad elegida de manera satisfactoria");
//                ram = "16";
//                decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                if (decideCapacidadAdicional.equals("1")) {
//                    ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
//                    System.out.println(ramAdicional);
//                    System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                } else if (decideCapacidadAdicional.equals("2")) {
//                    System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                }
//
//            }
//            almacenamiento = Utils.leerString(String.format("%-20s: ", "Capacidad de almacenamiento. (Elija entre \n1. 1 HDD(1 Tb) \n2. 1 SSD(12GB)"));
//            if (almacenamiento.equals("1")) {
//                System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                System.out.println(almacenamiento);
//                almacenamiento = "1 HDD(1 Tb)";
//            } else if (almacenamiento.equals("2")) {
//                System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                System.out.println(almacenamiento);
//                almacenamiento = "1 SSD(12GB)";
//            }
//
//            System.out.println("Esta familia de computadoras no acepta tarjetas de video");
//
//            /*Definir donde se va a guardar lo de la familia Escolar, que es de la linea 142 a la 194*/
//
//
//            // componente // aca iba a implementar lo de la nueva clase familia, para que se guarde como familia y no como componente, e ignora las lineas de abajo, fue un copy paste que iba editando conforme fuera necesario para ir metiendo mas IFs
//
//
//        } else if (opcionComponente.equals("2")) {
//            opcionesSobremesa = Utils.leerString(String.format("%-20s: ", "Tipo de computadora de la familia Sobremesa (Seleccione una de las siguientes opciones) \nA. Oficina \nB. Gaming \nC. Workstation \nSeleccione una opcion: "));
//            if (opcionesSobremesa.equals("A")) {
//                System.out.println("A continuacion ingrese la informacion necesaria para el tipo de computadora Oficina");
//                ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '8', '16' GB)"));
//
//                if (ram.equals("8")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "8";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '4', '8', '16' GB)"));
//                        System.out.println(ramAdicional);
//                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//
//                } else if (ram.equals("16")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "16";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre  '8', '16' GB)"));
//                        System.out.println(ramAdicional);
//                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//
//                }
//                almacenamiento = Utils.leerString(String.format("%-20s: ", "Capacidad de almacenamiento disponible para Oficna: 1 SSD (256GB) \n Ingrese 1 para confirmar: "));
//                if (almacenamiento.equals("1")) {
//                    System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                    System.out.println(almacenamiento);
//                    almacenamiento = "1 SSD (256GB) ";
//                } else {
//                    System.out.println("Error, intente nuevamente");
//
//                    System.out.println("Esta subfamilia de computadoras no acepta tarjetas de video");
//                }
//            } else if (opcionesSobremesa.equals("B")) {
//                System.out.println("A continuacion ingrese los detalles de los componentes de 'Gaming' ");
//                ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
//                if (ram.equals("16")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "16";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//                    ;
//                } else if (ram.equals("8")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "24";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
//                        System.out.println(ramAdicional);
//                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//
//                } else if (ram.equals("32")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "32";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '16', '24', '32' GB)"));
//                        System.out.println(ramAdicional);
//                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//                }
//                almacenamiento = Utils.leerString(String.format("%-20s: ", "Capacidad de almacenamiento. (Elija el tipo de almacenamiento entre \n1. HDD \n2. SSD "));
//                if (almacenamiento.equals("1")) {
//                    cantidadHDD = Utils.leerString(String.format("%-20s: ", "Digite la cantidad de sticks de HDD que desea (MAXIMO 2  sticks)"));
//                    if (cantidadHDD.equals("1")) {
//                        tipoHDD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 1Tb \n2. 2Tb)"));
//                        if (tipoHDD.equals("1")) {
//                            almacenamiento = "HDD 1Tb ";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        } else if (tipoHDD.equals("2")) {
//                            almacenamiento = "HDD 2Tb";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        }
//                    } else if (cantidadHDD.equals("2")) {
//                        tipoHDD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 1Tb \n2. 2Tb \n3. 1 Stick de Tb y 1 Stick 2 Tb)"));
//                        if (tipoHDD.equals("1")) {
//                            almacenamiento = "HDD 1Tb ";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        } else if (tipoHDD.equals("2")) {
//                            almacenamiento = "HDD 2Tb";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        } else if (tipoHDD.equals("3")) {
//                            almacenamiento = "1 Stick HDD de 1Tb y 1 Stick HDD de 2 Tb";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//
//                        }
//                    }
//                } else if (almacenamiento.equals("2")) {
//                    cantidadSSD = Utils.leerString(String.format("%-20s: ", "Digite la cantidad de sticks de SSD que desea (MAXIMO 2  sticks, MINIMO 1 de 256gb)"));
//                    if (cantidadSSD.equals("1")) {
//                        tipoSSD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 256GB \n2. 1Tb \n3. 1 SSD de 256GB y 1 SSD de 1Tb )"));
//                        if (tipoSSD.equals("1")) {
//                            almacenamiento = "256 GB ";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        } else if (tipoSSD.equals("2")) {
//                            almacenamiento = "1 Tb";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        }
//                    } else if (cantidadSSD.equals("2")) {
//                        tipoHDD = Utils.leerString(String.format("%-20s: ", "Cpacidad de almacenamiento HDD (Elija entre \n1. 1Tb \n2. 2Tb \n3. 1 Stick de Tb y 1 Stick 2 Tb)"));
//                        if (tipoHDD.equals("1")) {
//                            almacenamiento = "SSD 256GB ";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        } else if (tipoHDD.equals("2")) {
//                            almacenamiento = "SSD 2Tb";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//                        } else if (tipoHDD.equals("3")) {
//                            almacenamiento = "1 Stick SSD de 256 y 1 Stick SSD de 1 Tb";
//                            System.out.println(almacenamiento);
//                            System.out.println("Capacidad de almacenamiento elegida de manera satisfactoria");
//
//                        }
//
//                    }
//                }
//
//                System.out.println("Ingrese a continuacion los detalles sobre la tarjeta de video");
//                tarjetaVideo = Utils.leerString(String.format("%-20s: ", "Modelo de Tarjeta de Video"));
//                System.out.println(tarjetaVideo);
//                System.out.println("Tarjeta de video ingresada correctamente");
//            } else if (opcionesSobremesa.equals("C")) {
//                System.out.println("A continuacion ingrese los detalles de los componentes de 'Workstation' ");
//                ram = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '32', '64' GB)"));
//                if (ram.equals("32")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "32";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '32', '64' GB)"));
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//                    ;
//                } else if (ram.equals("64")) {
//                    System.out.println("Capacidad elegida de manera satisfactoria");
//                    ram = "64";
//                    decideCapacidadAdicional = Utils.leerString(String.format("%-20s: ", "Si desea agregar un RAM stick adicional, por favor ingrese \n1.Si  \n2.No "));
//                    if (decideCapacidadAdicional.equals("1")) {
//                        ramAdicional = Utils.leerString(String.format("%-20s: ", "Capacidad de RAM. (Elija entre '32', '64' GB)"));
//                        System.out.println(ramAdicional);
//                        System.out.println("Capacidad adicional elegida de manera satisfactoria");
//                    } else if (decideCapacidadAdicional.equals("2")) {
//                        System.out.println("Capacidad adicional rechazada de manera satisfactoria");
//
//                    }
//
//
//                }
//
//
//            }
//
//        }
//
//
//        //} else
//        // opcionComponente = Utils.leerString(String.format("%-20s: ", "Opción Incorrecta\n(Seleccione una de las siguientes opciones)\n1.Ram \n2.Procesador \n3.Almacenamiento \n4.Fuente de Poder \n5.Tarjeta Madre \n6.Tarjeta de Video "));
//        Utils.limpiar();
//        return null;
//    }
//

//    public Familia capturarNuevaFamilia() {
//
//        Familia familia = null;
//        String opcionFamilia, opcionSobremesa, opcionPortable, tipoFamilia, subFamilia, duracionBateria;
//        double precio;
//        float rating, peso;
//        int idFamilia;
//
//        ArrayList<String> listaComponentes = new ArrayList<>();
//        Utils.establecerColorAzul();
//        System.out.println("Registro de Familia:");
//        Utils.reiniciarColores();
//        opcionFamilia = Utils.leerString(String.format("%-20s: ", "Tipo de Familia (Seleccione una de las siguientes opciones)\n1.Escolar \n2.Sobremesa \n3.Portables \n4.Servidores \nIngrese una opcion: "));
//        if (opcionFamilia.equals("1")) {
//            tipoFamilia = "Escolar";
//            precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//            rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//            System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//            listaComponentes.add(0, "RAM: 4, 8 o 16GB en maximo 2 sticks");
//            listaComponentes.add(1, "Almacenamiento:  1 HDD(1 Tb) o un SSD (128GB)");
//            listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
//            for (String componente : listaComponentes) {
//                System.out.println("- " + componente);
//            }
//
//
//            Familia nuevaFamiliaEscolar = new Escolar(tipoFamilia, listaComponentes, precio, rating);
//            // familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
//
//
//        } else if (opcionFamilia.equals("2")) {
//            opcionSobremesa = Utils.leerString(String.format("%-20s: ", "Tipo de Sobremesa (Seleccione una de las siguientes opciones) \n201. Oficina \n202. Gaming \n203. Workstation \nIngrese una opcion: "));
//            if (opcionSobremesa.equals("201")) {
//                tipoFamilia = "Sobremesa";
//                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//                listaComponentes.add(0, "RAM: 8 o 16GB en maximo 2 sticks");
//                listaComponentes.add(1, "Almacenamiento:  1 SSD (128GB)");
//                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
//
//                for (String componente : listaComponentes) {
//                    System.out.println("- " + componente);
//                }
//                subFamilia = "Oficina";
//
//                Familia nuevaSubfamiliaOficina = new Sobremesa(tipoFamilia, listaComponentes, precio, rating, subFamilia);
//                //  familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
//
//
//            } else if (opcionSobremesa.equals("202")) {
//                tipoFamilia = "Sobremesa";
//                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//                listaComponentes.add(0, "RAM: 16, 24 o 32GB en maximo 4 sticks");
//                listaComponentes.add(1, "Almacenamiento: hasta 2 HDD (1TB a 2TB), mínimo un SSD (de 256GB a 1TB)");
//                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora si acepta tarjeta de video");
//                subFamilia = "Gaming";
//                for (String componente : listaComponentes) {
//                    System.out.println("- " + componente);
//                }
//
//                Familia nuevaSubfamiliaGaming = new Sobremesa(tipoFamilia, listaComponentes, precio, rating, subFamilia);
//                //  familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
//
//            } else if (opcionSobremesa.equals("203")) {
//                tipoFamilia = "Sobremesa";
//                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//                listaComponentes.add(0, "RAM: 32 o 64GB en maximo 8 sticks");
//                listaComponentes.add(1, "Almacenamiento:  Mínimo 1 HDD y máximo 2 (1Tb a 2TB), mínimo un SSD (de 256GB a 1TB)");
//                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora si acepta tarjeta de video");
//                subFamilia = "Workstation";
//                for (String componente : listaComponentes) {
//                    System.out.println("- " + componente);
//                }
//
//                Familia nuevaSubfamiliaWorkstation = new Sobremesa(tipoFamilia, listaComponentes, precio, rating, subFamilia);
//                //  familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
//
//            }
//
//        } else if (opcionFamilia.equals("3")) {
//            opcionPortable = Utils.leerString(String.format("%-20s: ", "Tipo de Portable (Seleccione una de las siguientes opciones) \n301. Casa \n302. Trabajo  \nIngrese una opcion: "));
//            if (opcionPortable.equals("301")) {
//                tipoFamilia = "Portable";
//                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//                listaComponentes.add(0, "RAM: 8 o 16B en maximo 2 sticks");
//                listaComponentes.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
//                listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no acepta tarjeta de video");
//                listaComponentes.add(3, "Duracion de bateria: de 8 a 10 horas de duracion");
//                for (String componente : listaComponentes) {
//                    System.out.println("- " + componente);
//                }
//
//                subFamilia = "Casa";
//                peso = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el peso: ")));
//
//                //Familia nuevaSubfamiliaCasa = new Portable(tipoFamilia, precio, rating, listaComponentes, subFamilia, peso);
//                //familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
//
//            } else if (opcionPortable.equals("302")) {
//                tipoFamilia = "Portable";
//                precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//                rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//                System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//                listaComponentes.add(0, "RAM: 8 o 16B en maximo 2 sticks");
//                listaComponentes.add(1, "Almacenamiento:  1 SSD (256GB / 512GB)");
//                listaComponentes.add(2, "Tarjeta de video: Admite Tarjeta de Video (GPU calculo científico, GPU renderizado, GPU homeworking)");
//                listaComponentes.add(3, "Duracion de bateria: Opciones de 8, 10 y 16 horas de duracion");
//                for (String componente : listaComponentes) {
//                    System.out.println("- " + componente);
//                }
//                peso = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el peso: ")));
//
//                subFamilia = "Trabajo";
//
//
//                // Familia nuevaSubfamiliaTrabajo = new Portable(tipoFamilia, precio, rating, listaComponentes, subFamilia, peso);
//                //familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
//
//            }
//
//        } else if (opcionFamilia.equals("4")) {
//            tipoFamilia = "Servidor";
//            precio = Double.parseDouble(Utils.leerString(String.format("%-20s: ", "Ingrese el precio sin comas o puntos: ")));
//            rating = Float.parseFloat(Utils.leerString(String.format("%-20s: ", "Ingrese el rating: ")));
//            System.out.println("A continuacion se muestra la lista de componentes disponibles para este tipo de computadoa");
//            listaComponentes.add(0, "RAM: 64 / 128 / 256 / 512 / 1024 GB (máximo 16 sticks)");
//            listaComponentes.add(1, "Almacenamiento:  32 / 64 /128 TB");
//            listaComponentes.add(2, "Tarjeta de video: Tipo de computadora no admite cambios de tarjeta de video)");
//            listaComponentes.add(3, "Fuentes de poder: maximo 8");
//            for (String componente : listaComponentes) {
//                System.out.println("- " + componente);
//            }
//
//
//            //Familia nuevaSubfamiliaTrabajo = new Servidor(tipoFamilia, precio, rating, listaComponentes);
////            familia = new Familia(tipoFamilia, 0, listaComponentes, rating, precio);
////
//        }
//        return familia;
//    }

//    public void listarFamilia(List<Familia> familias) {
//        boolean impar = false;
//        Utils.limpiar();
//        Utils.establecerColorAzul();
//        System.out.printf("%-10s \n", "Tipo de familia");
//        if (familias != null && familias.size() > 0) {
//            for (Familia f : familias) {
//                impar = !impar;
//                if (impar) {
//                    Utils.establecerColorAmarillo();
//                } else {
//                    Utils.establecerColorVerde();
//                }
//                System.out.printf("%-10s\n", f.getTipoFamilia());
//            }
//            Utils.establecerColorMangenta();
//
//        } else {
//            Utils.establecerColorRojo();
//            System.out.println("NO HAY DATOS");
//        }
//        Utils.reiniciarColores();
//
//    }

}





