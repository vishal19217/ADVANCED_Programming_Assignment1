import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AppClass {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Patient> camp;
    private ArrayList<Institute> institute;
    private ArrayList<Patient> remove_Patients;
    private ArrayList<Institute> remove_Institute;
    private int non_Admitted_Patients;
    private int current_Open_Institute;
    private int id = 1;

    AppClass(int tot) {
        this.camp = new ArrayList<>();
        reg_Patients(tot);
        this.institute = new ArrayList<>();
        this.current_Open_Institute = 0;
        this.non_Admitted_Patients = tot;
        this.remove_Institute = new ArrayList<>();
        this.remove_Patients = new ArrayList<>();
        run();

    }

    void reg_Patients(int tot) {
        for (int i = 0; i < tot; i++) {
            String name = sc.next();
            float temp = sc.nextFloat();
            int oxygen_Lev = sc.nextInt();
            int age = sc.nextInt();
            Patient new_patient = new Patient(name, age, oxygen_Lev, temp);
            new_patient.setUnique_ID(id++);
            camp.add(new_patient);
        }
    }

    void admitPatient(Institute in) {

        for (Patient p : camp) {
            if (in.getAvailable_bed() > 0) {
                if (p.getAdmit_Status() == 0 && p.getOxygen_Level() >= in.getMin_Oxygen()) {
                    p.setAdmit_Status(1);
                    p.setMy_Institute(in);
                    in.setAvailable_bed();
                    in.setMy_Patients(p);
                    non_Admitted_Patients--;
                }
            } else {
                break;
            }

        }
        for (Patient p : camp) {
            if (in.getAvailable_bed() > 0) {
                if (p.getAdmit_Status() == 0 && p.getBody_Temp() <= in.getMax_Temp()) {
                    p.setAdmit_Status(1);
                    p.setMy_Institute(in);
                    in.setAvailable_bed();
                    in.setMy_Patients(p);
                    non_Admitted_Patients--;
                }
            } else {
                break;
            }

        }
    }

    void remove_Account_Admitted() {
        System.out.println("IDS of those patients whose accounts are now removed");
        for (Patient p : camp) {
            if (p.getAdmit_Status() == 1 && (!remove_Patients.contains(p))) {
                remove_Patients.add(p);
                System.out.println(p.getUnique_ID());
            }
        }
    }

    void remove_Institute() {
        for (Institute in : institute) {
            System.out.println("Names of CLOSED Health Care Institute whose accounts are now removed");
            if (in.getStatus().equals("CLOSED") && !remove_Institute.contains(in)) {
                remove_Institute.add(in);
                System.out.println(in.getName());
            }
        }
    }

    void print_Non_Admitted_Patients() {
        System.out.println("Number of patients still in camp- "+non_Admitted_Patients);
    }

    void print_Current_Open_Institute() {
        System.out.println("Number of currently admitting healthcare Institutes- "+current_Open_Institute);
    }
    void print_Institute_Details(Institute in){
        System.out.println("Name:-"+in.getName());
        System.out.println("Temperature should be <="+in.getMax_Temp());
        System.out.println("Oxygen-Levels>="+in.getMin_Oxygen());
        System.out.println("Number of Available beds="+in.getAvailable_bed());
        System.out.println("Admission Status-"+in.getStatus());
    }
    void run() {
        while (non_Admitted_Patients!= 0) {
            int query = sc.nextInt();
            if (query == 1) {
                String name = sc.next();
                System.out.print("Temperature Criteria-");
                float temp = sc.nextFloat();
                System.out.println();
                System.out.print("Oxygen-Levels-");
                int o2level = sc.nextInt();
                System.out.println();
                System.out.print("Number of Available beds-");
                int bedNum = sc.nextInt();

                Institute in = new Institute(name, temp, o2level, bedNum);
                institute.add(in);
                print_Institute_Details(in);
                admitPatient(in);
                //for setting status of hospital
                if (in.getAvailable_bed() == 0) {
                    in.setStatus("CLOSED");
                }
                else {
                    current_Open_Institute++;
                }

                //for output showing

                in.set_RecoveryDays();
            }
            else if (query == 2) {
                remove_Account_Admitted();
            }
            else if (query == 3) {
                remove_Institute();
            }
            else if (query == 4) {

                print_Non_Admitted_Patients();
            }
            else if (query == 5) {
                print_Current_Open_Institute();
            }
            else if (query == 6) {
                String in = sc.next();
                int flag = 0;
                for (Institute institute_obj : institute) {
                    if (!remove_Institute.contains(institute_obj) && institute_obj.getName().equals(in)) {
                        print_Institute_Details(institute_obj);
                        flag = 1;
                        break;
                    }

                }
                if(flag == 0){
                    System.out.println("Institute not found");
                }

            }
        else if (query == 7) {
            int id = sc.nextInt();
            int flag = 0;
            for(Patient p : camp){
                if(p.getUnique_ID() == id && !remove_Patients.contains(p) ){

                    System.out.println("Name:-"+p.getName());
                    System.out.println("Temperature:-"+p.getBody_Temp());
                    System.out.println("Oxygen levels:-"+p.getOxygen_Level());
                    flag = 1;
                    if(p.getAdmit_Status()==1) {
                        System.out.println("Admission Status -Admitted");
                        System.out.println("Admitting Institute-"+p.getMy_Institute());
                    }
                    else
                        System.out.println("Admission Status -Not-Admitted");
                    break;
                }
            }
            if(flag == 0){
                System.out.println("ID not Found");
            }

        } else if (query == 8) {
            for(Patient p:camp){
                //System.out.println(p.getName());
                if(!remove_Patients.contains(p)){
                    System.out.print(p.getName()+" ");
                    System.out.println(p.getUnique_ID());
                }
            }
        } else {
            String in_name = sc.next();
            int flag = 0;
            for(Institute institute_obj:institute){
                if(!remove_Institute.contains(institute_obj) && institute_obj.getName().equals(in_name)){
                    flag = 1;
                    institute_obj.print_PatientsName();
                }
            }
            if(flag == 0){
                System.out.println("Institute not found");
            }
        }
    }
    }
        }


