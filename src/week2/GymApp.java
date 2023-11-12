package week2;

import java.util.ArrayList;
import java.util.Date;

public class GymApp {
    private static int gymAppVersion;

    static {
        gymAppVersion = 2;
    }
    public static int getGymAppVersion() {
        return gymAppVersion;
    }
    public static void main(String[] args){
        Equipment squatBar = new Equipment(1,"Squat Bar","Generic","Bar",25,"Steel");
        Muscle quadriceps = new Muscle(1,"Quadriceps","Group of four muscles in the front of the thigh responsible for knee extension and lower limb stability","Knee extension",true);

        ArrayList<Muscle> squatMuscles = new ArrayList<>();
        squatMuscles.add(quadriceps);
        ArrayList<Equipment> squatEquipment = new ArrayList<>();
        squatEquipment.add(squatBar);

        Exercise squat = new Exercise("Squat","Strength exercise in which the trainee lowers their hips from a standing position and then stands back up",squatMuscles,squatEquipment);

        ArrayList<Exercise> powerlifting101 = new ArrayList<>();
        powerlifting101.add(squat);

        Instructor instructor = new Instructor(1,"John",new Date(1678882400000L),"john@gmail.com","powerlifting",true,powerlifting101);
        Membership standardMembership = new Membership("Standard",100,10,true,"Cash only");
        Member member = new Member(1,"Mike",new Date(1673462400000L),"mike@gmail.com","General Health",standardMembership);
        Payment mikeOctober = new Payment(new Date(1673462400000L),100,member,"cash");
        Workout powerliftingWorkout = new Workout(1,"Powerlifting 101",powerlifting101,4,instructor,"Squat only");
        Session mikePowerSession = new Session(new Date(1673462400000L),member,powerliftingWorkout,8);

        ArrayList<Person> powerliftingSeminarAttendees = new ArrayList<>();
        powerliftingSeminarAttendees.add(member);
        Seminar powerliftingSeminar = new Seminar(1,"Powerlifting 101",new Date(1687132800000L),120,instructor,powerliftingSeminarAttendees,"Introductory class to powerlifting");

        printSummary(squatBar,squat,instructor,member,standardMembership,quadriceps,mikeOctober,powerliftingSeminar,mikePowerSession,powerliftingWorkout);
        instructor.introduceMyself();
        member.introduceMyself();
    }

    public static void printSummary(Equipment eq, Exercise ex, Instructor in, Member me, Membership ms, Muscle mu, Payment pa, Seminar se, Session ss, Workout wo){
        System.out.println(
                "In summary: "+me.getName()+" paid his "+ms.getType()
                +" Membership on "+pa.getDate()
                +" and completed "+wo.getName()+" from instructor "
                +in.getName()+" on the "+ss.getDate()
                +". He did "+ex.getName()+"s with the "+eq.getName()
                +" which primarily work the "+mu.getName()
                +", and his perceived effort for the session was "+ss.getSessionRPE()
                +". He will be attending the "+se.getName()
                +" seminar on the"+se.getDate());
    }
}
