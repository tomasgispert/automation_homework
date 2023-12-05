package com.solvd.automation_homework;

import com.solvd.enums.Month;
import com.solvd.enums.MusclePrimaryFunction;
import com.solvd.enums.PaymentMethod;
import com.solvd.enums.RPE;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.*;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GymApp {
    private static final int gymAppVersion;
    private static final Logger LOGGER;


    static {
        gymAppVersion = 2;
        System.setProperty("log4j.configurationFile","log4j2.xml");
        LOGGER = Logger.getLogger("GymApp.class");
    }

    public static void main(String[] args){
        Equipment squatBar = new Equipment(1,"Squat Bar","Generic","Bar",25,"Steel");
        Muscle quadriceps = new Muscle(1,"Quadriceps",MusclePrimaryFunction.EXTENSOR,true);
        Muscle biceps = new Muscle(1,"Biceps", MusclePrimaryFunction.FLEXOR,false);

        ArrayList<Muscle> squatMuscles = new ArrayList<>();
        squatMuscles.add(quadriceps);
        ArrayList<Equipment> squatEquipment = new ArrayList<>();
        squatEquipment.add(squatBar);

        Exercise squat = new Exercise("Squat","Strength exercise in which the trainee lowers their hips from a standing position and then stands back up",squatMuscles,squatEquipment);

        List<Exercise> powerlifting101 = new ArrayList<>();
        powerlifting101.add(squat);

        Instructor instructor = new Instructor(1,"John",new Date(1678882400000L),"john@gmail.com","powerlifting",true,powerlifting101);
        Membership standardMembership = new Membership("Standard",100,10,true,"Cash only");
        Member member = new Member(1,"Mike",new Date(1673462400000L),"mike@gmail.com","General Health",standardMembership);
        Payment mikeOctober = new Payment(new Date(1673462400000L), Month.DECEMBER.getDisplayName(),100,member,"cash");
        Workout powerliftingWorkout = new Workout(1,"Powerlifting 101",powerlifting101,4,instructor,"Squat only");
        Session mikePowerSession = new Session(new Date(1673462400000L),member,powerliftingWorkout);

        ArrayList<Person> powerliftingSeminarAttendees = new ArrayList<>();
        powerliftingSeminarAttendees.add(member);
        Seminar powerliftingSeminar = new Seminar(1,"Powerlifting 101",new Date(1687132800000L),120,instructor,powerliftingSeminarAttendees,"Introductory class to powerlifting",100);


        try{
            mikePowerSession = member.completeSession(powerliftingWorkout, RPE.RPE_10.getValue());
        } catch (InvalidIntensityException e) {
            logExceptionToFile(e);
        }

        /*try{
            mikePowerSession = member.completeSession(powerliftingWorkout,11);
        } catch (InvalidIntensityException e) {
            logExceptionToFile(e);
        }**/

        try (FileWriter fw = new FileWriter("src/main/java/com/solvd/automation_homework/logs/payments.log",true)){
            fw.write(member.makePayment(80,Month.DECEMBER.getDisplayName(), PaymentMethod.CASH).toString()+System.getProperty("line.separator"));
        } catch (InsufficientMoneyException e){
            logExceptionToFile(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        WorkoutSet firstSet = new WorkoutSet(squat.getName(), squat.getDescription(), squat.getMusclesWorked(),squat.getEquipmentRequired(),10,100,7);
        WorkoutSet secondSet = new WorkoutSet(squat.getName(), squat.getDescription(), squat.getMusclesWorked(),squat.getEquipmentRequired(),8,120,8);
        WorkoutSet thirdSet = new WorkoutSet(squat.getName(), squat.getDescription(), squat.getMusclesWorked(),squat.getEquipmentRequired(),6,140,10);

        Predicate<List<Muscle>> hasMajor = (muscles) -> {
            boolean major = false;
            for (Muscle m : muscles) if(!major) major = m.isMajorMuscle();
            return major;
        };
        LOGGER.info(String.valueOf(hasMajor.test(firstSet.getMusclesWorked())));

        Function<WorkoutSet,Double> calculateStressIndex = s ->
                s.getVolume() * s.getRpe() / 10.0 / 1000.0;
        LOGGER.info(String.valueOf(calculateStressIndex.apply(secondSet)));

        Consumer<Seminar> sendReminder = seminar -> {
            seminar.getAttendees().forEach( person -> {
                LOGGER.info("Send reminder to: "+person.getContactInfo());
            });
        };
        sendReminder.accept(powerliftingSeminar);

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

    public static int getGymAppVersion() {
        return gymAppVersion;
    }

    public static void logExceptionToFile(Exception exception) {
        Logger logger = Logger.getLogger("ExceptionLogger");

        try (CustomFileHandler fileHandler = new CustomFileHandler("src/main/java/com/solvd/automation_homework/logs/exceptions.log", true)) {
            logger.addHandler(fileHandler.getFileHandler());

            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.info("Exception occurred: " + exception.getMessage());
        }
        catch (IOException e) {
            LOGGER.info(e.toString());
        }
    }

}