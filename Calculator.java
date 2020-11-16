import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;


public class Calculator extends JFrame{

    private static final long serialVersionUID = 1L;
    
    private JTextField ct;
    private JButton n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,np,sum,sub,mult,div,ac,c,pr,eq,ce,in,sq,sqr,pm;
    private JPanel p1,p2,p3,p4,p5;
    int op,er=0,point=0,pmc=0;
    double a,b,r;
    public Calculator(String s) {
        super(s);
        setBounds(600,150,350,450);
        ImageIcon icon=new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());
        create_component();
        font_set();
        color_set();
        // ct.setEditable(false);

        ct.addKeyListener(new H());
        n1.addMouseListener(new H());
        n2.addMouseListener(new H());
        n3.addMouseListener(new H());
        n4.addMouseListener(new H());
        n5.addMouseListener(new H());
        n6.addMouseListener(new H());
        n7.addMouseListener(new H());
        n8.addMouseListener(new H());
        n9.addMouseListener(new H());
        n0.addMouseListener(new H());
        in.addMouseListener(new H());
        np.addMouseListener(new H());
        sq.addMouseListener(new H());
        pr.addMouseListener(new H());
        sqr.addMouseListener(new H());
        ce.addMouseListener(new H());
        c.addMouseListener(new H());
        ac.addMouseListener(new H());
        pm.addMouseListener(new H());
        sum.addMouseListener(new H());
        sub.addMouseListener(new H());
        mult.addMouseListener(new H());
        div.addMouseListener(new H());
        eq.addMouseListener(new H());
   }


    class H implements KeyListener,MouseListener{
        Color nw=new Color(153, 153, 153);


        @Override
        public void keyPressed(KeyEvent e) {
            error_hendel();

            if(point==1) {
                ct.setEditable(true);
            }
            
            if(e.getKeyChar()=='1') {n1.setBackground(nw);}

            else if(e.getKeyChar()=='2'){n2.setBackground(nw);}

            else if(e.getKeyChar()=='3'){n3.setBackground(nw);}

            else if(e.getKeyChar()=='4'){n4.setBackground(nw);}

            else if(e.getKeyChar()=='5'){n5.setBackground(nw);}

            else if(e.getKeyChar()=='6'){n6.setBackground(nw);}

            else if(e.getKeyChar()=='7'){n7.setBackground(nw);}

            else if(e.getKeyChar()=='8'){n8.setBackground(nw);}

            else if(e.getKeyChar()=='9'){n9.setBackground(nw);}

            else if(e.getKeyChar()=='0'){n0.setBackground(nw);}

            else if(e.getKeyChar()=='.'){
                np.setBackground(nw);
                if(point==0) {
                    point=1;
                }
                else {
                    ct.setEditable(false);
                }
            }

            else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){c.setBackground(nw);}

            else if(e.getKeyCode()==KeyEvent.VK_DELETE){
                ce.setBackground(nw);
                ct.setText("");
                a=0;
                b=0;
                point=0;
            }

            else if(e.getKeyCode()==KeyEvent.VK_ADD){
                sum.setBackground(nw);
                // System.out.println(e.getKeyCode()+" "+e.getKeyChar()+" "+KeyEvent.VK_ADD);
                point=0;
            }

            else if(e.getKeyCode()==KeyEvent.VK_SUBTRACT){sub.setBackground(nw);point=0;}

            else if(e.getKeyCode()==KeyEvent.VK_MULTIPLY){mult.setBackground(nw);point=0;}//|| e.getKeyCode()==KeyEvent.VK_ASTERISK

            else if(e.getKeyCode()==KeyEvent.VK_DIVIDE){div.setBackground(nw);point=0;}

            else if(e.getKeyCode()==53){pr.setBackground(nw);}

            else if(e.getKeyCode()==KeyEvent.VK_ENTER ||e.getKeyCode()==KeyEvent.VK_EQUALS){
                eq.setBackground(new Color(26, 83, 255));
                if(e.getKeyCode()==KeyEvent.VK_EQUALS) {
                    ct.setEditable(false);
                }
            }
        }

        void error_hendel() {
            if(er==1) {
                ct.setText("");
               ct.setHorizontalAlignment(JTextField.RIGHT);
               er=0;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
                
        }


        @Override
        public void keyReleased(KeyEvent e) {
        
            if(e.getKeyChar()=='1') {n1.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='2'){n2.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='3'){n3.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='4'){n4.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='5'){n5.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='6'){n6.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='7'){n7.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='8'){n8.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='9'){n9.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='0'){n0.setBackground(Color.BLACK);}

            else if(e.getKeyChar()=='.'){np.setBackground(Color.BLACK);}

            else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){c.setBackground(Color.DARK_GRAY);}

            else if(e.getKeyCode()==KeyEvent.VK_DELETE){ce.setBackground(Color.DARK_GRAY);}

            else if(e.getKeyCode()==KeyEvent.VK_ADD){
                sum.setBackground(Color.DARK_GRAY);
                op=1;
                a_set();
                
            }

            else if(e.getKeyCode()==KeyEvent.VK_SUBTRACT){
                sub.setBackground(Color.DARK_GRAY);
                op=2;
                a_set();
            }

            else if(e.getKeyCode()==KeyEvent.VK_MULTIPLY){
                mult.setBackground(Color.DARK_GRAY);
                op=3;
                a_set();
            }

            else if(e.getKeyCode()==KeyEvent.VK_DIVIDE){
                div.setBackground(Color.DARK_GRAY);
                op=4;
                a_set();
            }

            else if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_EQUALS){
                eq.setBackground(new Color(77, 121, 255));
                if(e.getKeyCode()==KeyEvent.VK_EQUALS) {
                    ct.setEditable(true);
                }
                b_set_and_result();
            }

            else if(e.getKeyCode()==53){
                pr.setBackground(Color.DARK_GRAY);

                try {
                    String str=ct.getText();
                    int l=str.length();
                    // System.out.println("l="+l);
                    // System.out.println("ct o="+ct.getText());
                    ct.setText(str.substring(0,l-1));
                    a=Double.parseDouble(ct.getText());
                    r=a/100;
                    ct.setText(String.valueOf(r));
                    // System.out.println("ct ="+ct.getText());
                    // str=ct.getText();
                    // l=str.length();
                    // System.out.println("l up="+l);
                } 
                catch (Exception e1) {
                    err_msg();
                }
            }
        }

        void a_set() {
           try {
                String st=ct.getText();
                int l=st.length();
                ct.setText(st.substring(0,l-1));
                a=Double.parseDouble(ct.getText());
                ct.setText("");
                // System.out.println(a);
                // System.out.println(ct.getText());
           } 
           catch (Exception e) {
                err_msg();
           }
        }

        void err_msg() {
            ct.setText("Syntax ERROR");
            ct.setHorizontalAlignment(JTextField.CENTER);
            er=1;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==n1) {
                n1.setBackground(nw);
            }
            else if(e.getSource()==n2){
                n2.setBackground(nw);
            }
            else if(e.getSource()==n3){
                n3.setBackground(nw);
            }
            else if(e.getSource()==n4){
                n4.setBackground(nw);
            }
            else if(e.getSource()==n5){
                n5.setBackground(nw);
            }
            else if(e.getSource()==n6){
                n6.setBackground(nw);
            }
            else if(e.getSource()==n7){
                n7.setBackground(nw);
            }
            else if(e.getSource()==n8){
                n8.setBackground(nw);
            }
            else if(e.getSource()==n9){
                n9.setBackground(nw);
            }
            else if(e.getSource()==n0){
                n0.setBackground(nw);
            }
            else if(e.getSource()==np){
                np.setBackground(nw);
            }
            else if(e.getSource()==in){
                in.setBackground(nw);
            }
            else if(e.getSource()==pr){
                pr.setBackground(nw);
            }
            else if(e.getSource()==ce){
                ce.setBackground(nw);
            }
            else if(e.getSource()==ac){
                ac.setBackground(nw);
            }
            else if(e.getSource()==c){
                c.setBackground(nw);
            }
            else if(e.getSource()==sq){
                sq.setBackground(nw);
            }
            else if(e.getSource()==sqr){
                sqr.setBackground(nw);
            }
            else if(e.getSource()==sum){
                sum.setBackground(nw);
            }
            else if(e.getSource()==pm){
                pm.setBackground(nw);
            }
            else if(e.getSource()==sub){
                sub.setBackground(nw);
            }
            else if(e.getSource()==mult){
                mult.setBackground(nw);
            }
            else if(e.getSource()==div){
                div.setBackground(nw);
            }
            else if(e.getSource()==eq){
                eq.setBackground(new Color(26, 83, 255));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // if(e.getSource()==pm){
                
            //     if(ct.getText().trim().isEmpty()) {
            //         err_msg();
            //     }
            //     else {
            //         String str=ct.getText();
            //         if(pmc==0){
            //             ct.setText("-"+str);
            //             pmc=1;
            //         }
            //         else if(pmc==1) {
            //             ct.setText(str);
            //             pmc=0;
            //         }
            //     }
            // }
        }


        @Override
        public void mouseClicked(MouseEvent e) {

            error_hendel();

            if(e.getSource()==n1) {
                ct.setText(ct.getText()+"1");
            }
            else if(e.getSource()==n2){
                ct.setText(ct.getText()+"2");
            }
            else if(e.getSource()==n3){
                ct.setText(ct.getText()+"3");
            }
            else if(e.getSource()==n4){
                ct.setText(ct.getText()+"4");
            }
            else if(e.getSource()==n5){
                ct.setText(ct.getText()+"5");
            }
            else if(e.getSource()==n6){
                ct.setText(ct.getText()+"6");
            }
            else if(e.getSource()==n7){
                ct.setText(ct.getText()+"7");
            }
            else if(e.getSource()==n8){
                ct.setText(ct.getText()+"8");
            }
            else if(e.getSource()==n9){
                ct.setText(ct.getText()+"9");
            }
            else if(e.getSource()==n0){
                ct.setText(ct.getText()+"0");
            }
            
            else if(e.getSource()==np){
                if(point==0) {
                    ct.setText(ct.getText()+".");
                    point=1;  
                }
            }
            else if(e.getSource()==pr){
                if(ct.getText().trim().isEmpty()) {
                   err_msg();
                }
                else {
                    a=Double.parseDouble(ct.getText());
                    // ct.setText(ct.getText()+"%");
                    r=a/100;
                    ct.setText(String.valueOf(r));
                }
            }
            else if(e.getSource()==ce){
                ct.setText("");
                a=0;
                b=0;
                point=0;
            }
            else if(e.getSource()==in){
                try {
                    a=Double.parseDouble(ct.getText());
                    r=1/a;
                    ct.setText(String.valueOf(r));
                } 
                catch (Exception e1) {
                    err_msg();
                }
            }
            else if(e.getSource()==sq){
                try {
                    a=Double.parseDouble(ct.getText());
                    r=a*a;
                    ct.setText(String.valueOf(r));
                } 
                catch (Exception e1) {
                    err_msg();
                }
            }
            else if(e.getSource()==sqr){
                try {
                    a=Double.parseDouble(ct.getText());
                    r=Math.sqrt(a);
                    ct.setText(String.valueOf(r));
                } 
                catch (Exception e1) {
                    err_msg();
                }
            }
            else if(e.getSource()==c){
                String subs=ct.getText();
                int l=subs.length();
                if(l>0) {
                    ct.setText(subs.substring(0,l-1));
                    // System.out.println(ct.getText());
                }
            }

            //op
            else if(e.getSource()==sum){
                mouse_a_set();
                op=1;
            }
            else if(e.getSource()==sub){
                mouse_a_set();
                op=2;
            }
            else if(e.getSource()==mult){
                mouse_a_set();
                op=3;
            }
            else if(e.getSource()==div){
                mouse_a_set();
                op=4;
            }
            else if(e.getSource()==eq) {
                b_set_and_result();
            }
        }

        void mouse_a_set(){
            try {
                a=Double.parseDouble(ct.getText());
                ct.setText("");
                point=0;
            } catch (Exception e) {
                err_msg();
            }
        }

        void b_set_and_result() {
            try {
                b=Double.parseDouble(ct.getText());
                switch (op) {
                    case 1:
                        r=a+b;
                        ct.setText(String.valueOf(r));
                        break;
                    case 2:
                        r=a-b;
                        ct.setText(String.valueOf(r));
                        break;
                    case 3:
                        r=a*b;
                        ct.setText(String.valueOf(r));
                        break;
                    case 4:
                        r=a/b;
                        ct.setText(String.valueOf(r));
                        break;
                    default:
                        break;
                }
            } 
            catch (Exception e) {
                err_msg();
            }   
        }

        @Override
        public void mouseReleased(MouseEvent e) {ct.requestFocus();}

        
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==n1) {
                n1.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n2){
                n2.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n3){
                n3.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n4){
                n4.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n5){
                n5.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n6){
                n6.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n7){
                n7.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n8){
                n8.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n9){
                n9.setBackground(Color.BLACK);
            }
            else if(e.getSource()==n0){
                n0.setBackground(Color.BLACK);
            }
            else if(e.getSource()==np){
                np.setBackground(Color.BLACK);
            }
            else if(e.getSource()==in){
                in.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==pr){
                pr.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==ce){
                ce.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==ac){
                ac.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==c){
                c.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==sq){
                sq.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==sqr){
                sqr.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==sum){
                sum.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==pm){
                pm.setBackground(Color.BLACK);
            }
            else if(e.getSource()==sub){
                sub.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==mult){
                mult.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==div){
                div.setBackground(Color.DARK_GRAY);
            }
            else if(e.getSource()==eq){
                eq.setBackground(new Color(77, 121, 255));
            }
            // ct.requestFocus();
        }
        
    }
        

    public void create_component() {
        ct=new JTextField();

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();

        // ct.setBounds(10,25,330,30);
        // p.setBounds(10,75,330,345);
        GridLayout gl1= new GridLayout(1,1);
        p1.setLayout(gl1);
        gl1.minimumLayoutSize(this);
        p2.setLayout(new GridLayout(6,4,2,2));

        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.SOUTH);
        add(p5,BorderLayout.WEST);


        p1.setPreferredSize(new Dimension(12,80));
        p3.setPreferredSize(new Dimension(10,80));
        p4.setPreferredSize(new Dimension(10,10));
        p5.setPreferredSize(new Dimension(10,80));

        p1.add(ct);



        pr=new JButton("%");
        ce=new JButton("CE");
        ac=new JButton("C");
        c=new JButton(String.valueOf(((char)187)));

        in=new JButton("1/x");
        sq=new JButton("X"+String.valueOf(((char)178))); ImageIcon root=new ImageIcon("root.jpg");
        sqr=new JButton(root);
        div=new JButton("/");

        n7=new JButton("7");
        n8=new JButton("8");
        n9=new JButton("9");
        mult=new JButton(String.valueOf(((char)42)));

        n4=new JButton("4");
        n5=new JButton("5");
        n6=new JButton("6");
        sub=new JButton("-");

        n1=new JButton("1");
        n2=new JButton("2");
        n3=new JButton("3");
        sum=new JButton("+");

        pm=new JButton(String.valueOf(((char)177)));
        n0=new JButton("0");
        np=new JButton(".");
        eq=new JButton("=");

        p2.add(pr);
        p2.add(ce);
        p2.add(ac);
        p2.add(c);
        p2.add(in);
        p2.add(sq);
        p2.add(sqr);
        p2.add(div);
        p2.add(n7);
        p2.add(n8);
        p2.add(n9);
        p2.add(mult);
        p2.add(n4);
        p2.add(n5);
        p2.add(n6);
        p2.add(sub);
        p2.add(n1);
        p2.add(n2);
        p2.add(n3);
        p2.add(sum);
        p2.add(pm);
        p2.add(n0);
        p2.add(np);
        p2.add(eq);
    }

    public void color_set(){
        ct.setBackground(Color.DARK_GRAY);
        pr.setBackground(Color.DARK_GRAY);
        ce.setBackground(Color.DARK_GRAY);
        ac.setBackground(Color.DARK_GRAY);
        c.setBackground(Color.DARK_GRAY);
        in.setBackground(Color.DARK_GRAY);
        sq.setBackground(Color.DARK_GRAY);
        sqr.setBackground(Color.DARK_GRAY);
        div.setBackground(Color.DARK_GRAY);
        n7.setBackground(Color.BLACK);
        n8.setBackground(Color.BLACK);
        n9.setBackground(Color.BLACK);
        mult.setBackground(Color.DARK_GRAY);
        n4.setBackground(Color.BLACK);
        n5.setBackground(Color.BLACK);
        n6.setBackground(Color.BLACK);
        sub.setBackground(Color.DARK_GRAY);
        n1.setBackground(Color.BLACK);
        n2.setBackground(Color.BLACK);
        n3.setBackground(Color.BLACK);
        sum.setBackground(Color.DARK_GRAY);
        pm.setBackground(Color.BLACK);
        n0.setBackground(Color.BLACK);
        np.setBackground(Color.BLACK);
        eq.setBackground(new Color(77, 121, 255));

        p1.setBackground(Color.DARK_GRAY);
        p2.setBackground(Color.DARK_GRAY);
        p3.setBackground(Color.DARK_GRAY);
        p4.setBackground(Color.DARK_GRAY);
        p5.setBackground(Color.DARK_GRAY);


        ct.setForeground(Color.WHITE);
        pr.setForeground(Color.WHITE);
        ce.setForeground(Color.WHITE);
        ac.setForeground(Color.WHITE);
        c.setForeground(Color.WHITE);
        in.setForeground(Color.WHITE);
        sq.setForeground(Color.WHITE);
        sqr.setForeground(Color.WHITE);
        div.setForeground(Color.WHITE);
        n7.setForeground(Color.WHITE);
        n8.setForeground(Color.WHITE);
        n9.setForeground(Color.WHITE);
        mult.setForeground(Color.WHITE);
        n4.setForeground(Color.WHITE);
        n5.setForeground(Color.WHITE);
        n6.setForeground(Color.WHITE);
        sub.setForeground(Color.WHITE);
        n1.setForeground(Color.WHITE);
        n2.setForeground(Color.WHITE);
        n3.setForeground(Color.WHITE);
        sum.setForeground(Color.WHITE);
        pm.setForeground(Color.WHITE);
        n0.setForeground(Color.WHITE);
        np.setForeground(Color.WHITE);
        eq.setForeground(Color.WHITE);


    }

    public void font_set() {
        Font fontt=new Font("arial",Font.BOLD,35);
        Font font=new Font("arial",Font.BOLD,25);
        ct.setFont(fontt);
        ct.setHorizontalAlignment(JTextField.RIGHT);
        pr.setFont(font);
        ce.setFont(font);
        ac.setFont(font);
        c.setFont(font);
        in.setFont(font);
        sq.setFont(font);
        sqr.setFont(font);
        div.setFont(font);
        n7.setFont(font);
        n8.setFont(font);
        n9.setFont(font);
        mult.setFont(font);
        n4.setFont(font);
        n5.setFont(font);
        n6.setFont(font);
        sub.setFont(font);
        n1.setFont(font);
        n2.setFont(font);
        n3.setFont(font);
        sum.setFont(font);
        pm.setFont(font);
        n0.setFont(font);
        np.setFont(font);
        eq.setFont(font);   
    }
    public static void main(String[] args) {
        Calculator f=new Calculator("Calculator");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}