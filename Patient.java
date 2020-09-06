public  class Patient {
    private String name;
    private int age,oxygen_Level;
    private float body_Temp;
    private int unique_ID;
    private int admit_Status = 0;
    private int recovery_Time=0;
    private Institute my_Institute;

    public Patient(String name,int age, int oxygen_Level,float body_Temp) {
        this.name = name;
        this.age = age;
        this.oxygen_Level = oxygen_Level;
        this.body_Temp = body_Temp;

    }
    void setMy_Institute(Institute my_Institute){
        this.my_Institute = my_Institute;
    }
    void setAdmit_Status(int status){
        this.admit_Status = status;
    }

    String getName(){
        return name;
    }
    void setUnique_ID(int unique_ID){
        this.unique_ID = unique_ID;
    }
    void setRecovery_Time(int day){
        this.recovery_Time = day;
    }
    int getAdmit_Status(){
        return admit_Status;
    }
    int getOxygen_Level(){
        return oxygen_Level;
    }
    String getMy_Institute(){
        return my_Institute.getName();
    }
    float getBody_Temp(){
        return body_Temp;
    }
    int getUnique_ID(){
        return unique_ID;
    }
    int getRecovery_Time(){
        return recovery_Time;
    }
}