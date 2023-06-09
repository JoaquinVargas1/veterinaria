package crud;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class mascotas_r extends javax.swing.JFrame {

    /**
     * Creates new form mascotas_r
     * 
     * 
     */
	JTextField idMascotaBuscar = new JTextField();
	JTextField newNombreMascota = new JTextField();
	JTextField newNombreVeterinario = new JTextField();
	JTextField newNombreDueno = new JTextField();
	JTextField newNombreMedicina1 = new JTextField();
	JTextField newNombreMedicina2 = new JTextField();
	JTextField newNombreMedicina3 = new JTextField();






    public mascotas_r() {
        initComponents();
        conexion conecta=new conexion();
        conecta.llenaCombo("medicinas", "nombre_medicina", list_med);
        conecta.llenaCombo("veterinario", "nombre_vet", list_veterinario);
        conecta.llenaCombo("dueño", "nombre_dueño", list_dueño);
    
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

    	JLabel idMascota = new JLabel("Mascota a Modificar su ID: ");
    	idMascota.setSize(300,30);
    	idMascota.setLocation(10,50);
    	ss.add(idMascota);
    	
    	
    	idMascotaBuscar.setSize(150,30);
    	idMascotaBuscar.setLocation(150,50);
    	ss.add(idMascotaBuscar);
    	
    	JButton btnBuscar = new JButton("buscar");
    	btnBuscar.setLocation(150,80);
    	btnBuscar.setSize(100,30);
    	btnBuscar.setVisible(true);
    	ss.add(btnBuscar);
    
    	btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
					ponerDatos(idMascotaBuscar.getText());
				
			}
    		
    	});
    	
    	JLabel nombreMascota = new JLabel("Nombre de Mascota: ");
    	nombreMascota.setSize(150,30);
    	nombreMascota.setLocation(10,120);
    	ss.add(nombreMascota);
    	
    	
    	newNombreMascota.setSize(150,30);
    	newNombreMascota.setLocation(130,120);
    	ss.add(newNombreMascota);
    	
    	
    	
    	JLabel nombreMedicina1 = new JLabel("Medicina 1 ");
    	nombreMedicina1.setSize(150,30);
    	nombreMedicina1.setLocation(10,160);
    	ss.add(nombreMedicina1);
    	
    	
    	newNombreMedicina1.setSize(150,30);
    	newNombreMedicina1.setLocation(120,160);
    	ss.add(newNombreMedicina1);
    	
    	JLabel nombreMedicina2 = new JLabel("Medicina 2 ");
    	nombreMedicina2.setSize(150,30);
    	nombreMedicina2.setLocation(10,190);
    	ss.add(nombreMedicina2);
    	
    	
    	newNombreMedicina2.setSize(150,30);
    	newNombreMedicina2.setLocation(120,190);
    	ss.add(newNombreMedicina2);
    	
    	JLabel nombreMedicina3 = new JLabel("Medicina 3 ");
    	nombreMedicina3.setSize(150,30);
    	nombreMedicina3.setLocation(10,220);
    	ss.add(nombreMedicina3);
    	
    	
    	newNombreMedicina3.setSize(150,30);
    	newNombreMedicina3.setLocation(120,220);
    	ss.add(newNombreMedicina3);
    	
    	
    	
    	JLabel nombreVeterinario = new JLabel("Nombre del Veterinario ");
    	nombreVeterinario.setSize(150,30);
    	nombreVeterinario.setLocation(10,250);
    	ss.add(nombreVeterinario);
    	
    	
    	newNombreVeterinario.setSize(150,30);
    	newNombreVeterinario.setLocation(150,250);
    	ss.add(newNombreVeterinario);
    	
    	JLabel nombreDueno = new JLabel("Nombre del Dueño ");
    	nombreDueno.setSize(150,30);
    	nombreDueno.setLocation(10,290);
    	ss.add(nombreDueno);
    	
    	
    	newNombreDueno.setSize(150,30);
    	newNombreDueno.setLocation(150,290);
    	ss.add(newNombreDueno);

    	
    	
    	
    	
    	
    	JButton s = new JButton("Actualizar");
    	s.setLocation(180,320);
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
					             
					       
					        
					        try {
					       
					        	if(newNombreMedicina1.getText().equals(null) || newNombreMedicina1.getText().equals("")) {
						        	JOptionPane.showMessageDialog(null, "Medicina 1 no puede estar vacio");

					        	}else {
					        		String sql= "UPDATE mascotas SET nombre = '"+newNombreMascota.getText()+"', medicina_1 = '"+
					        				newNombreMedicina1.getText()+"', nombre_vet = '"+newNombreVeterinario.getText()+"', nombre_dueño = '"+newNombreDueno.getText()
							        		+"', medicina_2 = '"+newNombreMedicina2.getText()+"', medicina_3 = '"+newNombreMedicina3.getText()+"' WHERE id="+idMascotaBuscar.getText();
									System.out.println(sql);
									
						        	
									 st = conexion.createStatement();
							         st.executeUpdate(sql);
							         
						        	JOptionPane.showMessageDialog(null, "Datos Modificados Correctamente ");
					        	}
					        		
					        		
					        	

					        }catch(Exception e1) {
					        	JOptionPane.showMessageDialog(null, "Error Favor de ingresar un ID de tipo entero (INT) donde se solicite ID ó que existan ");

					        }
					      
				
			}});
    }

    
    
 public void ponerDatos(Object id) {
    	
    	
    	Statement st = null;
        conexion con = new conexion();
        Connection conexion = con.conectar();
        
		  try{
			  

         	 String sql= "SELECT id,nombre,nombre_vet,nombre_dueño,medicina_1,medicina_2,medicina_3 FROM mascotas WHERE id="+id;
			//	System.out.println(sql);
				
	            st = conexion.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	  
	            while(rs.next()){
		           
	       
	            
	            	idMascotaBuscar.setText(rs.getString(1));
	            	newNombreMascota.setText(rs.getString(2));
	            	newNombreVeterinario.setText(rs.getString(3));
	            	newNombreDueno.setText(rs.getString(4));
	            	newNombreMedicina1.setText(rs.getString(5));
	            	newNombreMedicina2.setText(rs.getString(6));
	                newNombreMedicina3.setText(rs.getString(7));
	                

	           
	 	  
	            	
	            }
	        }catch(SQLException e)
	        {
	        	JOptionPane.showMessageDialog(null, "ID no Valido, por favor ingresa uno valido");

	           // e.printStackTrace();
	        }
   
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
        list_dueño = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboboxx = new javax.swing.JComboBox<>();
        comboboxx2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        subir_vet = new javax.swing.JButton();
        nuevo_vet = new javax.swing.JButton();
        cerrar_vet = new javax.swing.JButton();

        
        
   //     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");

        nombre_m.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        med.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        med.setText("Medicina");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Veterinario");

        list_med.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una medicina" }));

        list_veterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione veterinario" }));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Registro Mascotas");

        

        ///aqui esta un combo box dieguita la jotita///////////////////////////////
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Comboboxss");
        comboboxx.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        ///aqui esta un combo box dieguita la jotita/////////////////////////////
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Comboboxss2");
        comboboxx2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Dueño");
        
        list_dueño.setFont(new java.awt.Font("Arial", 0, 12));
        list_dueño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un dueño" }));
        
       /////////////////////////////////////////////////////////////////////////////
       
        
        subir_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subir_vet.setText("Guardar Mascota");
        subir_vet.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				subir_Mascota(e);
				
				
			}
        	
       	
        });

        /*nuevo_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nuevo_vet.setText("Guardar Vet");
        nuevo_vet.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				subir_vet(e);
			}
        	
        	
        	
        });*/

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
                       // .addComponent(nuevo_vet)
                        //.addGap(43, 43, 43)
                        .addComponent(subir_vet))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                        .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(list_dueño, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4))
                            .addComponent(comboboxx)
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
                        .addComponent(cerrar_vet)))
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
                    .addComponent(list_dueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(comboboxx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                       
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
                    //.addComponent(nuevo_vet)
                    .addComponent(cerrar_vet))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrar_vetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_vetActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }
    
    
    
    
    
    private void subir_Mascota(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_dueñoActionPerformed
        // TODO add your handling code here:
        Statement st;
        conexion con = new conexion();
        Connection conexion = con.conectar();
                //select * from tipo where nombre_tipo = 'pupi'
   //             medicinas_r m= new medicinas_r();
                Object med = list_med.getSelectedItem();
                Object vet =list_veterinario.getSelectedItem();
                Object due =list_dueño.getSelectedItem();
                String sql = "insert into mascotas(nombre,nombre_medicina,nombre_vet,nombre_dueño) values "
                        + "('"+nombre_m.getText()+"','"+med+"','"+vet +"','"+due+"')";
                System.out.println(sql);
        try{
            st = conexion.createStatement();
            st.executeUpdate(sql);
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error " +e.toString());
        }
        JOptionPane.showMessageDialog(null, "Registro exitoso");
        main os = new main();
        os.mostrar("mascotas_r");
    }
    
    /*private void subir_vet(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_dueñoActionPerformed
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
    }*/
    
    
    
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mascotas_r.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mascotas_r.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mascotas_r.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mascotas_r.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mascotas_r().setVisible(true);
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
    public javax.swing.JComboBox<String> list_dueño;
    public javax.swing.JButton nuevo_vet;
    public javax.swing.JButton subir_vet;
    public javax.swing.JComboBox<String> comboboxx;
    public javax.swing.JComboBox<String> comboboxx2;
    // End of variables declaration//GEN-END:variables
}
