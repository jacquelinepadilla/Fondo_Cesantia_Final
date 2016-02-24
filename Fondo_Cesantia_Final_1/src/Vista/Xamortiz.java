
package Vista;

import Controlador.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.text.NumberFormat;

public class Xamortiz extends JApplet{
  double c = 0;      // Capital total del préstamo 
     //double i = 0; // interés anual en % 
  double i = 0;
     double i1 = 0;     //    "      "   en tanto por uno
     double p = 0;      // número de años de amortización
     double cuota = 0;  // cuota a pagar para amortizar el préstamo
                        // en esas condiciones
     double npago = 0;  // número del pago seleccionado para ver el 
                        // estado del préstamo   
     int    tipopago = 1;
     int    OTRO = 1;                               

    private NumberFormat integerFormatter;          


    boolean isStandalone = false;

    JButton B_calcular = new JButton();  // botón que calcula la cuota
    JButton B_limpiar  = new JButton();  //   " que limpia todo
    JButton B_ejemplo  = new JButton();  // botón que muestra un ejemplo
                                         // C = 1.000.000 ptas
                                         // i = 8 %
                                         // n = 4 años   
    

        // campos de texto
    JTextField capital  = new JTextField();
    JTextField interes  = new JTextField();
    JTextField años     = new JTextField();
    JTextField alfa     = new JTextField();
    JTextField pago     = new JTextField();
    JTextField cuantos  = new JTextField();
    
    
        // Etiquetas
    JLabel E_entrada       = new JLabel();
    JLabel E_entrada2      = new JLabel();
    JLabel E_salida        = new JLabel();
    JLabel E_msj           = new JLabel();
    JLabel E_capital       = new JLabel();
    JLabel E_interes       = new JLabel();
    JLabel E_pagos         = new JLabel();
    JLabel E_cuota         = new JLabel();
    JLabel E_valores       = new JLabel();
    JLabel E_linea         = new JLabel();
    JLabel E_cuantos       = new JLabel();
    
  /* Botones de tipo radio
   */
    JRadioButton RB_anual     = new JRadioButton();
    JRadioButton RB_semestral = new JRadioButton();
    JRadioButton RB_mensual   = new JRadioButton();
    JRadioButton RB_personal  = new JRadioButton();

        // Paneles
    JPanel P_principal = new JPanel();
    JPanel P_salida    = new JPanel();
    JPanel P_entrada   = new JPanel();
    JPanel P_botones   = new JPanel();
    JPanel P_mensajes  = new JPanel();
    JPanel P_valor     = new JPanel();
    JPanel P_entrada2  = new JPanel();
    JPanel P_tipo      = new JPanel();
   
    List  lista = new List();   
  
    // Obtiene el valor de un parámetro
    public String getParameter(String key, String def) {
        return isStandalone ? 
                  System.getProperty(key, def) :
                  (getParameter(key) != null ? 
                          getParameter(key) : def);
    }

    // Construye el applet 
    public Xamortiz() {
    }
  
    // Inicia el applet
    public void init() {
       try {
            IniciaComponentes();
        }
            catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    // Inicialización de componentes
    private void IniciaComponentes() throws Exception {

        // Botón para el cálculo de las raices de la ecuación
        B_calcular.setToolTipText(
                 "Calcula la cuota a pagar del préstamo.");
        B_calcular.setText("Calcular");
        B_calcular.setMnemonic(KeyEvent.VK_C);
        B_calcular.setActionCommand("Calcular");
        B_calcular.addActionListener(new 
                            java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                B_calcular_actionPerformed(e);
            }
        });

        // Botón para limpiar los coeficientes y resultados
        B_limpiar.setToolTipText(
                "Limpia toda la pantalla");
        B_limpiar.setText("Limpiar");
        B_limpiar.setMnemonic(KeyEvent.VK_L);
        B_limpiar.setActionCommand("Limpiar");
        B_limpiar.addActionListener(new 
                            java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                B_limpiar_actionPerformed(e);
            }
        });

        // Botón para mostrar un ejemplo del cálculo
        B_ejemplo.setToolTipText(
                "Demostración para valores preestablecidos");
        B_ejemplo.setText("Ejemplo");
        B_ejemplo.setMnemonic(KeyEvent.VK_E);
        B_ejemplo.setActionCommand("Ejemplo");
        B_ejemplo.addActionListener(new 
                            java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                B_ejemplo_actionPerformed(e);
            }
        });

        // Etiqueta para el campo de introducción de números
        E_entrada.setText("     Introduzca los datos del");
        E_entrada2.setText(" préstamo:");
        E_capital.setText("           Capital =");
        E_interes.setText("           Interés =");
        E_pagos.setText("           Nº años =");
        E_cuota.setText("             Cuota =");
        E_valores.setText("");
        E_msj.setText("");
        E_linea.setText("-------------------------------------------------------------------");
        E_cuantos.setText("¿Cuantos pagos al año? ");
        
        // Configura los botones de radio
        RB_anual.setText(" Anual");
        RB_semestral.setText(" Semestral");
        RB_mensual.setText(" Mensual");
        RB_personal.setText(" Personal");
        // valores iniciales
        tipopago=1;
        RB_anual.setSelected(true);
        
        RB_anual.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               tipopago=1;
               RB_anual.setSelected(true);
               RB_semestral.setSelected(false);
               RB_mensual.setSelected(false);
               RB_personal.setSelected(false);
               cuantos.setVisible(false);
               E_cuantos.setVisible(false);               
            }
        });   
        
        RB_semestral.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               tipopago=2;
               RB_anual.setSelected(false);
               RB_semestral.setSelected(true);
               RB_mensual.setSelected(false);
               RB_personal.setSelected(false);
               cuantos.setVisible(false);
               E_cuantos.setVisible(false);               
            }
        });  
        
        RB_mensual.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               tipopago=3;
               RB_anual.setSelected(false);
               RB_semestral.setSelected(false);
               RB_mensual.setSelected(true);
               RB_personal.setSelected(false);
               cuantos.setVisible(false);
               E_cuantos.setVisible(false);
            }
        });        
        
        RB_personal.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               RB_anual.setSelected(false);
               RB_semestral.setSelected(false);
               RB_mensual.setSelected(false);
               RB_personal.setSelected(true);
               cuantos.setVisible(true);
               E_cuantos.setVisible(true);
               tipopago=4;
            }
        });        

        
        // Campo de texto para C
        capital.setColumns(10);
        capital.setToolTipText("Capital a amortizar...");

        // Campo de texto para i
        interes.setColumns(10);
        interes.setToolTipText("Interés anual del préstamo...");

        // Campo de texto para n
        años.setColumns(10);
        años.setToolTipText("Años de amortización...");

        // Campo de texto que escribe la cuota a pagar
        alfa.setColumns(10);
        alfa.setEditable(false);

        // Campo de texto que permite personalizar el préstamo
        // y su etiqueta
        cuantos.setColumns(10);
        cuantos.setVisible(false);
        E_cuantos.setVisible(false);

        // Configuración general 
        this.setSize(400,450);
        this.getContentPane().add(P_principal, 
                                  BorderLayout.CENTER);

        // Se colocan los paneles en el principal
        P_principal.add(P_entrada2, null);
        P_principal.add(P_valor, null);
        P_principal.add(P_botones, null);
        P_principal.add(P_salida, null);
        P_principal.add(P_mensajes, null);

        // Se establece el layout del panel principal:
        // los paneles auxiliares se colocarán formando
        // una única columna en el panel principal
	  P_principal.setLayout(new GridLayout(0, 1));

      // Agrupo los paneles de entrada, P_entrada y P_tipo
      /*  P_entrada2.add(P_entrada, null);
        P_entrada2.add(P_tipo, null);
        P_entrada2.setLayout(new GridLayout(0, 2));
      */
        P_entrada2.setLayout(new BorderLayout());
        P_entrada2.add(P_entrada, BorderLayout.CENTER);
        P_entrada2.add(P_tipo, BorderLayout.EAST);
     
	// Se colocan los elementos (etiqueta y campo de texto)
      // del panel de entrada
        P_entrada.add(E_entrada, null);
        P_entrada.add(E_entrada2, null);
        P_entrada.add(E_capital, null);
        P_entrada.add(capital, null);
        P_entrada.add(E_interes, null);
        P_entrada.add(interes, null);
        P_entrada.add(E_pagos, null);
        P_entrada.add(años, null);
        P_entrada.add(E_cuantos, null);
        P_entrada.add(cuantos, null);
        P_entrada.setLayout(new GridLayout(0, 2));
        
        // Coloco los botones de radio en P_tipo
        P_tipo.add(RB_anual, null);
        P_tipo.add(RB_semestral, null);
        P_tipo.add(RB_mensual, null);
        P_tipo.add(RB_personal, null);
        P_tipo.setLayout(new GridLayout(0, 1));
            
        // Representación del valor actual de la ecuación
        // que se va a calcular al pulsar el botón
        P_valor.add(E_linea, null);
        P_valor.add(E_valores, null);
        P_valor.add(E_msj, null);

        // Los tres botones se colocan en el panel de botones
        P_botones.add(B_calcular, null);
        P_botones.add(B_limpiar, null);
        P_botones.add(B_ejemplo, null);
        
        // El panel de salida contiene una etiqueta y un
        // campo de texto que representarán el resultado
        // del cálculo (en función del botón seleccionado)
        // sobre el valor que figure en cada momento en la
        // etiqueta de valor actual
        P_salida.add(E_cuota, null);
        P_salida.add(pago, null);
        P_salida.setLayout(new GridLayout(0, 1));
        
        // Mensajes de aclaraciones o errores 
        P_mensajes.add(lista, null);
        P_mensajes.setLayout(new GridLayout(0, 1));        
    }
  
    // Arranca (start) el applet
    public void start() {
    }
  
    // Detiene (stop) el applet
    public void stop() {
    }
  
    // Destruye (destroy) el applet
    public void destroy() {
    }
  
    // Obtiene información del applet
    public String getAppletInfo() {
        return "Applet Information";
    }
  
    // Obtiene información acerca de los parámetros
    public String[][] getParameterInfo() {
        return null;  
}

    
  public static void main(String[] args) {
        Xamortiz applet = new Xamortiz();
        applet.isStandalone = true;
        JFrame frame = new JFrame();
        frame.setTitle("Applet Frame");
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        frame.setSize(400,450);
        Dimension d = 
               Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
               (d.width - frame.getSize().width) / 2, 
               (d.height - frame.getSize().height) / 2);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e) { 
                System.exit(0); 
            } 
        });
    }
    
    void B_calcular_actionPerformed(ActionEvent e) {
     boolean correcto = true;
     double  E        = 0;
     double  inte     = 0;
     double  ani      = 0;
     double  ta, ca, ci, ra, tci;
     int     indice;
     
     double  exp=0.0;

     String n = capital.getText();
        try {
            c = Integer.parseInt(n);
        } catch(NumberFormatException nfe) {
            E_msj.setText("No es un valor correcto: '"+n+"'");
            correcto = false;
        } 
       n = interes.getText();
        try {
            i = Integer.parseInt(n);
        } catch(NumberFormatException nfe) {
            E_msj.setText("No es un valor correcto: '"+n+"'");
            correcto = false;
        } 
       n = años.getText();
        try {
            p = Integer.parseInt(n);
        } catch(NumberFormatException nfe) {
            E_msj.setText("No es un valor correcto: '"+n+"'");
            correcto = false;
        } 
        
      if (tipopago == 4)  
      { 
        n = cuantos.getText();
        try {
            OTRO = Integer.parseInt(n);
        } catch(NumberFormatException nfe) {
            E_msj.setText("No es un valor correcto: '"+n+"'");
            correcto = false;
        }
      }
        
      if (correcto == true)
      { 
        E_msj.setText("");
        E_valores.setText("Amortización de "+c+", a un interés del "+i+"%, en "+p+" años.");
        lista.addItem(" Tabla que detalla la evolución del préstamo para la ...");
        lista.addItem(" Amortización de "+c+", a un interés anual del "+i+"%, en "+p+" años.");        
        
        i1=i/100;
        //inte=i1;
        
        switch(tipopago)
          {
            case 1:
             {// Cálculo de la cuota anual. 
              // Tipo de amortización anual
              lista.addItem("Cuotas Anuales");
              p = p;
              inte = i1;
              E = 1;
              for (indice=0;indice < p;indice++)
                E = E * (1+inte);
           } break;
           
           case 2:
             {// Cálculo de la cuota semestral. 
              // Tipo de amortización semestral
              lista.addItem("Cuotas Semestrales");
              p = p*2;
              //inte = (1+i1)^(1/2)-1;
              exp = 0.5;
              inte = Math.pow((1+i1),exp)-1;
              E = 1;
              for (indice=0;indice < p;indice++)
                E = E * (1+inte);
           } break;
           
           case 3:
             {// Cálculo de la cuota mensual.
              // Tipo de amortización mensual
              lista.addItem("Cuotas Mensuales");
              p = p*12;
              //inte = (1+i1)^(1/12)-1;
              exp = 0.083;
              inte = Math.pow((1+i1),exp)-1;
              E = 1;
              for (indice=0;indice < p;indice++)
                E = E * (1+inte);
           } break;
           
           case 4:
             {// Cálculo de la cuota personal. 
              // Tipo de amortización personal
              p = p*OTRO;
              //inte = (1+i1)^(1/OTRO)-1;
              switch (OTRO)  // ESTO ES NECESARIO PORQUE NO FUNCIONA EXP=1/OTRO.             
              {
                case 1:  exp=1; break;
                case 2:  exp=0.5; break;
                case 3:  exp=0.333; break;
                case 4:  exp=0.25; break;
                case 5:  exp=0.2; break;
                case 6:  exp=0.166; break;              
                case 7:  exp=0.142; break;
                case 8:  exp=0.125; break;
                case 9:  exp=0.111; break;
                case 10: exp=0.1; break;
                case 11: exp=0.09; break;
                case 12: exp=0.083; break;
                case 13: exp=0.076; break;
                case 14: exp=0.071; break;
                case 15: exp=0.066; break;
                case 16: exp=0.0625; break;
                case 17: exp=0.058; break;
                case 18: exp=0.055; break;
                case 19: exp=0.052; break;
                case 20: exp=0.05; break;
                case 21: exp=0.047; break;
                case 22: exp=0.045; break;
                case 23: exp=0.043; break;
                case 24: exp=0.041; break;
                case 48: exp=0.0208; break;
                case 365: exp=0.0027; break;
                default: 
                        {
                        exp=0.1; 
                        cuantos.setText("10");
                        }
                        break;
              }
              //exp = 1 / OTRO;   // esto es lo ideal pero no funciona
              inte = Math.pow((1+i1),exp)-1;
              lista.addItem("     "+OTRO+" Pagos al año, en un total de "+p+" cuotas.");              

              E = 1;
              for (indice=0;indice < p;indice++)
                E = E * (1+inte);
           }
          }
                 
        ani = (E - 1)/(inte * E);  
        cuota = c / ani;
        pago.setText(""+presenta(cuota));
        
        // Construcción de la tabla de amortización que detalla
        // el estado del préstamo
        lista.addItem("Pago     Cuota     C.Interés     C.Amortiz.     Tot.Amortiz.     Resto");
        lista.addItem(" 0              ---                ---                  ---                    ---            "+presenta(c)); 
        ta=0;
        ra=c;
        tci=0;
        for (indice=0;indice < p;indice++)
            {
                ci=ra*inte;
                tci=tci+ci;
                ca=cuota-ci;
                ta=ta+ca;
                ra=c-ta;
                    
                lista.addItem(" "+(indice+1)+"      "+presenta(cuota)+"      "+presenta(ci)+"      "+presenta(ca)+"      "+presenta(ta)+"      "+presenta(ra));
            }
         lista.addItem("Total de intereses pagados = "+presenta(tci));   
         lista.addItem("");   
        
      }  
    }
    
    void B_limpiar_actionPerformed(ActionEvent e) {
        // primero limpia las variables
        c  = 0;
        i  = 0;
        i1 = 0;
        p  = 0;
        cuota = 0;
        npago  = 0;
                
        limpia(); // segundo limpia los controles
    }

    void limpia()
    {
        capital.setText("");
        interes.setText("");
        años.setText("");      
        alfa.setText("");
        pago.setText("");
        E_valores.setText("");
        E_msj.setText("");
        lista.clear();
        
        cuantos.setText("");
        cuantos.setVisible(false);
        E_cuantos.setVisible(false);
   }
   
    void B_ejemplo_actionPerformed(ActionEvent e) {
        capital.setText("1000000");
        interes.setText("8");
        años.setText("4");
        alfa.setText("");
        pago.setText(""); 
        tipopago=1;
        RB_anual.setSelected(true);
        RB_semestral.setSelected(false);
        RB_mensual.setSelected(false);
        RB_personal.setSelected(false);
    }   
   
    // Esta función formatea la salida de los números reales
    // para mostrarlos sólo con dos decimales
      
    double presenta(double numero)
    {
      numero = numero*100;
      numero = (int) numero;
      numero = (numero/100);
      return numero;            
    }
    
 
}