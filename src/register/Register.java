/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import jdk.nashorn.internal.runtime.JSType;


/**
 *
 * @author SENA
 */
public class Register extends JFrame{

    /**
     * @param args the command line arguments
     */
    //private ImageIcon titleIcon;
    private boolean exceptionIndicator=false;
    public Register()  {
        super("Torchlight 2 - Register - \u00a9 2016 - 311410001 - Augustine Sena,Inc");
        setIcon();
        charSelected = Character.Outlander_Male;

        //setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("src/register/background_full.jpg")));
        //setContentPane(new JLabel (/*new Color(21, 21, 21, 255)*/));
        setLayout(new FlowLayout());
            
        add(Character()/*,BorderLayout.WEST*/,SwingConstants.CENTER);
        add(UserInput()/*,SwingConstants.CENTER)*/);
        jRadOutlander.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    if( jRadMale.isSelected())
                    {
                        setCharacter(Character.Outlander_Male);
                        charSelected=Character.Outlander_Male;
                    }
                    if (jRadFemale.isSelected())
                    {
                        setCharacter(Character.Outlander_Female);
                        charSelected=Character.Outlander_Female;
                    }
                }
            }
        );
        jRadEmbermage.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    if( jRadMale.isSelected())
                    {
                        setCharacter(Character.Embermage_Male);
                        charSelected=Character.Embermage_Male;
                    }
                    if (jRadFemale.isSelected())
                    {
                        setCharacter(Character.Embermage_Female);
                        charSelected=Character.Embermage_Female;
                    }
                }
            }
        );
        jRadBerserker.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    if( jRadMale.isSelected())
                    {
                        setCharacter(Character.Berserker_Male);
                        charSelected=Character.Berserker_Male;
                    }
                    if (jRadFemale.isSelected())
                    {
                        setCharacter(Character.Berserker_Female);
                        charSelected=Character.Berserker_Female;
                    }
                }
            }
        );
        jRadEngineer.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    if( jRadMale.isSelected())
                    {
                        setCharacter(Character.Engineer_Male);
                        charSelected=Character.Engineer_Male; 
                    }
                    if (jRadFemale.isSelected())
                    {
                        setCharacter(Character.Engineer_Female);
                        charSelected=Character.Engineer_Female;
                    }
                }
            }
        );
        
        jRadMale.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    if( jRadOutlander.isSelected())
                    {
                        setCharacter(Character.Outlander_Male);
                        charSelected=Character.Outlander_Male; 
                    }
                    if (jRadEmbermage.isSelected())
                    {
                        setCharacter(Character.Embermage_Male);
                        charSelected=Character.Embermage_Male; 
                    }
                    if( jRadBerserker.isSelected())
                    {
                        setCharacter(Character.Berserker_Male);
                        charSelected=Character.Berserker_Male; 
                    }
                    if (jRadEngineer.isSelected())
                    {
                        setCharacter(Character.Engineer_Male);
                        charSelected=Character.Engineer_Male; 
                    }
                }
            }
        );
        
        jRadFemale.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    if( jRadOutlander.isSelected())
                    {
                        setCharacter(Character.Outlander_Female);
                        charSelected=Character.Outlander_Female;
                    }
                    if (jRadEmbermage.isSelected())
                    {
                        setCharacter(Character.Embermage_Female);
                        charSelected=Character.Embermage_Female;
                    }
                    if( jRadBerserker.isSelected())
                    {
                        setCharacter(Character.Berserker_Female);
                        charSelected=Character.Berserker_Female;
                    }
                    if (jRadEngineer.isSelected())
                    {
                        setCharacter(Character.Engineer_Female);
                        charSelected=Character.Engineer_Female;
                    }
                }
            }
        );
    
    }
     private void setIcon()
    {
        Image titleIcon = Toolkit.getDefaultToolkit().getImage("src/register/icon.gif");
        setIconImage(titleIcon);
    }
    private final Icon setIconDialogMessage()
    {
        final ImageIcon icon = new ImageIcon("src/register/icon.gif");
        return icon;
    }
    private String getSelectedChar_Name()
    {
        return String.format(jTFCharname.getText().substring(0,1).toUpperCase()+jTFCharname.getText().substring(1,jTFCharname.getText().length()).toLowerCase());
    }
    private String getSelectedChar_Class()
    {String SelectedChar_Class="";
        if (charSelected==Character.Outlander_Male||charSelected==Character.Outlander_Female) {
            SelectedChar_Class = "Outlander";
        }
        if (charSelected==Character.Embermage_Male||charSelected==Character.Embermage_Female) {
            SelectedChar_Class = "Embermage";
        }
        if (charSelected==Character.Berserker_Male||charSelected==Character.Berserker_Female) {
            SelectedChar_Class = "Berserker";
        }
        if (charSelected==Character.Engineer_Male||charSelected==Character.Engineer_Female) {
            SelectedChar_Class = "Engineer";
        }
     return SelectedChar_Class;
    }
    private String getSelectedChar_Sex()
    {String SelectedChar_Sex="";
        if (charSelected==Character.Outlander_Male||charSelected==Character.Embermage_Male||charSelected==Character.Berserker_Male||charSelected==Character.Engineer_Male) {
            SelectedChar_Sex = "Male";
        }
        if (charSelected==Character.Outlander_Female||charSelected==Character.Embermage_Female||charSelected==Character.Berserker_Female||charSelected==Character.Engineer_Female) {
            SelectedChar_Sex = "Female";
        }
        
     return SelectedChar_Sex;
    }
    private String getSelectedChar_Strength()
    {
        return jLStrengthI.getText();
    }
    private String getSelectedChar_Dexternity()
    {
        return jLDexterI.getText();
    }
    private String getSelectedChar_Focus()
    {
        return jLFocusI.getText();
    }
    private String getSelectedChar_Vitality()
    {
        return jLVitalI.getText();
    }
     private Color colorTransparent()
     {
              Color myColour = new Color(21, 21,21,64);
              return myColour;
     }
     private Character charSelected;
    private  enum Character
    {
        Outlander_Male,
        Outlander_Female,
        Embermage_Male,
        Embermage_Female,
        Berserker_Male,
        Berserker_Female,
        Engineer_Male,
        Engineer_Female;
    }
    private void setCharacter(/*String myChar, String mySex, */Character Selected)
    {//iconCharacter = new ImageIcon();
        if(/*myChar.equals("Outlander")&&mySex.equals("M")*/Selected == Character.Outlander_Male)
        {   charSelected=Character.Outlander_Male; 
            iconCharacter = new ImageIcon(getClass().getResource("male_outlander.png"));
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("200");
            jLDexterI.setText("250");
            jLFocusI.setText("300");
            jLVitalI.setText("100");
        }
        if(/*myChar.equals("Outlander")&&mySex.equals("F")*/Selected == Character.Outlander_Female)
        {   charSelected=Character.Outlander_Female;
            iconCharacter = new ImageIcon(getClass().getResource("female_outlander.png"));
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("200");
            jLDexterI.setText("250");
            jLFocusI.setText("300");
            jLVitalI.setText("100");
        }
        if(/*myChar.equals("Embermage")&&mySex.equals("M")*/Selected == Character.Embermage_Male)
        {   charSelected=Character.Embermage_Male;
            iconCharacter = new ImageIcon(getClass().getResource("male_embermage.png"));
            jLCharacter.removeAll();
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("200");
            jLDexterI.setText("300");
            jLFocusI.setText("200");
            jLVitalI.setText("150");
        }
        if(/*myChar.equals("Embermage")&&mySex.equals("F")*/Selected == Character.Embermage_Female)
        {   charSelected=Character.Embermage_Female;
            iconCharacter = new ImageIcon(getClass().getResource("female_embermage.png"));
            jLCharacter.removeAll();
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("200");
            jLDexterI.setText("300");
            jLFocusI.setText("200");
            jLVitalI.setText("150");
        }
        if(/*myChar.equals("Berserker")&&mySex.equals("M")*/Selected == Character.Berserker_Male)
        {   charSelected=Character.Berserker_Male;
            iconCharacter = new ImageIcon(getClass().getResource("male_berserker.png"));
            jLCharacter.removeAll();
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("300");
            jLDexterI.setText("200");
            jLFocusI.setText("250");
            jLVitalI.setText("100");
        }
        if(/*myChar.equals("Berserker")&&mySex.equals("F")*/Selected == Character.Berserker_Female)
        {   charSelected=Character.Berserker_Female;
            iconCharacter = new ImageIcon(getClass().getResource("female_berserker.png"));
            jLCharacter.removeAll();
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("300");
            jLDexterI.setText("200");
            jLFocusI.setText("250");
            jLVitalI.setText("100");
        }
        if(/*myChar.equals("Engineer")&&mySex.equals("M")*/Selected == Character.Engineer_Male)
        {   charSelected=Character.Engineer_Male;
            iconCharacter = new ImageIcon(getClass().getResource("male_engineer.png"));
            jLCharacter.removeAll();
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("200");
            jLDexterI.setText("150");
            jLFocusI.setText("200");
            jLVitalI.setText("300");
        }
        if(/*myChar.equals("Engineer")&&mySex.equals("F")*/Selected == Character.Engineer_Female)
        {   charSelected=Character.Engineer_Female;
            iconCharacter = new ImageIcon(getClass().getResource("female_engineer.png"));
            jLCharacter.removeAll();
            jLCharacter.setIcon(iconCharacter);
            jLStrengthI.setText("200");
            jLDexterI.setText("150");
            jLFocusI.setText("200");
            jLVitalI.setText("300");
        }
    }
    private JPanel UserInput()
   {//JPanel jPUserInput = new JPanel(new BorderLayout());
       JPanel jPUserInputMain = new JPanel(new GridLayout(4,1));
            jPUserInputMain.setOpaque(false);
            jPUserInputMain.setBackground(new Color(21,21,21,64));
        //JPanel jPSeparator = new JPanel();
            //jPUserInput.add(jPSeparator);

            jPUserInputMain.add(buttonGroupCharType());
            //buttonGroupCharSex().setLayout(new FlowLayout(FlowLayout.LEFT));

            jPUserInputMain.add(buttonGroupCharSex());

            //jPUserInput.add(jPSeparator);
            jPUserInputMain.add(MiniForm());
            //PUserInput.add(jPSeparator);
            jPUserInputMain.add(UserSubmit());
        /*JPanel jPUserSubmit = new JPanel();
            jPUserSubmit.setOpaque(false);
            jPUserSubmit.setBackground(colorTransparent());
            jPUserSubmit.add(UserSubmit());*/
            
        //jPUserInput.add(jPUserInputMain,BorderLayout.CENTER);
        //jPUserInput.add(jPUserSubmit,BorderLayout.SOUTH);
     //return jPUserInput;   
     return jPUserInputMain;   
    }
    private JCheckBox jCBUserAgree;
    private JButton jBSave;
    private JPanel UserSubmit()
    {JPanel jPUserSubmit = new JPanel(new GridLayout(1, 2));
     jPUserSubmit.setOpaque(false);
     jPUserSubmit.setBackground(colorTransparent());
       JPanel jPUserAgree = new JPanel();
       jPUserAgree.setOpaque(false);
       jPUserAgree.setBackground(colorTransparent());
       jPUserAgree.setLayout(new FlowLayout(FlowLayout.LEFT));
        jCBUserAgree = new JCheckBox("I Agree");
        jCBUserAgree.setBackground(colorTransparent());
        jCBUserAgree.setForeground(Color.WHITE);
        jCBUserAgree.setOpaque(false);
        jCBUserAgree.addActionListener(
        new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if (jCBUserAgree.isSelected()) {
                    jBSave.setEnabled(true);
                }else if(!jCBUserAgree.isSelected())
                    {
                        jBSave.setEnabled(false);
                    }
            }
            
        }
        );
        
        JPanel jPButtonGroup = new JPanel();
        jPButtonGroup.setOpaque(false);
        jPButtonGroup.setBackground(colorTransparent());
        jPButtonGroup.setLayout(new FlowLayout(FlowLayout.RIGHT));
            jBSave = new JButton("Save");
            jBSave.setEnabled(false);
            jBSave.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(jTFCharname.getText().equals("")&& jTFCharemail.getText().equals(""))
                    {
                      String string = String.format("Name and E-mail must not empty");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().equals(""))
                    {
                      String string = String.format("Name must not empty");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().substring(0, 1).matches("[0-9]"))
                    {
                      String string = String.format("Name cannot begin with number");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    } 
                    else if (jTFCharname.getText().contains(" "))
                    {
                      String string = String.format("Name must not contain space");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().length()>20)
                    {
                      String string = String.format("Name must least 20 characters");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else if (jTFCharemail.getText().equals(""))
                    {
                      String string = String.format("E-mail must not empty");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else if (jTFCharemail.getText().contains(" "))
                    {
                      String string = String.format("E-mail must not contain space");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else if (!jTFCharemail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
                    {
                      String string = String.format("E-mail is not valid");
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=false;
                    }
                    else
                    {
                      String  string = String.format("Congratulations Your Character Successfully Created !\n"+
                               "Name========"+": "+getSelectedChar_Name()+"\n"+
                               "Class========"+": "+getSelectedChar_Class()+"\n"+
                               "Sex========="+": "+getSelectedChar_Sex()+"\n"+
                               "Strength====="+": "+getSelectedChar_Strength()+"\n"+
                               "Dexternity===="+": "+getSelectedChar_Dexternity()+"\n"+
                               "Focus======="+": "+getSelectedChar_Focus()+"\n"+
                               "Vitality======="+": "+getSelectedChar_Vitality()

                                
                        );
                      JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                      exceptionIndicator=true;
                    }
                }
            }
        );
            JButton jBCancel = new JButton("Cancel");
            jBCancel.addActionListener(
            new ActionListener()
            {
                public void  actionPerformed(ActionEvent ae) {
                    
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    
                    int dialogResult =JOptionPane.showConfirmDialog (null, "Are you sure to cancel ?","",dialogButton,1,setIconDialogMessage());
                        if(dialogResult == JOptionPane.YES_OPTION){
                        setCharacter(Character.Outlander_Male);
                        jRadOutlander.setSelected(true);
                        jRadMale.setSelected(true);
                        jTFCharname.setText("");
                        jTFCharemail.setText("");
                        jCBUserAgree.setSelected(false);
                        jBSave.setEnabled(false);                           
                        }
                }
            }
        );
            
            jPButtonGroup.add(jBSave);
            jPButtonGroup.add(jBCancel);
            
            jPUserAgree.add(jCBUserAgree);
        
     jPUserSubmit.add(jPUserAgree);
     jPUserSubmit.add(jPButtonGroup);
     return jPUserSubmit;
    }
    private ButtonGroup bGcharacterType;
        private JRadioButton jRadOutlander;
        private JRadioButton jRadEmbermage;
        private JRadioButton jRadBerserker;
        private JRadioButton jRadEngineer;
    
    private JPanel buttonGroupCharType()
    {JPanel jPType = new JPanel(new GridLayout(2, 1,2,2));
     jPType.setOpaque(false);
     jPType.setBackground(colorTransparent());
            JPanel jPCharTypePrime= new JPanel(new GridLayout(1, 4,2,2));
            jPCharTypePrime.setOpaque(false);
            jPCharTypePrime.setBackground(colorTransparent());
            JPanel jPCharType= new JPanel(new FlowLayout(FlowLayout.LEFT));
            jPCharType.setOpaque(false);
            jPCharType.setBackground(colorTransparent());
        bGcharacterType = new ButtonGroup();
        
        JLabel jLCharType = new JLabel("================Class================"/*,SwingConstants.CENTER*/);
          jLCharType.setForeground(Color.WHITE);
          jLCharType.setOpaque(false);
          jLCharType.setFont(new Font("Arial", Font.BOLD, 18));
            jRadOutlander   = new JRadioButton("Outlander",true);
            jRadOutlander.setBackground(colorTransparent());
            jRadOutlander.setForeground(Color.WHITE);
            jRadOutlander.setOpaque(false);
            jPCharTypePrime.add(jRadOutlander);
        bGcharacterType.add(jRadOutlander);
            jRadEmbermage   = new JRadioButton("Embermage");
            jRadEmbermage.setBackground(colorTransparent());
            jRadEmbermage.setForeground(Color.WHITE);
            jRadEmbermage.setOpaque(false);
            jPCharTypePrime.add(jRadEmbermage);
        bGcharacterType.add(jRadEmbermage);
            jRadBerserker   = new JRadioButton("Berserker");
            jRadBerserker.setBackground(colorTransparent());
            jRadBerserker.setForeground(Color.WHITE);
            jRadBerserker.setOpaque(false);
            jPCharTypePrime.add(jRadBerserker);
        bGcharacterType.add(jRadBerserker);
            jRadEngineer    = new JRadioButton("Engineer");
            jRadEngineer.setBackground(colorTransparent());
            jRadEngineer.setForeground(Color.WHITE);
            jRadEngineer.setOpaque(false);
            jPCharTypePrime.add(jRadEngineer);
        bGcharacterType.add(jRadEngineer);
        jPCharType.add(jPCharTypePrime);
        jPType.add(jLCharType);
        jPType.add(jPCharType);
    return jPType;
    }

    private ButtonGroup bGcharacterSex;
        private JRadioButton jRadMale;
        private JRadioButton jRadFemale;
        
    private JPanel buttonGroupCharSex()
    {JPanel jPSex = new JPanel(new GridLayout(2,1));
    jPSex.setOpaque(false);
        JPanel jPCharSexPrime = new JPanel(new GridLayout(1,2,30,0));
        jPCharSexPrime.setOpaque(false);
        jPCharSexPrime.setForeground(Color.WHITE);
        JPanel jPCharSex = new JPanel(/*new GridLayout(1,4)*/new FlowLayout(FlowLayout.LEFT));
        jPCharSex.setOpaque(false);
        jPCharSex.setBackground(colorTransparent());
        bGcharacterSex = new ButtonGroup(/*NB_ROW*/);
        
        JLabel jLCharSex=new JLabel("================ Sex ================"/*,SwingConstants.CENTER*/);
        jLCharSex.setForeground(Color.WHITE);
         jLCharSex.setFont(new Font("Arial", Font.BOLD, 18));
           jLCharSex.setOpaque(false);
            jRadMale   = new JRadioButton("Male",true);
            jRadMale.setForeground(Color.WHITE);
            jRadMale.setOpaque(false);
            jPCharSexPrime.add(jRadMale);
        bGcharacterSex.add(jRadMale);
            jRadFemale   = new JRadioButton("Female");
            jRadFemale.setForeground(Color.WHITE);
            jRadFemale.setOpaque(false);
             jPCharSexPrime.add(jRadFemale);
        bGcharacterSex.add(jRadFemale); 
        jPCharSex.add(jPCharSexPrime);
        jPSex.add(jLCharSex);
        jPSex.add(jPCharSex);
     return jPSex;
    }
    private JLabel jLCharname;
    private JTextField jTFCharname;
    private JLabel jLCharemail ;
    private JTextField jTFCharemail;

    private JPanel MiniForm()
    {   //JPanel jPMiniForm = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel jPMiniFormPrime = new JPanel(new GridLayout(2, 1,1,1));
        jPMiniFormPrime.setOpaque(false);
        jPMiniFormPrime.setBackground(colorTransparent());
        JPanel jPCharname = new JPanel(/*new GridLayout(1, 2,10,10)*/new FlowLayout(FlowLayout.LEFT));
        jPCharname.setOpaque(false);
        jPCharname.setBackground(colorTransparent());
            //jPCharname.setLayout(new FlowLayout(FlowLayout.CENTER));
            jLCharname = new JLabel("Name    : ",SwingConstants.RIGHT);
            jLCharname.setForeground(Color.WHITE);
            jTFCharname = new JTextField(20);
            jTFCharname.setColumns(20);
            jPCharname.add(jLCharname);
            jPCharname.add(jTFCharname);
        
        JPanel jPCharemail = new JPanel(/*new GridLayout(1,2,10,10)*/new FlowLayout(FlowLayout.LEFT));
        jPCharemail.setOpaque(false);
        jPCharemail.setBackground(colorTransparent());
            //jPCharpass.setLayout(new FlowLayout(FlowLayout.CENTER));
            jLCharemail = new JLabel("E-mail   : ",SwingConstants.RIGHT);
            jLCharemail.setForeground(Color.WHITE);
            jTFCharemail = new JTextField();
            jTFCharemail.setColumns(20);
            jPCharemail.add(jLCharemail);
            jPCharemail.add(jTFCharemail);
     jPMiniFormPrime.add(jPCharname);
     jPMiniFormPrime.add(jPCharemail);
     //jPMiniForm.add(jPMiniFormPrime);
     return jPMiniFormPrime;
    }
    private JPanel Character ()
    {
        JPanel jPCharacter = new JPanel();
        jPCharacter.setOpaque(false);
        jPCharacter.setBackground(colorTransparent());
            BorderLayout bLCharacter = new BorderLayout();
            jPCharacter.add(characterChar(),bLCharacter.NORTH);
            jPCharacter.add(attributeChar(),bLCharacter.SOUTH);
        return jPCharacter;
    }
    private Icon iconCharacter;
    private JLabel jLCharacter;
    private JPanel characterChar()
    {JPanel jPCharacter = new JPanel();
     jPCharacter.setOpaque(false);
     jPCharacter.setBackground(colorTransparent());
        jLCharacter = new JLabel();
        jLCharacter.setOpaque(false);
        jLCharacter.setBackground(colorTransparent());
            iconCharacter = new ImageIcon(getClass().getResource( "male_outlander.png" ));
            
        jLCharacter.setIcon(iconCharacter);
    jPCharacter.add(jLCharacter);
    return jPCharacter;
    }
    private JPanel attributeChar()
    {JPanel jPAttribute = new JPanel(new GridLayout(4,1));
     
        jPAttribute.add(attributeStr());
        jPAttribute.add(attributeDxt());
        jPAttribute.add(attributeFcs());
        jPAttribute.add(attributeVtl());
        jPAttribute.setOpaque(false);
        jPAttribute.setBackground(colorTransparent());
    return jPAttribute;
    }
    private JLabel jLStrengthI;
    private JPanel attributeStr()
   {JPanel jPStrength = new JPanel(new GridLayout(1,2));
    jPStrength.setOpaque(false);
    jPStrength.setBackground(colorTransparent());
        JLabel liconStrength = new JLabel();
        liconStrength.setOpaque(false);
        liconStrength.setBackground(colorTransparent());
            Icon iconStrength = new ImageIcon(getClass().getResource( "attribute_strength.png" )); 
                 JPanel jPStrengthI = new JPanel(new GridLayout(2,1));
                 jPStrengthI.setOpaque(false);
                 jPStrengthI.setBackground(colorTransparent());
                     JLabel jLStrength = new JLabel ("Strength");
                     jLStrength.setForeground(Color.WHITE);
                     jLStrength.setOpaque(false);
                     jLStrength.setBackground(colorTransparent());
                        jLStrength.setFont(new Font("Arial", Font.BOLD, 12));
                         jLStrengthI = new JLabel ("200" /*, SwingConstants.CENTER*/);
                         jLStrengthI.setForeground(Color.WHITE);
                         jLStrengthI.setOpaque(false);
                         jLStrengthI.setBackground(colorTransparent());
                         jLStrengthI.setFont(new Font("Arial", Font.BOLD, 18));
                     jPStrengthI.add(jLStrength);
                 jPStrengthI.add(jLStrengthI);
            liconStrength.setIcon(iconStrength);
    jPStrength.add(liconStrength); 
    jPStrength.add(jPStrengthI);
     return jPStrength;
    }
    private JLabel jLDexterI;
    private JPanel attributeDxt()
   {JPanel jPDexter = new JPanel(new GridLayout(1,2));
    jPDexter.setOpaque(false);
    jPDexter.setBackground(colorTransparent());
        JLabel liconDexter = new JLabel();
        liconDexter.setOpaque(false);
        liconDexter.setBackground(colorTransparent());
            Icon iconDexter = new ImageIcon(getClass().getResource( "attribute_dexterity.png" ));  
                 JPanel jPDexterI = new JPanel(new GridLayout(2,1));
                 jPDexterI.setOpaque(false);
                 jPDexterI.setBackground(colorTransparent());
                     JLabel jLDexter = new JLabel ("Dexterity");
                     jLDexter.setForeground(Color.WHITE);
                     jLDexter.setOpaque(false);
                     jLDexter.setBackground(colorTransparent());
                        jLDexter.setFont(new Font("Arial", Font.BOLD, 12));
                         jLDexterI = new JLabel ("250" /*, SwingConstants.CENTER*/);
                         jLDexterI.setForeground(Color.WHITE);
                         jLDexterI.setOpaque(false);
                         jLDexterI.setBackground(colorTransparent());
                         jLDexterI.setFont(new Font("Arial", Font.BOLD, 18));
                     jPDexterI.add(jLDexter);
                 jPDexterI.add(jLDexterI);
            liconDexter.setIcon(iconDexter);
    jPDexter.add(liconDexter); 
    jPDexter.add(jPDexterI);
     return jPDexter;
    }
    private JLabel jLFocusI;
    private JPanel attributeFcs()
   {JPanel jPFocus = new JPanel(new GridLayout(1,2));
    jPFocus.setOpaque(false);
    jPFocus.setBackground(colorTransparent());
        JLabel liconFocus = new JLabel();
        liconFocus.setOpaque(false);
        liconFocus.setBackground(colorTransparent());
            Icon iconFocus = new ImageIcon(getClass().getResource( "attribute_focus.png" ));  
                 JPanel jPFocusI = new JPanel(new GridLayout(2,1));
                 jPFocusI.setOpaque(false);
                 jPFocusI.setBackground(colorTransparent());
                     JLabel jLFocus = new JLabel ("Focus");
                     jLFocus.setForeground(Color.WHITE);
                     jLFocus.setOpaque(false);
                     jLFocus.setBackground(colorTransparent());
                        jLFocus.setFont(new Font("Arial", Font.BOLD, 12));
                         jLFocusI = new JLabel ("300" /*, SwingConstants.CENTER*/);
                         jLFocusI.setForeground(Color.WHITE);
                         jLFocusI.setOpaque(false);
                         jLFocusI.setBackground(colorTransparent());
                         jLFocusI.setFont(new Font("Arial", Font.BOLD, 18));
                     jPFocusI.add(jLFocus);
                 jPFocusI.add(jLFocusI);
            liconFocus.setIcon(iconFocus);
    jPFocus.add(liconFocus); 
    jPFocus.add(jPFocusI);
     return jPFocus;
    }
    private JLabel jLVitalI;
    private JPanel attributeVtl()
   {JPanel jPVital = new JPanel(new GridLayout(1,2));
    jPVital.setOpaque(false);
    jPVital.setBackground(colorTransparent());
        JLabel liconVital = new JLabel();
        liconVital.setOpaque(false);
        liconVital.setBackground(colorTransparent());
            Icon iconVital = new ImageIcon(getClass().getResource( "attribute_vitality.png" ));  
                 JPanel jPVitalI = new JPanel(new GridLayout(2,1));
                 jPVitalI.setOpaque(false);
                 jPVitalI.setBackground(colorTransparent());
                     JLabel jLVital = new JLabel ("Vitality");
                     jLVital.setForeground(Color.WHITE);
                     jLVital.setOpaque(false);
                     jLVital.setBackground(colorTransparent());
                         jLVital.setFont(new Font("Arial", Font.BOLD, 12));
                         jLVitalI = new JLabel ("100" /*, SwingConstants.CENTER*/);
                         jLVitalI.setForeground(Color.WHITE);
                         jLVitalI.setOpaque(false);
                         jLVitalI.setBackground(colorTransparent());
                         jLVitalI.setFont(new Font("Arial", Font.BOLD, 18));
                     jPVitalI.add(jLVital);
                 jPVitalI.add(jLVitalI);
            liconVital.setIcon(iconVital);
    jPVital.add(liconVital); 
    jPVital.add(jPVitalI);
     return jPVital;
    }



    public static void main(String[] args) {
        // TODO code application logic here
        Register createNew = new Register();
        createNew .setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        createNew .setSize( 900, 450 ); // set frame size
        createNew .setVisible( true ); // display frame
        createNew.setResizable(false);
        /*  try {
    		createNew.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/register/background_full.jpg")))));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	createNew.pack();*/

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - createNew.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - createNew.getHeight()) / 2);
        createNew.setLocation(x, y);


    }

}
