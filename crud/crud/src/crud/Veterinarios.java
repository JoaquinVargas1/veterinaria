package crud;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class Veterinarios extends javax.swing.JFrame {

    /**
     * Creates new form mascotas_r
     */
    public Veterinarios() {
        initComponents();
        conexion conecta=new conexion();
        conecta.llenaCombo("medicinas", "nombre_medicina", list_med);
        conecta.llenaCombo("veterinario", "nombre_vet", list_veterinario);
        //conecta.llenaCombo("dueño", "nombre_dueño", nombre_vet);
    
    }
    
    public void actualizarDatos() {
    	JFrame f= new JFrame();
    	f.setLayout(null);
    	f.setSize(500,600);
    	f.setLocation(0,0);
    	f.setVisible(true);
    	JPanel ss = new JPanel();
    	ss.setSize(300,600);
    	ss.setLocation(0,0);
    	ss.setLayout(null);
    	
    	
    	JLabel actualizarDatos = new JLabel("Actualizar Datos Mascota");
    	actualizarDatos.setSize(700,30);
    	actualizarDatos.setLocation(20,5);
    	actualizarDatos.setFont(new Font("Arial",Font.BOLD,20));
    	ss.add(actualizarDatos);

    	
    	JLabel nombreMascota = new JLabel("Nombre de Mascota: ");
    	nombreMascota.setSize(150,30);
    	nombreMascota.setLocation(10,50);
    	ss.add(nombreMascota);
    	
    	
    	JTextField newNombreMascota = new JTextField();
    	newNombreMascota.setSize(150,30);
    	newNombreMascota.setLocation(120,50);
    	ss.add(newNombreMascota);
    	
    	
    	
    	JLabel nombreMedicina = new JLabel("ID de Medicina: ");
    	nombreMedicina.setSize(150,30);
    	nombreMedicina.setLocation(10,80);
    	ss.add(nombreMedicina);
    	
    	
    	JTextField newNombreMedicina = new JTextField();
    	newNombreMedicina.setSize(150,30);
    	newNombreMedicina.setLocation(120,80);
    	ss.add(newNombreMedicina);
    	
    	JLabel nombreVeterinario = new JLabel("ID de Veterinario: ");
    	nombreVeterinario.setSize(150,30);
    	nombreVeterinario.setLocation(10,120);
    	ss.add(nombreVeterinario);
    	
    	
    	JTextField newNombreVeterinario = new JTextField();
    	newNombreVeterinario.setSize(150,30);
    	newNombreVeterinario.setLocation(150,120);
    	ss.add(newNombreVeterinario);
    	
    	
    	JLabel idMascota = new JLabel("Mascota a Modificar su ID: ");
    	idMascota.setSize(300,30);
    	idMascota.setLocation(10,150);
    	ss.add(idMascota);
    	
    	
    	JTextField idMascotaBuscar = new JTextField();
    	idMascotaBuscar.setSize(150,30);
    	idMascotaBuscar.setLocation(150,150);
    	ss.add(idMascotaBuscar);
    	
    	
    	
    	JButton s = new JButton("Actualizar");
    	s.setLocation(180,190);
    	s.setSize(100,30);
    	s.setVisible(true);
    	ss.add(s);
    	f.add(ss);
    	
    	s.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        

						 Statement st;
					        conexion con = new conexion();
					        Connection conexion = con.conectar();
					             
					        String nombreMedicina = newNombreMedicina.getText();
					        String id= idMascotaBuscar.getText();
					        String nombreMascota= newNombreMascota.getText();
					       
					        String nombreVeterinario =newNombreVeterinario.getText();
					        
					        try {
					        	
						       

						        String sql= "UPDATE mascotas SET nombre = '"+nombreMascota+"', fk_medicina = "+
										nombreMedicina+", fk_veterinario = "+nombreVeterinario+" WHERE id="+id;
								System.out.println(sql);
								
					        	
								 st = conexion.createStatement();
						         st.executeUpdate(sql);
						         
					        	JOptionPane.showMessageDialog(null, "Datos Modificados Correctamente ");

					        }catch(Exception e1) {
					        	JOptionPane.showMessageDialog(null, "Error Favor de ingresar un ID de tipo entero (INT) donde se solicite ID ó que existan ");

					        }
					      
				
			}});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre_m = new javax.swing.JTextField();
        med = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        list_med = new javax.swing.JComboBox<>();
        list_veterinario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre_vet = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telefono_vet = new javax.swing.JTextField();
        comboboxx2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        subir_vet = new javax.swing.JButton();
        nuevo_vet = new javax.swing.JButton();
        cerrar_vet = new javax.swing.JButton();

        
        
   //     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jLabel1.setVisible(false);
        nombre_m.setVisible(false);
        med.setVisible(false);
        jLabel3.setVisible(false);
        list_med.setVisible(false);
        list_veterinario.setVisible(false);
        jLabel7.setVisible(false); // NOI18N
        comboboxx2.setVisible(false);
        subir_vet.setVisible(false);

        ///aqui esta un combo box dieguita la jotita///////////////////////////////
        
        //titulo
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Registro Veterinario");
        
        //Nombre veterinario
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Nombre veterinario: ");
        nombre_vet.setFont(new java.awt.Font("Arial", 0, 12));
        
        //telefono veterinarios
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Numero telefonico: ");
        telefono_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        
        //boton de guardar
        nuevo_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevo_vet.setText("Guardar Vet");
        nuevo_vet.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				subir_vet(e);
			}
        	
        	
        	
        });
        cerrar_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cerrar_vet.setText("Cerrar");
        cerrar_vet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_vetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevo_vet)
                        .addComponent(cerrar_vet)
                        .addGap(43, 43, 43)
                        .addComponent(subir_vet))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                        .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre_vet, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4))
                            .addComponent(telefono_vet)
                .addComponent(comboboxx2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(med)
                                    .addComponent(jLabel3))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(list_med, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombre_m)
                                    .addComponent(list_veterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        ))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_vet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(med)
                            .addComponent(list_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telefono_vet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                       
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                		.addComponent(jLabel7)
                                .addComponent(comboboxx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )))
                          

                .addGap(19, 19, 19))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(list_veterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subir_vet)
                    .addComponent(nuevo_vet)
                    .addComponent(cerrar_vet))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrar_vetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_vetActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }
    
    private void subir_vet(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_dueñoActionPerformed
        // TODO add your handling code here:
        Statement st;
        conexion con = new conexion();
        Connection conexion = con.conectar();
                //select * from tipo where nombre_tipo = 'pupi'
                medicinas_r m= new medicinas_r();
                
                String sql = "insert into veterinario(nombre_vet,telefono) values "
                        +  "('"+nombre_vet.getText()+"','"+telefono_vet.getText()+"')";
                	//	"("+nombre_vet.getText()+","+telefono_vet.getText()+")";
                System.out.println(sql);
        try{
            st = conexion.createStatement();
            st.executeUpdate(sql);
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error " +e.toString());
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(null, "Registro exitoso");
        main os = new main();
        os.mostrar("mascotas_r");
    }
    
    
    
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Veterinarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Veterinarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cerrar_vet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JComboBox<String> list_med;
    public javax.swing.JComboBox<String> list_veterinario;
    private javax.swing.JLabel med;
    public javax.swing.JTextField nombre_m;
    public javax.swing.JTextField nombre_vet;
    public javax.swing.JButton nuevo_vet;
    public javax.swing.JButton subir_vet;
    public javax.swing.JTextField telefono_vet;
    public javax.swing.JComboBox<String> comboboxx2;
    // End of variables declaration//GEN-END:variables
}
