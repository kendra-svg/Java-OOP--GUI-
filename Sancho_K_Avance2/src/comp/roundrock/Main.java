package comp.roundrock;

import comp.roundrock.Controller.FamiliaControlador;
import comp.roundrock.DAO.ComponenteDAO;
import comp.roundrock.DAO.FamiliaDAO;
import comp.roundrock.DAO.Memory.ComponenteDAOMemoria;
import comp.roundrock.DAO.Memory.FamiliaDAOMemoria;
import comp.roundrock.View.Vista;
import comp.roundrock.Controller.ComponenteControlador;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame {

    ComponenteDAO componenteDAO = new ComponenteDAOMemoria();
    private Vista vista;

    private ComponenteDAOMemoria componenteDAOMemoria;
    private ComponenteControlador componenteControlador;
    private FamiliaDAO familiaDAO;
    private FamiliaControlador familiaControlador;

    private JButton registrarComponenteButton;
    private JButton listarComponenteButton;
    private JButton registrarFamiliaButton;
    private JButton listarFamiliasButton;

    private JButton registrarComponentesPermitidosAfamiliaButton;

    private JButton registroArmarComputadoraButton;
    private JButton salirButton;

    private JButton listarComputadorasArmadasButton;





    public Main() {
        setTitle("Registro de computadoras y familias");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        // Inicializar DAOs, controladores y otros componentes aquí
        componenteDAO = new ComponenteDAOMemoria();
        vista = new Vista();
        componenteControlador = new ComponenteControlador(componenteDAO, vista);
        familiaDAO = new FamiliaDAOMemoria();
        familiaControlador = new FamiliaControlador(familiaDAO, vista);

        // Crear botones
        registrarComponenteButton = new JButton("Registrar Componente");



        listarComponenteButton = new JButton("Listar Componentes");
        registrarFamiliaButton = new JButton("Registrar Familia");
        listarFamiliasButton = new JButton("Listar Familias");
        registrarComponentesPermitidosAfamiliaButton = new JButton("Agregar componentes permitidos a familia");
        registroArmarComputadoraButton = new JButton("Armar Computadora");
        listarComputadorasArmadasButton = new JButton("Listar computadoras armadas");

        salirButton = new JButton("Salir");

        // Configurar acciones de los botones
        registrarComponenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vista.initComponents();
            }
        });




        listarComponenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.initListaComponente();
            }
        });



        registrarFamiliaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.initFamilias();

            }
        });

        listarFamiliasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vista.initListaFamilias();
            }
        });

        registrarComponentesPermitidosAfamiliaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.initRegistroComponenteFamilia();
            }
        });

        registroArmarComputadoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.iniciaInitArmadoComputadora();
            }
        });

        listarComputadorasArmadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.initListaComputadoras();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);


            }
        });

        // Crear panel y agregar botones
        JPanel panel = new JPanel();
        panel.add(registrarComponenteButton);
        panel.add(listarComponenteButton);
        panel.add(registrarFamiliaButton);
        panel.add(listarFamiliasButton);
        panel.add(registrarComponentesPermitidosAfamiliaButton);
        panel.add(registroArmarComputadoraButton);
        panel.add(listarComputadorasArmadasButton);
        panel.add(salirButton);



        // Agregar panel a la ventana
        getContentPane().add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}
