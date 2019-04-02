package main;
import java.net.URL;
public enum Character {
    Outlander(200,250,300,100),
    Embermage(200,300,200,150),
    Berserker(300,200,250,100),
    Engineer(200,150,200,300);

    public enum Gender{
        MALE,
        FEMALE;

        @Override
        public String toString() {
            String base = super.toString().toLowerCase();
            return (base.substring(0,1).toUpperCase()+base.substring(1));
        }
    }
    private Gender gender = Character.Gender.MALE;
    private int strength;
    private int dexterity;
    private int focus;
    private int vitality;
    private URL obj;
    Character(){
        //
    }
    Character(Gender gender){
        this.setGender(gender);
    }
    Character(int strength, int dexterity,int focus, int vitality){

        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setFocus(focus);
        this.setVitality(vitality);
        updateResouce();
    }
    Character(Gender gender,int strength, int dexterity,int focus, int vitality){
        this.setGender(gender);
        this.setStrength(strength);
        this.setDexterity(dexterity);
        this.setFocus(focus);
        this.setVitality(vitality);
        updateResouce();
    }
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
        updateResouce();
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
    public  URL getResource() {
        if (obj == null)
            throw  new NullPointerException();
        return obj;
    }
    public  void setResource(String filename) {
        obj = getClass().getClassLoader().getResource(filename);
        if (obj == null)
            throw new NullPointerException("Filename not found in directory"+getClass().getClassLoader().getResource(""));
    }
    public void updateResouce(){
        if(this == Character.Outlander){
            if(getGender() == Gender.MALE)
                setResource("male_outlander.png");
            if(getGender()==Gender.FEMALE)
                setResource("female_outlander.png");
        }
        if(this == Character.Embermage){
            if(getGender() == Gender.MALE)
                setResource("male_embermage.png");
            if(getGender()==Gender.FEMALE)
                setResource("female_embermage.png");
        }
        if(this == Character.Berserker){
            if(getGender() == Gender.MALE)
                setResource("male_berserker.png");
            if(getGender()==Gender.FEMALE)
                setResource("female_berserker.png");
        }
        if(this == Character.Engineer){
            if(getGender() == Gender.MALE)
                setResource("male_engineer.png");
            if(getGender()==Gender.FEMALE)
                setResource("female_engineer.png");
        }
    }
}
