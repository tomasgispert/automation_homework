package week2;

import java.util.ArrayList;
import java.util.Date;

public class GymApp {
    public static void main(String[] args){
        Equipment squatBar = new Equipment(1,"Squat Bar","Generic","Bar",25,"Steel");
        Muscle quadriceps = new Muscle(1,"Quadriceps","Group of four muscles in the front of the thigh responsible for knee extension and lower limb stability","Knee extension",true);

        ArrayList<Muscle> squatMuscles = new ArrayList<>();
        squatMuscles.add(quadriceps);
        ArrayList<Equipment> squatEquipment = new ArrayList<>();
        squatEquipment.add(squatBar);

        Exercise squat = new Exercise(1,"Squat","Strength exercise in which the trainee lowers their hips from a standing position and then stands back up",1,10,squatMuscles,squatEquipment);

        ArrayList<Exercise> powerlifting101 = new ArrayList<>();
        powerlifting101.add(squat);

        Instructor instructor = new Instructor(1,"john",new Date(1678882400000L),"john@gmail.com","powerlifting",true,powerlifting101);
        Membership standardMembership = new Membership(1,"Standard",100,4,true,"Cash only");
        Member member = new Member(1,"mike",new Date(1673462400000L),"mike@gmail.com","General Health",standardMembership);
        Payment mikeOctober = new Payment(1,new Date(1673462400000L),100,member,"cash","successful");
        Workout powerliftingWorkout = new Workout(1,"Powerlifting 101",powerlifting101,4,instructor,"Squat only");
        Session mikePowerSession = new Session(1,new Date(1673462400000L),member,powerliftingWorkout,true,8);

        ArrayList<Member> powerliftingSeminarMembers = new ArrayList<>();
        powerliftingSeminarMembers.add(member);
        Seminar powerliftingSeminar = new Seminar(1,"Powerlifting 101",new Date(1687132800000L),120,instructor,powerliftingSeminarMembers,"Introductory class to powerlifting");

        //printClasses(squatBar,squat,instructor,member,standardMembership,quadriceps,mikeOctober,powerliftingSeminar,mikePowerSession,powerliftingWorkout);
        printSummary(squatBar,squat,instructor,member,standardMembership,quadriceps,mikeOctober,powerliftingSeminar,mikePowerSession,powerliftingWorkout);
    }

    /*
    public static void printClasses(Equipment eq,Exercise ex,Instructor in,Member me,Membership ms,Muscle mu,Payment pa,Seminar se,Session ss,Workout wo){
        System.out.println(eq.toString());
        System.out.println(ex.toString());
        System.out.println(in.toString());
        System.out.println(me.toString());
        System.out.println(ms.toString());
        System.out.println(mu.toString());
        System.out.println(pa.toString());
        System.out.println(se.toString());
        System.out.println(ss.toString());
        System.out.println(wo.toString());
    } **/

    public static void printSummary(Equipment eq,Exercise ex,Instructor in,Member me,Membership ms,Muscle mu,Payment pa,Seminar se,Session ss,Workout wo){
        System.out.println(
                "In summary: "+me.getName().substring(0,1).toUpperCase()+me.getName().substring(1)
                        +" paid his "+ms.getType()+" Membership on "+pa.getDate()
                        +" and completed "+wo.getName()+" from instructor "
                        +in.getName().substring(0,1).toUpperCase()+in.getName().substring(1)
                        +" on the "+ss.getDate()+". He did "+ex.getName()+"s with the "+eq.getName()
                        +" which primarily work the "+mu.getName()
                        +", and his perceived effort for the session was "+ss.getSessionRPE()
                        +". He will be attending the "+se.getName()
                        +" seminar on the"+se.getDate());
    }
}
