import java.util.ArrayList;
import java.util.Scanner;

public class Institute {
    String name;

    Scanner sc =new Scanner(System.in);
    float max_Temp;
    int min_Oxygen;
    String status = "OPEN";
    int available_bed;
    ArrayList<Patient>my_Patients;
    public Institute(String name, float max_Temp, int min_Oxygen,int available_bed){
        this.name = name;
        this.max_Temp = max_Temp;
        this.min_Oxygen = min_Oxygen;
        this.available_bed = available_bed;
        my_Patients = new ArrayList<>();
    }
    void setStatus(String status){
        this.status = status;
    }
    void print_PatientsName(){
        for(Patient p:my_Patients){
            System.out.println("Name:-"+p.getName());
            System.out.println("RecoveryTime:-"+p.getRecovery_Time());
        }
    }

    void setAvailable_bed(){
        available_bed--;
    }
    void setMy_Patients(Patient p){
         my_Patients.add(p);
    }
    void set_RecoveryDays(){
        for(Patient p:my_Patients){
            System.out.print("Recovery days for admitted patient ID"+p.getUnique_ID()+"-");
            int time =sc.nextInt();
            p.setRecovery_Time(time);
            System.out.println();
        }
    }
    int getTotPatientAdmitted(){
        return my_Patients.size();
    }

    int getAvailable_bed(){
        return available_bed;
    }

    int getMin_Oxygen(){
        return min_Oxygen;
    }
    float getMax_Temp(){
        return max_Temp;
    }

    String getStatus(){
        return status;
    }
    String getName(){
        return name;
    }


}
