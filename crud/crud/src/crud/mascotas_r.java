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
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

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
        conecta.llenaCombo("medicinas", "nombre_medicina", list_dueño);
        conecta.llenaCombo("veterinario", "nombre_vet", list_veterinario);
        conecta.llenaCombo("dueño", "nombre_dueño", list_med);
        conecta.llenaCombo("medicinas", "nombre_medicina", list_med2);
        conecta.llenaCombo("medicinas", "nombre_medicina", list_med3);
    }
    
    public void actualizarDatos() {
    	JFrame f= new JFrame();
    	f.getContentPane().setLayout(null);
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
    	f.getContentPane().add(ss);
    	
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
				
				 try {
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
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
	 
	  try {
		conexion.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
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
        list_med2 = new javax.swing.JComboBox<>();
        list_med3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        subir_vet = new javax.swing.JButton();
        nuevo_vet = new javax.swing.JButton();
        cerrar_vet = new javax.swing.JButton();

        
        
   //     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");

        nombre_m.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
       nombre_m.setText(" ");
        med.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        med.setText("Dueño");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Veterinario");

        list_med.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un dueño" }));

        list_veterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione veterinario" }));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Registro Mascotas");

        

        ///aqui esta un combo box dieguita la jotita///////////////////////////////
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Medicina 2(opcional)");
        list_med2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        ///aqui esta un combo box dieguita la jotita/////////////////////////////
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Medicina3(opcional)");
        list_med3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Medicina(Obligatoria)");
        
        list_dueño.setFont(new java.awt.Font("Arial", 0, 12));
        list_dueño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        
        list_med2.setFont(new java.awt.Font("Arial", 0, 12));
        list_med2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        list_med3.setFont(new java.awt.Font("Arial", 0, 12));
        list_med3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        
        
       /////////////////////////////////////////////////////////////////////////////
       
        
        subir_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subir_vet.setText("Guardar Mascota");
        subir_vet.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String medicina =list_dueño.getSelectedItem().toString();
				String nom=nombre_m.getText();
				String due=list_med.getSelectedItem().toString();
				String vete =list_veterinario.getSelectedItem().toString();
				if (nom.equals(" ")) {
					
					JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
				}else if (medicina.equals(" ")) {
					JOptionPane.showMessageDialog(null, "Medicina no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
					
				}else if(due.equals("Seleccione un dueño")){
					
					JOptionPane.showMessageDialog(null, "El dueño no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
				}else if(vete.equals("Seleccione veterinario")) {
					
					JOptionPane.showMessageDialog(null, "El veterinario no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					
					try {
						validarNombres(nom);
						
							subir_Mascota(e);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString(), "ERROR", JOptionPane.WARNING_MESSAGE);
					}
				}
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
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(52)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(subir_vet)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel6)
        						.addComponent(jLabel5)
        						.addComponent(jLabel7))
        					.addGap(36)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(list_med2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(list_med3, 0, 150, Short.MAX_VALUE)
        						.addComponent(list_dueño, 0, 150, Short.MAX_VALUE)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(32)
        							.addComponent(jLabel4)))))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(61)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel3)
        						.addComponent(med))
        					.addGap(36)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(list_med, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(list_veterinario, Alignment.LEADING, 0, 140, Short.MAX_VALUE)
        						.addComponent(nombre_m, Alignment.LEADING)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(35)
        					.addComponent(cerrar_vet)))
        			.addContainerGap(50, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(316, Short.MAX_VALUE)
        			.addComponent(jLabel2)
        			.addGap(268))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel4)
        				.addComponent(jLabel2))
        			.addGap(37)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(nombre_m, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(list_dueño, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5))
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(list_med2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(med)
        				.addComponent(list_med, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(list_med3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3)
        				.addComponent(list_veterinario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(62)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(subir_vet)
        				.addComponent(cerrar_vet))
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

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
                Object med2=list_med2.getSelectedItem();
                Object med3 =list_med3.getSelectedItem();
                
                String sql = "insert into mascotas(nombre,medicina_1,nombre_vet,nombre_dueño,medicina_2,medicina_3) values "
                        + "('"+nombre_m.getText()+"','"+due+"','"+vet +"','"+med+"','"+med2+"','"+med3+"')";
                System.out.println(sql);
        try{
        	if(due.toString().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Medicina no puede estar vacio");

        	}else{
        	st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        	}
        }catch(SQLException e)
        {
        	 JOptionPane.showMessageDialog(null, "Falta informacion");
            JOptionPane.showMessageDialog(null, "Error " +e.toString());
        }
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

    public static void validarNombres(String nombres) throws Exception {
        if (!nombres.matches("^[A-Za-z ]+$")) {
            throw new Exception("Nombre invalido.");
        }}
    
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
    public javax.swing.JComboBox<String> list_med2;
    public javax.swing.JComboBox<String> list_med3;
    // End of variables declaration//GEN-END:variables
}
