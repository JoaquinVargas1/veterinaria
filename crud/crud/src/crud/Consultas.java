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
import javax.swing.JComboBox;

public class Consultas extends javax.swing.JFrame {

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
	JComboBox Dia = new JComboBox();
    JComboBox Mes = new JComboBox();
    JComboBox Año = new JComboBox();
    JComboBox Hora = new JComboBox();
    JComboBox Minutos = new JComboBox();

    public Consultas() {
        initComponents();
        conexion conecta=new conexion();
        conecta.llenaCombo("mascotas", "nombre", Mascota);
        conecta.llenaCombo("veterinario", "nombre_vet", Veterinario);
        conecta.llenaCombo("medicinas", "nombre_medicina", Medicina);
        conecta.llenaCombo("medicinas", "nombre_medicina", MedicinaOpcional);
        conecta.llenaCombo("medicinas", "nombre_medicina", MedicinaOpcional2);
        
        
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
        Medicina = new javax.swing.JComboBox<>();
        med = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        subir_vet = new javax.swing.JButton();
        nuevo_vet = new javax.swing.JButton();
        cerrar_vet = new javax.swing.JButton();
        
        
   //     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Titulo
        jLabel2.setFont(new Font("Arial", Font.BOLD, 16)); // NOI18N
        jLabel2.setText("Consultas");
        
        //Fecha
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Fecha: ");
       
       
        for (int i = 1; i <= 31; i++) {
            Dia.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            Mes.addItem(i);
        }
        for (int i = 2023; i <=2035 ; i++) {
            Año.addItem(i);
        }
        
        //Hora
        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Hora: ");
       
        
        for (int i = 1; i <= 24; i++) {
            Hora.addItem(i);
        }
        
        for (int i = 0; i <= 60; i+=15) {
            Minutos.addItem(i);
        }
        
        
        
        //Medicina
        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Medicina:");
        Medicina.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Medicina.setFont(new java.awt.Font("Arial", 0, 12));
        Medicina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        
        med.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        med.setText("Medicina (Opcional):");
        JLabel lblNewLabel = new JLabel("Medicina (Opcional):");
        lblNewLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        
        MedicinaOpcional = new JComboBox();
        MedicinaOpcional2 = new JComboBox();
        
        MedicinaOpcional.setFont(new java.awt.Font("Arial", 0, 12));
        MedicinaOpcional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        MedicinaOpcional2.setFont(new java.awt.Font("Arial", 0, 12));
        MedicinaOpcional2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        
        //Veterinario
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Veterinario:");
        Veterinario = new JComboBox();
        Veterinario.setFont(new java.awt.Font("Arial", 0, 12));
        Veterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
        
        //Mascota
        lblNewLabel_1 = new JLabel("Mascota:");
        Mascota = new JComboBox();
        Mascota.setFont(new java.awt.Font("Arial", 0, 12));
        Mascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " "}));
       /////////////////////////////////////////////////////////////////////////////
       
        
        subir_vet.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        subir_vet.setText("Guardar");
     
        subir_vet.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				subir_consulta(e);
				
				
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
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(52)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(jLabel7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(Hora, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(Dia, 0, 44, Short.MAX_VALUE))
        							.addGap(2)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(32)
        									.addComponent(jLabel4))
        								.addGroup(layout.createSequentialGroup()
        									.addGap(4)
        									.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        										.addComponent(Minutos, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(Mes, Alignment.LEADING, 0, 44, Short.MAX_VALUE))
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(Año, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(Veterinario, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(subir_vet, Alignment.TRAILING)
        						.addComponent(Mascota, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(32)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(med)
        								.addComponent(lblNewLabel))
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(MedicinaOpcional, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(MedicinaOpcional2, 0, 140, Short.MAX_VALUE)
        								.addComponent(Medicina, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        						.addComponent(cerrar_vet)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(264)
        					.addComponent(jLabel2)))
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel4)
        				.addComponent(jLabel2))
        			.addGap(29)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(Dia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Mes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Año, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1)
        				.addComponent(Medicina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(Hora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addComponent(Minutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jLabel6)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(MedicinaOpcional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(med))))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(13)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel7)
        						.addComponent(Veterinario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(MedicinaOpcional2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(Mascota, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(lblNewLabel)))
        			.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(cerrar_vet)
        				.addComponent(subir_vet))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        
        
    }// </editor-fold>//GEN-END:initComponents

    private void cerrar_vetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_vetActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }
    
    private void subir_consulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_dueñoActionPerformed
        // TODO add your handling code here:
        Statement st;
        conexion con = new conexion();
        Connection conexion = con.conectar();
                //select * from tipo where nombre_tipo = 'pupi'
   //             medicinas_r m= new medicinas_r();
                Object med = Medicina.getSelectedItem();
                Object med2 = MedicinaOpcional.getSelectedItem();
                Object med3 = MedicinaOpcional2.getSelectedItem();
                String hor	= Hora.getSelectedItem().toString();
                String min = Minutos.getSelectedItem().toString();
                String dia = Dia.getSelectedItem().toString();
                String mes	= Mes.getSelectedItem().toString();
                String año = Año.getSelectedItem().toString();
                Object mas	= Mascota.getSelectedItem();
                Object vet = Veterinario.getSelectedItem();
                String fecha=año+"-"+mes+"-"+dia;
                String horario= hor+":"+min+":00";
                
                String sql ="insert into consultas(fecha,hora,mascota,veterinario,medicina_1,medicina_2,medicina_3) values "
                        + "('"+fecha+"','"+horario +"','"+mas+"','"+vet +"','"+med+"','"+med2+"','"+med3+"')";
                System.out.println(sql);
        try{
        	
             

        	
        	st = conexion.createStatement();
        	
        	
        	
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        	
        }catch(SQLException e)
        {
        	// JOptionPane.showMessageDialog(null, "Falta informacion");
            JOptionPane.showMessageDialog(null, "Error " +e.toString());
        }
        main os = new main();
        os.mostrar("Consultas");
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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
        
    }
        // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cerrar_vet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel med;
    public javax.swing.JComboBox<String> Medicina;
    public javax.swing.JButton nuevo_vet;
    public javax.swing.JButton subir_vet;
    private JComboBox Veterinario;
    private JLabel lblNewLabel_1;
    private JComboBox Mascota;
    private JComboBox MedicinaOpcional2;
    private JComboBox MedicinaOpcional;
}
