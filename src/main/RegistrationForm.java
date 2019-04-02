package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Objects;
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

import static javax.imageio.ImageIO.*;

public class RegistrationForm extends JFrame {
    /**
     * @param args the command line arguments
     */
    //private ImageIcon titleIcon;
    private boolean exceptionIndicator=false;
    private Character charSelected;
    private Character.Gender charGender;
    public RegistrationForm()  {
        super("Torchlight 2 - Register - \u00a9 2016 - 2019 by Augustine Sena,Inc");
        setIcon();
        charSelected = Character.Outlander;
        setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("background_full.jpg")))));
        setLayout(new FlowLayout());
        add(Character(),SwingConstants.CENTER);
        add(UserInput());
        jRadOutlander.addActionListener(
                ae ->{
                    charGender = charSelected.getGender();
                    charSelected=Character.Outlander;
                    charSelected.setGender(charGender);
                    setCharacter(charSelected);
                }
        );
        jRadEmbermage.addActionListener(
                ae -> {
                    charGender = charSelected.getGender();
                    charSelected=Character.Embermage;
                    charSelected.setGender(charGender);
                    setCharacter(charSelected);
                }
        );
        jRadBerserker.addActionListener(
                ae -> {
                    charGender = charSelected.getGender();
                    charSelected=Character.Berserker;
                    charSelected.setGender(charGender);
                    setCharacter(charSelected);
                }
        );
        jRadEngineer.addActionListener(
                ae -> {
                    charGender = charSelected.getGender();
                    charSelected=Character.Engineer;
                    charSelected.setGender(charGender);
                    setCharacter(charSelected);
                }
        );

        jRadMale.addActionListener(
                ae -> {
                    charSelected.setGender(Character.Gender.MALE);
                    setCharacter(charSelected);
                }
        );

        jRadFemale.addActionListener(
                ae -> {
                    charSelected.setGender(Character.Gender.FEMALE);
                    setCharacter(charSelected);
                }
        );

    }
    private void setIcon()
    {
        Image titleIcon = null;
        try {
           titleIcon = read(Objects.requireNonNull(getClass().getClassLoader().getResource("icon.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIconImage(titleIcon);
    }
    private Icon setIconDialogMessage()
    {
        return new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon.gif")));
    }
    private String getSelectedChar_Name()
    {
        return jTFCharname.getText().substring(0,1).toUpperCase()+jTFCharname.getText().substring(1).toLowerCase();
    }
    private String getSelectedChar_Class()
    {
        return charSelected.toString();
    }
    private String getSelectedChar_Sex()
    {
        return  charSelected.getGender().toString();
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
        return new Color(21, 21,21,64);
    }


    private void setCharacter(Character selected)
    {
        selected.updateResouce();
        iconCharacter = new ImageIcon(selected.getResource());
        jLCharacter.setIcon(iconCharacter);
        jLStrengthI.setText(selected.getStrength()+"");
        jLDexterI.setText(selected.getDexterity()+"");
        jLFocusI.setText(selected.getFocus()+"");
        jLVitalI.setText(selected.getVitality()+"");

    }
    private JPanel UserInput()
    {//JPanel jPUserInput = new JPanel(new BorderLayout());
        JPanel jPUserInputMain = new JPanel(new GridLayout(4,1));
        jPUserInputMain.setOpaque(false);
        jPUserInputMain.setBackground(new Color(21,21,21,64));
        jPUserInputMain.add(buttonGroupCharType());
        jPUserInputMain.add(buttonGroupCharSex());
        jPUserInputMain.add(MiniForm());
        jPUserInputMain.add(UserSubmit());
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
                e -> {
                    if (jCBUserAgree.isSelected()) {
                        jBSave.setEnabled(true);
                    }else if(!jCBUserAgree.isSelected())
                    {
                        jBSave.setEnabled(false);
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
                ae -> {
                    if(jTFCharname.getText().equals("")&& jTFCharemail.getText().equals(""))
                    {
                        String string = "Name and E-mail must not empty";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().equals(""))
                    {
                        String string = "Name must not empty";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().substring(0, 1).matches("[0-9]"))
                    {
                        String string = "Name cannot begin with number";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().contains(" "))
                    {
                        String string = "Name must not contain space";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (jTFCharname.getText().length()>20)
                    {
                        String string = "Name must least 20 characters";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (jTFCharemail.getText().equals(""))
                    {
                        String string = "E-mail must not empty";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (jTFCharemail.getText().contains(" "))
                    {
                        String string = "E-mail must not contain space";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else if (!jTFCharemail.getText().matches("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
                    {
                        String string = "E-mail is not valid";
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=false;
                    }
                    else
                    {
                        String  string = "Congratulations Your Character Successfully Created !\n"+
                                "Name========"+": "+getSelectedChar_Name()+"\n"+
                                "Class========"+": "+getSelectedChar_Class()+"\n"+
                                "Sex========="+": "+getSelectedChar_Sex()+"\n"+
                                "Strength====="+": "+getSelectedChar_Strength()+"\n"+
                                "Dexternity===="+": "+getSelectedChar_Dexternity()+"\n"+
                                "Focus======="+": "+getSelectedChar_Focus()+"\n"+
                                "Vitality======="+": "+getSelectedChar_Vitality();
                        JOptionPane.showMessageDialog(null,string,"",JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                        exceptionIndicator=true;
                    }
                }
        );
        JButton jBCancel = new JButton("Cancel");
        jBCancel.addActionListener(
                ae -> {

                    int dialogButton = JOptionPane.YES_NO_OPTION;

                    int dialogResult =JOptionPane.showConfirmDialog (null, "Are you sure to cancel ?","",dialogButton, JOptionPane.INFORMATION_MESSAGE,setIconDialogMessage());
                    if(dialogResult == JOptionPane.YES_OPTION){
                        charSelected = Character.Outlander;
                        charSelected.setGender(charGender = Character.Gender.MALE);
                        setCharacter(charSelected);
                        jRadOutlander.setSelected(true);
                        jRadMale.setSelected(true);
                        jTFCharname.setText("");
                        jTFCharemail.setText("");
                        jCBUserAgree.setSelected(false);
                        jBSave.setEnabled(false);
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
        ButtonGroup bGcharacterType = new ButtonGroup();

        JLabel jLCharType = new JLabel("================Class================"/*,SwingConstants.CENTER*/);
        jLCharType.setForeground(Color.WHITE);
        jLCharType.setOpaque(false);
        jLCharType.setFont(new Font("Arial", Font.BOLD, 18));
        jRadOutlander   = new JRadioButton(Character.Outlander.toString(),true);
        jRadOutlander.setBackground(colorTransparent());
        jRadOutlander.setForeground(Color.WHITE);
        jRadOutlander.setOpaque(false);
        jPCharTypePrime.add(jRadOutlander);
        bGcharacterType.add(jRadOutlander);
        jRadEmbermage   = new JRadioButton(Character.Embermage.toString());
        jRadEmbermage.setBackground(colorTransparent());
        jRadEmbermage.setForeground(Color.WHITE);
        jRadEmbermage.setOpaque(false);
        jPCharTypePrime.add(jRadEmbermage);
        bGcharacterType.add(jRadEmbermage);
        jRadBerserker   = new JRadioButton(Character.Berserker.toString());
        jRadBerserker.setBackground(colorTransparent());
        jRadBerserker.setForeground(Color.WHITE);
        jRadBerserker.setOpaque(false);
        jPCharTypePrime.add(jRadBerserker);
        bGcharacterType.add(jRadBerserker);
        jRadEngineer    = new JRadioButton(Character.Engineer.toString());
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
        jRadMale   = new JRadioButton(Character.Gender.MALE.toString(),true);
        jRadMale.setForeground(Color.WHITE);
        jRadMale.setOpaque(false);
        jPCharSexPrime.add(jRadMale);
        bGcharacterSex.add(jRadMale);
        jRadFemale   = new JRadioButton(Character.Gender.FEMALE.toString());
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
        iconCharacter = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("male_outlander.png")));

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
        Icon iconStrength = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("attribute_strength.png")));
        JPanel jPStrengthI = new JPanel(new GridLayout(2,1));
        jPStrengthI.setOpaque(false);
        jPStrengthI.setBackground(colorTransparent());
        JLabel jLStrength = new JLabel ("Strength");
        jLStrength.setForeground(Color.WHITE);
        jLStrength.setOpaque(false);
        jLStrength.setBackground(colorTransparent());
        jLStrength.setFont(new Font("Arial", Font.BOLD, 12));
        jLStrengthI = new JLabel (charSelected.getStrength()+"");
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
        Icon iconDexter = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("attribute_dexterity.png")));
        JPanel jPDexterI = new JPanel(new GridLayout(2,1));
        jPDexterI.setOpaque(false);
        jPDexterI.setBackground(colorTransparent());
        JLabel jLDexter = new JLabel ("Dexterity");
        jLDexter.setForeground(Color.WHITE);
        jLDexter.setOpaque(false);
        jLDexter.setBackground(colorTransparent());
        jLDexter.setFont(new Font("Arial", Font.BOLD, 12));
        jLDexterI = new JLabel (charSelected.getDexterity()+"");
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
        Icon iconFocus = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("attribute_focus.png")));
        JPanel jPFocusI = new JPanel(new GridLayout(2,1));
        jPFocusI.setOpaque(false);
        jPFocusI.setBackground(colorTransparent());
        JLabel jLFocus = new JLabel ("Focus");
        jLFocus.setForeground(Color.WHITE);
        jLFocus.setOpaque(false);
        jLFocus.setBackground(colorTransparent());
        jLFocus.setFont(new Font("Arial", Font.BOLD, 12));
        jLFocusI = new JLabel (charSelected.getFocus()+"");
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
        Icon iconVital = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("attribute_vitality.png")));
        JPanel jPVitalI = new JPanel(new GridLayout(2,1));
        jPVitalI.setOpaque(false);
        jPVitalI.setBackground(colorTransparent());
        JLabel jLVital = new JLabel ("Vitality");
        jLVital.setForeground(Color.WHITE);
        jLVital.setOpaque(false);
        jLVital.setBackground(colorTransparent());
        jLVital.setFont(new Font("Arial", Font.BOLD, 12));
        jLVitalI = new JLabel (charSelected.getVitality()+"");
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
}
