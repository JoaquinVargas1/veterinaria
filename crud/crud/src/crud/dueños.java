package crud;

import com.mysql.jdbc.Connection;

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
import javax.swing.table.DefaultTableModel;


public class dueños extends javax.swing.JFrame {
	JTextField newNombreDueno = new JTextField();
	JTextField telefonoText = new JTextField();
	JTextField direccionText = new JTextField();
	JTextField idDuenoBuscar = new JTextField();


    public dueños() {
        initComponents();
        conexion conecta= new conexion();
      //  conecta.llenaCombo("mascotas", "id", lista_mascota);
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
    	
    	JLabel actualizarDatos = new JLabel("Actualizar Datos Dueño");
    	actualizarDatos.setSize(500,30);
    	actualizarDatos.setLocation(80,5);
    	actualizarDatos.setFont(new Font("Arial",Font.BOLD,20));

    	ss.add(actualizarDatos);
    	
    	
    	JLabel idDueno = new JLabel("ID del dueño a modificar:  ");
    	idDueno.setSize(250,30);
    	idDueno.setLocation(10,50);
    	ss.add(idDueno);
    	
    	
    	idDuenoBuscar.setSize(150,30);
    	idDuenoBuscar.setLocation(150,50);
    	ss.add(idDuenoBuscar);
    	
    	JLabel nombreDueno = new JLabel("Nombre de Dueño: ");

    	nombreDueno.setSize(140,30);
    	nombreDueno.setLocation(10,110);
    	ss.add(nombreDueno);
    	
    	
    	
    	newNombreDueno.setSize(150,30);
    	newNombreDueno.setLocation(120,110);
    	ss.add(newNombreDueno);
    	
    	JLabel telefonoLabel = new JLabel("Telefono: ");
    	telefonoLabel.setSize(150,30);
    	telefonoLabel.setLocation(10,150);
    	ss.add(telefonoLabel);
    	
    	telefonoText.setSize(150,30);
    	telefonoText.setLocation(120,150);
    	ss.add(telefonoText);
    	

    	JLabel direccionLabel = new JLabel("Direccion: ");
    	direccionLabel.setSize(150,30);
    	direccionLabel.setLocation(10,200);
    	ss.add(direccionLabel);
    	
    	
    	direccionText.setSize(150,30);
    	direccionText.setLocation(120,200);
    	ss.add(direccionText);
    
    	
    	

    	JButton btnBuscar = new JButton("buscar");
    	btnBuscar.setLocation(150,80);
    	btnBuscar.setSize(100,30);
    	btnBuscar.setVisible(true);
    	ss.add(btnBuscar);
    
    	btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
					
				
					ponerDatos(idDuenoBuscar.getText());
				
			}
    		
    	});
    	
    	JButton s = new JButton("Actualizar");
    	s.setLocation(180,260);
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
							        

							        String sql= "UPDATE dueño SET nombre_dueño = '"+newNombreDueno.getText()+"', telefono = '"+telefonoText.getText()+"', direccion = '"+
							        		direccionText.getText()+"' WHERE id_dueño = "+idDuenoBuscar.getText();
									System.out.println(sql);
									
									st = conexion.createStatement();
						            st.executeUpdate(sql);
						            
						        	JOptionPane.showMessageDialog(null, "Datos Modificados Correctamente ");

						        }catch(Exception e1) {
						        	JOptionPane.showMessageDialog(null, "Error Favor de ingresar un ID de mascota de tipo entero (INT) al igual que en ID ó que existan ");
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
			  

         	 String sql= "SELECT id_dueño,nombre_dueño,telefono,direccion FROM dueño WHERE id_dueño="+id;
			//	System.out.println(sql);
				
	            st = conexion.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	  
	            while(rs.next()){
		           
	       
	            	idDuenoBuscar.setText(rs.getString(1));
	 	            newNombreDueno.setText(rs.getString(2));
	 	            telefonoText.setText(rs.getString(3));
	 	           direccionText.setText(rs.getString(4));

	 	  
	            	
	            }
	        }catch(SQLException e)
	        {
	        	JOptionPane.showMessageDialog(null, "ID no Valido, por favor ingresa uno valido");

	          e.printStackTrace();
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

        nombre_d = new javax.swing.JTextField();
        label_na = new javax.swing.JLabel();
        telefono_d = new javax.swing.JTextField();
        label_na1 = new javax.swing.JLabel();
        label_na2 = new javax.swing.JLabel();
        direccion_d = new javax.swing.JTextField();
        label_na3 = new javax.swing.JLabel();
        lista_mascota = new javax.swing.JComboBox<>();
        link = new javax.swing.JLabel();
        subir_dueño = new javax.swing.JButton();  
        cerrar_d = new javax.swing.JButton();

        
        label_na3.setVisible(false);
        lista_mascota.setVisible(false);
        
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre_d.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombre_d.setText(" ");
        nombre_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_dActionPerformed(evt);
            }
        });

        label_na.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label_na.setText("Nombre");
        
        
        telefono_d.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        telefono_d.setText("");
        telefono_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefono_dActionPerformed(evt);
            }
        });

        label_na1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label_na1.setText("Teléfono");

        label_na2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label_na2.setText("Dirección");

        direccion_d.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        direccion_d.setText(" ");
        
        direccion_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccion_dActionPerformed(evt);
            }
        });

  

        link.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        link.setText("Registro de dueños");
        link.setToolTipText("");

        subir_dueño.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subir_dueño.setText("Guardar");
        subir_dueño.addActionListener(new java.awt.event.ActionListener() {
           
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
               String tel = telefono_d.getText();
               String nomd=nombre_d.getText();
               String direc=direccion_d.getText();
               int cant = tel.length();
        	
            //   System.out.println(cant);
               
        		if(nomd.equals(" ")) {
        			
        			JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);

        		}else if(tel.equals("")) {
        			JOptionPane.showMessageDialog(null, "El Telefono no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
        			
        		}else if(direc.equals(" ")) {
        			JOptionPane.showMessageDialog(null, "La direccion  no puede estar vacio", "ERROR", JOptionPane.WARNING_MESSAGE);
        			
        		}
        		
        		
        		else  {
        		
        			
        		if(cant<=10 ) {
        	
        			
        				try {
        					validarNombres(nomd);
        					validarTel(tel);
							subir_dueñoActionPerformed(evt);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e.toString(), "ERROR", JOptionPane.WARNING_MESSAGE);
						}
        			
					
        		
        		
        		}else {
        			JOptionPane.showMessageDialog(null, "Demasiados caracteres en numero el numero de telefono, revise el numero y vuelva a intertarlo", "ERROR", JOptionPane.WARNING_MESSAGE);
        		}
        		
        		}
        	
        	
        	}
        });

        cerrar_d.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cerrar_d.setText("Cerrar");
        cerrar_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_dActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_na2)
                                        .addComponent(label_na3))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(direccion_d)
                                        .addComponent(lista_mascota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(label_na1)
                                            .addGap(52, 52, 52))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label_na)
                                            .addGap(37, 37, 37)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nombre_d)
                                        .addComponent(telefono_d, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(link)
                                .addGap(92, 92, 92)))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subir_dueño)
                        .addGap(30, 30, 30)
                        .addComponent(cerrar_d)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(link)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_d, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_na))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono_d, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_na1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion_d, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_na2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_na3)
                    .addComponent(lista_mascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subir_dueño)
                    .addComponent(cerrar_d))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombre_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_dActionPerformed

    private void telefono_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefono_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefono_dActionPerformed

    private void direccion_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccion_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccion_dActionPerformed

    private void cerrar_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_dActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cerrar_dActionPerformed

    private void subir_dueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_dueñoActionPerformed
        // TODO add your handling code here:
        Statement st;
        conexion con = new conexion();
        Connection conexion = con.conectar();
                //select * from tipo where nombre_tipo = 'pupi'
        
                
                String sql = "insert into dueño(nombre_dueño,telefono,direccion) values "
                        + "('"+nombre_d.getText()+"','"+telefono_d.getText()+"','"+direccion_d.getText()+"')";
                System.out.println(sql);
               // System.out.println("consulta hecha");
        try{
            st = conexion.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error " +e.toString());
        }
       // JOptionPane.showMessageDialog(null, "Borrado de la base de datos");
        main os = new main();
        os.mostrar("dueños");
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
            java.util.logging.Logger.getLogger(dueños.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dueños.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dueños.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dueños.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dueños().setVisible(true);
            }
        });
    }
    
    public static void validarTel(String telefono) throws Exception {
        if (!telefono.matches("^[0-9]+$")) {
            throw new Exception("El numero de telefono  no es válido.");
        }
    }

    public static void validarNombres(String nombres) throws Exception {
        if (!nombres.matches("^[A-Za-z ]+$")) {
            throw new Exception("Nombre invalido.");
        }
    }


    public javax.swing.JButton cerrar_d;
    public javax.swing.JTextField direccion_d;
    private javax.swing.JLabel label_na;
    private javax.swing.JLabel label_na1;
    private javax.swing.JLabel label_na2;
    private javax.swing.JLabel label_na3;
    private javax.swing.JLabel link;
    public javax.swing.JComboBox<String> lista_mascota;
    public javax.swing.JTextField nombre_d;
    public javax.swing.JButton nuevo_d;
    public javax.swing.JButton subir_dueño;
    public javax.swing.JTextField telefono_d;
  
}

