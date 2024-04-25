import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;
    private Cine asistentes1=new Cine ();

    private Cine asistentes2=new Cine ();

    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= JOptionPane.showInputDialog("Ingrese su número de cédula real");
            a = JOptionPane.showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asistentes1.encolar(cboPelicula.getSelectedItem().toString(),Integer.parseInt(cboCantidad.getSelectedItem().toString()));
                txtEntradas.setText(asistentes1.listarPeliculas());
                limpiarCampos();
            }
        });
        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Entradas disponibles: "+asistentes1.entradasDisponiblesP1());
            }
        });
        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Entradas disponibles: "+asistentes2.entradasDisponiblesP2());
            }
        });
    }
    public void limpiarCampos(){
        cboPelicula.setSelectedItem("");
        cboCantidad.setSelectedItem("");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
